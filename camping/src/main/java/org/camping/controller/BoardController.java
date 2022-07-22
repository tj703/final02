package org.camping.controller;

import org.camping.service.BoardService;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.camping.model.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/board/*")
public class BoardController {
   
   @Autowired
   private BoardService service;
   
   // �� ���� ��
   @RequestMapping("writeForm")
   public String writeForm(BoardDTO dto) {
      
      return "/board/writeForm";
   }
   
   // �� ���� ����
   @RequestMapping("writePro")
   public String writePro(BoardDTO dto, MultipartFile mf, MultipartHttpServletRequest request) throws Exception  {
      
      // ���� ���ε�
      mf = request.getFile("img");   // ���ε� �Ķ����
      String path = request.getRealPath("resources/img");   
      String fileName = mf.getOriginalFilename();      // ���ε� ���� �̸�
      File upload = new File(path+"//"+fileName);
      mf.transferTo(upload);
      
      dto.setImage(fileName);
      
      service.insertBoard(dto);
      
      return "/board/writePro";
   }
   
   // �� ���� ��
   @RequestMapping("sgWriteForm")
   public String sgWriteForm(BoardDTO dto) {
         
      return "/board/sgWriteForm";
   }
      
   // �� ���� ����
   @RequestMapping("sgWritePro")
   public String sgWritePro(BoardDTO dto, MultipartFile mf, MultipartHttpServletRequest request) throws Exception  {
         
      // ���� ���ε�
      mf = request.getFile("img");   // ���ε� �Ķ����
      String path = request.getRealPath("resources/img");   
      String fileName = mf.getOriginalFilename();      // ���ε� ���� �̸�
      File upload = new File(path+"//"+fileName);
      mf.transferTo(upload);
         
      dto.setImage(fileName);
         
      service.insertBoard(dto);
         
      return "/board/writePro";
   }
   
   // �� ����
   @RequestMapping("content")
   public String content(int boardnum , String pageNum , Model model) {
      
      model.addAttribute("board", service.getBoard(boardnum));
      model.addAttribute("pageNum",pageNum);
      
      return "/board/content";
   }
   
    
   // �� ���� ��
   @RequestMapping("updateForm")
   public String updateForm(int boardnum, String pageNum, Model model, HttpSession session) {
      
      String memId = (String)session.getAttribute("memId");
      model.addAttribute("board",service.getBoard(boardnum));
      model.addAttribute("pageNum",pageNum);         
      
      return "/board/updateForm";
   }
      
   // �� ���� ����
   @RequestMapping("updatePro")
   public String updatePro(BoardDTO dto, String pageNum , Model model, HttpSession session) {
         
      String memId = (String)session.getAttribute("memId");
      model.addAttribute("pageNum",pageNum);   
      model.addAttribute("result",service.updateBoard(dto));
      
      return "/board/updatePro";
   }
   
   // �� ���� ��
   @RequestMapping("deleteForm")
   public String deleteForm(int boardnum, String pageNum , String writer, Model model) {
      
      model.addAttribute("pageNum",pageNum);   
      model.addAttribute("boardnum",boardnum);
      model.addAttribute("writer",writer);
      
      return "/board/deleteForm";
   }
   
   // �� ���� ����
   @RequestMapping("deletePro")
   public String deletePro(String pageNum , Model model, BoardDTO dto) {
      System.out.println(pageNum);
   
      int result = service.delete(dto);      
      if(result == 1) {
         service.deleteBoard(dto);
      }
      model.addAttribute("pageNum",pageNum);
      model.addAttribute("result",result);
      
      return "/board/deletePro";
   }

   // ���ǻ��� �� ���� ��
   @RequestMapping("sgDeleteForm")
   public String sgDeleteForm(int boardnum, String pageNum , Model model) {
      
      model.addAttribute("pageNum",pageNum);   
      model.addAttribute("boardnum",boardnum);
      
      return "/board/sgDeleteForm";
   }
      
   // ���ǻ��� �� ���� ����
   @RequestMapping("sgDeletePro")
   public String sgDeletePro(String pageNum , Model model, BoardDTO dto) {
      System.out.println(pageNum);
   
      int result = service.sgDelete(dto);      
      if(result == 1) {
         service.sgDeleteBoard(dto);
      }
      model.addAttribute("pageNum",pageNum);
      model.addAttribute("result",result);
      
      return "/board/sgDeletePro";
   }   

   // �� ���
   @RequestMapping("list") 
   public String list (String pageNum, Model model) {
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.getBoardCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.getBoards(startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/list"; 
   }
   
   // ķ���� �ı� �� ���
   @RequestMapping("campspot") 
   public String campspot (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/campspot"; 
   }
   
   // ��� �ı� �� ���
   @RequestMapping("equipment") 
   public String equipment (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount(category);
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/equipment"; 
   }
   
   // ķ�� �丮 �� ���
   @RequestMapping("recipe") 
   public String recipe (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/recipe"; 
   }
   
   // ���� �� ���
   @RequestMapping("question") 
   public String question (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/question"; 
   }

   // �� �� ���
   @RequestMapping("tip") 
   public String tip (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/tip"; 
   }
   
   // ���ǻ��� �� ���
   @RequestMapping("suggestion") 
   public String suggestion (int category, String pageNum, Model model) {
      
      if(pageNum == null) pageNum ="1";
         int pageSize = 10;
         int currentPage = Integer.parseInt(pageNum);
         int startRow = (currentPage - 1) * pageSize +1;
         int endRow = currentPage * pageSize;
         int count = 0;
         int number = 0;
      count = service.categoryCheckCount();
      List<BoardDTO> boardList = null;
      
      if(count > 0) {
         boardList = service.categoryCheck(category, startRow, endRow);
      }
      number = count - (currentPage-1) * pageSize;
       
         model.addAttribute("pageNum", pageNum);
         model.addAttribute("pageSize", pageSize);
         model.addAttribute("currentPage", currentPage);
         model.addAttribute("startRow", startRow);
         model.addAttribute("endRow", endRow);
         model.addAttribute("count", count);
         model.addAttribute("boardList", boardList);
         model.addAttribute("number", number);
          
      return "/board/suggestion"; 
   }
   
}