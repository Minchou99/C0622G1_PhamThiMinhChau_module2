package ss4_class_object.exercise.stopWatch;

import java.time.LocalTime;
import java.util.spi.LocaleServiceProvider;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch(){
        this.startTime=System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long start(){
        return this.startTime=System.currentTimeMillis();
    }

    public long stop(){
        return this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }
}
