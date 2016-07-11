package user;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction {
	
	
	
	public String projectAdd(){
		System.out.println("projectAdd:");
		
		return ActionSupport.SUCCESS;
	}
	
	
	public String projectManage(){
		System.out.println("projectManage:");
		
		return ActionSupport.SUCCESS;
	}
	
	public String information(){
		System.out.println("information:");
		
		return ActionSupport.SUCCESS;
	}
}
