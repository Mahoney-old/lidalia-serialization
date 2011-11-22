package uk.org.lidalia.serialization;

import org.apache.commons.lang.Validate;

import uk.org.lidalia.lang.Identity;

public class SerializedString extends Serialized {
	
	@Identity protected final String string;

	public SerializedString(String string) {
		Validate.notNull(string);
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}
}
