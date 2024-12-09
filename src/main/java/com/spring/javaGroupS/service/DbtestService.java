package com.spring.javaGroupS.service;

import java.util.ArrayList;
import com.spring.javaGroupS.vo.UserVO;

public interface DbtestService {

	ArrayList<UserVO> getDbtestList();

	int setDbtestInputOk(UserVO vo);

	UserVO getDbtestCheckForm(String mid);

}
