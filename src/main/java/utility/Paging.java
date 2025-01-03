package utility;

public class Paging {

	private int totalCount = 0 ;
	private int totalPage = 0 ;
	
	private int pageNumber = 0 ;
	private int pageSize = 0 ;
	private int beginRow = 0 ;
	private int endRow = 0 ;
	
	private int pageCount = 10 ;
	private int beginPage = 0 ;
	private int endPage = 0 ;
	
	private String url = "" ;
	private String pagingHtml = "" ;
	private String pagingStatus = "" ;
	
	private String mode = "" ;
	private String keyword = "" ;
	
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getBeginRow() {
		return beginRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public String getUrl() {
		return url;
	}

	public String getPagingHtml() {
		return pagingHtml;
	}

	public String getPagingStatus() {
		return pagingStatus;
	}

	public String getMode() {
		return mode;
	}

	public String getKeyword() {
		return keyword;
	}

	public Paging(String _pageNumber, String _pageSize, 
			int totalCount, String url, String mode, String keyword) {
		if (_pageNumber == null || _pageNumber.equals("null") || _pageNumber.equals("") ) {
			_pageNumber = "1" ;
		}
		this.pageNumber = Integer.parseInt(_pageNumber) ;
		
		if (_pageSize == null || _pageSize.equals("null") || _pageSize.equals("") ) {
			_pageSize = "10" ;
		}
		this.pageSize = Integer.parseInt(_pageSize) ;
		this.totalCount = totalCount ;
		
		this.totalPage = (int)Math.ceil(1.0*totalCount/pageSize)  ; 
		
		this.beginRow = (this.pageNumber - 1 ) * this.pageSize + 1 ; 
		this.endRow = this.pageNumber * this.pageSize ;
		
		this.beginPage = (this.pageNumber - 1)/this.pageCount*this.pageCount + 1  ;
		this.endPage = this.beginPage + this.pageCount - 1 ;
		
		if (totalPage < endPage) {
			endPage = totalPage ; 
		}
		
		this.url = url ;
		if(mode == null || mode.equals("null")) { 
			this.mode = "all" ;	
		}else {
			this.mode = mode ;
		}		
		
		this.keyword = keyword ;
		
		this.pagingHtml = this.getPagingHtml(url) ;
		
		this.pagingStatus = "총 " + totalCount + "건[" + pageNumber + "/" + totalPage + "]" ;
	}
	
	private String getPagingHtml(String url) {
		String result = "" ;
		
		String add_param = "&mode=" + mode + "&keyword=" + keyword ;   
		
		result += "<ul class='pagination pagination-sm'>" ;
		// 맨앞, 이전 
		if (pageNumber <= pageCount) {
			// 맨앞과 이전 항목이 필요 없습니다. 
		} else {
			
			result += "<li><a href='" + url + "&pageNumber=" + 1 
					+ "&pageSize=" + pageSize + add_param + "'>" + "맨앞" + "</a></li>" + "";  
			
			result += "<li><a href='" + url + "&pageNumber=" + (beginPage - 1) 
					+ "&pageSize=" + pageSize + add_param + "'>" + "이전" + "</a></li>" + ""; 			
		}
		
		// PageCount 영역
		for (int i = beginPage; i <= endPage; i++) {
			if (i == pageNumber) { // 현재 페이지는 링크가 없고, 빨간색으로 표시
				
				result += "<li class='active'><a><font color='red'><b>" + i + "</b></font></a></li>" ;
				
			}else { // 다른 페이지로 이동할 수 있도록 링크를 붙여줌 
				
				result += "<li><a href='" + url + "&pageNumber=" + i 
						+ "&pageSize=" + pageSize + add_param + "'>" + i + "</a></li>" + "";  
				
			}
		}		
		
		// 다음, 맨끝 
		if (pageNumber >= (totalPage/pageCount*pageCount+1)) {
			// 다음과 맨끝 버튼이 필요 없습니다.
		} else {
		
			result += "<li><a href='" + url + "&pageNumber=" + (endPage + 1 ) 
					+ "&pageSize=" + pageSize + add_param + "'>" + "다음" + "</a></li>" + "";
			
			result += "<li><a href='" + url + "&pageNumber=" + totalPage 
					+ "&pageSize=" + pageSize + add_param + "'>" + "맨끝" + "</a></li>" + "";  
			
		}
		result += "</ul>" ;		
		
		return result ;
	}

	@Override
	public String toString() {
		String imsi = "totalCount : " + totalCount + "\n" ;
		imsi += "totalPage : " + totalPage + "\n" ;
		imsi += "pageNumber  : " + pageNumber  + "\n" ;
		imsi += "pageSize  : " + pageSize  + "\n" ;
		imsi += "beginRow  : " + beginRow  + "\n" ;
		imsi += "endRow  : " + endRow  + "\n" ;
		imsi += "pageCount  : " + pageCount  + "\n" ;
		imsi += "beginPage  : " + beginPage  + "\n" ;
		imsi += "endPage  : " + endPage  + "\n" ;
		imsi += "url  : " + url  + "\n" ;
		imsi += "pagingHtml  : " + pagingHtml  + "\n" ;
		imsi += "pagingStatus  : " + pagingStatus  + "\n" ;
		imsi += "mode  : " + mode  + "\n" ;
		imsi += "keyword   : " + keyword   + "\n" ;
		
		
		return imsi ;
	}
	
}



















