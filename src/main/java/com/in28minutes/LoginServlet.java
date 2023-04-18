package com.in28minutes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login.do")        // @WebServlet allows us to define url
public class LoginServlet extends HttpServlet {

    private UserValidationService userValidationService =new UserValidationService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name",request.getParameter("name")); // setting attribute for the request so that it is available in the JSP as ${name}
        request.setAttribute("password",request.getParameter("password"));
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response); // redirect request to JSP since
        //it is easier to write html content in a JSP file
//        PrintWriter out = response.getWriter();
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Yahoo!!!!!!!!</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("My First Servlet");
//        out.println("</body>");
//        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        boolean isUserValid= userValidationService.isUserValid(name, password);
        if(isUserValid) {
            request.setAttribute("name", name);
            request.setAttribute("password", password);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage","Invalid Credentials");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        }
    }

}
