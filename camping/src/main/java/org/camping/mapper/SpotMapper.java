package org.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.model.SpotCategoryDTO;
import org.camping.model.SpotDTO;

public interface SpotMapper {
	// ķ���� ���� ���
	public List<SpotDTO> getAllSpot();
	// ��ȸ�� ķ���� ��õ ���
	public List<SpotDTO> getPopularList();
	
	//ȸ�� �������� ���� ���
	public String checkAns1(String id);
	public String checkAns2(String id);
	public String checkAns6(String id);
	
	// üũ�ڽ� �˻�
	public List<SpotDTO> getSearchCheck(@Param("searchCheck")String[] searchCheck, @Param("startRow") int startRow, @Param("endRow") int endRow );
	// üũ�ڽ� �˻� ī��Ʈ
	public int getCountCheck(@Param("searchCheck")String[] searchCheck);
	// �̸� �˻�
	public List<SpotDTO> getSearchKey(@Param("searchKey")String searchKey, @Param("startRow") int startRow, @Param("endRow") int endRow );
	// �̸� �˻� ī��Ʈ
	public int getCountKey(@Param("searchKey")String searchKey);
	
	// �غ� ����Ʈ
	public List<SpotDTO> getBeachList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// �غ� ī��Ʈ
	public int getBeachCount();
	// ���� ����Ʈ
	public List<SpotDTO> getCityList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// ���� ī��Ʈ
	public int getCityCount();
	// �� ����Ʈ
	public List<SpotDTO> getForestList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// �� ī��Ʈ
	public int getForestCount();
	// �� ����Ʈ
	public List<SpotDTO> getIslandList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// �� ī��Ʈ
	public int getIslandCount();
	// �� ��� ����Ʈ
	public List<SpotDTO> getMountainList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// �� ��� ī��Ʈ
	public int getMountainCount();
	// �� ����Ʈ
	public List<SpotDTO> getRiverList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// �� ī��Ʈ
	public int getRiverCount();
	
	// ķ���� ���� ���
	public SpotDTO getContent(int num);
	// ķ���� ���� ���� (��ǥ�� � �ִ���)
	public int getCountFil(int num);
	// ķ���� ���� �κ� ������ (��ǥ �ڸ���) filnum�� ��ǥ����
	public String getFil(@Param("filNum")int filNum, @Param("num") int num);
	// ķ���� ���Ϳ� �´� ���� ��� fil�� �������� ���͵�
	public List<SpotCategoryDTO> getContentFil(@Param("fil") List fil);
	
	// ��ȸ�� ����
	public void updateRead(int num);
	
	// ķ�� ���ã�� Ȯ��
	public int checkFav(@Param("id")String id, @Param("num") int num);
	// ķ�� ���ã�� ���
	public void inFav(@Param("id")String id, @Param("num") int num);
	// ķ�� ���ã�� ����
	public void delFav(@Param("id")String id, @Param("num") int num);
}
