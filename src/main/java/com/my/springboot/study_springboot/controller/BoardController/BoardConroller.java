package com.my.springboot.study_springboot.controller.BoardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardConroller {

    @RequestMapping(value = "/board/form", method = RequestMethod.GET)
    public String form() {

        return "/WEB-INF/views/board/form.jsp";

    }

    @RequestMapping(value = "/board/form", method = RequestMethod.POST)
    public String formPost() {

        // insert biz
        return "/WEB-INF/views/board/list.jsp";

    }

}
