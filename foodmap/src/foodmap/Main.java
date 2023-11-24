package foodmap;
import foodmap.Resturant;
import java.util.Vector;

public class Main {
   
   public static final int SCREEN_WIDTH = 1060;
   public static final int SCREEN_HEIGHT = 500;
   
   public static void main(String[] args) {
      new Foodmap();
      
      Resturant Wang = new Resturant(1, "왕십리 야식", "11:00~23:00", "041-564-2848", "연중무휴", "충남 천안시 동남구 병천면 병천리 162-1");//객체 찍기
      Wang.SetMenu("../images/wang.jpg");//메뉴사진등록
      Wang.SetPhoto("사진 url");//가게사진 등록
      
      Resturant Jeulgyeo = new Resturant(2, "즐겨먹기", "11:00~20:00", "041-522-0122", "매주 토요일", "충남 천안시 동남구 병천면 충절로 1578");
      Jeulgyeo.SetMenu("jeulgyeo");
      Jeulgyeo.SetPhoto("사진 url");
      
      Resturant Hansot = new Resturant(3, "한솥도시락", "09:00~21:00", "041-523-1123", "연중무휴", "충남 천안시 동남구 병천면 가전리 177-15");
      Hansot.SetMenu("hansot");
      Hansot.SetPhoto("사진 url");
      
      Resturant Sseony = new Resturant(4, "써니숯불도시락", "11:00~20:30", "041-554-8951", "연중무휴", "충남 천안시 동남구 병천면 가전리 206-3");
      Sseony.SetMenu("sseony");
      Sseony.SetPhoto("사진 url");
      
      Resturant Chowon = new Resturant(5, "초원", "17:00~04:00", "041-569-4404", "연중무휴", "충남 천안시 동남구 병천면 가전8길 81");
      Chowon.SetMenu("chowon");
      Chowon.SetPhoto("사진 url");
      
      Resturant Yong = new Resturant(6, "용짬뽕", "10:00~20:20", "041-908-9080", "매주 화요일", "충남 천안시 동남구 병천면 충절로 1578");
      Yong.SetMenu("yong");
      Yong.SetPhoto("사진 url");
      
      Resturant Soosin = new Resturant(7, "수신반점", "11:00~15:00", "041-522-3722", "매주 월요일", "충남 천안시 동남구 병천면 충절로 1614");
      Soosin.SetMenu("soosin");
      Soosin.SetPhoto("사진 url");
      
      Resturant Bohwa = new Resturant(8, "보화 중화요리", "10:00~20:00", "041-569-3703", "정보 미등록", "충남 천안시 동남구 병천면 충절로 1700");
      Bohwa.SetMenu("bohwa");
      Bohwa.SetPhoto("사진 url");
      
      Resturant Yogit = new Resturant(9, "요깃", "10:30~14:30", "0507-1370-7998", "매주 주말", "충남 천안시 동남구 병천면 가전7길 4");
      Yogit.SetMenu("yogit");
      Yogit.SetPhoto("사진 url");
      
      Resturant Sinjeon = new Resturant(10, "신전떡볶이", "11:00~23:40", "041-552-5512", "매주 토요일", "충남 천안시 동남구 병천면 가전6길 6");
      Sinjeon.SetMenu("sinjeon");
      Sinjeon.SetPhoto("사진 url");
      
      Resturant Well = new Resturant(11, "웰돈카츠", "11:00~20:40", "0508-8189-8646", "정보 미등록", "충남 천안시 동남구 병천면 병천리 294");
      Well.SetMenu("well");
      Well.SetPhoto("사진 url");
      
      Vector <Resturant> V = new Vector <Resturant> ();
      
      V.add(Wang);//객체 만들었으면 벡터에 추가하기
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
     
      Vector <Resturant> K = new Vector <Resturant> (); //한식 리스트 저장
      Vector <Resturant> W = new Vector <Resturant> (); //양식 리스트 저장
      Vector <Resturant> C = new Vector <Resturant> (); //중식 리스트 저장
      Vector <Resturant> J = new Vector <Resturant> (); // 일식 리스트 저장
      Vector <Resturant> S = new Vector <Resturant> (); //분식 리스트 저장

      for(int i = 0; i < V.size();i++) {
    	  if(V.get(i).GetType() == 1) {
    		  K.add(V.get(i));
    	  }
    	  else if (V.get(i).GetType()==2) {
    		  C.add(V.get(i));
    	  }
    	  else if (V.get(i).GetType()==3) {
    		  J.add(V.get(i));
    	  }
    	  else if (V.get(i).GetType()==4) {
    		  W.add(V.get(i));
    	  }
    	  else if (V.get(i).GetType()==5) {
    		  S.add(V.get(i));
    	  }
      }
      
      
      
   }
}