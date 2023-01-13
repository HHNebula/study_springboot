package com.my.springboot.study_springboot.controller.BoardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardConroller {

    // 게시판 진입 시 리스트 출력
    @RequestMapping(value = { "/board", "/board/list" }, method = RequestMethod.GET)
    public String board() {

        return "/WEB-INF/views/board/list.jsp";
    }

    // 게시글 작성하기 진입
    @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String formGet() {

        return "/WEB-INF/views/board/form.jsp";
    }

    // 작성 후 등록하기 클릭 시
    @RequestMapping(value = "/board/form", method = RequestMethod.POST)
    public String formPost() {

        // insert biz
        return "/WEB-INF/views/board/list.jsp";
    }

    // 게시글 수정하기 진입
    @RequestMapping(value = "/board/edit", method = RequestMethod.GET)
    public String edit() {

        return "/WEB-INF/views/board/edit.jsp";
    }

    // 게시글 클릭 시 View
    @RequestMapping(value = "/board/view", method = RequestMethod.GET)
    public String view() {

        return "/WEB-INF/views/board/view.jsp";
    }

}
