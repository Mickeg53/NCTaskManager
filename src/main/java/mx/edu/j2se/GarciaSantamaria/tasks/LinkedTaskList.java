package mx.edu.j2se.GarciaSantamaria.tasks;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

class LinkedTaskList extends AbstractTaskList{

       public Node head;

    //Metodo que agrega una tarea en especifico a la lista enlazada de tareas.
    public void add(Task task){

        Node nodo = new Node();
        nodo.data = task;
        nodo.next = null;

        if(head == null){   //Sí el primer nodo esta vacío se agrega la tarea en ese nodo.

            head = nodo;

        }else{
            Node n = head;    //Lista enlazada temporal
            while(n.next != null){      //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                n = n.next;             //Se recorre el nodo en cuestión
            }
           // Node node = new Node<Task>(); //Declaracion de nuevo nodo
            //node.data = task;   //Asignando al nodo la tarea que recibe el método
            //node.next = null;   //Asignando el valor null al apuntador del siguiente nodo
            n.next = nodo;              //Se guarda el nuevo nodo en el último nodo que contiene el apuntador null.
        }
    }

    //Metodo que elimina una tarea del arreglo y regresa el booleano true si la tarea a eliminar se
    // encontraba en la lista, sí la tarea se repite, el metodo elimina cualquiera de ellas.
    public boolean remove(Task task){
        boolean estado = false;
        try{
                Node n = head;    //Lista enlazada temporal
            if(n.data != task){
                while(n.next != null && n.next.data != task){       //mientras el indice temporal sea menor al índice ingresado
                    n = n.next;                                     //Corrimiento de nodo
                }
                if(n.data != task && n.next == null){
                    estado = false;
                }
                Node current = n.next;    //Lista enlazada temporal de nodo actual que se requiere borrar
                n.next = current.next;              //El apuntador del nodo siguiente apuntará al segundo siguiente nodo
                current.next = null;                //El apuntador del siguiente nodo del nodo actual se vuelve null para asi eliminarse.
            }else{
                Node previous = n;
                n = n.next;
                head.data = n.data;
                head.next = n.next;
                previous.next = null;
            }
            estado = true;

        }catch(IndexOutOfBoundsException d){
            System.out.println("El índice ingresado no es válido ya que es negativo");
        }catch(NullPointerException d){
            System.out.println("El índice ingresado no es válido ya que es mayor al número de elementos en la lista.");
        }
        return estado;
    }

    //Metodo que regresa el número de tareas que hay en el arreglo.
    public int size(){
        int size = 0;
        Node nodeTemp = head;
        if(nodeTemp.next == null){   //Sí existe el primer nodo.
            size = 1;       //Hay por lo menos un nodo
        }else{
            Node n = nodeTemp;    //Lista enlazada temporal
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
        Node nodoTemporal = head;

        try{
            if(index <0){                                       //Comprobando que el índice ingresado sea válido.
                throw new IndexOutOfBoundsException();
            }
            if(index == 0){   //Sí el indice ingresado es el primer indice.
                linkedTask = nodoTemporal.data;       //asignar dicha tarea a la tarea temporal
            }else{
                Node n = head;    //Lista enlazada temporal
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
        Node node = head;     //Se asigna el primer nodo de la lista a una lista anidada "node"

        while(node.next != null){       //Mientras no se se llegue al último nodo
            System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());  //Se imprime el nodo en el que se encuentre
            node = node.next;       //Se recorre al siguiente nodo
        }
        System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());      //Se imprime el titulo de la tarea contenida en el último nodo

    }


    public LinkedTaskList incoming(int from, int to){

        Node nodeList = head;     //Asignando el nodo inicial de la lista anidada a una lista temporal
        LinkedTaskList incoming = new LinkedTaskList();

        if(nodeList.next == null){  //Sí el apuntador inicial es nulo significa que solo hay una tarea x lo que sí corresponde a una tarea por ejecutar será asigada a incoming.
            if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){
                incoming.head = nodeList;
            }
        }else{
            while(nodeList.next != null){           //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
               try{
                   if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){

                       incoming.head = nodeList;

                   }
               }catch(Exception e){

                }
                nodeList = nodeList.next;
            }
            if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){
                incoming.head = nodeList;
            }
        }
        return incoming;
    }

    public int getIndex(Task task){
        int indexTemp = 0;
        Node temp = head;
        while(temp.next != null){
            if(task == temp.data){                                    //Sí la tarea obtenida del arreglo es igual a la tarea que busco.
                return indexTemp;
            }else{
                indexTemp++;                                     //Recorriendo a la siguiente posición.
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public Iterator<Task> iterator() {
        return null;
    }
}
