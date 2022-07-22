package org.camping.mapper;

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

public interface MemberMapper {
	
	//ȸ������
	public void signUp(MemberDTO dto);
	//���̵� �ߺ�üũ
	public int idConfirm(String id);
	//���� �ߺ�üũ
	public int nickConfirm(String nickname);

	//ȸ������Ȯ��
	public int userCheck(MemberDTO dto);
	//�α��� �ð� ����
	public int loginTime(MemberDTO dto);

	//�������� üũ 
	public int surveyCheck(MemberDTO dto);
	//��������
	public void survey(MemberDTO dto);

	//ȸ��Ż��
	public int delete(MemberDTO dto);
	//Ż�𿩺� Ȯ��
	public int deleteUser(MemberDTO dto);

	//ȸ������
	public List<InfoDTO> info(@Param("id")String id);
	//ȸ������ ����
	public void userInfo(MemberDTO dto);
	
	//�� �ۼ��� Ȯ��
	public int myBoard(@Param("id")String id);
	//�� �ۼ��� ����
	public List<BoardDTO> getList(@Param("id")String id, @Param("startRow")int startRow, @Param("endRow")int endRow);

	// ���ã�� ��ä ����
	public int favoCount(String id);
	//ķ����
	public int favoCampCh(String id);
	//���
	public int favoEquipCh(String id);
	
	// ������ ó��, ���, ķ����
	public List<EquipDTO> favoEquip(@Param("id")String id, @Param("startRow")int startRow, @Param("endRow")int endRow);
	public List<SpotDTO> favoCamp(@Param("id")String id, @Param("startRow")int startRow, @Param("endRow")int endRow);
	//���ã�� ����
	public void deleteFavo(@Param("id")String id, @Param("num")int num, @Param("status")int status);
	public int deleteFavoCh(@Param("id")String id, @Param("num")int num, @Param("status")int status);
	

	//üũ����Ʈ Ȯ�� 
	public ChecklistDTO chlist(@Param("id")String id, @Param("status")int status);
	public int chlist2(@Param("id")String id, @Param("status")int status);
	
	public ChecklistDTO clSite(@Param("id")String id, @Param("status")int status);
	public EquipDTO clTent(@Param("id")String id, @Param("status")int status);
	public EquipDTO clTaf(@Param("id")String id, @Param("status")int status);
	public EquipDTO clWaterjug(@Param("id")String id, @Param("status")int status);
	public EquipDTO clStove(@Param("id")String id, @Param("status")int status);
	public EquipDTO clLight(@Param("id")String id, @Param("status")int status);
	public EquipDTO clMat(@Param("id")String id, @Param("status")int status);
	public EquipDTO clSb(@Param("id")String id, @Param("status")int status);
	public EquipDTO clChair(@Param("id")String id, @Param("status")int status);
	public EquipDTO clDesk(@Param("id")String id, @Param("status")int status);
	public EquipDTO clGas(@Param("id")String id, @Param("status")int status);
	
	public int deleteCheck(ChecklistDTO dto);
	
	//üũ����Ʈ ���,����
	public void chModify(ChecklistDTO dto);


	//������ Ȯ��
	public int adCheck(MemberDTO dto);

}
