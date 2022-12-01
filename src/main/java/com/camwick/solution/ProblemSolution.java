package com.camwick.solution;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;

import com.camwick.Util.InputUtil;
import com.camwick.Util.TimerUtil;

public abstract class ProblemSolution {
    private final String year, day, part;
    protected Scanner testScanner;
    protected TimerUtil timer;

    public ProblemSolution(String year, String day, String part) throws ClientProtocolException, IOException {
        this.year = year;
        this.day = day;
        this.part = part;

        InputUtil input = new InputUtil();
        input.sendGet(this.year, this.day);
        this.testScanner = new Scanner(
                new File(String.format("./src/main/resources/input/y%s/day%s/input.txt", this.year, this.day)));

        this.timer = new TimerUtil();
    }

    public String getYear() {
        return this.year;
    }

    public String getDay() {
        return this.day;
    }

    public String getPart() {
        return this.part;
    }

    public abstract void solve(Scanner sc);
}