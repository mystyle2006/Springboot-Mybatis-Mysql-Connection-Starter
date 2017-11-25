package com.restful.studentservices;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.restful.application.BoardServicesApplication;
import com.restful.domain.BoardVO;
import com.restful.mapper.BoardMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BoardServicesApplication.class)
public class BoardServicesApplicationTests {

	@Autowired
	private SqlSessionFactory sqlSession;
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testConnection() throws Exception {
		System.out.println("sqlSession" + sqlSession);
		System.out.println(mapper);
		ArrayList<BoardVO> bvos = mapper.boardSelect();
		
		for(int i=0;i<bvos.size();i++){
			System.out.println(bvos.get(i).toString());
		}
	}
}
