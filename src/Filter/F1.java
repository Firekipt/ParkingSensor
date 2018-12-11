package Filter;

public class F1 {

	public F1() {

	}

	public String filter(int input) {
		if (input == 1) {
			System.out.println("Filtre 1 : Disponible");
			return "D";
		} else {
			System.out.println("Filtre 1 : Non disponible");
			return "N";
		}
	}
}
