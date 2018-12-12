package Filter;

public class Filter {

	private F1 filtre1 = new F1();
	private F2 filtre2 = new F2();

	private boolean f1;
	private boolean f2;

	private String dataFiltered;

	public Filter(boolean f1, boolean f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	public String filter(String value) {
		this.dataFiltered = value;

		if (this.f1) {
			this.dataFiltered = this.filtre1.filter(this.dataFiltered);
			//System.out.println("Filtre 1 effectué");
		} else {
			//System.out.println("Filtre 1 non effectué");
		}

		if (this.f2) {
			this.dataFiltered = this.filtre2.filter(this.dataFiltered);
			//System.out.println("Filtre 2 effectué");
		} else {
			//System.out.println("Filtre 2 non effectué");
		}

		return this.dataFiltered;
	}
}
