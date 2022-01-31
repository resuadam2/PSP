
public class Consumidor extends Thread {
	private final Contenedor container;
	private final int id;
	private static final int MAX_ACCESOS = 5;
	static int accesos = MAX_ACCESOS;
	
	public Consumidor(Contenedor container, int id) {
		this.container = container;
		this.id = id;
	}
	
	public static void resetAccesos() {
		accesos = MAX_ACCESOS;
	}
	
	@Override
	public void run() {
		System.out.println("Starting consumidor " + id);
		while(accesos > 0) {
			System.out.println("Quedan " + accesos + " accesos.");
			int consumido = container.get();
			if(accesos <= 0) break;
			System.out.println("Consumidor " + id + " "
					+ "consumiendo " + consumido);
			accesos--;
		}
		System.out.println("Ending consumidor " + id);
	}
}
