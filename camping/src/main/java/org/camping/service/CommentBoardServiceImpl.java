package org.camping.service;

import java.util.List;
import org.camping.mapper.CommentBoardMapper;
import org.camping.model.BoardDTO;
import org.camping.model.CommentBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentBoardServiceImpl implements CommentBoardService {

	@Autowired
	private CommentBoardMapper mapper;
	
	@Override
	public CommentBoardDTO getCommentBoard(int comnum) {
		return mapper.getCommentBoard(comnum);
	}
	
	@Override
	public BoardDTO getBoard(int boardnum) {
		return mapper.getBoard(boardnum);
	}
	
	@Override
	public List<CommentBoardDTO> getCommentBoards(int startRow, int endRow) {
		return mapper.getCommentBoards(startRow, endRow);
	}
	
	@Override
	public int getCommentBoardCount() {
		return mapper.getCommentBoardCount();
	}
	
	@Override
	public void insertCommentBoard(CommentBoardDTO dto) {	// number�� ref(�׷��ȣ).
		int number = mapper.maxNum()+1;
		
		if(dto.getBoardnum() != 0) {				// ��۾��� �Ҷ���! �׷�ref�� �����ϱ� �Ƚ��൵��, else�� �����϶�! 0�̴ϱ� �� �ʿ� ����.
			mapper.stepUp(dto);
			dto.setCom_ref(dto.getCom_ref()+1);		// dto���� �����Ÿ� �ٽ� set����.
			dto.setCom_step(dto.getCom_step()+1);
		}else{
			dto.setCom_ref(number);	// 
		}
		mapper.insertCommentBoard(dto);
	}
	
	@Override
	public int updateCommentBoard(CommentBoardDTO dto) {
		return mapper.updateCommentBoard(dto);
	}
	
	@Override
	public void deleteCommentBoard(CommentBoardDTO dto) {
		mapper.deleteCommentBoard(dto);
	}
	
	@Override
	public int delete(CommentBoardDTO dto) {
		return mapper.delete(dto);
	}
}
