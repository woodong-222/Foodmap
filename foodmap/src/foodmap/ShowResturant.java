package foodmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowResturant extends JPanel { // 가게 정보 출력해주는 클래스
	
	private JLabel namelabel;
	
	public ShowResturant(Foodmap foodmap, Resturant r) {
		setLayout(null);
		setBounds(0, 0, 360, 500);

		namelabel = new JLabel(r.GetName()+" 정보");
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		namelabel.setBounds(0, 0, 360, 72);
		add(namelabel);
		repaint();
	}
	/*
	@Override
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//super.paintComponent(g);
		//Graphics g = getGraphics();
		
		if (restaurant != null) {
            // 가게 정보 그래픽 처리
            g.setColor(Color.black);
            g.drawString(restaurant.GetName() + " 정보", 0, 0);

            // 별점 출력
            //ShowStar(restaurant, g);

            // 가게 사진 출력
            //ShowPhoto(restaurant, g);

            // 가게 메뉴 출력
            //ShowMenu(restaurant, g);
        } else {
            // restaurant이 null일 때의 처리 (예: 오류 메시지 출력 등)
            g.setColor(Color.red);
            g.drawString("가게 정보를 찾을 수 없습니다.", 0, 0);
        }
		
		// 가게 정보 그래픽 처리
        //g.setColor(Color.black);
        //g.drawString(restaurant.GetName() + " 정보", 0, 0); // 좌표설정 아직안함
		//g.drawString(r.GetBussinessHour(), , ABORT);
		//g.drawString(r.GetTel(), ALLBITS, ABORT);
		//g.drawString(r.GetRestday(), ALLBITS, ABORT);
	}
	*/

	void ShowStar(Resturant r, Graphics g) { // 가게 별점 출력
		Image Star0 = new ImageIcon(Main.class.getResource("../images/zero.png")).getImage(); // 별사진 받기
		Image Star05 = new ImageIcon(Main.class.getResource("../images/helf.png")).getImage();
		Image Star1 = new ImageIcon(Main.class.getResource("../images/one.png")).getImage();

		if (r.GetStar() == 5.0) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star1, 73, 225, null);
			g.drawImage(Star1, 107, 225, null);
			g.drawImage(Star1, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);

		} else if (r.GetStar() >= 4.5 && r.GetStar() < 5.0) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star1, 73, 225, null);
			g.drawImage(Star1, 107, 225, null);
			g.drawImage(Star05, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 4.0 && r.GetStar() < 4.5) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star1, 73, 225, null);
			g.drawImage(Star1, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 3.5 && r.GetStar() < 4.0) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star1, 73, 225, null);
			g.drawImage(Star05, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 3.0 && r.GetStar() < 3.5) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star1, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 2.5 && r.GetStar() < 3.0) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star05, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 2.0 && r.GetStar() < 2.5) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star1, 39, 225, null);
			g.drawImage(Star0, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 1.5 && r.GetStar() < 2.0) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star05, 39, 225, null);
			g.drawImage(Star0, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 1.0 && r.GetStar() < 1.5) {
			g.drawImage(Star1, 5, 225, null);
			g.drawImage(Star0, 39, 225, null);
			g.drawImage(Star0, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 0.5 && r.GetStar() < 1.0) {
			g.drawImage(Star05, 5, 225, null);
			g.drawImage(Star0, 39, 225, null);
			g.drawImage(Star0, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		} else if (r.GetStar() >= 0.0 && r.GetStar() < 0.5) {
			g.drawImage(Star0, 5, 225, null);
			g.drawImage(Star0, 39, 225, null);
			g.drawImage(Star0, 73, 225, null);
			g.drawImage(Star0, 107, 225, null);
			g.drawImage(Star0, 141, 225, null);
			g.drawString(r.GetStar() + "/ 5.0", 180, 225);
		}
	}

	void ShowPhoto(Resturant r, Graphics g) { // 가게 사진 출력하기
		g.drawImage(r.GetPhoto(), 0, 72, 360, 150, null);
	}

	void ShowMenu(Resturant r, Graphics g) { // 가게 메뉴 출력하기
		g.drawImage(r.GetMenu(), 0, 72, 360, 150, null);
	}

}
