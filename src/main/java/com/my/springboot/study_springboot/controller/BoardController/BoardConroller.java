package com.my.springboot.study_springboot.controller.BoardController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
@RequestMapping(value = "/board")
public class BoardConroller {

    // =========================================================================================================
    /**
     * 게시판 진입 시 리스트 출력
     * 
     * @return modelAndView
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

    // 게시글 작성하기 진입
    @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String formGet() {

        // Writing Out
        return "/WEB-INF/views/board/form.jsp";
    }

    // 작성 후 등록하기 클릭 시
    @RequestMapping(value = "/board/form", method = RequestMethod.POST)
    public String formPost() {

        // Insert Biz
        return "/WEB-INF/views/board/list.jsp";
    }

    // 게시글 수정하기 진입
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView) {
        modelAndView.setViewName("board/edit");
        return modelAndView;
    }

    // 게시글 클릭 시 View
    @RequestMapping(value = "/board/view", method = RequestMethod.GET)
    public String view() {

        // Content View
        return "/WEB-INF/views/board/view.jsp";
    }

}
