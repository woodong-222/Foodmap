package foodmap;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;

public class Heart {
   HashMap<String, String> HeartList = new HashMap <String, String> ();
   
   void Like(Resturant r) { 
		if(r.GetLike()== false) {//좋아요 안눌려있을 때
			r.SetLike(true); //좋아요 누른 상태로 변경 
			HeartList.put(r.GetName(), r.GetAddress());//찜 리스트에 추가
		}
		else if (r.GetLike()== true) {//좋아요 눌려있을때
			r.SetLike(false);//좋아요 안누른 상태로 변경
			HeartList.remove(r.GetName()); //찜 리스트 빼기
		}
	}
   
   void PrintHeartList(Graphics g) { // 찜목록 출력
      Iterator<String> keys = HeartList.keySet().iterator();
      while(keys.hasNext()){
          String key = keys.next();
          g.drawString("[가게 이름]:" + key + " [주소]:" +  HeartList.get(key), 0, 0);
      }
   }
   
   void Share() {//파일입출력으로 구현할 예정
      
   }
}