package com.JDBC.ProductDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcServletConnection.DBConnection;

 //import jdbcServletConnection;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBConnection dbconnection= new DBConnection();
		Connection connection=dbconnection.getConnection();
	
	//step 3: Create Statement object
		try {
		
			Statement stmt=connection.createStatement();
			
			//step4:Execute query
		
			Integer prod_Id=102;
			ResultSet rs =null;
			PrintWriter out=response.getWriter();
						
			out.println("<html><body>");
			if(prod_Id!=null)
			{
			 rs= stmt.executeQuery("select * from data1.products Where prod_Id=101");
		     }
			else
			{
				out.println("Please Enter Correct ProductID");
			}
			while(rs.next())
			{
			 prod_Id =rs.getInt("prod_Id");
			String prod_name=rs.getString("prod_name");
			Double  prod_price= rs.getDouble("prod_price");
			Integer prod_qty=rs.getInt("prod_qty");
			
			out.println(prod_Id+" ");
			out.println(prod_name+"");
			out.println(prod_price+"");
			out.println(prod_qty+"");
			out.println("</br>");
			}
			out.println("</body></html>");
			//step 5: closing connection query
			stmt.close();
			connection.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
