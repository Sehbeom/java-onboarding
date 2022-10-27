package onboarding.problem4;

public class WordConverter {
	public static final int ASCII_OF_LOWERCASE_A = 97;
	public static final int ASCII_OF_LOWERCASE_Z = 122;
	public static final int ASCII_OF_UPPERCASE_A = 65;
	public static final int ASCII_OF_UPPERCASE_Z = 90;

	private enum CharacterCategory {
		LOWERCASE, UPPERCASE, NOT_ALPHABET
	}

	public static CharacterCategory checkCharacterCategory(char oneCharacter) {
		if (ASCII_OF_LOWERCASE_A <= oneCharacter && oneCharacter <= ASCII_OF_LOWERCASE_Z) {
			return CharacterCategory.LOWERCASE;
		} else if (ASCII_OF_UPPERCASE_A <= oneCharacter && oneCharacter <= ASCII_OF_UPPERCASE_Z) {
			return CharacterCategory.UPPERCASE;
		} else {
			return CharacterCategory.NOT_ALPHABET;
		}
	}

	public static char convertLowerCharacter(char lowercaseCharacter) {
		int convertedCharacter = lowercaseCharacter;

		convertedCharacter = convertedCharacter + ((109 - convertedCharacter)*2 + 1);

		return (char)convertedCharacter;
	}

	public static char convertUpperCharacter(char uppercaseCharacter) {
		int convertedCharacter = uppercaseCharacter;

		convertedCharacter = convertedCharacter + ((77 - convertedCharacter)*2 + 1);

		return (char)convertedCharacter;
	}
}
