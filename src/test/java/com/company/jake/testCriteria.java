package com.company.jake;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.BoardVO;
import com.company.domain.Criteria;
import com.company.persistencce.BoardDAO;
import com.company.persistencce.BoardDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class testCriteria {

	private static Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject
	BoardDAO dao;
	
	@Test
	public void testCriteria()throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		List<BoardVO> list = dao.listCriteria(cri);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			logger.info(list.get(i).getBno()+":"+list.get(i).getTitle());
		}
	}
}
