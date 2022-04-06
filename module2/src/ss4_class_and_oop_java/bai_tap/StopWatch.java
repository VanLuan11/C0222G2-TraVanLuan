package ss4_class_and_oop_java.bai_tap;


import java.time.LocalTime;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime = System.currentTimeMillis();
    }


    public long getStartTime(){
        return this.startTime;
    }

    public long getEndTime(){
        return this.endTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return (this.startTime -this.endTime );
    }
}