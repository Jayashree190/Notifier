package com.notify.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

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
import com.notify.model.Note;
import com.notify.model.User;
import com.notify.model.noteBook;

/**
 * Servlet implementation class notifyServlet
 */
@WebServlet("/")
public class notifyServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
      private notifyDao dao;
      private LoginDao loginDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	dao = new notifyDao();
    	loginDao = new LoginDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
			switch(action)
			{
			case "/createUser":
				createUser(request, response);
				break;
			case "/updateUser":
				updateUser(request, response);
				break;
			case "/addNoteBook":
				addNoteBook(request, response);	
				break;
			case "/noteBooks":
				noteBooks(request, response);	
				break;
			case "/note":
				note(request, response);	
				break;
			case "/insertNote":
				insertNote(request, response);	
				break;
			case "/updateNoteBook":
				updateNoteBook(request, response);	
				break;
			case "/updateNote":
				updateNote(request, response);	
				break;	
			case "/deleteNoteBook":
				deleteNoteBook(request, response);	
				break;
			case "/showNote":
				showNote(request, response);	
				break;
			case "/deleteNote":
				deleteNote(request, response);	
				break;	
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
			}
		}
		catch(Exception e) {
		
		}
	}
	private void deleteNoteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
       System.out.println(id_);
      
		//String noteBookName = request.getParameter("noteBookName");
		//  System.out.println(noteBookName);
	//	noteBook userd = new noteBook(id_);
		dao.deletenote(id_);
	//	 System.out.println("deletenotebook1");
		 String s ="";
		session.setAttribute("nb_Name",s);
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		
		rd.forward(request, response);
		// System.out.println("addnotebook2");
	}
	
	
