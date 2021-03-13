package mx.edu.j2se.GarciaSantamaria.tasks;

import java.util.Arrays;

public class ArrayTaskList extends AbstractTaskList {

    //Histórico del índice del arreglo.
    public int index = -1;

    //Declaración del arreglo de tareas.
    Task[] arrayTask = new Task[0];

    //Declaración del arreglo de tareas por ejecutar.
    Task[] arrayOfScheduleTasks = new Task[0];

    //Metodo que agrega una tarea en especifico al arreglo de tareas.
    public void add(Task task){
        index++;
        arrayTask = Arrays.copyOf(arrayTask, (index+1));    //Se crea copia del arreglo en un arreglo del mismo nombre pero con diferente longitud.
        arrayTask [index] = task;                           //Se agrega la tarea al arreglo redimensionado.
    }

    //Metodo que elimina una tarea del arreglo y regresa el booleano true si la tarea a eliminar se
    // encontraba en la lista, sí la tarea se repite, el metodo elimina cualquiera de ellas.
    public boolean remove(Task task){
        int indexTemp = 0;
        int indexTemp1 = 0;
        int indexTemp2 = index;
        boolean status = false;
        
        for (Task temp : arrayTask){
               if(task == temp){                                    //Sí la tarea obtenida del arreglo es igual a la tarea que busco.
                   indexTemp1++;                                    //Adelanto una posición del indice
                   index--;                                         //Esto quiere decir que el indice original del arreglo tiene que disminuir.
               }else{
                   arrayTask[indexTemp] = arrayTask[indexTemp1];    //Recorriendo la tarea siguiente al indice donde fue eliminada la tarea. Sí la tarea no se encuentra simplemente se copian las tareas en su misma posición.
                   indexTemp++;                                     //Recorriendo a la siguiente posición.
                   indexTemp1++;                                    //Recorriendo a la siguiente posición.
               }
        }
        arrayTask = Arrays.copyOf(arrayTask, index+1);    //Redimensionando el tamaño del arreglo en caso de que el índice original haya cambiado.

        if(indexTemp2 > index){                                     //Sí el índice original cambio y ahora es menor al índice temporal, quiere decir que una tarea fue eliminada.
            status = true;
        }
        return status;
    }

    //Metodo que regresa el número de tareas que hay en el arreglo.
    public int size(){
        return arrayTask.length;
    }

    //Metodo que regresa la tarea que ocupa el lugar indicado mediante un índice
    //El índice de la primer tarea es 0.
    public Task getTask(int index){
        try{
            if(index > this.index || index <0){                                       //Comprobando que el índice ingresado sea válido.
                throw new IndexOutOfBoundsException();
            }
        }catch(IndexOutOfBoundsException d){
            System.out.println("El índice ingresado no es válido ya que es negativo o el tamaño del arreglo es menor. size: "+arrayTask.length);
        }
        return arrayTask[index];
    }


    public Task[] incoming(int from, int to){
        //Índice temporal
        int tempIndex = -1;
        if(this.arrayTask.length != 0){
            for (Task temp : this.arrayTask){

                if (temp.isActive() &&((temp.time >= from && temp.time <= to && temp.interval == 0)||((temp.start >= from || temp.end <= to) && temp.interval != 0))){
                    tempIndex++;
                    arrayOfScheduleTasks = Arrays.copyOf(arrayOfScheduleTasks, tempIndex+1);    //Se crea copia del arreglo en un arreglo del mismo nombre pero con diferente longitud.
                    arrayOfScheduleTasks [tempIndex] = temp;
                }
            }
        }else{
            System.out.println("El arreglo de tareas se encuentra vacío");
        }
        return arrayOfScheduleTasks;
    }
}
