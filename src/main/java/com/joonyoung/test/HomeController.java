package com.joonyoung.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "hello")
	public String hello(Model model) {
		
		model.addAttribute("data", "안녕 헬로월드!!");
		
		return "HelloWorld";
	}
	
	@RequestMapping(value = "member")
	public String member(Model model) {
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId("tiger");
		memberDto.setName("홍길동");
		memberDto.setEmail("abc@abc.com");
		memberDto.setAge(27);
		
		model.addAttribute("memberDto", memberDto);
		
		return "member/member";
	}
	
	@RequestMapping(value = "members")
	public String members(Model model) {
		
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		for(int i=1;i<11;i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setId("tiger"+i);
			memberDto.setName("홍길동");
			memberDto.setEmail("abc@abc.com");
			memberDto.setAge(27);
			
			memberDtos.add(memberDto);
		}
		
		model.addAttribute("memberDtos", memberDtos);
		
		return "member/eachTest";
	}
	
	@RequestMapping(value = "memberif")
	public String memberif(Model model) {
		
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		for(int i=1;i<11;i++) {
			
			MemberDto memberDto = new MemberDto();
			memberDto.setId("tiger"+i);
			memberDto.setName("홍길동");
			memberDto.setEmail("abc@abc.com");
			memberDto.setAge(27);
			
			memberDtos.add(memberDto);
		}
		
		model.addAttribute("memberDtos", memberDtos);
		
		return "member/ifTest";
	}

	
	@RequestMapping(value = "elseif")
	public String elseif(Model model) {
		
		List<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		MemberDto memberDto1 = new MemberDto();
		memberDto1.setAge(10);
		memberDto1.setName("이순신");
		
		MemberDto memberDto2 = new MemberDto();
		memberDto2.setAge(20);
		memberDto2.setName("김유신");
		
		MemberDto memberDto3 = new MemberDto();
		memberDto3.setAge(30);
		memberDto3.setName("강감찬");
		
//		memberDtos.add(memberDto1);
//		memberDtos.add(memberDto2);
//		memberDtos.add(memberDto3);
		
		model.addAttribute("member1", memberDto1);
		model.addAttribute("member2", memberDto2);
		model.addAttribute("member3", memberDto3);
		
		
		return "member/elseifTest";
	}
	
	@RequestMapping(value = "/hreftest")
	public String hrefTest(Model model) {
		
		
		
		return "member/hrefTest";
	}
	
	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "member/login";
	}
	
	@RequestMapping(value = "content")
	public String content() {
		
		return "content";
	}
	
}