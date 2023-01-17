package com.my.springboot.study_springboot.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository // DAO를 인식시켜주기 위한 설정
@Component // Bean 등록
public class CommonCodeDao {

    @Autowired // Dependency Injection - 객체 주입
    private SqlSessionTemplate sqlSessionTemplate;

    public Object getListForCommon() {
        String statement = "CommonCode.selectCommonCodeIdNameOrderNumberByCipCommonCode";
        Map parameter = new HashMap();
        // parameter.put("key", "value");
        Object resultset = sqlSessionTemplate.selectList(statement, parameter);
        return resultset;
    }

}
