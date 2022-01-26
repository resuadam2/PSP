
public class Contenedor {
	private int cont;
	private boolean full;
	private final int CONTAINER_SIZE = 1;
	private int iterations;
	
	public Contenedor() {
		this.cont = 0;
		this.full = false;
		this.iterations = 0;
	}
	
	public Contenedor(int cont, boolean full) {
		this.cont = cont;
		this.full = full;
		this.iterations = 0;
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
	
	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	public void endIterations() {
		synchronized (this){
			notifyAll();
		}
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
		this.iterations++;
		notifyAll();
		return getCont();
	}
	
	public synchronized void addContent(int value) {
		if(value + getCont() > CONTAINER_SIZE) value = CONTAINER_SIZE;
		while(isFull()) {
			try {
				wait();
			} catch(InterruptedException e) {
				System.err.println("Error while adding content to the container: " + e.getMessage());
			}
		}
		setCont(value + getCont());
		if(getCont() == CONTAINER_SIZE) {
			setFull(true);
		}
		notifyAll();
	}
}
