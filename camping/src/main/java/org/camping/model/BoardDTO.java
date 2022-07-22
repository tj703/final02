package org.camping.model;

import java.util.Date;
import lombok.Data;

@Data
public class BoardDTO {
	
	private int boardnum;		// �۹�ȣ
	private int category;		// ī�װ�
	private String title;		// ����
	private String content;		// �۳���
	private String writer;		// �ۼ���
	private String image;		// ÷���̹���
	private String password;	//��й�ȣ
	private int readcount;		// ��ȸ��
	private Date reg;			// �ۼ��Ͻ�
	private int status;			// �� ����
	
}
