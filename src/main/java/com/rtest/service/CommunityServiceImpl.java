package com.rtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtest.controller.UserController;
import com.rtest.domain.CommunityVO;
import com.rtest.domain.Criteria;
import com.rtest.domain.UserVO;
import com.rtest.mapper.CommunityMapper;
import com.rtest.mapper.UserMapper;


@Service
public class CommunityServiceImpl implements CommunityService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private CommunityMapper communityMapper;
	
	
	@Override
	public List<CommunityVO> getList(Criteria cri) {
		logger.info("getList community service");
		return communityMapper.getList(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		logger.info("getTotal community service");
		return communityMapper.getTotal();
	}

	@Override
	public void insertPost(CommunityVO communityVo) {
		logger.info("CC" + communityVo.getPost_title());
		communityMapper.insertPost(communityVo);
		
	}

	@Override
	public CommunityVO getView(int post_no) {
		logger.info("getView community service");
		return communityMapper.getView(post_no);
	}

	@Override
	public void updateView(CommunityVO communityVo) {
		logger.info("updateView community service");
		communityMapper.updateView(communityVo);
		
	}

	@Override
	public void delete(int post_no) {
		logger.info("delete community service");
		communityMapper.delete(post_no);
		
	}
	
	


	
	}
	


