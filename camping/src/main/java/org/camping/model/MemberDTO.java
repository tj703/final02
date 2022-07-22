package org.camping.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;							// ȸ�� ID
	private String pw;							// ȸ�� pw
	private String nickname;					// ȸ�� ����
	private int gender;						// ȸ�� ����
	private String mail1;						// email ID 
	private String mail2;						// email @�� �κ�
	private String adrs;						// �� �ּ� (adrs1~4 �� �ּҸ� �����ؼ� ����)
	private String adrs1;						// adrs 1~4 ���� api �ּҺκ� �����
	private String adrs2;						
	private String adrs3;
	private String adrs4;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;							// ȸ�� ����
	private Date reg;							// ���� ��¥
	private int status;							// ȸ������ 0 - Ż�� / 1 - ȸ�� / 2 ������
	private String question;					// ��й�ȣ ã�� ����
	private String ans;							// ��й�ȣ ã�� ���� ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date loginTime;						// �α����� �ð� (�����Ҷ� ���� ���� sysdate ����)
	private int car;							// ���� ���� ����
	private String ans1;						// �������� ���� 1
	private String ans2;						// �������� ���� 2
	private String ans3;						// �������� ���� 3
	private String ans4;						// �������� ���� 4
	private String ans5;						// �������� ���� 5
	private String ans6;						// �������� ���� 6
	private String platform;					// ���� �÷��� (���̹�, ���� , ���� API�� ����� ���Խ� ����)


	public String getAdrs() {
		return adrs1 + " " +adrs2 + " "+ adrs3 + " " +adrs4 ;
	}
	
}
	
