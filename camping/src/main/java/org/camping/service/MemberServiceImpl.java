package org.camping.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.mapper.MemberMapper;
import org.camping.model.BoardDTO;
import org.camping.model.ChecklistDTO;
import org.camping.model.EqcategoryDTO;
import org.camping.model.EquipDTO;
import org.camping.model.FavoriteDTO;
import org.camping.model.InfoDTO;
import org.camping.model.MemberDTO;
import org.camping.model.SpotCategoryDTO;
import org.camping.model.SpotDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	// ȸ������
	@Override
	public void signUp(MemberDTO dto) {
		mapper.signUp(dto);
	}
	@Override
	public int idConfirm(String id) {
		return mapper.idConfirm(id);
	}
	@Override
	public int nickConfirm(String nickname) {
		return mapper.nickConfirm(nickname);
	}
	
	
	//�α���
	@Override
	public int userCheck(MemberDTO dto) {
		return mapper.userCheck(dto);
	}
	@Override
	public int loginTime(MemberDTO dto) {
		return mapper.loginTime(dto);
	}
	
	
	//��������
	@Override
	public int surveyCheck(MemberDTO dto) {
		return mapper.surveyCheck(dto);
	}
	@Override
	public void survey(MemberDTO dto) {
		mapper.survey(dto);
	}

	//ȸ��Ż��
	@Override
	public int delete(MemberDTO dto) {
		return mapper.delete(dto);
	}
	@Override
	public int deleteUser(MemberDTO dto) {
		return mapper.deleteUser(dto);
	}
	
	
	//ȸ������
	@Override
	public List<InfoDTO> info(String id) {
		return mapper.info(id);
	}
	@Override
	public void userInfo(MemberDTO dto) {
		mapper.userInfo(dto);
	}
	
	// �� �ۼ���
	@Override
	public int myBoard(String id) {
		return mapper.myBoard(id);
	}
	@Override
	public List<BoardDTO> getList(String id, int startRow, int endRow){
		return mapper.getList(id, startRow, endRow);
	}
	
	
	//üũ����Ʈ
	@Override
	public ChecklistDTO chlist(String id, int status) {
		return mapper.chlist(id, status);
	}
	@Override
	public int chlist2(String id, int status) {
		return mapper.chlist2(id, status);
	}
	//����
	@Override
	public void chModify(ChecklistDTO dto) {
		mapper.chModify(dto);
	}

	
	@Override
	public ChecklistDTO clSite(String id, int status) {
		return mapper.clSite(id, status);
	}
	@Override
	public EquipDTO clTent(String id, int status) {
		return mapper.clTent(id, status);
	}
	@Override
	public EquipDTO clTaf(String id, int status) {
		return mapper.clTaf(id, status);
	}
	@Override
	public EquipDTO clWaterjug(String id, int status) {
		return mapper.clWaterjug(id, status);
	}
	@Override
	public EquipDTO clStove(String id, int status) {
		return mapper.clStove(id, status);
	}
	@Override
	public EquipDTO clLight(String id, int status) {
		return mapper.clLight(id, status);
	}
	@Override
	public EquipDTO clMat(String id, int status) {
		return mapper.clMat(id, status);
	}
	@Override
	public EquipDTO clSb(String id, int status) {
		return mapper.clSb(id, status);
	}
	@Override
	public EquipDTO clChair(String id, int status) {
		return mapper.clChair(id, status);
	}
	@Override
	public EquipDTO clDesk(String id, int status) {
		return mapper.clDesk(id, status);
	}
	@Override
	public EquipDTO clGas(String id, int status) {
		return mapper.clGas(id, status);
	}
	
	@Override
	public int deleteCheck(ChecklistDTO dto) {
		return mapper.deleteCheck(dto);
	}
	
	//���ã��
	@Override
	public int favoCount(String id) {
		return mapper.favoCount(id);
	}
	//���ã�� ķ���� Ȯ��
	@Override
	public int favoCampCh(String id) {
		return mapper.favoCampCh(id);
	}
	//���ã�� ���Ȯ��
	@Override
	public int favoEquipCh(String id) {
		return mapper.favoEquipCh(id);
	}
	//������ ó��
	@Override
	public List<EquipDTO> favoEquip(String id, int startRow, int endRow){
		return mapper.favoEquip(id, startRow, endRow);
	}
	@Override
	public List<SpotDTO> favoCamp(String id, int startRow, int endRow){
		return mapper.favoCamp(id, startRow, endRow);
	}
	//����
	public void deleteFavo(String id, int num, int status) {
		 mapper.deleteFavo(id, num, status);
	}
	public int deleteFavoCh(String id, int num, int status) {
		return mapper.deleteFavoCh(id, num, status);
	}
	
	//������ �α���
	@Override
	public int adCheck(MemberDTO dto) {
		return mapper.adCheck(dto);
	}
}
