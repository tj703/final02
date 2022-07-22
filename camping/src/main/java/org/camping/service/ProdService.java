package org.camping.service;

import java.util.List;

import org.camping.model.ChecklistDTO;
import org.camping.model.EquipDTO;
import org.camping.model.SpotDTO;

public interface ProdService {
	// �̸� �˻�
	public List<SpotDTO> getSearchKey(String spot, int startRow, int endRow);
	// �̸� �˻� ī��Ʈ
	public int getCountKey(String spot);
	// �����Ǹ� Ȯ��
	public int checkFuel(String spot);
	// ���� ��õ
	public EquipDTO recommendFuel1();
	public EquipDTO recommendFuel2();	
	// ��Ʈ ��õ
	public List<EquipDTO> recomTent1(int price);
	public List<EquipDTO> recomTent2(int price);
	public List<EquipDTO> recomTent3(int price);
	// Ÿ�� ��õ
	public List<EquipDTO> recomTaf(int price);
	// ��Ʈ ��õ
	public List<EquipDTO> recomMat(int price);
	// ħ�� ��õ
	public List<EquipDTO> recomSB1(int price);
	public List<EquipDTO> recomSB2(int price);
	public List<EquipDTO> recomSB3(int price);
	// ���̺� ��õ
	public List<EquipDTO> recomTB(int price);
	// ���� ��õ
	public List<EquipDTO> recomChair(int price);
	// ������õ
	public List<EquipDTO> recomLight(int price);
	// ����� ��õ
	public List<EquipDTO> recomStove1(int price);
	public List<EquipDTO> recomStove2(int price);
	// ���̽��ڽ� ��õ
	public List<EquipDTO> recomWJ1(int price);
	public List<EquipDTO> recomWJ2(int price);
	public List<EquipDTO> recomWJ3(int price);
	// üũ����Ʈ ���� Ȯ��
	public int checkId(String id);
	//üũ����Ʈ Ȯ��
	public int checkStatus(ChecklistDTO dto);
	// üũ����Ʈ ���
	public int saveChecklist(ChecklistDTO dto);
}
