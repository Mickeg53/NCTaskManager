package mx.edu.j2se.GarciaSantamaria.tasks;

public abstract class AbstractTaskList {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    /*public abstract Task[] incoming(int from, int to);

    public abstract LinkedTaskList incomingLinked(int from, int to);*/

}
