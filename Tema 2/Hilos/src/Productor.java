import java.util.Random;

public class Productor extends Thread {
	private final Random random;
	private final Contenedor container;
	private final int id;
	private final int TIME_TO_WAIT = 1500;
	private boolean finished = false;
	
	public Productor(Contenedor container, int id) {
		this.container = container;
		this.id = id;
		random = new Random();
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
	
	public void isFinished( boolean fin) {
		this.finished = fin;
	}

	@Override
	public void run() {
		while(true) {
			if(finished) break;
			int add = random.nextInt(5);
			System.out.println("El productor " + getIdentificador() + " pone " + add);
			container.addContent(add);
			try {
				Thread.sleep(TIME_TO_WAIT);
			} catch (InterruptedException e) {
				System.err.println("Error in producer " + e.getMessage());
			}
		}
	}
}
