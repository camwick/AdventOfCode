package com.camwick.solution;

import java.util.ArrayList;
import java.util.List;

public abstract class SolutionManager {
    private String year;
    private boolean test;
    protected List<ProblemSolution> solutions;

    public SolutionManager(String year, boolean test) {
        this.year = year;
        this.test = test;
        this.solutions = new ArrayList<>();
    }

    public String getYear() {
        return this.year;
    }

    public abstract void runSolutionForDay(String day);
}
