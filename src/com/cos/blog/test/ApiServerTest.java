package com.cos.blog.test;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApiServerTest
 */
@WebServlet("/test")
public class ApiServerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiServerTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mime = request.getContentType();
		System.out.println(mime);
		
		if(mime.equals("application/json")) {
			BufferedReader br = request.getReader();
			String input;
			StringBuffer buffer = new StringBuffer();
			while((input = br.readLine()) != null) {
				buffer.append(input);
			}
			
			System.out.println(buffer.toString());
		}else {
			String food = request.getParameter("food");
			String method = request.getParameter("method");
			
			System.out.println("food :::: " + food + ", method ::: " + method);
		}
		
//		int result = 1;
//		PrintWriter out = response.getWriter();
//		out.println(result);	
//		out.flush();
		
		response.sendRedirect("index.jsp");
	}
}
