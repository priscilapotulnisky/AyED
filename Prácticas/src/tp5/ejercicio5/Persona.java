package tp5.ejercicio5;

public class Persona {

	private String nombre;
	private String domicilio;
	private boolean esEmpleado;
	private boolean cobro;
	
	public boolean isCobro() {
		return cobro;
	}

	public void setCobro(boolean cobro) {
		this.cobro = cobro;
	}

	public Persona(String nombre, String domicilio, boolean esEmpleado, boolean cobro) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.esEmpleado = esEmpleado;
		this.cobro = cobro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public boolean isEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	
	
}

