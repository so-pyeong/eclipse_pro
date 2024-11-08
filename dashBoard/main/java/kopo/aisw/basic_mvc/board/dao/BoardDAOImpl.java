package kopo.aisw.basic_mvc.board.dao;

import kopo.aisw.basic_mvc.board.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List selectAllArticlesList() throws DataAccessException {
        List<BoardVO> articlesList = null;
        articlesList = sqlSession.selectList("mapper.board.selectAllArticlesList");
        return articlesList;
    }

    @Override
    public int insertArticle(BoardVO boardVO) throws DataAccessException {
        int result = sqlSession.insert("mapper.board.insertArticle", boardVO);
        return result;
    }

    @Override
    public int deleteArticle(String articleNO) throws DataAccessException {
        int result = sqlSession.delete("mapper.board.deleteArticle", articleNO);
        return result;
    }

    // 수정 : Max ArticleNO 구하기
    @Override
    public int maxArticleNum() throws DataAccessException {
        return sqlSession.selectOne("mapper.board.getMaxArticleNO");
    }

    @Override
    public BoardVO selectArticle(String articleNO) throws DataAccessException {
        BoardVO boardVO = sqlSession.selectOne("mapper.board.articleView", articleNO);
        return boardVO;
    }

    @Override
    public int updateArticle(BoardVO boardVO) throws DataAccessException {
        return sqlSession.update("mapper.board.updateArticle", boardVO);
    }
}
