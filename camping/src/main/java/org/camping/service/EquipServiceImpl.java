package org.camping.service;

import java.util.HashMap;
import java.util.List;

import org.camping.mapper.EquipMapper;
import org.camping.model.EquipDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipServiceImpl implements EquipService{

	@Autowired
	private EquipMapper mapper;

	@Override
	public int getEquipCount(HashMap<String,Object> map) {

		return mapper.getEquipCount(map);
	
	}
	
	@Override
	public List<EquipDTO> getEquipList(HashMap<String,Object> map) {

		return mapper.getEquipList(map);
	
	}

	
}



