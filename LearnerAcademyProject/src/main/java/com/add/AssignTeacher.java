package com.add;



import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pojo.Subject;
import com.pojo.Teacher;
import com.util.HibernateUtil;




/**
 * Servlet implementation class AssignTeacher
 */
@WebServlet("/assignTeacher")
public class AssignTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacher() {
        super();
        // TODO Auto-generated constructor stub
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
		
	
		String name = request.getParameter("name");
		String[] nameArray = name.split(" ");
		//System.out.println("NameList: " + nameList);
		String subject = request.getParameter("subject");
				
		
		SessionFactory sf  = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
	
		Transaction tx = session.beginTransaction();
		
		String hql_teacher= "from Teacher where name='" + nameArray[0] + "'" + " and lname='" + nameArray[1] + "'";
		List<Teacher> teachers = session.createQuery(hql_teacher).list();
		
		String hql_subject = "update Subject s set s.teacher=:n where s.name=:sn";
		
		Query<Subject> query = session.createQuery(hql_subject);
		query.setParameter("n", teachers.get(0));
		query.setParameter("sn", subject);
				
		query.executeUpdate();

		
		
		tx.commit();
		session.close();
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/viewTeacher.jsp");
        dispatcher.forward(request, response); 
	}

}
