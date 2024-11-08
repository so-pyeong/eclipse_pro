package kopo.aisw.basic_mvc.board.service;

import kopo.aisw.basic_mvc.board.dao.BoardDAO;
import kopo.aisw.basic_mvc.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("boardService")
@Transactional(propagation = Propagation.REQUIRED)
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List listArticles() throws DataAccessException {
        List articlesList = null;
        articlesList = boardDAO.selectAllArticlesList();
        return articlesList;
    }

    @Override
    public int addArticle(BoardVO boardVO) throws DataAccessException {
        // 수정 Max ArticleNO +1 -> 새글 번호 생성
        int maxNum = boardDAO.maxArticleNum() + 1;
        // 수정 : 새글 번호를 boardVO -> ArticleNO 적용
        boardVO.setArticleNO(maxNum);
        return boardDAO.insertArticle(boardVO);
    }

    @Override
    public int removeArticle(String articleNO) throws DataAccessException {
        return boardDAO.deleteArticle(articleNO);
    }

    @Override
    public BoardVO getArticle(String articleNO) throws DataAccessException {
        BoardVO boardVO = boardDAO.selectArticle(articleNO);
        return boardVO;
    }

    public int updateArticle(BoardVO boardVO) throws DataAccessException {
        return boardDAO.updateArticle(boardVO);
    }

}
