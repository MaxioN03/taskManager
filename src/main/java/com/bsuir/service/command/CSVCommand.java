package com.bsuir.service.command;

import com.bsuir.dao.entity.Task;
import com.bsuir.dao.resourceFactory.AbstractFactory;
import com.bsuir.dao.resourceFactory.Resource;
import com.bsuir.dao.resourceFactory.ResourceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 02.05.17.
 */
public class CSVCommand implements com.bsuir.service.implement.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("CSV");
        List<Task> taskList = resource.getResource("task");
        request.setAttribute("taskList", taskList);

        List<String> projectList = new LinkedList<>();
        projectList.add(taskList.get(0).getProjectName());
        for(Task task: taskList){
            if(projectList.contains(task.getProjectName())==false){
                projectList.add(task.getProjectName());
            }
        }
        request.setAttribute("projectList", projectList);

        HttpSession session = request.getSession(true);
        session.setAttribute("source", "CSV");
        return "/view/index.jsp";
    }
}
