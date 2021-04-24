package mx.edu.j2se.GarciaSantamaria.tasks.tests;

import mx.edu.j2se.GarciaSantamaria.tasks.LinkedTaskList;
import mx.edu.j2se.GarciaSantamaria.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Iterator;

public class LinkedTaskList_Tests {
    Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"));
    Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"), 1);

    public LinkedTaskList_Tests() throws Exception {
    }

    @Test
    public void add_remove_Test() throws Exception{

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        Assert.assertEquals(0, list.getIndex(tarea1));
        Assert.assertEquals(1, list.getIndex(tarea2));
        Assert.assertEquals(tarea2, list.getTask(2));

        Assert.assertTrue(list.remove(tarea2));
        Assert.assertEquals(1, list.getIndex(tarea2));

        Assert.assertTrue(list.remove(tarea1));
        Assert.assertFalse(list.remove(tarea1));
        Assert.assertEquals(-1, list.getIndex(tarea1));

        Assert.assertEquals(tarea2, list.getTask(0));
        Assert.assertTrue(list.remove(tarea2));

    }

    @Test
    public void size_Test() throws Exception{

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        Assert.assertEquals(2, list.size());

        list.add(tarea2);
        Assert.assertEquals(3, list.size());

        list.remove(tarea2);
        Assert.assertEquals(2, list.size());

    }

    @Test
    public void getTask_Test() throws Exception{

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        Task tareaLinked = null;

        try{
            tareaLinked = list.getTask(0);
            Assert.assertEquals("Lavar trastes", tareaLinked.getTitle());

            tareaLinked = list.getTask(1);
            Assert.assertEquals("Hacer ejercicio", tareaLinked.getTitle());

        }catch(IndexOutOfBoundsException d){
            Assert.assertEquals("El índice ingresado no es válido ya que es negativo",d.getMessage());
        }catch(NullPointerException d){
            Assert.assertEquals("El índice ingresado no es válido ya que es mayor al número de elementos en la lista.",d.getMessage());
        }
    }

    @Test
    public void incoming_Test()throws Exception{

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas
        LinkedTaskList incomingList;                    //Lista anidada de tareas por ejecutar

        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        tarea1.setActive(true);
        tarea2.setActive(true);

        incomingList = (LinkedTaskList) list.incoming(LocalDateTime.parse("2021-04-15T11:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"));   //Obteniendo las tareas que están por ejecutarse en una lista anidada

        Assert.assertEquals(tarea1, incomingList.getTask(0));
        Assert.assertEquals(tarea2, incomingList.getTask(1));

        Assert.assertTrue(incomingList.remove(tarea1));

        Assert.assertEquals(tarea2, incomingList.getTask(0));
    }

    @Test
    public void getIndex_Test()throws Exception{

        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas
        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        Assert.assertEquals(0, list.getIndex(tarea1));
        Assert.assertEquals(1, list.getIndex(tarea2));

        list.remove(tarea1);

        Assert.assertEquals(0, list.getIndex(tarea2));

        list.remove(tarea2);

        Assert.assertEquals(-1, list.getIndex(tarea2));
    }

    @Test
    public void iterator_Test(){
        LinkedTaskList list = new LinkedTaskList();     //Declarando un nueva lista anidada de todas las tareas
        list.add(tarea1);   //Añadiendo tarea a la lista anidada
        list.add(tarea2);   //Añadiendo tarea a la lista anidada

        Iterator iteradorLinked = list.iterator();

        Assert.assertTrue(iteradorLinked.hasNext());
        Assert.assertEquals(tarea1, iteradorLinked.next());
        iteradorLinked.remove();

        Assert.assertTrue(iteradorLinked.hasNext());
        Assert.assertEquals(tarea2, iteradorLinked.next());
        iteradorLinked.remove();

        Assert.assertFalse(iteradorLinked.hasNext());
    }
}
