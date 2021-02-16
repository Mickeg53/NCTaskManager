package mx.edu.j2se.GarciaSantamaria.tasks;

public class Main {
	
	public static void main(String[] args) {

		Persona estudianteNC = new Persona();					//Creación de nuevo objeto
		estudianteNC.setEdad(18);								//Asignación de la edad a la persona estudianteNC
		estudianteNC.setNombre("Miguel");
		estudianteNC.setSexo("Masculino");
		estudianteNC.setAltura(1.71);
		estudianteNC.setNacionalidad("Mexicana");

		Persona estudianteNC2 = new Persona();
		estudianteNC2.setNombre("Arturo");
		estudianteNC2.setEdad(12);

		String loDejaron = estudianteNC.loDejanEntrarAlBar();	//Creando variable loDejaron y asignandole el valor que retorna el metodo "loDejanEntrarAlBar" de la persona estudiante NC
		String loDejaron2 = loDejanEntrarAlBar(estudianteNC2.getEdad());
		System.out.println(estudianteNC.getNombre() + ":" + loDejaron);			//Imprimiendo el mensaje que se obtuvo del metodo loDejanEntrarAlBar
		System.out.println(estudianteNC2.getNombre() + ":" + loDejaron2);
		System.out.println(estudianteNC.getNombre() + " tiene " + estudianteNC.getEdad() + " años y mide: " + estudianteNC.getAltura());

		if(estudianteNC.condicionalAlturaNacionalidad()){
			System.out.println("SE CUMPLIÓ CON LA ALTURA Y LA NACIONALIDAD");
			System.out.println("El resultado de la operación es: " + operadorDeAlturaEdad(estudianteNC.getAltura(), estudianteNC.getEdad()));
		}else if(estudianteNC.getNacionalidad() == null){
			System.out.println("NO SE HA INGRESADO LA NACIONALIDAD DE " + estudianteNC2.getNombre());
		}
	}

	public static String loDejanEntrarAlBar(int laEdad){
		if(laEdad >= 18){
			return "Adelante, la barra esta por allá";
		}else{
			return "Lo sentimos, regresa despues";
		}
	}

	public static double operadorDeAlturaEdad(double altura, int edad){
		int i=0;
		double resultado=0;
		for (i=0; i<3; i++){
			resultado = altura*edad+resultado;
			System.out.println("La iteración numero "+i+" tiene un valor de: "+resultado);
		}
		return resultado;
	}
}
