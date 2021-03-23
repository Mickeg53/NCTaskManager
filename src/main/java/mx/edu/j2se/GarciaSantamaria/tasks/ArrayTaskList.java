package mx.edu.j2se.GarciaSantamaria.tasks;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayTaskList extends AbstractTaskList {

    //Histórico del índice del arreglo.
    public int index = -1;

    //Declaración del arreglo de tareas.
    Task[] arrayTask = new Task[0];

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

        if(indexTemp2 > index){                                     //Sí el índice original cambio y ahora es menor al índice temporal, quiere decir que una tarea fue eliminada.
            status = true;
            arrayTask = Arrays.copyOf(arrayTask, index+1);    //Redimensionando el tamaño del arreglo en caso de que el índice original haya cambiado.
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


    public ArrayTaskList incoming(int from, int to){
        //Declaración del arreglo de tareas por ejecutar.
        ArrayTaskList arrayOfScheduleTasks = new ArrayTaskList();

        //Índice temporal
        int tempIndex = -1;

        if(this.arrayTask.length != 0){
            for (Task temp : this.arrayTask){

                if (temp.isActive() &&((temp.time >= from && temp.time <= to && temp.interval == 0)||((temp.start >= from || temp.end <= to) && temp.interval != 0))){

                    arrayOfScheduleTasks.add(temp);

                }
            }
        }else{
            System.out.println("No existen tareas por ejecutar");
        }
        return arrayOfScheduleTasks;
    }

    public int getIndex(Task task){
        int indexTemp = 0;

        for (Task temp : arrayTask){
            if(task == temp){           //Sí la tarea obtenida del arreglo es igual a la tarea que busco.
               return indexTemp;
            }else{
                indexTemp++;            //Recorriendo a la siguiente posición.
            }
        }
        return -1;
    }

    @Override
    public Iterator<Task> iterator() {
        return new iterator<Task>(this);
    }



    public static class iterator<Task> implements Iterator<Task>{
        ArrayTaskList ATL;
        int index;

        public iterator(ArrayTaskList ATL){
            this.ATL = ATL;
            index = -1;
        }

        /*public iterator(ArrayTaskList ATL, int index){
            this.ATL = ATL;
            this.index = index;
        }*/

        @Override
        public boolean hasNext() {

            return index < (ATL.size() - 1);
        }

        @Override
        public Task next() {
            if(hasNext()){
                return (Task) ATL.arrayTask[++index];
            }
            return null;
        }

        @Override
        public void remove() throws ArrayIndexOutOfBoundsException{
            if(index < 0){
                throw new ArrayIndexOutOfBoundsException();
            }
            ATL.remove(ATL.arrayTask[index]);
            index--;
        }
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof ArrayTaskList)){
            return false;
        }

        ArrayTaskList t = (ArrayTaskList) obj;

        if(this.size() != t.size()){
            return false;
        }

        for(int i = 0; i < t.size(); i++){
            if(!arrayTask[i].equals(t.arrayTask[i])){
                return false;
            }
        }
        return true;
    }

    public int hashCode(){
        int hash = 0;
        for(Task temp : arrayTask){
            hash += temp.hashCode();
        }
        return hash;
    }

}
