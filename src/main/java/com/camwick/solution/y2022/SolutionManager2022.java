package com.camwick.solution.y2022;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2022.day1.*;

public class SolutionManager2022 extends SolutionManager{
    public SolutionManager2022(boolean test, String fileName) throws ClientProtocolException, IOException{
        super("2022");

        // add solutions to manager here...
        this.solutions.add(new Day1Part1(test, fileName));
        this.solutions.add(new Day1Part2(test, fileName));
    }
}
