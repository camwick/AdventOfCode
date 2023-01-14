package com.camwick.solution.y2022.day10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day10Part1 extends ProblemSolution{

    public Day10Part1(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "10", "1", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        this.timer.startTimer();
        
        int cycle = 0;
        int x = 1;
        List<Instruction> instructions = new ArrayList<>();
        boolean first20 = false;
        List<Integer> signals = new ArrayList<>();
        
        while(this.sc.hasNextLine()){
            // read in instruction
            String line = this.sc.nextLine().trim();
            String[] lineParts = line.split(" ");

            // create a list of instruction objects
            switch(lineParts[0]){
                case "noop":
                    instructions.add(new Instruction(0, 1));
                    break;
                case "addx":
                    instructions.add(new Instruction(Integer.parseInt(lineParts[1]), 2));
                    break;
            }
        }

        // loop through all the instructions
        // increment cycle number and add the necessary amount
        while(!instructions.isEmpty()){
            cycle++;

            if(cycle == 20 && !first20){
                signals.add(x);
                first20 = true;
            }
            else if((cycle - 20) % 40 == 0){
                signals.add(x);
            }

            for(int i = 0; i < instructions.size(); ++i){
                instructions.get(i).cycle();

                if(instructions.get(i).getCycle() == 0){
                        x += instructions.get(i).getAddAmount();   
                    instructions.remove(i);               
                }
            }
        }

        System.out.println(x);

        for(int signal : signals)
            System.out.println("Signal: " + signal);

        this.timer.endTimer();

        System.out.println("Signal Strength: ");
        this.timer.printElapsedTime();
    }

    private class Instruction{
        private int addAmount;
        private int cycle;

        public Instruction(int amount, int cycle){
            this.addAmount = amount;
            this.cycle = cycle;
        }

        public int getCycle(){
            return this.cycle;
        }

        public int getAddAmount(){
            return this.addAmount;
        }

        public void cycle(){
            this.cycle--;
        }
    }
}
