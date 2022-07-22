package org.camping.controller;

import java.util.Arrays;
import java.util.List;

import org.camping.model.ChecklistDTO;
import org.camping.model.SpotDTO;
import org.camping.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prod/*")
public class ProdController {

	@Autowired
	private ProdService service;
	// ���� ��������� üũ����Ʈ ����
	@RequestMapping("check")
	public String Check(String id, Model model) {
		int result = 0;
		result = service.checkId(id);
		model.addAttribute("result", result);
		return "prod/check1";
	}
	// �����õ
	@RequestMapping("checklist")
	public String Checklist(Model model, String sitename, String person, String season, int price, String[] equipments, int sitenum) {
		int spotResult = 0;
		// �����Ǹ����� Ȯ���ϴ� �ż���
		spotResult = service.checkFuel(sitename);
		model.addAttribute("spotResult", spotResult);
		// ��õ�ϴ� ���� ǰ��
		model.addAttribute("fuel1", service.recommendFuel1());
		model.addAttribute("fuel2", service.recommendFuel2());
		
		// ��Ʈ ħ�� 
		model.addAttribute("mat",service.recomMat(price));
		// ���� ���
		model.addAttribute("chair",service.recomChair(price));
		// ���� ���
		model.addAttribute("light",service.recomLight(price));
		// ���̺� ���
		model.addAttribute("desk",service.recomTB(price));
		if(person.equals("1")) {
			// ��Ʈ ���
			model.addAttribute("tent", service.recomTent1(price));
			// ���̽��ڽ� ���
			model.addAttribute("waterjug",service.recomWJ1(price));
			// ����� ���(1��)
			model.addAttribute("stove",service.recomStove1(price));
		}else if (person.equals("2")) {
			// ��Ʈ ���
			model.addAttribute("tent", service.recomTent2(price));
			// ���̽��ڽ� ���
			model.addAttribute("waterjug",service.recomWJ2(price));
			// ����� ���(2��)
			model.addAttribute("stove",service.recomStove2(price));
		}else {
			// ��Ʈ ���
			model.addAttribute("tent", service.recomTent3(price));
			// ���̽��ڽ� ���
			model.addAttribute("waterjug",service.recomWJ3(price));
			// ����� ���(2��)
			model.addAttribute("stove",service.recomStove2(price));
		}
		
		if(season.equals("1")) {
			// ħ�� ���
			model.addAttribute("sb", service.recomSB1(price));
			// Ÿ�� ���
			model.addAttribute("taf",service.recomTaf(price));
		}else if (season.equals("2")) {
			// ħ�� ���
			model.addAttribute("sb", service.recomSB2(price));
			// Ÿ�� ���
			model.addAttribute("taf",service.recomTaf(price));
		}else {
			// ħ�� ���
			model.addAttribute("sb", service.recomSB3(price));
			
		}
		model.addAttribute("tentCheck", Arrays.asList(equipments).contains("1"));
		model.addAttribute("tafCheck", Arrays.asList(equipments).contains("2"));
		model.addAttribute("waterCheck", Arrays.asList(equipments).contains("3"));
		model.addAttribute("stoveCheck", Arrays.asList(equipments).contains("4"));
		model.addAttribute("lightCheck", Arrays.asList(equipments).contains("5"));
		model.addAttribute("matCheck", Arrays.asList(equipments).contains("6"));
		model.addAttribute("sbCheck", Arrays.asList(equipments).contains("7"));
		model.addAttribute("chairCheck", Arrays.asList(equipments).contains("8"));
		model.addAttribute("tableCheck", Arrays.asList(equipments).contains("9"));
		model.addAttribute("person",person);
		model.addAttribute("season",season);
		model.addAttribute("price",price);
		model.addAttribute("equipments",equipments);
		model.addAttribute("sitenum",sitenum);
		return "prod/check2";
	}
	// ���� üũ����Ʈ
	@RequestMapping("checkdetail")
	public String CheckDetail(ChecklistDTO dto, Model model) {
		if(service.checkStatus(dto)==1) {
			dto.setStatus(2);
			if(service.checkStatus(dto)==1) {
				dto.setStatus(3);
			}
		}
		int result = 0;
		result = service.saveChecklist(dto); 
		return "prod/check3";
	}
	// ķ���� �˻�
	@RequestMapping("searchSpot")
	public String SearchSpot(Model model, String pageNum, String spot) {
		// �� ȭ�鿡 ��Ÿ�� ķ���� �� 
		if(pageNum == null) pageNum = "1";
		int pageSize = 6;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		int count = 0;
		if(spot != null) {
			count = service.getCountKey(spot);	
		}
		// ����¡ ó���� ���� ������
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getSearchKey(spot, startRow, endRow);
			pageCount = count / pageSize + (count%pageSize ==0 ? 0 : 1);
			startPage = (int)((currentPage / pageBlock)*pageBlock +1);
			endPage = startPage + pageBlock - 1;
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		model.addAttribute("searchKey", spot);
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
		return "prod/searchSpot";
	}
}
