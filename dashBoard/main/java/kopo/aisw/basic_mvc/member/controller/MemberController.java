package kopo.aisw.basic_mvc.member.controller;

import kopo.aisw.basic_mvc.member.vo.MemberVO;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberController {
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView addMember(@ModelAttribute("memberInfo") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView modifyMember(@ModelAttribute("memberInfo") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception;
    public ModelAndView deleteMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;

    public ModelAndView editMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
