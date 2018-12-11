package Filter;

public class F2 {

	private String previousInput = null;

	public F2() {

	}

	public String filter(String input) {
		if (previousInput == null) {
			previousInput = input;
			System.out.println("Filtre 2 : Donnée transférée");
			return input;
		} else {
			if (previousInput == input) {
				System.out.println("Filtre 2 : Donnée non transférée");
				return null;
			} else {
				System.out.println("Filtre 2 : Donnée transférée");
				return input;
			}
		}
	}
}
