package mx.edu.j2se.GarciaSantamaria.tasks;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;


public class TaskIO {
    static void write(AbstractTaskList tasks, OutputStream out) throws IOException {

        DataOutput dataOutput = new DataOutputStream(out);
        dataOutput.write(tasks.size());

        tasks.forEach(s ->{
                try {
                    dataOutput.write(s.getTitle().length());
                    dataOutput.writeChars(s.getTitle());
                    dataOutput.writeBoolean(s.isActive());
                    dataOutput.writeBoolean(s.isRepeated());

                    if(s.isRepeated()){
                        dataOutput.writeInt(s.getRepeatInterval());
                        dataOutput.writeInt(Integer.parseInt(s.getStartTime().toString()));
                        dataOutput.writeInt(Integer.parseInt(s.getEndTime().toString()));
                    }else{
                        dataOutput.writeInt(Integer.parseInt(s.getTime().toString()));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

        });
        out.close();
    }
    static void read(AbstractTaskList tasks, InputStream in){
        try{
            Task readTask;
            DataInput input = new DataInputStream(in);
            int sizeOfInputStream = input.readInt();
            String taskTitle = "";

            for(int i=0; i < sizeOfInputStream; i++){
                int length = input.readInt();
                for(int j=0; j < length; j++){
                    taskTitle = taskTitle + String.valueOf(input.readChar());
                }
            }

            boolean isActive = input.readBoolean();
            boolean isRepetitive = input.readBoolean();

            if(isRepetitive){
                int interval = input.readInt();

                String startt = String.valueOf(input.readInt());
                String endd = String.valueOf(input.readInt());

                LocalDateTime start = LocalDateTime.parse(startt);
                LocalDateTime end = LocalDateTime.parse(endd);

                readTask = new Task(taskTitle, start, end, interval);
            }else{
                String getTimee = String.valueOf(input.readInt());
                LocalDateTime time = LocalDateTime.parse(getTimee);

                readTask = new Task(taskTitle, time);
            }
            readTask.setActive(isActive);
            tasks.add(readTask);

        }catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void writeBinary(AbstractTaskList tasks, File file) throws IOException {
        OutputStreamWriter outputStream = new FileWriter(file);
        outputStream.write(tasks.size());
        tasks.forEach(s ->{

            try {
                outputStream.write(s.getTitle().length());
                outputStream.write(s.getTitle());
                outputStream.write(s.isActive() ? 1:0);
                outputStream.write(s.isRepeated() ? 1:0);

                if(s.isRepeated()){
                    outputStream.write(s.getRepeatInterval());
                    outputStream.write(s.getStartTime().toString());
                    outputStream.write(s.getEndTime().toString());
                }else{
                    outputStream.write(s.getTime().toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    static void readBinary(AbstractTaskList tasks, File file) throws Exception {
        InputStreamReader input = new FileReader(file);
        int size = input.read();
        String taskTitle = "";
        Task readBinaryTask;

        for(int i=0; i < size; i++){
            int length = input.read();
            for(int j=0; j < length; j++){
                taskTitle = taskTitle + String.valueOf(input.read());
            }
        }
        boolean isActive = input.read() == 1;
        boolean isRepetitive = input.read() == 1;

        if (isRepetitive) {
            int interval = input.read();

            String startt = String.valueOf(input.read());
            String endd = String.valueOf(input.read());

            LocalDateTime start = LocalDateTime.parse(startt);
            LocalDateTime end = LocalDateTime.parse(endd);
            readBinaryTask = new Task(taskTitle, start, end, interval);
        }else{
            String getTime = String.valueOf(input.read());
            LocalDateTime time = LocalDateTime.parse(getTime);
            readBinaryTask = new Task(taskTitle, time);
        }
    }

    static void write(AbstractTaskList tasks, Writer out){
        Gson gson = new Gson();

    }
    static void read(AbstractTaskList tasks, Reader in){

    }
    static void writeText(AbstractTaskList tasks, File file){

    }
    static void readText(AbstractTaskList tasks, File file){

    }
}
