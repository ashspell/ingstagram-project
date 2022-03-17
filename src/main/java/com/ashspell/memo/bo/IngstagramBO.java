package com.ashspell.memo.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.memo.dao.IngstagramDAO;

@Service
public class IngstagramBO {
	
	@Autowired
	private IngstagramDAO ingstagramDAO;
	
	public int addUser(
			String loginid,
			String password,
			String email,
			String name) {
		
		return  ingstagramDAO.insertUser(loginid, password, email, name);
	}
}
