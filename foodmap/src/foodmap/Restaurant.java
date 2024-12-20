package foodmap;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

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
	private Image bigMenu;
	private Image bigPhoto;
	private int cnt = 0;	
	private Map<String, ReviewData> reviews; // 리뷰를 저장할 해시맵

	public Restaurant(int Type, String Name, String BussinessHour, String Tel, String Restday, String Address){//생성자로 가게 기본 정보 입력받음
		this.Type = Type;
		this.Name = Name;
		this.BussinessHour = BussinessHour;
		this.Tel = Tel;
		this.Restday = Restday;
		this.Address = Address;
		this.reviews = new HashMap<>();
	}
	
	public String getaddress() {
		return Address;
	}
	
	// ReviewData 클래스로 리뷰와 별점을 묶어서 관리합니다.
    public static class ReviewData {
        String review;
        double stars;

        public ReviewData(String review, double stars) {
            this.review = review;
            this.stars = stars;
        }
    }

    public Map<String, ReviewData> getReviews() {
        return reviews;
    }
	
	void Evaluate(double Star) { //별점 주기
		double sum = this.Star * cnt;
		sum += Star;
		cnt++;
		this.Star = sum / cnt;
		return;
	}
	
	 public double calculateAverageStars() {
	        Map<String, ReviewData> reviews = getReviews();
	        if (reviews.isEmpty()) {
	            return 0.0; // 리뷰가 없을 경우 0을 반환합니다.
	        }

	        double sumStars = 0.0;
	        for (ReviewData reviewData : reviews.values()) {
	            sumStars += reviewData.stars;
	        }

	        return sumStars / reviews.size();
	    }
	 
	 
	double GetStar() {
		return Star;
	}	
	
	void SetLike(boolean like) { //좋아요 입력
		this.Like = like;
		return;
	}
	
	boolean GetLike() { //좋아요 반환
		return Like;
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
	
	void Share() { //파일 입출력을 이용해 메모장에 가게 정보 입력	// 파일입출력으로 구현
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("맛집정보.txt"))) {
			String infor = "[가게 이름] : " + this.GetName() + "\n[가게 주소] : " + this.getaddress()
					+ "\n[영업 시간] : " + this.GetBussinessHour() + "\n[가게 이름] : " + this.GetName()
					+ "\n[휴무일] : " + this.GetRestday() + "\n[별점] : " + this.GetStar() + "\n[전화번호] : "
					+ this.GetTel();
			writer.write(infor);

			Sharefinsh sharefinsh = new Sharefinsh();
			sharefinsh.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			sharefinsh.setVisible(true);

		} catch (IOException e) {
			// g.drawString("오류 발생" + e.getMessage(), 0, 0);
		}
	
	}
	void SetMenu( String menu ) { //가게 메뉴 입력받기
		Menu = new ImageIcon(Main.class.getResource(menu)).getImage();
	}
	
	void SetPhoto ( String photo) {//가게 사진 입력받기
		Photo = new ImageIcon(Main.class.getResource(photo)).getImage();
	}
	void SetbigMenu( String menu ) { //가게 메뉴 입력받기
		bigMenu = new ImageIcon(Main.class.getResource(menu)).getImage();
	}
	
	void SetbigPhoto ( String photo) {//가게 사진 입력받기
		bigPhoto = new ImageIcon(Main.class.getResource(photo)).getImage();
	}
	
	public Image GetMenu() {
		return Menu;
	}
	public Image GetPhoto() {
		return Photo;
	}
	public Image GetbigMenu() {
		return bigMenu;
	}
	public Image GetbigPhoto() {
		return bigPhoto;
	}
	
	
}



