package mx.edu.j2se.GarciaSantamaria.tasks.tests;

import mx.edu.j2se.GarciaSantamaria.tasks.ArrayTaskList;
import mx.edu.j2se.GarciaSantamaria.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class ArrayTaskList_Tests {

    Task tarea1 = new Task("Lavar trastes", 20);
    Task tarea2 = new Task("Hacer ejercicio", 30, 50, 10);

    ArrayTaskList arrayOfTasks = new ArrayTaskList();       //Declaración de objeto arregloDeTareas del tipo ArrayTaskList

    public ArrayTaskList_Tests() throws Exception {
    }

    @Test
    public void add_remove_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);
        arrayOfTasks.add(tarea2);


        Assert.assertEquals(0, arrayOfTasks.getIndex(tarea1));
        Assert.assertEquals(1, arrayOfTasks.getIndex(tarea2));
        Assert.assertEquals(tarea2, arrayOfTasks.getTask(2));

        arrayOfTasks.remove(tarea2);
        Assert.assertEquals(-1, arrayOfTasks.getIndex(tarea2));
        Assert.assertFalse(arrayOfTasks.remove(tarea2));
        Assert.assertTrue(arrayOfTasks.remove(tarea1));

    }

    @Test
    public void size_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);
        Assert.assertEquals(2, arrayOfTasks.size());

        arrayOfTasks.add(tarea2);
        Assert.assertEquals(3, arrayOfTasks.size());

        arrayOfTasks.remove(tarea1);
        arrayOfTasks.remove(tarea2);
        Assert.assertEquals(0, arrayOfTasks.size());
    }

    @Test
    public void getTask_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);

        Assert.assertEquals(tarea1, arrayOfTasks.getTask(0));
        Assert.assertEquals("Hacer ejercicio", arrayOfTasks.getTask(1).getTitle());

        try{
            Assert.assertEquals("Hacer ejercicio", arrayOfTasks.getTask(2).getTitle());
        }catch(IndexOutOfBoundsException d){
            Assert.assertEquals("2",d.getMessage());
        }
    }

    @Test
    public void getIndex_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);

        Assert.assertEquals(1,arrayOfTasks.getIndex(tarea2));
        Assert.assertEquals(0,arrayOfTasks.getIndex(tarea1));
    }

    @Test
    public void incoming_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);

        tarea1.setActive(true);
        tarea2.setActive(true);

        ArrayTaskList c = (ArrayTaskList) arrayOfTasks.incoming(15,50);

        Assert.assertEquals(tarea1,c.getTask(0));
        Assert.assertEquals(tarea2,c.getTask(1));

        ArrayTaskList d = (ArrayTaskList) arrayOfTasks.incoming(21,50);

        Assert.assertEquals(tarea2,d.getTask(0));
    }

    @Test
    public void iterator_Test() throws Exception{
        arrayOfTasks.add(tarea1);
        arrayOfTasks.add(tarea2);

        Iterator iterador = arrayOfTasks.iterator();

        Assert.assertTrue(iterador.hasNext());
        Assert.assertEquals(tarea1, iterador.next());

        iterador.remove();

        Assert.assertEquals(tarea2, iterador.next());
    }
}
