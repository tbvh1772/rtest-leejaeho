package com.rtest.mapper;

import java.util.List;

import com.rtest.domain.CommunityVO;
import com.rtest.domain.Criteria;;

public interface CommunityMapper {
	
	public List<CommunityVO> getList(Criteria cri);
	
	public int getTotal();
	
	public void insertPost (CommunityVO communityVo);
	
	public CommunityVO getView(int post_no);
	
	public void updateView(CommunityVO communityVo);
	
	public void delete(int post_no);

}
