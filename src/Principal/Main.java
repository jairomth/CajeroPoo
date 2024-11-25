package Principal;

import java.util.Scanner;

import Dominio.Clientes;
import LogicaMetodos.Implementacion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		String apellidop;
		String apellidom;
		long numCuenta;
		float saldo;

		Scanner lectura = null;

		Clientes cliente;

		int menuPrin = 0, subMenu = 0, indice;

		Implementacion imp = new Implementacion();

		do {
			System.out.println("Menú principal:");
			System.out.println("1) Dar de alta.");
			System.out.println("2) Consulta de saldo.");
			System.out.println("3) Movimientos (Deposito y retiro).");
			System.out.println("4) Buscar por número de cliente.");
			System.out.println("5) Salir.");

			lectura = new Scanner(System.in);

			try {
				menuPrin = lectura.nextInt();

				if (menuPrin < 1 || menuPrin > 5) {
					System.out.println("Por favor, ingrese una opción válida (1, 2, 3, 4 o 5).");
					continue;
				}
				switch (menuPrin) {
				case 1:
					System.out.println("Ingrese el nombre del cliente.");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();

					System.out.println("Ingrese el apellido paterno del cliente.");
					lectura = new Scanner(System.in);
					apellidop = lectura.nextLine();

					System.out.println("Ingrese el apellido materno del cliente.");
					lectura = new Scanner(System.in);
					apellidom = lectura.nextLine();

					System.out.println("Ingrese el número de cuenta del cliente.");
					lectura = new Scanner(System.in);
					numCuenta = lectura.nextLong();

					saldo = 0;

					cliente = new Clientes(nombre, apellidop, apellidom, numCuenta, saldo);
					System.out.println("\n" + imp.guardar(cliente) + "\n");

					break;

				case 2: // Consulta de saldo
					imp.consulta();

					break;
				case 3: // Movimientos
					if (imp.mostrar().size() > 0) {
						do {
							System.out.println("Menú de movimientos");
							System.out.println("1) Depositar");
							System.out.println("2) Retirar");
							System.out.println("3) Menú principal");
							lectura = new Scanner(System.in);

							try {
								subMenu = lectura.nextInt();

								if (subMenu < 1 || subMenu > 3) {
									System.out.println("Por favor, ingrese una opción válida (1, 2 o 3).");
									continue;
								}

								switch (subMenu) {
								case 1:
									imp.depositar();
									break;
								case 2:
									imp.retirar();
									break;
								case 3:
									System.out.println("Regresando al menú principal...\n");
									break;
								}
							} catch (Exception e) {
								System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y 3.");
							}
						} while (subMenu != 3);
					} else {
						System.out.println("No hay registros en la lista.\n");
					}
					break;
				case 4: // Buscar por número de cliente
					if (imp.mostrar().size() > 0) {
						System.out.println("Digite el número de cuenta que desea buscar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();
						System.out.println("Se encontró lo siguiente: " + imp.buscarXcuenta(indice));

					} else {
						System.out.println("No existen registros.");
					}
					break;

				case 5:
					System.out.println("Saliendo del sistema...");
					break;
				}
			} catch (Exception e) {
				System.out.println("Entrada inválida. Por favor, ingrese un número entre 1 y 5.");
			}

		} while (menuPrin != 5);

	}

}
