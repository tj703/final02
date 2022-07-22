package org.camping.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.camping.model.EquipDTO;
import org.camping.service.EquipService;
import org.camping.service.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equip/*")
public class EquipController {

	@Autowired
	private EquipService service;
	@Autowired
	private StaticService staticService;

	@RequestMapping("list")
	public String list(HttpServletRequest request, String cat, String pageNum, HttpSession session,Model model) throws UnsupportedEncodingException, ParseException {
		
		String memId = (String)session.getAttribute("memId");
		
		
		//��赥���� ���� �� ���� 
		HashMap<String, Object> statics = new HashMap<String, Object>();
		
		//�α��ε� ���̵�,��α��ν� guest
		if(session.getAttribute("memId") != null) {
			statics.put("id",(String)session.getAttribute("memId"));
			
			if(staticService.getStarttime(statics) == 1){
				staticService.setEndtime(statics);
			}
			
		}else {
			statics.put("id","guest");	
		}
		

		statics.put("endtime","");
		
		//���� ���ӵ� ������
		String page = request.getRequestURI() + "?" + request.getQueryString();
		String decodedPage  = URLDecoder.decode(page, "UTF-8");        
        System.out.println(decodedPage ); 
		statics.put("page",decodedPage);
		
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
        System.out.println(decodedInflow );
		statics.put("inflow",decodedInflow);
		}else {
			statics.put("inflow","");	
		}
		
		
		
		//���ӵ���̽�
		String device = null;
		String agent = request.getHeader("USER-AGENT");
		if(agent.contains("iPhone")){
		device = "iPhone";
		}
		else if(agent.contains("Android")) {
			device = "Android";
		}else {
			device = "Windows";
		}
		statics.put("device",device);
		
		//�˻���
		if(request.getParameter("title") != null) {
		statics.put("keyword",request.getParameter("title"));
		}else if (request.getParameter("title") == null) {
			statics.put("keyword","");
		}
		
		//����üũ�� 
		
		String fil = "Eq";
		String par = request.getQueryString();
		if(par != null) {
		String decodedPar  = URLDecoder.decode(par, "UTF-8");
		System.out.println(decodedPar);
		//����üũ �ڵ�ȭ
		if(decodedPar.contains("cat=1")) {
			if(decodedPar.contains("bran=���̵���")){
				fil += ",AA1";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",AA2";
			}if(decodedPar.contains("bran=����ó����ũ")){
				fil += ",AA3";
			}if(decodedPar.contains("bran=������")){
				fil += ",AA4";
			}if(decodedPar.contains("fil1=ĳ����Ʈ")){
				fil += ",AB1";
			}if(decodedPar.contains("fil1=����Ʈ")){
				fil += ",AB2";
			}if(decodedPar.contains("fil1=�״ø���Ʈ")){
				fil += ",AB3";
			}if(decodedPar.contains("fil1=�ͳ�����Ʈ")){
				fil += ",AB4";
			}if(decodedPar.contains("fil7=1")){
				fil += ",AC1";
			}if(decodedPar.contains("fil7=3")){
				fil += ",AC2";
			}if(decodedPar.contains("fil7=6")){
				fil += ",AC3";
			}if(decodedPar.contains("fil8=1000")){
				fil += ",AD1";
			}if(decodedPar.contains("fil8=1001")){
				fil += ",AD2";
			}if(decodedPar.contains("fil8=2001")){
				fil += ",AD3";
			}if(decodedPar.contains("fil8=3001")){
				fil += ",AD4";
			}
		}
		if(decodedPar.contains("cat=2")) {
			if(decodedPar.contains("bran=������")){
				fil += ",BA1";
			}if(decodedPar.contains("bran=���̵���")){
				fil += ",BA2";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",BA3";
			}if(decodedPar.contains("bran=�ݸ�")){
				fil += ",BA4";
			}if(decodedPar.contains("fil1=��Ų")){
				fil += ",BB1";
			}if(decodedPar.contains("fil1=��Ų+��")){
				fil += ",BB2";
			}if(decodedPar.contains("fil1=�Ķ��")){
				fil += ",BB3";
			}if(decodedPar.contains("fil1=��ũ��")){
				fil += ",BB4";
			}if(decodedPar.contains("fil1=���̵��")){
				fil += ",BB5";
			}if(decodedPar.contains("fil8=1000")){
				fil += ",BC1";
			}if(decodedPar.contains("fil8=1001")){
				fil += ",BC2";
			}if(decodedPar.contains("fil8=2001")){
				fil += ",BC3";
			}if(decodedPar.contains("fil8=3001")){
				fil += ",BC4";
			}if(decodedPar.contains("fil2=���������׸�")){
				fil += ",BD1";
			}if(decodedPar.contains("fil2=���Ϸ�")){
				fil += ",BD2";
			}if(decodedPar.contains("fil2=������")){
				fil += ",BD3";
			}if(decodedPar.contains("fil2=��")){	
				fil += ",BD4";
			}
		}
		if(decodedPar.contains("cat=3")) {
			if(decodedPar.contains("bran=���ؽ�")){
				fil += ",CA1";
			}if(decodedPar.contains("bran=����ó����ũ")){
				fil += ",CA2";
			}if(decodedPar.contains("bran=�������Ʈ")){
				fil += ",CA3";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",CA4";
			}if(decodedPar.contains("bran=��ũ��")){
				fil += ",CA5";	
			}if(decodedPar.contains("fil1=�����Ʈ")){
				fil += ",CB1";
			}if(decodedPar.contains("fil1=�����̸�Ʈ")){
				fil += ",CB2";
			}if(decodedPar.contains("fil1=��ũ�и�Ʈ")){
				fil += ",CB3";
			}if(decodedPar.contains("fil1=�������")){
				fil += ",CB4";
			}if(decodedPar.contains("fil1=��������")){
				fil += ",CB5";
			}if(decodedPar.contains("fil1=���ڸ�")){
				fil += ",CB6";
			}if(decodedPar.contains("fil7=1")){
				fil += ",CC1";
			}if(decodedPar.contains("fil7=3")){
				fil += ",CC2";
			}if(decodedPar.contains("fil7=6")){
				fil += ",CC3";
			}if(decodedPar.contains("fil2=�ƿ������")){
				fil += ",CD1";
			}if(decodedPar.contains("fil2=��Ʈ���ο�")){
				fil += ",CD2";
			}if(decodedPar.contains("fil2=����+�ƿ������")){
				fil += ",CD3";
			}if(decodedPar.contains("fil3=���̽�")){
				fil += ",CE1";
			}if(decodedPar.contains("fil3=���̽�")){
				fil += ",CE2";
			}
		}
		if(decodedPar.contains("cat=4")) {
			if(decodedPar.contains("bran=�ݰ�")){
				fil += ",DA1";
			}if(decodedPar.contains("bran=�������Ʈ")){
				fil += ",DA2";
			}if(decodedPar.contains("bran=����ó����ũ")){
				fil += ",DA3";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",DA4";
			}if(decodedPar.contains("bran=�޻�")){
				fil += ",DA5";	
			}if(decodedPar.contains("fil1=ħ��")){
				fil += ",DB1";
			}if(decodedPar.contains("fil1=�谳")){
				fil += ",DB2";
			}if(decodedPar.contains("fil1=���̳�")){
				fil += ",DB3";
			}if(decodedPar.contains("fil1=���")){
				fil += ",DB4";
			}if(decodedPar.contains("fil2=�簢")){
				fil += ",DC1";
			}if(decodedPar.contains("fil2=�ӹ�(���̶���)")){
				fil += ",DC2";
			}if(decodedPar.contains("fil2=�簢(�ĵ���)")){
				fil += ",DC3";
			}if(decodedPar.contains("fil2=�Դ���")){
				fil += ",DC4";
			}if(decodedPar.contains("fil3=������")){
				fil += ",DD1";
			}if(decodedPar.contains("fil3=�������")){
				fil += ",DD2";
			}if(decodedPar.contains("fil3=��,������")){
				fil += ",DD3";
			}if(decodedPar.contains("fil3=�ܿ��")){
				fil += ",DD4";
			}if(decodedPar.contains("fil4=���������׸�")){
				fil += ",DE1";
			}if(decodedPar.contains("fil4=Ȧ�����̹�")){
				fil += ",DE2";
			}if(decodedPar.contains("fil4=������")){
				fil += ",DE3";
			}if(decodedPar.contains("fil4=������")){
				fil += ",DE4";
			}if(decodedPar.contains("fil4=����ũ��ȭ�̹�")){
				fil += ",DE5";
			}if(decodedPar.contains("fil11=-50")){
				fil += ",DF1";
			}if(decodedPar.contains("fil11=-30")){
				fil += ",DF2";
			}if(decodedPar.contains("fil11=-10")){
				fil += ",DF3";
			}if(decodedPar.contains("fil11=0")){
				fil += ",DF4";
			}
		}
		if(decodedPar.contains("cat=5")) {
			if(decodedPar.contains("bran=ī���")){
				fil += ",EA1";
			}if(decodedPar.contains("bran=�ݸ�")){
				fil += ",EA2";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",EA3";
			}if(decodedPar.contains("bran=����ó����ũ")){
				fil += ",EA4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",EB1";
			}if(decodedPar.contains("fil1=ħ��")){
				fil += ",EB2";
			}if(decodedPar.contains("fil1=���̺�")){
				fil += ",EB3";
			}if(decodedPar.contains("fil1=����")){
				fil += ",EB4";
			}if(decodedPar.contains("fil2=�˷�̴�")){
				fil += ",EC1";
			}if(decodedPar.contains("fil2=��ƿ")){
				fil += ",EC2";
			}if(decodedPar.contains("fil2=�ζ����")){
				fil += ",EC3";
			}if(decodedPar.contains("fil2=����")){
				fil += ",EC4";
			}if(decodedPar.contains("fil12=100")){
				fil += ",ED1";
			}if(decodedPar.contains("fil12=120")){
				fil += ",ED2";
			}if(decodedPar.contains("fil12=121")){
				fil += ",ED3";
			}
		}
		if(decodedPar.contains("cat=6")) {
			if(decodedPar.contains("bran=�ݸ�")){
				fil += ",FA1";
			}if(decodedPar.contains("bran=���ĸ�")){
				fil += ",FA2";
			}if(decodedPar.contains("bran=�ڽ���")){
				fil += ",FA3";
			}if(decodedPar.contains("bran=���̿�")){
				fil += ",FA4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",FB1";
			}if(decodedPar.contains("fil1=���̽��ڽ�")){
				fil += ",FB2";
			}if(decodedPar.contains("fil1=����")){
				fil += ",FB3";
			}if(decodedPar.contains("fil1=�𷯹�")){
				fil += ",FB4";
			}if(decodedPar.contains("fil9=10")){
				fil += ",FC1";
			}if(decodedPar.contains("fil9=40")){
				fil += ",FC2";
			}if(decodedPar.contains("fil9=41")){
				fil += ",FC3";
			}if(decodedPar.contains("fil2=�����θ���")){
				fil += ",FD1";
			}if(decodedPar.contains("fil2=��ƿ")){
				fil += ",FD2";
			}if(decodedPar.contains("fil2=�˷�̴�")){
				fil += ",FD3";
			}if(decodedPar.contains("fil2=�ö�ƽ")){
				fil += ",FD4";
			}
		}
		if(decodedPar.contains("cat=7")) {
			if(decodedPar.contains("bran=�������ũ")){
				fil += ",GA1";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",GA2";
			}if(decodedPar.contains("bran=ķ�ι�")){
				fil += ",GA3";
			}if(decodedPar.contains("bran=�븶��")){
				fil += ",GA4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",GB1";
			}if(decodedPar.contains("fil1=��")){
				fil += ",GB2";
			}if(decodedPar.contains("fil1=��")){
				fil += ",GB3";
			}if(decodedPar.contains("fil1=����ǰ")){
				fil += ",GB4";
			}if(decodedPar.contains("fil1=�ı�")){
				fil += ",GB5";
			}if(decodedPar.contains("fil7=1")){
				fil += ",GC1";
			}if(decodedPar.contains("fil7=3")){
				fil += ",GC2";
			}if(decodedPar.contains("fil7=6")){
				fil += ",GC3";
			}if(decodedPar.contains("fil2=�����θ���")){
				fil += ",GD1";
			}if(decodedPar.contains("fil2=��ƿ")){
				fil += ",GD2";
			}if(decodedPar.contains("fil2=�˷�̴�")){
				fil += ",GD3";
			}if(decodedPar.contains("fil2=�ö�ƽ")){
				fil += ",GD4";
			}if(decodedPar.contains("fil3=��")){
				fil += ",GE1";
			}if(decodedPar.contains("fil3=��")){
				fil += ",GE2";
			}
		}
		if(decodedPar.contains("cat=8")) {
			if(decodedPar.contains("bran=�ں���")){
				fil += ",HA1";
			}if(decodedPar.contains("bran=������")){
				fil += ",HA2";
			}if(decodedPar.contains("bran=�ٹ���")){
				fil += ",HA3";
			}if(decodedPar.contains("bran=�븶��")){
				fil += ",HA4";
			}if(decodedPar.contains("fil1=ȭ��")){
				fil += ",HB1";
			}if(decodedPar.contains("fil1=��ġ")){
				fil += ",HB2";
			}if(decodedPar.contains("fil1=����������")){
				fil += ",HB3";
			}if(decodedPar.contains("fil1=�����׸�")){
				fil += ",HB4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",HB5";
			}if(decodedPar.contains("fil2=1")){
				fil += ",HC1";
			}if(decodedPar.contains("fil2=2")){
				fil += ",HC2";
			}if(decodedPar.contains("fil3=����")){
				fil += ",HD1";
			}if(decodedPar.contains("fil3=����")){
				fil += ",HD2";
			}if(decodedPar.contains("fil3=��")){
				fil += ",HD3";
			}if(decodedPar.contains("fil4=��")){
				fil += ",HE1";
			}if(decodedPar.contains("fil4=��")){
				fil += ",HE2";
			}
		}
		if(decodedPar.contains("cat=9")) {
			if(decodedPar.contains("bran=�ٹ���")){
				fil += ",IA1";
			}if(decodedPar.contains("bran=�ں���")){
				fil += ",IA2";
			}if(decodedPar.contains("bran=������")){
				fil += ",IA3";
			}if(decodedPar.contains("bran=�Ƽ�")){
				fil += ",IA4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",IB1";
			}if(decodedPar.contains("fil1=�̼Ұ���")){
				fil += ",IB2";
			}if(decodedPar.contains("fil1=����")){
				fil += ",IB3";
			}if(decodedPar.contains("fil1=��")){
				fil += ",IB4";
			}if(decodedPar.contains("fil1=����")){
				fil += ",IB5";
			}
		}
		if(decodedPar.contains("cat=10")) {
			if(decodedPar.contains("bran=������")){
				fil += ",JA1";
			}if(decodedPar.contains("bran=��ź�����")){
				fil += ",JA2";
			}if(decodedPar.contains("bran=��ȭ���")){
				fil += ",JA3";
			}if(decodedPar.contains("bran=����Ʈ")){
				fil += ",JA4";
			}if(decodedPar.contains("fil1=������")){
				fil += ",JB1";
			}if(decodedPar.contains("fil1=��巣��")){
				fil += ",JB2";
			}if(decodedPar.contains("fil1=�ǳ���")){
				fil += ",JB3";
			}if(decodedPar.contains("fil1=�۾���")){
				fil += ",JB4";
			}if(decodedPar.contains("fil2=������")){
				fil += ",JC1";
			}if(decodedPar.contains("fil2=������")){
				fil += ",JC2";
			}if(decodedPar.contains("fil10=1000")){
				fil += ",JD1";
			}if(decodedPar.contains("fil10=2000")){
				fil += ",JD2";
			}if(decodedPar.contains("fil10=2001")){
				fil += ",JD3";
			}if(decodedPar.contains("fil3=����")){
				fil += ",JE1";
			}if(decodedPar.contains("fil3=����")){
				fil += ",JE2";
			}
		}
		System.out.println(fil);
		}
		statics.put("filter",fil);
		
		
		staticService.pageStatic(statics);
		
	
		
		

		
		//����Ʈ �����ּ� ó�� �� ����¡ó���� ���� ���� 
		if (pageNum == null)
			pageNum = "1";
		if (cat == null)
			cat = "0";
		int pageSize = 30;
		int category = Integer.parseInt(cat);
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		
		//ī�װ� �� �˻� ���� ���� 
		String tent = "WHERE CATEGORY = 1";
		String taf = "WHERE CATEGORY = 2";
		String mat = "WHERE CATEGORY = 3";
		String sb = "WHERE CATEGORY = 4";
		String chair = "WHERE CATEGORY = 5";
		String ib = "WHERE CATEGORY = 6";
		String cw = "WHERE CATEGORY = 7";
		String stove = "WHERE CATEGORY = 8";
		String gas = "WHERE CATEGORY = 9";
		String light = "WHERE CATEGORY = 10";

		HashMap<String, Object> map = new HashMap<String, Object>();
		if (category == 1) {
			map.put("category", tent);
		}
		if (category == 2) {
			map.put("category", taf);
		}
		if (category == 3) {
			map.put("category", mat);
		}
		if (category == 4) {
			map.put("category", sb);
		}
		if (category == 5) {
			map.put("category", chair);
		}
		if (category == 6) {
			map.put("category", ib);
		}
		if (category == 7) {
			map.put("category", cw);
		}
		if (category == 8) {
			map.put("category", stove);
		}
		if (category == 9) {
			map.put("category", gas);
		}
		if (category == 10) {
			map.put("category", light);
		}

		else if (category == 0) {
			map.put("category", "where category > 0");
		}
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		//JSP���� üũ�� ���ͺ� üũ�ڽ� ���� �޾ƿͼ� �迭�� ����
		String[] brands = request.getParameterValues("bran");
		String[] fil1s = request.getParameterValues("fil1");
		String[] fil2s = request.getParameterValues("fil2");
		String[] fil3s = request.getParameterValues("fil3");
		String[] fil4s = request.getParameterValues("fil4");
		String[] fil5s = request.getParameterValues("fil5");
		String[] fil6s = request.getParameterValues("fil6");
		String[] fil7s = request.getParameterValues("fil7");
		String[] fil8s = request.getParameterValues("fil8");
		String[] fil9s = request.getParameterValues("fil9");
		String[] fil10s = request.getParameterValues("fil10");
		String[] fil11s = request.getParameterValues("fil11");
		String[] fil12s = request.getParameterValues("fil12");
		String titles = request.getParameter("title");
		
		//���ͺ� ������ ������ ���������� ���� �� �ʱ�ȭ
		String brand = "";
		String fil1 = "";
		String fil2 = "";
		String fil3 = "";
		String fil4 = "";
		String fil5 = "";
		String fil6 = "";
		String fil7 = "";
		String fil8 = "";
		String fil9 = "";
		String fil10 = "";
		String fil11 = "";
		String fil12 = "";
		String title = "";
		
		//üũ�� ���������� ������ٴ� �Ķ���� ��
		String brandp = "";
		String fil1p = "";
		String fil2p = "";
		String fil3p = "";
		String fil4p = "";
		String fil5p = "";
		String fil6p = "";
		String fil7p = "";
		String fil8p = "";
		String fil9p = "";
		String fil10p = "";
		String fil11p = "";
		String fil12p = "";
		String titlep = "";
		
		//��� �˻����� �� ����Ȯ�� �� ���� �������� ���� �� ��������
		// �귣�� ����
		if (brands == null || brands[0] == "") {
			brand = "BRAND LIKE '%%' OR brand IS null ";
			map.put("brand", brand);
			brandp = "&bran=";
		}
		if (brands != null && brands[0] != "") {
			if (brands.length == 1) {
				brand = "BRAND LIKE '%" + brands[0] + "%'";
				map.put("brand", brand);
				brandp = "&bran=" + brands[0];
			}
			if (brands.length == 2) {
				brand = "BRAND LIKE '%" + brands[0] + "%' OR BRAND LIKE '%" + brands[1] + "%'";
				map.put("brand", brand);
				brandp = "&bran=" + brands[0] + "&bran=" + brands[1];
			}
			if (brands.length == 3) {
				brand = "BRAND LIKE '%" + brands[0] + "%' OR BRAND LIKE '%" + brands[1] + "%' OR BRAND LIKE '%"
						+ brands[2] + "%'";
				map.put("brand", brand);
				brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2];
			}
			if (brands.length == 4) {
				brand = "BRAND LIKE '%" + brands[0] + "%' OR BRAND LIKE '%" + brands[1] + "%' OR BRAND LIKE '%"
						+ brands[2] + "%' OR BRAND LIKE '%" + brands[3] + "%'";
				map.put("brand", brand);
				brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2] + "&bran=" + brands[3];
			}
			if (brands.length == 5) {
				brand = "BRAND LIKE '%" + brands[0] + "%' OR BRAND LIKE '%" + brands[1] + "%' OR BRAND LIKE '%"
						+ brands[2] + "%' OR BRAND LIKE '%" + brands[3] + "%' OR BRAND LIKE '%" + brands[4] + "%'";
				map.put("brand", brand);
				brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2] + "&bran=" + brands[3]
						+ "&bran=" + brands[4];
			}
		}

		// 1�� ����

		if (fil1s == null || fil1s[0] == "") {
			fil1 = "fil1 LIKE '%%' OR fil1 IS null";
			map.put("fil1", fil1);
			fil1p = "&fil1=";
		}

		if (fil1s != null && fil1s[0] != "") {
			if (fil1s.length == 1) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%'";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0];
			}

			if (fil1s.length == 2) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%' OR fil1 LIKE '%" + fil1s[1] + "%'";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1];
			}

			if (fil1s.length == 3) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%' OR fil1 LIKE '%" + fil1s[1] + "%' OR fil1 LIKE '%" + fil1s[2]
						+ "%'";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2];
			}

			if (fil1s.length == 4) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%' OR fil1 LIKE '%" + fil1s[1] + "%' OR fil1 LIKE '%" + fil1s[2]
						+ "%' OR fil1 LIKE '%" + fil1s[3] + "%'";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3];
			}

			if (fil1s.length == 5) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%' OR fil1 LIKE '%" + fil1s[1] + "%' OR fil1 LIKE '%" + fil1s[2]
						+ "%' OR fil1 LIKE '%" + fil1s[3] + "%' OR fil1 LIKE '%" + fil1s[4] + "%' ";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3] + "&fil1="
						+ fil1s[4];
			}

			if (fil1s.length == 6) {
				fil1 = "fil1 LIKE '%" + fil1s[0] + "%' OR fil1 LIKE '%" + fil1s[1] + "%' OR fil1 LIKE '%" + fil1s[2]
						+ "%' OR fil1 LIKE '%" + fil1s[3] + "%' OR fil1 LIKE '%" + fil1s[4] + "%' OR fil1 LIKE '%"
						+ fil1s[5] + "%' ";
				map.put("fil1", fil1);
				fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3] + "&fil1="
						+ fil1s[4] + "&fil1=" + fil1s[5];
			}
		}

		// 2������

		if (fil2s == null || fil2s[0] == "") {
			fil2 = "fil2 LIKE '%%' OR fil2 IS NULL";
			map.put("fil2", fil2);
			fil2p = "&fil2=";
		}
		if (fil2s != null && fil2s[0] != "") {
			if (fil2s.length == 1) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%'";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0];
			}

			if (fil2s.length == 2) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%' OR fil2 LIKE '%" + fil2s[1] + "%'";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1];
			}

			if (fil2s.length == 3) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%' OR fil2 LIKE '%" + fil2s[1] + "%' OR fil2 LIKE '%" + fil2s[2]
						+ "%'";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2];
			}

			if (fil2s.length == 4) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%' OR fil2 LIKE '%" + fil2s[1] + "%' OR fil2 LIKE '%" + fil2s[2]
						+ "%' OR fil2 LIKE '%" + fil2s[3] + "%'";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3];
			}

			if (fil2s.length == 5) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%' OR fil2 LIKE '%" + fil2s[1] + "%' OR fil2 LIKE '%" + fil2s[2]
						+ "%' OR fil2 LIKE '%" + fil2s[3] + "%' OR fil2 LIKE '%" + fil2s[4] + "%' ";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3] + "&fil2="
						+ fil2s[4];
			}

			if (fil2s.length == 6) {
				fil2 = "fil2 LIKE '%" + fil2s[0] + "%' OR fil2 LIKE '%" + fil2s[1] + "%' OR fil2 LIKE '%" + fil2s[2]
						+ "%' OR fil2 LIKE '%" + fil2s[3] + "%' OR fil2 LIKE '%" + fil2s[4] + "%' OR fil2 LIKE '%"
						+ fil2s[5] + "%' ";
				map.put("fil2", fil2);
				fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3] + "&fil2="
						+ fil2s[4] + "&fil2=" + fil2s[5];
			}
		}

		// 3������

		if (fil3s == null || fil3s[0] == "") {
			fil3 = "fil3 LIKE '%%' OR fil3 IS null";
			map.put("fil3", fil3);
			fil3p = "&fil3=";
		}
		if (fil3s != null && fil3s[0] != "") {
			if (fil3s.length == 1) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%'";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0];
			}

			if (fil3s.length == 2) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%' OR fil3 LIKE '%" + fil3s[1] + "%'";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1];
			}

			if (fil3s.length == 3) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%' OR fil3 LIKE '%" + fil3s[1] + "%' OR fil3 LIKE '%" + fil3s[2]
						+ "%'";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2];
			}

			if (fil3s.length == 4) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%' OR fil3 LIKE '%" + fil3s[1] + "%' OR fil3 LIKE '%" + fil3s[2]
						+ "%' OR fil3 LIKE '%" + fil3s[3] + "%'";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3];
			}

			if (fil3s.length == 5) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%' OR fil3 LIKE '%" + fil3s[1] + "%' OR fil3 LIKE '%" + fil3s[2]
						+ "%' OR fil3 LIKE '%" + fil3s[3] + "%' OR fil3 LIKE '%" + fil3s[4] + "%' ";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3] + "&fil3="
						+ fil3s[4];
			}

			if (fil3s.length == 6) {
				fil3 = "fil3 LIKE '%" + fil3s[0] + "%' OR fil3 LIKE '%" + fil3s[1] + "%' OR fil3 LIKE '%" + fil3s[2]
						+ "%' OR fil3 LIKE '%" + fil3s[3] + "%' OR fil3 LIKE '%" + fil3s[4] + "%' OR fil3 LIKE '%"
						+ fil3s[5] + "%' ";
				map.put("fil3", fil3);
				fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3] + "&fil3="
						+ fil3s[4] + "&fil3=" + fil3s[5];
			}
		}

		// 4������

		if (fil4s == null || fil4s[0] == "") {
			fil4 = "fil4 LIKE '%%' OR fil4 IS null";
			map.put("fil4", fil4);
			fil4p = "&fil4=";
		}
		if (fil4s != null && fil4s[0] != "") {
			if (fil4s.length == 1) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%'";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0];
			}

			if (fil4s.length == 2) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%' OR fil4 LIKE '%" + fil4s[1] + "%'";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1];
			}

			if (fil4s.length == 3) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%' OR fil4 LIKE '%" + fil4s[1] + "%' OR fil4 LIKE '%" + fil4s[2]
						+ "%'";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2];
			}

			if (fil4s.length == 4) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%' OR fil4 LIKE '%" + fil4s[1] + "%' OR fil4 LIKE '%" + fil4s[2]
						+ "%' OR fil4 LIKE '%" + fil4s[3] + "%'";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3];
			}

			if (fil4s.length == 5) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%' OR fil4 LIKE '%" + fil4s[1] + "%' OR fil4 LIKE '%" + fil4s[2]
						+ "%' OR fil4 LIKE '%" + fil4s[3] + "%' OR fil4 LIKE '%" + fil4s[4] + "%' ";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3] + "&fil4="
						+ fil4s[4];
			}

			if (fil4s.length == 6) {
				fil4 = "fil4 LIKE '%" + fil4s[0] + "%' OR fil4 LIKE '%" + fil4s[1] + "%' OR fil4 LIKE '%" + fil4s[2]
						+ "%' OR fil4 LIKE '%" + fil4s[3] + "%' OR fil4 LIKE '%" + fil4s[4] + "%' OR fil4 LIKE '%"
						+ fil4s[5] + "%' ";
				map.put("fil4", fil4);
				fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3] + "&fil4="
						+ fil4s[4] + "&fil4=" + fil4s[5];
			}
		}

		// 5������

		if (fil5s == null || fil5s[0] == "") {
			fil5 = "fil5 LIKE '%%' OR fil5 IS null";
			map.put("fil5", fil5);
			fil5p = "&fil5=";
		}
		if (fil5s != null && fil5s[0] != "") {
			if (fil5s.length == 1) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%'";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0];
			}

			if (fil5s.length == 2) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%' OR fil5 LIKE '%" + fil5s[1] + "%'";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1];
			}

			if (fil5s.length == 3) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%' OR fil5 LIKE '%" + fil5s[1] + "%' OR fil5 LIKE '%" + fil5s[2]
						+ "%'";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2];
			}

			if (fil5s.length == 4) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%' OR fil5 LIKE '%" + fil5s[1] + "%' OR fil5 LIKE '%" + fil5s[2]
						+ "%' OR fil5 LIKE '%" + fil5s[3] + "%'";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3];
			}

			if (fil5s.length == 5) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%' OR fil5 LIKE '%" + fil5s[1] + "%' OR fil5 LIKE '%" + fil5s[2]
						+ "%' OR fil5 LIKE '%" + fil5s[3] + "%' OR fil5 LIKE '%" + fil5s[4] + "%' ";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3] + "&fil5="
						+ fil5s[4];
			}

			if (fil5s.length == 6) {
				fil5 = "fil5 LIKE '%" + fil5s[0] + "%' OR fil5 LIKE '%" + fil5s[1] + "%' OR fil5 LIKE '%" + fil5s[2]
						+ "%' OR fil5 LIKE '%" + fil5s[3] + "%' OR fil5 LIKE '%" + fil5s[4] + "%' OR fil5 LIKE '%"
						+ fil5s[5] + "%' ";
				map.put("fil5", fil5);
				fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3] + "&fil5="
						+ fil5s[4] + "&fil5=" + fil5s[5];
			}
		}

		// 6������
		if (fil6s == null || fil6s[0] == "") {
			fil6 = "fil6 LIKE '%%' OR fil6 IS null";
			map.put("fil6", fil6);
			fil6p = "&fil6=";
		}
		if (fil6s != null && fil6s[0] != "") {
			if (fil6s.length == 1) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%'";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0];
			}

			if (fil6s.length == 2) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%' OR fil6 LIKE '%" + fil6s[1] + "%'";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1];
			}

			if (fil6s.length == 3) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%' OR fil6 LIKE '%" + fil6s[1] + "%' OR fil6 LIKE '%" + fil6s[2]
						+ "%'";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2];
			}

			if (fil6s.length == 4) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%' OR fil6 LIKE '%" + fil6s[1] + "%' OR fil6 LIKE '%" + fil6s[2]
						+ "%' OR fil6 LIKE '%" + fil6s[3] + "%'";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3];
			}

			if (fil6s.length == 5) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%' OR fil6 LIKE '%" + fil6s[1] + "%' OR fil6 LIKE '%" + fil6s[2]
						+ "%' OR fil6 LIKE '%" + fil6s[3] + "%' OR fil6 LIKE '%" + fil6s[4] + "%' ";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3] + "&fil6="
						+ fil6s[4];
			}

			if (fil6s.length == 6) {
				fil6 = "fil6 LIKE '%" + fil6s[0] + "%' OR fil6 LIKE '%" + fil6s[1] + "%' OR fil6 LIKE '%" + fil6s[2]
						+ "%' OR fil6 LIKE '%" + fil6s[3] + "%' OR fil6 LIKE '%" + fil6s[4] + "%' OR fil6 LIKE '%"
						+ fil6s[5] + "%' ";
				map.put("fil6", fil6);
				fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3] + "&fil6="
						+ fil6s[4] + "&fil6=" + fil6s[5];
			}
		}

		// 7������
		if (fil7s == null || fil7s[0] == "") {
			fil7 = "fil7 LIKE '%%' OR fil7 IS null ";
			map.put("fil7", fil7);
			fil7p = "&fil7=";
		}
		String fil7a = "";
		String fil7b = "";
		String fil7ba = "";
		String fil7bb = "";
		String fil7bc = "";
		String fil7c = "";
		String fil7ca = "";
		String fil7cb = "";
		String fil7cc = "";
		if (fil7s != null && fil7s[0] != "") {
			if (fil7s.length == 1) {
				if (Arrays.asList(fil7s).contains("1")) {
					fil7a = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'";
					fil7p = "&fil7=1";
				}
				if (Arrays.asList(fil7s).contains("3")) {
					fil7a = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'";
					fil7p = "&fil7=3";
				}
				if (Arrays.asList(fil7s).contains("6")) {
					fil7a = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600";
					fil7p = "&fil7=6";
				}
				fil7 = fil7a;
				map.put("fil7", fil7);
			}

			if (fil7s.length == 2) {
				if (Arrays.asList(fil7s).contains("1")) {
					fil7ba = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'";
				}
				if (Arrays.asList(fil7s).contains("3")) {
					fil7bb = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'";
				}
				if (Arrays.asList(fil7s).contains("6")) {
					fil7bc = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600";
				}
				if (fil7ba.equals("")) {
					fil7b = fil7bb + " OR " + fil7bc;
					fil7p = "&fil7=3&fil7=6";
				}
				if (fil7bb.equals("")) {
					fil7b = fil7ba + " OR " + fil7bc;
					fil7p = "&fil7=1&fil7=6";
				}
				if (fil7bc.equals("")) {
					fil7b = fil7ba + " OR " + fil7bb;
					fil7p = "&fil7=1&fil7=3";
				}
				fil7 = fil7b;
				map.put("fil7", fil7);
			}

			if (fil7s.length == 3) {
				if (Arrays.asList(fil7s).contains("1")) {
					fil7ca = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'";
				}
				if (Arrays.asList(fil7s).contains("3")) {
					fil7cb = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'";
				}
				if (Arrays.asList(fil7s).contains("6")) {
					fil7cc = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600";
				}
				fil7c = fil7ca + " OR " + fil7cb + " OR " + fil7cc;
				fil7p = "&fil7=1&fil7=3&fil7=6";
				fil7 = fil7c;
				map.put("fil7", fil7);
			}

		}

		// 8������
		if (fil8s == null || fil8s[0] == "") {
			fil8 = "fil8 LIKE '%%' OR fil8 IS null ";
			map.put("fil8", fil8);
			fil8p = "&fil8=";
		}
		String fil8a = "";
		String fil8b = "";
		String fil8ba = "";
		String fil8bb = "";
		String fil8bc = "";
		String fil8bd = "";
		String fil8c = "";
		String fil8ca = "";
		String fil8cb = "";
		String fil8cc = "";
		String fil8cd = "";
		String fil8d = "";
		String fil8da = "";
		String fil8db = "";
		String fil8dc = "";
		String fil8dd = "";
		if (fil8s != null && fil8s[0] != "") {
			if (fil8s.length == 1) {
				if (Arrays.asList(fil8s).contains("1000")) {
					fil8a = "fil8 <= 1000 ";
					fil8p = "&fil8=1000";
				}
				if (Arrays.asList(fil8s).contains("1001")) {
					fil8a = "fil8 >= 1000 AND fil8 <= 2000";
					fil8p = "&fil8=1001";
				}
				if (Arrays.asList(fil8s).contains("2001")) {
					fil8a = "fil8 >= 2000 AND fil8 <= 3000";
					fil8p = "&fil8=2001";
				}
				if (Arrays.asList(fil8s).contains("3001")) {
					fil8a = "fil8 >= 3000 ";
					fil8p = "&fil8=3001";
				}
				fil8 = fil8a;
				map.put("fil8", fil8);
			}

			if (fil8s.length == 2) {
				if (Arrays.asList(fil8s).contains("1000")) {
					fil8ba = "fil8 <= 1000 ";
					fil8p = "&fil8=1000";
				}
				if (Arrays.asList(fil8s).contains("1001")) {
					fil8bb = "fil8 >= 1000 AND fil8 <= 2000";
					fil8p = "&fil8=1001";
				}
				if (Arrays.asList(fil8s).contains("2001")) {
					fil8bc = "fil8 >= 2000 AND fil8 <= 3000";
					fil8p = "&fil8=2001";
				}
				if (Arrays.asList(fil8s).contains("3001")) {
					fil8bd = "fil8 >= 3000 ";
					fil8p = "&fil8=3001";
				}

				if (fil8ba.equals("") && fil8bb.equals("")) {
					fil8b = fil8bc + " OR " + fil8bd;
					fil8p = "&fil8=2001&fil8=3001";
				}
				if (fil8ba.equals("") && fil8bc.equals("")) {
					fil8b = fil8bb + " OR " + fil8bd;
					fil8p = "&fil8=1001&fil8=3001";
				}
				if (fil8ba.equals("") && fil8bd.equals("")) {
					fil8b = fil8bb + " OR " + fil8bc;
					fil8p = "&fil8=1001&fil8=2001";
				}
				if (fil8bb.equals("") && fil8bc.equals("")) {
					fil8b = fil8ba + " OR " + fil8bd;
					fil8p = "&fil8=1000&fil8=3001";
				}
				if (fil8bb.equals("") && fil8bd.equals("")) {
					fil8b = fil8ba + " OR " + fil8bc;
					fil8p = "&fil8=1000&fil8=2001";
				}
				if (fil8bc.equals("") && fil8bd.equals("")) {
					fil8b = fil8ba + " OR " + fil8bb;
					fil8p = "&fil8=1000&fil8=1001";
				}
				fil8 = fil8b;
				map.put("fil8", fil8);
			}

			if (fil8s.length == 3) {
				if (Arrays.asList(fil8s).contains("1000")) {
					fil8ca = "fil8 <= 1000 ";
					fil8p = "&fil8=1000";
				}
				if (Arrays.asList(fil8s).contains("1001")) {
					fil8cb = "fil8 >= 1000 AND fil8 <= 2000";
					fil8p = "&fil8=1001";
				}
				if (Arrays.asList(fil8s).contains("2001")) {
					fil8cc = "fil8 >= 2000 AND fil8 <= 3000";
					fil8p = "&fil8=2001";
				}
				if (Arrays.asList(fil8s).contains("3001")) {
					fil8cd = "fil8 >= 3000 ";
					fil8p = "&fil8=3001";
				}

				if (fil8ca.equals("")) {
					fil8c = fil8cb + " OR " + fil8cc + " OR " + fil8cd;
					fil8p = "fil8=1001&fil8=2001&fil8=3001";
				}
				if (fil8cb.equals("")) {
					fil8c = fil8ca + " OR " + fil8cc + " OR " + fil8cd;
					fil8p = "fil8=1000&fil8=2001&fil8=3001";
				}
				if (fil8cc.equals("")) {
					fil8c = fil8ca + " OR " + fil8cb + " OR " + fil8cd;
					fil8p = "fil8=1000&fil8=1001&fil8=3001";
				}
				if (fil8cd.equals("")) {
					fil8c = fil8ca + " OR " + fil8cb + " OR " + fil8cc;
					fil8p = "fil8=1000&fil8=1001&fil8=2001";
				}

				fil8 = fil8c;
				map.put("fil8", fil8);
			}

			if (fil8s.length == 4) {
				if (Arrays.asList(fil8s).contains("1000")) {
					fil8da = "fil8 <= 1000 ";
					fil8p = "&fil8=1000";
				}
				if (Arrays.asList(fil8s).contains("1001")) {
					fil8db = "fil8 >= 1000 AND fil8 <= 2000";
					fil8p = "&fil8=1001";
				}
				if (Arrays.asList(fil8s).contains("2001")) {
					fil8dc = "fil8 >= 2000 AND fil8 <= 3000";
					fil8p = "&fil8=2001";
				}
				if (Arrays.asList(fil8s).contains("3001")) {
					fil8dd = "fil8 >= 3000 ";
					fil8p = "&fil8=3001";
				}

				fil8d = fil8da + " OR " + fil8db + " OR " + fil8dc + " OR " + fil8dd;
				fil8p = "fil8=1000&fil8=1001&fil8=2001&fil8=3001";
				fil8 = fil8d;
				map.put("fil8", fil8);

			}
		}

		// 9������

		if (fil9s == null || fil9s[0] == "") {
			fil9 = "fil9 LIKE '%%' OR fil9 IS null ";
			map.put("fil9", fil9);
			fil9p = "&fil9=";
		}
		String fil9a = "";
		String fil9b = "";
		String fil9ba = "";
		String fil9bb = "";
		String fil9bc = "";
		String fil9bd = "";
		String fil9c = "";
		String fil9ca = "";
		String fil9cb = "";
		String fil9cc = "";
		String fil9cd = "";
		String fil9d = "";
		String fil9da = "";
		String fil9db = "";
		String fil9dc = "";
		String fil9dd = "";
		if (fil9s != null && fil9s[0] != "") {
			if (fil9s.length == 1) {
				if (Arrays.asList(fil9s).contains("10")) {
					fil9a = "fil9 <= 10 ";
					fil9p = "&fil9=10";
				}
				if (Arrays.asList(fil9s).contains("20")) {
					fil9a = "fil9 >= 10 AND fil9 <= 20";
					fil9p = "&fil9=20";
				}
				if (Arrays.asList(fil9s).contains("40")) {
					fil9a = "fil9 >= 20 AND fil9 <= 40";
					fil9p = "&fil9=40";
				}
				if (Arrays.asList(fil9s).contains("41")) {
					fil9a = "fil9 >= 40 ";
					fil9p = "&fil9=41";
				}
				fil9 = fil9a;
				map.put("fil9", fil9);
			}

			if (fil9s.length == 2) {
				if (Arrays.asList(fil9s).contains("10")) {
					fil9ba = "fil9 <= 10 ";
					fil9p = "&fil9=10";
				}
				if (Arrays.asList(fil9s).contains("20")) {
					fil9bb = "fil9 >= 10 AND fil9 <= 20";
					fil9p = "&fil9=20";
				}
				if (Arrays.asList(fil9s).contains("40")) {
					fil9bc = "fil9 >= 20 AND fil9 <= 40";
					fil9p = "&fil9=40";
				}
				if (Arrays.asList(fil9s).contains("41")) {
					fil9bd = "fil9 >= 40 ";
					fil9p = "&fil9=41";
				}

				if (fil9ba.equals("") && fil9bb.equals("")) {
					fil9b = fil9bc + " OR " + fil9bd;
					fil9p = "&fil9=40&fil9=41";
				}
				if (fil9ba.equals("") && fil9bc.equals("")) {
					fil9b = fil9bb + " OR " + fil9bd;
					fil9p = "&fil9=20&fil9=41";
				}
				if (fil9ba.equals("") && fil9bd.equals("")) {
					fil9b = fil9bb + " OR " + fil9bc;
					fil9p = "&fil9=20&fil9=40";
				}
				if (fil9bb.equals("") && fil9bc.equals("")) {
					fil9b = fil9ba + " OR " + fil9bd;
					fil9p = "&fil9=10&fil9=41";
				}
				if (fil9bb.equals("") && fil9bd.equals("")) {
					fil9b = fil9ba + " OR " + fil9bc;
					fil9p = "&fil9=10&fil9=40";
				}
				if (fil9bc.equals("") && fil9bd.equals("")) {
					fil9b = fil9ba + " OR " + fil9bb;
					fil9p = "&fil9=10&fil9=20";
				}
				fil9 = fil9b;
				map.put("fil9", fil9);
			}

			if (fil9s.length == 3) {
				if (Arrays.asList(fil9s).contains("10")) {
					fil9ca = "fil9 <= 10 ";
					fil9p = "&fil9=10";
				}
				if (Arrays.asList(fil9s).contains("20")) {
					fil9cb = "fil9 >= 10 AND fil9 <= 20";
					fil9p = "&fil9=20";
				}
				if (Arrays.asList(fil9s).contains("40")) {
					fil9cc = "fil9 >= 20 AND fil9 <= 40";
					fil9p = "&fil9=40";
				}
				if (Arrays.asList(fil9s).contains("41")) {
					fil9cd = "fil9 >= 40 ";
					fil9p = "&fil9=41";
				}

				if (fil9ca.equals("")) {
					fil9c = fil9cb + " OR " + fil9cc + " OR " + fil9cd;
					fil9p = "fil9=20&fil9=40&fil9=41";
				}
				if (fil9cb.equals("")) {
					fil9c = fil9ca + " OR " + fil9cc + " OR " + fil9cd;
					fil9p = "fil9=10&fil9=40&fil9=41";
				}
				if (fil9cc.equals("")) {
					fil9c = fil9ca + " OR " + fil9cb + " OR " + fil9cd;
					fil9p = "fil9=10&fil9=20&fil9=41";
				}
				if (fil9cd.equals("")) {
					fil9c = fil9ca + " OR " + fil9cb + " OR " + fil9cc;
					fil9p = "fil9=10&fil9=20&fil9=40";
				}

				fil9 = fil9c;
				map.put("fil9", fil9);
			}

			if (fil9s.length == 4) {
				if (Arrays.asList(fil9s).contains("10")) {
					fil9da = "fil9 <= 10 ";
					fil9p = "&fil9=10";
				}
				if (Arrays.asList(fil9s).contains("20")) {
					fil9db = "fil9 >= 10 AND fil9 <= 20";
					fil9p = "&fil9=20";
				}
				if (Arrays.asList(fil9s).contains("40")) {
					fil9dc = "fil9 >= 20 AND fil9 <= 40";
					fil9p = "&fil9=40";
				}
				if (Arrays.asList(fil9s).contains("41")) {
					fil9dd = "fil9 >= 40 ";
					fil9p = "&fil9=41";
				}

				fil9d = fil9da + " OR " + fil9db + " OR " + fil9dc + " OR " + fil9dd;
				fil9p = "fil9=10&fil9=20&fil9=40&fil9=41";
				fil9 = fil9d;
				map.put("fil9", fil9);

			}
		}
		// 10������

		if (fil10s == null || fil10s[0] == "") {
			fil10 = "fil10 LIKE '%%' OR fil10 IS null ";
			map.put("fil10", fil10);
			fil10p = "&fil10=";
		}
		String fil10a = "";
		String fil10b = "";
		String fil10ba = "";
		String fil10bb = "";
		String fil10bc = "";
		String fil10c = "";
		String fil10ca = "";
		String fil10cb = "";
		String fil10cc = "";
		if (fil10s != null && fil10s[0] != "") {
			if (fil10s.length == 1) {
				if (Arrays.asList(fil10s).contains("1000")) {
					fil10a = "fil10 <= 1000 ";
					fil10p = "&fil10=1000";
				}
				if (Arrays.asList(fil10s).contains("2000")) {
					fil10a = "fil10 >= 1000 and  fil10 <= 2000";
					fil10p = "&fil10=2000";
				}
				if (Arrays.asList(fil10s).contains("2001")) {
					fil10a = "fil10 >= 2000";
					fil10p = "&fil10=2001";
				}
				fil10 = fil10a;
				map.put("fil10", fil10);
			}

			if (fil10s.length == 2) {
				if (Arrays.asList(fil10s).contains("1000")) {
					fil10ba = "fil10 <= 1000 ";
					fil10p = "&fil10=1000";
				}
				if (Arrays.asList(fil10s).contains("2000")) {
					fil10bb = "fil10 >= 1000 and  fil10 <= 2000";
					fil10p = "&fil10=2000";
				}
				if (Arrays.asList(fil10s).contains("2001")) {
					fil10bc = "fil10 >= 2000";
					fil10p = "&fil10=2001";
				}
				if (fil10ba.equals("")) {
					fil10b = fil10bb + " OR " + fil10bc;
					fil10p = "&fil10=2000&fil10=2001";
				}
				if (fil10bb.equals("")) {
					fil10b = fil10ba + " OR " + fil10bc;
					fil10p = "&fil10=1000&fil10=2001";
				}
				if (fil10bc.equals("")) {
					fil10b = fil10ba + " OR " + fil10bb;
					fil10p = "&fil10=1000&fil10=2000";
				}
				fil10 = fil10b;
				map.put("fil10", fil10);
			}

			if (fil10s.length == 3) {
				if (Arrays.asList(fil10s).contains("1000")) {
					fil10ca = "fil10 <= 1000 ";
					fil10p = "&fil10=1000";
				}
				if (Arrays.asList(fil10s).contains("2000")) {
					fil10cb = "fil10 >= 1000 and  fil10 <= 2000";
					fil10p = "&fil10=2000";
				}
				if (Arrays.asList(fil10s).contains("2001")) {
					fil10cc = "fil10 >= 2000";
					fil10p = "&fil10=2001";
				}
				fil10c = fil10ca + " OR " + fil10cb + " OR " + fil10cc;
				fil10p = "&fil10=1000&fil10=2000&fil10=2001";
				fil10 = fil10c;
				map.put("fil10", fil10);
			}

		}

		// 11������

		if (fil11s == null || fil11s[0] == "") {
			fil11 = "fil11 LIKE '%%' OR fil11 IS null ";
			map.put("fil11", fil11);
			fil11p = "&fil11=";
		}
		String fil11a = "";
		String fil11b = "";
		String fil11ba = "";
		String fil11bb = "";
		String fil11bc = "";
		String fil11bd = "";
		String fil11c = "";
		String fil11ca = "";
		String fil11cb = "";
		String fil11cc = "";
		String fil11cd = "";
		String fil11d = "";
		String fil11da = "";
		String fil11db = "";
		String fil11dc = "";
		String fil11dd = "";
		if (fil11s != null && fil11s[0] != "") {
			if (fil11s.length == 1) {
				if (Arrays.asList(fil11s).contains("-50")) {
					fil11a = "fil11 <= -50 and fil11 >= -69";
					fil11p = "&fil11=-50";
				}
				if (Arrays.asList(fil11s).contains("-30")) {
					fil11a = "fil11 >= -50 AND fil11 <= -30";
					fil11p = "&fil11=-30";
				}
				if (Arrays.asList(fil11s).contains("-10")) {
					fil11a = "fil11 >= -30 AND fil11 <= -10";
					fil11p = "&fil11=-10";
				}
				if (Arrays.asList(fil11s).contains("0")) {
					fil11a = "fil11 >= -10 ";
					fil11p = "&fil11=0";
				}
				fil11 = fil11a;
				map.put("fil11", fil11);
			}

			if (fil11s.length == 2) {
				if (Arrays.asList(fil11s).contains("-50")) {
					fil11ba = "fil11 <= -50 and fil11 >= -69";
					fil11p = "&fil11=-50";
				}
				if (Arrays.asList(fil11s).contains("-30")) {
					fil11bb = "fil11 >= -50 AND fil11 <= -30";
					fil11p = "&fil11=-30";
				}
				if (Arrays.asList(fil11s).contains("-10")) {
					fil11bc = "fil11 >= -30 AND fil11 <= -10";
					fil11p = "&fil11=-10";
				}
				if (Arrays.asList(fil11s).contains("0")) {
					fil11bd = "fil11 >= -10 ";
					fil11p = "&fil11=0";
				}

				if (fil11ba.equals("") && fil11bb.equals("")) {
					fil11b = fil11bc + " OR " + fil11bd;
					fil11p = "&fil11=-10&fil11=0";
				}
				if (fil11ba.equals("") && fil11bc.equals("")) {
					fil11b = fil11bb + " OR " + fil11bd;
					fil11p = "&fil11=-30&fil11=0";
				}
				if (fil11ba.equals("") && fil11bd.equals("")) {
					fil11b = fil11bb + " OR " + fil11bc;
					fil11p = "&fil11=-30&fil11=-10";
				}
				if (fil11bb.equals("") && fil11bc.equals("")) {
					fil11b = fil11ba + " OR " + fil11bd;
					fil11p = "&fil11=-50&fil11=0";
				}
				if (fil11bb.equals("") && fil11bd.equals("")) {
					fil11b = fil11ba + " OR " + fil11bc;
					fil11p = "&fil11=-50&fil11=-10";
				}
				if (fil11bc.equals("") && fil11bd.equals("")) {
					fil11b = fil11ba + " OR " + fil11bb;
					fil11p = "&fil11=-50&fil11=-30";
				}
				fil11 = fil11b;
				map.put("fil11", fil11);
			}

			if (fil11s.length == 3) {
				if (Arrays.asList(fil11s).contains("-50")) {
					fil11ca = "fil11 <= -50 and fil11 >= -69";
					fil11p = "&fil11=-50";
				}
				if (Arrays.asList(fil11s).contains("-30")) {
					fil11cb = "fil11 >= -50 AND fil11 <= -30";
					fil11p = "&fil11=-30";
				}
				if (Arrays.asList(fil11s).contains("-10")) {
					fil11cc = "fil11 >= -30 AND fil11 <= -10";
					fil11p = "&fil11=-10";
				}
				if (Arrays.asList(fil11s).contains("0")) {
					fil11cd = "fil11 >= -10 ";
					fil11p = "&fil11=0";
				}

				if (fil11ca.equals("")) {
					fil11c = fil11cb + " OR " + fil11cc + " OR " + fil11cd;
					fil11p = "fil11=-30&fil11=-10&fil11=0";
				}
				if (fil11cb.equals("")) {
					fil11c = fil11ca + " OR " + fil11cc + " OR " + fil11cd;
					fil11p = "fil11=-50&fil11=-10&fil11=0";
				}
				if (fil11cc.equals("")) {
					fil11c = fil11ca + " OR " + fil11cb + " OR " + fil11cd;
					fil11p = "fil11=-50&fil11=-30&fil11=0";
				}
				if (fil11cd.equals("")) {
					fil11c = fil11ca + " OR " + fil11cb + " OR " + fil11cc;
					fil11p = "fil11=-50&fil11=-30&fil11=-10";
				}

				fil11 = fil11c;
				map.put("fil11", fil11);
			}

			if (fil11s.length == 4) {
				if (Arrays.asList(fil11s).contains("-50")) {
					fil11da = "fil11 <= -50 and fil11 >= -69";
					fil11p = "&fil11=-50";
				}
				if (Arrays.asList(fil11s).contains("-30")) {
					fil11db = "fil11 >= -50 AND fil11 <= -30";
					fil11p = "&fil11=-30";
				}
				if (Arrays.asList(fil11s).contains("-10")) {
					fil11dc = "fil11 >= -30 AND fil11 <= -10";
					fil11p = "&fil11=-10";
				}
				if (Arrays.asList(fil11s).contains("0")) {
					fil11dd = "fil11 >= -10 ";
					fil11p = "&fil11=0";
				}

				fil11d = fil11da + " OR " + fil11db + " OR " + fil11dc + " OR " + fil11dd;
				fil11p = "fil11=-50&fil11=-30&fil11=-10&fil11=0";
				fil11 = fil11d;
				map.put("fil11", fil11);

			}
		}
		// 12������

		if (fil12s == null || fil12s[0] == "") {
			fil12 = "fil12 LIKE '%%' OR fil12 IS null  ";
			map.put("fil12", fil12);
			fil12p = "&fil12=";
		}
		String fil12a = "";
		String fil12b = "";
		String fil12ba = "";
		String fil12bb = "";
		String fil12bc = "";
		String fil12c = "";
		String fil12ca = "";
		String fil12cb = "";
		String fil12cc = "";
		if (fil12s != null && fil12s[0] != "") {
			if (fil12s.length == 1) {
				if (Arrays.asList(fil12s).contains("100")) {
					fil12a = "fil12 <= 100 ";
					fil12p = "&fil12=100";
				}
				if (Arrays.asList(fil12s).contains("120")) {
					fil12a = "fil12 >= 100 and  fil12 <= 120";
					fil12p = "&fil12=120";
				}
				if (Arrays.asList(fil12s).contains("121")) {
					fil12a = "fil12 >= 120";
					fil12p = "&fil12=121";
				}
				fil12 = fil12a;
				map.put("fil12", fil12);
			}

			if (fil12s.length == 2) {
				if (Arrays.asList(fil12s).contains("100")) {
					fil12ba = "fil12 <= 100 ";
					fil12p = "&fil12=100";
				}
				if (Arrays.asList(fil12s).contains("120")) {
					fil12bb = "fil12 >= 100 and  fil12 <= 120";
					fil12p = "&fil12=120";
				}
				if (Arrays.asList(fil12s).contains("121")) {
					fil12bc = "fil12 >= 120";
					fil12p = "&fil12=121";
				}
				if (fil12ba.equals("")) {
					fil12b = fil12bb + " OR " + fil12bc;
					fil12p = "&fil12=120&fil12=121";
				}
				if (fil12bb.equals("")) {
					fil12b = fil12ba + " OR " + fil12bc;
					fil12p = "&fil12=100&fil12=121";
				}
				if (fil12bc.equals("")) {
					fil12b = fil12ba + " OR " + fil12bb;
					fil12p = "&fil12=100&fil12=120";
				}
				fil12 = fil12b;
				map.put("fil12", fil12);
			}

			if (fil12s.length == 3) {
				if (Arrays.asList(fil12s).contains("100")) {
					fil12ca = "fil12 <= 100 ";
					fil12p = "&fil12=100";
				}
				if (Arrays.asList(fil12s).contains("120")) {
					fil12cb = "fil12 >= 100 and  fil12 <= 120";
					fil12p = "&fil12=120";
				}
				if (Arrays.asList(fil12s).contains("121")) {
					fil12cc = "fil12 >= 120";
					fil12p = "&fil12=121";
				}
				fil12c = fil12ca + " OR " + fil12cb + " OR " + fil12cc;
				fil12p = "&fil12=100&fil12=120&fil12=121";
				fil12 = fil12c;
				map.put("fil12", fil12);
			}
			
			

		}
		
		//��ǰ��˻�
		if (titles == null || titles == "") {
			title = "TITLE LIKE '%%' OR TITLE IS null ";
			map.put("title", title);
			titlep = "&title=";
		}
		if (titles != null && titles != "") {
			
				title = "title LIKE '%" + titles + "%'";
				map.put("title", title);
				titlep = "&title=" + titles;
			
		}
		
		//���ͺ� üũ�� ���� ���ļ� �Ķ���ͷ� ��� 
		String filpara = brandp + fil1p + fil2p + fil3p + fil4p + fil5p + fil6p + fil7p + fil8p + fil9p + fil10p
				+ fil11p + fil12p + titlep;
		
		//����Ʈ�� ǥ�õ� ��ǰ �� /��ǰ ���� ȣ�� 
		count = service.getEquipCount(map);
		List<EquipDTO> EquipList = service.getEquipList(map);
		
		
		
		//���ã�� ���� �� �� �������� ���͸� ���� uri/�Ķ���ͼ���
		String uri = request.getRequestURI();
		String uri2 = request.getQueryString();
		String uri3 = uri + "?" + uri2;
		
		
		//��ǰ�� ���ã�� ���� �� ����(�α��ν�)
		if(session.getAttribute("memId") != null) {
		int listCount = service.getEquipListCount(map);
		
		System.out.println(listCount);
		
		map.put("id",memId);
		List<Integer> FavList = new ArrayList<>();
		for(int i=0; i < listCount; i++ ) {
		map.put("num2",EquipList.get(i).getNum());

		FavList.add(service.equipFavoriteCnt(map));
		
		}
		
		if(!EquipList.isEmpty()){
			System.out.println(EquipList.get(0).getNum());
		}
		
		System.out.println(FavList);
		 
		    
		model.addAttribute("ifFavorite", FavList);
		
		}
		

		
		model.addAttribute("EquipList", EquipList);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("category", category);
		model.addAttribute("filpara", filpara);
		model.addAttribute("uri",uri);
		model.addAttribute("uri2",uri2);
		model.addAttribute("uri3",uri3);
		return "equip/equipList";
	}

	
	
	@RequestMapping("main")
	public String main(HttpSession session) {
		
		String memId = (String)session.getAttribute("memId");
		
		
		return "equip/equipMain";
	
		
		
	}
	
	@RequestMapping("insert")
	public String insert() {
		
		
		
		return "equip/equipInsert";
	
		
		
	}
	
	@RequestMapping("insertPro")
	public String insertPro(EquipDTO dto) {
		
		service.equipInsert(dto);
		
		return "equip/equipInsertPro";
	
		
		
	}
	
	@RequestMapping("favorite")
	public String favorite(HttpSession session,String id,int status,int num,Model model,EquipDTO dto,HttpServletRequest request) {
		
		
		String memId = (String)session.getAttribute("memId");
		HashMap<String, Object> equipFavorite = new HashMap<String, Object>();
		equipFavorite.put("num", num);
		equipFavorite.put("id", memId);
		equipFavorite.put("status", status);
		
		int favoriteInsert = 2;
		int favoriteDelete = 2; 
		int favoriteCount = service.equipFavoriteCount(equipFavorite);
		
		if(favoriteCount == 0) {
		 favoriteInsert = service.equipFavoriteInsert(equipFavorite);
		}
		else {
		 favoriteDelete = service.equipFavoriteDelete(equipFavorite);
		}
		
		//���޹��� �Ķ���� �ȿ��ִ� uri�� Ȱ���ؼ� ���� �������� ����
		String uri = request.getQueryString();
		System.out.println(uri);
		int index = uri.indexOf("uri");
		System.out.println(index);
		String uri1 = uri.substring(index+4);
		System.out.println(uri1);
		
		
		model.addAttribute("uri", uri1);
		model.addAttribute("favoriteInsert", favoriteInsert);
		model.addAttribute("favoriteCount", favoriteCount);
		model.addAttribute("favoriteDelete", favoriteDelete);

		return "equip/equipFavorite";
	
		
		
	}
	
	
	@RequestMapping("test")
	public String test() {
		return "equip/test";	
	
	
	
		
		
	}

	
}


