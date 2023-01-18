package com.my.springboot.study_springboot.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class CommonCodeOurDao {

    @Autowired // Dependency Injection - Mapper Connect
    private SqlSessionTemplate sqlSessionTemplatel;

    public Object getList(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplatel.selectList(sqlMapId, dataMap);
        return result;
    }

    public Object getOne(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplatel.selectOne(sqlMapId, dataMap);
        return result;
    }

    public Object updateOne(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplatel.update(sqlMapId, dataMap);
        return result;
    }

    public Object deleteOne(String sqlMapId, Object dataMap) {
        Object result = sqlSessionTemplatel.delete(sqlMapId, dataMap);
        return result;
    }

}
