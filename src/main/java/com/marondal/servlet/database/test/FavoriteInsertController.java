package com.marondal.servlet.database.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.marondal.servlet.common.MysqlService;

@WebServlet("/db/favorite/insert")
public class FavoriteInsertController extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		MysqlService mysqlService = MysqlService.getInstance();
		
		mysqlService.connect();
		
		String query = "INSERT INTO `favorite` \r\n"
				+ "(`name`, `url`)\r\n"
				+ "VALUE \r\n"
				+ "('" + name + "', '" + url + "')";
		
		int count = mysqlService.update(query);

		response.sendRedirect("/db/favorite/list.jsp");
	}
}
