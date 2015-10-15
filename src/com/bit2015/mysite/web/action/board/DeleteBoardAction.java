package com.bit2015.mysite.web.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.action.Action;

public class DeleteBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo(); 
		vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		
		dao.delete(vo);
		
		response.sendRedirect("/mysite/board");
	}

}
