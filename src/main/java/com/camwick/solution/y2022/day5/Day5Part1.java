package com.camwick.solution.y2022.day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day5Part1 extends ProblemSolution {

    public Day5Part1(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "5", "1", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        // parse input
        List<String> stackStuff = new ArrayList<>();
        List<Integer> commands = new ArrayList<>();
        while (this.sc.hasNextLine()) {
            String line = this.sc.nextLine();

            if (line.equals(""))
                continue;

            if (line.charAt(0) != 'm') {
                stackStuff.add(line);
            } else {
                String[] commandParts = line.split(" ");
                commands.add(Integer.parseInt(commandParts[1]));
                commands.add(Integer.parseInt(commandParts[3]));
                commands.add(Integer.parseInt(commandParts[5]));
            }
        }

        // put crates in proper stacks
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < Character.getNumericValue(
                stackStuff.get(stackStuff.size() - 1).charAt(stackStuff.get(stackStuff.size() - 1).length() - 2)); i++)
            stacks.add(new Stack<Character>());

        for (int i = stackStuff.size() - 2; i >= 0; i--) {
            for (int j = 0; j < stackStuff.get(i).length(); j += 4) {
                if (stackStuff.get(i).charAt(j) == '[') {
                    // calculate the crate position using char index
                    int index = stackStuff.get(i).indexOf('[', j) / 4;
                    stacks.get(index).add(stackStuff.get(i).charAt(j + 1));
                }
            }
        }

        // start solution finally...
        this.timer.startTimer();

        for (int i = 0; i < commands.size(); i += 3) {
            int quantity = commands.get(i);
            int fromIndex = commands.get(i + 1) - 1;
            int toIndex = commands.get(i + 2) - 1;

            for (int j = 0; j < quantity; ++j)
                stacks.get(toIndex).add(stacks.get(fromIndex).pop());
        }

        // get answer from tops of each stack
        StringBuilder ans = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            if (!stack.empty())
                ans.append(stack.pop());
        }

        this.timer.endTimer();

        System.out.println("Top Crates: " + ans);
        this.timer.printElapsedTime();
    }
}
