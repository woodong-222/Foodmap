package foodmap;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

abstract class Share{
	abstract void Share();
}

public class Restaurant extends Share {
	//가게의 멤버들
	private String Name;
	private String BussinessHour;
	private String Tel;
	private String Restday;
	private double Star = 0;
	private String Address;
	private int Type;
	private boolean Like = false;
	private Image Menu;
	private Image Photo;
	private int cnt = 0;	
    private Map<String, String> reviews; // 리뷰를 저장할 해시맵

	public Restaurant(int Type, String Name, String BussinessHour, String Tel, String Restday, String Address){//생성자로 가게 기본 정보 입력받음
		this.Type = Type;
		this.Name = Name;
		this.BussinessHour = BussinessHour;
		this.Tel = Tel;
		this.Restday = Restday;
		this.Address = Address;
		this.reviews = new HashMap<>();
	}
	
	public void addReview(String user, String review) {
        reviews.put(user, review);
    }

    public Map<String, String> getReviews() {
        return reviews;
    }
	
	void SetLike(boolean like) { //좋아요 입력
		this.Like = like;
		return;
	}
	boolean GetLike() { //좋아요 반환
		return Like;
	}
	
	void Evaluate(double Star) { //별점 주기
		double sum = this.Star * cnt;
		sum += Star;
		cnt++;
		this.Star = sum / cnt;
		return;
	}
	double GetStar() {
		return Star;
	}
	int GetType() {
		return Type;
	}
	String GetBussinessHour() {
		return BussinessHour;
	}
	String GetTel() {
		return Tel;
	}
	String GetRestday() {
		return Restday;
	}
	
	String GetAddress() {
		return Address;
	}
	
	String GetName() {
		return Name;
	}
	
	void Share() { //파일 입출력을 이용해 메모장에 가게 정보 입력	
	
	}
	void SetMenu( String menu ) { //가게 메뉴 입력받기
		Menu = new ImageIcon(Main.class.getResource(menu)).getImage();
	}
	
	void SetPhoto ( String photo) {//가게 사진 입력받기
		Photo = new ImageIcon(Main.class.getResource(photo)).getImage();
	}
	
	public Image GetMenu() {
		return Menu;
	}
	public Image GetPhoto() {
		return Photo;
	}
	
	void ShowReview() {//리뷰 보여주기
		
		
	}
	void WriteReview() {//리뷰 쓰기
		
	}
	
	
}



