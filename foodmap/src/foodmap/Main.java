package foodmap;

import java.util.Vector;

public class Main {

	public static final int SCREEN_WIDTH = 1060;
	public static final int SCREEN_HEIGHT = 500;

	static Vector<Resturant> V = new Vector<Resturant>();
	
	private static Main main_instance = null;
	   
	   private Main() {}
	   public static Main getInstance() {
	      if(main_instance == null) {
	         main_instance = new Main();
	         main_instance.initializeData();
	      }
	      return main_instance;
	   }
	   
	   public static void main(String[] args) {
		      new Foodmap();
		   }

	public void initializeData() {
		Resturant Wang = new Resturant(1, "왕십리 야식", "11:00~23:00", "041-564-2848", "연중무휴", "충남 천안시 동남구 병천면 병천리 162-1");// 객체
		// 찍기
		Wang.SetMenu("../images/wang.png");// 메뉴사진등록
		Wang.SetPhoto("../images/store.png");// 가게사진 등록

		Resturant Jeulgyeo = new Resturant(2, "즐겨먹기", "11:00~20:00", "041-522-0122", "매주 토요일",
				"충남 천안시 동남구 병천면 충절로 1578");
		Jeulgyeo.SetMenu("../images/jeulgyeo.png");
		Jeulgyeo.SetPhoto("../images/jeulgyeo.store.png");

		Resturant Hansot = new Resturant(3, "한솥도시락", "09:00~21:00", "041-523-1123", "연중무휴",
				"충남 천안시 동남구 병천면 가전리 177-15");
		Hansot.SetMenu("../images/hansot.png");
		Hansot.SetPhoto("../images/hansot.store.png");

		Resturant Sseony = new Resturant(4, "써니숯불도시락", "11:00~20:30", "041-554-8951", "연중무휴",
				"충남 천안시 동남구 병천면 가전리 206-3");
		Sseony.SetMenu("../images/sseony.png");
		Sseony.SetPhoto("../images/store.png");

		Resturant Chowon = new Resturant(5, "초원", "17:00~04:00", "041-569-4404", "연중무휴", "충남 천안시 동남구 병천면 가전8길 81");
		Chowon.SetMenu("../images/chowon.png");
		Chowon.SetPhoto("../images/store.png");

		Resturant Yong = new Resturant(6, "용짬뽕", "10:00~20:20", "041-908-9080", "매주 화요일", "충남 천안시 동남구 병천면 충절로 1578");
		Yong.SetMenu("../images/yong.png");
		Yong.SetPhoto("../images/yong.store.png");

		Resturant Soosin = new Resturant(7, "수신반점", "11:00~15:00", "041-522-3722", "매주 월요일", "충남 천안시 동남구 병천면 충절로 1614");
		Soosin.SetMenu("../images/soosin.png");
		Soosin.SetPhoto("../images/soosin.store.png");

		Resturant Bohwa = new Resturant(8, "보화 중화요리", "10:00~20:00", "041-569-3703", "정보 미등록",
				"충남 천안시 동남구 병천면 충절로 1700");
		Bohwa.SetMenu("../imajes/bohwa.png");
		Bohwa.SetPhoto("../imajes/store.png");

		Resturant Yogit = new Resturant(9, "요깃", "10:30~14:30", "0507-1370-7998", "매주 주말", "충남 천안시 동남구 병천면 가전7길 4");
		Yogit.SetMenu("../images/yogit.png");
		Yogit.SetPhoto("../images/yogit.store.png");

		Resturant Sinjeon = new Resturant(10, "신전떡볶이", "11:00~23:40", "041-552-5512", "매주 토요일",
				"충남 천안시 동남구 병천면 가전6길 6");
		Sinjeon.SetMenu("../images/sinjeon.png");
		Sinjeon.SetPhoto("../images/sinjeon.store.png");

		Resturant Well = new Resturant(11, "웰돈카츠", "11:00~20:40", "0508-8189-8646", "정보 미등록", "충남 천안시 동남구 병천면 병천리 294");
		Well.SetMenu("../images/well.png");
		Well.SetPhoto("../images/well.store.png");

		V.add(Wang);// 객체 만들었으면 벡터에 추가하기
		V.add(Jeulgyeo);
		V.add(Hansot);
		V.add(Sseony);
		V.add(Chowon);
		V.add(Yong);
		V.add(Soosin);
		V.add(Bohwa);
		V.add(Yogit);
		V.add(Sinjeon);
		V.add(Well);
		
		Vector<Resturant> K = new Vector<Resturant>(); // 한식 리스트 저장
		Vector<Resturant> W = new Vector<Resturant>(); // 양식 리스트 저장
		Vector<Resturant> C = new Vector<Resturant>(); // 중식 리스트 저장
		Vector<Resturant> J = new Vector<Resturant>(); // 일식 리스트 저장
		Vector<Resturant> S = new Vector<Resturant>(); // 분식 리스트 저장

		for (int i = 0; i < V.size(); i++) {
			if (V.get(i).GetType() == 1) {
				K.add(V.get(i));
			} else if (V.get(i).GetType() == 2) {
				C.add(V.get(i));
			} else if (V.get(i).GetType() == 3) {
				J.add(V.get(i));
			} else if (V.get(i).GetType() == 4) {
				W.add(V.get(i));
			} else if (V.get(i).GetType() == 5) {
				S.add(V.get(i));
			}
		}
	}

	public Resturant getResturantInfo(String name) {
		// 벡터에 저장된 가게 정보를 조회하면서 이름이 일치하는 가게를 찾아 반환
		for (Resturant r : V) {
			if (r.GetName().equals(name)) {
				return r;
			}
		}

		// 일치하는 가게를 찾지 못한 경우, 적절한 처리를 수행하거나 예외를 던질 수 있음
		return null; // 예시로 null 반환
	}
}