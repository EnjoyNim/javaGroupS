package com.spring.javaGroupS.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.javaGroupS.dao.DbtestDAO;
import com.spring.javaGroupS.vo.UserVO;

@Service
public class DbtestServiceImpl implements DbtestService {

		@Autowired
		DbtestDAO dbtestDAO;

		@Override
		public ArrayList<UserVO> getDbtestList() {
			return dbtestDAO.getDbtestList();
		}

		@Override
		public int setDbtestInputOk(UserVO vo) {
			return dbtestDAO.setDbtestInputOk(vo);
		}

		@Override
		public UserVO getDbtestCheckForm(String mid) {
			// TODO Auto-generated method stub
			return dbtestDAO.getDbtestCheckForm(mid);
		}
}