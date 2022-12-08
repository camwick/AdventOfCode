package com.camwick.solution.y2022.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day8Part2 extends ProblemSolution {

    public Day8Part2(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "8", "2", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        // parse input
        List<List<Integer>> grid = new ArrayList<>();
        while (this.sc.hasNextLine()) {
            String line = this.sc.nextLine();
            List<Integer> gridLine = new ArrayList<>();

            for (int i = 0; i < line.length(); ++i) {
                gridLine.add(Character.getNumericValue(line.charAt(i)));
            }

            grid.add(gridLine);
        }

        this.timer.startTimer();

        int maxScenic = Integer.MIN_VALUE;
        for (int i = 1; i < grid.size() - 1; ++i) {
            for (int j = 0; j < grid.size(); ++j) {
                List<Integer> treeCounts = new ArrayList<>();

                // skip calculating edgs since scenic score will result in 0
                if (j == 0 || j == grid.size() - 1)
                    continue;

                // check for vertical tree sight
                int treeCount = 0;
                for (int y = i - 1; y >= 0; --y) {
                    if (grid.get(y).get(j) < grid.get(i).get(j))
                        treeCount++;
                    else if (grid.get(y).get(j) >= grid.get(i).get(j)) {
                        treeCount++;
                        treeCounts.add(treeCount);
                        break;
                    }

                    if (y == 0)
                        treeCounts.add(treeCount);
                }
                treeCount = 0;
                for (int y = i + 1; y < grid.size(); ++y) {
                    if (grid.get(y).get(j) < grid.get(i).get(j))
                        treeCount++;
                    else if (grid.get(y).get(j) >= grid.get(i).get(j)) {
                        treeCount++;
                        treeCounts.add(treeCount);
                        break;
                    }

                    if (y == grid.size() - 1)
                        treeCounts.add(treeCount);
                }

                // check for horizontal tree sight
                treeCount = 0;
                for (int x = j - 1; x >= 0; x--) {
                    if (grid.get(i).get(x) < grid.get(i).get(j))
                        treeCount++;
                    else if (grid.get(i).get(x) >= grid.get(i).get(j)) {
                        treeCount++;
                        treeCounts.add(treeCount);
                        break;
                    }

                    if (x == 0)
                        treeCounts.add(treeCount);
                }
                treeCount = 0;
                for (int x = j + 1; x < grid.size(); ++x) {
                    if (grid.get(i).get(x) < grid.get(i).get(j))
                        treeCount++;
                    else if (grid.get(i).get(x) >= grid.get(i).get(j)) {
                        treeCount++;
                        treeCounts.add(treeCount);
                        break;
                    }

                    if (x == grid.size() - 1)
                        treeCounts.add(treeCount);
                }

                // calculate scenic score
                int quotient = 1;
                for (int x : treeCounts)
                    quotient *= x;

                if (quotient > maxScenic)
                    maxScenic = quotient;
            }
        }

        this.timer.endTimer();

        System.out.println("Largest Scenic Score: " + maxScenic);
        this.timer.printElapsedTime();
    }
}
