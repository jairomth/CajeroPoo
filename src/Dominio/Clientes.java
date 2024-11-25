package Dominio;

public class Clientes {
	private String nombre;
	private String apellidop;
	private String apellidom;
	private long numCuenta;
	private float saldo;
	
	public Clientes() {
	}
	
	public Clientes(String nombre, String apellidop, String apellidom, long numCuenta, float saldo) {
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", apellidop=" + apellidop + ", apellidom=" + apellidom + ", numCuenta="
				+ numCuenta + ", saldo=" + saldo + "]\n";
		
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidop() {
		return apellidop;
	}
	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}
	public String getApellidom() {
		return apellidom;
	}
	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
	public long getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
