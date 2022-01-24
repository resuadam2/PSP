
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
	
	public void setRef(TareaLenta ref) {
		this.ref = ref;
	}
	
	@Override
	public void run() {
		if(ref != null) {
			while(ref.isAlive()) System.out.println("loading... i am waiting for " + ref.getName());
			try {
				ref.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.err.println("Ref is null, please initialize it." + e.getMessage());
			}
		} else {
			System.err.println("Ref is null, please initialize it.");
		}
	}
}
