package com.my.springboot.study_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.springboot.study_springboot.dao.CommonCodeOurDao;

@Service
public class CommonCodeOurService {

    @Autowired
    private CommonCodeOurDao commonCodeOurDao;

    public Object getList(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectListByUID";
        Object result = commonCodeOurDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.selectByUID";
        Object result = commonCodeOurDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.updateByUID";
        Object result = commonCodeOurDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteByUID";
        Object result = commonCodeOurDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "CommonCodeOur.deleteMultiByUIDs";
        Object result = commonCodeOurDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "CommonCodeOur.insertWithUID";
        Object result = commonCodeOurDao.insertOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteAndGetList(Object dataMap) {
        Object result = deleteOne(dataMap);
        result = getList(dataMap);
        return result;
    }

    public Object deleteMultiAndGetList(Object dataMap) {
        Object result = deleteMulti(dataMap);
        result = getList(dataMap);
        return result;
    }

    public Object updateAndGetList(Object dataMap) {
        Object result = updateOne(dataMap);
        result = getList(dataMap);
        return result;
    }

    public Object insertAndGetList(Object dataMap) {
        Object result = insertOne(dataMap);
        result = getList(dataMap);
        return result;
    }

    public Object insertWithFilesAndGetList(Object dataMap) {
        // TO-DO
        // insert Files
        Object result = insertOne(dataMap);
        result = getList(dataMap);
        return result;
    }

}
