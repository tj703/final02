package org.camping.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.camping.service.StaticService;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


import org.camping.model.SpotCategoryDTO;
import org.camping.model.SpotDTO;
import org.camping.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spot/*")
public class SpotController {

	@Autowired
	private SpotService service;
	

	@Autowired
	private StaticService staticService;
	
	// ķ���� ���� ���� ����
	@RequestMapping("info")
	public String Info(Model model,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// ���� �� ������ �α� ķ���� ��õ
		model.addAttribute("nonLog", service.getPopularList());
		
		// ���� ������ ķ���� ��õ
		String answer = service.checkAns(memId);
		String[] ans = answer.split(",");
		model.addAttribute("count",service.getCountCheck(ans));
		model.addAttribute("answer",answer);
		model.addAttribute("log", service.getSearchCheck(ans, 1, 8));
		
		return "spot/main";
	}
	// ���� �˻�
	@RequestMapping("map")
	public String Map(Model model, String searchMap,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		if(searchMap != null) {
		statics.put("keyword",searchMap);
		}else if (searchMap == null) {
			statics.put("keyword","");
		}
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		List<SpotDTO> list = service.getAllSpot();
		model.addAttribute("searchMap", searchMap);
		model.addAttribute("mapinfo", list);
		return "spot/searchMap";
	}
	// ķ���� �˻�
	@RequestMapping("key")
	public String Key(Model model, String searchKey, String pageNum,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		if(searchKey != null) {
		statics.put("keyword",searchKey);
		}else if (searchKey == null) {
			statics.put("keyword","");
		}
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getCountKey(searchKey);
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getSearchKey(searchKey, startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("searchKey", searchKey);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/searchKey";
	}
	// üũ�ڽ� �˻�
	@RequestMapping("check")
	public String Check(Model model, String[] searchCheck, String pageNum,HttpServletRequest request,HttpSession session) throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
			statics.put("keyword","");
		//����üũ�� 
		String fil = "Sp";
		for(int i=0; i < searchCheck.length; i++) {
			fil += ","+searchCheck[i];
		}
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getCountCheck(searchCheck);
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getSearchCheck(searchCheck, startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		// ����¡�� ���� ������ �̵�
		String key ="";
		if(searchCheck !=null){
			for(int i = 0 ;i < searchCheck.length; i++) {
				key += "&searchCheck="+searchCheck[i];
			}
		}
	
		model.addAttribute("key",key);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/searchCheck";
	}
	// �غ� ����Ʈ
	@RequestMapping("beach")
	public String Beach(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {
		
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getBeachCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getBeachList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/beach";
	}
	// ���� ����Ʈ
	@RequestMapping("city")
	public String City(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getCityCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getCityList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/city";
	}
	// �� ����Ʈ
	@RequestMapping("forest")
	public String Forest(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getForestCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getForestList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/forest";
	}
	// �� ����Ʈ
	@RequestMapping("island")
	public String Island(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getIslandCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getIslandList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/island";
	}
	// ��,��� ����Ʈ
	@RequestMapping("mountain")
	public String Mountain(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {


		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
			statics.put("keyword","");
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getMountainCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getMountainList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/mountain";
	}
	// �� ����Ʈ
	@RequestMapping("river")
	public String River(Model model, String pageNum,HttpServletRequest request,HttpSession session)throws UnsupportedEncodingException {


		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		
		//����üũ�� 
		String fil = "";
		statics.put("filter",fil);
		//����������� 
		staticService.pageStatic(statics);
		
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 8;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		count = service.getRiverCount();
		
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getRiverList(startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("pageBlock", pageBlock);
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		return "spot/river";
	}
	// �̵�� ���� ����Ʈ
	@RequestMapping("media")
	public String Media() {
		return "spot/media";
	}
	//ķ���� ����
	@RequestMapping("campingspot")
	public String campingspot(Model model, int num, HttpServletRequest request, HttpSession session)throws UnsupportedEncodingException {
		//���
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
		statics.put("page",decodedPage);
		//�� ������
		String inflow = (String)request.getHeader("Referer");
		if(inflow != null) {
		String decodedInflow  = URLDecoder.decode(inflow, "UTF-8");        
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
		statics.put("keyword","");
		//����üũ�� 
		String fils = "";
		statics.put("filter",fils);
		//����������� 
		staticService.pageStatic(statics);

		// ��ȸ�� ����
		service.updateRead(num);
		// ������ ��ǥ ���� üũ
		int filCount = service.getCountFil(num);
		ArrayList fil = new ArrayList();
		// ��ǥ������ ����̸� �� ���ڸ�ŭ �ݺ������� ������ ���� ī�װ� ���ڵ� list fil�� �������
		if(filCount>0) {
			for(int filNum = 1; filNum<filCount+1; filNum++) {
				String filName = service.getFil(filNum, num);
				fil.add(filName);
			}
		}
		// ���� ī�װ����� ī�װ� DTO�� ���ؼ� ���� ���� �ҷ���
		List<SpotCategoryDTO> filList = service.getContentFil(fil);
		// cate = exp�� Ű�� ���� ����
		HashMap<String,String> filMap = new HashMap();
		for (SpotCategoryDTO item : filList) {
			filMap.put(item.getCate(), item.getExp()+" ");
		}
		int result = service.checkFav(memId, num);
		model.addAttribute("result", result);	
		model.addAttribute("spot", service.getContent(num));
		model.addAttribute("fil",filMap);
		return "spot/content";
	}
	
	// ķ���� ���ã��
	@RequestMapping("fav")
	public String fav(Model model, int num, String id) {
		int result = service.checkFav(id, num);
		if(result == 0) {
			service.inFav(id, num);
		}else{
			service.delFav(id, num);
		}
		model.addAttribute("num", num);
		model.addAttribute("result", result);
		return "spot/favoritePro";
	}
}
