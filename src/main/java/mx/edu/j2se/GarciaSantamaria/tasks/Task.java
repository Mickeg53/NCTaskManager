package mx.edu.j2se.GarciaSantamaria.tasks;

public class Task {
    String title;
    int time = 0;
    int start = 0;
    int end = 0;
    int interval = 0;
    boolean active = false;
    int current = 0;

    //Constructor de la clase Task que será usado para construir una tarea que se encuentra deshabilitada en
    // determinado tiempo  sin repetirse
    public Task (String title, int time){
        this.title=title;
        this.time=time;
    }

    //Constructor de la clase Task que será usado para construir una tarea que se activará durante
    // un intervalos de tiempo dentro de un rango de tiempo
    public Task (String title, int start, int end, int interval){
        this.title=title;
        this.interval=interval;
        this.start=start;
        this.end=end;
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

    //Metodo que se ejecutará cada que la alarma de la tarea llegue al tiempo de ejecución y así actualizar el tiempo start para tareas repetitivas.
    public int nextTimeAfter(int current){
        if((this.end - current) == 0){
            return -1;
        }else{
            this.start = current + this.interval;
            return (start);
        }
    }
}
