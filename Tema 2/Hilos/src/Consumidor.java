
public class Consumidor extends Thread {
	private final Contenedor container;
	private final int id;
	private boolean finished = false;
	
	public Consumidor(Contenedor container, int id) {
		this.container = container;
		this.id = id;
	}

	public Contenedor getContainer() {
		return container;
	}

	public int getIdentificador() {
		return id;
	}
	
	public void isFinished(boolean fin) {
		this.finished = fin;
	}
	
	@Override
	public void run() {
		while(true) {
			if(finished) break;
			System.out.println("Consumidor " + getIdentificador() + " consumiendo " + container.getContent());
		}
	}
}
