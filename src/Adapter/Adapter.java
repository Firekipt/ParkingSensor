package Adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Adapter implements Runnable{

	private String sid;
	private String lnk;
	private int freq;
	private String snsValue;

	public Adapter(String sid, String freq, String lnk) {
		this.sid = sid;
		this.freq = Integer.parseInt(freq);
		this.lnk = lnk;
	}

	@Override
	public void run() {
		while(true) {
			File file = new File(lnk);

			BufferedReader br = null;

			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}

			try {
				while ((snsValue = br.readLine()) != null) {
					System.out.println("Valeur du capteur " + sid + " = " + snsValue);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				Thread.sleep(freq);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String getSnsValue() {
		return this.snsValue;
	}
}
