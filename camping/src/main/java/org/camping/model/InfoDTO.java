package org.camping.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class InfoDTO {
	private String id;						// ȸ�� ID
	private String nickname;				// ����
	private String pw;						// ��й�ȣ
	private String mail1;					// email ID
	private String mail2;					// email �ּ� ( @����)
	private String adrs;					// ������
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date birth;						// �������
	private String question;				// ��й�ȣ ã�� ���� ���
	private String ans;						// ��й�ȣ ã�� ���� ��
	private String car;						// ���� ���� ����

}
