package com.bit2015.mysite.web.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardVo vo = new BoardVo();
		
		vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		
		BoardDao dao = new BoardDao();

		viewCntUpdate(vo, dao);
		
		List<BoardVo> list = dao.getList(vo);
		request.setAttribute("list", list);
		
		WebUtil.forwarding(request, response, "/views/board/view.jsp");
		
		
	}
	
	public void viewCntUpdate(BoardVo vo, BoardDao dao){
		
		dao.viewCntUpdate(vo);
	}

}
