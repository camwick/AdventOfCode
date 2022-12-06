package com.camwick.solution.y2022.day1;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day1Part2 extends ProblemSolution {

    public Day1Part2(boolean test, String fileName, String currentDay) throws ClientProtocolException, IOException {
        super("2022", "1", "2", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        this.timer.startTimer();

        int total = 0;
        int[] max = new int[3];
        int minMax = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < 3; ++i)
            max[i] = Integer.MIN_VALUE;

        while (this.sc.hasNextLine()) {
            String line = this.sc.nextLine();

            if (line.equals("")) {
                if (max[0] < 0) {
                    max[0] = total;
                    if (total < minMax) {
                        minMax = total;
                        minIndex = 0;
                    }
                } else if (max[1] < 0) {
                    max[1] = total;
                    if (total < minMax) {
                        minMax = total;
                        minIndex = 1;
                    }
                } else if (max[2] < 0) {
                    max[2] = total;
                    if (total < minMax) {
                        minMax = total;
                        minIndex = 2;
                    }
                } else {
                    if (total > minMax) {
                        max[minIndex] = total;

                        minMax = Integer.MAX_VALUE;
                        for (int i = 0; i < 3; ++i) {
                            if (max[i] < minMax) {
                                minMax = max[i];
                                minIndex = i;
                            }
                        }
                    }
                }

                total = 0;
                continue;
            }

            total += Integer.valueOf(line);

            if (!this.sc.hasNextLine()) {
                if (total > minMax) {
                    max[minIndex] = total;

                    minMax = Integer.MAX_VALUE;
                    for (int i = 0; i < 3; ++i) {
                        if (max[i] < minMax) {
                            minMax = max[i];
                            minIndex = i;
                        }
                    }
                }
            }
        }
        int maxInt = totalMax(max);
        this.timer.endTimer();

        System.out.println("Calories: " + maxInt);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }

    private static int totalMax(int[] arr) {
        int total = 0;

        for (int x : arr)
            total += x;

        return total;
    }
}
