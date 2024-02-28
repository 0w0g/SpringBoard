package com.itwillbs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	// DAO객체 주입
	@Inject
	private BoardService bService;
		
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	// 글쓰기GET : /board/register
	// http://localhost:8088/board/register
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.debug(" /board/register -> registerGET() 호출 ");
		logger.debug(" /board/register.jsp 뷰 연결 ");
		
	}
	
	// 글쓰기 POST : /board/register
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO vo) throws Exception {
		logger.debug(" /board/register.jsp (submit) -> registerPOST() 호출 ");
		
		// 한글처리(필터) 생략
		// 전달정보(글 정보) 저장
		logger.debug(" 전달정보 : "+vo.toString());
		
		// 서비스 -> DAO 글쓰기 동작 호출 
		bService.regist(vo);
		
		logger.debug(" 글쓰기 완료! -> 리스트 페이지로 이동 ");
		
		// 페이지 이동 (list) 
		return "redirect:/board/list";
	}
	
	// 리스트GET : /board/List;
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGET(Model model, HttpSession session) throws Exception{
		logger.debug(" /board/list -> listGET()실행 ");
		logger.debug(" 서비스 실행 ");
		// 서비스 -> 게시판 글 목록 가져오기
		List<BoardVO> boardList = bService.getList();
		logger.debug(" list.size : "+boardList.size());
		// 연결됨 뷰페이지에 정보 전달
		model.addAttribute("boardList",boardList);
		
		// 조회수 상태 0 : 조회수 증가 X , 1 : 조회수 증가 O 
		session.setAttribute("viewUpdateStatus", 1);
	}
	
	@RequestMapping(value="/read", method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno, Model model, HttpSession session) throws Exception{
		// @ModelAttribute : 파라메터 저장 + 영역 저장 (1:N 관계)
		// @RequestParam : 파라메터 저장 (1:1 관계)
		// int bno로 받아와도 ㄱㅊ 
		
		logger.debug(" /board/read -> readGET() 호출 ");
		
		// 전달정보 저장
		logger.debug(" bno : "+bno);
		
		int status = (Integer)session.getAttribute("viewUpdateStatus");
		
		if(status == 1) {
			// 서비스 -> DAO 게시판 글 조회수 1증가
			bService.updateViewcnt(bno);
			// 조회수 상태 0 : 조회수 증가 X, 1 : 조회수 증가 0
			session.setAttribute("viewUpdateStatus", 0);
		}
		
		// 서비스 -> DAO 게시판 글정보 조회 동작
		BoardVO resultVO = bService.getBoard(bno);
		logger.debug("resultVO : "+resultVO.toString());
		// 해당정보를 저장 -> 연결된 뷰페이지로 전달
		model.addAttribute("boardVO", resultVO);
		// 뷰페이지로 이동
			
	}
	
	// 본문수정 GET : /board/modify?bno=000
	@RequestMapping(value = "/modify" ,method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno, Model model) throws Exception{
		logger.debug(" /board/modify -> modifyGET() 호출 ");
		
		// 전달받은 정보 (bno) 저장
		logger.debug(" bno : "+bno);
		// 서비스 -> DAO 특정 글정보 조회 동작
		// BoardVO vo = bService.getBoard(bno);
		// 연결된 뷰페이지에 전달(Model)
		model.addAttribute(bService.getBoard(bno));
		// 연결된 뷰페이지 (/board/modify.jsp)
		
	}
	
	// 본문수정 POST : /board/modify
	@RequestMapping(value="/modify" ,method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception{
		logger.debug(" /board/modify -> modifyPOST() 호출 ");
		
		// 한글처리 인코딩
		// 전달정보 저장(bno,title,writer,content)
		logger.debug(" vo : "+vo.toString());
		// 서비스 -> DAO 게시판 글 정보 수정 
		bService.updateBoard(vo);
		// 수정완료 후에 list 페이지로 이동(redirect)
		
		return "redirect:/board/list";
	}
	
	// 글 삭제
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String deleteGET(int bno) throws Exception{
		logger.debug(" /board/delete -> deleteGET 호출 ");
		
		logger.debug("bno : "+bno);
		
		bService.deleteBoard(bno);
		
		return "redirect:/board/list";
	}
	
}
