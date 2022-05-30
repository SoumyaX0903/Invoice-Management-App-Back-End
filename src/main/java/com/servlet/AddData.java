package com.servlet;

import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import com.pojo.DataModel;

import com.google.gson.Gson;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("AT adddata");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String business_code=request.getParameter("business_code");
		String cust_number=request.getParameter("cust_number");
		String clear_date=request.getParameter("clear_date");
		String business_year=request.getParameter("business_year");
		String doc_id=request.getParameter("doc_id");
		String posting_date=request.getParameter("posting_date");
		String document_create_date=request.getParameter("document_create_date");
		String due_in_date=request.getParameter("due_in_date");
		String invoice_currency=request.getParameter("invoice_currency");
		String doc_type=request.getParameter("doc_type");
		String posting_id=request.getParameter("posting_id");
		String total_open_amount=request.getParameter("total_open_amount");
		String baseline_create_date=request.getParameter("baseline_create_date");
		String cust_payment_terms=request.getParameter("cust_payment_terms");
		String invoice_id=request.getParameter("invoice_id");
		
		HashMap<Object,Object> res=new HashMap<Object, Object>();

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Soumya@0903");

			 PreparedStatement ps= con.prepareStatement("INSERT INTO winter_internship (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			 
             ps.setString(1, business_code);
             ps.setInt(2, Integer.parseInt(cust_number));
             ps.setDate(3, Date.valueOf(clear_date));
             ps.setString(4,business_year);
             ps.setString(5,doc_id);
             ps.setDate(6, Date.valueOf(posting_date));
             ps.setDate(7, Date.valueOf(document_create_date));
             ps.setDate(8,Date.valueOf(due_in_date) );
             ps.setString(9, invoice_currency);
             ps.setString(10,doc_type);
             ps.setString(11,posting_id);
             ps.setString(12, total_open_amount);
             ps.setDate(13, Date.valueOf(baseline_create_date));
             ps.setString(14, cust_payment_terms);
             ps.setString(15, invoice_id);
             int insertSuccess=ps.executeUpdate();
			 res.put("Insert", insertSuccess);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Gson gson=new Gson();
		String jsonResponse=gson.toJson(res);
		response.setHeader("Access-Control-Allow-Origin","*");
		response.getWriter().append(jsonResponse);
	}

}