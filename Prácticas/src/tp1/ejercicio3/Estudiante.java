package tp1.ejercicio3;

public class Estudiante extends Persona {
	
	private String comision;
	private String direccion;
	
	
	public Estudiante(String nombre, String apellido, String email, String comision, String direccion) {
		super(nombre, apellido, email);
		this.comision = comision;
		this.direccion = direccion;
	}
	
	public String getComision() {
		return comision;
	}
	
	public void setComision(String comision) {
		this.comision = comision;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux = super.tusDatos();
		return aux + "Comision: " + this.getComision() + "\n"+ "Direccion: " + this.getDireccion();
	}
	

}
