package com.control;

import com.model.RequestClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/compile"})
public class Compile extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String code = req.getParameter("code");
      String language = req.getParameter("language");
      RequestClass requestClass = new RequestClass(code, language);

      req.setAttribute("RequestClass", requestClass);
      req.setAttribute("code", code);

      //String result = "language: " + requestClass.getLanguage() + "\ncode:\n" + requestClass.getContent();
      String result = "";
      result = ConnectSSH.getInstance().ExecuteCmd(requestClass);
      req.setAttribute("result", result);
      getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
   }
}
