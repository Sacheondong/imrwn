package com.imrwn.jh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imrwn.jh.dao.MovieDaoImpl;
import com.imrwn.jh.dto.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MovieTest {
	

	@Autowired
	MovieDaoImpl movieDao;

	@Test
	public void test2() throws Exception {
		Movie m = movieDao.selectTitleDire(" µµƒÏ!", "∫¿¡ÿ»£");
		System.out.println(m);
		
		assertTrue(m != null);
	}
}
