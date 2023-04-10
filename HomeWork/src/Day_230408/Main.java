package Day_230408;

import java.util.List;

class Board { // 질문 필수,,
	List<Comment> comments;
	
	public void addComment(Comment comment) { // 댓글 추가, 집합 연관(aggregation)
		this.comments.add(comment);
	}
}

class Comment {
	Board board;
	
	public void setBoard(Board board) {
		this.board = board;
		board.addComment(this);
	}
}

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		Comment comment = new Comment();
		
		comment.setBoard(board);
	}
}
