package com.store.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.DataBaseConnector;
import com.store.SmartphoneRepository;

import sun.misc.Request;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		DataBaseConnector connector = new DataBaseConnector();
		SmartphoneRepository rep = new SmartphoneRepository(connector);
		RequestDispatcher rd = req.getRequestDispatcher("catalog.jsp");
		
		req.setAttribute("list", rep.getPhones());
		rd.forward(req, res);
	}
}
