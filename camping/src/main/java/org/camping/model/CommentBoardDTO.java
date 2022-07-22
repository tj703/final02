package org.camping.model;

import java.util.Date;
import lombok.Data;

@Data
public class CommentBoardDTO {
	
	public int comnum;			// ��� ��ȣ
	public int boardnum;		// �۹�ȣ
	public String content;		// ��۳���
	public String writer;		// ��۾���
	public String password;		// ��� ���
	public Date reg;			// ����Ͻ�
	public int com_ref;			// ����ۼ��� (����)��۹�ȣ
	public int com_step;		// ��� ����
}
