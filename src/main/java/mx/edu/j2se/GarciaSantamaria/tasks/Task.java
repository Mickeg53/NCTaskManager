package mx.edu.j2se.GarciaSantamaria.tasks;

import java.time.LocalDateTime;

public class Task {
    String title;   //Variable para guardar el título de la tarea
    LocalDateTime time;   //Variable para guardar el tiempo de ejecución de tareas no repetitivas
    LocalDateTime start;  //Variable para guardar el tiempo de inicio de tareas repetitivas
    LocalDateTime end;    //Variable para guardar el tiempo de término de tareas repetitivas
    int interval;   //Variable para guardar el intervalo entre ejecución de tareas repetitivas
    boolean active = false; //Variable para guardar el estado de la tarea.
    boolean repetitive = false;

    //Constructor de la clase Task que será usado para construir una tarea que se encuentra deshabilitada en
    // determinado tiempo  sin repetirse
    public Task (String title, LocalDateTime time) throws Exception{
        try{
            /*if(time.isBefore(LocalDateTime.now())){
                throw new IllegalArgumentException();
            }*/
            if(/*time.equals(LocalDateTime.now()) || time.isBefore(LocalDateTime.now()) ||*/ title.equals("") || title.equals(" ")) {
                throw new Exception();
            }else{
                    this.title=title;
                    this.time=time;
                    this.repetitive = false;
            }
        }catch(IllegalArgumentException d){
            System.out.println("***Ingrese unicamente números POSITIVOS para el campo tiempo***");
        }catch(Exception d){
            System.out.println("***No se pueden ingresar campos vacios o fechas pasadas***");
        }
    }

    //Constructor de la clase Task que será usado para construir una tarea que se activará durante
    // un intervalos de tiempo dentro de un rango de tiempo
    public Task (String title, LocalDateTime start, LocalDateTime end, int interval) throws Exception{
        try{
            /*if(start.isBefore(LocalDateTime.now()) || end.isBefore(LocalDateTime.now())){
                throw new IllegalArgumentException();
            }else*/ if(title.equals("")) {
                throw new Exception();
            }else if(end.isBefore(start)) {
                throw new IndexOutOfBoundsException();
            }else if((interval <= 0)) {
                throw new IllegalStateException();
            }else{
                this.title=title;
                this.interval=interval;
                this.start=start;
                this.end=end;
                this.repetitive = true;
            }
        }catch(IllegalArgumentException d) {
            System.out.println("***Ingrese una fecha válida o futura***");
        }catch(IndexOutOfBoundsException f){
            System.out.println("***La fecha de término no puede ser antes de la fecha de inicio***");
        }catch(IllegalStateException g){
            System.out.println("***El tiempo de intervalo es inválido***");
        }catch(Exception d){
            System.out.println("***NO se pueden ingresar campos vacios o iguales a cero***");
        }
    }

