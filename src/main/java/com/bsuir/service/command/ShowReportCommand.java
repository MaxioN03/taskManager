package com.bsuir.service.command;

import com.bsuir.dao.entity.Report;
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
public class ShowReportCommand implements com.bsuir.service.implement.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession(true);

        if(request.getParameter("taskId")==null ||
                session.getAttribute("source")==null){
            request.setAttribute("error", "Не выбрана задача!");
            return "/view/index.jsp";
        }
        int id = Integer.parseInt(request.getParameter("taskId"));
        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("CSV");
        List<Report> allReportList = resource.getResource("report");
        List<Report> reportList = new LinkedList<>();
        for(Report report: allReportList){
            if(report.getTaskid()==id){
                reportList.add(report);
            }
        }
        request.setAttribute("reportList", reportList);


        if(session.getAttribute("source").equals("CSV")) {
            CSVCommand csvCommand = new CSVCommand();
            return csvCommand.execute(request);
        }
        else if(session.getAttribute("source").equals("XML")){
            XMLCommand xmlCommand = new XMLCommand();
            return xmlCommand.execute(request);
        }
        else{
            request.setAttribute("error", "Не выбрана задача!");
            return "/view/index.jsp";
        }
    }
}
