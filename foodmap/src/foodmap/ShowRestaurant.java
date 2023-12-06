package foodmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowRestaurant extends JPanel { // 가게 정보 출력해주는 클래스

	static HashMap<String, String> Restaurantinfor = new HashMap<String, String>();
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

	public ShowRestaurant(Foodmap foodmap, Restaurant r) {
		setLayout(null);
		setBounds(0, 0, 360, 500);
		setBackground(Color.WHITE);

		this.restaurant = r; // Restaurant 인스턴스를 저장합니다.

		JLabel line = new JLabel(new ImageIcon(Main.class.getResource("../images/line.png")));
		JLabel line2 = new JLabel(new ImageIcon(Main.class.getResource("../images/line.png")));
		line.setBounds(0, 70, 360, 2);
		add(line);
		line2.setBounds(0, 222, 360, 2);
		add(line2);
		// 가게 이름
		namelabel = new JLabel(r.GetName() + " 정보");
		namelabel.setHorizontalAlignment(JLabel.CENTER);
		namelabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		namelabel.setBounds(0, 0, 360, 72);
		add(namelabel);

		// 공유 버튼을 생성하고 추가합니다.
		sharebutton = new JButton(new ImageIcon(Main.class.getResource("../images/share.png")));
		sharebutton.setBorderPainted(false);
		sharebutton.setContentAreaFilled(false);
		sharebutton.setFocusPainted(false);
		sharebutton.setBounds(288, 72, 32, 32); // 버튼 위치와 크기 설정
		sharebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				sharebutton.setIcon(new ImageIcon(Main.class.getResource("../images/share2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				sharebutton.setIcon(new ImageIcon(Main.class.getResource("../images/share.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 공유기능
				r.Share();
			}
		});

		// 좋아요 버튼을 생성하고 추가합니다.
		likedbutton = new JButton();
		if (r.GetLike()) {
			likedbutton.setIcon(new ImageIcon(Main.class.getResource("../images/likedbut2.png")));
		} else {
			likedbutton.setIcon(new ImageIcon(Main.class.getResource("../images/likedbut.png")));
		}
		likedbutton.setBorderPainted(false);
		likedbutton.setContentAreaFilled(false);
		likedbutton.setFocusPainted(false);
		likedbutton.setBounds(323, 72, 32, 32); // 버튼 위치와 크기 설정
		likedbutton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				if (r.GetLike()) {
					likedbutton.setIcon(new ImageIcon(Main.class.getResource("../images/likedbut.png")));
					// 좋아요 해제 기능
					Heart.Like(r);
				} else {
					likedbutton.setIcon(new ImageIcon(Main.class.getResource("../images/likedbut2.png")));
					// 좋아요 하기 기능
					Heart.Like(r);
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
		text = new JTextArea("\n\n -영업시간 : " + r.GetBussinessHour() + "\n\n -전화번호 : " + r.GetTel() + "\n\n -휴무일 : "
				+ r.GetRestday() + "\n\n -주소 : " + r.GetAddress());
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setEditable(false);
		// text.setHorizontalAlignment(JLabel.LEFT);
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

		JButton submitButton = new JButton(new ImageIcon(Main.class.getResource("../images/add.png")));
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
		submitButton.setFocusPainted(false);
		submitButton.setBounds(323, 227, 32, 32);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				submitButton.setIcon(new ImageIcon(Main.class.getResource("../images/add2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				submitButton.setIcon(new ImageIcon(Main.class.getResource("../images/add.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 리뷰 추가 기능
				Review reviewDialog = new Review(r, ShowRestaurant.this);
				reviewDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				reviewDialog.setVisible(true);
				
				validate();
				repaint();
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
					submitButton.setVisible(true); // 제출 버튼을 숨김
					DisplayReviewsAndAverageStars();

					isinfor = false; // 상태를 리뷰 보기로 전환
				} else {
					reviewbutton.setIcon(new ImageIcon(Main.class.getResource("../images/review2.png")));
					submitButton.setVisible(false); // 제출 버튼을 보임
					showInformation(); // 원래의 가게 정보를 표시하는 메소드
					isinfor = true; // 상태를 정보 보기로 전환
				}
				repaint();
			}
		});

		add(photolabel); // 가게 사진 출력
		add(menubutton); // 메뉴 버튼 출력
		add(reviewbutton); // 리뷰 버튼 출력
		add(text);
		repaint();
	}

	private void showInformation() {
		// 가게 정보를 JTextArea에 설정하는 코드
		String infoText = String.format("\n\n -영업시간: %s\n\n -전화번호: %s\n\n -휴무일: %s\n\n -주소: %s",
				restaurant.GetBussinessHour(), restaurant.GetTel(), restaurant.GetRestday(), restaurant.GetAddress());
		text.setText(infoText);
	}

	void drawStars(Graphics g, double starRating) {
		int starWidth = 34; // 이미지 폭에 따라 이 값을 조절하세요
		int x = 5;
		int y = 225;

		for (int i = 0; i < 5; i++) {
			Image starImage;

			if (starRating >= i + 1) {
				starImage = new ImageIcon(Main.class.getResource("../images/one.png")).getImage();
			} else if (starRating >= i + 0.5) {
				starImage = new ImageIcon(Main.class.getResource("../images/half.png")).getImage();
			} else {
				starImage = new ImageIcon(Main.class.getResource("../images/zero.png")).getImage();
			}

			g.drawImage(starImage, x, y, null);
			x += starWidth;
		}

		g.drawString(starRating + "/ 5.0", 180, y);
	}

	void DisplayReviewsAndAverageStars() {

		text.setText(""); // 텍스트 영역을 초기화합니다.

		StringBuilder reviewsDisplay = new StringBuilder();
		String filePath = restaurant.GetName() + ".txt"; // 사용자 아이디와 비밀번호가 저장된 파일 경로
		double averageStars = 0;
		double num = 0;
		
		createFileIfNotExists(filePath);
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				averageStars += Double.parseDouble(parts[0].trim());
				String storedUsername = parts[1].trim();
				String storedReview = parts[2].trim();
				num++;

				reviewsDisplay.append(" -> ").append(storedUsername).append(" : ").append(storedReview).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(num != 0)
			averageStars = averageStars/num;
		// 평균 별점을 표시하는 문자열을 구성합니다.
		String averageStarDisplay = String.format("평균 별점: %.1f / 5.0", averageStars);

		// 텍스트 영역에 리뷰 내용과 평균 별점을 설정합니다.
		text.setText( averageStarDisplay + "\n" + reviewsDisplay.toString());
		drawStars(text.getGraphics(), averageStars);

		// 패널을 새로 고치기 위해 validate()와 repaint()를 호출합니다.
		validate();
		repaint();
	}
	
	private void createFileIfNotExists(String filePath) {
	    File file = new File(filePath);
	    if (!file.exists()) {
	        try {
	            file.createNewFile();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	void ShowPhoto(Restaurant r, Graphics g) { // 가게 사진 출력하기
		g.drawImage(r.GetPhoto(), 0, 72, 360, 150, null);
	}

	void ShowMenu(Restaurant r, Graphics g) { // 가게 메뉴 출력하기
		g.drawImage(r.GetMenu(), 0, 72, 360, 150, null);
	}


}
