package com.my.springboot.study_springboot.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.my.springboot.study_springboot.beans.BoardBean;

public class DataInfors {
    public HashMap<String, String> getSearchFormData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "SOO SPRING BOOT");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    public HashMap<String, Object> getBundlesData() {
        DataInfors DataInfors = new DataInfors();
        HashMap<String, String> searchForm = DataInfors.getSearchFormData();
        ArrayList<String> tablesListWithString = DataInfors.getTablesListWithString();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        // bundlesData.put("dataWithMamberBean", DataInfors.getDataWithMamberBean());
        bundlesData.put("dataListWithBoardBean", DataInfors.getDataListWithBoardBean());

        return bundlesData;
    }

    public BoardBean getDataWithMamberBean(String title) {
        ArrayList<BoardBean> memberList = getDataListWithBoardBean();
        BoardBean boardBean = new BoardBean();
        for (BoardBean member : memberList) {
            if (member.getTitle().equals(title)) {
                boardBean.setTitle(member.getTitle());
                boardBean.setContent(member.getContent());
                boardBean.setWriter(member.getWriter());
                boardBean.setDate(member.getDate());
                return boardBean;
            }
        }
        boardBean.setTitle("[Err] 해당 게시글이 없음");
        boardBean.setContent("Otto");
        boardBean.setWriter("@mdo");

        return boardBean;
    }

    public ArrayList<BoardBean> getDataListWithBoardBean() {
        ArrayList<BoardBean> membersList = new ArrayList<>();
        BoardBean boardBean = new BoardBean();
        boardBean.setTitle("또 북한발 해킹?... daum아닌 daurn에서 메일 오면 주의");
        boardBean.setContent(
                "북한 소속으로 추정되는 해킹조직이 카카오를 위장해 개인 정보를 탈취하려는 정황이 포착됐다. "
                        + "14일 자유아시아방송(RFA)에 따르면 한국 사이버보안업체 이스트시큐리티는 다음(daum)과 유사한 영문 표기 'daurn' 도메인을 이용해 사용자들의 비밀번호를 탈취하려는 피싱(phishing) 시도가 일어나고 있다고 밝혔다. "
                        + "이스트시큐리티는 이번 공격이 북한 정찰총국의 지원을 받는 해킹조직 '김수키'에 의해 이뤄졌다고 분석했다. "
                        + "피싱 메일은 '[긴급] 지금 바로 비밀번호를 변경해주세요'라는 제목으로 전송됐다. "
                        + "메일 본문에는 '안녕하세요, Daum입니다. 회원님의 비밀번호와 개인정보가 타인에게 도용되었을 수 있습니다' 등의 내용이 담겼다. "
                        + "비밀번호를 변경하라며 수신자를 피싱 페이지로 유도하려는 전략이다. 만일 수신자가 메일에 있는 '지금 비밀번호 변경하러 가기' 아웃링크를 클릭하면, 피싱 페이지로 넘어간다.");
        boardBean.setWriter("박선민");
        boardBean.setDate("2023-01-14");
        membersList.add(boardBean);

        boardBean = new BoardBean();
        boardBean.setTitle("네이버 기술로 혁신, 2024년 흑자 만들겠다");
        boardBean.setContent("\"네이버의 검색, 콘텐츠 기술을 기반으로 서비스를 고도화하고 사용자 경험을 대폭 개선할 것이다.\" "
                + "지난 12일 미 캘리포니아 실리콘밸리 레드우드시티에서 만난 마니시 샨드라 포시마크 CEO(최고경영자)는 포시마크가 네이버 자회사가 된 것에 대해 "
                + "\"많은 기대를 걸고 있다\"고 말했다. 그는 네이버의 기술력을 접목하면 아시아 시장 진출 같은 성장 기회를 잡는 데 도움이 될 것이라며 이를 기반으로 패션 리커머스(중고거래)의 글로벌 리더가 될 것이라고 했다.");
        boardBean.setWriter("김성민");
        boardBean.setDate("2023-01-16");
        membersList.add(boardBean);

        boardBean = new BoardBean();
        boardBean.setTitle("韓 원자력 UAE 수출 6개월 빨라진다");
        boardBean.setContent(
                "원자력안전위원회는 15일(현지시간) 아랍에미리트(UAE) 원자력규제기관인 연방원자력규제청(FANR)과 원자력 수출허가 절차 간소화를 골자로 하는 행정약정을 체결했다. "
                        + "이번 행정약정은 윤석열 대통령의 UAE 국빈방문을 계기로 한-UAE 간 원자력협력협정을 근거로 이뤄졌다. "
                        + "원안위-FANR 행정약정은 양국 간 원자력 안전조치 및 수출통제 관련 의무사항을 규정한 것으로, 특히 양국 간 원자력 수출허가 절차를 간소화하는 효과가 있다.");
        boardBean.setWriter("구본혁");
        boardBean.setDate("2023-01-15");
        membersList.add(boardBean);
        return membersList;
    }

}
