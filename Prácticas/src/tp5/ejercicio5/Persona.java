package tp5.ejercicio5;

import java.util.Objects;

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
	
	@Override
    public boolean equals(Object o) {               
        if ((o != null) && (o instanceof Persona)){ 
        	Persona p = (Persona) o;
        	return  this.getNombre().equals(p.getNombre())  &&
        			this.getDomicilio().equals(p.getDomicilio()) &&
        			this.isCobro() == p.isCobro() &&
        			this.isEsEmpleado() == p.isEsEmpleado();
        }
        return false;
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(nombre, domicilio, esEmpleado, cobro);
    }

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", domicilio=" + domicilio + ", esEmpleado=" + esEmpleado + ", cobro="
				+ cobro + "]";
	}
	
	
}

