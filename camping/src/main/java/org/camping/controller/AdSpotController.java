package org.camping.controller;

import java.util.List;

import org.camping.model.SpotDTO;
import org.camping.service.AdSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/adSpot/*")
public class AdSpotController {

	@Autowired
	private AdSpotService service;
	
	
	@RequestMapping("list")
	public String list(Model model, String pageNum) {
		// ������������ �����ִ� ķ���� ��
		if(pageNum == null) pageNum = "1";
		int pageSize = 50;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize+1 ;
		int endRow = (currentPage) * pageSize ;
		// ����¡ ó���� �ʿ��� ����
		int count = 0;
		count = service.getSpotCount();
		List<SpotDTO> list = null;
		int pageCount = 0;
		int pageBlock = 10;
		int startPage = 0;
		int endPage = 0;
		if(count >0) {
			list = service.getSpotList(startRow, endRow);
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
		return "adSpot/list";
	}
	
	@RequestMapping("insert")
	public String InsertForm() {
		return "adSpot/insertForm";
	}
	
	@RequestMapping("insertpro")
	public String InsertPro(Model model, SpotDTO dto) {
		service.addSpot(dto);
		return "adSpot/list";
	}
	
	@RequestMapping("modify")
	public String ModifyForm() {
		return "adSpot/modifyForm";
	}
	
	@RequestMapping("modifyPro")
	public String ModifyPro() {
		return "adSpot/modifyPro";
	}
	
	@RequestMapping("delete")
	public String DeletePro() {
		return "adSpot/deletePro";
	}
	
}
