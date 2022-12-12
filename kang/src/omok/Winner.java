package omok;

public class Winner {
	private Pan pan;
	private Piece piece;
	public Winner(Pan pan, Piece piece) {
		this.pan = pan;
		this.piece = piece;
	}
	public boolean win() {
		if(this.winX()||this.winY()||this.winZ()||this.winW()) return true;
		else return false;
	}
	
	private boolean winX() {
		int cnt=0;
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				if(this.pan.getPan()[i][j]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		return false;
	}
	private boolean winY() {
		int cnt=0;
		for(int i=1;i<20;i++) {
			for(int j=1;j<20;j++) {
				if(this.pan.getPan()[j][i]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		return false;
	}
	private boolean winZ() {
		int cnt=0;
		for(int i=1;i<20;i++) {
			cnt=0;
			for(int j=1;j<=i;j++) {
				if(this.pan.getPan()[j][i-j+1]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		cnt=0;
		for(int i=19;i>=2;i--) {
			cnt=0;
			for(int j=2;j<=i;j++) {
				if(this.pan.getPan()[j][i-j+2]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		return false;
	}
	private boolean winW() {
		int cnt=0;
		for(int i=19;i>=1;i--) {
			cnt=0;
			for(int j=1;j<=i;j++) {
				if(this.pan.getPan()[j][19-i+j]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		cnt=0;
		for(int i=1;i<=18;i++) {
			cnt=0;
			for(int j=i+1;j<=19;j++) {
				if(this.pan.getPan()[j][j-i]==this.piece) cnt++;
				else cnt=0;
				if(cnt==5) return true;
			}
		}
		return false;
	}
}