private void deleteNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session = request.getSession();
      //  int id_ = (int)session.getAttribute("id_");
		
      //  System.out.println("deletenote");
      
		//String noteBookName = request.getParameter("noteBookName");
		//  System.out.println(noteBookName);
		//noteBook userd = new noteBook(id_);
	//	dao.deletenote(userd);
	//	 System.out.println("deletenotebook1");
	 
		
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		
		rd.forward(request, response);
		 System.out.println("addnotebook2");
	}
	
	
	
	private void showNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		System.out.println("showNote");
		
		HttpSession session = request.getSession();
		
		   int noteBookId_ = (int)session.getAttribute("NoteBookId_");
	//	int noteBookId_ =(int) request.getParameter("noteBookId_");
		 //  System.out.println(noteBookId_+"hey");
	
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("mm/dd/yyyy");
       
        String remDate = noteDao.remDate(noteBookId_);
        String status = noteDao.status(noteBookId_);
	
		
      //   System.out.println(sdate);
     //    System.out.println(edate);

        String name=noteDao.name(noteBookId_);
         String sdate=noteDao.startDate(noteBookId_);
         String edate=  noteDao.endDate(noteBookId_);
         String des=  noteDao.des(noteBookId_);
         
         session.setAttribute("sdate",sdate);
         session.setAttribute("edate",edate);
         session.setAttribute("des",des);
         session.setAttribute("status",status);
         session.setAttribute("remDate",remDate);
         session.setAttribute("name",name);
		
		RequestDispatcher rd = request.getRequestDispatcher("showNote.jsp");
		rd.forward(request, response);
		
	}
	
	
	private void updateNoteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
        System.out.println("updatenotebook");
		String noteBookName = request.getParameter("noteBookName");
		noteBook useru = new noteBook(id_, noteBookName);
		dao.updatenote(useru);
		 System.out.println("upaddnotebook1");
		// String noteBookName = request.getParameter("noteBookName");
		 session.setAttribute("nb_Name",noteBookName);
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		
		rd.forward(request, response);
		 System.out.println("addnotebook2");
	}
	private void insertNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		System.out.println("insertNote");
		
		HttpSession session = request.getSession();
		
		   int noteBookId_ = (int)session.getAttribute("NoteBookId_");
	//	int noteBookId_ =(int) request.getParameter("noteBookId_");
		   System.out.println(noteBookId_+"hey");
		String noteName = request.getParameter("noteName");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        LocalDate remDate = LocalDate.parse(request.getParameter("remainderDate"));
        boolean status = Boolean.valueOf(request.getParameter("statusName"));
		String desc = request.getParameter("noteDescription");
		Note note = new Note(noteBookId_,noteName,startDate,endDate,remDate,status,desc);
		note.setNoteName(noteName);
		note.setStartDate(startDate);
		note.setEndDate(endDate);
		note.setRemDate(remDate);
		note.setStatus(status);
		note.setDesc(desc);
		note.setId(noteBookId_);
		noteDao.validateNote(note);
		String name = noteDao.name(noteBookId_);
		String des = noteDao.des(noteBookId_);
		 String sdate=noteDao.startDate(noteBookId_);
         String edate=  noteDao.endDate(noteBookId_);
      //   System.out.println(sdate);
     //    System.out.println(edate);
       session.setAttribute("sdate",sdate);
         session.setAttribute("edate",edate);
         session.setAttribute("noteName",name);
         session.setAttribute("des",des);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("notes.jsp");
		rd.forward(request, response);
		
	}
	
	
	
	private void updateNote(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		System.out.println("insertNote");
		
		HttpSession session = request.getSession();
		
		   int noteBookId_ = (int)session.getAttribute("NoteBookId_");
		   
	//	int noteBookId_ =(int) request.getParameter("noteBookId_");
		   System.out.println(noteBookId_+"hey");
		String noteName = request.getParameter("noteName");
		session.setAttribute("noteName", noteName);
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));
        LocalDate remDate = LocalDate.parse(request.getParameter("remainderDate"));
        boolean status = Boolean.valueOf(request.getParameter("statusName"));
		String desc = request.getParameter("noteDescription");
		Note note = new Note(noteBookId_,noteName,startDate,endDate,remDate,status,desc);
		note.setNoteName(noteName);
		note.setStartDate(startDate);
		note.setEndDate(endDate);
		note.setRemDate(remDate);
		note.setStatus(status);
		note.setDesc(desc);
		note.setId(noteBookId_);
		noteDao.uNote(note);
		RequestDispatcher rd = request.getRequestDispatcher("notes.jsp");
		rd.forward(request, response);
		
	}
	
	
	

	private void createUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("createUSer");
		String userName = request.getParameter("userName");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User(userName, mobileNumber, email, password);
		dao.inserUser(user);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
		String userName = request.getParameter("userName");
		String mobileNumber = request.getParameter("mobileNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User userm = new User(id_,userName, mobileNumber, email, password);
		dao.newUser(userm);
		request.setAttribute("userName", userName);
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		rd.forward(request, response);
	}
	private void addNoteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		//List <User> listBook = dao.books();
		//request.setAttribute("listBook", listBook);
		//RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		//rd.forward(request, response);
		
		////////////////////////////////////
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
        System.out.println("addnotebook");
		String noteBookName = request.getParameter("noteBookName");
		noteBook userm = new noteBook(id_, noteBookName);
		dao.note(userm);
		 System.out.println("addnotebook1");
		 
		session.setAttribute("nb_Name", noteBookName);
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		
		rd.forward(request, response);
		 System.out.println("addnotebook2");
	}
	private void noteBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
         User u = new User(id_);
         String nb_Name= dao.books(u);
         request.setAttribute("nb_Name", nb_Name);
         System.out.println(nb_Name+"kkk");
        RequestDispatcher dispatcher = request.getRequestDispatcher("noteBooks.jsp");
        dispatcher.forward(request,response);
	}
	
	private void note(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		 System.out.println("in note servlet");
		HttpSession session = request.getSession();
        int id_ = (int)session.getAttribute("id_");
     //   System.out.println(id_);
        request.setAttribute("u_id", id_ );
        
        int noteBookId_ = (int)session.getAttribute("NoteBookId_");
     //   System.out.println(noteBookId_+"hey");
        request.setAttribute("noteBookId_", noteBookId_ );
       // System.out.println(noteBookId_+"hey");
         User u = new User(id_);
         String nb_Name= dao.books(u);
         request.setAttribute("nb_Name", nb_Name);
        // System.out.println(nb_Name+"kkk");
         
         
         String sdate=noteDao.startDate(noteBookId_);
         String edate=  noteDao.endDate(noteBookId_);
         String des=  noteDao.des(noteBookId_);
         System.out.println(sdate);
         System.out.println(edate);
         session.setAttribute("sdate",sdate);
         session.setAttribute("edate",edate);
         session.setAttribute("des",des);
         
        RequestDispatcher dispatcher = request.getRequestDispatcher("notes.jsp");
        dispatcher.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}