package com.notify.web;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notify.dao.LoginDao;
import com.notify.dao.noteDao;
import com.notify.dao.notifyDao;
import com.notify.model.LoginBean;
import com.notify.model.User;

@WebServlet("/index")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private LoginDao loginDao;
    private notifyDao nDao;
    public LoginController() {
    	super();
    }

    public void init() {
        loginDao = new LoginDao();
        nDao = new notifyDao();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
        	System.out.print("t");
			authenticate(request, response);
			System.out.print("k");
		} catch (IOException | ServletException | SQLException e) 
        {
			// TODO Auto-generated catch block
			System.out.print("u");
			e.printStackTrace();
		}
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
      
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean(email,password);
        loginBean.setEmail(email);
        loginBean.setPassword(password);
         
       
        try {
            if (loginDao.validate(loginBean)) 
            {
            	 HttpSession session= request.getSession();
            //	System.out.print("j");
            	 int id_ = loginDao.getId_(loginBean);
            //	System.out.print(id_);
            	 int NoteBookId_ = loginDao.getNoteBookId_(id_);
            	 session.setAttribute("NoteBookId_", NoteBookId_); 
            	 System.out.print(NoteBookId_+"qqq");
            	String user_ = loginDao.getuser_(loginBean);
            //	System.out.print(user_);
            	String noteName = noteDao.getnoteName(NoteBookId_);
            	System.out.print(noteName);
            	 session.setAttribute("noteName", noteName); 
                 request.setAttribute("email", email); 
                 request.setAttribute("user_", user_); 
               // request.setAttribute("userName",username);
                 session.setAttribute("id_", id_);
                 User u = new User(id_);
                 String nb_Name = nDao.books(u);
                 System.out.print(nb_Name+"there");
                 session.setAttribute("nb_Name", nb_Name);
                RequestDispatcher dispatcher = request.getRequestDispatcher("noteBooks.jsp");
           
                dispatcher.forward(request, response);
                
             
                
            } 
            
            
            else
            {
                HttpSession session = request.getSession();
                 session.setAttribute("email", email);
                 response.sendRedirect("index.jsp");
            }
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}