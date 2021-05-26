package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardExt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	@Override
	public List<BoardExt> selectBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public List<BoardExt> selectBoardList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(param);
	}

	@Override
	public int selectBoardTotalContents() {
		// TODO Auto-generated method stub
		return  boardDao.selectBoardTotalContents();
	}
	
	/**
	 * rollbackFor - 트랜젝션 rollback처리하기위한 예외 등록, Exception -> 모든 예외.
	 * 		기본적으로 RuntimeException만 rollback한다.
	 */
//	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertBoard(BoardExt board) {
		int result = 0;
		//1.board 등록
		result = boardDao.insertBoard(board);
		//callbyreference원리로 작동
		log.debug("board ={}",board);
		
		//2.attachment 등록
		if(board.getAttachList().size() > 0) {
			for(Attachment attach: board.getAttachList()) {
				attach.setBoardNo(board.getNo()); //이번에 발급받은 board pk|  board no fk세팅
				result = insertAttachment(attach);
			}
		}
		
		return result;
	}
//	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertAttachment(Attachment attach) {
		return boardDao.insertAttachment(attach);
	}

	@Override
	public BoardExt selectOneBoardCollection(int no) {
		// TODO Auto-generated method stub
		return boardDao.selectOneBoardCollection(no);
	}

	@Override
	public BoardExt selectOneBoard(int no) {
		BoardExt board = boardDao.selectOneBoard(no);
		List<Attachment> attachList = boardDao.selectListAttach(no);
		board.setAttachList(attachList);
		
		return board;
	}

	@Override
	public List<Attachment> selectListAttach(int no) {
		// TODO Auto-generated method stub
		return boardDao.selectListAttach(no);
	}
}
