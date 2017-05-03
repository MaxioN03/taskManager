package com.bsuir.service.command;

import com.bsuir.dao.dao.DAO;
import com.bsuir.dao.entity.Report;
import com.bsuir.dao.entity.Task;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Егор on 03.05.17.
 */
public class AddCommand implements com.bsuir.service.implement.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        switch (request.getParameter("type")){
            case "report":
                String time = request.getParameter("time1ReportAdd")+":"+request.getParameter("time2ReportAdd");
                Report report = new Report(request.getParameter("dateReportAdd"),
                        time,
                        Integer.parseInt(request.getParameter("leftTimeReportAdd")),
                        request.getParameter("projectNameReportAdd"),
                        Integer.parseInt(request.getParameter("taskIdReportAdd")));
                DAO reportDAO = new DAO();
                reportDAO.addReportCSV(report);

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
            case "task":
                Task task = new Task(Integer.parseInt(request.getParameter("taskIdAdd")),
                        request.getParameter("projectNameAdd"),
                        request.getParameter("taskNameAdd"),
                        Integer.parseInt(request.getParameter("labAdd")),
                        Integer.parseInt(request.getParameter("resourceAdd")),
                        0,0);
                DAO dao = new DAO();


                session = request.getSession(true);
                if(session.getAttribute("source").equals("CSV")) {

                    dao.addTaskCSV(task);
                    CSVCommand csvCommand = new CSVCommand();
                    return csvCommand.execute(request);
                }
                else if(session.getAttribute("source").equals("XML")){
                    dao.addTaskXML(task);
                    XMLCommand xmlCommand = new XMLCommand();
                    return xmlCommand.execute(request);
                }
                else{

                    request.setAttribute("error", "Не выбрана задача!");
                    return "/view/index.jsp";
                }
        }
        return "/view/index.jsp";
    }
}
