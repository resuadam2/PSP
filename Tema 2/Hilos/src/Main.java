import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static final int NUM_HILOS = 10;

	public static void ejercicio1() {
		Tarea t1 = new Tarea();
		t1.start();
	}

	public static void ejercicio2() {
		for (int i = 0; i < NUM_HILOS; i++) {
			Tarea t1 = new Tarea("Tarea " + i);
			t1.start();
		}
	}

	public static void ejercicio3() throws InterruptedException {
		for (int i = 0; i < NUM_HILOS; i++) {
			Tarea t1 = new Tarea("Tarea " + i);
			t1.start();
			t1.join();
		}
	}

	public static void ejercicio4() {
		for (int i = 0; i < NUM_HILOS; i++) {
			if (i % 2 == 0) {
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
		Loading l1 = new Loading("Loader", t1);
		t1.start();
		l1.start();
		
	}

	// Ejercicio 7
	
	private static Contenedor container;
	private static Thread productor;
	private static Thread[] consumidores;
	private static final int CANTIDAD_CONSUMIDORES = 5;
	
	public static void ejercicio7() {
		container = new Contenedor();
		consumidores = new Thread[CANTIDAD_CONSUMIDORES];
		//Cambiar a for normal
		for(int i = 0; i < consumidores.length; i++) {
			consumidores[i] = new Thread(new Consumidor(container, i));
			consumidores[i].start();
		}
		productor = new Thread(new Productor(container,1,consumidores));
		productor.start();
	}
	
	public static void ejercicio8(int numTasks) throws InterruptedException {
		Counter contador = new Counter();
		for(int i = 0; i < numTasks; i++) {
			MyTask t = new MyTask(contador);
			t.start();
		}
		Thread.sleep(2000);
		System.out.println("Final counter: " + contador.getCont());
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String opt = "";
		try {
			do {
				System.out.println("Seleccione el ejercicio a realizar:\n" + "\n 1. Ejercicio 1: "
						+ "\n 2. Ejercicio 2: " + "\n 3. Ejercicio 3: " + "\n 4. Ejercicio 4: " + "\n 5. Ejercicio 5: "
						+ "\n 7. Ejercicio 7: " + "\n 8. Ejercicio 8: " + "\n 0. Finalizar programa.");
				opt = scan.nextLine();
				switch (opt) {
				case "1":
					System.out.println("Inicio ejercicio 1. ");
					ejercicio1();
					Thread.sleep(1000);
					System.out.println("Fin ejercicio 1.");
					break;
				case "2":
					System.out.println("Inicio ejercicio 2. ");
					ejercicio2();
					Thread.sleep(1000);
					System.out.println("Fin ejercicio 2.");
					break;
				case "3":
					System.out.println("Inicio ejercicio 3. ");
					ejercicio3();
					Thread.sleep(1000);
					System.out.println("Fin ejercicio 3.");
					break;
				case "4":
					System.out.println("Inicio ejercicio 4. ");
					ejercicio4();
					Thread.sleep(1000);
					System.out.println("Fin ejercicio 4.");
					break;
				case "5":
					System.out.println("Inicio ejercicio 5. ");
					ejercicio5();
					Thread.sleep(1000);
					System.out.println("Fin ejercicio 5.");
					break;
				case "7":
					System.out.println("Inicio ejercicio 7. ");
					ejercicio7();
					Thread.sleep(10000);
					for(int i = 0; i < consumidores.length; i++) {
						if(consumidores[i].isAlive()) System.out.println("Estoy vivo");
					}			
					Consumidor.resetAccesos();
					System.out.println("Fin ejercicio 7.");
					break;
				case "8":
					System.out.println("Inicio ejercicio 8. ");
					int numTasks = 1;
					try {
						System.out.println("Introduzca el número de Tasks\n(Debe ser mayor a 0)");
						numTasks = Integer.parseInt(scan.nextLine());
						if(numTasks <= 0) numTasks = 1;
					} catch (InputMismatchException e) {
						System.err.println("Error al introducir el número, se usará el valor 1");
					}
					ejercicio8(numTasks);
					System.out.println("Fin ejercicio 8.");
					Thread.sleep(1000);
					break;
				case "0":
					System.out.println("Fin del programa.");
					break;
				default:
					System.out.println("Opción inválida, seleccione una opción del menú.");
				}			
			} while (!opt.equals("0"));
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			scan.close();
		}
	}
}
