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

      /*  AbstractTaskList inc = null;

        Stream<Task> incomingTask = null;

        if(this instanceof  LinkedTaskList){
            LinkedTaskList objLinked = (LinkedTaskList) this;
            incomingTask = objLinked.getStream();
            inc = new LinkedTaskList();
            System.out.println("Ingresó a LinkedTaskList");
        }
        if(this instanceof ArrayTaskList){
            ArrayTaskList objArray = (ArrayTaskList) this;
            incomingTask = objArray.getStream();
            inc = new ArrayTaskList();
            System.out.println("Ingresó a ArrayTaskList");
        }

        System.out.println(incomingTask.toString());


        //assert false;
        incomingTask.filter((Task task) ->
            (task.isActive() &&
                    (((task.time.isAfter(from) || task.time.isEqual(from)) && (task.time.isBefore(to) || task.time.isEqual(to)) && !task.repetitive)
                    || ((!task.start.isAfter(to) || !task.end.isBefore(from)) && task.repetitive))))
        .forEach(System.out::println);

        return inc;*/
    };

}