    //Metodos para obtener y agregar titulo a las tareas
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        try{
            if(title.equals("") || title.equals(" ") || title.equals("  ")){
                throw new IllegalStateException();
            }else{
                this.title = title;
            }
        }catch(IllegalStateException d){
            System.out.println("***Ingrese un título válido***");
        }
    }

    //Metodo para leer y modificar el estatus de la tarea (activa o inactiva)
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active=active;
    }

    //Métodos para leer y cambiar el tiempo de ejecución para TAREAS NO REPETITIVAS

    //Metodo para devolver el tiempo de inicio de una tarea
    public LocalDateTime getTime() {
        if (this.repetitive){    //Si la tarea es repetitiva
            return start;
        } else return time;
    }

    //Metodo para agregar un tiempo de ejecución de la tarea y volverla no repetitiva si se
    // trata de una tarea repetitiva
    public void setTime(LocalDateTime time) throws Exception{
        try{
            if (this.repetitive){    //Si la tarea es repetitiva
                this.start = null;
                this.end = null;
                this.interval = 0;
            }else if(time.isBefore(LocalDateTime.now()) || time.isEqual(LocalDateTime.now())){
                throw new IllegalArgumentException();
            }
            this.time=time;
        }catch (IllegalArgumentException d){
            System.out.println("***Ingrese una fecha válida o futura***");
        }

    }

    //Metodo para cambiar el tiempo de execución para TAREAS REPETITIVAS
    public void setTime(LocalDateTime start, LocalDateTime end, int interval) throws Exception{
        try{
            if(start.isBefore(LocalDateTime.now()) || end.isBefore(LocalDateTime.now())){
                throw new IllegalArgumentException();
            }else if(end.isBefore(start)) {
                throw new IndexOutOfBoundsException();
            }else if(interval <= 0) {
                throw new IllegalStateException();
            }else{
                this.start = start;
                this.end = end;
                this.interval = interval;
                this.time = null;
            }
        }catch(IllegalArgumentException d) {
            System.out.println("***Ingrese fechas válidas o posteriores a la actual***");
        }catch(IndexOutOfBoundsException f){
            System.out.println("***El tiempo de término no puede ser menor al tiempo de inicio***");
        }catch(IllegalStateException g){
            System.out.println("***El tiempo de intervalo es inválido***");
        }catch(Exception d){
            System.out.println("***NO se pueden ingresar campos vacios o iguales a cero***");
        }
    }

    //Metodos para leer y cambiar el tiempo de execución para TAREAS REPETITIVAS
            //int
    public LocalDateTime getStartTime(){
        if (this.repetitive){    //Si la tarea es repetitiva
            return start;
        }else return time;
    }
            //int
    public LocalDateTime getEndTime(){
        if (this.repetitive){    //Si la tarea es repetitiva
            return end;
        }else return time;
    }

    public int getRepeatInterval(){
        return interval;
    }

    //Metodo para consultar si una tarea es repetitiva
    public boolean isRepeated(){
        return this.repetitive;
    }

    //Metodo que regresa el siguiente tiempo de ejecución en una tarea repetitiva.
    //En caso de que la tarea llegue al último intervalo de ejecución regresará "-1".

    //Metodo que devuelve el siguiente tiempo de ejecución de tareas repetitivas.
    public LocalDateTime nextTimeAfter(LocalDateTime current){
        try{
            if(current.isBefore(start)) {
                throw new IllegalArgumentException();
            }

            LocalDateTime startTemp = start;

            if(this.active){
                if(this.repetitive && (this.end.isBefore(current) )||(!this.repetitive && (this.time.isBefore(current)))){
                    return null;
                }else if(this.repetitive){
                    while(current.compareTo(startTemp) > 0){
                        startTemp = startTemp.plusHours(interval);
                    }
                    if(!current.equals(end)){
                        return startTemp;
                    }

                }else if(!this.repetitive){
                    return this.time;
                }
            }else{
                return null;
            }
            /*LocalDateTime nextTime;

            if(this.active){
                if((this.repetitive && (this.end.isBefore(current) )||(!this.repetitive && (this.time.isBefore(current)))){
                    nextTime = null;
                }else if(this.repetitive){
                    int numOfIntervals = (this.end-this.start)/interval;
                    numOfIntervals = (current-(current%this.interval))/this.interval;
                    nextTime = (numOfIntervals+1)*this.interval;
                }else if(!this.repetitive){
                    nextTime = this.time;
                }
                return nextTime;
            }else{
                return -1;
            }*/
        }catch (IllegalArgumentException d){
            System.out.println("***Tiempo current inválido, es menor al tiempo de inicio***");
        }
        return null;
    }

    public String toString(){
        String temp;
        if(this.repetitive){
            temp = "\n Title: "+title+
                    "\t Start: "+start+
                    "\t End: "+end+
                    "\t Interval: "+interval+
                    "\t Active: "+active+
                    "\t Repetitive: "+repetitive;
        }else{
            temp = "\n Title: "+title+
                    "\t Time: "+time+
                    "\t Active: "+active+
                    "\t Repetitive: "+repetitive;
        }
        return temp;
    }

    public boolean equals(Object obj){
        if(obj == null || !(obj instanceof Task)){
            return false;
        }

        Task t = (Task) obj;

        if(!t.title.equals(this.title))
            return false;
        if(this.time != t.time)
            return false;
        if(this.start != t.start)
            return false;
        if (this.end != t.end)
            return false;
        if(this.interval != t.interval)
            return false;
    return true;
    }

    public int hashCode(){
        int hash = 1;
        for(int i = 0; i < title.length(); i++){
            char c = title.charAt(i);
            hash = hash * c;
        }
        return hash;
    }

    public Task cloneTask(){
        Task tempTask = this;
        return tempTask;
    }

}
