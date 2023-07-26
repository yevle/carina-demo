package ylevchenko.gfit.mobile.gui.perfomance;

public class Stopwatch {

    private Long startTime;

    private Long runningTime;

    private boolean isRunning = false;

    public Stopwatch() {
    }

    public Stopwatch(Long startTime, boolean isRunning) {
        this.startTime = startTime;
        this.isRunning = isRunning;
    }

    public static Stopwatch createStarted() {
        return new Stopwatch(System.currentTimeMillis(), true);
    }

    public Long stopAndGetRunningTime() {
        runningTime = System.currentTimeMillis()-startTime;
        isRunning = false;
        return runningTime;
    }

}
