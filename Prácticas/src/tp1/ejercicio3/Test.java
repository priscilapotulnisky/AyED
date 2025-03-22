package tp1.ejercicio3;


public class Test {

	public static void main (String [] args) {
		
		//vector de estudiantes
		Estudiante [] estudiantes = new Estudiante [2];
		estudiantes[0] = new Estudiante ("Nombre estudiante 1", "Apellido estudiante 1", "Email estudiante 1","Comision 1", "Direccion 1");
		estudiantes[1] = new Estudiante ("Nombre estudiante 2", "Apellido estudiante 2", "Email estudiante 2","Comision 2", "Direccion 2");
		
		//vector de profesores
		Profesor [] profesores = new Profesor [3];
		profesores[0] = new Profesor("Nombre profesor 1", "Apellido profesor 1", "Email profesor 1", "Catedra 1", "Facultad 1");
		profesores[1] = new Profesor("Nombre profesor 2", "Apellido profesor 2", "Email profesor 2", "Catedra 2", "Facultad 2");
		profesores[2] = new Profesor("Nombre profesor 3", "Apellido profesor 3", "Email profesor 3", "Catedra 3", "Facultad 3");
		
		//Imprimir la información 
		System.out.println("-------ESTUDIANTES--------");
		for(int i = 0; i<estudiantes.length; i++) {
			System.out.println("---Estudiante "+(i+1));
			System.out.println(estudiantes[i].tusDatos());
			System.out.println();
		}
		
		System.out.println("-------PROFESORES--------");
		for(int i = 0; i<profesores.length; i++) {
			System.out.println("---Profesor "+(i+1));
			System.out.println(profesores[i].tusDatos());
			System.out.println();
		}
	}
}
