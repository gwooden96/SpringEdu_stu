package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	
	// /boardList.do
	@Autowired
	private BoardMapper mapper;
	
	// HandlerMapping
	@RequestMapping("/boardList.do") 
	public String boardList(Model model) {
	
		List<Board> list = mapper.getLists();
		model.addAttribute("list", list);
		
		return "boardList"; // /WEB-INF/views/boardList.jsp -> forward
	}
	
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm"; // /WEB-INF/views/boardForm.jsp -> forward
	}
	
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) { // title, content, writer파라메터 수집(Board)
		mapper.boardInsert(vo); // 등록
		return "redirect:/boardList.do"; //redirect
	}

	
}
