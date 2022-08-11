
package com.TracPro.calendar;

import com.TracPro.accounts.Project;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *Implements Inheritence concept of OOP
 *
 *Implements Runtime Polymorphism using method overloading
 */

public class ProjectTask extends Task {
    private String projectID;
    transient private Project project;

    private ArrayList<String> assigneeIDs;
   // transient private ArrayList<User> assignees;

    public ProjectTask(String name, LocalDateTime deadline, String creatorUsername,
                       String projectID, ArrayList<String> assigneeIDs) {
        super(name, deadline, creatorUsername);
        this.projectID = projectID;
        this.assigneeIDs = assigneeIDs;
    }

    public ProjectTask(String name, String details, LocalDateTime deadline, String creatorUsername, int priority,
                       String projectID, ArrayList<String> assigneeIDs) {
        super(name, details, deadline, creatorUsername, priority);
        this.projectID = projectID;
        this.assigneeIDs = assigneeIDs;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }



    public ArrayList<String> getAssigneeIDs() {
        return assigneeIDs;
    }

    public void setAssigneeIDs(ArrayList<String> assigneeIDs) {
        this.assigneeIDs = assigneeIDs;
    }
}
