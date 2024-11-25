package Interface;

import java.util.List;
import java.util.Scanner;

import Dominio.Clientes;

public interface Metodos {

	public String guardar(Clientes cliente);

	public List<Clientes> mostrar();

	public Clientes buscarXcuenta(long indice);

	public void depositar();

	public void retirar();
	
	public void consulta();

}
