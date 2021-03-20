package com.rtest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
									"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		})
@Log4j
public class UnitControllerTests  {

	@Autowired
	WebApplicationContext wac;
	

	private MockMvc mockMvc;
	
	@Before

	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	/* 로그인 */
	@Test
	public void testLogin() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/login")
				.param("user_id", "lee1")
				.param("user_passwd","lee1"))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	/* 페이징 게시글 목록 */
	@Test
	public void testListPaging() throws Exception{
		log.info("========== 페이징 게시글 목록(List) ==========");
		log.info(
					mockMvc.perform(MockMvcRequestBuilders.get("/community/list")
					.param("pageNum" , "2")
					.param("amount","10"))
					.andReturn().getModelAndView().getModelMap());
	}
	
	/* 글작성 */
	@Test
	public void testWrite() throws Exception{
		log.info("========== 글작성(Wrtie) ==========");
		
		String resultPage= mockMvc.perform(MockMvcRequestBuilders.get("/community/write")
				
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	/* 글상세보기 */
	@Test
	public void testView() throws Exception{
		log.info("========== 글조회(View) ==========");
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/community/view")
				.param("post_no", "2"))
				.andReturn()
				.getModelAndView().getModelMap());
				
	}
	
	/* 글수정 */
	@Test
	public void testUpdate() throws Exception{
		log.info("========== 글수정(Update) ==========");
		
		String resultPage= mockMvc.perform(MockMvcRequestBuilders.get("/community/update")
				
				).andReturn().getModelAndView().getViewName();
		
		log.info(resultPage);
	}
	
	/* 글삭제보기 */
	@Test
	public void testDelete() throws Exception{
		log.info("========== 글삭제(Delete) ==========");
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/community/delete")
				.param("post_no", "10"))
				.andReturn()
				.getModelAndView().getModelMap());
				
	}
	
		
	}
	


	
	

