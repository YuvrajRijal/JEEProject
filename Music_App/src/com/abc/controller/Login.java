package com.abc.controller;

import java.io.IOException;
import java.sql.Blob;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.model.Model;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pw;
	private String email;
	private RequestDispatcher req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pw = request.getParameter("pw");
		email = request.getParameter("email");
		Model m=new Model();
		boolean b = m.login(email, pw);
		if(b==true)
		{
			
//			Blob image = m.getImage();
//			request.setAttribute("image", image);
//			System.out.println(image);
		
			req = request.getRequestDispatcher("musicHome.jsp");
			req.forward(request, response);
			
		}
		else
		{
		 req = request.getRequestDispatcher("errorLogin.jsp");
		 req.forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
