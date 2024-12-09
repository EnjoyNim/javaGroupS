package com.spring.javaGroupS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	
	// 정보 수정폼 보기
	@RequestMapping("/dbtestUpdate")
	public String dbtestUpdateGet(Model model, int idx) {
		
		System.out.println("dbtestUpdateGet");
		
		
		UserVO vo = dbtestService.getDbtestRecByIdx(idx);
		System.out.println("vo:"+vo.toString());
		
		model.addAttribute("vo", vo);
		
		return "dbtest/dbtestUpdate";
		
	}
	
	// 이상한걸 발견했다. 회원정보수정에서 주소창에 가지고온 http://localhost:8080/javaGroupS/dbtest/dbtestUpdate?mid=admin 이라고
	// 되어 있으면 이걸 바로 아래의 post 에서 받을때 vo 를 찍어보면 mid 가 admin, admin 으로 나오는걸 알 수 있다.  롬복이 vo 객체의 필드에 값을 넣을때 
	// 여기에서 post 방식으로 받아도 주소에 딸려온 mid=admin 을 보고 다시 mid 필드에 추가해서 더해지는듯? 이상한게 idx 로 하면 멀쩡하다.  숫자는 교체되고
	// 문자열은 추가되어서 그런가??
	
	// 정보 수정 처리
	@RequestMapping(value = "/dbtestUpdate", method = RequestMethod.POST)
	public String dbtestUpdatePost(UserVO vo) {
		System.out.println("dbtestUpdatePost");
		System.out.println("vo:"+vo.toString());
		
		int res = dbtestService.setDbtestUpdate(vo);
		
		if(res!=0) return "redirect:/message/dbtestUpdateOk";
		else return "redirect:/message/dbtestUpdateNo?mid="+vo.getIdx();
		
	}
	
	// 개별 회원 삭제
	@RequestMapping(value = "/dbtestDeleteOk", method = RequestMethod.GET)
	public String userDeleteOkGet(int idx) {
		int res = dbtestService.setDbtestDeleteOk(idx);
		if(res != 0) return "redirect:/message/dbtestDeleteOk";
		else return "redirect:/message/dbtestDeleteNo";
	}
	
}
