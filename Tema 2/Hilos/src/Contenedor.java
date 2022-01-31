public class Contenedor {
	private int cont;
	private boolean full = false;

	public synchronized int get() {
		while (!full) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Container error: " + e.getMessage());
			}
		}
		full = false;
		notify();
		return cont;
	}

	public synchronized void put(int value) {
		while (full) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Error while adding content to the container: " + e.getMessage());
			}
		}
		cont = value;
		full = true;
		notify();
	}
}
