package org.tnr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tnr.model.Emp;
import org.tnr.service.EmpService;

@WebServlet("/empList")
public class EmpServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//创建业务类对象
			EmpService empService = new EmpService();
			
			//通过业务类的方法获得数据
			List<Emp> list = empService.getEmpList();
			
			//将数据存入request对象中
			request.setAttribute("empList", list);
			
			//将request转发到jsp
			request.getRequestDispatcher("empList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
