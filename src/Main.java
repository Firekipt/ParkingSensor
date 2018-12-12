import java.util.ArrayList;

import Adapter.*;
import Filter.Filter;
import Server.Server;

public class Main {
	private static Simulator simulator = new Simulator();
	//private static ArrayList<Adapter> allAdapter = new ArrayList<>();
	private static Adapter adapter1;
	private static Adapter adapter2;
	private static Adapter adapter3;
	private static Thread threadAdapter1;
	private static Thread threadAdapter2;
	private static Thread threadAdapter3;
	private static Server server = new Server();

	private static Filter filterType1 = new Filter(false, false);
	private static Filter filterType2 = new Filter(true, false);
	private static Filter filterType3 = new Filter(true, true);

	public static void main(String[] args) {
		System.out.println("Démarrage du serveur");
		Thread threadServer = new Thread(server);
		threadServer.start();

		System.out.println("Début de la lecture des descriptions");
		while (!simulator.start()) {

		};

		System.out.println("Création et démarrage des adaptateurs");
		//System.out.println("Adapter 1 : " + simulator.getAllSid().get(0) + simulator.getAllFreq().get(0) + simulator.getAllLnk().get(0));
		adapter1 = new Adapter(simulator.getAllSid().get(0), simulator.getAllFreq().get(0), simulator.getAllLnk().get(0), filterType1, server);
		threadAdapter1 = new Thread(adapter1);
		threadAdapter1.start();

		//System.out.println("Adapter 2 : " + simulator.getAllSid().get(1) + simulator.getAllFreq().get(1) + simulator.getAllLnk().get(1));
		adapter2 = new Adapter(simulator.getAllSid().get(1), simulator.getAllFreq().get(1), simulator.getAllLnk().get(1), filterType2, server);
		threadAdapter2 = new Thread(adapter2);
		threadAdapter2.start();

		//System.out.println("Adapter 3 : " + simulator.getAllSid().get(2) + simulator.getAllFreq().get(2) + simulator.getAllLnk().get(2));
		adapter3 = new Adapter(simulator.getAllSid().get(2), simulator.getAllFreq().get(2), simulator.getAllLnk().get(2), filterType3, server);
		threadAdapter3 = new Thread(adapter3);
		threadAdapter3.start();
    }
}
