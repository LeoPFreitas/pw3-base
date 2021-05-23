package com.example.HelloServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProcessamentoServlet", value = "/ProcessamentoServlet")
public class ProcessamentoServlet extends HttpServlet {

    public void init(){
        ServletContext context = getServletContext();
        context.setAttribute("lista",new ArrayList<Users>());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();

        ArrayList<Users> lista = (ArrayList<Users>)context.getAttribute("lista");

        response.setContentType("text/html");
        String nome = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        lista.add(new Users(nome,email, password));
        context.setAttribute("lista",lista);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Servlet de Processamento</h1>");


        for (Users e : lista) {
            out.println("<p>"+e.getNome()+" possui o email "+e.getEmail()+"</p>");
        }
        out.println("<p><a href='index.html'>Voltar</a></p>");
        out.println("</body></html>");

    }


}
