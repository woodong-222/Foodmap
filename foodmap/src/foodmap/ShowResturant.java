package foodmap;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ShowResturant extends JPanel{ //가게 정보 출력해주는 클래스
	
	protected void ShowInfo(Resturant r, Graphics g) { //가게 정보 출력
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawString(r.GetName()+" 정보", ALLBITS, ABORT); //좌표설정 아직안함
		g.drawString(r.GetBussinessHour(), ALLBITS, ABORT);
		g.drawString(r.GetTel(), ALLBITS, ABORT);
		g.drawString(r.GetRestday(), ALLBITS, ABORT);
	}
	
	void ShowStar(Resturant r, Graphics g) { //가게 별점 출력
		Image Star0 = new ImageIcon(Main.class.getResource("")).getImage(); //별사진 받기
		Image Star05 = new ImageIcon(Main.class.getResource("")).getImage();
		Image Star1 = new ImageIcon(Main.class.getResource("")).getImage();
		
		if(r.GetStar() == 5.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star1, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
			
			
		}
		else if(r.GetStar() >= 4.5 && r.GetStar() < 5.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star05, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 4.0 && r.GetStar() < 4.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star1, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 3.5 && r.GetStar() < 4.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star05, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}		
		else if(r.GetStar() >= 3.0 && r.GetStar() < 3.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star1, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 2.5 && r.GetStar() < 3.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star05, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 2.0 && r.GetStar() < 2.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star1, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 1.5 && r.GetStar() < 2.0) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star05, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 1.0 && r.GetStar() < 1.5) {
			g.drawImage(Star1, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 0.5 && r.GetStar() < 1.0) {
			g.drawImage(Star05, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
		else if(r.GetStar() >= 0.0 && r.GetStar() < 0.5) {
			g.drawImage(Star0, 350, 5, null);
			g.drawImage(Star0, 350, 39, null);
			g.drawImage(Star0, 350, 73, null);
			g.drawImage(Star0, 350, 107, null);
			g.drawImage(Star0, 350, 141, null);
			g.drawString(r.GetStar()+ "/ 5.0", ALLBITS, ABORT);
		}
	}
	
	void ShowPhoto(Resturant r, Graphics g) { //가게 사진 출력하기
		g.drawImage(r.GetPhoto(), 0, 144, 360, 200, null);
	}
	
	void ShowMenu(Resturant r, Graphics g) { // 가게 메뉴 출력하기
		g.drawImage(r.GetMenu(), 0, 144, 360, 200, null);
	}
	
}
