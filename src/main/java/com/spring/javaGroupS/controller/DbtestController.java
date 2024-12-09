package com.spring.javaGroupS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.javaGroupS.service.DbtestService;
import com.spring.javaGroupS.vo.UserVO;

@Controller
@RequestMapping("/dbtest")
public class DbtestController {
	
	@Autowired
	private DbtestService dbtestService;
	
	
	@RequestMapping("/dbtestList")
	public String dbtestListGet(Model model) {
		List<UserVO> vos = dbtestService.getDbtestList();
		model.addAttribute("vos", vos);
		return "dbtest/dbtestList";
	}
	
	@RequestMapping("/dbtestInputOk")
	public String dbtestInputOkGet(UserVO vo) {
		int res = dbtestService.setDbtestInputOk(vo);
		
		if(res!=0) return "redirect:/message/dbtestInputOk";
		else return "redirect:/message/dbtestInputNo";
		
	}
	
	@RequestMapping("/dbtestIdCheckForm")
	public String dbtestInputOkGet(Model model, String mid) {
		
			UserVO vo = dbtestService.getDbtestCheckForm(mid);
			
			String isDuplicateId = "";
			
			if(vo != null) isDuplicateId = "YES";
			else isDuplicateId = "NO";
			
			model.addAttribute("isDuplicateId", isDuplicateId);
			model.addAttribute("mid", mid);
		
		 return "dbtest/dbtestIdCheckForm";
		
	}
	
	
}
