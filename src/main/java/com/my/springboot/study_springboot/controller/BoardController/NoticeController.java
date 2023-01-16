package com.my.springboot.study_springboot.controller.BoardController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.beans.NoticeBean;
import com.my.springboot.study_springboot.service.NoticeInfo;

@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String root() {
        return "redirect:/notice/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        NoticeInfo noticeInfo = new NoticeInfo();
        ArrayList<NoticeBean> noticeList = noticeInfo.getNoticeList();
        modelAndView.addObject("noticeList", noticeList);
        modelAndView.setViewName("notice/list");
        return modelAndView;
    }

    @RequestMapping(value = "/view/{uId}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable String uId, ModelAndView modelAndView) {
        NoticeInfo noticeInfo = new NoticeInfo();
        NoticeBean noticeBean = noticeInfo.getNoticeBean(uId);
        modelAndView.addObject("noticeBean", noticeBean);
        modelAndView.setViewName("notice/view");
        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form(ModelAndView modelAndView) {
        modelAndView.setViewName("notice/form");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String form(NoticeBean noticeBean, ModelAndView modelAndView) {
        System.out.println(noticeBean.getuId());
        System.out.println(noticeBean.getTitle());
        System.out.println(noticeBean.getContent());
        System.out.println(noticeBean.getWriter());
        System.out.println(noticeBean.getDate());
        return "redirect:/notice/list";
    }

    @RequestMapping(value = "/edit/{uId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable String uId, ModelAndView modelAndView) {
        NoticeInfo noticeInfo = new NoticeInfo();
        NoticeBean noticeBean = noticeInfo.getNoticeBean(uId);
        modelAndView.addObject("noticeBean", noticeBean);
        modelAndView.setViewName("notice/edit");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/done", method = RequestMethod.POST)
    public String editCompleted(NoticeBean noticeBean, ModelAndView modelAndView) {
        System.out.println(noticeBean.getuId());
        System.out.println(noticeBean.getTitle());
        System.out.println(noticeBean.getContent());
        System.out.println(noticeBean.getWriter());
        System.out.println(noticeBean.getDate());
        return "redirect:/notice/view/" + noticeBean.getuId();
    }

}
