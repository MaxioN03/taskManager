package com.bsuir.dao.dao;

import com.bsuir.dao.entity.Report;
import com.bsuir.dao.entity.Task;

import java.io.*;

/**
 * Created by Егор on 03.05.17.
 */
public class DAO {

    public static void main(String[] args) {
        DAO reportDAO = new DAO();
        //reportDAO.addReportCSV(new Report("123","123",1,"123",2));
    }


    private static final String COMMA_DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public void addReportCSV(Report report) {
        System.out.println(report);
        String csvFile = "E:\\Uchoba\\6\\ВДИШП\\lab12\\src\\main\\resources\\reports.csv";
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile,true), "UTF-8"));
            out.append(report.getDate());
            out.append(COMMA_DELIMITER);
            out.append(report.getTime());
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(report.getLeftLabs()));
            out.append(COMMA_DELIMITER);
            out.append(report.getProjectName());
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(report.getTaskid()));
            out.append(NEW_LINE_SEPARATOR);
            out.flush();
            out.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    public void addTaskCSV(Task task) {
        String csvFile = "E:\\Uchoba\\6\\ВДИШП\\lab12\\src\\main\\resources\\tasks.csv";
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(csvFile,true), "UTF-8"));

            out.append(String.valueOf(task.getId()));
            out.append(COMMA_DELIMITER);
            out.append(task.getProjectName());
            out.append(COMMA_DELIMITER);
            out.append(task.getTaskName());
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(task.getLab()));
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(task.getResource()));
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(0));
            out.append(COMMA_DELIMITER);
            out.append(String.valueOf(0));

            out.append(NEW_LINE_SEPARATOR);
            out.flush();
            out.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    //todo Добавление в XML
    public void addTaskXML(Task task) {
    }
}