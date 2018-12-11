import Adapter.*;

public class Main {
	private static Simulator simulator = new Simulator();

	public static void main(String[] args) {
		Thread threadSimulator = new Thread(simulator);
		threadSimulator.start();
    }
}
