package foodmap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ShowRestaurant extends JPanel { // 가게 정보 출력해주는 클래스
	
	private JLabel namelabel;
	private JButton reviewButton; // 리뷰 보기 버튼
	private Restaurant restaurant; // Restaurant 인스턴스
	private JButton menuButton; // 리뷰 보기 버튼
    private boolean showReviewState = false; // 리뷰 표시 상태를 추적합니다.
	
	public ShowRestaurant(Foodmap foodmap, Restaurant r) {
		setLayout(null);
		setBounds(0, 0, 360, 500);

		this.restaurant = r; // Restaurant 인스턴스를 저장합니다.

		namelabel = new JLabel(r.GetName()+" 정보");
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		namelabel.setBounds(0, 0, 360, 72);
		add(namelabel);
		repaint();
		
		// 리뷰 보기 버튼을 생성하고 추가합니다.
        reviewButton = new JButton("리뷰 보기");
        reviewButton.setBounds(0, 300, 120, 30); // 버튼 위치와 크기 설정
        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	showReviewState = !showReviewState; // 상태 토글
                repaint(); // 패널을 다시 그려 리뷰를 표시합니다.
            }
        });
        add(reviewButton);
	}
	
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
            ShowStar(restaurant, g);

            // 가게 사진 출력
            ShowPhoto(restaurant, g);

            // 가게 메뉴 출력
            ShowMenu(restaurant, g);
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
		if (restaurant != null && restaurant.getReviews() != null) {
			ShowReview(g, restaurant.getReviews());
        }
	}
	

	
	
	void ShowStar(Restaurant r, Graphics g) { // 가게 별점 출력
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

	void ShowPhoto(Restaurant r, Graphics g) { // 가게 사진 출력하기
		g.drawImage(r.GetPhoto(), 0, 72, 360, 150, null);
	}

	void ShowMenu(Restaurant r, Graphics g) { // 가게 메뉴 출력하기
		g.drawImage(r.GetMenu(), 0, 72, 360, 150, null);
	}
	void ShowReview(Graphics g, Map<String, String> reviews) {
        int y = 350; // 시작 y 좌표
        for (Map.Entry<String, String> entry : reviews.entrySet()) {
            String user = entry.getKey();
            String review = entry.getValue();
            g.drawString(user + ": " + review, 10, y);
            y += 15; // 다음 리뷰를 위해 y 좌표를 증가
        }
    }

}
