package Server;

public class Server implements Runnable {
	private String dataSns1;
	private String dataSns2;
	private String dataSns3;

	public Server() {

	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Données reçues sur le serveur");
			System.out.println("Donnée 1 : " + this.dataSns1);
			System.out.println("Donnée 2 : " + this.dataSns2);
			System.out.println("Donnée 3 : " + this.dataSns3);
		}
	}

	public void setDataSns1(String data) {
		this.dataSns1 = data;
		System.out.println("Donnée 1 modifiée");
	}

	public void setDataSns2(String data) {
		this.dataSns2 = data;
		System.out.println("Donnée 2 modifiée");
	}

	public void setDataSns3(String data) {
		this.dataSns3 = data;
		System.out.println("Donnée 3 modifiée");
	}
}
