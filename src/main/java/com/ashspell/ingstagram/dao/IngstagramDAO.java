package com.ashspell.ingstagram.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ashspell.ingstagram.model.Ingstagram;



@Repository
public interface IngstagramDAO {

	
	
	public int insertUser(
			@Param("loginid") String loginid,
			@Param("password") String password,
			@Param("email") String email,
			@Param("name") String name);
	
	public Ingstagram selectUser(
			@Param("loginid") String loginid,
			@Param("password") String password);
	
	public int selectCountByloginId(@Param("loginid")String loginid)
	
	}

