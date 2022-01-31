
public class Counter {
	private int cont;
	
	public Counter() {
		this.cont = 0;
	}
	
	public synchronized int getCont() {
		return this.cont;
	}
	
	public synchronized void increment() {
		this.cont++;
	}
}
