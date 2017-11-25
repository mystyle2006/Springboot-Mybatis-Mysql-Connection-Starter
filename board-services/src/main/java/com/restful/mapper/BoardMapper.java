package com.restful.mapper;

import java.util.ArrayList;

import com.restful.domain.BoardVO;

public interface BoardMapper {

	public ArrayList<BoardVO> boardSelect() throws Exception;
	
}
