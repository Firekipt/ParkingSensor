package Filter;

public class F2 {

	private String previousValue = null;

	public F2() {

	}

	public String filter(String value) {
		if (previousValue == null) {
			previousValue = value;
			//System.out.println("Filtre 2 : Donn�e transf�r�e");
			return value;
		} else {
			if (previousValue == value) {
				//System.out.println("Filtre 2 : Donn�e non transf�r�e");
				return null;
			} else {
				previousValue = value;
				//System.out.println("Filtre 2 : Donn�e transf�r�e");
				return value;
			}
		}
	}
}
