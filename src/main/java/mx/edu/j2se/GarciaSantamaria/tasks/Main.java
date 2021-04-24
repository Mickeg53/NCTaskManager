package mx.edu.j2se.GarciaSantamaria.tasks;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Iterator;

public class Main {
	
	public static void main(String[] args) throws Exception {

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

        LocalDateTime current = LocalDateTime.now();

        Task tarea1 = new Task("jhvhvh",LocalDateTime.parse("2021-04-15T13:00:00"), LocalDateTime.parse("2021-04-15T16:00:00"), 0);  //Creacion de nuevo objeto tarea1

        //Prueba de metodo getTitle y getTime
        System.out.println("La tarea: -"+tarea1.getTitle()+"- será ejecutada a las "+tarea1.getTime()+" hrs.");

        //Prueba de metodo setTitle
        tarea1.setTitle("Estudiar JAVA");

        //Prueba de metodo setTime(int time)
        tarea1.setTime(LocalDateTime.parse("2021-04-15T15:00:00"));
        System.out.println("La tarea: -"+tarea1.getTitle()+"- será ejecutada a las "+tarea1.getTime()+" hrs.");

        //Prueba de metodo isActive y setActive
        if (tarea1.isActive()){
            System.out.println("la tarea: -"+tarea1.getTitle()+"- se encuentra activa.");
        }else{
            System.out.println("la tarea: -"+tarea1.getTitle()+"- se encuentra desactiva.");
            System.out.println("Activando la tarea: -"+tarea1.getTitle()+"-");
            tarea1.setActive(true);
        }

        if(tarea1.isActive()){
            System.out.println("la tarea: -"+tarea1.getTitle()+"- se encuentra ahora ACTIVA.");
        }

        //Prueba de metodo getStartTime con tarea no repetitiva
        System.out.println("La tarea: -"+tarea1.getTitle()+"- será ejecutada a las "+tarea1.getStartTime()+" hrs.");

        //Prueba de metodo getEndTime con tarea no repetitiva
        System.out.println("La tarea: -"+tarea1.getTitle()+"- termina a las "+tarea1.getEndTime()+ "hrs");

        //Prueba de metodo getRepeateInterval con tarea no repetitiva
        System.out.println("La tarea -"+tarea1.getTitle()+"- tiene un intervalo de repeticion de: "+tarea1.getRepeatInterval()+" hrs.");

        //Prueba de metodo setTime repetitivo con tarea no repetitiva
        if(tarea1.isRepeated()){
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea repetitiva");
        }else{
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea no repetitiva");
        }

        tarea1.setTime(LocalDateTime.parse("2021-04-15T14:00:00"), LocalDateTime.parse("2021-04-15T16:00:00"), 1);

        if(tarea1.isRepeated()){
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea repetitiva");
        }else{
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea no repetitiva");
        }

        //Prueba de metodo nextTimeAfter
        System.out.println("El tiempo actual es: "+current);
        System.out.println("El siguiente tiempo de ejecución de la tarea: -"+tarea1.getTitle()+"- es: "+tarea1.nextTimeAfter(current));


        Task tarea2 = new Task("Avanzar tesis",LocalDateTime.parse("2021-04-15T16:00:00"));

        tarea2.setActive(false);
        System.out.println("El siguiente tiempo de ejecución de la tarea: -"+tarea2.getTitle()+"- no repetitiva es "+tarea2.nextTimeAfter(current));


        System.out.println("");
        System.out.println("PRUEBA DE ARREGLO DE TAREAS");
        System.out.println("");


        ArrayTaskList arrayOfTasks = new ArrayTaskList();                                                       //Declaración de objeto arregloDeTareas del tipo ArrayTaskList

        arrayOfTasks.add(tarea2);                                                                               //Agregando la tarea2 previamente creada al arreglo de tareas
        System.out.println("La tarea agregada de nombre: -"+arrayOfTasks.getTask(0).getTitle()+"- tiene índice: "+arrayOfTasks.index);  //Obteniendo la tarea recien agregada al arreglo
        System.out.println("El tamaño del arreglo general de tareas es: "+arrayOfTasks.size());

        arrayOfTasks.add(tarea1);                                                                               //Agregando la tarea1 previamente creada al arreglo de tareas
        System.out.println("La tarea agregada de nombre: -"+arrayOfTasks.getTask(1).getTitle()+"- tiene índice: "+arrayOfTasks.index);  //Obteniendo la tarea recien agregada al arreglo
        System.out.println("El tamaño del arreglo general de tareas es: "+arrayOfTasks.size());

        /*if (arrayOfTasks.remove(tarea2)){                                                                       //Eliminando y comprobando que la tarea2 con indice 0 fue eliminada desplazando las tareas subsiguientes al indice que quedó libre y poder acortar el tamaño del arreglo.
                System.out.println("La tarea fue eliminada, el tamaño del arreglo es: "+arrayOfTasks.size());
            }else{
                System.out.println("Tarea no encontrada, el tamaño del arreglo es: "+arrayOfTasks.size());
        }*/

        //arrayOfTasks.arrayTask.forEach(Task -> )

        for(Task temp : arrayOfTasks.arrayTask){
                System.out.println("Tarea que se encuentra en el arreglo general de tareas: -"+ temp.getTitle()+"-"); //Obteniendo todas las tareas que están en el arreglo
        }

        System.out.println("El tamaño del arreglo general de tareas es: "+arrayOfTasks.size());


        /*if (arrayOfTasks.remove(tarea1)){                                                                       //Eliminando y comprobando que la tarea1 con indice 0 (antes indice 1) fue eliminada.
                System.out.println("La tarea fue eliminada, el tamaño del arreglo es: "+arrayOfTasks.size());
        }else{
                System.out.println("Tarea no encontrada, el tamaño del arreglo es: "+arrayOfTasks.size());
        }*/

        ArrayTaskList c = (ArrayTaskList) arrayOfTasks.incoming(LocalDateTime.parse("2021-04-15T14:30:00"),LocalDateTime.parse("2021-04-15T18:00:00"));

        for(int i = 0; i < c.size(); i++){

                Task temp = c.getTask(i);
                System.out.println("Tarea activa del arreglo por ejecutar en el rango de 15 a 50: -"+temp.getTitle()+"-");          //Imprimiendo el título de cada tarea que está por ejecutarse dentro del rango establecido.

        }

        Iterator iterador = arrayOfTasks.iterator();

        while (iterador.hasNext()){
                System.out.println("\nElementos de arrayOfTasks:" + iterador.next());
                iterador.remove();
        }
        System.out.println("\nElementos de arrayOfTasks:" + iterador.next());

        //PROBANDO LINKEDLIST

        System.out.println("");
        System.out.println("PRUEBA DE LINKEDLIST");
        System.out.println("");

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas
        LinkedTaskList incomingList;                    //Lista anidada de tareas por ejecutar

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        list.showList();    //Mostrando todas las tareas de la lista anidada

        System.out.println("El tamaño de la lista enlazada es: "+list.size());

        incomingList = (LinkedTaskList) list.incoming(LocalDateTime.parse("2021-04-15T14:30:00"), LocalDateTime.parse("2021-04-15T18:00:00"));   //Obteniendo las tareas que están por ejecutarse en una lista anidada

        incomingList.showList();

        System.out.println("El tamaño de la lista enlazada de tareas por ejecutar es: "+incomingList.size());

        //Comprobando funcionamiento del método getTask
        Task tareaLinked = null;

        try{
                tareaLinked = list.getTask(0);
                System.out.println("La tarea de la lista enlazada con indice 0 es: "+tareaLinked.getTitle());

        }catch(IndexOutOfBoundsException d){
                System.out.println("El índice ingresado no es válido ya que es negativo");
        }catch(NullPointerException d){
                System.out.println("El índice ingresado no es válido ya que es mayor al número de elementos en la lista.");
        }

        System.out.println("El indice de la tarea anterior es: "+ list.getIndex(tareaLinked));

        //Comprobando funcionamiento de Iterador
        Iterator iteradorLinked = list.iterator();

        while (iteradorLinked.hasNext()){
                System.out.println("\n Elementos de arrayOfLinkedTasks:" + iteradorLinked.next());
                iteradorLinked.remove();
        }

        //Comprobando funcionamiento de método remove
        list.remove(tarea2);
        list.showList();
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
