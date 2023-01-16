package com.my.springboot.study_springboot.service;

import java.util.ArrayList;

import com.my.springboot.study_springboot.beans.NoticeBean;

public class NoticeInfo {

    // 게시글 각각의 정보를 NoticeBean에 담아 ArrayList 에 추가한 후 리턴
    public ArrayList<NoticeBean> getNoticeList() {
        ArrayList<NoticeBean> noticeInfos = new ArrayList<>();

        NoticeBean noticeBean = new NoticeBean();
        noticeBean.setuId("1");
        noticeBean.setTitle("설연휴 배송 및 휴무 안내");
        noticeBean.setWriter("관리자 햇님");
        noticeBean.setContent("설연휴간 배송지연이 예상되오니 양해 바랍니다.<br>설연휴간 휴무입니다.");
        noticeBean.setDate("2023-01-14");
        noticeInfos.add(noticeBean);

        noticeBean = new NoticeBean();
        noticeBean.setuId("2");
        noticeBean.setTitle("설 맞이 이벤트 안내");
        noticeBean.setWriter("관리자 달님");
        noticeBean.setContent("설연휴간 모든 상품에 대해 50% 할인합니다.");
        noticeBean.setDate("2023-01-15");
        noticeInfos.add(noticeBean);

        noticeBean = new NoticeBean();
        noticeBean.setuId("3");
        noticeBean.setTitle("설 맞이 상품 입고 안내");
        noticeBean.setWriter("관리자 별님");
        noticeBean.setContent("설 맞이 신상품이 대거 입고되었습니다.");
        noticeBean.setDate("2023-01-16");
        noticeInfos.add(noticeBean);

        return noticeInfos;
    }

    // Param 으로 받아온 uId 와 동일한 NoticeBean 리턴
    public NoticeBean getNoticeBean(String uId) {
        NoticeBean noticeBean = new NoticeBean();
        ArrayList<NoticeBean> noticeInfos = getNoticeList();
        for (int i = 0; i < noticeInfos.size(); i++) {
            noticeBean = noticeInfos.get(i);
            if (noticeBean.getuId().equals(uId)) {
                break;
            }
        }
        return noticeBean;
    }

}
