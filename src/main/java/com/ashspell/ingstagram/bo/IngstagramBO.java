package com.ashspell.ingstagram.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashspell.ingstagram.common.EncryptUtils;
import com.ashspell.ingstagram.dao.IngstagramDAO;
import com.ashspell.ingstagram.model.Ingstagram;

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
	
	public Ingstagram getUser(
				String loginid,
				String password) {
		
		String encryptPassword = EncryptUtils.md5(password);

		return ingstagramDAO.selectUser(loginid, password);
	}
	
	public boolean isDuplicateId(String loginid) {
		
		int count = ingstagramDAO.selectCountByloginId(loginid);
		
		return (count != 0);
		
	}
}
