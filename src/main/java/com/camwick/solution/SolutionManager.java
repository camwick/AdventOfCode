package com.camwick.solution;

public abstract class SolutionManager {
    private String year;

    public SolutionManager(String year) {
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }
}
