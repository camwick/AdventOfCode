package com.camwick.solution.y2016;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;
import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2016.day1.Day1Part1;

public class SolutionManager2016 extends SolutionManager {
    private List<ProblemSolution> solutions;

    public SolutionManager2016(boolean test) throws ClientProtocolException, IOException {
        super("2016");

        if (test) {
            // run with example tests
        } else {
            // run with regular input
        }

        solutions.add(new Day1Part1());
    }
}
