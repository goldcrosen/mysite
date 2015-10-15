package com.bit2015.mysite.web.action.board;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {

		Action action = null;
		
		if("view".equals(actionName)){
			action = new ViewAction();
		}else if("delete".equals(actionName)){
			action = new DeleteBoardAction();
		}else if("updateForm".equals(actionName)){
			action = new UpdateFormAction();
		}else if("update".equals(actionName)){
			action = new UpdateAction();
		}else if("writeForm".equals(actionName)){
			action = new writeFormAction();
		}else if("write".equals(actionName)){
			action = new WriteAction();
		}else{
			action = new BoardListAction();
		}
		
		return action;
		
	}

}
