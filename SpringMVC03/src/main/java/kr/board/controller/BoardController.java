package kr.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

//	@Autowired
//	BoardMapper boardMapper;

	@RequestMapping("/boardMain.do")
	public String main() {
		return "board/main";
	}

	/*
	 * // @ResponseBody -> jackson-databind(객체를 -> JSON 데이터포맷으로 변환)
	 * 
	 * @RequestMapping("/boardList.do") public @ResponseBody List<Board> boardList()
	 * { List<Board> list = boardMapper.getLists(); return list; // JSON 데이터 형식으로
	 * 변환(API)해서 리턴(응답)하겠다. }
	 * 
	 * @RequestMapping("/boardInsert.do") public @ResponseBody void
	 * boardInsert(Board vo) { boardMapper.boardInsert(vo); }
	 * 
	 * @RequestMapping("/boardDelete.do") public @ResponseBody void
	 * boardDelete(@RequestParam("idx") int idx) { boardMapper.boardDelete(idx); }
	 * 
	 * @RequestMapping("/boardUpdate.do") public @ResponseBody void
	 * boardUpdate(Board vo) { boardMapper.boardUpdate(vo); }
	 * 
	 * @RequestMapping("/boardContent.do") public @ResponseBody Board
	 * boardContent(int idx) { Board vo = boardMapper.boardContent(idx); return vo;
	 * }
	 * 
	 * @RequestMapping("/boardCount.do") public @ResponseBody Board boardCount(int
	 * idx) { boardMapper.boardCount(idx); Board vo = boardMapper.boardContent(idx);
	 * return vo; }
	 */

}
