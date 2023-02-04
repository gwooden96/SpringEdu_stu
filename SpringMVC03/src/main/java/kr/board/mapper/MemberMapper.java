package kr.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Member;

@Mapper // Mybatis API
public interface MemberMapper {
		
	public Member registerCheck(String memID);
	
	public int register(Member m); //회원등록 (성공 1,  실패 0)

	public Member memLogin(Member mvo); //로그인체크
	
	public int memUpdate(Member mvo); //수정하기
	
	public Member getMember(String memID);
	
	public void memProfileUpdate(Member mvo); //신규 이미지 업데이트
	
	
	
}
