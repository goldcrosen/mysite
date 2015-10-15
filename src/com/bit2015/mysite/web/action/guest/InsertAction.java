package com.bit2015.mysite.web.action.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestBookVo;
import com.bit2015.web.action.Action;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GuestBookVo vo = new GuestBookVo();
		
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setMessage(request.getParameter("content"));
		
		GuestbookDao dao = new GuestbookDao();
		dao.insert(vo);
		
		response.sendRedirect("/mysite/guest");
	}

}
