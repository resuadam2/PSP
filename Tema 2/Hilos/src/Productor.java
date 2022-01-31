import java.util.Random;

public class Productor implements Runnable {
	private final Random random;
	private final Contenedor container;
	private final int id;
	private final int TIME_TO_WAIT = 1500;
	private static Thread[] consumidores;

	
	public Productor(Contenedor container, int id, Thread[] consumidores) {
		this.container = container;
		this.id = id;
		random = new Random();
		this.consumidores = consumidores;
	}
	
	public boolean consumidoresAlive() {
		for(Thread c: consumidores) {
			if(!c.isAlive()) return false; 
		}
		return true;
	}

	@Override
	public void run() {
		System.out.println("Starting producer...");
		while(consumidoresAlive()) {
			int add = random.nextInt(5);
			System.out.println("El productor " + id + " pone " + add);
			container.put(add);
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				System.err.println("Error in producer " + e.getMessage());
			}
		}
	}
}
