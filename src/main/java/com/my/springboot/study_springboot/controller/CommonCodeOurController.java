package com.my.springboot.study_springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.service.CommonCodeOurService;

@Controller
@RequestMapping(value = "/commoncodeour")
public class CommonCodeOurController {

    @Autowired
    private CommonCodeOurService commonCodeOurService;

    @RequestMapping(value = { "/list", "/", "" }, method = RequestMethod.GET)
    public ModelAndView list(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        Object resultMap = commonCodeOurService.getList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/list");

        return modelAndView;
    }

    @RequestMapping(value = "/edit/{uniqueId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String uniqueId, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.getOne(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/edit");

        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        commonCodeOurService.updateOne(params);
        modelAndView.setViewName("commonCode_Our/list");

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{uniqueId}", method = RequestMethod.POST)
    public String delete(@PathVariable String uniqueId, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        params.put("COMMON_CODE_ID", uniqueId);
        commonCodeOurService.deleteOne(params);

        return "redirect:/commoncodeour/list";
    }

}
