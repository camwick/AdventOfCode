package com.camwick.solution.y2022.day3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day3Part1 extends ProblemSolution{

    public Day3Part1(boolean test, String fileName)
            throws ClientProtocolException, IOException {
        super("2022", "3", "1", test, fileName);
    }

    @Override
    public void solve() {
        // parse input
        List<String> rucksacks = new ArrayList<>();
        while(this.sc.hasNextLine()){
            rucksacks.add(this.sc.nextLine());
        }

        this.timer.startTimer();

        // find common items
        List<Character> commonItems = new ArrayList<>();
        for(String rucksack : rucksacks){
            String[] parts = {rucksack.substring(0, rucksack.length() / 2), rucksack.substring(rucksack.length() / 2)};
            commonItems.add(findCommonChar(parts[0], parts[1]));
        }   

        // compute sum of priority
        int sum = sumOfPriority(commonItems);

        this.timer.endTimer();

        System.out.println("Sum of prioritiens: " + sum);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }
   
    private char findCommonChar(String x, String y){
        char ans = 'a';

        for(int i = 0; i < x.length(); ++i){
            for(int j = 0; j < y.length(); ++j){
                if (x.charAt(i) == y.charAt(j))
                    return x.charAt(i);
            }
        }

        return ans;
    }

    private int sumOfPriority(List<Character> x){
        int sum = 0;

        for(char item : x){
            if(Character.isUpperCase(item)){
                sum += (item - 65 + 27);
            }
            else {
                sum += (item - 97 + 1);
            }
        }

        return sum;
    }
}
