package com.search.servlet;

import java.io.IOException;
import java.net.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchEngines
 */

public class SearchEngines extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchString = request.getParameter("searchString");
		String numResults = request.getParameter("numResults");
		String searchEngine = request.getParameter("searchEngine");
		SearchSpec[] commonSpecs = SearchSpec.getCommonSpecs();
		for(int i=0; i<commonSpecs.length; i++){
			SearchSpec searchSpec = commonSpecs[i];
			if(searchSpec.getName().equals(searchEngine)){
				String url = response.encodeRedirectURL(searchSpec.makeURL(searchString, numResults));
				response.sendRedirect(url);
				return;
			}
		}
		response.sendError(response.SC_NOT_FOUND, "No recognized search engine specified");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
