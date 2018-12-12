package Adapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {

	private String path = "src/SnsDesc";
	private File snsDescDir = new File(path);
	private File[] allSnsDesc = snsDescDir.listFiles();
	private ArrayList<String> nameFile = new ArrayList<>();

	private static ArrayList<String> sid = new ArrayList<>();
	private static ArrayList<String> freq = new ArrayList<>();
	private static ArrayList<String> lnk = new ArrayList<>();

	private boolean allRead = false;

	public Simulator() {

	}

	public boolean start() {
		while(!allRead) {
			for(File file : allSnsDesc)
			{
				if (!nameFile.contains(file.getName())) {
					nameFile.add(file.getName());

					BufferedReader br = null;

					try {
						br = new BufferedReader(new FileReader(file));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}

					String[] data;
					try {
						for (int i = 0; i < 3; i++) {
							data = br.readLine().split(" ");
							if (i == 0) {
								sid.add(data[1]);
								//System.out.println("SID lu : " + data[1]);
							} else if (i == 1) {
								freq.add(data[1]);
								//System.out.println("FREQ lu : " + data[1]);
							} else {
								lnk.add(data[1]);
								//System.out.println("LNK lu : " + data[1]);
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}

			if (allSnsDesc.length == nameFile.size()) {
				allRead = true;
				System.out.println("Lecture de tous les fichiers effectuée");
			}

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

	public ArrayList<String> getAllSid() {
		return sid;
	}

	public ArrayList<String> getAllFreq() {
		return freq;
	}

	public ArrayList<String> getAllLnk() {
		return lnk;
	}
}
