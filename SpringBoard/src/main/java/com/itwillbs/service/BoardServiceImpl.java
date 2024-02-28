package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	// DAO객체 주입
	@Inject
	private BoardDAO bdao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		logger.debug(" regist(BoardVO vo) 실행 -> DAO 글쓰기 동작 호출 ");
		bdao.boardCreate(vo);
	}

	@Override
	public List<BoardVO> getList() throws Exception {
		logger.debug(" getList() 실행 ");
		
		return bdao.boardListSelect();
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug(" getBoard(int bno) 실행 -> DAO 게시글 조회 동작 호출 ");
		
		return bdao.getBoard(bno);
	}

	@Override
	public void updateViewcnt(int bno) throws Exception {
		logger.debug(" updateViewcnt(int bno) 실행 ");
		
		bdao.boardViewcntUpdate(bno);
	}

	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		logger.debug(" updateBoard(BoardVO vo) 실행 ");
	
		bdao.boardUpdate(vo);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		logger.debug(" deleteBoard(int bno) 실행 ");
		
		bdao.boardDelete(bno);
	}
	
	
}
