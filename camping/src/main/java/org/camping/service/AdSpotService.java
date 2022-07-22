package org.camping.service;

import java.util.List;

import org.camping.model.SpotDTO;

public interface AdSpotService {
	// ���ķ���� ���
	public List<SpotDTO> getSpotList(int startRow, int endRow);
	// ķ���� �� ī��Ʈ
	public int getSpotCount(); 
	// ķ���� �Է�
	public void addSpot(SpotDTO dto);
}
