package Filter;

public class F2 {

	private String previousInput = null;

	public F2() {

	}

	public String filter(String input) {
		if (previousInput == null) {
			previousInput = input;
			System.out.println("Filtre 2 : Donn�e transf�r�e");
			return input;
		} else {
			if (previousInput == input) {
				System.out.println("Filtre 2 : Donn�e non transf�r�e");
				return null;
			} else {
				System.out.println("Filtre 2 : Donn�e transf�r�e");
				return input;
			}
		}
	}
}
