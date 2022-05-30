package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sl_no=request.getParameter("sl_no");
		String invoice_currency=request.getParameter("invoice_currency");
		String cust_payment_terms=request.getParameter("cust_payment_terms");
		HashMap<Object,Object> res=new HashMap<Object, Object>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Soumya@0903");
			PreparedStatement ps=con.prepareStatement("update winter_internship set invoice_currency=?,cust_payment_terms=? where sl_no=?;");
			ps.setString(1, invoice_currency);
			ps.setString(2, cust_payment_terms);
			ps.setString(3,sl_no);
            int updateSuccess=ps.executeUpdate();
			res.put("Update", updateSuccess);
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
