
public class TareaLenta extends Thread {
	public TareaLenta() {
		setName("Tarea por defecto");
	}
	
	public TareaLenta(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		System.out.println("I am the  Slowly Thread " + getName() + " starting...");
		for(int i = 0; i < 10; i++) {
			try {
				TareaLenta.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("I am the  Slowly Thread " + getName() + " finished.");
	}
}
