package mx.edu.j2se.GarciaSantamaria.tasks.tests;

import mx.edu.j2se.GarciaSantamaria.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class TaskTests {

    @Test
    public void newNonRepetitiveTaskTest() throws Exception{
        try{
            Task tarea1 = new Task("Tarea 1", LocalDateTime.parse("2021-04-15T15:00:00"));  //Creacion de nuevo objeto de prueba tarea1
            Task tarea2 = new Task("", LocalDateTime.parse("2021-04-15T18:00:00"));  //Creacion de nuevo objeto de prueba tarea2
            Task tarea3 = new Task("Tarea 3",LocalDateTime.parse("2021-04-15T21:00:00"));  //Creacion de nuevo objeto de prueba tarea3

        }catch(IllegalArgumentException e){
            Assert.assertEquals("***Ingrese unicamente números POSITIVOS para el campo tiempo***",e.getMessage());
        }catch(Exception d){
            Assert.assertEquals("***No se pueden ingresar campos vacios o igual a cero***",d.getMessage());
        }
    }

    @Test
    public void newRepetitiveTaskTest() throws Exception{
        try{
            Task tarea1 = new Task("Tarea 1",LocalDateTime.parse("2021-04-15T-15:00:00"), LocalDateTime.parse("2021-04-15T15:00:00"), 1);  //Creacion de nuevo objeto de prueba tarea1
            Task tarea2 = new Task("",LocalDateTime.parse("2021-04-15T15:00:00"), LocalDateTime.parse("2021-04-15T16:00:00"), 1);  //Creacion de nuevo objeto de prueba tarea2
            Task tarea3 = new Task("Tarea 3",LocalDateTime.now(), LocalDateTime.parse("2021-04-15T15:00:00"), 0);  //Creacion de nuevo objeto de prueba tarea3
            Task tarea4 = new Task("Tarea 3",LocalDateTime.parse("2021-04-15T15:00:00"), LocalDateTime.parse("0000-00-00T00:00:00"), 1);  //Creacion de nuevo objeto de prueba tarea4

        }catch(IllegalArgumentException e){
            Assert.assertEquals("***Ingrese únicamente números POSITIVOS o mayores a CERO***",e.getMessage());
        }catch(IllegalStateException f){
            Assert.assertEquals("***El tiempo de intervalo es inválido***",f.getMessage());
        }catch(IndexOutOfBoundsException g){
            Assert.assertEquals("***El tiempo de término no puede ser menor al tiempo de inicio***",g.getMessage());
        }catch(Exception d){
            Assert.assertEquals("Text '2021-04-15T-15:00:00' could not be parsed at index 11",d.getMessage());
        }
    }

    @Test
    public void getTitle_setTitle_Test() throws Exception{
        try{
            Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"));
            Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"), 1);

            Assert.assertEquals("Lavar trastes", tarea1.getTitle());
            Assert.assertEquals("Hacer ejercicio", tarea2.getTitle());

            tarea1.setTitle("Lavar ropa");
            Assert.assertEquals("Lavar ropa", tarea1.getTitle());

            tarea2.setTitle(" ");

            tarea2.setTitle("Hacer lagartijas");
            Assert.assertEquals("Hacer lagartijas", tarea2.getTitle());

        }catch(IllegalStateException d){
            Assert.assertEquals("***Ingrese un título válido***", d.getMessage());
        }

    }

    @Test
    public void isActive_setActive_Test() throws Exception{
        Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"));
        Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"), 1);
        tarea2.setActive(true);

        Assert.assertEquals(false, tarea1.isActive());
        tarea1.setActive(true);
        Assert.assertEquals(true, tarea1.isActive());

        Assert.assertEquals(true, tarea2.isActive());
    }

    @Test
    public void getTime_setTime_Test() throws Exception{

        Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"));
        Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-15T18:00:00"), 1);
        Assert.assertEquals(true, tarea2.isRepeated());

        Assert.assertEquals(20, tarea1.getTime());
        tarea1.setTime(LocalDateTime.now());
        Assert.assertEquals(20, tarea1.getTime());
        tarea1.setTime(LocalDateTime.parse("2021-04-15T-18:00:00"));

        Assert.assertEquals(30, tarea2.getTime());
        tarea2.setTime(LocalDateTime.parse("2021-04-15T17:00:00"));
        Assert.assertEquals(40, tarea2.getTime());
        Assert.assertEquals(false, tarea2.isRepeated());

    }

    @Test
    public void getStartTime_getEndTime_setTime__getRepeatedIntervalTest() throws Exception{
        Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T15:00:00"), LocalDateTime.parse("2021-04-15T20:00:00"), 5);
        Task tarea2 = new Task("Hacer ejercicio", LocalDateTime.parse("2021-04-15T16:00:00"), LocalDateTime.parse("2021-04-16T16:00:00"), 12);

        Assert.assertEquals(LocalDateTime.parse("2021-04-15T15:00"), tarea1.getStartTime());
        Assert.assertEquals(LocalDateTime.parse("2021-04-15T16:00:00"), tarea2.getStartTime());

        Assert.assertEquals(LocalDateTime.parse("2021-04-15T20:00:00"), tarea1.getEndTime());
        Assert.assertEquals(LocalDateTime.parse("2021-04-16T16:00:00"), tarea2.getEndTime());

        Assert.assertEquals(5, tarea1.getRepeatInterval());
        Assert.assertEquals(12, tarea2.getRepeatInterval());

        tarea1.setTime(LocalDateTime.parse("2021-04-15T00:00:00"),LocalDateTime.parse("2021-04-15T19:00:00"),1);
        tarea2.setTime(LocalDateTime.parse("2021-04-15T16:00:00"),LocalDateTime.parse("2021-04-15T16:00:00"),1);
        tarea2.setTime(LocalDateTime.parse("2021-04-15T16:00:00"),LocalDateTime.parse("2021-04-15T18:00:00"),1);
    }

    @Test
    public void nextTimeAfter_Test() throws Exception{
        Task tarea1 = new Task("Lavar trastes", LocalDateTime.parse("2021-04-15T14:00:00"), LocalDateTime.parse("2021-04-15T16:00:00"), 1);

        try{
            tarea1.nextTimeAfter(LocalDateTime.parse("2021-04-15T13:00:00"));

        }catch (IllegalArgumentException d){
            Assert.assertEquals("***Tiempo current inválido, es menor al tiempo de inicio***", d.getMessage());
        }

        Assert.assertNull(tarea1.nextTimeAfter(LocalDateTime.parse("2021-04-15T14:30:00")));
        tarea1.setActive(true);
        Assert.assertEquals(LocalDateTime.parse("2021-04-15T15:00:00"), tarea1.nextTimeAfter(LocalDateTime.parse("2021-04-15T14:30:00")));
        Assert.assertNull(tarea1.nextTimeAfter(LocalDateTime.parse("2021-04-15T16:00:00")));
        Assert.assertEquals(LocalDateTime.parse("2021-04-15T16:00:00"), tarea1.nextTimeAfter(LocalDateTime.parse("2021-04-15T15:59:59")));

    }
}
