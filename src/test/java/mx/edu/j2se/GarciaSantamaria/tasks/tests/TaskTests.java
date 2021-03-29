package mx.edu.j2se.GarciaSantamaria.tasks.tests;

import mx.edu.j2se.GarciaSantamaria.tasks.Task;
import org.junit.Assert;
import org.junit.Test;

public class TaskTests {

    @Test
    public void newNonRepetitiveTaskTest() throws Exception{
        try{
            Task tarea1 = new Task("Tarea 1",-2);  //Creacion de nuevo objeto de prueba tarea1
            Task tarea2 = new Task("",30);  //Creacion de nuevo objeto de prueba tarea2
            Task tarea3 = new Task("Tarea 3",0);  //Creacion de nuevo objeto de prueba tarea3

        }catch(IllegalArgumentException e){
            Assert.assertEquals("***Ingrese unicamente números POSITIVOS para el campo tiempo***",e.getMessage());
        }catch(Exception d){
            Assert.assertEquals("***No se pueden ingresar campos vacios o igual a cero***",d.getMessage());
        }
    }

    @Test
    public void newRepetitiveTaskTest() throws Exception{
        try{
            Task tarea1 = new Task("Tarea 1",-2, 20, 3);  //Creacion de nuevo objeto de prueba tarea1
            Task tarea2 = new Task("",30, 40, 10);  //Creacion de nuevo objeto de prueba tarea2
            Task tarea3 = new Task("Tarea 3",0, 20, 0);  //Creacion de nuevo objeto de prueba tarea3
            Task tarea4 = new Task("Tarea 3",10, 0, 6);  //Creacion de nuevo objeto de prueba tarea4

        }catch(IllegalArgumentException e){
            Assert.assertEquals("***Ingrese únicamente números POSITIVOS o mayores a CERO***",e.getMessage());
        }catch(IllegalStateException f){
            Assert.assertEquals("***El tiempo de intervalo es inválido***",f.getMessage());
        }catch(IndexOutOfBoundsException g){
            Assert.assertEquals("***El tiempo de término no puede ser menor al tiempo de inicio***",g.getMessage());
        }catch(Exception d){
            Assert.assertEquals("***NO se pueden ingresar campos vacios o iguales a cero***",d.getMessage());
        }
    }

    @Test
    public void getTitle_setTitle_Test() throws Exception{
        try{
            Task tarea1 = new Task("Lavar trastes", 20);
            Task tarea2 = new Task("Hacer ejercicio", 30, 50, 10);

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
        Task tarea1 = new Task("Lavar trastes", 20);
        Task tarea2 = new Task("Hacer ejercicio", 30, 50, 10);
        tarea2.setActive(true);

        Assert.assertEquals(false, tarea1.isActive());
        tarea1.setActive(true);
        Assert.assertEquals(true, tarea1.isActive());

        Assert.assertEquals(true, tarea2.isActive());
    }

    @Test
    public void getTime_setTime_Test() throws Exception{

        Task tarea1 = new Task("Lavar trastes", 20);
        Task tarea2 = new Task("Hacer ejercicio", 30, 50, 10);
        Assert.assertEquals(true, tarea2.isRepeated());

        Assert.assertEquals(20, tarea1.getTime());
        tarea1.setTime(0);
        Assert.assertEquals(20, tarea1.getTime());
        tarea1.setTime(-10);

        Assert.assertEquals(30, tarea2.getTime());
        tarea2.setTime(40);
        Assert.assertEquals(40, tarea2.getTime());
        Assert.assertEquals(false, tarea2.isRepeated());

    }

    @Test
    public void getStartTime_getEndTime_setTime__getRepeatedIntervalTest() throws Exception{
        Task tarea1 = new Task("Lavar trastes", 20, 60, 5);
        Task tarea2 = new Task("Hacer ejercicio", 30, 50, 10);

        Assert.assertEquals(20, tarea1.getStartTime());
        Assert.assertEquals(30, tarea2.getStartTime());

        Assert.assertEquals(60, tarea1.getEndTime());
        Assert.assertEquals(50, tarea2.getEndTime());

        Assert.assertEquals(5, tarea1.getRepeatInterval());
        Assert.assertEquals(10, tarea2.getRepeatInterval());

        tarea1.setTime(-1,62,7);
        tarea2.setTime(32,30,12);
        tarea2.setTime(32,52,0);
    }

    @Test
    public void nextTimeAfter_Test() throws Exception{
        Task tarea1 = new Task("Lavar trastes", 10, 30, 5);

        try{
            tarea1.nextTimeAfter(-1);

        }catch (IllegalArgumentException d){
            Assert.assertEquals("***Tiempo current inválido***", d.getMessage());
        }

        Assert.assertEquals(-1, tarea1.nextTimeAfter(15));
        tarea1.setActive(true);
        Assert.assertEquals(20, tarea1.nextTimeAfter(15));
        Assert.assertEquals(-1, tarea1.nextTimeAfter(31));
    }
}
