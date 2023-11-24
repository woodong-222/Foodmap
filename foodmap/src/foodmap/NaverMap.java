// 네이버 지도 API 불러들이기 가급적 수정 X

package foodmap;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import javax.swing.ImageIcon;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public class NaverMap implements ActionListener {

    private final String clientId = "7x94217qyn";
    private final String clientSecret = "9UbKbSWIOA1AQddHNN6AjbOdzksvDzS7g5hcmXEp";

    public static int mapsize = 16;
    
    Foodmap naverMap;
    
    public NaverMap(Foodmap naverMap) {
        this.naverMap = naverMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddressVO vo = null;

        try {
            String addr = URLEncoder.encode(naverMap.address, "UTF-8");
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
            URL url = new URL(apiURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONTokener tokener = new JSONTokener(response.toString());
            JSONObject object = new JSONObject(tokener);

            if (object.has("addresses")) {
                JSONArray arr = object.getJSONArray("addresses");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject temp = (JSONObject) arr.get(i);
                    vo = new AddressVO();
                    vo.setRoadAddress((String) temp.get("roadAddress"));
                    vo.setJibunAddress((String) temp.get("jibunAddress"));
                    vo.setX((String) temp.get("x"));
                    vo.setY((String) temp.get("y"));
                }
                map_service(vo);
            } 

        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void map_service(AddressVO vo) {
        String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

        try {
            String pos = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");
            URL_STATICMAP += "center=" + vo.getX() + "," + vo.getY();
            String staticmap1 = "&level=";
            String staticmap2 = "&w=700&h=500";
            String mapsizetoStr = String.valueOf(mapsize);
            URL_STATICMAP += (staticmap1 + mapsizetoStr + staticmap2); // 맵 크기 조절
            URL_STATICMAP += "&markers=type:t|size:mid|pos:" + pos
                    + "|label:" + URLEncoder.encode(vo.getRoadAddress(), "UTF-8");

            URL url = new URL(URL_STATICMAP);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

			InputStream is = con.getInputStream();

			int read = 0;
			byte[] bytes = new byte[1024];

			// 랜덤 파일명으로 파일 생성
			String tempName = Long.valueOf(new Date().getTime()).toString();
			File file = new File(tempName + ".jpg"); // 파일 생성.

			file.createNewFile();

			OutputStream out = new FileOutputStream(file);

			while ((read = is.read(bytes)) != -1) {
				out.write(bytes, 0, read); // 파일 작성
			}

			is.close();
			ImageIcon img = new ImageIcon(file.getName());
			naverMap.map.setIcon(img);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
