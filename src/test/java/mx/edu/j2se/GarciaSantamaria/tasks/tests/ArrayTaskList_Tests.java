package mx.edu.j2se.GarciaSantamaria.tasks.tests;

import mx.edu.j2se.GarciaSantamaria.tasks.ArrayTaskList;
import mx.edu.j2se.GarciaSantamaria.tasks.Task;
import mx.edu.j2se.GarciaSantamaria.tasks.Tasks;
import org.junit.Assert;
import org.junit.Test;
import java.time.*;

import java.util.Iterator;

public class ArrayTaskList_Tests {

    Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"));
    Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"), 1);

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

        //Tasks incomingList = new Tasks();

        ArrayTaskList c = (ArrayTaskList) arrayOfTasks.incoming(LocalDateTime.parse("2021-04-15T13:00:00"),LocalDateTime.parse("2021-04-15T18:01:00"));

        Assert.assertEquals(tarea1,c.getTask(0));
        Assert.assertEquals(tarea2,c.getTask(1));

        //ArrayTaskList d = (ArrayTaskList) arrayOfTasks.incoming(LocalDateTime.parse("2021-04-15T15:30:00"),LocalDateTime.parse("2021-04-15T18:00:00"));

        //Assert.assertEquals(tarea2,d.getTask(0));
        //Assert.assertNull(d.getTask(0));

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
