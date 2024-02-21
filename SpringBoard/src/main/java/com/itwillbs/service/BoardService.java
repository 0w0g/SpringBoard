package com.itwillbs.service;

import javax.inject.Inject;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

// 컨트롤러와 DAO를 연결하는 역할

// 컨트롤러가 외부 호출에 종속적인 상황 방지

public interface BoardService {


	
	// 글쓰기 동작
	public void regist(BoardVO vo) throws Exception;
	
}
