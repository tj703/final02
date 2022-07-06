package org.camping.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.camping.model.EquipDTO;
import org.camping.service.EquipService;
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
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,String cat,String pageNum,Model model) {
		
		if(pageNum == null) pageNum = "1";
		if(cat == null) cat = "0";
		
		

		
		int pageSize = 30;
		int category = Integer.parseInt(cat);
		int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    int endRow = currentPage * pageSize;
	    int count = 0;
	    int number=0;
	    

	    
	    
		String tent = "WHERE CATEGORY = 1";
		String taf  = "WHERE CATEGORY = 2";
		String mat  = "WHERE CATEGORY = 3";
		String sb  	 = "WHERE CATEGORY = 4";
		String chair = "WHERE CATEGORY = 5";
		String ib  = "WHERE CATEGORY = 6";
		String cw  = "WHERE CATEGORY = 7";
		String stove = "WHERE CATEGORY = 8";
		String gas = "WHERE CATEGORY = 9";
		String light = "WHERE CATEGORY = 10";
		
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		if(category == 1) {map.put("category", tent);}
		if(category == 2) {map.put("category", taf);}
		if(category == 3) {map.put("category", mat);}
		if(category == 4) {map.put("category", sb);}
		if(category == 5) {map.put("category", chair);}
		if(category == 6) {map.put("category", ib);}
		if(category == 7) {map.put("category", cw);}
		if(category == 8) {map.put("category", stove);}
		if(category == 9) {map.put("category", gas);}
		if(category == 10) {map.put("category", light);}
		
		else if (category == 0) {
			map.put("category", "where category > 0");}
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
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
		
		
		
			//브랜드 필터
		    if(brands == null || brands[0] == "") {brand = "BRAND LIKE '%%' OR brand IS null "; map.put("brand", brand);  brandp = "&bran="; }
			    if(brands != null && brands[0] != "") {
					    if(brands.length == 1)
					    {brand = "BRAND LIKE '%"+brands[0]+"%'"; map.put("brand", brand); 
					     brandp = "&bran=" + brands[0];}
					    if(brands.length == 2)
					    {brand = "BRAND LIKE '%"+brands[0]+"%' OR BRAND LIKE '%"+brands[1]+"%'"; map.put("brand", brand); 
					    brandp = "&bran=" + brands[0] + "&bran=" + brands[1]; }
					    if(brands.length == 3) 
					    {brand = "BRAND LIKE '%"+brands[0]+"%' OR BRAND LIKE '%"+brands[1]+"%' OR BRAND LIKE '%"+brands[2]+"%'"; map.put("brand", brand); 
					    brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2] ;}
					    if(brands.length == 4) 
					    {brand = "BRAND LIKE '%"+brands[0]+"%' OR BRAND LIKE '%"+brands[1]+"%' OR BRAND LIKE '%"+brands[2]+"%' OR BRAND LIKE '%"+brands[3]+"%'"; map.put("brand", brand); 
					    brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2] + "&bran=" + brands[3];}
					    if(brands.length == 5) 
					    {brand = "BRAND LIKE '%"+brands[0]+"%' OR BRAND LIKE '%"+brands[1]+"%' OR BRAND LIKE '%"+brands[2]+"%' OR BRAND LIKE '%"+brands[3]+"%' OR BRAND LIKE '%"+brands[4]+"%'"; map.put("brand", brand); 
					    brandp = "&bran=" + brands[0] + "&bran=" + brands[1] + "&bran=" + brands[2] + "&bran=" + brands[3] + "&bran=" + brands[4];}
			    	}
		    
			//1번 필터

		    if(fil1s == null || fil1s[0] == "") {
		    	fil1 = "fil1 LIKE '%%' OR fil1 IS null"; 
		    	map.put("fil1", fil1); fil1p = "&fil1=";
		    }

		    
		    
		    
		    if(fil1s != null &&  fil1s[0] != "") {
				    if(fil1s.length == 1) 
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%'"; map.put("fil1", fil1); 
				    fil1p = "&fil1=" + fil1s[0];}
				    
				    if(fil1s.length == 2)
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%' OR fil1 LIKE '%"+fil1s[1]+"%'"; map.put("fil1", fil1); 
				    fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1];}
				    
				    if(fil1s.length == 3) 
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%' OR fil1 LIKE '%"+fil1s[1]+"%' OR fil1 LIKE '%"+fil1s[2]+"%'"; map.put("fil1", fil1); 
				    fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2];}
				    
				    if(fil1s.length == 4) 
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%' OR fil1 LIKE '%"+fil1s[1]+"%' OR fil1 LIKE '%"+fil1s[2]+"%' OR fil1 LIKE '%"+fil1s[3]+"%'"; map.put("fil1", fil1); 
				    fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3];}
				    
				    if(fil1s.length == 5) 
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%' OR fil1 LIKE '%"+fil1s[1]+"%' OR fil1 LIKE '%"+fil1s[2]+"%' OR fil1 LIKE '%"+fil1s[3]+"%' OR fil1 LIKE '%"+fil1s[4]+"%' "; map.put("fil1", fil1); 
				    fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3] + "&fil1=" + fil1s[4]; }
				    
				    if(fil1s.length == 6) 
				    {fil1 = "fil1 LIKE '%"+fil1s[0]+"%' OR fil1 LIKE '%"+fil1s[1]+"%' OR fil1 LIKE '%"+fil1s[2]+"%' OR fil1 LIKE '%"+fil1s[3]+"%' OR fil1 LIKE '%"+fil1s[4]+"%' OR fil1 LIKE '%"+fil1s[5]+"%' "; map.put("fil1", fil1);
				     fil1p = "&fil1=" + fil1s[0] + "&fil1=" + fil1s[1] + "&fil1=" + fil1s[2] + "&fil1=" + fil1s[3] + "&fil1=" + fil1s[4] + "&fil1=" + fil1s[5]; }
		    }
		   
		    
		    //2번필터
		    
		    if(fil2s == null || fil2s[0] == "") {fil2 = "fil2 LIKE '%%' OR fil2 IS NULL"; map.put("fil2", fil2); fil2p = "&fil2=";}
		    if(fil2s != null && fil2s[0] != "") {
				    if(fil2s.length == 1) 
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%'"; map.put("fil2", fil2); 
				    fil2p = "&fil2=" + fil2s[0];}
				    
				    if(fil2s.length == 2)
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%' OR fil2 LIKE '%"+fil2s[1]+"%'"; map.put("fil2", fil2); 
				    fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1];}
				    
				    if(fil2s.length == 3) 
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%' OR fil2 LIKE '%"+fil2s[1]+"%' OR fil2 LIKE '%"+fil2s[2]+"%'"; map.put("fil2", fil2); 
				    fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2];}
				    
				    if(fil2s.length == 4) 
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%' OR fil2 LIKE '%"+fil2s[1]+"%' OR fil2 LIKE '%"+fil2s[2]+"%' OR fil2 LIKE '%"+fil2s[3]+"%'"; map.put("fil2", fil2); 
				    fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3];}
				    
				    if(fil2s.length == 5) 
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%' OR fil2 LIKE '%"+fil2s[1]+"%' OR fil2 LIKE '%"+fil2s[2]+"%' OR fil2 LIKE '%"+fil2s[3]+"%' OR fil2 LIKE '%"+fil2s[4]+"%' "; map.put("fil2", fil2); 
				    fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3] + "&fil2=" + fil2s[4]; }
				    
				    if(fil2s.length == 6) 
				    {fil2 = "fil2 LIKE '%"+fil2s[0]+"%' OR fil2 LIKE '%"+fil2s[1]+"%' OR fil2 LIKE '%"+fil2s[2]+"%' OR fil2 LIKE '%"+fil2s[3]+"%' OR fil2 LIKE '%"+fil2s[4]+"%' OR fil2 LIKE '%"+fil2s[5]+"%' "; map.put("fil2", fil2);
				     fil2p = "&fil2=" + fil2s[0] + "&fil2=" + fil2s[1] + "&fil2=" + fil2s[2] + "&fil2=" + fil2s[3] + "&fil2=" + fil2s[4] + "&fil2=" + fil2s[5]; }
		    }
		    
		    //3번필터
		    
		    if(fil3s == null || fil3s[0] == "") {fil3 = "fil3 LIKE '%%' OR fil3 IS null"; map.put("fil3", fil3); fil3p = "&fil3=";}
		    if(fil3s != null && fil3s[0] != "") {
				    if(fil3s.length == 1) 
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%'"; map.put("fil3", fil3); 
				    fil3p = "&fil3=" + fil3s[0];}
				    
				    if(fil3s.length == 2)
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%' OR fil3 LIKE '%"+fil3s[1]+"%'"; map.put("fil3", fil3); 
				    fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1];}
				    
				    if(fil3s.length == 3) 
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%' OR fil3 LIKE '%"+fil3s[1]+"%' OR fil3 LIKE '%"+fil3s[2]+"%'"; map.put("fil3", fil3); 
				    fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2];}
				    
				    if(fil3s.length == 4) 
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%' OR fil3 LIKE '%"+fil3s[1]+"%' OR fil3 LIKE '%"+fil3s[2]+"%' OR fil3 LIKE '%"+fil3s[3]+"%'"; map.put("fil3", fil3); 
				    fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3];}
				    
				    if(fil3s.length == 5) 
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%' OR fil3 LIKE '%"+fil3s[1]+"%' OR fil3 LIKE '%"+fil3s[2]+"%' OR fil3 LIKE '%"+fil3s[3]+"%' OR fil3 LIKE '%"+fil3s[4]+"%' "; map.put("fil3", fil3); 
				    fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3] + "&fil3=" + fil3s[4]; }
				    
				    if(fil3s.length == 6) 
				    {fil3 = "fil3 LIKE '%"+fil3s[0]+"%' OR fil3 LIKE '%"+fil3s[1]+"%' OR fil3 LIKE '%"+fil3s[2]+"%' OR fil3 LIKE '%"+fil3s[3]+"%' OR fil3 LIKE '%"+fil3s[4]+"%' OR fil3 LIKE '%"+fil3s[5]+"%' "; map.put("fil3", fil3);
				     fil3p = "&fil3=" + fil3s[0] + "&fil3=" + fil3s[1] + "&fil3=" + fil3s[2] + "&fil3=" + fil3s[3] + "&fil3=" + fil3s[4] + "&fil3=" + fil3s[5]; }
		    }
		    
		    //4번필터
		    
		    if(fil4s == null || fil4s[0] == "") {fil4 = "fil4 LIKE '%%' OR fil4 IS null"; map.put("fil4", fil4); fil4p = "&fil4=";}
		    if(fil4s != null && fil4s[0] != "") {
				    if(fil4s.length == 1) 
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%'"; map.put("fil4", fil4); 
				    fil4p = "&fil4=" + fil4s[0];}
				    
				    if(fil4s.length == 2)
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%' OR fil4 LIKE '%"+fil4s[1]+"%'"; map.put("fil4", fil4); 
				    fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1];}
				    
				    if(fil4s.length == 3) 
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%' OR fil4 LIKE '%"+fil4s[1]+"%' OR fil4 LIKE '%"+fil4s[2]+"%'"; map.put("fil4", fil4); 
				    fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2];}
				    
				    if(fil4s.length == 4) 
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%' OR fil4 LIKE '%"+fil4s[1]+"%' OR fil4 LIKE '%"+fil4s[2]+"%' OR fil4 LIKE '%"+fil4s[3]+"%'"; map.put("fil4", fil4); 
				    fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3];}
				    
				    if(fil4s.length == 5) 
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%' OR fil4 LIKE '%"+fil4s[1]+"%' OR fil4 LIKE '%"+fil4s[2]+"%' OR fil4 LIKE '%"+fil4s[3]+"%' OR fil4 LIKE '%"+fil4s[4]+"%' "; map.put("fil4", fil4); 
				    fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3] + "&fil4=" + fil4s[4]; }
				    
				    if(fil4s.length == 6) 
				    {fil4 = "fil4 LIKE '%"+fil4s[0]+"%' OR fil4 LIKE '%"+fil4s[1]+"%' OR fil4 LIKE '%"+fil4s[2]+"%' OR fil4 LIKE '%"+fil4s[3]+"%' OR fil4 LIKE '%"+fil4s[4]+"%' OR fil4 LIKE '%"+fil4s[5]+"%' "; map.put("fil4", fil4);
				     fil4p = "&fil4=" + fil4s[0] + "&fil4=" + fil4s[1] + "&fil4=" + fil4s[2] + "&fil4=" + fil4s[3] + "&fil4=" + fil4s[4] + "&fil4=" + fil4s[5]; }
		    }
		    
		    
		    //5번필터
		    
		    if(fil5s == null || fil5s[0] == "") {fil5 = "fil5 LIKE '%%' OR fil5 IS null"; map.put("fil5", fil5); fil5p = "&fil5=";}
		    if(fil5s != null && fil5s[0] != "") {
				    if(fil5s.length == 1) 
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%'"; map.put("fil5", fil5); 
				    fil5p = "&fil5=" + fil5s[0];}
				    
				    if(fil5s.length == 2)
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%' OR fil5 LIKE '%"+fil5s[1]+"%'"; map.put("fil5", fil5); 
				    fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1];}
				    
				    if(fil5s.length == 3) 
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%' OR fil5 LIKE '%"+fil5s[1]+"%' OR fil5 LIKE '%"+fil5s[2]+"%'"; map.put("fil5", fil5); 
				    fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2];}
				    
				    if(fil5s.length == 4) 
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%' OR fil5 LIKE '%"+fil5s[1]+"%' OR fil5 LIKE '%"+fil5s[2]+"%' OR fil5 LIKE '%"+fil5s[3]+"%'"; map.put("fil5", fil5); 
				    fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3];}
				    
				    if(fil5s.length == 5) 
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%' OR fil5 LIKE '%"+fil5s[1]+"%' OR fil5 LIKE '%"+fil5s[2]+"%' OR fil5 LIKE '%"+fil5s[3]+"%' OR fil5 LIKE '%"+fil5s[4]+"%' "; map.put("fil5", fil5); 
				    fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3] + "&fil5=" + fil5s[4]; }
				    
				    if(fil5s.length == 6) 
				    {fil5 = "fil5 LIKE '%"+fil5s[0]+"%' OR fil5 LIKE '%"+fil5s[1]+"%' OR fil5 LIKE '%"+fil5s[2]+"%' OR fil5 LIKE '%"+fil5s[3]+"%' OR fil5 LIKE '%"+fil5s[4]+"%' OR fil5 LIKE '%"+fil5s[5]+"%' "; map.put("fil5", fil5);
				     fil5p = "&fil5=" + fil5s[0] + "&fil5=" + fil5s[1] + "&fil5=" + fil5s[2] + "&fil5=" + fil5s[3] + "&fil5=" + fil5s[4] + "&fil5=" + fil5s[5]; }
		    }
		    
		    //6번필터
		    if(fil6s == null || fil6s[0] == "") {fil6 = "fil6 LIKE '%%' OR fil6 IS null"; map.put("fil6", fil6); fil6p = "&fil6=";}
		    if(fil6s != null && fil6s[0] != "") {
				    if(fil6s.length == 1) 
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%'"; map.put("fil6", fil6); 
				    fil6p = "&fil6=" + fil6s[0];}
				    
				    if(fil6s.length == 2)
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%' OR fil6 LIKE '%"+fil6s[1]+"%'"; map.put("fil6", fil6); 
				    fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1];}
				    
				    if(fil6s.length == 3) 
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%' OR fil6 LIKE '%"+fil6s[1]+"%' OR fil6 LIKE '%"+fil6s[2]+"%'"; map.put("fil6", fil6); 
				    fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2];}
				    
				    if(fil6s.length == 4) 
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%' OR fil6 LIKE '%"+fil6s[1]+"%' OR fil6 LIKE '%"+fil6s[2]+"%' OR fil6 LIKE '%"+fil6s[3]+"%'"; map.put("fil6", fil6); 
				    fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3];}
				    
				    if(fil6s.length == 5) 
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%' OR fil6 LIKE '%"+fil6s[1]+"%' OR fil6 LIKE '%"+fil6s[2]+"%' OR fil6 LIKE '%"+fil6s[3]+"%' OR fil6 LIKE '%"+fil6s[4]+"%' "; map.put("fil6", fil6); 
				    fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3] + "&fil6=" + fil6s[4]; }
				    
				    if(fil6s.length == 6) 
				    {fil6 = "fil6 LIKE '%"+fil6s[0]+"%' OR fil6 LIKE '%"+fil6s[1]+"%' OR fil6 LIKE '%"+fil6s[2]+"%' OR fil6 LIKE '%"+fil6s[3]+"%' OR fil6 LIKE '%"+fil6s[4]+"%' OR fil6 LIKE '%"+fil6s[5]+"%' "; map.put("fil6", fil6);
				     fil6p = "&fil6=" + fil6s[0] + "&fil6=" + fil6s[1] + "&fil6=" + fil6s[2] + "&fil6=" + fil6s[3] + "&fil6=" + fil6s[4] + "&fil6=" + fil6s[5]; }
		    }
		    
		  //7번필터
		    if(fil7s == null || fil7s[0] == "") {fil7 = "fil7 LIKE '%%' OR fil7 IS null "; map.put("fil7", fil7); fil7p = "&fil7=";}
		    String fil7a = "";
		    String fil7b = "";
		    String fil7ba = "";
		    String fil7bb = "";
		    String fil7bc = "";
		    String fil7c = "";
		    String fil7ca = "";
		    String fil7cb = "";
		    String fil7cc = "";
		    if(fil7s != null && fil7s[0] != "") {
		    if(fil7s.length == 1) { 
		    if(Arrays.asList(fil7s).contains("1")) {fil7a = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'"; fil7p = "&fil7=1";}
		    if(Arrays.asList(fil7s).contains("3")) {fil7a = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'"; fil7p = "&fil7=3";}
		    if(Arrays.asList(fil7s).contains("6")) {fil7a = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600"; fil7p = "&fil7=6";}
		    fil7 = fil7a; map.put("fil7", fil7); }
		    
		    if(fil7s.length == 2) { 
			    if(Arrays.asList(fil7s).contains("1")) {fil7ba = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'";}
			    if(Arrays.asList(fil7s).contains("3")) {fil7bb = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'";}
			    if(Arrays.asList(fil7s).contains("6")) {fil7bc = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600";}
			    if(fil7ba.equals("")){fil7b = fil7bb + " OR " + fil7bc; fil7p = "&fil7=3&fil7=6"; }
			    if(fil7bb.equals("")){fil7b = fil7ba + " OR " + fil7bc; fil7p = "&fil7=1&fil7=6"; }
			    if(fil7bc.equals("")){fil7b = fil7ba + " OR " + fil7bb; fil7p = "&fil7=1&fil7=3"; }
			    fil7 = fil7b; map.put("fil7", fil7); }
			    
			if(fil7s.length == 3) { 
				if(Arrays.asList(fil7s).contains("1")) {fil7ca = "fil7 like '1' OR fil7 like '102' OR fil7 like '2'";}
				if(Arrays.asList(fil7s).contains("3")) {fil7cb = "fil7 like '3' OR fil7 like '304' OR fil7 like '4'";}
				if(Arrays.asList(fil7s).contains("6")) {fil7cc = "fil7 >= 6 and fil7 <= 14 OR fil7 >= 600";}
				fil7c = fil7ca + " OR " + fil7cb + " OR " + fil7cc; fil7p = "&fil7=1&fil7=3&fil7=6"; 
				fil7 = fil7c; map.put("fil7", fil7); }
		    
		    }
		    
		    
		    //8번필터
		    if(fil8s == null || fil8s[0] == "") {fil8 = "fil8 LIKE '%%' OR fil8 IS null "; map.put("fil8", fil8); fil8p = "&fil8=";}
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
		    if(fil8s != null && fil8s[0] != "") {
		    if(fil8s.length == 1) { 
		    if(Arrays.asList(fil8s).contains("1000")) {fil8a = "fil8 <= 1000 "; fil8p = "&fil8=1000";}
		    if(Arrays.asList(fil8s).contains("1001")) {fil8a = "fil8 >= 1000 AND fil8 <= 2000"; fil8p = "&fil8=1001";}
		    if(Arrays.asList(fil8s).contains("2001")) {fil8a = "fil8 >= 2000 AND fil8 <= 3000"; fil8p = "&fil8=2001";}
		    if(Arrays.asList(fil8s).contains("3001")) {fil8a = "fil8 >= 3000 "; fil8p = "&fil8=3001";}
		    fil8 = fil8a; map.put("fil8", fil8); }
		    
		    if(fil8s.length == 2) { 
			    if(Arrays.asList(fil8s).contains("1000")) {fil8ba = "fil8 <= 1000 "; fil8p = "&fil8=1000";}
			    if(Arrays.asList(fil8s).contains("1001")) {fil8bb = "fil8 >= 1000 AND fil8 <= 2000"; fil8p = "&fil8=1001";}
			    if(Arrays.asList(fil8s).contains("2001")) {fil8bc = "fil8 >= 2000 AND fil8 <= 3000"; fil8p = "&fil8=2001";}
			    if(Arrays.asList(fil8s).contains("3001")) {fil8bd = "fil8 >= 3000 "; fil8p = "&fil8=3001";}
			    
			    if(fil8ba.equals("") && fil8bb.equals("") ){fil8b = fil8bc + " OR " + fil8bd; fil8p = "&fil8=2001&fil8=3001"; }
			    if(fil8ba.equals("") && fil8bc.equals("") ){fil8b = fil8bb + " OR " + fil8bd; fil8p = "&fil8=1001&fil8=3001"; }
			    if(fil8ba.equals("") && fil8bd.equals("") ){fil8b = fil8bb + " OR " + fil8bc; fil8p = "&fil8=1001&fil8=2001"; }
			    if(fil8bb.equals("") && fil8bc.equals("") ){fil8b = fil8ba + " OR " + fil8bd; fil8p = "&fil8=1000&fil8=3001"; }
			    if(fil8bb.equals("") && fil8bd.equals("") ){fil8b = fil8ba + " OR " + fil8bc; fil8p = "&fil8=1000&fil8=2001"; }
			    if(fil8bc.equals("") && fil8bd.equals("") ){fil8b = fil8ba + " OR " + fil8bb; fil8p = "&fil8=1000&fil8=1001"; }
			    fil8 = fil8b; map.put("fil8", fil8); }
			    
			if(fil8s.length == 3) { 
					if(Arrays.asList(fil8s).contains("1000")) {fil8ca = "fil8 <= 1000 "; fil8p = "&fil8=1000";}
				    if(Arrays.asList(fil8s).contains("1001")) {fil8cb = "fil8 >= 1000 AND fil8 <= 2000"; fil8p = "&fil8=1001";}
				    if(Arrays.asList(fil8s).contains("2001")) {fil8cc = "fil8 >= 2000 AND fil8 <= 3000"; fil8p = "&fil8=2001";}
				    if(Arrays.asList(fil8s).contains("3001")) {fil8cd = "fil8 >= 3000 "; fil8p = "&fil8=3001";}
				    
				    if(fil8ca.equals("")){fil8c = fil8cb + " OR " + fil8cc + " OR " + fil8cd; fil8p = "fil8=1001&fil8=2001&fil8=3001"; }
				    if(fil8cb.equals("")){fil8c = fil8ca + " OR " + fil8cc + " OR " + fil8cd; fil8p = "fil8=1000&fil8=2001&fil8=3001"; }
				    if(fil8cc.equals("")){fil8c = fil8ca + " OR " + fil8cb + " OR " + fil8cd; fil8p = "fil8=1000&fil8=1001&fil8=3001"; }
				    if(fil8cd.equals("")){fil8c = fil8ca + " OR " + fil8cb + " OR " + fil8cc; fil8p = "fil8=1000&fil8=1001&fil8=2001"; }
				    
				fil8 = fil8c; map.put("fil8", fil8); }
		    
		    
		    
		    if(fil8s.length == 4) { 
				if(Arrays.asList(fil8s).contains("1000")) {fil8da = "fil8 <= 1000 "; fil8p = "&fil8=1000";}
			    if(Arrays.asList(fil8s).contains("1001")) {fil8db = "fil8 >= 1000 AND fil8 <= 2000"; fil8p = "&fil8=1001";}
			    if(Arrays.asList(fil8s).contains("2001")) {fil8dc = "fil8 >= 2000 AND fil8 <= 3000"; fil8p = "&fil8=2001";}
			    if(Arrays.asList(fil8s).contains("3001")) {fil8dd = "fil8 >= 3000 "; fil8p = "&fil8=3001";}
			    
			    fil8d = fil8da + " OR " + fil8db + " OR " + fil8dc + " OR " + fil8dd; fil8p = "fil8=1000&fil8=1001&fil8=2001&fil8=3001"; 
			    fil8 = fil8d; map.put("fil8", fil8); 
	    
	    }
		    }
		    
		    //9번필터

		    if(fil9s == null || fil9s[0] == "") {fil9 = "fil9 LIKE '%%' OR fil9 IS null "; map.put("fil9", fil9); fil9p = "&fil9=";}
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
		   if(fil9s != null && fil9s[0] != "") {
		   if(fil9s.length == 1) { 
		   if(Arrays.asList(fil9s).contains("10")) {fil9a = "fil9 <= 10 "; fil9p = "&fil9=10";}
		   if(Arrays.asList(fil9s).contains("20")) {fil9a = "fil9 >= 10 AND fil9 <= 20"; fil9p = "&fil9=20";}
		   if(Arrays.asList(fil9s).contains("40")) {fil9a = "fil9 >= 20 AND fil9 <= 40"; fil9p = "&fil9=40";}
		   if(Arrays.asList(fil9s).contains("41")) {fil9a = "fil9 >= 40 "; fil9p = "&fil9=41";}
		   fil9 = fil9a; map.put("fil9", fil9); }

		   if(fil9s.length == 2) { 
			   if(Arrays.asList(fil9s).contains("10")) {fil9ba = "fil9 <= 10 "; fil9p = "&fil9=10";}
			   if(Arrays.asList(fil9s).contains("20")) {fil9bb = "fil9 >= 10 AND fil9 <= 20"; fil9p = "&fil9=20";}
			   if(Arrays.asList(fil9s).contains("40")) {fil9bc = "fil9 >= 20 AND fil9 <= 40"; fil9p = "&fil9=40";}
			   if(Arrays.asList(fil9s).contains("41")) {fil9bd = "fil9 >= 40 "; fil9p = "&fil9=41";}
		       
		       if(fil9ba.equals("") && fil9bb.equals("") ){fil9b = fil9bc + " OR " + fil9bd; fil9p = "&fil9=40&fil9=41"; }
		       if(fil9ba.equals("") && fil9bc.equals("") ){fil9b = fil9bb + " OR " + fil9bd; fil9p = "&fil9=20&fil9=41"; }
		       if(fil9ba.equals("") && fil9bd.equals("") ){fil9b = fil9bb + " OR " + fil9bc; fil9p = "&fil9=20&fil9=40"; }
		       if(fil9bb.equals("") && fil9bc.equals("") ){fil9b = fil9ba + " OR " + fil9bd; fil9p = "&fil9=10&fil9=41"; }
		       if(fil9bb.equals("") && fil9bd.equals("") ){fil9b = fil9ba + " OR " + fil9bc; fil9p = "&fil9=10&fil9=40"; }
		       if(fil9bc.equals("") && fil9bd.equals("") ){fil9b = fil9ba + " OR " + fil9bb; fil9p = "&fil9=10&fil9=20"; }
		       fil9 = fil9b; map.put("fil9", fil9); }
		       
		   if(fil9s.length == 3) { 
			   if(Arrays.asList(fil9s).contains("10")) {fil9ca = "fil9 <= 10 "; fil9p = "&fil9=10";}
			   if(Arrays.asList(fil9s).contains("20")) {fil9cb = "fil9 >= 10 AND fil9 <= 20"; fil9p = "&fil9=20";}
			   if(Arrays.asList(fil9s).contains("40")) {fil9cc = "fil9 >= 20 AND fil9 <= 40"; fil9p = "&fil9=40";}
			   if(Arrays.asList(fil9s).contains("41")) {fil9cd = "fil9 >= 40 "; fil9p = "&fil9=41";}
		   	    
		   	    if(fil9ca.equals("")){fil9c = fil9cb + " OR " + fil9cc + " OR " + fil9cd; fil9p = "fil9=20&fil9=40&fil9=41"; }
		   	    if(fil9cb.equals("")){fil9c = fil9ca + " OR " + fil9cc + " OR " + fil9cd; fil9p = "fil9=10&fil9=40&fil9=41"; }
		   	    if(fil9cc.equals("")){fil9c = fil9ca + " OR " + fil9cb + " OR " + fil9cd; fil9p = "fil9=10&fil9=20&fil9=41"; }
		   	    if(fil9cd.equals("")){fil9c = fil9ca + " OR " + fil9cb + " OR " + fil9cc; fil9p = "fil9=10&fil9=20&fil9=40"; }
		   	    
		   	fil9 = fil9c; map.put("fil9", fil9); }



		   if(fil9s.length == 4) { 
			   if(Arrays.asList(fil9s).contains("10")) {fil9da = "fil9 <= 10 "; fil9p = "&fil9=10";}
			   if(Arrays.asList(fil9s).contains("20")) {fil9db = "fil9 >= 10 AND fil9 <= 20"; fil9p = "&fil9=20";}
			   if(Arrays.asList(fil9s).contains("40")) {fil9dc = "fil9 >= 20 AND fil9 <= 40"; fil9p = "&fil9=40";}
			   if(Arrays.asList(fil9s).contains("41")) {fil9dd = "fil9 >= 40 "; fil9p = "&fil9=41";}
		       
		       fil9d = fil9da + " OR " + fil9db + " OR " + fil9dc + " OR " + fil9dd; fil9p = "fil9=10&fil9=20&fil9=40&fil9=41"; 
		       fil9 = fil9d; map.put("fil9", fil9); 

		   }
		   }
		   //10번필터
		   
		   if(fil10s == null || fil10s[0] == "") {fil10 = "fil10 LIKE '%%' OR fil10 IS null "; map.put("fil10", fil10); fil10p = "&fil10=";}
		    String fil10a = "";
		    String fil10b = "";
		    String fil10ba = "";
		    String fil10bb = "";
		    String fil10bc = "";
		    String fil10c = "";
		    String fil10ca = "";
		    String fil10cb = "";
		    String fil10cc = "";
		    if(fil10s != null && fil10s[0] != "") {
		    if(fil10s.length == 1) { 
		    if(Arrays.asList(fil10s).contains("1000")) {fil10a = "fil10 <= 1000 "; fil10p = "&fil10=1000";}
		    if(Arrays.asList(fil10s).contains("2000")) {fil10a = "fil10 >= 1000 and  fil10 <= 2000"; fil10p = "&fil10=2000";}
		    if(Arrays.asList(fil10s).contains("2001")) {fil10a = "fil10 >= 2000"; fil10p = "&fil10=2001";}
		    fil10 = fil10a; map.put("fil10", fil10); }
		    
		    if(fil10s.length == 2) { 
			    if(Arrays.asList(fil10s).contains("1000")) {fil10ba = "fil10 <= 1000 "; fil10p = "&fil10=1000";}                  
			    if(Arrays.asList(fil10s).contains("2000")) {fil10bb = "fil10 >= 1000 and  fil10 <= 2000"; fil10p = "&fil10=2000";}
			    if(Arrays.asList(fil10s).contains("2001")) {fil10bc = "fil10 >= 2000"; fil10p = "&fil10=2001";}                   
			    if(fil10ba.equals("")){fil10b = fil10bb + " OR " + fil10bc; fil10p = "&fil10=2000&fil10=2001"; }
			    if(fil10bb.equals("")){fil10b = fil10ba + " OR " + fil10bc; fil10p = "&fil10=1000&fil10=2001"; }
			    if(fil10bc.equals("")){fil10b = fil10ba + " OR " + fil10bb; fil10p = "&fil10=1000&fil10=2000"; }
			    fil10 = fil10b; map.put("fil10", fil10); }
			    
			if(fil10s.length == 3) { 
				if(Arrays.asList(fil10s).contains("1000")) {fil10ca = "fil10 <= 1000 "; fil10p = "&fil10=1000";}                  
				if(Arrays.asList(fil10s).contains("2000")) {fil10cb = "fil10 >= 1000 and  fil10 <= 2000"; fil10p = "&fil10=2000";}
				if(Arrays.asList(fil10s).contains("2001")) {fil10cc = "fil10 >= 2000"; fil10p = "&fil10=2001";}                   
				fil10c = fil10ca + " OR " + fil10cb + " OR " + fil10cc; fil10p = "&fil10=1000&fil10=2000&fil10=2001"; 
				fil10 = fil10c; map.put("fil10", fil10); }
		    
		    }

		    //11번필터
		    
		  

		    if(fil11s == null || fil11s[0] == "") {fil11 = "fil11 LIKE '%%' OR fil11 IS null "; map.put("fil11", fil11); fil11p = "&fil11=";}
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
		    		   if(fil11s != null && fil11s[0] != "") {
		    		   if(fil11s.length == 1) { 
		    		   if(Arrays.asList(fil11s).contains("-50")) {fil11a = "fil11 <= -50 and fil11 >= -69"; fil11p = "&fil11=-50";}
		    		   if(Arrays.asList(fil11s).contains("-30")) {fil11a = "fil11 >= -50 AND fil11 <= -30"; fil11p = "&fil11=-30";}
		    		   if(Arrays.asList(fil11s).contains("-10")) {fil11a = "fil11 >= -30 AND fil11 <= -10"; fil11p = "&fil11=-10";}
		    		   if(Arrays.asList(fil11s).contains("0")) {fil11a = "fil11 >= -10 "; fil11p = "&fil11=0";}
		    		   fil11 = fil11a; map.put("fil11", fil11); }

		    		   if(fil11s.length == 2) { 
		    			   if(Arrays.asList(fil11s).contains("-50")) {fil11ba = "fil11 <= -50 and fil11 >= -69"; fil11p = "&fil11=-50";}
		    			   if(Arrays.asList(fil11s).contains("-30")) {fil11bb = "fil11 >= -50 AND fil11 <= -30"; fil11p = "&fil11=-30";}
		    			   if(Arrays.asList(fil11s).contains("-10")) {fil11bc = "fil11 >= -30 AND fil11 <= -10"; fil11p = "&fil11=-10";}
		    			   if(Arrays.asList(fil11s).contains("0")) {fil11bd = "fil11 >= -10 "; fil11p = "&fil11=0";}
		    		       
		    		       if(fil11ba.equals("") && fil11bb.equals("") ){fil11b = fil11bc + " OR " + fil11bd; fil11p = "&fil11=-10&fil11=0"; }
		    		       if(fil11ba.equals("") && fil11bc.equals("") ){fil11b = fil11bb + " OR " + fil11bd; fil11p = "&fil11=-30&fil11=0"; }
		    		       if(fil11ba.equals("") && fil11bd.equals("") ){fil11b = fil11bb + " OR " + fil11bc; fil11p = "&fil11=-30&fil11=-10"; }
		    		       if(fil11bb.equals("") && fil11bc.equals("") ){fil11b = fil11ba + " OR " + fil11bd; fil11p = "&fil11=-50&fil11=0"; }
		    		       if(fil11bb.equals("") && fil11bd.equals("") ){fil11b = fil11ba + " OR " + fil11bc; fil11p = "&fil11=-50&fil11=-10"; }
		    		       if(fil11bc.equals("") && fil11bd.equals("") ){fil11b = fil11ba + " OR " + fil11bb; fil11p = "&fil11=-50&fil11=-30"; }
		    		       fil11 = fil11b; map.put("fil11", fil11); }
		    		       
		    		   if(fil11s.length == 3) { 
		    			   if(Arrays.asList(fil11s).contains("-50")) {fil11ca = "fil11 <= -50 and fil11 >= -69"; fil11p = "&fil11=-50";}
		    			   if(Arrays.asList(fil11s).contains("-30")) {fil11cb = "fil11 >= -50 AND fil11 <= -30"; fil11p = "&fil11=-30";}
		    			   if(Arrays.asList(fil11s).contains("-10")) {fil11cc = "fil11 >= -30 AND fil11 <= -10"; fil11p = "&fil11=-10";}
		    			   if(Arrays.asList(fil11s).contains("0")) {fil11cd = "fil11 >= -10 "; fil11p = "&fil11=0";}
		    		   	    
		    		   	    if(fil11ca.equals("")){fil11c = fil11cb + " OR " + fil11cc + " OR " + fil11cd; fil11p = "fil11=-30&fil11=-10&fil11=0"; }
		    		   	    if(fil11cb.equals("")){fil11c = fil11ca + " OR " + fil11cc + " OR " + fil11cd; fil11p = "fil11=-50&fil11=-10&fil11=0"; }
		    		   	    if(fil11cc.equals("")){fil11c = fil11ca + " OR " + fil11cb + " OR " + fil11cd; fil11p = "fil11=-50&fil11=-30&fil11=0"; }
		    		   	    if(fil11cd.equals("")){fil11c = fil11ca + " OR " + fil11cb + " OR " + fil11cc; fil11p = "fil11=-50&fil11=-30&fil11=-10"; }
		    		   	    
		    		   	fil11 = fil11c; map.put("fil11", fil11); }



		    		   if(fil11s.length == 4) { 
		    			   if(Arrays.asList(fil11s).contains("-50")) {fil11da = "fil11 <= -50 and fil11 >= -69"; fil11p = "&fil11=-50";}
		    			   if(Arrays.asList(fil11s).contains("-30")) {fil11db = "fil11 >= -50 AND fil11 <= -30"; fil11p = "&fil11=-30";}
		    			   if(Arrays.asList(fil11s).contains("-10")) {fil11dc = "fil11 >= -30 AND fil11 <= -10"; fil11p = "&fil11=-10";}
		    			   if(Arrays.asList(fil11s).contains("0")) {fil11dd = "fil11 >= -10 "; fil11p = "&fil11=0";}
		    		       
		    		       fil11d = fil11da + " OR " + fil11db + " OR " + fil11dc + " OR " + fil11dd; fil11p = "fil11=-50&fil11=-30&fil11=-10&fil11=0"; 
		    		       fil11 = fil11d; map.put("fil11", fil11); 

		    		   }
		    		   }
		    	//12번필터

		    		   


				if(fil12s == null || fil12s[0] == "") {fil12 = "fil12 LIKE '%%' OR fil12 IS null "; map.put("fil12", fil12); fil12p = "&fil12=";}
						    String fil12a = "";
						    String fil12b = "";
						    String fil12ba = "";
						    String fil12bb = "";
						    String fil12bc = "";
						    String fil12c = "";
						    String fil12ca = "";
						    String fil12cb = "";
						    String fil12cc = "";
						    if(fil12s != null && fil12s[0] != "") {
						    if(fil12s.length == 1) { 
						    if(Arrays.asList(fil12s).contains("100")) {fil12a = "fil12 <= 100 "; fil12p = "&fil12=100";}
						    if(Arrays.asList(fil12s).contains("120")) {fil12a = "fil12 >= 100 and  fil12 <= 120"; fil12p = "&fil12=120";}
						    if(Arrays.asList(fil12s).contains("121")) {fil12a = "fil12 >= 120"; fil12p = "&fil12=121";}
						    fil12 = fil12a; map.put("fil12", fil12); }
						    
						    if(fil12s.length == 2) { 
							    if(Arrays.asList(fil12s).contains("100")) {fil12ba = "fil12 <= 100 "; fil12p = "&fil12=100";}                  
							    if(Arrays.asList(fil12s).contains("120")) {fil12bb = "fil12 >= 100 and  fil12 <= 120"; fil12p = "&fil12=120";}
							    if(Arrays.asList(fil12s).contains("121")) {fil12bc = "fil12 >= 120"; fil12p = "&fil12=121";}                   
							    if(fil12ba.equals("")){fil12b = fil12bb + " OR " + fil12bc; fil12p = "&fil12=120&fil12=121"; }
							    if(fil12bb.equals("")){fil12b = fil12ba + " OR " + fil12bc; fil12p = "&fil12=100&fil12=121"; }
							    if(fil12bc.equals("")){fil12b = fil12ba + " OR " + fil12bb; fil12p = "&fil12=100&fil12=120"; }
							    fil12 = fil12b; map.put("fil12", fil12); }
							    
							if(fil12s.length == 3) { 
								if(Arrays.asList(fil12s).contains("100")) {fil12ca = "fil12 <= 100 "; fil12p = "&fil12=100";}                  
								if(Arrays.asList(fil12s).contains("120")) {fil12cb = "fil12 >= 100 and  fil12 <= 120"; fil12p = "&fil12=120";}
								if(Arrays.asList(fil12s).contains("121")) {fil12cc = "fil12 >= 120"; fil12p = "&fil12=121";}                   
								fil12c = fil12ca + " OR " + fil12cb + " OR " + fil12cc; fil12p = "&fil12=100&fil12=120&fil12=121"; 
								fil12 = fil12c; map.put("fil12", fil12); }
						    
						    }
						    
		    String filpara = brandp + fil1p + fil2p + fil3p + fil4p + fil5p + fil6p + fil7p + fil8p + fil9p + fil10p + fil11p + fil12p ;
	    
	    
	    
		

		
		count = service.getEquipCount(map);
		
		
		
		
		
		List<EquipDTO> EquipList = service.getEquipList(map);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("EquipList", EquipList);
		model.addAttribute("category", category);
		model.addAttribute("filpara", filpara);
		
		

		return "equip/equipList";
	}

}
