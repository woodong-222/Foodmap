package foodmap;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;

public class Heart {
   HashMap<String, String> HeartList = new HashMap <String, String> ();
   
   void AddHeart(Resturant r) { //좋아요 누르기 + 찜에 추가
      r.SetLike(true);
      HeartList.put(r.GetName(), r.GetAddress());
   }
   
   void DeleteHeart(Resturant r) { //좋아요 취소하기 + 찜에서 삭제
      r.SetLike(false);
      HeartList.remove(r.GetName());
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