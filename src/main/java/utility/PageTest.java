package utility;

public class PageTest {
	public static void main(String[] args) {
		String _pageNumber = "2" ; 
		String _pageSize = "10" ;
		int totalCount = 35 ; 
		String url = "/boList" ;
		String mode = "" ;
		String keyword = "" ;
		
		Paging pageInfo 
			= new Paging(
					_pageNumber, _pageSize, totalCount,
					url, mode, keyword) ;
		
		System.out.println(pageInfo); 
	}
}
