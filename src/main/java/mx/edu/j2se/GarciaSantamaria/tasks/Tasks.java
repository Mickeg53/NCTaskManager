package mx.edu.j2se.GarciaSantamaria.tasks;

import java.time.LocalDateTime;
import java.util.*;

public class Tasks {
    static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){

        AbstractTaskList listIncoming ;
        if (tasks instanceof LinkedTaskList) {
            listIncoming = new LinkedTaskList();
        }else{
            listIncoming = new ArrayTaskList();
        }

       for(Task task : tasks){
           if((task.isActive()/* &&
                    (((task.time.isAfter(from) || task.time.isEqual(from)) && (task.time.isBefore(to) || task.time.isEqual(to)) && !task.repetitive)
                    || ((!task.start.isAfter(to) || !task.end.isBefore(from)) && task.repetitive))*/)){
                listIncoming.add(task);
           }
       }
        System.out.println(listIncoming);
       return listIncoming;
    }

    static SortedMap<LocalDateTime, Set<Task>> calendar(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end){
        System.out.println("Comienza calendar");

        SortedMap<LocalDateTime, Set<Task>> sortedTasks = new TreeMap<LocalDateTime, Set<Task>>();
        Iterable<Task> tasksInc = incoming(tasks, start, end);
        Set<Task> set = new HashSet<Task> ();
        for(Task s : tasksInc){
            set.add(s);
            sortedTasks.put(start, set);
        }
        sortedTasks.forEach((d,t) -> System.out.println(d + "\t | \t"+ t));
        return sortedTasks;
    }
}
