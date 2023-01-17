package com.my.springboot.study_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.dao.CommonCodeDao;

// Class RequestMapping
@Controller
@RequestMapping(value = "/commonCode")
public class CommonCodeController {

    @Autowired // Dependency Injection - 객체 주입
    CommonCodeDao commonCodeDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView modelAndView) {

        Object resultSet = commonCodeDao.getListForCommon();
        modelAndView.addObject("resultSet", resultSet);
        modelAndView.setViewName("commonCode/list");

        return modelAndView;

    }

}
