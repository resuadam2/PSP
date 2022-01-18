
public class Tarea extends Thread{
	
	public Tarea() {
		setName("Tarea por defecto");
	}
	
	public Tarea(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) 
			System.out.println("I am the Thread " + getName() + " and i am in the iteration number: " + i);
	}
}
