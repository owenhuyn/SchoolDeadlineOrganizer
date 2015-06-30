package com.example.owenhuyn.schooldeadlineorganizer;

import java.util.ArrayList;

/**
 * Created by owenhuyn on 15-06-10.
 */
public class course {
    public String name;
    public String courseCode;
    public ArrayList<Assignment> assignmentList;
    public Examination exam;
    public ArrayList<Test> testList;

    public course (String n, String c) {
        name = n;
        courseCode = c;
    }
}
