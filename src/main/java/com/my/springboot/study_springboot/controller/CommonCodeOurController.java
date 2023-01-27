package com.my.springboot.study_springboot.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.my.springboot.study_springboot.service.CommonCodeOurService;
import com.my.springboot.study_springboot.utils.CommonUtils;

@Controller
@RequestMapping(value = "/commoncodeour")
public class CommonCodeOurController {

    @Autowired
    private CommonCodeOurService commonCodeOurService;

    @Autowired
    private CommonUtils commonUtils;

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

        Object resultMap = commonCodeOurService.updateAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/list");

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{uniqueId}", method = RequestMethod.POST)
    public ModelAndView delete(@PathVariable String uniqueId, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        params.put("COMMON_CODE_ID", uniqueId);
        Object resultMap = commonCodeOurService.deleteAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/list");

        return modelAndView;
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView form(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        modelAndView.setViewName("commonCode_Our/edit");

        return modelAndView;
    }

    // 파일 등록
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insert(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        String registerSeq = multipartHttpServletRequest.getParameter("REGISTER_SEQ");

        // input:file attribute name
        MultipartFile file = multipartHttpServletRequest.getFile("file_first");
        String fileName = file.getOriginalFilename();
        String relativePath = "src\\main\\resources\\static\\files\\";

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(relativePath + fileName));

        bufferedWriter.write(new String(file.getBytes()));

        commonCodeOurService.insertOne(params);
        // Object resultMap = commonCodeOurService.insertAndGetList(params);
        // modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/list");

        return modelAndView;
        // return "redirect:/commoncodeour/list";
    }

    // 1. @RequestParam Map<String, Object> params > Key가 동일하면 덮어써진다.
    @RequestMapping(value = "/deleteMulti", method = RequestMethod.POST)
    public ModelAndView deleteMulti(HttpServletRequest request, @RequestParam Map<String, Object> params,
            ModelAndView modelAndView) {

        // 2. 위 문제를 해결하기 위해 HttpServletRequest 클래스를 통해 배열로 가져온다.
        String[] deleteMultis = request.getParameterMap().get("COMMON_CODE_ID");
        params.put("deleteMultis", deleteMultis);
        Object resultMap = commonCodeOurService.deleteMultiAndGetList(params);

        modelAndView.addObject("resultMap", resultMap);
        modelAndView.setViewName("commonCode_Our/list");
        return modelAndView;
    }

    @RequestMapping(value = { "/insertMulti" }, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();
        String relativePath = "C:\\_workspace\\study_springboot\\src\\main\\resources\\static\\files\\";

        Map attachfile = null;
        List attachfiles = new ArrayList();
        String physicalFileName = commonUtils.getUniqueSequence();
        String storePath = relativePath + physicalFileName + "\\";
        File newPath = new File(storePath);
        newPath.mkdir(); // create directory
        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFilename = multipartFile.getOriginalFilename();

            String storePathFileName = storePath + originalFilename;
            multipartFile.transferTo(new File(storePathFileName));

            // add SOURCE_UNIQUE_SEQ, ORGINALFILE_NAME, PHYSICALFILE_NAME in HashMap
            attachfile = new HashMap<>();
            attachfile.put("ATTACHFILE_SEQ", commonUtils.getUniqueSequence());
            attachfile.put("SOURCE_UNIQUE_SEQ", params.get("COMMON_CODE_ID"));
            attachfile.put("ORGINALFILE_NAME", originalFilename);
            attachfile.put("PHYSICALFILE_NAME", physicalFileName);
            attachfile.put("REGISTER_SEQ", params.get("REGISTER_SEQ"));
            attachfile.put("MODIFIER_SEQ", params.get("MODIFIER_SEQ"));

            attachfiles.add(attachfile);
        }
        params.put("attachfiles", attachfiles);

        Object resultMap = commonCodeOurService.insertWithFilesAndGetList(params);
        modelAndView.addObject("resultMap", resultMap);

        modelAndView.setViewName("commonCode_Our/list");
        return modelAndView;
    }

    // 멀티 파일 등록 폼
    @RequestMapping(value = "/formMulti", method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {

        modelAndView.setViewName("commonCode_Our/editMulti");

        return modelAndView;
    }

}
