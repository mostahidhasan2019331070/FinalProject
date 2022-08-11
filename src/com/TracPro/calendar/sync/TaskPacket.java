package com.TracPro.calendar.sync;

import com.TracPro.accounts.User;
import com.TracPro.calendar.ProjectTask;
import com.TracPro.calendar.TaskManager;
import com.TracPro.network.Packet;

import java.util.Map;

/**
 * A container object for sending entire task manager,
 * task edit, add and remove commands over the network
 * @author Shibli Noman Sunny
 */
public class TaskPacket implements Packet {
    public String command;
    public TaskManager taskManager;
    public ProjectTask task;
    public Map<String, User> projectMemberInfo;

    public TaskPacket() {}

    public TaskPacket(String command, TaskManager taskManager, ProjectTask task, Map<String, User> projectMemberInfo) {
        this.command = command;
        this.taskManager = taskManager;
        this.task = task;
        this.projectMemberInfo = projectMemberInfo;
    }
}
