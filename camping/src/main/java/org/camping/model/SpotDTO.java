package org.camping.model;

import java.sql.Date;

import lombok.Data;

@Data
public class SpotDTO {
	private int num;		// ķ���� ������ȣ
	private int status;		// ķ���� ��ϻ���
	private String name;	// ķ�����
	private int score;		// ķ���� ����
	private int read;		// ķ���� ��ȸ��
	private String phone;	// ķ���� ����ó
	
	private String addr;	// ķ���� �ּ�
	private double lng;		// �浵
	private double lat;		// ����
	private String image;	// ķ���� ����
	private String page;	// ķ���� Ȩ������
	private String cate;	// ķ���� ī�װ�
	private String tag;		// ķ���� �±�
	private Date reg;		// ķ���� �����
	private String[] addrs;
	private String[] cates;
	public void setAddrs(String[] addrs) {
		this.addr = String.join(" ", addrs);
	}
	public void setCates(String[] cates) {
		this.cate = String.join(",", cates);
	}	
}
