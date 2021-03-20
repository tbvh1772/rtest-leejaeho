package com.rtest.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.rtest.domain.CommunityVO;
import com.rtest.domain.Criteria;
import com.rtest.domain.UserVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UnitMapperTests {
	@Setter(onMethod_ = @Autowired)
	private CommunityMapper mapper;
	
	@Setter(onMethod_ = @Autowired )
	private UserMapper usermapper;
	
	/* 페이징 게시글 목록 */
	@Test
	public void testPaging() {
		log.info("========== 페이징 게시글 목록(List) ==========");
		Criteria cri = new Criteria();
		cri.setPageNum(1);
		cri.setAmount(10);

		List<CommunityVO> list = mapper.getList(cri);

		list.forEach(community -> log.info(community));
	}
	
	/* 글작성 */
	@Test
	public void testWrite() {
		log.info("========== 글작성(Wrtie) ==========");
		CommunityVO vo = new CommunityVO();
		vo.setPost_title("테스트로 작성하는 제목");
		vo.setUser_id("lee1");
		vo.setPost_content("테스트로 작성하는 내용");
		vo.setFileName("첨부파일");
		mapper.insertPost(vo);
		log.info(vo);
	}
	
	/* 글상세보기 */
	@Test
	public void testView() {
		log.info("========== 글상세보기(View) ==========");
		mapper.getView(5);
		
	}

	/* 글수정 */
	@Test
	public void testUpdate() {
		log.info("========== 글수정(Update) ==========");
		CommunityVO vo = new CommunityVO();
		vo.setPost_no(3);
		vo.setPost_title("단위테스트로 수정한 제목 입니다.");
		vo.setPost_content("단위테스트로 수정한 내용 입니다.");
		mapper.updateView(vo);
		mapper.getView(3);
	}
	
	/* 글삭제 */
	@Test
	public void testDelete() {
		log.info("========== 글삭제(Delete) ==========");
		mapper.delete(6);
	}
	
	/* 로그인 */
	@Test
	public void testLogin() {
		log.info("========== 로그인(Login) ==========");
		UserVO vo = new UserVO();
		vo.setUser_id("lee1");
		vo.setUser_passwd("lee1");
		usermapper.login(vo);
	}
	
	
	
	
	
}

