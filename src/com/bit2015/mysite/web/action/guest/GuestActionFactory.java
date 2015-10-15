package com.bit2015.mysite.web.action.guest;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class GuestActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
	
		Action action = null;
		if ("insert".equals(actionName)) {
			action = new InsertAction();
		}else if("deleteForm".equals(actionName)){
			action = new DeleteFormAction();
		}else if("delete".equals(actionName)){
			action = new DeleteAction();
		}else{
			action = new ListAction();
		}
		
		return action;
	}

}
