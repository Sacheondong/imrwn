package com.imrwn.jh;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.imrwn.jh.basic.SearchCondition;
import com.imrwn.jh.dao.BoardDao;
import com.imrwn.jh.dto.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImpTest2 {
	    @Autowired
	    private BoardDao Dao;
		
//		//@Test
//	    public void countTest() throws Exception {
//
//			Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        Board boardDto = new Board("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.count()==1);
//
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.count()==2);
//	    }
//
//	    //@Test
//	    public void deleteAllTest() throws Exception {
//	        Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        Board boardDto = new Board("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.deleteAll()==1);
//	        assertTrue(Dao.count()==0);
//
//	        boardDto = new Board("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.deleteAll()==2);
//	        assertTrue(Dao.count()==0);
//	    }
//
//	    //@Test
//	    public void deleteTest() throws Exception {
//	        Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        Board boardDto = new Board();
//	        assertTrue(Dao.insert(boardDto)==1);
//	        Integer bno = Dao.selectAll().get(0).getBno();
//	        assertTrue(Dao.delete(bno, boardDto.getWriter())==1);
//	        assertTrue(Dao.count()==0);
//
//	        assertTrue(Dao.insert(boardDto)==1);
//	        bno = Dao.selectAll().get(0).getBno();
//	        assertTrue(Dao.delete(bno, boardDto.getWriter()+"222")==0);
//	        assertTrue(Dao.count()==1);
//
//	        assertTrue(Dao.delete(bno, boardDto.getWriter())==1);
//	        assertTrue(Dao.count()==0);
//
//	        assertTrue(Dao.insert(boardDto)==1);
//	        bno = Dao.selectAll().get(0).getBno();
//	        assertTrue(Dao.delete(bno+1, boardDto.getWriter())==0);
//	        assertTrue(Dao.count()==1);
//	    }
//
//	   // @Test
//	    public void insertTest() throws Exception {
//	        Dao.deleteAll();
//	        Board boardDto = new Board();
//	        assertTrue(Dao.insert(boardDto)==1);
//
//	        boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.count()==2);
//
//	        Dao.deleteAll();
//	        boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.count()==1);
//	    }
//
//	   // @Test
//	    public void selectAllTest() throws Exception {
//	        Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        List<BoardDto> list = Dao.selectAll();
//	        assertTrue(list.size() == 0);
//
//	        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//
//	        list = Dao.selectAll();
//	        assertTrue(list.size() == 1);
//
//	        assertTrue(Dao.insert(boardDto)==1);
//	        list = Dao.selectAll();
//	        assertTrue(list.size() == 2);
//	    }
//
//	  //  @Test
//	    public void selectTest() throws Exception {
//	        Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//
//	        Integer bno = Dao.selectAll().get(0).getBno();
//	        boardDto.setBno(bno);
//	        BoardDto boardDto2 = Dao.select(bno);
//	        assertTrue(boardDto.equals(boardDto2));
//	    }
//
//
//	   // @Test
//	    public void updateTest() throws Exception {
//	        Dao.deleteAll();
//	        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//
//	        Integer bno = Dao.selectAll().get(0).getBno();
//	        System.out.println("bno = " + bno);
//	        boardDto.setBno(bno);
//	        boardDto.setTitle("yes title");
//	        assertTrue(Dao.update(boardDto)==1);
//
//	        BoardDto boardDto2 = Dao.select(bno);
//	        assertTrue(boardDto.equals(boardDto2));
//	    }
//
//	   // @Test
//	    public void increaseViewCntTest() throws Exception {
//	        Dao.deleteAll();
//	        assertTrue(Dao.count()==0);
//
//	        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//	        assertTrue(Dao.insert(boardDto)==1);
//	        assertTrue(Dao.count()==1);
//
//	        Integer bno = Dao.selectAll().get(0).getBno();
//	        assertTrue(Dao.updateView_cnt(bno)==1);
//
//	        boardDto = Dao.select(bno);
//	        assertTrue(boardDto!=null);
//	        assertTrue(boardDto.getView_cnt() == 1);
//
//	        assertTrue(Dao.updateView_cnt(bno)==1);
//	        boardDto = Dao.select(bno);
//	        assertTrue(boardDto!=null);
//	        assertTrue(boardDto.getView_cnt() == 2);
//	    }
	    @Test
	    public void searchConditionTest() throws Exception {
	    	SearchCondition sc = new SearchCondition(1, 10, "asdf2","1", null);
	    	List<Board> list = Dao.searchSelectPage(sc);

	    }

}
