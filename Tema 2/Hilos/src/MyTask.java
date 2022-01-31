import java.util.Random;

public class MyTask extends Thread{
	private Counter counter;
	
	public MyTask(Counter counter) {
		this.counter = counter;
		
	}
	
	@Override
	public void run() {
		Random r = new Random();
		try {
			sleep(r.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.counter.increment();
		System.out.println("I am the task " + getId() + " and the value of the counter is " + counter.getCont());
	}
}
