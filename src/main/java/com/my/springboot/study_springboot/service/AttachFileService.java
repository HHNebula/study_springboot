package com.my.springboot.study_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.springboot.study_springboot.dao.AttachFileDao;

@Service
public class AttachFileService {

    @Autowired
    private AttachFileDao attachFileDao;

    public Object getList(Object dataMap) {
        String sqlMapId = "AttachFile.selectListByUID";
        Object result = attachFileDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(Object dataMap) {
        String sqlMapId = "AttachFile.selectByUID";
        Object result = attachFileDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(Object dataMap) {
        String sqlMapId = "AttachFile.updateByUID";
        Object result = attachFileDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteOne(Object dataMap) {
        String sqlMapId = "AttachFile.deleteByUID";
        Object result = attachFileDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object deleteMulti(Object dataMap) {
        String sqlMapId = "AttachFile.deleteMultiByUIDs";
        Object result = attachFileDao.updateOne(sqlMapId, dataMap);
        return result;
    }

    public Object insertOne(Object dataMap) {
        String sqlMapId = "AttachFile.insertWithUID";
        Object result = attachFileDao.insertOne(sqlMapId, dataMap);
        return result;
    }

    public Object insertMulti(Object dataMap) {
        String sqlMapId = "AttachFile.insertMulti";
        Object result = attachFileDao.insertOne(sqlMapId, dataMap);
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
        Object result = insertMulti(dataMap);
        result = getList(dataMap);
        return result;
    }

}
