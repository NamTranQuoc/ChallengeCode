package com.control;

import com.model.CreateDb;
import com.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/load"})
public class Load extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=UTF-8");
      req.setCharacterEncoding("utf-8");

      PrintWriter out = resp.getWriter();

      String result = "";
      CreateDb.getInstance().create();
      for (Exercise e: CreateDb.exercises) {
         result += "<option value=\"" + e.getId() + "\">Bài " + e.getId() + "</option>";
      }

      out.write(result);
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
   }
}
