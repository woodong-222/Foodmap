package foodmap;
import java.awt.Image;


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
	private Image bigMenu;
	private Image bigPhoto;
	private int cnt = 0;	
    private String reviewpath; // 리뷰를 저장할 메모장의 경로

	public Restaurant(int Type, String Name, String BussinessHour, String Tel, String Restday, String Address, String reviewpath) {//생성자로 가게 기본 정보 입력받음
		this.Type = Type;
		this.Name = Name;
		this.BussinessHour = BussinessHour;
		this.Tel = Tel;
		this.Restday = Restday;
		this.Address = Address;
		this.reviewpath = reviewpath;
	}
	
	public String getaddress() {
		return Address;
	}
	
	public String getreivewpath() {
		return reviewpath;
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
	
	void ShowReview() {//리뷰 보여주기
		
		
	}
	void WriteReview() {//리뷰 쓰기
		
	}
	
	
}


