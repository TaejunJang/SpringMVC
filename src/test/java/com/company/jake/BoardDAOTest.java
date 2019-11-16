package com.company.jake;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.domain.BoardVO;
import com.company.persistencce.BoardDAO;
import com.company.persistencce.BoardDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {

	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	/*@Test
	public void testCreate()throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글");
		board.setContent("새로운 내용");
		board.setWriter("작가");
		dao.create(board);
	}
	
	@Test
	public void testRead()throws Exception{
		logger.info(dao.read(2).toString());
		
	}
	
	@Test
	public void testUpdate()throws Exception{
		
		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle(" 수정새로운 글");
		board.setContent("수정새로운 내용");
		dao.update(board);
		
	}
	
	@Test
	public void testDelete()throws Exception{
		dao.delete(1);
		
	}*/
	
	@Test
	public void testURI()throws Exception{
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read/")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
	}
	
}
