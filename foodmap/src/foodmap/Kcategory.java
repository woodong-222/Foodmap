package foodmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Kcategory extends JFrame {
	// 이미지는 추가 해야함
	private ImageIcon Kfood = new ImageIcon(Main.class.getResource("../images/Kfood.png"));
	private ImageIcon Cfood = new ImageIcon(Main.class.getResource("../images/Cfood.png"));
	private ImageIcon Jfood = new ImageIcon(Main.class.getResource("../images/Jfood.png"));
	private ImageIcon Wfood = new ImageIcon(Main.class.getResource("../images/Wfood.png"));
	private ImageIcon Sfood = new ImageIcon(Main.class.getResource("../images/Sfood.png"));

	private JLabel Kfoodlabel = new JLabel(Kfood); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton("A"); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton("B");
	private JButton Hansotbutton = new JButton("C");
	private JButton Sseonybutton = new JButton("D");

	private JLabel Cfoodlabel = new JLabel(Cfood);// 중식 카테고리 라벨
	private JButton Chowonbutton = new JButton("A"); // 중식 식당 버튼들
	private JButton Yongbutton = new JButton("B");
	private JButton Soosinbutton = new JButton("C");
	private JButton Bohwabutton = new JButton("D");

	private JLabel Jfoodlabel = new JLabel(Jfood); // 일식 카테고리 라벨
	private JButton Wellbutton = new JButton("A"); // 일식 식당 버튼들

	private JLabel Wfoodlabel = new JLabel(Wfood); // 일식 카테고리 라벨
	private JButton Yogitbutton = new JButton("A"); // 일식 식당 버튼들

	private JLabel Sfoodlabel = new JLabel(Sfood); // 중식 카테고리 라벨
	private JButton Sinjeonbutton = new JButton("A"); // 중식 식당 버튼

	private ImageIcon homeEnteredbutton = new ImageIcon(Main.class.getResource("../images/home2.png"));
	private ImageIcon homeBasicbutton = new ImageIcon(Main.class.getResource("../images/home.png"));
	private ImageIcon likedEnteredbutton = new ImageIcon(Main.class.getResource("../images/liked2.png"));
	private ImageIcon likedBasicbutton = new ImageIcon(Main.class.getResource("../images/liked.png"));
	private ImageIcon PEnteredbutton = new ImageIcon(Main.class.getResource("../images/plu2.png"));
	private ImageIcon PBasicbutton = new ImageIcon(Main.class.getResource("../images/plu.png"));
	private ImageIcon MEnteredbutton = new ImageIcon(Main.class.getResource("../images/min2.png"));
	private ImageIcon MBasicbutton = new ImageIcon(Main.class.getResource("../images/min.png"));

	private JButton homebutton = new JButton(homeBasicbutton); // 홈버튼 생성
	private JButton likedbutton = new JButton(likedBasicbutton); // 찜버튼 생성
	private JButton Pbutton = new JButton(PBasicbutton);
	private JButton Mbutton = new JButton(MBasicbutton);

	JLabel map; // 지도 사진 (여기에서 지도 출력)

	private Image screenImage;
	private Graphics screenGraphic;

	private Foodmap parent;
	private NaverMap naverMap;

	public Kcategory(Foodmap parent) {
		this.parent = parent; // 부모 객체 참조 설정

		setUndecorated(true);
		setTitle("Food Map");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		Kfoodlabel.setBounds(0, 0, 360, 100);
		Kfoodlabel.setVisible(true);

		Wangbutton.setBackground(Color.WHITE);
		Wangbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Wangbutton.setBounds(0, 100, 360, 100);
		Wangbutton.setVisible(true);
		Wangbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 왕십리 야식 버튼 눌렀을 때
			}
		});

		Jeulgyeobutton.setBackground(Color.WHITE);
		Jeulgyeobutton.setFont(new Font("Arial", Font.BOLD, 25));
		Jeulgyeobutton.setBounds(0, 200, 360, 100);
		Jeulgyeobutton.setVisible(true);
		Jeulgyeobutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 즐겨먹기 버튼 눌렀을 때
			}
		});

		Hansotbutton.setBackground(Color.WHITE);
		Hansotbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Hansotbutton.setBounds(0, 300, 360, 100);
		Hansotbutton.setVisible(true);
		Hansotbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 한솥 버튼 눌렀을 때
			}
		});

		Sseonybutton.setBackground(Color.WHITE);
		Sseonybutton.setFont(new Font("Arial", Font.BOLD, 25));
		Sseonybutton.setBounds(0, 400, 360, 100);
		Sseonybutton.setVisible(true);
		Sseonybutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 써니 버튼 눌렀을 때
			}
		});

		// 중식
		Cfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Chowonbutton.setBackground(Color.WHITE);
		Chowonbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Chowonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Chowonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});
		
		Yongbutton.setBackground(Color.WHITE);
		Yongbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Yongbutton.setBounds(0, 200, 360, 100); // 버튼 위치 및 사이즈
		Yongbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 용짬뽕 버튼 눌렀을 때
			}
		});

		Soosinbutton.setBackground(Color.WHITE);
		Soosinbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Soosinbutton.setBounds(0, 300, 360, 100); // 버튼 위치 및 사이즈
		Soosinbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 수신 버튼 눌렀을 때
			}
		});

		Bohwabutton.setBackground(Color.WHITE);
		Bohwabutton.setFont(new Font("Arial", Font.BOLD, 25));
		Bohwabutton.setBounds(0, 400, 360, 100); // 버튼 위치 및 사이즈
		Bohwabutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 보화 버튼 눌렀을 때
			}
		});

		// 일식
		Jfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Wellbutton.setBackground(Color.WHITE);
		Wellbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Wellbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Wellbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		// 양식
		Wfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Yogitbutton.setBackground(Color.WHITE);
		Yogitbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Yogitbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Yogitbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		// 분식
		Sfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Sinjeonbutton.setBackground(Color.WHITE);
		Sinjeonbutton.setFont(new Font("Arial", Font.BOLD, 25));
		Sinjeonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Sinjeonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		// 홈 버튼
		homebutton.setBounds(900, 20, 65, 65); // 버튼 위치 및 사이즈
		homebutton.setBorderPainted(false);
		homebutton.setContentAreaFilled(false);
		homebutton.setFocusPainted(false);
		homebutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				homebutton.setIcon(homeEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				homebutton.setIcon(homeBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 홈 버튼 눌렀을 때
			}
		});

		// 찜 버튼
		likedbutton.setBounds(975, 20, 65, 65); // 버튼 위치 및 사이즈
		likedbutton.setBorderPainted(false);
		likedbutton.setContentAreaFilled(false);
		likedbutton.setFocusPainted(false);
		likedbutton.addMouseListener(new MouseAdapter() {// 재정의
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				likedbutton.setIcon(likedEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				likedbutton.setIcon(likedBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 찜 버튼 눌렀을 때
			}
		});

		// + 버튼
		Pbutton.setBounds(1020, 460, 32, 32);
		Pbutton.setBorderPainted(false);
		Pbutton.setContentAreaFilled(false);
		Pbutton.setFocusPainted(false);
		Pbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Pbutton.setIcon(PEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Pbutton.setIcon(PBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				NaverMap.mapsize++; // 맵 사이즈 늘리기
				naverMap.actionPerformed(null); // 지도 새로고침
			}
		});
		// - 버튼
		Mbutton.setBounds(980, 460, 32, 32);
		Mbutton.setBorderPainted(false);
		Mbutton.setContentAreaFilled(false);
		Mbutton.setFocusPainted(false);
		Mbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Mbutton.setIcon(MEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Mbutton.setIcon(MBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				NaverMap.mapsize--; // 맵 사이즈 줄이기
				naverMap.actionPerformed(null); // 지도 새로고침
			}
		});
		// 기본 버튼들
		add(homebutton);
		add(likedbutton);
		add(Pbutton);
		add(Mbutton);

		// NaverMap 객체 생성 및 초기화
		this.naverMap = new NaverMap(parent);
		// KfoodCategory();
		map = new JLabel();
		map.setBounds(360, -111, 877, 720);

		// 지도 새로고침
		naverMap.actionPerformed(null);
		add(map);

	}

	public void KfoodCategory() { // 한식 카테고리 음식점 버튼
		add(Kfoodlabel);
		add(Wangbutton);
		add(Jeulgyeobutton);
		add(Hansotbutton);
		add(Sseonybutton);
	}

	void CfoodCategory() {// 중식 카테고리 음식점 버튼
		add(Cfoodlabel);
		add(Chowonbutton);
		add(Yongbutton);
		add(Soosinbutton);
		add(Bohwabutton);
	}

	void JfoodCategory() {// 일식 카테고리 음식점 버튼
		add(Jfoodlabel);
		add(Wellbutton);
	}

	void WfoodCategory() {// 양식 카테고리 음식점 버튼
		add(Wfoodlabel);
		add(Yogitbutton);

	}

	void SfoodCategory() {// 분식 카테고리 음식점 버튼
		add(Sfoodlabel);
		add(Sinjeonbutton);

	}
/*
	public void removefoodCategory() {
		// 버튼들 제거
		remove(Kfoodlabel);
		remove(Wangbutton);
		remove(Jeulgyeobutton);
		remove(Hansotbutton);
		remove(Sseonybutton);
		remove(Cfoodlabel);
		remove(Chowonbutton);
		remove(Yongbutton);
		remove(Soosinbutton);
		remove(Bohwabutton);
		remove(Jfoodlabel);
		remove(Wellbutton);
		remove(Wfoodlabel);
		remove(Yogitbutton);
		remove(Sfoodlabel);
		remove(Sinjeonbutton);
	}
*/
	/*
	 * public void paint(Graphics g) { screenImage = createImage(Main.SCREEN_WIDTH,
	 * Main.SCREEN_HEIGHT); screenGraphic = screenImage.getGraphics();
	 * screenDraw(screenGraphic); g.drawImage(screenImage, 0, 0, null); }
	 * 
	 * public void screenDraw(Graphics g) { // 화면 그리기 // g.drawImage(null, 0, 0,
	 * null); paintComponents(g); this.repaint(); }
	 */
}
