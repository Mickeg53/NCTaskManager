package mx.edu.j2se.GarciaSantamaria.tasks;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractTaskList implements Iterable<Task> {

    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public abstract int getIndex(Task task);
    
    public abstract Stream<Task> getStream();

    public AbstractTaskList incoming(int from, int to) throws CloneNotSupportedException {
        //List<Task> incomingTasks = this.getStream().filter((Task task) -> {return (task.isActive() &&((task.time >= from && task.time <= to && task.interval == 0)||((task.start >= from || task.end <= to) && task.interval != 0)}).collect(Collectors.toList());

        AbstractTaskList inc = null;

        Stream<Task> incomingTask = this.getStream();
        assert false;
        incomingTask.filter((Task task) ->
            (task.isActive() &&((task.time >= from && task.time <= to && task.interval == 0)
                    ||((task.start >= from || task.end <= to) && task.interval != 0))))
        .forEach(inc::add);

        return inc;
    };

}