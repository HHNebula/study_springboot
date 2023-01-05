package com.my.springboot.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // 컨트롤러가 요청을 받아 모델과 데이터를 주고 받음
    // 모델이 데이터 베이스와 연동되어 반영
    // 모델에서 돌아온 데이터를 컨트롤러가 가지고 있음
    // 해당 데이터와 파일 경로를 통해 View 로 출력

    @RequestMapping(value = "/homejsp")
    public String home() {

        int i = 0;

        return "WEB-INF/views/home.jsp";
    }

}
