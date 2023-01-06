package j12_배열Test;

// 숫자를 저장
public class Lotto {
	
	private int lottoNumber;
	private int myNumber;
	private int correctNumber;
	
	public Lotto(int lottoNumber, int myNumber, int correctNumber) {
		this.lottoNumber = lottoNumber;
		this.myNumber = myNumber;
		this.correctNumber = correctNumber;
	}

	public int getLottoNumber() {
		return lottoNumber;
	}

	public void setLottoNumber(int lottoNumber) {
		this.lottoNumber = lottoNumber;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public int getCorrectNumber() {
		return correctNumber;
	}

	public void setCorrectNumber(int correctNumber) {
		this.correctNumber = correctNumber;
	}

	@Override
	public String toString() {
		return "Lotto [lottoNumber=" + lottoNumber + ", myNumber=" + myNumber + ", correctNumber=" + correctNumber
				+ "]";
	}
	
	
	
	
	
}
