package com.example.owenhuyn.schooldeadlineorganizer;

import java.util.Date;

/**
 * Created by owenhuyn on 15-06-12.
 */
public class Assignment {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAssignedDate() {
        return AssignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        AssignedDate = assignedDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String name;
    public float weight;
    public Date AssignedDate;
    public Date DueDate;


}
