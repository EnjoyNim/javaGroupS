package com.spring.javaGroupS.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.spring.javaGroupS.vo.UserVO;

public interface DbtestDAO {

	ArrayList<UserVO> getDbtestList();

										// 이렇게 해주면 vo 를 가지고 dbtestMapper.xml 에서 vo 를 사용할 수 있다.
	int setDbtestInputOk(@Param("vo") UserVO vo);

														// 이런 변수 한개는 @Param("mid") 를 안해줘도 된다.
	UserVO getDbtestCheckForm(@Param("mid") String mid);

		// 탬플릿을 안쓰고 할 것이다.
}
