package com.kharisma.inside.mandiri.sejahtera.kimsapp.Model;

public class ModelTask {
    private String taskDate, nameTask;

    public ModelTask(String taskDate, String nameTask) {
        this.taskDate = taskDate;
        this.nameTask = nameTask;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }
}
