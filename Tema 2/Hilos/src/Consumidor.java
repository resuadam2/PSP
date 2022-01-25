
public class Consumidor extends Thread {
	private final Contenedor container;
	private final int id;
	private boolean finished;
	
	public Consumidor(Contenedor container, int id) {
		this.container = container;
		this.id = id;
		this.finished = false;
	}

	public Contenedor getContainer() {
		return container;
	}

	public int getIdentificador() {
		return id;
	}
	
	public void setFinished(boolean fin) {
		this.finished = fin;
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	@Override
	public void run() {
		System.out.println("Starting consumidor " + getIdentificador());
		while(!isFinished()) {
			System.out.println("Consumidor " + getIdentificador() + " "
					+ "consumiendo " + container.getContent());
		}
		System.out.println("Ending consumidor " + getIdentificador());
	}
}
