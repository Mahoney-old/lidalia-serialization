package uk.org.lidalia.serialization;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SerializedObject extends Serialized implements Map<String, Serialized> {
	
	private final Map<String, Serialized> data = new HashMap<String, Serialized>();

	public void clear() {
		data.clear();
	}

	public boolean containsKey(Object key) {
		return data.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return data.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, Serialized>> entrySet() {
		return data.entrySet();
	}

	public boolean equals(Object o) {
		return data.equals(o);
	}

	public Serialized get(Object key) {
		return data.get(key);
	}

	public int hashCode() {
		return data.hashCode();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public Set<String> keySet() {
		return data.keySet();
	}

	public Serialized put(String key, Serialized value) {
		return data.put(key, value);
	}

	public void putAll(Map<? extends String, ? extends Serialized> m) {
		data.putAll(m);
	}

	public Serialized remove(Object key) {
		return data.remove(key);
	}

	public int size() {
		return data.size();
	}

	public Collection<Serialized> values() {
		return data.values();
	}

}
