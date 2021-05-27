package com.kh.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.BoardExt;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public List<BoardExt> selectBoardList() {
		return session.selectList("board.selectBoardList");
	}

	@Override
	public List<BoardExt> selectBoardList(Map<String, Object> param) {
		int offset = (int) param.get("offset");
		int limit = (int) param.get("limit");
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return session.selectList("board.selectBoardList",null,rowBounds);
	}

	@Override
	public int selectBoardTotalContents() {
		return session.selectOne("board.selectBoardTotalContents");
	}

	@Override
	public int insertBoard(BoardExt board) {
		// TODO Auto-generated method stub
		return session.insert("board.insertBoard",board);
	}

	@Override
	public int insertAttachment(Attachment attach) {
		// TODO Auto-generated method stub
		return session.insert("board.insertAttachment",attach);
	}

	@Override
	public BoardExt selectOneBoard(int no) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectOneBoard",no);
	}

	@Override
	public List<Attachment> selectListAttach(int boardNo) {
		// TODO Auto-generated method stub
		return session.selectList("board.selectListAttach",boardNo);
	}

	@Override
	public BoardExt selectOneBoardCollection(int no) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectOneBoardCollection",no);
	}

	@Override
	public Attachment selectOneAttachment(int no) {
		// TODO Auto-generated method stub
		return session.selectOne("board.selectOneAttachment",no);
	}

	@Override
	public List<BoardExt> autocomplete(String search) {
		// TODO Auto-generated method stub
		return session.selectList("board.autocomplete",search);
	}
	
	
	
}
