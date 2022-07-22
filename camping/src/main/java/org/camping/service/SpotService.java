package org.camping.service;

import java.util.List;

import org.camping.model.SpotCategoryDTO;
import org.camping.model.SpotDTO;

public interface SpotService {
	// ķ���� ���� ���
	public List<SpotDTO> getAllSpot();
	// ��ȸ�� ķ���� ��õ ���
	public List<SpotDTO> getPopularList();	
	
	//ȸ�� �������� ���� ���
	public String checkAns(String id);
		
	//üũ�ڽ� �˻�
	public List<SpotDTO> getSearchCheck(String[] searchCheck, int StartRow, int endRow);
	//üũ�ڽ� ����Ʈ�� ���� ī��Ʈ
	public int getCountCheck(String[] searchCheck);
	// �̸� �˻�
	public List<SpotDTO> getSearchKey(String searchKey, int StartRow, int endRow);
	// �̸� �˻� ī��Ʈ
	public int getCountKey(String searchKey);
	
	// �غ� ����Ʈ
	public List<SpotDTO> getBeachList(int startRow, int endRow);
	// �غ� ī��Ʈ
	public int getBeachCount();
	// ���� ����Ʈ
	public List<SpotDTO> getCityList(int startRow, int endRow);
	// ���� ī��Ʈ
	public int getCityCount();
	// �� ����Ʈ
	public List<SpotDTO> getForestList(int startRow, int endRow);
	// �� ī��Ʈ
	public int getForestCount();
	// �� ����Ʈ
	public List<SpotDTO> getIslandList(int startRow, int endRow);
	// �� ī��Ʈ
	public int getIslandCount();
	// �� ��� ����Ʈ
	public List<SpotDTO> getMountainList(int startRow, int endRow);
	// �� ��� ī��Ʈ
	public int getMountainCount();
	// �� ����Ʈ
	public List<SpotDTO> getRiverList(int startRow, int endRow);
	// �� ī��Ʈ
	public int getRiverCount();
	
	// ķ���� ���� ���
	public SpotDTO getContent(int num);
	// ķ���� ���� ���� (��ǥ�� � �ִ���)
	public int getCountFil(int num);
	// ķ���� ���� �κ� ������ (��ǥ �ڸ���)
	public String getFil(int filNum, int num); 
	// ķ���� ���Ϳ� �´� ���� ���
	public List<SpotCategoryDTO> getContentFil(List fil);
	//��ȸ�� ����
	public void updateRead(int num);
	
	// ķ�� ���ã�� Ȯ��
	public int checkFav(String id, int num);
	// ķ�� ���ã�� ���
	public void inFav(String id, int num);
	// ķ�� ���ã�� ����
	public void delFav(String id, int num);
}
