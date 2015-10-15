package com.bit2015.mysite.web.action.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVo vo = new BoardVo();
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		
		List<BoardVo> list = new ArrayList<BoardVo>();
		list.add(vo);
		
		request.setAttribute("list", list);
		
		WebUtil.forwarding(request, response, "/views/board/modify.jsp");
	}

}
