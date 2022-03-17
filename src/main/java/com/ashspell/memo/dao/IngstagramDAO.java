package com.ashspell.memo.dao;

import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;



@Repository
public interface IngstagramDAO {

	
	
	public int insertUser(
			@Param("loginid") String loginid,
			@Param("password") String password,
			@Param("email") String email,
			@Param("name") String name);
	
		
	}

