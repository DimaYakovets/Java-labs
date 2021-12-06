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
import com.store.Smartphone.SmartphoneBuilder;

@WebServlet("/add")
public class AddPhoneServlet extends HttpServlet  {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String newManufacturer = req.getParameter("manufacturer");
		String newName = req.getParameter("name");
		int newRam = Integer.parseInt( req.getParameter("ram"));
		int newStorage = Integer.parseInt( req.getParameter("storage"));
		
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		
		rep.add(new Smartphone.SmartphoneBuilder()
                           .setManufacturer(newManufacturer)
                           .setName(newName)
                           .setStorage(newStorage)
                           .setRam(newRam)
                           .CreateInstance());
		
		res.sendRedirect("catalog");
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		
		RequestDispatcher rd = req.getRequestDispatcher("add.html");
		rd.forward(req, res);
	}
}
