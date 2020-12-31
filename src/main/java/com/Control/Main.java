package com.control;

import com.model.RequestClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/compile"})
public class Main extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String code = request.getParameter("code");
      String language = request.getParameter("language");
      RequestClass requestClass = new RequestClass(code, language);

      request.setAttribute("RequestClass", requestClass);
      request.setAttribute("code", code);

      //String result = "language: " + requestClass.getLanguage() + "\ncode:\n" + requestClass.getContent();
      String result = "";
      result = ConnectSSH.getInstance().ExecuteCmd(requestClass);
      request.setAttribute("result", result);
      getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
   }
}
