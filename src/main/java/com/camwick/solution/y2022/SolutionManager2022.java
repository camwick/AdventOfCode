package com.camwick.solution.y2022;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2022.day1.Day1Part1;
import com.camwick.solution.y2022.day1.Day1Part2;
import com.camwick.solution.y2022.day10.Day10Part1;
import com.camwick.solution.y2022.day2.Day2Part1;
import com.camwick.solution.y2022.day2.Day2Part2;
import com.camwick.solution.y2022.day3.Day3Part1;
import com.camwick.solution.y2022.day3.Day3Part2;
import com.camwick.solution.y2022.day4.Day4Part1;
import com.camwick.solution.y2022.day4.Day4Part2;
import com.camwick.solution.y2022.day5.Day5Part1;
import com.camwick.solution.y2022.day5.Day5Part2;
import com.camwick.solution.y2022.day6.Day6Part1;
import com.camwick.solution.y2022.day6.Day6Part2;
import com.camwick.solution.y2022.day7.Day7Part1;
import com.camwick.solution.y2022.day7.Day7Part2;
import com.camwick.solution.y2022.day8.Day8Part1;
import com.camwick.solution.y2022.day8.Day8Part2;

public class SolutionManager2022 extends SolutionManager {
    public SolutionManager2022(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022");

        // add solutions to manager here...
        this.solutions.add(new Day1Part1(test, fileName, currentDay));
        this.solutions.add(new Day1Part2(test, fileName, currentDay));
        this.solutions.add(new Day2Part1(test, fileName, currentDay));
        this.solutions.add(new Day2Part2(test, fileName, currentDay));
        this.solutions.add(new Day3Part1(test, fileName, currentDay));
        this.solutions.add(new Day3Part2(test, fileName, currentDay));
        this.solutions.add(new Day4Part1(test, fileName, currentDay));
        this.solutions.add(new Day4Part2(test, fileName, currentDay));
        this.solutions.add(new Day5Part1(test, fileName, currentDay));
        this.solutions.add(new Day5Part2(test, fileName, currentDay));
        this.solutions.add(new Day6Part1(test, fileName, currentDay));
        this.solutions.add(new Day6Part2(test, fileName, currentDay));
        this.solutions.add(new Day7Part1(test, fileName, currentDay));
        this.solutions.add(new Day7Part2(test, fileName, currentDay));
        this.solutions.add(new Day8Part1(test, fileName, currentDay));
        this.solutions.add(new Day8Part2(test, fileName, currentDay));
        this.solutions.add(new Day10Part1(test, fileName, currentDay));
    }
}
