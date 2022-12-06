package com.camwick.solution.y2022.day1;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day1Part1 extends ProblemSolution {
    public Day1Part1(boolean test, String fileName, String currentDay) throws ClientProtocolException, IOException {
        super("2022", "1", "1", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        this.timer.startTimer();

        int total = 0;
        int max = Integer.MIN_VALUE;

        while (this.sc.hasNextLine()) {
            String line = this.sc.nextLine();

            if (line.equals("")) {
                if (total > max)
                    max = total;

                total = 0;
                continue;
            }

            total += Integer.valueOf(line);
        }
        this.timer.endTimer();

        System.out.println("Calories: " + max);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }
}
