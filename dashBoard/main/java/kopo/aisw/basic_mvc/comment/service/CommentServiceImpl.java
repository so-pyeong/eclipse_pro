package kopo.aisw.basic_mvc.comment.service;

import kopo.aisw.basic_mvc.comment.vo.CommentVO;
import kopo.aisw.basic_mvc.comment.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED)
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDAO commentDAO;

    @Override
    public List<CommentVO> listComment(String parentNO) throws DataAccessException {
        List<CommentVO> commentAll = commentDAO.selectCommentList(parentNO);
        return commentAll;
    }

    @Override
    public int addComment(CommentVO commentVO) throws DataAccessException {
        int maxNum = commentDAO.maxCommentNO() + 1;
        commentVO.setCommentNO(maxNum);
        return commentDAO.insertComment(commentVO);
    }

    @Override
    public int removeComment(String commentNO) throws DataAccessException {
        return commentDAO.deleteComment(commentNO);
    }

    @Override
    public int modifyComment(CommentVO commentVO) throws DataAccessException {
        return commentDAO.updateComment(commentVO);
    }
}
