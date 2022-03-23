package kr.co.ict;

public class BoardDTO {
	private int boardCount;
	private int currentPage;
	private int totalPages;
	private int startPage;
	private int endPage;
	private static final int NAV_NUM = 10;
	private static final int BOARD_NUM = 10;
	
	public BoardDTO(int boardCount, int currentPage) {
		
		this.boardCount = boardCount;
		this.currentPage = currentPage;
		
		
		if(boardCount == 0) {
			this.totalPages = 0;
			this.startPage = 0;
			this.endPage = 0;
		} else {
			if(boardCount % BOARD_NUM == 0) {
				totalPages = boardCount / BOARD_NUM;
			} else {
				totalPages = (boardCount / BOARD_NUM) + 1;
			}
			
			int navNum = 0;
			if(currentPage % NAV_NUM == 0) {
				navNum = (currentPage - 1) / NAV_NUM;
			} else {
				navNum = currentPage / NAV_NUM;
			}
			startPage = (navNum * NAV_NUM) + 1;
			endPage = startPage + (NAV_NUM - 1);
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
	
	public int getBoardCount() {
		return boardCount;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public boolean hasNoBoard() {
		return boardCount == 0;
	}
	
	public boolean hasBoard() {
		return boardCount > 0;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [boardCount=" + boardCount + ", currentPage=" + currentPage + ", totalPages=" + totalPages
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
}
