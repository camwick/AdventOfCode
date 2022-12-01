package com.camwick.solution.y2022;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;
import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2022.day1.Day1Part1;

public class SolutionManager2022 extends SolutionManager{
    public SolutionManager2022(boolean test) throws ClientProtocolException, IOException{
        super("2022", test);

        // add solutions to manager here...
        this.solutions.add(new Day1Part1(test));
    }

    @Override
    public void runSolutionForDay(String day){
        for (ProblemSolution solution : this.solutions){
            if (solution.getDay().equals(day))
                solution.solve();
        }
    }
}
