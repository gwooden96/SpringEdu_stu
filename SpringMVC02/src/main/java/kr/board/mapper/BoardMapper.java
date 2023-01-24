package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper // Mybatis API
public interface BoardMapper {
	
	public List<Board> getLists(); //전체리스트 조회
	public void boardInsert(Board vo); //글쓰기 추가
	public Board boardContent(int idx); //내용 상세보기 조회
	public void boardDelete(int idx); //글 삭제
	public void boardUpdate(Board vo); //글 업데이트
	
	@Update("update myboard set count=count+1 where idx=#{idx}")
	public void boardCount(int idx); //조회수 누적

}
