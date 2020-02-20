package com.mycompany.mytax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyTax extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	double taxRate = 0;
	double exemptions = 0;
	try (PrintWriter out = response.getWriter()) {
	    String income = request.getParameter("income");
	    double incomeNum = Double.parseDouble(income);
	    String marr = request.getParameter("married");

	    if (incomeNum < 10000) {
		taxRate = 0;
	    }
	    if (incomeNum > 25000) {
		taxRate = 0.15;
	    }
	    if (incomeNum >= 10000 || incomeNum <= 25000) {
		taxRate = 0.05;
	    }

	    if (marr.equals("checked")) {
		String kid = request.getParameter("sel");
		if (kid.equals("noKid")) {
		    exemptions = 8000;
		}
		if (kid.equals("oneKid")) {
		    exemptions = 8000 + 2000;
		}
		if (kid.equals("twoKid")) {
		    exemptions = 8000 + 3500;
		}
		if (kid.equals("threeKid")) {
		    exemptions = 8000 + 4500;
		}
		if (kid.equals("moreThan3Kid")) {
		    exemptions = 8000 + 5000;
		}
	    }
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>YOUR RESULT</title>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	    out.println("<style>");
	    out.println("@import url(tax_css.css);");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body id=\"page\">");
	    out.println("<header id=\"headerHtml\">");
	    out.println("YOUR INCOME IS: " + incomeNum + ", AND YOUR TAX RATE IS: " + taxRate + ", YOUR EXEMPTIONS IS: " + exemptions
			+ "<br> YOUR TAX IS: " + taxRate * incomeNum + ", YOUR NET INCOME IS: " + (incomeNum - (taxRate * incomeNum)));
	    out.println("</header>");
	    out.println("</body>");
	    out.println("</html>");
	    out.flush();
	    out.close();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	double taxRate = 0;
	double exemptions = 0;
	try (PrintWriter out = response.getWriter()) {
	    String income = request.getParameter("income");
	    double incomeNum = Double.parseDouble(income);
	    String marr = request.getParameter("married");
	    if (incomeNum < 10000) {
		taxRate = 0;
	    }
	    if (incomeNum > 25000) {
		taxRate = 0.15;
	    }
	    if (incomeNum >= 10000 || incomeNum <= 25000) {
		taxRate = 0.05;
	    }
	    if (marr != null) {
		if (marr.equals("checked")) {
		    String kid = request.getParameter("sel");
		    if (kid.equals("noKid")) {
			exemptions = 8000;
		    }
		    if (kid.equals("oneKid")) {
			exemptions = 8000 + 2000;
		    }
		    if (kid.equals("twoKid")) {
			exemptions = 8000 + 3500;
		    }
		    if (kid.equals("threeKid")) {
			exemptions = 8000 + 4500;
		    }
		    if (kid.equals("moreThan3Kid")) {
			exemptions = 8000 + 5000;
		    }
		}
	    }
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>YOUR RESULT</title>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	    out.println("<style>");
	    out.println("@import url(taxs_css.css);");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body id=\"page\">");
	    out.println("<header id=\"headerRlt\">");
	    out.println("YOUR INCOME IS: " + incomeNum + "<br> AND YOUR TAX RATE IS: " + taxRate + "<br> YOUR EXEMPTIONS IS: " + exemptions
			+ "<br> YOUR TAX IS: " + taxRate * incomeNum + "<br> YOUR NET INCOME IS: " + (incomeNum - (taxRate * incomeNum)));
	    out.println("</header>");
	    out.println("</body>");
	    out.println("</html>");
	    out.flush();
	    out.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }

}
