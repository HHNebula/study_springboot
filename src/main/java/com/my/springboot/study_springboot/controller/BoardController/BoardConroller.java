package com.my.springboot.study_springboot.controller.BoardController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.beans.BoardBean;
import com.my.springboot.study_springboot.service.DataInfors;

// * Cast 
// - use bootstrap
// - 항목 : title, content,userName, date
// - CRUD : 
//   + list.jsp(/board) -> view.jsp(/board_our/view) -> list.jsp(/board_our/list)
//   + list.jsp(/board) -> form.jsp(/board_our/form) -> list.jsp(/board_our/save) with Post
//   + view.jsp(/board_our/view) -> edit.jsp(/board_our/edit) -> list.jsp(/board_our/save)

// 클래스 레벨의 RequestMapping
// 클래스 설정 시 메소드에 설정한 URL은 모두 클래스의 서브 URL이 된다.
@Controller
@RequestMapping(value = "/board")
public class BoardConroller {

    // =========================================================================================================
    /**
     * 게시판 진입 시 리스트 출력
     * 
     * @return list.jsp
     */
    @RequestMapping(value = { "", "/list" }, method = RequestMethod.GET)
    public ModelAndView list() {

        // 1. ModelAndView 생성
        ModelAndView modelAndView = new ModelAndView();

        // 2. Object 추가 == .addObject(Name, Value)
        modelAndView.addObject("firstString", "firstValue");

        // 3. DataInfo 를 가져와 Object 추가
        DataInfors dataInfors = new DataInfors();
        ArrayList<BoardBean> boardList = dataInfors.getDataListWithBoardBean();
        modelAndView.addObject("boardList", boardList);

        // 4. Model 정보와 View 정보 전달
        modelAndView.setViewName("board/list");
        return modelAndView; // --> Dispatcher Servlet }
    }

    // =========================================================================================================
    /**
     * 게시판 작성하기 진입
     * Writing Out Work
     * 
     * @return form.jsp
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form() {

        // Writing Out
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("board/form");
        return modelAndView; // --> Dispatcher Servlet }
    }

    // =========================================================================================================
    /**
     * 게시판 글 등록하기 작업
     * Insert Biz Work
     * 
     * @param ModelAndView modelAndView
     * @return list.jsp
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insert(ModelAndView modelAndView) {

        modelAndView.setViewName("board/list");
        return modelAndView; // --> Dispatcher Servlet }
    }

    // =========================================================================================================
    /**
     * 게시글 수정하기 진입
     * Edit Work
     * 
     * @param ModelAndView modelAndView
     * @return edit.jsp
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(/* @RequestParam String title, */ModelAndView modelAndView) {
        // System.out.println(title);
        // DataInfors dataInfors = new DataInfors();
        // BoardBean boardBean = dataInfors.getDataWithMamberBean(title);
        // modelAndView.addObject("boardBean", boardBean);
        modelAndView.setViewName("board/edit");
        return modelAndView;
    }

    // =========================================================================================================
    /**
     * 게시글 조회 기능
     * View Work
     * 
     * @param String       uId
     * @param ModelAndView modelAndView
     * @return view.jsp
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView view(@RequestParam String title, ModelAndView modelAndView) {
        System.out.println(title);
        DataInfors dataInfors = new DataInfors();
        BoardBean boardBean = dataInfors.getDataWithMamberBean(title);
        modelAndView.addObject("boardBean", boardBean);
        modelAndView.setViewName("board/view");
        return modelAndView;
    }

}
