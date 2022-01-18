
public class Loading extends Thread {
	
	private TareaLenta ref;
		
	public Loading() {
		setName("Tarea por defecto");
	}
	
	public Loading(String name) {
		setName(name);
	}
	
	public Loading(String name, TareaLenta ref) {
		setName(name);
		this.ref = ref;
	}
	
	@Override
	public void run() {
		while(ref.isAlive()) System.out.println("loading... i am waiting for " + ref.getName());
		try {
			ref.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
