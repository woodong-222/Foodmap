package foodmap;
import foodmap.Main;
import java.util.*;
import foodmap.Resturant;

public class Heart {
	HashMap<String, String> HeartList = new HashMap <String, String> ();
	
	void AddHeart(Resturant r) { //찜에 추가
		if(r.GetLike() == true) {
			HeartList.put(r.GetName(), r.GetAddress());
		}
	}
	
	void DeleteHeart(Resturant r) { //찜에서 삭제
		if(r.GetLike() == false) {
			HeartList.remove(r.GetName());
		}
	}
	
	void PrintHeartList() { // 찜목록 출력
		Iterator<String> keys = HeartList.keySet().iterator();
		while(keys.hasNext()){
		    String key = keys.next();
		    System.out.println("[가게 이름]:" + key + " [주소]:" +  HeartList.get(key));
		}
	}
	
	void Share() {//파일입출력으로 구현할 예정
		
	}
}
