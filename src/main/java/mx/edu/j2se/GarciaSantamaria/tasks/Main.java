package mx.edu.j2se.GarciaSantamaria.tasks;

public class Main {
	
	public static void main(String[] args) {

		/*Persona estudianteNC = new Persona();					//Creación de nuevo objeto
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
		}*/

        Task tarea1 = new Task("Estudiar",20);  //Creacion de nuevo objeto tarea1

        //Prueba de metodo getTitle y getTime
        System.out.println("La tarea: "+tarea1.getTitle()+" será ejecutada a las "+tarea1.getTime()+" hrs.");

        //Prueba de metodo setTitle
        tarea1.setTitle("Estudiar JAVA");

        //Prueba de metodo setTime(int time)
        tarea1.setTime(30);
        System.out.println("La tarea: "+tarea1.getTitle()+" será ejecutada a las "+tarea1.getTime()+" hrs.");

        //Prueba de metodo isActive y setActive
        if (tarea1.isActive()){
            System.out.println("la tarea: "+tarea1.getTitle()+" se encuentra activa.");
        }else{
            System.out.println("la tarea: "+tarea1.getTitle()+" se encuentra desactiva.");
            System.out.println("Activando la tarea: "+tarea1.getTitle());
            tarea1.setActive(true);
        }

        if(tarea1.isActive()){
            System.out.println("la tarea: "+tarea1.getTitle()+" se encuentra ahora ACTIVA.");
        }

        //Prueba de metodo getStartTime con tarea no repetitiva
        System.out.println("La tarea: "+tarea1.getTitle()+" será ejecutada a las "+tarea1.getStartTime()+" hrs.");

        //Prueba de metodo getEndTime con tarea no repetitiva
        System.out.println("La tarea: "+tarea1.getTitle()+" termina a las "+tarea1.getEndTime()+ "hrs");

        //Prueba de metodo getRepeateInterval con tarea no repetitiva
        System.out.println("La tarea "+tarea1.getTitle()+" tiene un intervalo de repeticion de: "+tarea1.getRepeatInterval()+" hrs.");

        //Prueba de metodo setTime repetitivo con tarea no repetitiva
        if(tarea1.isRepeated()){
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea repetitiva");
        }else{
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea no repetitiva");
        }

        tarea1.setTime(10, 30, 10);

        if(tarea1.isRepeated()){
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea repetitiva");
        }else{
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea no repetitiva");
        }

        //Prueba de metodo nextTimeAfter
        System.out.println("El tiempo actual de la tarea es: "+tarea1.current);

        tarea1.current = tarea1.nextTimeAfter(tarea1.current);
        System.out.println("El siguiente tiempo de ejecución es: "+tarea1.current);

        tarea1.current = tarea1.nextTimeAfter(tarea1.current);
        System.out.println("El siguiente tiempo de ejecución es: "+tarea1.current);

        Task tarea2 = new Task("Avanzar tesis",30);

        tarea2.current = tarea2.nextTimeAfter(tarea2.current);
        System.out.println("El siguiente tiempo de ejecución de la tarea: "+tarea2.getTitle()+" es "+tarea2.current);

	}
	/*
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
	*/
}
