package uk.org.lidalia.serialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

public class Serialized {

    public static <T> T deserialize(Serialized serialized, Class<T> type) {
        if (serialized instanceof SerializedString) {
            Member builder = findStringBuilder(type);
        } else if (serialized instanceof SerializedObject) {
            SerializedObject serializedObject = (SerializedObject) serialized;
//            if (Map.class.isAssignableFrom(type) && type.getTypeParameters()[0].) {
//
//            }
            Set<String> keys = serializedObject.keySet();
            Member builder = findBuilder(keys, type);
            List<String> parameterNames = getParameterNames(builder);
            if (builder instanceof Constructor) {
                Constructor<T> constructor = (Constructor<T>) builder;
                Type[] genericParameterTypes = constructor.getGenericParameterTypes();
                for (Type type2 : genericParameterTypes) {
                    System.out.println(type2);
                }
            }
            System.out.println(builder);
        }
        return null;
    }

    private static LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    private static Member findStringBuilder(final Class<?> type) {
        Collection<Constructor<?>> constructors = Collections2.filter(Arrays.asList(type.getConstructors()), new Predicate<Constructor<?>>() {
            public boolean apply(Constructor<?> input) {
                return input.getParameterTypes().length == 1 && input.getParameterTypes()[0] == String.class;
            }
        });
        Collection<Method> factories = Collections2.filter(Arrays.asList(type.getMethods()), new Predicate<Method>() {
            public boolean apply(Method input) {
                return type.isAssignableFrom(input.getReturnType()) && Modifier.isStatic(input.getModifiers()) && input.getParameterTypes().length == 1 && input.getParameterTypes()[0] == String.class;
            }
        });
        Collection<Member> builders = new ArrayList<Member>();
        builders.addAll(constructors);
        builders.addAll(factories);

        return builders.iterator().next();
    }

    private static Member findBuilder(Set<String> keys, final Class<?> type) {
        Collection<Constructor<?>> constructors = Arrays.asList(type.getConstructors());
        Collection<Method> factories = Collections2.filter(Arrays.asList(type.getMethods()), new Predicate<Method>() {
            public boolean apply(Method method) {
                return type.isAssignableFrom(method.getReturnType()) && Modifier.isStatic(method.getModifiers());
            }
        });

        Collection<Member> builders = new ArrayList<Member>();
        builders.addAll(constructors);
        builders.addAll(factories);

        int highestNamesMatched = 0;
        Member bestBuilder = null;
        for (Member builder : builders) {
            List<String> parameterNames = getParameterNames(builder);
            int namesMatched = Sets.intersection(new HashSet<String>(keys), new HashSet<String>(parameterNames)).size();
            if (namesMatched > highestNamesMatched) {
                highestNamesMatched = namesMatched;
                bestBuilder = builder;
            }
        }
        return bestBuilder;
    }

    private static List<String> getParameterNames(Member member) {
        if (member instanceof Constructor<?>) {
            return Arrays.asList(discoverer.getParameterNames((Constructor<?>)member));
        } else if (member instanceof Method) {
            return Arrays.asList(discoverer.getParameterNames((Method)member));
        } else {
            throw new IllegalArgumentException("Can't handle fields or null");
        }
    }

    Serialized(){}

    public static void main(String[] args) {
        SerializedObject test = new SerializedObject();
        test.put("something", new SerializedObject());

        deserialize(test, Test.class);
    }

    public static enum TestEnum {
        ONE, TWO
    }

}
