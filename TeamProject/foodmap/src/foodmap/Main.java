package foodmap;
import foodmap.Resturant;
import java.util.Vector;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	
	public static void main(String[] args) {
		new Foodmap();
		
		Resturant GeoSung = new Resturant(1, "거성", "09:00~18:00", "010-0000-0000", "매주 월요일", "충절로1600");//객체 찍기
		GeoSung.SetMenu("사진 url");//메뉴사진등록
		GeoSung.SetPhoto("사진 url");//가게사진 등록
		//Resturant chowon = new Resturant(2, "초원", "09:00~18:00", "010-0000-0000", "매주 월요일", "충절로1600");
		//GeoSung.SetMenu("사진 url");
		//GeoSung.SetPhoto("사진 url");
		
		Vector <Resturant> V = new Vector <Resturant> ();
		V.add(GeoSung);//객체 만들었으면 벡터에 추가하기
		//V.add(chowon);
		//V.add(soosin);
		
	}
}
