package com.Control;

import com.Model.RequestClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String language = request.getParameter("language");
        RequestClass requestClass = new RequestClass(code, language);

        request.setAttribute("RequestClass", requestClass);

        //String result = "language: " + requestClass.getLanguage() + "\ncode:\n" + requestClass.getContent();
        String result = "";
        result = ConnectSSH.getInstance().ExecuteCmd(requestClass);
        request.setAttribute("result", result);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
