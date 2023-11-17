package foodmap;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;

abstract class Share{
	abstract void Share();
}

public class Resturant extends Share {
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
	Resturant(int Type, String Name, String BussinessHour, String Tel, String Restday, String Address){//생성자로 가게 기본 정보 입력받음
		this.Type = Type;
		this.Name = Name;
		this.BussinessHour = BussinessHour;
		this.Tel = Tel;
		this.Restday = Restday;
		this.Address = Address;
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
		this.Star = Star / cnt;
		return;
	}
	
	int GetType() {
		return Type;
	}
	
	String GetAddress() {
		return Address;
	}
	
	String GetName() {
		return Name;
	}
	
	void Share() { //파일 입출력을 이용해 메모장에 가게 정보 입력
		
	}
	
	void ShowStar(Graphics g) {
		Image Star0 = new ImageIcon(Main.class.getResource("")).getImage(); //별사진 받기
		Image Star05 = new ImageIcon(Main.class.getResource("")).getImage();
		Image Star1 = new ImageIcon(Main.class.getResource("")).getImage();
		
		if(Star == 5.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star1, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
			
		}
		else if(Star >= 4.5 && Star < 5.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star05, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 4.0 && Star < 4.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 3.5 && Star < 4.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star05, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}		
		else if(Star >= 3.0 && Star < 3.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 2.5 && Star < 3.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star05, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 2.0 && Star < 2.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 1.5 && Star < 2.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star05, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 1.0 && Star < 1.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 0.5 && Star < 1.0) {
			g.drawImage(Star05, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
		else if(Star >= 0.0 && Star < 0.5) {
			g.drawImage(Star0, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			System.out.println(this.Star + "/ 5.0"); // 출력 고쳐야 할듯
		}
	}
	void ShowInfo(){//정보 출력하기
		System.out.println("가게 정보");
		System.out.println("영업 시간 :" + BussinessHour );
		System.out.println("전화 번호 :" + Tel);
		System.out.println("휴 무 일 :" + Restday);
	}
	void SetMenu( String menu ) { //가게 메뉴 입력받기
		Menu = new ImageIcon(Main.class.getResource(menu)).getImage();
	}
	void ShowMenu(Graphics g) { // 가게 메뉴 출력하기
		g.drawImage(Menu, 0, 144, 360, 200, null);
	}
	void SetPhoto ( String photo) {//가게 사진 입력받기
		Photo = new ImageIcon(Main.class.getResource(photo)).getImage();
	}
	void ShowPhoto(Graphics g) { //가게 사진 출력하기
		g.drawImage(Photo, 0, 144, 360, 200, null);
	}
	
	void ShowReview() {//리뷰 보여주기
		
	}
	void WriteReview() {//리뷰 쓰기
		
	}
	
}

