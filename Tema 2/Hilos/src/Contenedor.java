public class Contenedor {
	private int cont;
	private boolean full = false;
	private static final int BUFFER_SIZE = 1;

	public synchronized int get() {
		while (!full && Consumidor.accesos > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Container error: " + e.getMessage());
			}
		}
		full = false;
		notifyAll();
		return cont;
	}

	public synchronized void put(int value) {
		if(value > BUFFER_SIZE) value = BUFFER_SIZE;
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
