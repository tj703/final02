package org.camping.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.model.BoardDTO;
import org.camping.model.ChecklistDTO;
import org.camping.model.EqcategoryDTO;
import org.camping.model.EquipDTO;
import org.camping.model.FavoriteDTO;
import org.camping.model.InfoDTO;
import org.camping.model.MemberDTO;
import org.camping.model.SpotCategoryDTO;
import org.camping.model.SpotDTO;

public interface MemberService {

	//ȸ������
	public void signUp(MemberDTO dto);
	public int idConfirm(String id);
	public int nickConfirm(String nickname);

	// �������� üũ
	public int surveyCheck(MemberDTO dto);
	public void survey(MemberDTO dto);
	//�α��� 
	public int userCheck(MemberDTO dto);
	public int loginTime(MemberDTO dto);
	//����
	public int deleteUser(MemberDTO dto);
	public int delete(MemberDTO dto);
	//ȸ������	
	public List<InfoDTO> info(String id);
	public void userInfo(MemberDTO dto);
	//�� �ۼ���
	public int myBoard(String id);
	public List<BoardDTO> getList(String id, int startRow, int endRow);

	//üũ����Ʈ ����
	public void chModify(ChecklistDTO dto);
	
	public ChecklistDTO chlist(String id, int status);
	public int chlist2(String id, int status);
	
	public ChecklistDTO clSite(String id, int status);
	public EquipDTO clTent(String id, int status);
	public EquipDTO clTaf(String id, int status);
	public EquipDTO clWaterjug(String id, int status);
	public EquipDTO clStove(String id, int status);
	public EquipDTO clLight(String id, int status);
	public EquipDTO clMat(String id, int status);
	public EquipDTO clSb(String id, int status);
	public EquipDTO clChair(String id, int status);
	public EquipDTO clDesk(String id, int status);
	public EquipDTO clGas(String id, int status);
	


	
	
	//üũ����Ʈ ����
	public int deleteCheck(ChecklistDTO dto);
	//��ü
	public int favoCount(String id);
	//ķ����
	public int favoCampCh(String id);
	//���
	public int favoEquipCh(String id);
	//������ ó��
	public List<EquipDTO> favoEquip(String id, int startRow, int endRow);
	public List<SpotDTO> favoCamp(String id, int startRow, int endRow);
	//���ã�� ����
	public void deleteFavo(String id, int num, int status);
	public int deleteFavoCh(String id, int num, int status);
	



	public int adCheck(MemberDTO dto);
}
