import java.util.ArrayList;
import java.util.Random;

public class Productor extends Thread {
	private final Random random;
	private final Contenedor container;
	private final int id;
	private final int TIME_TO_WAIT = 1500;
	private boolean finished;
	private ArrayList<Consumidor> consumidores;
	
	public Productor(Contenedor container, int id, ArrayList<Consumidor> consumidores) {
		this.container = container;
		this.id = id;
		random = new Random();
		this.consumidores = consumidores;
		this.finished = false;
	}
	
	public Random getRandom() {
		return random;
	}

	public Contenedor getContainer() {
		return container;
	}

	public int getIdentificador() {
		return id;
	}
	
	public void setFinished( boolean fin) {
		this.finished = fin;
	}
	
	public boolean isFinished() {
		return this.finished;
	}

	@Override
	public void run() {
		System.out.println("Starting producer...");
		while(!isFinished()) {
			int add = random.nextInt(5);
			System.out.println("El productor " + getIdentificador() + " pone " + add);
			container.addContent(add);
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				System.err.println("Error in producer " + e.getMessage());
			}
		}
		System.out.println("Ending producer...");
		for(Consumidor consumidor: consumidores) {
			consumidor.setFinished(true);
			consumidor.notify();
		}
	}
}
