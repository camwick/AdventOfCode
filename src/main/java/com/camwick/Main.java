package com.camwick;

import java.util.Scanner;

import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2016.SolutionManager2016;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Running...");
        System.out.print("Year: ");
        String year = sc.nextLine().trim();

        System.out.print("\nDay: ");
        String day = sc.nextLine().trim();

        System.out.print("\nUse example tests? [Y/N] (Default yes): ");
        String testInput = sc.nextLine().toUpperCase();

        boolean test = true;
        if (testInput.equals("N"))
            test = false;

        SolutionManager solutionManager = null;
        try {
            switch (year) {
                case "2016":
                    solutionManager = new SolutionManager2016(test);
                    break;
                default:
                    System.out.println(String.format("Solutions for %s do not exist yet", year));
                    System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        solutionManager.runSolutionForDay(day);

        sc.close();
    }
}
