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
import java.util.*;

/**
 * Servlet implementation class DataLoading
 */
@WebServlet("/DataLoading")
public class DataLoading extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DataLoading() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Object,Object> res=new HashMap<Object, Object>();
		ArrayList<DataModel>a=new ArrayList<DataModel>();
		String skip=request.getParameter("skip");
		String take=request.getParameter("take");
		String orderby=request.getParameter("orderby");
		String sort=request.getParameter("sort");
				
		System.out.println("Skip "+skip+" Take "+take);
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/grey_goose","root","Soumya@0903");
            String query="select * from winter_internship order by "+orderby +" "+sort + " limit ? offset ?;";
			
			System.out.print(query);
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(take));
			ps.setInt(2, Integer.parseInt(skip));

			
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
			res.put("winterintern", a);
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
