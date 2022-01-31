
public class Consumidor extends Thread {
	private final Contenedor container;
	private final int id;
	private int accesos = 5;
	
	public Consumidor(Contenedor container, int id) {
		this.container = container;
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Starting consumidor " + id);
		while(accesos > 0) {
			System.out.println("Consumidor " + id + " "
					+ "consumiendo " + container.get());
			accesos--;
		}
	}
}
