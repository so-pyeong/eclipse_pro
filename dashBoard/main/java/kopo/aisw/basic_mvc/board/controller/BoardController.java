package kopo.aisw.basic_mvc.board.controller;

import kopo.aisw.basic_mvc.board.vo.BoardVO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardController {
    public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView addArticle(@ModelAttribute("board") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView removeArticle(@RequestParam("articleNO") String articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView detailArticle(@RequestParam("articleNO") String articleNO, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView modifyArticle(@ModelAttribute("board") BoardVO board, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
