package com.abc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.abc.model.Model;

/**
 * Servlet implementation class Registration
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/go")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fn;
	private String ln;
	private String pw;
	private String email;
	private long number;
	private Part filePart;
	private RequestDispatcher req;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Servlet");
		fn = request.getParameter("fn");
		ln = request.getParameter("ln");
		pw = request.getParameter("pw");
		email = request.getParameter("email");
//		number = Integer.parseInt(request.getParameter("number"));
		number =new Long(request.getParameter("number"));
		System.out.println(number);
		filePart = request.getPart("photo");
		Model m=new Model();
		m.setEmail(email);
		m.setFirst_name(fn);
		m.setLast_name(ln);
		m.setPassword(pw);
		m.setPhone(number);
		m.setPhoto(filePart);
		boolean t=m.register();
		if(t==true)
		{
			req = request.getRequestDispatcher("login.html");
			req.forward(request, response);
			
		}
		else
		{
			req = request.getRequestDispatcher("errorRegistration.jsp");
			req.forward(request, response);
		}
	}

}
