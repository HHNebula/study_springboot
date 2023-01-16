package com.my.springboot.study_springboot.controller.BoardController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.beans.NoticeBean;
import com.my.springboot.study_springboot.service.NoticeInfo;

// 클래스 레벨의 RequestMapping 은 상위 URL
// 메소드에 설정한 URL은 모두 클래스의 서브 URL이 된다.
@Controller
@RequestMapping(value = "/notice")
public class NoticeController {

    // Root 서블릿 - /notice >> /notice/list - 던지는 용도 / 리다이렉션 / URL 변화
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String root() {
        return "redirect:/notice/list";
    }

    // 리스트 출력 (/notice/list)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) {

        // 1. 모델&뷰 객체 생성 - Pram 으로 주어지면 생성은 불필요
        // ModelAndView modelAndView = new ModelAndView();

        // 2. Notice 의 정보를 담은 Bean 객체들을 ArrayList 로 받아옴
        NoticeInfo noticeInfo = new NoticeInfo();
        ArrayList<NoticeBean> noticeList = noticeInfo.getNoticeList();

        // 3. 위 ArrayList 를 모델&뷰에 담음 (request.setAttribute 와 비슷한 개념)
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

    // Notice 등록 페이지 이동 - 단순 페이지 출력이므로 셋뷰네임만 한다.
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

        // 2. 등록 로직을 완료 하고 List 로 리다이렉션 - DB 작업 필요
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

        // 2. 등록 로직을 완료 하고 view 로 리다이렉션 - DB 작업 필요
        return "redirect:/notice/view/" + noticeBean.getuId();
    }

}
