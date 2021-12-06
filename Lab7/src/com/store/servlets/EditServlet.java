package com.store.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.DataBaseConnector;
import com.store.Smartphone;
import com.store.SmartphoneRepository;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String manufacturer = req.getParameter("manufacturer");
		String name = req.getParameter("name");
		int ram = Integer.parseInt( req.getParameter("ram"));
		int storage = Integer.parseInt( req.getParameter("storage"));
		int id = Integer.parseInt( req.getParameter("id"));
		
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		
		rep.update(id, new Smartphone.SmartphoneBuilder()
                           .setManufacturer(manufacturer)
                           .setName(name)
                           .setStorage(storage)
                           .setRam(ram)
                           .CreateInstance());
		
		res.sendRedirect("catalog");
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		
		int id = Integer.parseInt( req.getParameter("id"));
		
		
		req.setAttribute("phone", rep.getPhone(id));
		rd.forward(req, res);
	}
}
