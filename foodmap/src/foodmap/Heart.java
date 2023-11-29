package foodmap;

import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;

public class Heart {
   HashMap<String, String> HeartList = new HashMap <String, String> ();
   
   void Like(Restaurant r) { 
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
   
   void Share(Graphics g) {//파일입출력으로 구현
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter("찜리스트.txt"))) {
           Iterator<String> keys = HeartList.keySet().iterator();
           while (keys.hasNext()) {
               String key = keys.next();
               writer.write("[가게 이름]:" + key + " [주소]:" + HeartList.get(key));
               writer.newLine();
           }
           g.drawString("찜리스트가 성공적으로 저장되었습니다.", 0, 0);
         
       } catch (IOException e) {
    	   g.drawString("오류 발생" + e.getMessage(), 0, 0);
       }
   }
}