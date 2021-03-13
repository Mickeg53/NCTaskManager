package mx.edu.j2se.GarciaSantamaria.tasks;
import java.util.Scanner;

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

        int current = 15;
        int exit = 0;

        Scanner myObject = new Scanner(System.in);

        Task tarea1 = new Task("jhvhvh",20, 30, 0);  //Creacion de nuevo objeto tarea1

        //Prueba de metodo getTitle y getTime
        System.out.println("La tarea: -"+tarea1.getTitle()+"- será ejecutada a las "+tarea1.getTime()+" hrs.");

        //Prueba de metodo setTitle
        tarea1.setTitle("Estudiar JAVA");

        //Prueba de metodo setTime(int time)
        tarea1.setTime(30);
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

        tarea1.setTime(10, 30, 10);

        if(tarea1.isRepeated()){
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea repetitiva");
        }else{
            System.out.println("La tarea: "+ tarea1.getTitle()+" es una tarea no repetitiva");
        }

        //Prueba de metodo nextTimeAfter
        System.out.println("El tiempo actual es: "+current);
        System.out.println("El siguiente tiempo de ejecución de la tarea: -"+tarea1.getTitle()+"- es: "+tarea1.nextTimeAfter(current));


        Task tarea2 = new Task("Avanzar tesis",30);

        tarea2.setActive(true);
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

        for(Task temp : arrayOfTasks.arrayTask){
                System.out.println("Tarea que se encuentra en el arreglo general de tareas: -"+ temp.getTitle()+"-"); //Obteniendo todas las tareas que están en el arreglo
        }
        System.out.println("El tamaño del arreglo general de tareas es: "+arrayOfTasks.size());


        /*if (arrayOfTasks.remove(tarea1)){                                                                       //Eliminando y comprobando que la tarea1 con indice 0 (antes indice 1) fue eliminada.
                System.out.println("La tarea fue eliminada, el tamaño del arreglo es: "+arrayOfTasks.size());
        }else{
                System.out.println("Tarea no encontrada, el tamaño del arreglo es: "+arrayOfTasks.size());
        }*/


        for(Task temp : arrayOfTasks.incoming(15,50)){                                                            //Recorriendo el arreglo obtenido del método incoming
                System.out.println("Tarea activa del arreglo por ejecutar en el rango de 15 a 50: -"+temp.getTitle()+"-");          //Imprimiendo el título de cada tarea que está por ejecutarse dentro del rango establecido.
        }

        //PROBANDO LINKEDLIST

        System.out.println("");
        System.out.println("PRUEBA DE LINKEDLIST");
        System.out.println("");

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas
        LinkedTaskList incomingList;                    //Lista anidada de tareas por ejecutar

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada
        list.showList();    //Mostrando todas las tareas de la lista anidada

        System.out.println("El tamaño de la lista enlazada es: "+list.size());

        incomingList = list.incoming(15, 50);   //Obteniendo las tareas que están por ejecutarse en una lista anidada

        incomingList.showList();

        System.out.println("El tamaño de la lista enlazada de tareas por ejecutar es: "+incomingList.size());

        //Comprobando funcionamiento del método getTask
        Task tareaLinked = null;
        tareaLinked = list.getTask(0);
        System.out.println("La tarea de la lista enlazada con indice 0 es: "+tareaLinked.getTitle());

        //Comprobando funcionamiento de método remove
        list.remove(tarea1);
        list.showList();
/*
        do{
                System.out.println("Ingrese el valor numérico de la acción que desea ejecutar del menú:");
                System.out.println("A. Ver todas las tareas");
                System.out.println("B. Visualizar una tarea");
                System.out.println("C. Ver las tareas que estan por ejecutarse");
                System.out.println("D. Ver el número de tareas que están programadas");
                System.out.println("E. Programar o agregar nueva tarea");
                System.out.println("F. Reprogramar tarea existente");
                System.out.println("G. Borrar tarea");
                System.out.println("H. Activar/Desactivar una tarea");
                System.out.println("I. Obtener el estado activo/desactivo de una tarea");
                System.out.println("J. Verificar si una tarea es repetitiva");
                System.out.println("K. Obtener el siguiente tiempo de ejecución de una tarea");
                System.out.println("L. Salir");
                String option = myObject.nextLine();

                switch (option){
                        case "A":{
                                System.out.println("Opción 1. Ver todas las tareas");
                                //continue();//
                        }
                        case "B":{
                                System.out.println("2. Visualizar una tarea");
                        }
                        case "C":{
                                System.out.println("3. Ver las tareas que estan por ejecutarse");
                        }
                        case "D":{
                                System.out.println("4. Ver el número de tareas que están programadas");
                        }
                        case "E":{
                                System.out.println("5. Programar o agregar nueva tarea");
                        }
                        case "F":{
                                System.out.println("6. Reprogramar tarea existente");
                        }
                        case "G":{
                                System.out.println("7. Borrar tarea");
                        }
                        case "H":{
                                System.out.println("8. Activar/Desactivar una tarea");
                        }
                        case "I":{
                                System.out.println("9. Obtener el estado activo/desactivo de una tarea");
                        }
                        case "J":{
                                System.out.println("10. Verificar si una tarea es repetitiva");
                        }
                        case "K":{
                                System.out.println("11. Obtener el siguiente tiempo de ejecución de una tarea");
                        }
                        case "L":{
                                System.out.println("SALIENDO");
                                exit = 1;
                        }
                        default:{
                                System.out.println("Seleccione una opcion válida");
                        }
                }
        }while(exit == 0);*/
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
