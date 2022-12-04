package com.camwick.solution.y2022.day4;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day4Part1 extends ProblemSolution{

    public Day4Part1(boolean test, String fileName)
            throws ClientProtocolException, IOException {
        super("2022", "4", "1", test, fileName);
    }

    @Override
    public void solve() {
        this.timer.startTimer();

        int count = 0;
        while(this.sc.hasNextLine()){
            String section1 = this.sc.nextLine().trim();
            String[] elfSections = section1.split(",|-");
            
            if((Integer.parseInt(elfSections[0]) >= Integer.parseInt(elfSections[2]) 
                    && Integer.parseInt(elfSections[1]) <= Integer.parseInt(elfSections[3]))
                || (Integer.parseInt(elfSections[2]) >= Integer.parseInt(elfSections[0]) 
                    && Integer.parseInt(elfSections[3]) <= Integer.parseInt(elfSections[1])))
                count++;            
        }

        this.timer.endTimer();

        System.out.println("Fully contained assignment pairs: " + count);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }
}
