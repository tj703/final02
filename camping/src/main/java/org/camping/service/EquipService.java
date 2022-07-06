package org.camping.service;

import java.util.HashMap;
import java.util.List;
import org.camping.model.EquipDTO;

public interface EquipService {
	public int getEquipCount(HashMap<String,Object> map);
	public List<EquipDTO> getEquipList( HashMap<String,Object> map);
}
