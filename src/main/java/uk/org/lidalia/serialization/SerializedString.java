package uk.org.lidalia.serialization;

import uk.org.lidalia.lang.Identity;

import static com.google.common.base.Preconditions.checkNotNull;

public class SerializedString extends Serialized {

    @Identity protected final String string;

    public SerializedString(String string) {
        this.string = checkNotNull(string);
    }

    @Override
    public String toString() {
        return string;
    }
}
