package com.camwick.solution.y2022.day6;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day6Part2 extends ProblemSolution {

    public Day6Part2(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "6", "2", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        this.timer.startTimer();

        int endOfMarker = 0;
        while (this.sc.hasNextLine()) {
            String buffer = this.sc.nextLine();

            for (int i = 0; i < buffer.length() - 14; i++) {
                String bufferSubString = buffer.substring(i, i + 14);
                if (hasDupes(bufferSubString))
                    continue;
                else {
                    endOfMarker = i + 14;
                    break;
                }
            }
        }

        this.timer.endTimer();

        System.out.println("End of marker index: " + endOfMarker);
        this.timer.printElapsedTime();
    }

    private boolean hasDupes(CharSequence x) {
        for (int i = 0; i < x.length(); ++i)
            for (int j = i + 1; j < x.length(); ++j)
                if (x.charAt(i) == x.charAt(j))
                    return true;
        return false;
    }
}
