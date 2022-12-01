package com.camwick.Util;

import java.time.Duration;

public class TimerUtil {
    private long start;
    private long end;

    public void startTimer() {
        this.start = System.nanoTime();
    }

    public void endTimer() {
        this.end = System.nanoTime();
    }

    public long getElapsedTime() {
        long elapsed = this.end - this.start;

        return Duration.ofNanos(elapsed).toMillis();
    }
}