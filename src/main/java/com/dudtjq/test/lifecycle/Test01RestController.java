package com.dudtjq.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dudtjq.test.lifecycle.board.gameBoard;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01RestController {
	
	// 내가 출력을 하고자 하는 클래스와 리턴하는 것이 같아야한다!
	@RequestMapping("/3")
	public List<Map<String, Object>> listMovie(){
		
		List<Map<String, Object>> movieList = new ArrayList<>();

	    Map<String, Object> movieInfo = new HashMap<>();
	    
	    movieInfo.put("rate", 15);
	    movieInfo.put("directer", "봉준호");
	    movieInfo.put("time", 131);
	    movieInfo.put("title", "기생충");
	    movieList.add(movieInfo);
	    
	    movieInfo = new HashMap<>();
	    movieInfo.put("rate", 0);
	    movieInfo.put("directer", "로베르토 베니니");
	    movieInfo.put("time", 116);
	    movieInfo.put("title", "인생은 아름다워");
	    movieList.add(movieInfo);
	    
	    movieInfo = new HashMap<>();
	    movieInfo.put("rate", 12);
	    movieInfo.put("directer", "크리스토퍼 놀란");
	    movieInfo.put("time", 147);
	    movieInfo.put("title", "인셉션");
	    movieList.add(movieInfo);
	    
	    movieInfo = new HashMap<>();
	    movieInfo.put("rate", 19);
	    movieInfo.put("directer", "윤종빈");
	    movieInfo.put("time", 133);
	    movieInfo.put("title", "범죄와의 전쟁 : 나쁜놈들 전성 시대");
	    movieList.add(movieInfo);
	    
	    movieInfo = new HashMap<>();
	    movieInfo.put("rate", 15);
	    movieInfo.put("directer", "프란시스 로렌스");
	    movieInfo.put("time", 137);
	    movieInfo.put("title", "헝거게임");
	    movieList.add(movieInfo);
	    
	    return movieList;
	    	
	}
	
	@RequestMapping("/4")
	public List<gameBoard> gameBoardList() {
		
		// 리스트 <>안에 만들어 놓았던 클래스를 집어 넣어준다! 그 뒤론 맵과 동일하게 사용! 
		List<gameBoard> boardList = new ArrayList<>();
		
		gameBoard gameBoard = new gameBoard();
		
		gameBoard.setTitle("안녕하세요 가입인사 드립니다.");
		gameBoard.setUser("hiting");
		gameBoard.setContents("안녕하세요 잘부탁드립니다.");
		boardList.add(gameBoard);
		
		gameBoard = new gameBoard();
		gameBoard.setTitle("안녕하세요");
		gameBoard.setUser("onhit");
		gameBoard.setContents("인사 오지게 박습니다.");
		boardList.add(gameBoard);
		
		gameBoard = new gameBoard();
		gameBoard.setTitle("안녕하십니까?");
		gameBoard.setUser("hiting2");
		gameBoard.setContents("오늘 가입했습니다 잘부탁드려용~");
		boardList.add(gameBoard);
		
		return boardList;
		
	}
	
	// ResponseEntity<gameBoard> 요것에 맞춰서 리턴해준다!
	@RequestMapping("/5")
	public ResponseEntity<gameBoard> entity() {
		
		gameBoard gameBoard = new gameBoard();
		
		gameBoard.setTitle("안녕하세요 가입인사 드립니다.");
		gameBoard.setUser("hiting");
		gameBoard.setContents("안녕하세요 잘부탁드립니다.");
		
		ResponseEntity<gameBoard> entity = new ResponseEntity(gameBoard, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;

	}
	
	 
	

	
	
}
