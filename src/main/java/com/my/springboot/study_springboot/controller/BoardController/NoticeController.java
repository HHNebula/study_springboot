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
@RequestMapping(value = "/notice") // 상위 URL - 모든 RequestMapping 의 앞에 작성됨
public class NoticeController {

    // Root 서블릿 - /notice > /notice/list
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String root() {
        return "redirect:/notice/list";
    }

    // 리스트 출력
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) {

        // 1. 모델&뷰 객체 생성
        // ModelAndView modelAndView = new ModelAndView();

        // 2. Notice 의 정보를 담은 Bean 객체들을 ArrayList 로 받아옴
        NoticeInfo noticeInfo = new NoticeInfo();
        ArrayList<NoticeBean> noticeList = noticeInfo.getNoticeList();

        // 3. 위 ArrayList 를 모델&뷰에 담음
        modelAndView.addObject("noticeList", noticeList);

        // 4. 모델&뷰의 뷰네임을 설정해줌 - jsp 파일의 경로
        modelAndView.setViewName("notice/list");

        // 5. 리턴
        return modelAndView;
    }

    // Notice 조회 기능 - View
    @RequestMapping(value = "/view/{uId}", method = RequestMethod.GET)
    public ModelAndView view(@PathVariable String uId, ModelAndView modelAndView) {

        // 1. 정보를 가져오기 위해 NoticeInfo 객체 생성
        NoticeInfo noticeInfo = new NoticeInfo();

        // 2. uId 에 해당하는 게시글의 정보를 가져옴
        NoticeBean noticeBean = noticeInfo.getNoticeBean(uId);

        // 3. 가져온 정보를 모델&뷰에 담음
        modelAndView.addObject("noticeBean", noticeBean);

        // 4. 모델&뷰의 뷰네임을 설정해줌 - jsp 파일의 경로
        modelAndView.setViewName("notice/view");

        // 5. 리턴
        return modelAndView;
    }

    // Notice 등록 페이지 이동
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form(ModelAndView modelAndView) {
        modelAndView.setViewName("notice/form");
        return modelAndView;
    }

    // Notice 등록
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String form(NoticeBean noticeBean, ModelAndView modelAndView) {

        // 1. Bean에 Form 정보를 담아서 받아옴
        System.out.println(noticeBean.getuId());
        System.out.println(noticeBean.getTitle());
        System.out.println(noticeBean.getContent());
        System.out.println(noticeBean.getWriter());
        System.out.println(noticeBean.getDate());

        // 2. 등록 로직을 완료 하고 List 로 리다이렉션
        return "redirect:/notice/list";
    }

    // Notice 수정
    @RequestMapping(value = "/edit/{uId}", method = RequestMethod.POST)
    public ModelAndView edit(@PathVariable String uId, ModelAndView modelAndView) {

        // 1. 정보를 가져오기 위해 NoticeInfo 객체 생성
        NoticeInfo noticeInfo = new NoticeInfo();

        // 2. uId 에 해당하는 게시글의 정보를 가져옴
        NoticeBean noticeBean = noticeInfo.getNoticeBean(uId);

        // 3. 가져온 정보를 모델&뷰에 담음
        modelAndView.addObject("noticeBean", noticeBean);

        // 4. 모델&뷰의 뷰네임을 설정해줌 - jsp 파일의 경로
        modelAndView.setViewName("notice/edit");

        // 5. 리턴
        return modelAndView;
    }

    // Notice 수정 완료
    @RequestMapping(value = "/edit/done", method = RequestMethod.POST)
    public String editCompleted(NoticeBean noticeBean, ModelAndView modelAndView) {

        // 1. Bean에 Form 정보를 담아서 받아옴
        System.out.println(noticeBean.getuId());
        System.out.println(noticeBean.getTitle());
        System.out.println(noticeBean.getContent());
        System.out.println(noticeBean.getWriter());
        System.out.println(noticeBean.getDate());

        // 2. 등록 로직을 완료 하고 view 로 리다이렉션
        return "redirect:/notice/view/" + noticeBean.getuId();
    }

}
