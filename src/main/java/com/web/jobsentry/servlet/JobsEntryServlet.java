package com.web.jobsentry.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.jobsentry.dao.JobDetail;
import com.web.jobsentry.dao.LoginDao;
import com.web.jobsentry.service.JobService;
import com.web.jobsentry.utils.Constants;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(
        name = "JobsEntryServlet",
        urlPatterns = "/JobsEntryServlet")
public class JobsEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public JobsEntryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Hello: ").append(request.getParameter("name"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In JobsEntryServlet .....");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String location = request.getParameter("location");
		String category = request.getParameter("category");

		JobService service = new JobService();

		JobDetail jobDetail = service.getJobDetails(location, category);
		if (jobDetail.getError() != null && jobDetail.getError().equals(Constants.ERROR)) {
			request.setAttribute("jobDetail", jobDetail);
			//response.sendRedirect(request.getContextPath() + "/error.jsp");
			 RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
	         rd.forward(request, response);
		} else {
			request.setAttribute("jobDetail", jobDetail);
			//response.sendRedirect(request.getContextPath() + "/jd.jsp");
			 RequestDispatcher rd=request.getRequestDispatcher("/jd.jsp");
	         rd.forward(request, response);
		}

	}

}
