package com.spring.javaGroupS.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.javaGroupS.vo.UserVO;

public interface DbtestDAO {

	ArrayList<UserVO> getDbtestList();

										
	int setDbtestInputOk(@Param("vo") UserVO vo);

														
	UserVO getDbtestCheckForm(@Param("mid") String mid);


	int setDbtestUpdate(@Param("vo") UserVO vo);


	UserVO getDbtestRecByIdx(int idx);


	int setDbtestDeleteOk(int idx);

		
}
