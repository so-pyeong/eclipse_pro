package kopo.aisw.basic_mvc.member.controller;

import kopo.aisw.basic_mvc.member.service.MemberService;
import kopo.aisw.basic_mvc.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller("memberController")
public class MemberControllerImpl implements MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired(required=false)
    private MemberVO memberVO;

    @Override
    @RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
    public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List membersList = memberService.listMembers();
        ModelAndView mav = new ModelAndView("member/listMembers");
        mav.addObject("membersList", membersList);
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
    public ModelAndView addMember(@ModelAttribute("memberInfo") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        memberService.addMember(memberVO);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/modifyMember.do", method = RequestMethod.GET)
    public ModelAndView modifyMember(@ModelAttribute("memberInfo") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        System.out.println("확인 : " + memberVO.getId() + " ; " + memberVO.getPwd() + " ; " + memberVO.getName() + " ; " + memberVO.getEmail());
        memberService.updateMember(memberVO);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
    public ModelAndView deleteMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        memberService.deleteMember(id);
        ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
        return mav;
    }

    @Override
    @RequestMapping(value = "/member/editMember.do", method = RequestMethod.GET)
    public ModelAndView editMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemberVO memberView = memberService.getMember(id);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/member/viewMember");
        mav.addObject("memberView", memberView);
        return mav;
    }
}
