package com.camwick.solution.y2022.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import com.camwick.solution.ProblemSolution;

public class Day8Part1 extends ProblemSolution{

    public Day8Part1(boolean test, String fileName, String currentDay)
            throws ClientProtocolException, IOException {
        super("2022", "8", "1", test, fileName, currentDay);
    }

    @Override
    public void solve() {
        // parse input
        List<List<Integer>> grid = new ArrayList<>();
        while(this.sc.hasNextLine()){
            String line = this.sc.nextLine();
            List<Integer> gridLine = new ArrayList<>();

            for(int i = 0; i < line.length(); ++i){
                gridLine.add(Character.getNumericValue(line.charAt(i)));
            }

            grid.add(gridLine);
        }

        // create boolean array for tree visibility
        boolean[][] visibleTrees = new boolean[grid.size()][grid.get(0).size()];
        for(int i = 0; i < visibleTrees.length; ++i){
            for(int j = 0; j < visibleTrees[0].length; ++j){
                if(i == 0 || i == visibleTrees.length-1){
                    visibleTrees[i][j] = true;
                    continue;
                }
                
                if(j == 0 || j == visibleTrees[0].length-1){
                    visibleTrees[i][j] = true;
                    continue;
                }
            }
        }
        
        // find visible trees
        for(int i = 1; i < grid.size() - 1; ++i){
            int tallest = grid.get(i).get(0);
            for(int j = 1; j < grid.get(0).size() - 1; ++j){              
                if(tallest == 9)
                    break;
                
                if(grid.get(i).get(j) > tallest){
                    visibleTrees[i][j] = true;
                    tallest = grid.get(i).get(j);
                }
            }
        }

        for(int i = grid.size()-2; i > 0; --i){
            int tallest = grid.get(i).get(grid.get(i).size()-1);
            for(int j = grid.get(i).size()-2; j > 0; --j){
                if(tallest == 9)
                    break;
                
                if(grid.get(i).get(j) > tallest){
                    visibleTrees[i][j] = true;
                    tallest = grid.get(i).get(j);
                }
            }
        }

        for(int j = 1; j < grid.size() - 1; ++j){
            int tallest = grid.get(0).get(j);
            for(int i = 1; i < grid.get(0).size() - 1; ++i){
                if(tallest == 9)
                    break;
                
                if(grid.get(i).get(j) > tallest){
                    visibleTrees[i][j] = true;
                    tallest = grid.get(i).get(j);
                }
            }
        }
        
        for(int j = grid.size()-2; j > 0; --j){
            int tallest = grid.get(grid.size()-1).get(j);
            for(int i = grid.get(j).size()-2; i > 0; --i){
                if(tallest == 9)
                    break;
                
                if(grid.get(i).get(j) > tallest){
                    visibleTrees[i][j] = true;
                    tallest = grid.get(i).get(j);
                }
            }
        }

        int numVisTrees = countTrue(visibleTrees);

        System.out.println(numVisTrees);
    }

    // count true values
    public int countTrue(boolean[][] arr){
        int sum = 0;
        for (boolean[] line : arr) {
            for (boolean x : line) {
                if(x)
                    sum++;
            }
        }
        return sum;
    }
}
