package com.store.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.DataBaseConnector;
import com.store.Smartphone;
import com.store.SmartphoneRepository;
import com.store.Smartphone.SmartphoneBuilder;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String manufacturer = req.getParameter("manufacturer");
		String name = req.getParameter("name");
		int ram = Integer.parseInt( req.getParameter("ram"));
		int storage = Integer.parseInt( req.getParameter("storage"));
		
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		
		rep.delete((new Smartphone.SmartphoneBuilder()
                           .setManufacturer(manufacturer)
                           .setName(name)
                           .setStorage(storage)
                           .setRam(ram)
                           .CreateInstance()));
		
		res.sendRedirect("catalog");
	}

}
