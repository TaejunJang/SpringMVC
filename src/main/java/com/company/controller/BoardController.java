package com.company.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BoardVO;
import com.company.domain.Criteria;
import com.company.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject 
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(BoardVO board, Model model)throws Exception{
		logger.info("register get.....");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registPOST(BoardVO board, Model model, RedirectAttributes rttr)throws Exception{
		
		logger.info("register post.....");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		//model.addAttribute("result","text");
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public String listAll(Model model)throws Exception{
		logger.info("show all list......");
		
		model.addAttribute("list", service.listAll());		
		return "/board/listAll";
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno ,Model model,@ModelAttribute("cri") Criteria cri)throws Exception{
		logger.info("read data......");
		
		model.addAttribute(service.read(bno));		
	}
	
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno ,RedirectAttributes rttr,Model model)throws Exception{
		logger.info("read data......");
	    int result =0;
		service.remove(bno);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	

	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno ,RedirectAttributes rttr,Model model)throws Exception{
		model.addAttribute("boardVO", service.read(bno));
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO board ,@RequestParam("bno") int bno ,RedirectAttributes rttr,Model model)throws Exception{
		 logger.info("mod post........");
		 try {
			 service.modify(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri, Model model)throws Exception{
		logger.info("show list page with Crieteria");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="listPage",method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model )throws Exception{
		logger.info(cri.toString());
		
		model.addAttribute("list",service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@ResponseBody
	@RequestMapping(value="ajax.do",method=RequestMethod.POST)
	public int ajaxTest(HttpServletRequest request, HttpServletResponse response , Model model)throws Exception{
		String  a= "a";
		String b="b";
		return 1;
		
	}
}
