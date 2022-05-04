package com.add;




import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pojo.Teacher;
import com.util.HibernateUtil;



/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/addTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		Teacher teacher=new Teacher();
		teacher.setFname(fname);
		teacher.setLname(lname);
		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
			out.println("Teacher added Successfully <br>");
			out.println("<a href=\"addClasses.html\">Add Classes</a><br>");
			out.println("<a href=\"addStudent.html\">Add Student</a><br>");
			out.println("<a href=\"addSubject.html\">Add Subject</a><br>");
			out.println("<a href=\"addTeacher.html\">Add Teacher</a><br>");
			out.print("<br><br>");
			out.println("<a href=\"index.html\">Main Menu</a><br>");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		
	}
	

	}
}
