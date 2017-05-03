package com.bsuir.service.command;


import com.bsuir.service.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Егор on 21.04.17.
 */
public class EmptyCommand implements ActionCommand {


    public String execute(HttpServletRequest request) {
        String page = "/view/error/404.jsp";
        return page;
    }
}
