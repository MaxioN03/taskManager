package com.bsuir.dao.resourceFactory;


import com.bsuir.dao.entity.Report;
import com.bsuir.dao.entity.Task;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CSVResource implements Resource {

    public static void main(String[] args) {
        AbstractFactory factory = new ResourceFactory();
        Resource resource = factory.getResource("CSV");
        System.out.println(resource.getResource("task"));
    }

    public List getResource(String scheduleType) {
        switch (scheduleType.toLowerCase()) {
            //todo
            case "task":
                return getTasks();
            case "report":
                return getReports();
        }
        return null;
    }

    private List<Task> getTasks() {
        List<Task> result = new LinkedList<Task>();
        String csvFile = "E:\\Uchoba\\6\\ВДИШП\\lab12\\src\\main\\resources\\tasks.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"))) {

            while ((line = br.readLine()) != null) {
                // use ; as separator
                String[] arr = line.split(cvsSplitBy);
                result.add(new Task(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        Integer.parseInt(arr[3]),
                        Integer.parseInt(arr[4]),
                        Integer.parseInt(arr[5]),
                        Integer.parseInt(arr[6])
                        ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Report> getReports(){
        List<Report> result = new LinkedList<Report>();
        String csvFile = "E:\\Uchoba\\6\\ВДИШП\\lab12\\src\\main\\resources\\reports.csv";
        String line = "";
        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile),"UTF-8"))) {

            while ((line = br.readLine()) != null) {
                // use ; as separator
                String[] arr = line.split(cvsSplitBy);
                result.add(new Report(arr[0],
                        arr[1],
                        Integer.parseInt(arr[2]),
                        arr[3],
                        Integer.parseInt(arr[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


