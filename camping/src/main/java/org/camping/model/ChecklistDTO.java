package org.camping.model;

import java.util.Date;

import lombok.Data;

@Data
public class ChecklistDTO {
	private String id;		// ������ ȸ�� ID
	private int price;		// ���󰡰�
	private int person;		// �ο��� 1=1~2�� / 2=3~4�� / 3=5~6��
	private int season;		// ���� 1=������/2=����/3=�ܿ�
	private int site;		// ķ���� ��ȣ
	private int tent;		// ��Ʈ ��ȣ
	private int taf;		// Ÿ�� ��ȣ
	private int waterjug;	// ���� ��ȣ
	private int stove;		// �����ⱸ ��ȣ
	private int light;		// ���� ��ȣ
	private int mat;		// ��Ʈ ��ȣ
	private int sb;			// ħ�� ��ȣ
	private int chair;		// ���� ��ȣ
	private int desk;		// å�� ��ȣ
	private int gas;		// ���� ��ȣ
	private int status;		// üũ����Ʈ ����
	private Date reg;		// �ۼ���
}
