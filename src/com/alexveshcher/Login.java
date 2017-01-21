package com.alexveshcher;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form method='post' action='login'>\n" +
                    "  Login:<br>\n" +
                    "  <input type=\"text\" name=\"login\"><br>\n" +
                    "  Password:<br>\n" +
                    "  <input type=\"password\" name=\"password\"><br><br>\n" +
                    "  <input type=\"submit\" value=\"Log in\">" +
                    "</form>\n");

            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login.equals("admin") && password.equals("12345")){
            RequestDispatcher rs = request.getRequestDispatcher("welcome");
            rs.forward(request, response);
        }
        else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='post' action='login'>\n" +
                        "  Login:<br>\n" +
                        "  <input type=\"text\" name=\"login\"><br>\n" +
                        "  Password:<br>\n" +
                        "  <input type=\"password\" name=\"password\"><br><br>\n" +
                        "  <input type=\"submit\" value=\"Log in\">" +
                        "</form>\n");

                out.println("<h2>INCORRECT!!</h2>");

                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        }
    }

}