package com.camwick;

import java.util.Scanner;

import com.camwick.solution.SolutionManager;
import com.camwick.solution.y2016.SolutionManager2016;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Running...");
        System.out.print("Year: ");
        String year = sc.nextLine();

        System.out.print("\nDay: ");
        String day = sc.nextLine();

        System.out.print("\nUse example tests? [Y/N] (Default yes): ");
        String testInput = sc.nextLine().toUpperCase();

        boolean test = true;
        if (testInput.length() > 0 && !testInput.equals("Y"))
            test = false;

        // try {
        // switch (year) {
        // case "2016":
        // SolutionManager solutionManager = new SolutionManager2016();
        // break;
        // default:
        // System.out.println(String.format("Solutions for %s do not exist yet", year));
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        sc.close();
    }
}
