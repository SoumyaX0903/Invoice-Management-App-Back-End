package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pojo.DataModel;

/**
 * Servlet implementation class AdvancedSearch
 */
@WebServlet("/AdvancedSearch")
public class AdvancedSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvancedSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Object,Object> res=new HashMap<Object, Object>();
		ArrayList<DataModel>a=new ArrayList<DataModel>();
		String doc_id=request.getParameter("doc_id");
		String invoice_id=request.getParameter("invoice_id");
		String cust_number=request.getParameter("cust_number");
		String business_year=request.getParameter("business_year");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Soumya@0903");
            
			int c=0;
			String a1,a2,a3,a4;
			
			
			if(request.getParameter("doc_id") != "")		
			a1 = c++>0?"":"" + " doc_id=" + request.getParameter("doc_id");
			else
			a1="";
			
			if(request.getParameter("invoice_id") != "")		
			a2 = (c++>0?" and":"")+ " invoice_id="+request.getParameter("invoice_id");
			else
			a2="";
			
			if(request.getParameter("cust_number") != "")		
			a3 = (c++>0?" and":"")+ " cust_number="+request.getParameter("cust_number");
			else
			a3="";
			
			if(request.getParameter("business_year") != "")		
			a4 = (c++>0?" and":"")+ " buisness_year="+request.getParameter("business_year");
			else
			a4="";
			
			
			//System.out.println("select * from winter_internship where "+a1+a2+a3+a4 +" limit 20;\n");
			PreparedStatement ps= con.prepareStatement("select * from winter_internship where "+a1+a2+a3+a4 +";");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DataModel d=new DataModel(
						rs.getString("sl_no"),
						rs.getString("business_code"),
						rs.getString("cust_number"),
						rs.getString("clear_date"),
						rs.getString("buisness_year").split("-")[0],
						rs.getString("doc_id"),
						rs.getString("posting_date"),
						rs.getString("document_create_date"),
						rs.getString("due_in_date"),
						rs.getString("invoice_currency"),
						rs.getString("document_type"),
						rs.getString("posting_id"),
						rs.getString("total_open_amount"),
						rs.getString("baseline_create_date"),
						rs.getString("cust_payment_terms"),
						rs.getString("invoice_id")
						);
				a.add(d);
			}
			res.put("Advanced_Search_found", a);
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
