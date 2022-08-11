package com.TracPro.gui.calendar;


import com.TracPro.calendar.PriorityComparator;
import com.TracPro.calendar.ProjectTask;
import com.TracPro.calendar.sync.ClientTaskSyncHandler;
import com.TracPro.gui.GUIUtil;
import com.TracPro.network.client.NetClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;

public class progressController{


    private ObservableList<ProjectTask> willDoList = FXCollections.observableArrayList();
    private ObservableList<ProjectTask> doingList = FXCollections.observableArrayList();
    private ObservableList<ProjectTask> doneList = FXCollections.observableArrayList();


    @FXML
    AnchorPane anchor;
    @FXML
    ProgressIndicator pie_chart;

    /**
     * Initilizes progress indicator pie chart each time when task is updated
     *
     */

    @FXML void initialize(){

        ClientTaskSyncHandler clientTaskSyncHandler = NetClient.getInstance().getClientTaskSyncHandler();
        resetItems();


        double willdo = willDoList.size();
        double doing = doingList.size();
        double done = doneList.size();

        double numerator = done;

        double denominator = doing + willdo + done ;

        double piechart_value = 0.0;

        if(done == 0.0)piechart_value=0.0;



        else {
            piechart_value = numerator/(double)denominator;
        }
        pie_chart.setMinHeight(500);
        pie_chart.setMinWidth(500);


        pie_chart.setProgress(piechart_value);





    }

    private void resetItems() {
        ClientTaskSyncHandler clientTaskSyncHandler = NetClient.getInstance().getClientTaskSyncHandler();
        ArrayList<ProjectTask> projectTasks = clientTaskSyncHandler.getTaskManager().getProjectTasks();

        willDoList.clear();
        doingList.clear();
        doneList.clear();

        for (ProjectTask task : projectTasks) {
            switch (task.getProgress()) {
                case willdo:
                    willDoList.add(task);
                    break;
                case doing:
                    doingList.add(task);
                    break;
                case done:
                    doneList.add(task);
                    break;
            }
        }

        FXCollections.sort(willDoList, new PriorityComparator());
        FXCollections.sort(doingList, new PriorityComparator());
        FXCollections.sort(doneList, new PriorityComparator());
    }



    public static Pane getRoot() throws IOException {
        Parent root = FXMLLoader.load(
                progressController.class.getResource("progress.fxml"));
        return (Pane) root;
    }





}
