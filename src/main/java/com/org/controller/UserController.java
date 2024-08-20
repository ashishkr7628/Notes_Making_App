package com.org.controller;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.NotesDao;
import com.org.dao.SendingMail;
import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@Controller
public class UserController {
	
	@Autowired
	 private UserDao userDao;
	
	@Autowired
private NotesDao notesDao;
	
	
	@PostMapping("register")
	public ModelAndView userRegister(@ModelAttribute User user) {
		
		ModelAndView mav = new ModelAndView("register.jsp");
		
		userDao.insertAndUpdateUser(user);
		
		mav.addObject("msg","Registration Successful");
		
		return mav;
		
		
		
		
		
	}
	
	
	@PostMapping("login")
	public ModelAndView userRegister(@RequestParam String email, @RequestParam String password,HttpSession session) {
		
		ModelAndView mav =null;
		
		List<User> list = userDao.verifyAdminByEmailAndPassword(email, password);
		System.out.println(list);
		
		int userId = list.get(0).getId();
		String name = list.get(0).getName();
		
		session.setAttribute("userId", userId);
		session.setAttribute("userName", name);
		
		
		if(list.isEmpty()) {
	mav= new ModelAndView("login.jsp");
			
			mav.addObject("msg","Invalid Credentials");
			
		
			
			
		}
		
		
		else
		{
			
			mav=new ModelAndView("homepage.jsp");
		}
		
		
		
		
		
		
		
	
		
		return mav;
		
		
		
		
		
	}
	
	
	@PostMapping("/add_notes")
	
	public ModelAndView addNotes(@ModelAttribute Notes notes,HttpSession session) {
		
		ModelAndView mav = new ModelAndView("homepage.jsp");
		
		int userId =(int)session.getAttribute("userId");
		
		User user = userDao.fetchUserById(userId);
		List<Notes> notes2 = user.getNotes();
		notes2.add(notes);
		user.setNotes(notes2);
		userDao.insertAndUpdateUser(user);
		notes.setUser(user);
		
		notesDao.insertAndUpdateNotes(notes);
		
		return mav;
				
		
	}
	
	
	@GetMapping("/view_Notes")
	
	public ModelAndView viewNotes() {
		
		ModelAndView mav = new ModelAndView("notes/viewNotes.jsp");
		
		List<Notes> fetchAllNotes = notesDao.fetchAllNotes();
		
		mav.addObject("list",fetchAllNotes);
		
		
		
		
		return mav;
				
		
	}
	
	@RequestMapping("updateNotes")
	public ModelAndView updateNotes(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("notes/update_Notes.jsp");
		
		Notes notes = notesDao.fetchNotesById(id);
		
		mav.addObject("notes",notes);
		return mav;
		 
		
		
		
		
	}
	
	
	@RequestMapping("deleteNotes")
	public ModelAndView deleteNotes(@RequestParam int id, HttpSession session) {
		Notes tempNotes=null;
		ModelAndView mav = new ModelAndView("notes/viewNotes.jsp");
		
		int userId = (int)session.getAttribute("userId");
		
		User user = userDao.fetchUserById(userId);
		
		List<Notes> notes2 = user.getNotes();
		
		for(Notes notes: notes2) {
			if(notes.getId()==id) {
				tempNotes=notes;
				
				
			}
				
			
			
		}
		notes2.remove(tempNotes);
		
		user.setNotes(notes2);
		
		userDao.insertAndUpdateUser(user);
		
		Notes notes1 = notesDao.fetchNotesById(id);
		notes1.setUser(null);
		
		notesDao.insertAndUpdateNotes(notes1);
		
		notesDao.deleteNotesById(id);
		
	
		
	
		return mav;
		 
		
		
		
		
	}
	
	@GetMapping("viewUser")
	
	public ModelAndView viewUser(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("user/viewUser.jsp");
		
		int userId = (int)session.getAttribute("userId");
		
		User user = userDao.fetchUserById(userId);
		
		mav.addObject("user",user);
		
		return mav;
		
		
	}
	
	
	
	
	
	@GetMapping("updateUser")
	
	public ModelAndView updateUser(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("user/updateUser.jsp");
		
		User user = userDao.fetchUserById(id);
		
		mav.addObject("user",user);
		
		return mav;
		
		
	}
	
	
	@PostMapping("update")
	public ModelAndView userUpdate(@ModelAttribute User user) {
		
		ModelAndView mav = new ModelAndView("user/viewUser.jsp");
		
		userDao.insertAndUpdateUser(user);
		
	
		
		return mav;
		
		
		
		
		
	}
	

	

	
	
	@GetMapping("logout")
	
	public ModelAndView userLogout( HttpSession session) {
		
		ModelAndView mav = new ModelAndView("login.jsp");
		
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		
		
	
		
	
		
		return mav;
		
		
	}
	

	@GetMapping("forgot")
	
	public ModelAndView userForgot( ) {
		
		ModelAndView mav = new ModelAndView("user/userForgot.jsp");
		
		return mav;
		
		
		
	
		
	
	
		
	}
	
	
	@PostMapping("sendOtp")
	
	public ModelAndView sendOtp(@RequestParam String email,HttpSession session) throws MessagingException {
		
		Random random =  new Random();
		int r= 1000 + random.nextInt(9000);
		
		String otp = ""+r;
		
		SendingMail mail = new SendingMail();
		mail.mail(otp, email);
		
		
		
		ModelAndView mav = new ModelAndView("user/forgotPage.jsp");
		
		session.setAttribute("otp",otp);
		session.setAttribute("userEmail",email);
		
		
	
		
		return mav;
		
		
			
		
		
		
	}
	
	
	@PostMapping("reset")
	
	public ModelAndView sendOtp(@RequestParam String password, @RequestParam String userOtp,HttpSession session)  {
	String userEmail= (String) session.getAttribute("userEmail");
	String Otp= (String) session.getAttribute("otp");
	
	ModelAndView mav = new ModelAndView("index.jsp");
	
	if(userOtp.equals(Otp)) {
		
		User user = userDao.fetchByEmail(userEmail);
		
		user.setPassword(password);
		
		userDao.insertAndUpdateUser(user);
		
		mav.addObject("msg","password successfully changed");
		
		
	}
	
	
	
		
		return mav;
		
		
			
		
		
		
	}
	
	
	

		
		
		
		
	}
	
	
	
	
	

