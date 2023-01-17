package com.my.springboot.study_springboot.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class HomeDao {

    // fn 과 xml 을 연결해주는 클래스
    // MyBatis의 자원을 이용할 수 있게 함
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Object getList() {
        String statement = "Home.selectFormAnswersByQuestionUid";
        Map parameter = new HashMap();
        parameter.put("QUESTIONS_UID", "Q2");
        Object resultset = sqlSessionTemplate.selectList(statement, parameter);
        return resultset;
    }

}
