package com.camwick.solution.y2022.day2;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day2Part2 extends ProblemSolution{

    public Day2Part2(boolean test, String fileName)
            throws ClientProtocolException, IOException {
        super("2022", "2", "2", test, fileName);
    }

    @Override
    public void solve() {
        this.timer.startTimer();
        
        int score = 0;
        while (this.sc.hasNextLine()){
            String round = this.sc.nextLine().trim();
            char opp = round.charAt(0);
            char outcomeNeeded = round.charAt(2);

            // translate opponents move to match same scheme
            if (opp == 'A')
                opp = 'X';
            else if (opp == 'B')
                opp = 'Y';
            else 
                opp = 'Z';
            
            if (opp == 'X'){
                switch(outcomeNeeded){
                    case 'X':
                        score += 3 + 0;
                        break;
                    case 'Y':
                        score += 1 + 3;
                        break;
                    case 'Z':
                        score += 2 + 6;
                        break;
                }
            }
            else if (opp == 'Y'){
                switch(outcomeNeeded){
                    case 'X':
                        score += 1 + 0;
                        break;
                    case 'Y':
                        score += 2 + 3;
                        break;
                    case 'Z':
                        score += 3 + 6;
                        break;
                }
            }
            else {
                switch(outcomeNeeded){
                    case 'X':
                        score += 2 + 0;
                        break;
                    case 'Y':
                        score += 3 + 3;
                        break;
                    case 'Z':
                        score += 1 + 6;
                        break;
                }
            }
        }
        this.timer.endTimer(); 

        System.out.println("Score: " + score);
        System.out.println("Solution took " + this.timer.getElapsedTime() + "ms");
    }
}

// rock     A    lose X  1
// paper    B    draw Y  2
// scissors C    win  Z  3
// win      6
// loss     0
// draw     3
