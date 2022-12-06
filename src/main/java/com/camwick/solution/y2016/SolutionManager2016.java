package com.camwick.solution.y2016;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;
import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2016.day1.Day1Part1;

public class SolutionManager2016 extends SolutionManager {
    public SolutionManager2016(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2016");

        this.solutions.add(new Day1Part1(test, fileName, currentDay));
    }

    @Override
    public void runSolutionForDay(String day) {
        for (ProblemSolution solution : this.solutions) {
            if (solution.getDay().equals(day))
                solution.solve();
        }
    }
}
