package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
/**
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String[] sl_nos=request.getParameter("payload").split(",");
			HashMap<Object,Object> res=new HashMap<Object, Object>();
			int deleteSuccess=0;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Soumya@0903");
				for(String sl_no : sl_nos)
				{PreparedStatement ps=con.prepareStatement("DELETE FROM winter_internship where sl_no=?;");
				ps.setString(1, sl_no);
	            deleteSuccess+=ps.executeUpdate();
				 res.put("Delete", deleteSuccess);}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			Gson gson=new Gson();
			String jsonResponse=gson.toJson(res);
			response.setHeader("Access-Control-Allow-Origin","*");
			response.getWriter().append(jsonResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
