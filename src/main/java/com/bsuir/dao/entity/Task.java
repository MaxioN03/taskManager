package com.bsuir.dao.entity;

/**
 * Created by Егор on 02.05.17.
 */
public class Task {

    //id ЗАДАЧИ
    private int id;
    private String projectName;
    private String taskName;
    //Трудоёмкость (часов)
    private int lab;
    //Запланированный ресурс (человек)
    private int resource;
    //Фактическая трудоёмкость
    private int factLab;
    //Сколько отсалось
    private int leftLab;

    public Task(int id, String projectName, String taskName, int lab, int resource, int factLab, int leftLab) {
        this.id = id;
        this.projectName = projectName;
        this.taskName = taskName;
        this.lab = lab;
        this.resource = resource;
        this.factLab = factLab;
        this.leftLab = leftLab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getFactLab() {
        return factLab;
    }

    public void setFactLab(int factLab) {
        this.factLab = factLab;
    }

    public int getLeftLab() {
        return leftLab;
    }

    public void setLeftLab(int leftLab) {
        this.leftLab = leftLab;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (lab != task.lab) return false;
        if (resource != task.resource) return false;
        if (factLab != task.factLab) return false;
        if (leftLab != task.leftLab) return false;
        if (projectName != null ? !projectName.equals(task.projectName) : task.projectName != null) return false;
        return taskName != null ? taskName.equals(task.taskName) : task.taskName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + lab;
        result = 31 * result + resource;
        result = 31 * result + factLab;
        result = 31 * result + leftLab;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Task{");
        sb.append("id=").append(id);
        sb.append(", projectName='").append(projectName).append('\'');
        sb.append(", taskName='").append(taskName).append('\'');
        sb.append(", lab=").append(lab);
        sb.append(", resource=").append(resource);
        sb.append(", factLab=").append(factLab);
        sb.append(", leftLab=").append(leftLab);
        sb.append("}\n");
        return sb.toString();
    }
}
