package mx.edu.j2se.GarciaSantamaria.tasks;

public class Task {
    String title;   //Variable para guardar el título de la tarea
    int time = 0;   //Variable para guardar el tiempo de ejecución de tareas no repetitivas
    int start = 0;  //Variable para guardar el tiempo de inicio de tareas repetitivas
    int end = 0;    //Variable para guardar el tiempo de término de tareas repetitivas
    int interval = 0;   //Variable para guardar el intervalo entre ejecución de tareas repetitivas
    boolean active = false; //Variable para guardar el estado de la tarea.

    //Constructor de la clase Task que será usado para construir una tarea que se encuentra deshabilitada en
    // determinado tiempo  sin repetirse
    public Task (String title, int time){
        try{
            if(time < 0){
                throw new IllegalArgumentException();
            }
            if(time == 0 || title == "") {
                throw new Exception();
            }else{
                    this.title=title;
                    this.time=time;
            }
        }catch(IllegalArgumentException d){
            System.out.println("***Ingrese unicamente números POSITIVOS para el campo tiempo***");
        }catch(Exception d){
            System.out.println("***No se pueden ingresar campos vacios***");
        }
    }

    //Constructor de la clase Task que será usado para construir una tarea que se activará durante
    // un intervalos de tiempo dentro de un rango de tiempo
    public Task (String title, int start, int end, int interval) throws Exception{
        try{
            if(start < 0 || end < 0 || interval < 0){
                throw new IllegalArgumentException();
            }else if(start == 0 || end == 0 || title.equals("")) {
                throw new Exception();
            }else if(interval == 0){
                throw new IllegalArgumentException();
            }else{
                this.title=title;
                this.interval=interval;
                this.start=start;
                this.end=end;
            }
        }catch(IllegalArgumentException d) {
            System.out.println("***Ingrese únicamente números POSITIVOS o mayores a CERO***");
        }catch(Exception d){
            System.out.println("***NO se pueden ingresar campos vacios***");
        }
    }

    //Metodos para obtener y agregar titulo a las tareas
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
    public int getTime() {
        if (this.interval != 0){    //Si la tarea es repetitiva
            return start;
        } else return time;
    }

    //Metodo para agregar un tiempo de ejecución de la tarea y volverla no repetitiva si se
    // trata de una tarea repetitiva
    public void setTime(int time){
        if (this.interval != 0){    //Si la tarea es repetitiva
            this.start = 0;
            this.end = 0;
            this.interval = 0;
        }
        this.time=time;
    }

    //Metodos para leer y cambiar el tiempo de execución para TAREAS REPETITIVAS
    public int getStartTime(){
        if (this.interval == 0){    //Si la tarea no es repetitiva
            return time;
        }else return start;
    }

    public int getEndTime(){
        if (this.interval == 0){    //Si la tarea no es repetitiva
            return time;
        }else return end;
    }

    public int getRepeatInterval(){
        return interval;
    }

    //Metodo para cambiar el tiempo de execución para TAREAS REPETITIVAS
    public void setTime(int start, int end, int interval){
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.time = 0;
    }

    //Metodo para consultar si una tarea es repetitiva
    public boolean isRepeated(){
        return this.interval != 0;  //Sí el intervalo es diferente de 0 significa que es una tarea repetitiva
    }

    //Metodo que regresa el siguiente tiempo de ejecución en una tarea repetitiva.
    //En caso de que la tarea llegue al último intervalo de ejecución regresará "-1".

    //Metodo que devuelve el siguiente tiempo de ejecución de tareas repetitivas.
    public int nextTimeAfter(int current){

        int nextTime = 0;

        if((this.interval != 0 && (this.end - current) <= 0 )||(this.interval == 0 && (this.time - current <= 0))){
            nextTime = -1;
        }else if(this.interval != 0){
            int numOfIntervals = (this.end-this.start)/interval;
            numOfIntervals = (current-(current%this.interval))/this.interval;
            nextTime = (numOfIntervals+1)*this.interval;
        }else if(this.interval == 0){
            nextTime = this.time;
        }
        return nextTime;
    }

    public String toString(){
        String temp;
        if(interval == 0){
            temp = "\n Title: "+title+
                    "\n Time: "+time+
                    "\n Active: "+active;
        }else{
            temp = "\n Title: "+title+
                    "\n Start: "+start+
                    "\n End: "+end+
                    "\n Active: "+active;
        }
        return temp;
    }

}
