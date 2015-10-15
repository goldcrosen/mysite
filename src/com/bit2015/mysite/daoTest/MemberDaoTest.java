package com.bit2015.mysite.daoTest;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		//insertTest();
		getTest();
		//updateTest();
	}
	
	public static void getTest(){
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.get("dd", "s");
		System.out.println(vo);
	}
	
	public static void insertTest(){
		MemberDao dao = new MemberDao();
		
		MemberVo vo = new MemberVo();
		
		vo.setName("nameTest");
		vo.setEmail("emailTest");
		vo.setPassword("passwordTest");
		vo.setGender("genderTest");
		
		dao.insert(vo);
	}
	
	public static void updateTest(){
		MemberDao dao = new MemberDao();
		
		MemberVo vo = new MemberVo();
		
		vo.setNo(2L);
		vo.setName("업데이트네임");
		vo.setEmail("dd");
		vo.setPassword("s");
		vo.setGender("ss");
		
		dao.update(vo);
	}

}
