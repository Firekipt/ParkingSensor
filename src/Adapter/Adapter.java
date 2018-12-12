package Adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Filter.Filter;
import Server.Server;

public class Adapter implements Runnable{

	private String sid;
	private String lnk;
	private int freq;
	private String snsValue;
	private String dataToSend;

	private Filter filter;
	private Server server;

	public Adapter(String sid, String freq, String lnk, Filter filter, Server server) {
		this.sid = sid;
		this.freq = Integer.parseInt(freq);
		this.lnk = lnk;
		this.filter = filter;
		this.server = server;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(freq);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			File file = new File(lnk);

			BufferedReader br = null;

			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}

			try {
				snsValue = br.readLine();
				System.out.println("Valeur du capteur " + this.sid + " = " + snsValue);
				dataToSend = this.filter.filter(snsValue);
				if (dataToSend != null) {
					System.out.println("Donnée du capteur " + this.sid + " envoyée");
					send(this.server, this.sid);
				} else {
					System.out.println("Donnée du capteur " + this.sid + " non envoyée car aucun changement");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void send(Server server, String sid) {
		if (sid.equals("1")) {
			this.server.setDataSns1(dataToSend);
		} else if (sid.equals("2")) {
			this.server.setDataSns2(dataToSend);
		} else {
			this.server.setDataSns3(dataToSend);
		}
	}
}
