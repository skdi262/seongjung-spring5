package com.edu.vo;
/**
 * 이 클래스는 공통(회원관리, 게시물관리)로 사용하는 페이징처리 + 검색기능포함 클래스.
 * @author 김성중
 * queryStartNo, queryPerPageNum, page, StartPage, endPage
 * 이 클래스는 오라클이든, mysql이든 마리아 DB든 공통으로 사용가능한 Get/Set
 * 검색에 사용되는 변수 (쿼리변수) :검색어 (search_keyword), 검색조건 (search_type)
 */
public class PageVO {
	private int queryStartNo;// 쿼리전용
	private int queryPerPageNum; //쿼리전용
	private Integer page; // jsp 에서 받아옴, 에러방지용 Null 값을 허용
	private int perPageNum; //Ui하단에 보여줄 페이징 개수
	private int totalCount; // 계산식의 기초값으로 이 값이 지정된 이 후에 페이징 계산이 이루어짐
	private int startPage; // 위 perPageNum으로 구하는 UI하단 페이지 시작번호
	private int endPage; //위 perPageNum으로 구하는 UI하단 페이지 끝번호
	private boolean prev; // UI하단에 이전페이지 게시물 관리
	private boolean next; // UI하단에 다음 페이지로 이동이 가능한 지 판별
//	여기서부턴 검색
	private String search_keyword; //jsp에서 받은 검색어
	private String search_type; //검색 조건에 해당하는 쿼리전용변수
	
	@Override
	public String toString() {
		return "PageVO [queryStartNo=" + queryStartNo + ", queryPerPageNum=" + queryPerPageNum + ", page=" + page
				+ ", perPageNum=" + perPageNum + ", totalCount=" + totalCount + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", search_keyword=" + search_keyword
				+ ", search_type=" + search_type + "]";
	}
	public int getQueryStartNo() {
		//jsp에서는 1,2,3,... 으로 받지만
		//쿼리에서는 0,1,2로 사용되기 떄문에 page*페이지당보여줄개수
		queryStartNo = this.page-1;
		return queryStartNo;
	}
	public void setQueryStartNo(int queryStartNo) {
		this.queryStartNo = queryStartNo;
	}
	public int getQueryPerPageNum() {
		return queryPerPageNum;
	}
	public void setQueryPerPageNum(int queryPerPageNum) {
		this.queryPerPageNum = queryPerPageNum;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//전체갯수 값을 지정한 이후 계산식
		calcPage();
	}
	private void calcPage() {
		// 이 메서드는 totlaCOunt 변수 값을 기반으로 prev,next,startPage,enPAge 등등을 구현하게 됨.
	int tempEnd =(int) Math.ceil(page/(double)this.perPageNum)*this.perPageNum;
	//jps에서 클릭한 페이지 번호 예로1부터 10까지는 클릭하면 임시끝페이지가 10,
	// 만약 11페이지를 클릭하면 , 임시 끄텦이지가 20. 확인 위 tmepEnd 변수 값으로 아래 내용
		this.startPage = (tempEnd - this.perPageNum) + 1;
		//1-10까지는 jsp에 클릭했을때, 시작페이지가 1페이지, 11부터는 시작페이지가 11이되게 만들어줌
		if(tempEnd*this.queryPerPageNum > this.totalCount) {
			this.endPage = (int)Math.ceil(this.totalCount/(double)this.queryPerPageNum);
		} else {
			this.endPage = tempEnd;//엔드페이지
		}
		this.prev = (this.startPage != 1);//start가 1페이지일땐 뜨면 안되니까
		this.next = this.endPage*this.queryPerPageNum < this.totalCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public String getSearch_keyword() {
		return search_keyword;
	}
	public void setSearch_keyword(String search_keyword) {
		this.search_keyword = search_keyword;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}

}
