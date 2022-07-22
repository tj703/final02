package org.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.model.SpotDTO;

public interface AdSpotMapper {
	// ��� ķ���� ���� ���
	public List<SpotDTO> getSpotList(@Param("startRow") int startRow, @Param("endRow") int endRow);
	// ķ���� �� ī��Ʈ
	public int getSpotCount();
	// ķ���� �Է� �� ����� �����ض�
	public void addSpot(SpotDTO dto); 
}
