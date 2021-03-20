package com.rtest.controller;



import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.multipart.MultipartFile;

import com.rtest.domain.PageVO;

import com.rtest.domain.CommunityVO;
import com.rtest.domain.Criteria;
import com.rtest.service.CommunityService;


@Controller
@RequestMapping("/community")
public class CommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);
	
	@Autowired
	CommunityService communityService;
	
	@Resource(name="uploadPath")
	   private String uploadPath;
	
	/* 글목록 */
	@GetMapping(value="/list")
	public void getList(Criteria cri,Model model) {
		logger.info("getList Controller 호출"+ cri);
		
		model.addAttribute("list",communityService.getList(cri));
		
		int total = communityService.getTotal(cri);
		model.addAttribute("pageMaker", new PageVO(cri,total));
		
	}
	
	/* 글작성 */
	@GetMapping(value="/write")
	public void getWrite(HttpSession session , Model model) {
		String user_id = (String) session.getAttribute("userId");
		model.addAttribute("user_id",user_id);
	}
	
	/* 글작성처리 */
	@PostMapping(value="/write")
	public String postWrite(CommunityVO communityVo ,MultipartFile[] file) throws Exception{
		logger.info("postwrite controller ");
		logger.info(communityVo.getPost_title());
		
		String fileName=null;
		MultipartFile uploadFile = communityVo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);	//확장자 구하기
			UUID uuid = UUID.randomUUID();	//UUID 구하기
			fileName=uuid+"."+ext;
			uploadFile.transferTo(new File("D:\\upload\\" + fileName));
		}
		communityVo.setFileName(fileName);
		communityService.insertPost(communityVo);
		return "redirect:/community/list";
	}
	
	/* 글상세보기 */
	@GetMapping(value="/view")
	public void getView(Model model,CommunityVO communityVo) throws Exception {
		logger.info("getView controller");
		model.addAttribute("view",communityService.getView(communityVo.getPost_no()));
		
	}
	
	/* 글수정 */
	@GetMapping(value= "/update")
	public void getUpdate(CommunityVO communityVo,Model model) throws Exception {
		logger.info("getUpdate Controller"+communityVo.getPost_no());
		model.addAttribute("view",communityService.getView(communityVo.getPost_no()));
				
	}
	
	/* 글수정처리 */
	@PostMapping(value="/update")
	public String postUpdate(CommunityVO communityVo) {
		logger.info("postUpdate Controller"+communityVo.getPost_no());
		communityService.updateView(communityVo);
		return "redirect:/community/view?post_no=" + communityVo.getPost_no();
	}
	
	/* 글삭제 */
	@GetMapping(value="/delete")
	public String getDelete(CommunityVO communityVO) {
		logger.info("getDelete controller"+communityVO.getPost_no());
		communityService.delete(communityVO.getPost_no());
		return "redirect:/community/list";
	}
	
		
	
}
