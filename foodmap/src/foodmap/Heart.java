package foodmap;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Heart extends JPanel {
   HashMap<String, String> HeartList = new HashMap <String, String> ();
   private JLabel namelabel;
   private JButton sharebutton;
   private JButton[] likedbutton = new JButton[10];
   Foodmap f;
   
   public Heart(Foodmap foodmap) {
       for (int i = 0; i < 10; i++) {
           likedbutton[i] = new JButton(); // 버튼 초기화
       }
       f = foodmap;
   }
   
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
   
   void ShowHeartList() { // 찜목록 출력
	   setLayout(null);
	   setBounds(0, 0, 360, 500);
	   namelabel = new JLabel("찜리스트");
	   namelabel.setHorizontalAlignment(JLabel.CENTER);
	   namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
	   namelabel.setBounds(0, 0, 360, 72);
	   
	   add(namelabel);
	   Iterator<String> keys = HeartList.keySet().iterator();
	   
	   for(int i=0; i<10; i++) {
		   if(keys.hasNext() == false) break;
		   likedbutton[i].setBounds(10, 72 + i * 40, 280, 30);//좌표설정할거임
		   String key = keys.next();
		   likedbutton[i].setText("[가게 이름]:" + key + " [주소]:" +  HeartList.get(key));
		   
		   likedbutton[i].addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {//버튼 눌렀을 때
		        	if (!HeartList.isEmpty()) {
		        	    Set<String> keySet = HeartList.keySet();
		        	    Iterator<String> keyIterator = keySet.iterator();		        	    
		        	    f.changerest(keyIterator.next());
		        	}
		        }
		    });
		   
		   add(likedbutton[i]);
	       
	   }
	   
	   
		sharebutton = new JButton("공유");
		// sharebutton.setBorderPainted(false);
		// sharebutton.setContentAreaFilled(false);
		// sharebutton.setFocusPainted(false);
		sharebutton.setBounds(288, 72, 32, 32); // 버튼 위치와 크기 설정
		sharebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				sharebutton.setText("공유2");
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				sharebutton.setText("공유1");
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 공유기능
				Share();
			}
		});	   
   }
   
   
   
   
   void Share() {//파일입출력으로 구현
	   try (BufferedWriter writer = new BufferedWriter(new FileWriter("찜리스트.txt"))) {
           Iterator<String> keys = HeartList.keySet().iterator();
           while (keys.hasNext()) {
               String key = keys.next();
               writer.write("[가게 이름]:" + key + " [주소]:" + HeartList.get(key));
               writer.newLine();
           }
           //g.drawString("찜리스트가 성공적으로 저장되었습니다.", 0, 0);
         
       } catch (IOException e) {
    	   //g.drawString("오류 발생" + e.getMessage(), 0, 0);
       }
   }
}