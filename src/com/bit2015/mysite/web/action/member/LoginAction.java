package com.bit2015.mysite.web.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDao dao = new MemberDao();
		
		MemberVo vo = dao.get(request.getParameter("email"), request.getParameter("password"));
		
		if(vo == null) {
			//�α��� ���� ó�� 1
			//WebUtil.forwarding(request, response, "/views/user/loginform_error.jsp");
			
			//�α��� ���� ó��2
			WebUtil.redirect(response, "/mysite/member?a=loginform&result=error");
			return;
		}
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("authUser",vo);
		
		WebUtil.forwarding(request, response, "/views/main/index.jsp");
		
	}

}
