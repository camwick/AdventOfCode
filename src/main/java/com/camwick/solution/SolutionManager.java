package com.camwick.solution;

import java.util.ArrayList;
import java.util.List;

public abstract class SolutionManager {
    private String year;
    protected List<ProblemSolution> solutions;

    public SolutionManager(String year) {
        this.year = year;
        this.solutions = new ArrayList<>();
    }

    public String getYear() {
        return this.year;
    }

    public void runSolutionForDay(String day){
        for (ProblemSolution solution : this.solutions){
            if (solution.getDay().equals(day)){
                solution.solve();
                System.out.println("\n");
            }
        }
    }
}
