package com.bsuir.dao.entity;

/**
 * Created by Егор on 03.05.17.
 */
public class Report {
    private String date;
    private String time;
    private int leftLabs;
    private String projectName;
    private int taskid;

    public Report(String date, String time, int leftLabs, String projectName, int taskid) {
        this.date = date;
        this.time = time;
        this.leftLabs = leftLabs;
        this.projectName = projectName;
        this.taskid = taskid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLeftLabs() {
        return leftLabs;
    }

    public void setLeftLabs(int leftLabs) {
        this.leftLabs = leftLabs;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;

        Report report = (Report) o;

        if (leftLabs != report.leftLabs) return false;
        if (taskid != report.taskid) return false;
        if (date != null ? !date.equals(report.date) : report.date != null) return false;
        if (time != null ? !time.equals(report.time) : report.time != null) return false;
        return projectName != null ? projectName.equals(report.projectName) : report.projectName == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + leftLabs;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + taskid;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Report{");
        sb.append("date='").append(date).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append(", leftLabs=").append(leftLabs);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", taskid=").append(taskid);
        sb.append("}\n");
        return sb.toString();
    }
}
