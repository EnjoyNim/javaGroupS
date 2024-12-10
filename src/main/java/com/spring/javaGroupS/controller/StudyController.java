package com.spring.javaGroupS.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.javaGroupS.service.DbtestService;
import com.spring.javaGroupS.service.StudyService;
import com.spring.javaGroupS.vo.UserVO;

//@RestController   // 이걸 해주면 문자에 대한 응답을 해버린다. REST API 의 개념, 이렇게 하면 return 으로 주소를 넘겨줘도 그냥 텍스트로 인식한다.
@Controller
@RequestMapping("/study")
public class StudyController {

	@Autowired
	StudyService studyService;
	
	@Autowired
	DbtestService dbtestService;
	
	@RequestMapping(value="/ajax/ajaxForm", method = RequestMethod.GET)
	public String ajaxFormGet() {
		return "study/ajax/ajaxForm";
	}
	
	@RequestMapping(value="/ajax/ajaxTest1", method = RequestMethod.GET)
	public String ajaxTest1Get(Model model, int idx) {
		model.addAttribute("idx", idx);
		return "study/ajax/ajaxForm";
	}
	
	@ResponseBody   // 이걸 해주면 response 바디로 바로 반환한다. ajax 의 응답으로서 그냥 바로 텍스트로 전송한다.
	@RequestMapping(value="/ajax/ajaxTest2", method = RequestMethod.GET)
	public String ajaxTest2Get(int idx) {
		
		System.out.println("idx:"+idx);
		
		return idx+"";
	}
	
	@ResponseBody   // 이걸 해주면 response 바디로 바로 반환한다. ajax 의 응답으로서 그냥 바로 텍스트로 전송한다.
	@RequestMapping(value="/ajax/ajaxTest3", method = RequestMethod.POST, produces="application/text; charset=utf-8")
	public String ajaxTest3Post(String str) {
		
		System.out.println("str:"+str);
		// 이게 jsp 로 가는게 아니라 그냥 텍스트로 가기때문에 받는 jsp 의 처음에 있는 utf-8 한글 인코딩하라는 표시를 못해준다.
		// 한글의 경우에 엉뚱한 문자셋으로 인코딩이 되어 가버린다. 따라서 여기에서 utf-8 으로 인코딩해줘야한다.
		return str;
	}
	
	@RequestMapping(value="/ajax/ajaxTest4_1", method = RequestMethod.GET)
	public String ajaxTest4_1Get() {
		return "study/ajax/ajaxTest4_1";
	}
	
	// 배열 형식(문자열)의 처리
	@ResponseBody   // 이걸 해주면 response 바디로 바로 반환한다. ajax 의 응답으로서 그냥 바로 텍스트로 전송한다.
	@RequestMapping(value="/ajax/ajaxTest4_1", method = RequestMethod.POST)
	public String[] ajaxTest4_1Post(String dodo) {
			// 배열을 이렇게 보낼 수 있다. 자바스크립트도 배열로 받는다. 
			// 아마도 "내용","내용","null" 이렇게 가는듯
			return studyService.getCityStringArray(dodo);  
	}
	
	@RequestMapping(value="/ajax/ajaxTest4_2", method = RequestMethod.GET)
	public String ajaxTest4_2Get() {
		return "study/ajax/ajaxTest4_2";
	}
	
	// ArrayList의 처리
	@ResponseBody   // 이걸 해주면 response 바디로 바로 반환한다. ajax 의 응답으로서 그냥 바로 텍스트로 전송한다.
	@RequestMapping(value="/ajax/ajaxTest4_2", method = RequestMethod.POST)
	public ArrayList<String> ajaxTest4_2Post(String dodo) {
		// ArrayList 도 그냥 보내진다. 아마도 "내용","내용","null" 이렇게 가는듯
		return studyService.getCityStringArrayList(dodo);  	
	}
	
	
	
	@RequestMapping(value="/ajax/ajaxTest4_3", method = RequestMethod.GET)
	public String ajaxTest4_3Get() {
		return "study/ajax/ajaxTest4_3";
	}
	
	// Map의 처리
	@ResponseBody   // 이걸 해주면 response 바디로 바로 반환한다. ajax 의 응답으로서 그냥 바로 텍스트로 전송한다.
	@RequestMapping(value="/ajax/ajaxTest4_3", method = RequestMethod.POST)
	public HashMap<Object, Object> ajaxTest4_3Post(String dodo) {
		// "key": ["내용", "내용", "null"]  형태로 간다.
		HashMap<Object, Object> hashMap = new HashMap<>();
		
		hashMap.put("city", studyService.getCityStringArrayList(dodo));
		
		return hashMap;  	
	}
	
	
	@RequestMapping(value="/ajax/ajaxTest4_4", method = RequestMethod.GET)
	public String ajaxTest4_4Get(Model model) {
		ArrayList<String> midVos = dbtestService.getDbtestMidList();
		model.addAttribute("midVos", midVos);
		return "study/ajax/ajaxTest4_4";
	}
	
	@ResponseBody
	@RequestMapping(value="/ajax/ajaxTest4_4", method = RequestMethod.POST, produces="application/text; charset=utf-8")
	public String ajaxTest4_4Post(String mid) {
		UserVO vo = dbtestService.getDbtestIdCheckForm(mid);
		String str = "<h3>회원정보</h3>";
		str += "아이디 :" + vo.getMid() + "<br>";
		str += "비밀번호 :" + vo.getPwd() + "<br>";
		str += "성명 :" + vo.getName() + "<br>";
		str += "나이 :" + vo.getAge() + "<br>";
		str += "성별 :" + vo.getGender() + "<br>";
		str += "주소 :" + vo.getAddress() + "<br>";
		return str; 
	}
	
}
