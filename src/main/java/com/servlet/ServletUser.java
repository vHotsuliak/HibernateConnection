package com.servlet;

import com.store.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletUser extends HttpServlet {
    private final UserStore userStore = new UserStore();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userStore.value());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/UserView.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    public void destroy() {
        super.destroy();
        this.userStore.close();
    }
}
