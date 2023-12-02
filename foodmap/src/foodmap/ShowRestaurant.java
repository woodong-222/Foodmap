package foodmap;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowRestaurant extends JPanel { // 가게 정보 출력해주는 클래스

	private JButton likedbutton; // 리뷰 보기 버튼
	private JButton sharebutton; // 메뉴판 보기 버튼
	private JLabel namelabel;
	private JLabel photolabel;
	private JButton reviewbutton; // 리뷰 보기 버튼
	private JButton menubutton; // 메뉴판 보기 버튼

	private JTextArea text; // 주소

	private Restaurant restaurant; // Restaurant 인스턴스

	boolean isphoto = true;
	boolean isinfor = true;
	boolean isliked = true;

	public ShowRestaurant(Foodmap foodmap, Restaurant r) {
		setLayout(null);
		setBounds(0, 0, 360, 500);

		this.restaurant = r; // Restaurant 인스턴스를 저장합니다.

		// 가게 이름
		namelabel = new JLabel(r.GetName() + " 정보");
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		namelabel.setBounds(0, 0, 360, 72);
		add(namelabel);

		// 공유 버튼을 생성하고 추가합니다.
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

			}
		});

		// 좋아요 버튼을 생성하고 추가합니다.
		likedbutton = new JButton("좋아요1");
		// likedbutton.setBorderPainted(false);
		// likedbutton.setContentAreaFilled(false);
		// likedbutton.setFocusPainted(false);
		likedbutton.setBounds(323, 72, 32, 32); // 버튼 위치와 크기 설정
		likedbutton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				if (isliked) {
					likedbutton.setText("안좋아요2");
				} else {
					likedbutton.setText("좋아요2");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				if (isliked) {
					likedbutton.setText("안좋아요1");
				} else {
					likedbutton.setText("좋아요1");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				if (isliked) {
					likedbutton.setText("좋아요2");
					// ImageIcon menu = new ImageIcon(r.GetMenu());
					// photolabel.setIcon(menu);
					// 좋아요 해제 기능

					isliked = false;
				} else {
					likedbutton.setText("안좋아요2");
					// ImageIcon photo = new ImageIcon(r.GetPhoto());
					// photolabel.setIcon(photo);
					// 좋아요 하기 기능

					isliked = true;
				}
			}
		});

		add(sharebutton); // 공유 버튼 출력
		add(likedbutton); // 좋아요 버튼 출력

		// 가게 사진
		ImageIcon photo = new ImageIcon(r.GetPhoto());
		photolabel = new JLabel(photo);
		photolabel.setBounds(0, 72, 360, 150);

	

		// 가게 정보
		text = new JTextArea("\n\n -영업시간 : " + r.GetBussinessHour() + "\n\n -전화번호 : " + r.GetTel() + "\n\n -휴무일 : " + r.GetRestday()+"\n\n -주소 : " + r.GetAddress());
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		//text.setHorizontalAlignment(JLabel.LEFT);
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		text.setBounds(0, 222, 360, 420);


		// 메뉴판 보기 버튼을 생성하고 추가합니다.
		menubutton = new JButton(new ImageIcon(Main.class.getResource("../images/menu.png")));
		menubutton.setBorderPainted(false);
		menubutton.setContentAreaFilled(false);
		menubutton.setFocusPainted(false);
		menubutton.setBounds(0, 428, 180, 72); // 버튼 위치와 크기 설정
		menubutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				if (isphoto) {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/menu2.png")));
				} else {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/photo2.png")));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				if (isphoto) {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/menu.png")));
				} else {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/photo.png")));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				if (isphoto) {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/photo2.png")));
					ImageIcon menu = new ImageIcon(r.GetMenu());
					photolabel.setIcon(menu);
					isphoto = false;
				} else {
					menubutton.setIcon(new ImageIcon(Main.class.getResource("../images/menu2.png")));
					ImageIcon photo = new ImageIcon(r.GetPhoto());
					photolabel.setIcon(photo);
					isphoto = true;
				}
			}
		});

		JButton submitButton = new JButton("Submit Review");
        submitButton.setBounds(323, 227, 32, 32);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Review reviewDialog = new Review();
                reviewDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                reviewDialog.setVisible(true);
            }
        });
        add(submitButton);
		submitButton.setVisible(false);
        
		// 리뷰 보기 버튼을 생성하고 추가합니다.
		reviewbutton = new JButton(new ImageIcon(Main.class.getResource("../images/review.png")));
		reviewbutton.setBorderPainted(false);
		reviewbutton.setContentAreaFilled(false);
		reviewbutton.setFocusPainted(false);
		reviewbutton.setBounds(180, 428, 180, 72); // 버튼 위치와 크기 설정
		reviewbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				if (isinfor) {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/review2.png")));
				} else {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/infor2.png")));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				if (isinfor) {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/review.png")));
				} else {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/infor.png")));
				}
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				if (isinfor) {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/infor2.png")));
					// 가게 정보 넣기
					submitButton.setVisible(true);
					text.setVisible(false);
					repaint();
					isinfor = false;
				} else {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/review2.png")));
					// 리뷰 넣기
					
					//리뷰쓰기가 필요 -> 여기서 별점
					
					submitButton.setVisible(false);
					
			        // 여기에 버튼을 표시하는 코드 추가
			        // 예를 들어, 버튼을 생성하고 패널에 추가하는 코드를 아래와 같이 작성할 수 있습니다.
					text.setVisible(true);
			        
                             
					
					repaint();
					isinfor = true;
				}

			}
		});

		add(photolabel); // 가게 사진 출력
		add(menubutton); // 메뉴 버튼 출력
		add(reviewbutton); // 리뷰 버튼 출력

		add(text);
		repaint();
	}
	/*
	 * @Override protected void paintComponent(Graphics g) {
	 * super.paintComponent(g); //super.paintComponent(g); //Graphics g =
	 * getGraphics();
	 * 
	 * if (restaurant != null) { // 가게 정보 그래픽 처리 g.setColor(Color.black);
	 * g.drawString(restaurant.GetName() + " 정보", 0, 0);
	 * 
	 * // 별점 출력 ShowStar(restaurant, g);
	 * 
	 * // 가게 사진 출력 ShowPhoto(restaurant, g);
	 * 
	 * // 가게 메뉴 출력 ShowMenu(restaurant, g); } else { // restaurant이 null일 때의 처리 (예:
	 * 오류 메시지 출력 등) g.setColor(Color.red); g.drawString("가게 정보를 찾을 수 없습니다.", 0, 0);
	 * }
	 * 
	 * // 가게 정보 그래픽 처리 //g.setColor(Color.black);
	 * //g.drawString(restaurant.GetName() + " 정보", 0, 0); // 좌표설정 아직안함
	 * //g.drawString(r.GetBussinessHour(), , ABORT); //g.drawString(r.GetTel(),
	 * ALLBITS, ABORT); //g.drawString(r.GetRestday(), ALLBITS, ABORT); if
	 * (restaurant != null && restaurant.getReviews() != null) { ShowReview(g,
	 * restaurant.getReviews()); } }
	 */

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
