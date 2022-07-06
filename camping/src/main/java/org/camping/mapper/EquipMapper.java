package org.camping.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.model.EquipDTO;

public interface EquipMapper {
	
	public int getEquipCount(HashMap<String,Object> map);
	
	public List<EquipDTO> getEquipList(HashMap<String,Object> map);
	
}
