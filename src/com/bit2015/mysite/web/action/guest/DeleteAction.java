package com.bit2015.mysite.web.action.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.GuestbookDao;
import com.bit2015.mysite.vo.GuestBookVo;
import com.bit2015.web.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestBookVo vo = new GuestBookVo();
		
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setPassword(request.getParameter("password"));
		
		GuestbookDao dao = new GuestbookDao();
		dao.delete(vo);
		
		response.sendRedirect("/mysite/guest");
	}

}
