package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.NameCity;

public class AjaxJsonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream in = req.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		String msg = "";
		String bufStr = null;
		while((bufStr=br.readLine()) != null) {
			msg += bufStr;
		}
		
		Gson gson =new Gson();
		NameCity nc = gson.fromJson(msg, NameCity.class);
		
		try(PrintWriter out = resp.getWriter()){
			out.println(nc.toString());
		}catch(Exception ex) {
			System.out.println(ex);
		}
	}
}
