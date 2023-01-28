package kr.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {

	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/memJoin.do")
	public String memJoin() {
		return "member/join"; //join.jsp
	}
	
	
	@RequestMapping("/memRegisterCheck.do")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
	  
	  Member m = memberMapper.registerCheck(memID);
	  
	  if(m != null || memID.equals("")) { 
		  return 0; //이미 존재하는 회원, 입력불가 }
	  	}
	  
	  return 1; //사용가능한 아이디 }
	
	  }
	
	//회원가입 처리
	@RequestMapping("/memRegister.do")
	public String memRegister(Member m, String memPassword1, String memPassword2, RedirectAttributes rttr, HttpSession session) {
		if(m.getMemID() == null || m.getMemID().equals("") ||
		   memPassword1 == null || memPassword1.equals("") ||
		   memPassword1 == null || memPassword1.equals("") ||
		   m.getMemName() == null || m.getMemName().equals("") ||
		   m.getMemAge() == 0 ||
		   m.getMemGender() == null || m.getMemGender().equals("") ||
		   m.getMemEmail() == null || m.getMemEmail().equals("")) {
			//누락메세지를 가지고 가기? => 객체바인딩(Model,HttpServletRequest, HttpSession)
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "모든 내용을 입력하세요.");
			return "redirect:/memJoin.do"; //${msgType}, ${msg}
		}
		if(!memPassword1.equals(memPassword2)) {
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "비밀번호가 서로 다릅니다.");
			return "redirect:/memJoin.do";
		}
		
		
		m.setMemProfile(""); //사진이미지는 없다는 의미 ""
		//회원을 테이블에 저장하기
		int result = memberMapper.register(m);
		if(result == 1) { //회원가입 성공 메세지
			rttr.addFlashAttribute("msgType", "성공 메세지");
			rttr.addFlashAttribute("msg", "회원가입에 성공했습니다.");
			//회원가입이 성공하면 => 로그인처리하기
			session.setAttribute("mvo", m); //${!empty m}
			return "redirect:/";
		} else { //회원가입 실패 메세지
			rttr.addFlashAttribute("msgType", "실패 메세지");
			rttr.addFlashAttribute("msg", "이미 존재하는 회원입니다.");
			return "redirect:/memJoin.do";
		}
		
	}

}
