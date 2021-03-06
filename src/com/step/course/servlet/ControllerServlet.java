package com.step.course.servlet;

import com.step.course.dao.StudentDao;
import com.step.course.dao.StudentDaoImpl;
import com.step.course.model.Student;
import com.step.course.service.StudentService;
import com.step.course.service.StudentServiceImpl;
import com.step.course.util.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends HttpServlet {

    private StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = null;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
            System.out.println(action);
        }

        if (action.equals("getAllStudent")){
            List<Student> list = studentService.getAllStudent();
            request.setAttribute("studentList", list);

            request.getRequestDispatcher("/WEB-INF/fragments/student-table.jsp").forward(request,response);

        }


    }


}
