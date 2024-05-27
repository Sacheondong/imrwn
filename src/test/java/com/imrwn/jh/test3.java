package com.imrwn.jh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imrwn.jh.dao.BoardDaoImpl;
import com.imrwn.jh.dto.Board;

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
	public class test3 {
		

		@Autowired
		BoardDaoImpl boardDao;

		@Test
		public void test() throws Exception {
			Board b = boardDao.select(221);
			System.out.println(b);
			
			assertTrue(b != null);
		}

}
