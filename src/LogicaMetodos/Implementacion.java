package LogicaMetodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dominio.Clientes;
import Interface.Metodos;

public class Implementacion implements Metodos {
	Scanner lectura = new Scanner(System.in);
	private List<Clientes> lista = new ArrayList<Clientes>();

	@Override
	public String guardar(Clientes cliente) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		String mensaje = "";

		for (Clientes clienteEncon : lista) {
			if (clienteEncon.getNumCuenta() == cliente.getNumCuenta()) {
				mensaje = "NumeroDeCuentaExistente";
				bandera = true;
				break;
			}
		}
		if (bandera == false) {
			lista.add(cliente);
			mensaje = "clienteGuardado";
		}
		return mensaje;
	}

	@Override
	public List<Clientes> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Clientes buscarXcuenta(long cuenta) {
		// TODO Auto-generated method stub
		Clientes clienteEncon = null;
		for (Clientes p : lista) {
			if (p.getNumCuenta() == cuenta) {
				clienteEncon = p;
				break;
			}
		}
		return clienteEncon;
	}

	@Override
	public void depositar() {
		// Solicitar el número de cuenta
		System.out.println("Digite el número de cliente:");
		lectura = new Scanner(System.in);
		long cuenta = lectura.nextLong();

		// Verificar si hay clientes registrados
		if (mostrar().isEmpty()) {
			System.out.println("No existen registros de clientes.");
			return;
		}

		// Buscar el cliente
		Clientes cliente = buscarXcuenta(cuenta);

		// Verificar si el cliente fue encontrado
		if (cliente == null) {
			System.out.println("Número de cuenta inválido.");
			return;
		}

		// Solicitar el monto a depositar
		try {
			System.out.println("¿Cuánto desea depositar?");
			lectura = new Scanner(System.in);
			float monto = lectura.nextFloat();

			// Validar que el monto sea positivo
			if (monto <= 0) {
				System.out.println("El depósito debe ser mayor a cero.");
				return;
			}

			// Actualizar el saldo del cliente
			float saldoActual = cliente.getSaldo();
			cliente.setSaldo(saldoActual + monto);
			System.out.println("El saldo se ha actualizado: " + cliente.getSaldo());
		} catch (Exception e) {
			// Manejo de excepciones
			System.out.println("Error en los datos ingresados.");
		}
	}

	@Override
	public void retirar() {
		// TODO Auto-generated method stub
		// Solicitar el número de cuenta
		System.out.println("Digite el número de cliente:");
		lectura = new Scanner(System.in);
		long cuenta = lectura.nextLong();

		// Verificar si hay clientes registrados
		if (mostrar().isEmpty()) {
			System.out.println("No existen registros de clientes.");
			return;
		}

		// Buscar el cliente
		Clientes cliente = buscarXcuenta(cuenta);

		// Verificar si el cliente fue encontrado
		if (cliente == null) {
			System.out.println("Número de cuenta inválido.");
			return;
		}

		// Solicitar el monto a depositar
		try {
			System.out.println("¿Cuánto desea retirar?");
			lectura = new Scanner(System.in);
			float monto = lectura.nextFloat();
			float saldoActual = cliente.getSaldo();
			// Validar que el monto sea positivo

			if (monto <= 0) {
				System.out.println("El monto del retiro debe ser mayor a cero.");
				return;
			}

			if (10000 <= monto) {
				System.out.println("El monto del retiro debe ser menor a 10,000.");
				return;
			}

			if (saldoActual <= monto) {
				System.out.println("El monto del retiro debe ser menor al Saldo actual:" + saldoActual + ".");
				return;
			}
			// Actualizar el saldo del cliente

			cliente.setSaldo(saldoActual - monto);
			System.out.println("El saldo se ha actualizado: " + cliente.getSaldo());
		} catch (Exception e) {
			// Manejo de excepciones
			System.out.println("Error en los datos ingresados.");
		}
	}

	@Override
	public void consulta() {
		// TODO Auto-generated method stub
		// Verificar si hay clientes registrados
		if (mostrar().isEmpty()) {
			System.out.println("No existen registros de clientes.");
			return;
		}

		try {
			System.out.println("Digite el número de cuenta.");
			lectura = new Scanner(System.in);
			long numCuenta = lectura.nextLong();

			// Buscar el cliente
			Clientes cliente = buscarXcuenta(numCuenta);

			// Verificar si el cliente fue encontrado
			if (cliente == null) {
				System.out.println("Número de cuenta inválido.");
				return;
			} else {
				System.out
						.println("El saldo actual de la cuenta con número " + numCuenta + " es: " + cliente.getSaldo());

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en los datos ingresados.");

		}

	}

}
