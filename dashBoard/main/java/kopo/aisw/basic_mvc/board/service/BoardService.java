package kopo.aisw.basic_mvc.board.service;

import kopo.aisw.basic_mvc.board.vo.BoardVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface BoardService {
    public List listArticles() throws DataAccessException;

    public int addArticle(BoardVO boardVO) throws DataAccessException;

    public int removeArticle(String articleNO) throws DataAccessException;

    public BoardVO getArticle(String articleNO) throws DataAccessException;

    public int updateArticle(BoardVO boardVO) throws DataAccessException;

}
