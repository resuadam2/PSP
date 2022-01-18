
public class Main {
	
	public static final int NUM_HILOS = 10;
	
	public static void ejercicio1() {
		Tarea t1 = new Tarea();
		t1.start();
	}
	
	public static void ejercicio2() {
		for(int i = 0; i < NUM_HILOS; i++) {
			Tarea t1 = new Tarea("Tarea " + i);
			t1.start();
		}
	}
	
	public static void ejercicio3() throws InterruptedException {
		for(int i = 0; i < NUM_HILOS; i++) {
			Tarea t1 = new Tarea("Tarea " + i);
			t1.start();
			t1.join();
		}
	}
	
	public static void ejercicio4() {
		for(int i = 0; i < NUM_HILOS; i++) {
			if(i%2 == 0) {
				Tarea t1 = new Tarea("Tarea " + i);
				t1.start();
			} else {
				TareaLenta t1 = new TareaLenta("Tarea lenta" + i);
				t1.start();
			}
		}
	}
	
	public static void ejercicio5() {
		TareaLenta t1 = new TareaLenta("Tarea lenta");
		Loading l1 = new Loading("Loader",t1);
		t1.start();
		l1.start();
	}
	
	public static void main(String [] args) {
		try {
			System.out.println("Inicio ejercicio 1. ");
			ejercicio1();
			Thread.sleep(3000);
			System.out.println("Fin ejercicio 1.");
			System.out.println("Inicio ejercicio 2. ");
			ejercicio2();
			Thread.sleep(3000);
			System.out.println("Fin ejercicio 2.");	
			System.out.println("Inicio ejercicio 3. ");
			ejercicio3();
			Thread.sleep(3000);
			System.out.println("Fin ejercicio 3.");	
			System.out.println("Inicio ejercicio 4. ");
			ejercicio4();
			Thread.sleep(3000);
			System.out.println("Fin ejercicio 4.");	
			System.out.println("Inicio ejercicio 5. ");
			ejercicio5();
			Thread.sleep(3000);
			System.out.println("Fin ejercicio 5.");	
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
