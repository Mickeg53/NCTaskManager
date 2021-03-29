package mx.edu.j2se.GarciaSantamaria.tasks;
import java.util.Iterator;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public abstract AbstractTaskList incoming(int from, int to);

    public abstract int getIndex(Task task);
    
    public abstract Stream<Task> getStream();




}
