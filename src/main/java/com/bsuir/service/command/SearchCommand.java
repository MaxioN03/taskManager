package com.bsuir.service.command;

import com.bsuir.dao.entity.Report;
import com.bsuir.dao.resourceFactory.AbstractFactory;
import com.bsuir.dao.resourceFactory.Resource;
import com.bsuir.dao.resourceFactory.ResourceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Егор on 03.05.17.
 */
public class SearchCommand implements com.bsuir.service.implement.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String field = request.getParameter("taskFieldSearch");
        String query = request.getParameter("taskQuerySearch");


        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("CSV");
        List<Report> reportList = resource.getResource("report");
        List<Report> result = new LinkedList<>();

        switch(field){
            case "Nazvanie proekta":
                for(Report report: reportList){
                    if(report.getProjectName().contains(query)){
                        result.add(report);
                    }
                }
                break;
            case "ID zadachi":
                for(Report report: reportList){
                    if(report.getTaskid()==Integer.parseInt(query)){
                        result.add(report);
                    }
                }
                break;
            case "Trudoemkost, fact":
                for(Report report: reportList){
                    if(report.getTime().contains(query)){
                        result.add(report);
                    }
                }
                break;
            case "Trudoemkost, ostatok":
                for(Report report: reportList){
                    if(report.getLeftLabs()==Integer.parseInt(query)){
                        result.add(report);
                    }
                }
                break;
        }

        System.out.println(result);
        request.setAttribute("reportList", result);


        HttpSession session = request.getSession(true);
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
