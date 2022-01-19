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
	private static final int CANTIDAD_CONSUMIDORES = 5;
	private static Contenedor container;
	private static Productor productor;
	private static Consumidor [] consumidores;

	public static void ejercicio7() {
		container = new Contenedor();
		productor = new Productor(container, 1);
		consumidores = new Consumidor[CANTIDAD_CONSUMIDORES];
		for (int i = 0; i < consumidores.length; i++) {
			consumidores[i] = new Consumidor(container, i);
			consumidores[i].start();
		}
		productor.start();
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
					Thread.sleep(3000);
					System.out.println("Fin ejercicio 1.");
					break;
				case "2":
					System.out.println("Inicio ejercicio 2. ");
					ejercicio2();
					Thread.sleep(3000);
					System.out.println("Fin ejercicio 2.");
					break;
				case "3":
					System.out.println("Inicio ejercicio 3. ");
					ejercicio3();
					Thread.sleep(3000);
					System.out.println("Fin ejercicio 3.");
					break;
				case "4":
					System.out.println("Inicio ejercicio 4. ");
					ejercicio4();
					Thread.sleep(3000);
					System.out.println("Fin ejercicio 4.");
					break;
				case "5":
					System.out.println("Inicio ejercicio 5. ");
					ejercicio5();
					Thread.sleep(3000);
					System.out.println("Fin ejercicio 5.");
					break;
				case "7":
					System.out.println("Inicio ejercicio 7. ");
					ejercicio7();
					while(productor.isAlive()) {
						Thread.sleep(5000);
						System.out.println("Para terminar la ejecución del programa pulse 0.");
						opt = scan.nextLine();
						if(opt.equals("0")) {
							System.out.println("Finalizando ejercicio 7...");
							for(int i = 0; i < consumidores.length; i++) {
								consumidores[i].isFinished(true);
							}
							productor.isFinished(true);
						}
						Thread.sleep(1000);
					}
					System.out.println("Fin ejercicio 7.");
					break;
				case "8":
					// TODO
					System.out.println(" -- TODO -- ");
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
