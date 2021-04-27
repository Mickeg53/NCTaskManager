package mx.edu.j2se.GarciaSantamaria.tasks;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public abstract int getIndex(Task task);

    public AbstractTaskList incoming(LocalDateTime from, LocalDateTime to) throws CloneNotSupportedException {
        Tasks incomingTasks = new Tasks();
        incomingTasks.calendar(this, from, to);

        System.out.println("Sigue Incoming");

        return (AbstractTaskList) incomingTasks.incoming(this,from, to);

    };

}