package com.camwick.solution.y2022.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day3Part2 extends ProblemSolution {

    public Day3Part2(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "3", "2", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        // parse input
        List<String> rucksacks = new ArrayList<>();
        while (this.sc.hasNextLine()) {
            rucksacks.add(this.sc.nextLine());
        }

        this.timer.startTimer();

        // find common items
        List<Character> commonItems = new ArrayList<>();
        for (int i = 0; i <= rucksacks.size() - 3; i += 3) {
            commonItems.add(findCommonChar(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2)));
        }

        // compute sum of priority
        int sum = sumOfPriority(commonItems);

        this.timer.endTimer();

        System.out.println("Sum of priorities: " + sum);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }

    private char findCommonChar(String x, String y, String z) {
        char ans = 'a';

        List<Character> common = new ArrayList<>();
        for (int i = 0; i < x.length(); ++i) {
            for (int j = 0; j < y.length(); ++j) {
                if (x.charAt(i) == y.charAt(j))
                    common.add(x.charAt(i));
            }
        }

        for (int i = 0; i < common.size(); ++i) {
            for (int j = 0; j < z.length(); ++j) {
                if (common.get(i) == z.charAt(j))
                    return common.get(i);
            }
        }

        return ans;
    }

    private int sumOfPriority(List<Character> x) {
        int sum = 0;

        for (char item : x) {
            if (Character.isUpperCase(item)) {
                sum += (item - 65 + 27);
            } else {
                sum += (item - 97 + 1);
            }
        }

        return sum;
    }
}
