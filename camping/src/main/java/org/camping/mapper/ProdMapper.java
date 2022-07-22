package org.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.camping.model.ChecklistDTO;
import org.camping.model.EquipDTO;
import org.camping.model.SpotDTO;

public interface ProdMapper {
	// �̸� �˻�
	public List<SpotDTO> getSearchKey(@Param("spot")String spot, @Param("startRow") int startRow, @Param("endRow") int endRow );
	// �̸� �˻� ī��Ʈ
	public int getCountKey(@Param("spot")String spot);
	// ķ���� �����Ǹ� Ȯ��
	public int checkFuel(String spot);
	// ���� ��õ
	public EquipDTO recommendFuel1();
	public EquipDTO recommendFuel2();
	// ��Ʈ ��õ
	public List<EquipDTO> recomTent1(@Param("price") int price);
	public List<EquipDTO> recomTent2(@Param("price") int price);
	public List<EquipDTO> recomTent3(@Param("price") int price);
	// Ÿ�� ��õ
	public List<EquipDTO> recomTaf(@Param("price") int price);
	// ��Ʈ ��õ
	public List<EquipDTO> recomMat(@Param("price") int price);
	// ħ�� ��õ
	public List<EquipDTO> recomSB1(@Param("price") int price);
	public List<EquipDTO> recomSB2(@Param("price") int price);
	public List<EquipDTO> recomSB3(@Param("price") int price);
	// ���̺� ��õ
	public List<EquipDTO> recomTB(@Param("price") int price);
	// ���� ��õ
	public List<EquipDTO> recomChair(@Param("price") int price);
	// ������õ
	public List<EquipDTO> recomLight(@Param("price") int price);
	// ����� ��õ
	public List<EquipDTO> recomStove1(@Param("price") int price);
	public List<EquipDTO> recomStove2(@Param("price") int price);
	// ���̽��ڽ� ��õ
	public List<EquipDTO> recomWJ1(@Param("price") int price);
	public List<EquipDTO> recomWJ2(@Param("price") int price);
	public List<EquipDTO> recomWJ3(@Param("price") int price);
	// üũ����Ʈ Ȯ��
	public int checkStatus(ChecklistDTO dto);
	// üũ����Ʈ ���� Ȯ��
	public int checkId(String id);
	// üũ����Ʈ ���
	public int saveChecklist(ChecklistDTO dto);
}
