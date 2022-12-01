package com.camwick.solution.y2016.day1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day1Part1 extends ProblemSolution {
    public Day1Part1() throws ClientProtocolException, IOException {
        super("2016", "1", "1");
    }

    @Override
    public void solve() {
        // parsing data
        String line = this.sc.nextLine().trim();
        List<String> sequence = Arrays.asList(line.split(" "));

        this.timer.startTimer();

        int x = 0;
        int y = 0;
        char facing = 'N';

        for (int i = 0; i < sequence.size(); ++i) {
            // get next sequence command
            String command = sequence.get(i);
            char turn = command.charAt(0);
            int pace = Character.getNumericValue(turn);

            switch (facing) {
                case 'N':
                    if (turn == 'R')
                        x += pace;
                    else
                        x -= pace;
                    break;
                case 'S':
                    if (turn == 'R')
                        x -= pace;
                    else
                        x += pace;
                    break;
                case 'W':
                    if (turn == 'R')
                        y += pace;
                    else
                        y -= pace;
                    break;
                case 'E':
                    if (turn == 'R')
                        y -= pace;
                    else
                        y += pace;
                    break;
            }

            // change direction
            facing = changeDirection(facing, turn);
        }

        // get distance
        int distance = Math.abs(x) + Math.abs(y);

        this.timer.endTimer();

        System.out.println("\nBlocks away: " + distance);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }

    private char changeDirection(char facing, char turn) {
        if (facing == 'N')
            if (turn == 'R')
                return 'E';
            else
                return 'W';
        else if (facing == 'E')
            if (turn == 'R')
                return 'S';
            else
                return 'N';
        else if (facing == 'S')
            if (turn == 'R')
                return 'W';
            else
                return 'E';
        else if (turn == 'R')
            return 'N';
        else
            return 'S';
    }
}
