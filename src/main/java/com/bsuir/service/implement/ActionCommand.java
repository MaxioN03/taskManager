package com.bsuir.service.implement;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Егор on 21.04.17.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
