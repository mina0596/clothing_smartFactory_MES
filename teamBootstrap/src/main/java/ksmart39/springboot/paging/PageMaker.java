package ksmart39.springboot.paging;

public class PageMaker {
    
    private Pagination paging;
    private int totalCount;
    private int pageStartNum; //페이지 시작 넘버
    private int pageEndNum;	  //페이지 끝 넘버
    private int lastPage;	  //마지막 페이지
    private boolean prev;		
    private boolean next;
    private int displayPageNum = 5; //페이지 숫자

    
    public Pagination getPaging() {
		return paging;
	}

	public void setPaging(Pagination paging) {
		this.paging = paging;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	public int getPageStartNum() {
		System.out.println("PageMaker pageStartNum :" + pageStartNum);
		return pageStartNum;
	}

	public void setPageStartNum(int pageStartNum) {
		this.pageStartNum = pageStartNum;
	}

	public int getPageEndNum() {
		System.out.println("PageMaker pageEndNum :" + pageEndNum);
		return pageEndNum;
	}

	public void setPageEndNum(int pageEndNum) {
		this.pageEndNum = pageEndNum;
	}

	private void calcData() {
		
		//paging.getCurrentPage() = 현재 페이지 번호
		//paging.getRowPerPage() = 한 페이지 당 보여줄 게시글 행의 개수
		//totalCount = 총 게시글 수 
		//lastPage = 화면에 보여질 마지막 페이지 번호(끝 페이지 번호)
		
		//끝 페이지 번호 = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		lastPage = (int) Math.ceil(paging.getCurrentPage()/(double) displayPageNum) * displayPageNum;
		System.out.println("calcData lastPage :" + lastPage);
		
		//시작 페이지 번호 = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		pageStartNum = (lastPage - displayPageNum) + 1;
		
		//시작 페이지 번호를 구할 때, 마지막 페이지 번호가 화면에 보여질 페이징 버튼의 개수보다 작으면 문제 발생(시작 페이지 번호가 음수가 됨)
		//따라서, 시작 페이지 번호가 0보다 작으면, 시작페이지를 1로 설정
		if(pageStartNum <= 0) pageStartNum = 1;
		System.out.println("calcData pageStartNum : " + pageStartNum);
		System.out.println("calcData totalCount : " + totalCount);
		System.out.println("calcData paging.getRowPerPage() : " + paging.getRowPerPage());
		
		//마지막 페이지 번호 = 총 게시글 수 / 한 페이지 당 보여줄 게시글 행의 개수
		pageEndNum = (int) (Math.ceil(totalCount / (double) paging.getRowPerPage()));
		
		//끝 페이지 번호보다 마지막 페이지 번호가 작은 경우, 마지막 페이지 번호를 끝 페이지 번호로 저장함.
		//화면에 보여질 끝 페이지 번호가 마지막 페이지 번호보다 클 수 없기 때문에 조건처리
		if (lastPage > pageEndNum) {
			lastPage = pageEndNum;
		}
		
		/*
		 * //현재 페이지가 6보다 클 경우 //시작 페이지 번호는 현재 페이지 - 5 / 마지막 페이지 번호 = 현재 페이지 + 4
		 * if(paging.getCurrentPage() > 6) { pageStartNum = paging.getCurrentPage() - 5;
		 * pageEndNum = paging.getCurrentPage() + 4;
		 * 
		 * //마지막 페이지 번호가 끝 페이지 번호보다 크거나 같을 경우 //시작 페이지 번호는 끝 페이지 번호 - 9 / 마지막 페이지 번호 = 끝
		 * 페이지; if(pageEndNum >= lastPage) { pageStartNum = lastPage - 9; pageEndNum =
		 * lastPage; } }
		 */
		
		System.out.println("calcData pageEndNum : " + pageEndNum);
        System.out.println("calcData currentPage : " + paging.getCurrentPage());
        
        //이전 버튼 생성 여부 = 시작 페이지 번호 == 1? false : true
        //이전 버튼은 시작 페이지 번호가 1이 아니면 생기면 된다.
        prev = pageStartNum == 1 ? false : true;
        
        //다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지 당 보여줄 게시글 행의 개수 < 총 게시글의 수  ? true: false;
        next = lastPage * paging.getRowPerPage() < totalCount ? true : false;

        
    }

	

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	//displayPageNum : 화면 하단에 보여지는 페이지 버튼의 수를 설정함.
	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
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

	
    
}
