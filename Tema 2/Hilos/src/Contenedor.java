
public class Contenedor {
	private int cont;
	private boolean full;
	private final int CONTAINER_SIZE = 1;
	
	public Contenedor() {
		this.cont = 0;
		this.full = false;
	}
	
	public Contenedor(int cont, boolean full) {
		this.cont = cont;
		this.full = full;
	}
	
	public void setFull(boolean full) {
		this.full = full;
	}
	
	public boolean isFull() {
		return this.full;
	}
	
	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}


	public synchronized int getContent() {
		while(!isFull()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Container error: " + e.getMessage());
			}
		}
		setFull(false);
		notifyAll();
		return getCont();
	}
	
	public synchronized void addContent(int value) {
		if(value > CONTAINER_SIZE) value = CONTAINER_SIZE;
		while(isFull()) {
			try {
				wait();
			} catch(InterruptedException e) {
				System.err.println("Error while adding content to the container: " + e.getMessage());
			}
		}
		setCont(value);
		if(getCont() == CONTAINER_SIZE) {
			setFull(true);
		}
		notifyAll();
	}
}
