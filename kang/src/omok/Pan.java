package omok;

public class Pan {
	private Piece[][] pan;
	private Piece dot;

	public Pan() {
		this.pan=new Piece[20][20];
		this.dot=new Piece(".");
		for(int i=0;i<20;i++) {
			pan[0][i]=new Piece(String.valueOf(i));
			pan[i][0]=new Piece(String.valueOf(i));
		}
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				pan[i][j]=this.dot;
			}
		}
	}
	
	public boolean insertion(int x, int y, Piece p) {
		if(this.pan[x][y]!=this.dot) {
			System.out.println("이미 놓인 자리입니다.");
			return false;
		}
		else{
			this.pan[x][y]=p;
			return true;
		}
	}

	public void print() {
		for(Piece[] x:pan) {
			for(Piece y:x) {
				System.out.printf("%2s", y.getPiece());
			}
			System.out.println();
		}
	}
	
	public Piece[][] getPan(){
		return this.pan;
	}
}
