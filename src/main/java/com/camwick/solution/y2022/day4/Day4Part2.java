package com.camwick.solution.y2022.day4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day4Part2 extends ProblemSolution{

    public Day4Part2(boolean test, String fileName)
            throws ClientProtocolException, IOException {
        super("2022", "4", "2", test, fileName);
    }

    @Override
    public void solve() {
        // parse input
        List<List<Integer>> elfSections = new ArrayList<>();
        while(this.sc.hasNextLine()){
            String line = this.sc.nextLine();
            String[] parts = line.split(",|-");

            List<Integer> conversion = new ArrayList<>();
            for(String part : parts)
                conversion.add(Integer.parseInt(part));
            
            elfSections.add(conversion);
        }

        this.timer.startTimer();

        int count = 0;
        for(int i = 0; i < elfSections.size(); i++){
            List<Integer> pair = elfSections.get(i);
            
            if((pair.get(0) >= pair.get(2) 
                    && pair.get(0) <= pair.get(3))

                || (pair.get(1) >= pair.get(2) 
                    && pair.get(1) <= pair.get(3))

                || (pair.get(2) >= pair.get(0) 
                    && pair.get(2) <= pair.get(1))

                || (pair.get(3) >= pair.get(0) 
                    && pair.get(3) <= pair.get(1)))
                count++;    
        }

        this.timer.endTimer();
        System.out.println("Fully contained assignment pairs: " + count);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }
}
