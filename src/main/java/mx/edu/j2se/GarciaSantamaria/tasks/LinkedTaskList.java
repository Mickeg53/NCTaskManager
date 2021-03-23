package mx.edu.j2se.GarciaSantamaria.tasks;

import java.util.Iterator;

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
            n.next = nodo;              //Se guarda el nuevo nodo en el último nodo que contiene el apuntador null.
        }
    }

    //Metodo que elimina una tarea del arreglo y regresa el booleano true si la tarea a eliminar se
    // encontraba en la lista, sí la tarea se repite, el metodo elimina cualquiera de ellas.
    public boolean remove(Task task) {
        Node n = head;    //Nodo temporal inicial de lista enlazada head
        if(n.data != task){
            while(n.next != null && n.next.data != task){       //mientras el nodo siguiente no sea el ultimo y la tarea del siguiente nodo sea diferente a la reuqerida
                n = n.next;                                     //Posicionamiento en el siguiente nodo
            }
            if(n.data != task && n.next == null){       //Sí la tarea del nodo no es la que estamos buscando y el nodo actual es el último nodo
                return false;                           //No se borro ninguna tarea ya que no se encontró
            }

            Node current = n.next;      //Lista enlazada temporal de nodo actual que se requiere borrar
            n.next = current.next;      //El apuntador del nodo siguiente apuntará al segundo siguiente nodo despues del nodo a eliminar
            current.next = null;        //El apuntador del siguiente nodo del nodo actual se vuelve null para así eliminarse.
        }else{
            Node previous = n;
            n = n.next;
            head.data = n.data;
            head.next = n.next;
            previous.next = null;
        }
        return true;
    }

    //Metodo que regresa el número de tareas que hay en el arreglo.
    public int size(){
        int size = 0;
        Node nodeTemp = head;       //Lista enlazada temporal
        if(nodeTemp.next == null){  //Sí existe el primer nodo.
            return size = 1;                //Hay por lo menos un nodo
        }else{
            while(nodeTemp.next != null){   //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                nodeTemp = nodeTemp.next;   //Se recorre el nodo en cuestión
                size++;                     //Aumentando el tamaño cada que se recorre el nodo.
            }
            size++;      //Aumenta el tamaño en uno para contar el nodo que contiene el apuntador null.
        }
        return size;
    }

    //Metodo que regresa la tarea que ocupa el lugar indicado mediante un índice
    //El índice de la primer tarea es 0.
    public Task getTask(int index) throws IndexOutOfBoundsException, NullPointerException{
        int tempIndex = 0;          //Declaración de índice temporal
        Task linkedTask = null;     //Declaración de tarea temporal
        Node nodoTemporal = head;   //Declaración de nodo temporal

        if(index <0){                                   //Comprobando que el índice ingresado sea válido.
            throw new IndexOutOfBoundsException();      //Manejar excepción
        }
        if(index == 0){   //Sí el indice ingresado es el primer indice.
            linkedTask = nodoTemporal.data;       //asignar dicha tarea a la tarea temporal
            return linkedTask;
        }else{
            while(nodoTemporal.next != null){       //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                nodoTemporal = nodoTemporal.next;   //Se recorre el nodo en cuestión
                tempIndex++;                        //Aumentando el índice cada que se recorre el nodo.
                if(tempIndex == index){             //Sí el indice temporal corresponde con el indice ingresado
                    linkedTask = nodoTemporal.data; //Se asigna la tarea de la lista anidada a la tarea temporal.
                    return linkedTask;
                }
            }
            tempIndex++;                //Aumentando el indice temporal para apuntar al último nodo
            if(tempIndex == index){                 //Sí el indice temporal coincide con el indice ingresado
                linkedTask = nodoTemporal.data;     //Se asigna la tarea de la lista enlazada a la tarea temporal
                return linkedTask;
            }else if(index > tempIndex){            //Si el indice ingresado es mayor al indice temporal
                throw new NullPointerException();   //Manejar una excepción
            }
        }
        return null;
    }

    public void showList(){
        Node node = head;     //Se asigna el primer nodo de la lista a una lista anidada "node"

        while(node.next != null){                                                               //Mientras no se se llegue al último nodo
            System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());  //Se imprime el titulo de la tarea del nodo actual
            node = node.next;                                                                   //Se recorre al siguiente nodo
        }
        System.out.println("Tarea guardada en una lista enlazada: "+node.data.getTitle());      //Se imprime el titulo de la tarea contenida en el último nodo
    }


    public LinkedTaskList incoming(int from, int to){       //CHECAR

        Node nodeList = head;           //Asignando el nodo inicial de la lista anidada a una lista temporal
        LinkedTaskList incoming = new LinkedTaskList();

        if(nodeList.next == null){      //Sí el apuntador inicial es nulo significa que solo hay una tarea x lo que sí corresponde a una tarea por ejecutar será asigada a incoming.
            if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){
                incoming.head = nodeList;
            }
        }else{

            while(nodeList.next != null){           //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){
                    if(incoming.head == null){   //Sí el primer nodo esta vacío se agrega la tarea en ese nodo.
                        incoming.head = nodeList;
                    }else{
                        while(incoming.head.next != null){      //Se navega por cada nodo hasta llegar al último nodo que contiene el apuntador null
                            incoming.head = incoming.head.next;             //Se recorre el nodo en cuestión
                        }
                        incoming.head.next = nodeList;              //Se guarda el nuevo nodo en el último nodo que contiene el apuntador null.
                    }
                }
                nodeList = nodeList.next;
            }
            if (((Task)nodeList.data).isActive() &&((((Task)nodeList.data).time >= from && ((Task)nodeList.data).time <= to && ((Task)nodeList.data).interval == 0)||((((Task)nodeList.data).start >= from || ((Task)nodeList.data).end <= to) && ((Task)nodeList.data).interval != 0))){
               //n.next = nodeList;
                incoming.head.next = nodeList;
            }
        }
        return incoming;
    }

    public int getIndex(Task task){
        int indexTemp = 0;
        Node temp = head;
        while(temp.next != null){
            if(task == temp.data){          //Sí la tarea obtenida del arreglo es igual a la tarea que busco.
                return indexTemp;
            }else{
                indexTemp++;                //Recorriendo a la siguiente posición.
                temp = temp.next;
            }
        }
        return -1;
    }

    @Override
    public Iterator<Task> iterator() {
        return new iterator<Task>(head);
    }

    //Clase interna del iterador de LinkedTaskList
    public class iterator<Task> implements Iterator<Task>{
        Node LTL;
        Node anterior;
        boolean viewFirst = false;

        public iterator(Node LTL){
            this.LTL = LTL;
        }


        @Override
        public boolean hasNext() {
            return (LTL.next != null)?true:false;
        }

        @Override
        public Task next() {
            if(!viewFirst){
                viewFirst = true;
                return (Task) LTL.data;
            }else{
                if(hasNext()){
                    anterior = LTL;
                    LTL = LTL.next;
                    return (Task) LTL.data;
                }
            }
            return null;
        }

        @Override
        public void remove(){
            if(!viewFirst){
                try{
                    if (anterior != null){
                        anterior.next = null;
                        anterior = null;
                    }else{
                        throw new IllegalStateException("Ya fue usado el metodo anteriormente");
                    }
                }catch(IllegalStateException ise) {
                    System.out.println(ise.getMessage());
                }
            }
        }
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof LinkedTaskList)){
            return false;
        }

        LinkedTaskList t = (LinkedTaskList) obj;

        Node temp1 = null;
        Node temp2 = null;

        temp1 = t.head;
        temp2 = this.head;

        if(this.size() != t.size()){
            return false;
        }

        while(temp1.next != null){
            if(!temp2.data.equals(temp1.data)){
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public int hashCode(){
        int hash = 0;
        Node temp = this.head;
        while(temp.next != null){
            hash += temp.data.hashCode();
            temp = temp.next;
        }
        hash += temp.data.hashCode();
        return hash;
    }
}
