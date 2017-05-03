package com.bsuir.service.command;


import com.bsuir.service.constant.ErrorConstant;
import com.bsuir.service.implement.ActionCommand;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Егор on 21.04.17.
 */
public class LoginCommand implements ActionCommand {


    public String execute(HttpServletRequest request) {
        String page = "/view/index.jsp";
        /*UserMySQLDAO userMySQLDAO = new UserMySQLDAO();

        List<User> userList = userMySQLDAO.getAll();
        for (User user : userList) {
            if (user.getLogin().equals(request.getParameter(ParameterConstant.loginParameter)) &&
                    user.getPassword().equals(request.getParameter(ParameterConstant.passwordParameter))) {

                HttpSession session = request.getSession(true);
                String userType;
                if (userMySQLDAO.getByLogin(request.getParameter(ParameterConstant.loginParameter)).getUserType() == UserType.ADMINISTRATOR) {
                    userType = "ADMIN";
                } else {
                    userType = "USER";
                }
                session.setAttribute("ROLE", userType);
                session.setAttribute("USER_ID", user.getId());
                if(userType.equals("ADMIN")){
                    AdminPageCommand adminPageCommand = new AdminPageCommand();
                    page = adminPageCommand.execute(request);
                }
                else if(userType.equals("USER")){
                    UserPageCommand userPageCommand = new UserPageCommand();
                    page = userPageCommand.execute(request);
                }

                return page;
            }
        }*/
        request.setAttribute("error", ErrorConstant.loginError);
        return page;
    }
}
