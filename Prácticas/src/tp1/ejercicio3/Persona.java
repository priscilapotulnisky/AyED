package tp1.ejercicio3;

public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String email;
	
	public Persona(String nombre, String apellido, String email) {
		this.apellido = apellido;
		this.email = email;
		this.nombre = nombre;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String tusDatos() {
		return "Nombre: " + this.getNombre() + "\n" + "Apellido: " + this.getApellido()+"\n" + "Email: " + this.getEmail() + "\n";
	}
}
