package mx.edu.j2se.GarciaSantamaria.tasks;

import java.util.Arrays;

public class LinkedTaskList {

    Task data;              //Información del nodo de tipo Task
    LinkedTaskList next;    //Campo asignado a la referencia del siguiente nodo.

    private LinkedTaskList head;            //Primer nodo de la lista enlazada de todas las tareas agregadas.
    private LinkedTaskList headIncoming;    //Primer nodo de la lista enlazada de tareas por ejecutar.



    //Metodo que agrega una tarea en especifico a la lista enlazada de tareas.
    public void add(Task task){
        LinkedTaskList node = new LinkedTaskList(); //Declaracion de nuevo nodo
        node.data = task;   //Asignando al nodo la tarea que recibe el método
        node.next = null;   //Asignando el valor null al apuntador del siguiente nodo

        if(head == null){   //Sí el primer nodo esta vacío se agrega la tarea en ese nodo.
            head = node;
        }else{
            LinkedTaskList n = head;    //Lista enlazada temporal
            while(n.next != null){      //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                n = n.next;             //Se recorre el nodo en cuestión
            }
            n.next = node;              //Se guarda el nuevo nodo en el último nodo que contiene el apuntador null.
        }
    }


    //Metodo que elimina una tarea del arreglo y regresa el booleano true si la tarea a eliminar se
    // encontraba en la lista, sí la tarea se repite, el metodo elimina cualquiera de ellas.
    public boolean remove(int index){
        int tempIndex = 1;      //Declaración de índice temporal

        try{
            if(index <0){       //Comprobando que el índice ingresado sea válido.
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){   //Sí el indice ingresado es el primer indice.
                head = head.next;       //El primer nodo será igual al nodo siguiente
                head.next = null;       //El apuntador del primer nodo se convierte en null y así eliminandose
            }else{
                LinkedTaskList n = head;    //Lista enlazada temporal
                while(tempIndex < index ){      //mientras el indice temporal sea menor al índice ingresado
                    n = n.next;                 //Corrimiento de nodo
                    tempIndex++;                //Incremento del indice temporal cada vez que el nodo se recorre
                }
                LinkedTaskList current = n.next;    //Lista enlazada temporal de nodo actual que se requiere borrar
                n.next = current.next;              //El apuntador del nodo siguiente apuntará al segundo siguiente nodo
                current.next = null;                //El apuntador del siguiente nodo del nodo actual se vuelve null para asi eliminarse.

                if(index > tempIndex){              //Sí el índice ingresado es mayor a el índice temporal
                    throw new NullPointerException();   //Excepción
                }
            }
        }catch(IndexOutOfBoundsException d){
            System.out.println("El índice ingresado no es válido ya que es negativo");
        }catch(NullPointerException d){
            System.out.println("El índice ingresado no es válido ya que es mayor al número de elementos en la lista.");
        }
        return true;
    }

    //Metodo que regresa el número de tareas que hay en el arreglo.
    public int size(){
        int size = 0;
        if(head == null){   //Sí existe el primer nodo.
            size = 1;       //Hay por lo menos un nodo
        }else{
            LinkedTaskList n = head;    //Lista enlazada temporal
            while(n.next != null){      //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                n = n.next;             //Se recorre el nodo en cuestión
                size++;                 //Aumentando el tamaño cada que se recorre el nodo.
            }
            size++;              //Aumenta el tamaño en uno para contar el nodo que contiene el apuntador null.
        }
        return size;
    }

    //Metodo que regresa la tarea que ocupa el lugar indicado mediante un índice
    //El índice de la primer tarea es 0.
    public Task getTask(int index){
        int tempIndex = 0;      //Declaración de índice temporal
        Task linkedTask = null; //Declaracíon de tarea temporal

        try{
            if(index <0){                                       //Comprobando que el índice ingresado sea válido.
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){   //Sí el indice ingresado es el primer indice.
                linkedTask = head.data;       //asignar dicha tarea a la tarea temporal
            }else{
                LinkedTaskList n = head;    //Lista enlazada temporal
                while(n.next != null){      //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                    n = n.next;             //Se recorre el nodo en cuestión
                    tempIndex++;                 //Aumentando el índice cada que se recorre el nodo.
                    if(tempIndex == index){     //Sí el indice temporal corresponde con el indice ingresado
                        linkedTask = n.data;    //Se asigna la tarea de la lista anidada a la tarea temporal.
                    }
                }
                if(tempIndex == index){     //Sí el indice temporal coincide con el indice ingresado
                    linkedTask = n.data;    //Se asigna la tarea de la lista enlazada a la tarea temporal
                }else if(index > tempIndex){    //Si el indice ingresado es mayor al indice temporal
                    throw new NullPointerException();       //Manejar una excepción
                }
            }
        }catch(IndexOutOfBoundsException d){
            System.out.println("El índice ingresado no es válido ya que es negativo");
        }catch(NullPointerException d){
            System.out.println("El índice ingresado no es válido ya que es mayor al número de elementos en la lista.");
        }
        return linkedTask;      //Regresar la tarea contenida en tarea temporal.
    }

    public void showList(){
        LinkedTaskList node = head;     //Se asigna el primer nodo de la lista a una lista anidada "node"

        while(node.next != null){       //Mientras no se se llegue al último nodo
            System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());  //Se imprime el nodo en el que se encuentre
            node = node.next;       //Se recorre al siguiente nodo
        }
        System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());      //Se imprime el titulo de la tarea contenida en el último nodo
    }


    public LinkedTaskList incoming(int from, int to){
        LinkedTaskList nodeList = head;     //Asignando el nodo inicial de la lista anidada a una lista temporal

        if(nodeList.next == null){  //Sí el apuntador inicial es nulo significa que solo hay una tarea x lo que sí corresponde a una tarea por ejecutar será asigada a headIncoming.
            if (nodeList.data.isActive() &&((nodeList.data.time >= from && nodeList.data.time <= to && nodeList.data.interval == 0)||((nodeList.data.start >= from || nodeList.data.end <= to) && nodeList.data.interval != 0))){
                nodeList = headIncoming;
            }
        }else{
            LinkedTaskList no = headIncoming;    //Lista enlazada temporal
            while(nodeList.next != null){           //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                if (nodeList.data.isActive() &&((nodeList.data.time >= from && nodeList.data.time <= to && nodeList.data.interval == 0)||((nodeList.data.start >= from || nodeList.data.end <= to) && nodeList.data.interval != 0))){
                    LinkedTaskList nodeIncoming = new LinkedTaskList(); //Nuevo nodo de una lista enlazada

                    nodeIncoming.data = nodeList.data;
                    nodeIncoming.next = null;

                    if(headIncoming == null){
                        headIncoming = nodeIncoming;
                    }else{
                        LinkedTaskList n = headIncoming;    //Lista enlazada temporal
                        while(n.next != null){
                            n = n.next;
                        }
                        n.next = nodeIncoming;
                    }
                nodeList = nodeList.next;
                }
            }
            if (nodeList.data.isActive() &&((nodeList.data.time >= from && nodeList.data.time <= to && nodeList.data.interval == 0)||((nodeList.data.start >= from || nodeList.data.end <= to) && nodeList.data.interval != 0))){
                no.next = nodeList;
            }
        }
        return headIncoming;
    }
}
