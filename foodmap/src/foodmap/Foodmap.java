package foodmap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Foodmap extends JFrame {

	public static String address; // 주소 변수 (여기에 주소 넣으면 지도에서 이 주소값을 불러옴)
	public JLabel map; // 지도 사진 (여기에서 지도 출력)

	private Image screenImage;
	private Graphics screenGraphic;

	// Jpanel들 객체 지정
	private JPanel button;
	public Category category = new Category(this);
	public ShowRestaurant showresturant;

	NaverMap naverMap = new NaverMap(this);
	Heart heart = new Heart(this);

	// 로딩, 맵 경로 지정(맵은 바뀔 가능성 많음)
	private Image Background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();

	// 버튼 이미지 경로 지정
	private ImageIcon homeEnteredbutton = new ImageIcon(Main.class.getResource("../images/home2.png"));
	private ImageIcon homeBasicbutton = new ImageIcon(Main.class.getResource("../images/home.png"));
	private ImageIcon likedEnteredbutton = new ImageIcon(Main.class.getResource("../images/liked2.png"));
	private ImageIcon likedBasicbutton = new ImageIcon(Main.class.getResource("../images/liked.png"));
	private ImageIcon KfoodEnteredbutton = new ImageIcon(Main.class.getResource("../images/Kfood2.png"));
	private ImageIcon KfoodBasicbutton = new ImageIcon(Main.class.getResource("../images/Kfood.png"));
	private ImageIcon CfoodEnteredbutton = new ImageIcon(Main.class.getResource("../images/Cfood2.png"));
	private ImageIcon CfoodBasicbutton = new ImageIcon(Main.class.getResource("../images/Cfood.png"));
	private ImageIcon JfoodEnteredbutton = new ImageIcon(Main.class.getResource("../images/Jfood2.png"));
	private ImageIcon JfoodBasicbutton = new ImageIcon(Main.class.getResource("../images/Jfood.png"));
	private ImageIcon WfoodEnteredbutton = new ImageIcon(Main.class.getResource("../images/Wfood2.png"));
	private ImageIcon WfoodBasicbutton = new ImageIcon(Main.class.getResource("../images/Wfood.png"));
	private ImageIcon SfoodEnteredbutton = new ImageIcon(Main.class.getResource("../images/Sfood2.png"));
	private ImageIcon SfoodBasicbutton = new ImageIcon(Main.class.getResource("../images/Sfood.png"));
	private ImageIcon PEnteredbutton = new ImageIcon(Main.class.getResource("../images/plu2.png"));
	private ImageIcon PBasicbutton = new ImageIcon(Main.class.getResource("../images/plu.png"));
	private ImageIcon MEnteredbutton = new ImageIcon(Main.class.getResource("../images/min2.png"));
	private ImageIcon MBasicbutton = new ImageIcon(Main.class.getResource("../images/min.png"));

	// 버튼 생성
	private JButton homebutton = new JButton(homeBasicbutton); // 홈버튼 생성
	private JButton likedbutton = new JButton(likedBasicbutton); // 찜버튼 생성
	private JButton Kfoodbutton = new JButton(KfoodBasicbutton); // 카테고리 버튼
	private JButton Cfoodbutton = new JButton(CfoodBasicbutton);
	private JButton Jfoodbutton = new JButton(JfoodBasicbutton);
	private JButton Wfoodbutton = new JButton(WfoodBasicbutton);
	private JButton Sfoodbutton = new JButton(SfoodBasicbutton);
	private JButton Pbutton = new JButton(PBasicbutton);
	private JButton Mbutton = new JButton(MBasicbutton);
	private JLabel intro = new JLabel(new ImageIcon(Main.class.getResource("../images/introBackground.png")));

	public Foodmap() {
		// setUndecorated(false); // 메뉴바 같은거 안보이게인데 이거 보이게 하고 싶어
		setTitle("Food Map"); // 타이틀
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 사이즈 설정
		setResizable(false); // 사이즈 변경 불가능
		setLocationRelativeTo(null); // 컴퓨터 정중앙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로그램 종료
		setVisible(true); // 화면 보임

		// setBackground(new Color(0, 0, 0, 0)); // 배경 투명색
		setLayout(null);

		intro.setBounds(-8, -20, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 버튼 위치 및 사이즈
		add(intro);
		
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
				changeJpanel(0);
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
				change();
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

		// 한식 버튼
		Kfoodbutton.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈
		Kfoodbutton.setBorderPainted(false);
		Kfoodbutton.setContentAreaFilled(false);
		Kfoodbutton.setFocusPainted(false);
		Kfoodbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Kfoodbutton.setIcon(KfoodEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Kfoodbutton.setIcon(KfoodBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 한식 버튼 눌렀을 때
				// 패널 전환
				Kfoodbutton.setIcon(KfoodBasicbutton);
				category.removeAll();
				category.KfoodCategory();
				changeJpanel(1);
			}
		});

		// 중식 버튼
		Cfoodbutton.setBounds(0, 100, 360, 100);
		Cfoodbutton.setBorderPainted(false);
		Cfoodbutton.setContentAreaFilled(false);
		Cfoodbutton.setFocusPainted(false);
		Cfoodbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Cfoodbutton.setIcon(CfoodEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Cfoodbutton.setIcon(CfoodBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때

				category.removeAll();
				Cfoodbutton.setIcon(CfoodBasicbutton);
				category.CfoodCategory();
				changeJpanel(1);
			}
		});

		// 일식 버튼
		Jfoodbutton.setBounds(0, 200, 360, 100);
		Jfoodbutton.setBorderPainted(false);
		Jfoodbutton.setContentAreaFilled(false);
		Jfoodbutton.setFocusPainted(false);
		Jfoodbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Jfoodbutton.setIcon(JfoodEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Jfoodbutton.setIcon(JfoodBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때

				category.removeAll();
				Jfoodbutton.setIcon(JfoodBasicbutton);
				category.JfoodCategory();
				changeJpanel(1);
			}
		});

		// 양식 버튼
		Wfoodbutton.setBounds(0, 300, 360, 100);
		Wfoodbutton.setBorderPainted(false);
		Wfoodbutton.setContentAreaFilled(false);
		Wfoodbutton.setFocusPainted(false);
		Wfoodbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Wfoodbutton.setIcon(WfoodEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Wfoodbutton.setIcon(WfoodBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때

				category.removeAll();
				Wfoodbutton.setIcon(WfoodBasicbutton);
				category.WfoodCategory();
				changeJpanel(1);
			}
		});

		// 분식 버튼
		Sfoodbutton.setBounds(0, 400, 360, 100);
		Sfoodbutton.setBorderPainted(false);
		Sfoodbutton.setContentAreaFilled(false);
		Sfoodbutton.setFocusPainted(false);
		Sfoodbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스 가까이 가면
				Sfoodbutton.setIcon(SfoodEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스 멀어지면
				Sfoodbutton.setIcon(SfoodBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때

				category.removeAll();
				Sfoodbutton.setIcon(SfoodBasicbutton);
				category.SfoodCategory();
				changeJpanel(1);
			}
		});

		// JFrame frm = new JFrame();
		// frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Container c = frm.getContentPane();

		button = new JPanel();
		button.setLayout(null);
		button.setBounds(0, 0, 360, 500);
		button.add(Kfoodbutton);
		button.add(Cfoodbutton);
		button.add(Jfoodbutton);
		button.add(Wfoodbutton);
		button.add(Sfoodbutton);
		// button.setBackground(Color.yellow);

		Timer timer = new Timer(3000, new ActionListener() { // 3초뒤에 로딩화면 숨김 -> 이거 나중에 3000으로 수정
			public void actionPerformed(ActionEvent e) {
				intro.setIcon(null);

				add(button); // 버튼 패널
				el_add();
				repaint(); // 변경된 상태를 다시 그리기
			}
		});
		timer.setRepeats(false); // 한 번만 실행
		timer.start();

		// 지도 관련
		address = "충절로 1600"; // 도로명 주소를 집어넣음
		map = new JLabel(); // 지도 객체 생성
		map.setBounds(360, -111, 877, 720); // 지도 위치 설정

		// 지도 새로고침
		naverMap.actionPerformed(null);

	}

	public void el_add() { // 매 화면 필요한 화면 출력
		add(homebutton);
		add(likedbutton);
		add(Pbutton);
		add(Mbutton);

		add(map);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) { // 화면 그리기
		g.drawImage(Background, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}

	public void changeJpanel(int paneltype) {
		if (paneltype == 0) { // 홈버튼
			setContentPane(button);
			address = "충절로 1600";
			naverMap.actionPerformed(null);
		}
		if (paneltype == 1) { // 한식, 중식, 일식 등등 버튼
			setContentPane(category);
		}
		if (paneltype == 2) { // 가게 버튼
		}

		el_add();
		revalidate();
		repaint();
	}

	public void changerest(String rest) { // 가게 버튼
		// showresturant.removeAll();
		Restaurant restaurant = Main.getInstance().getResturantInfo(rest);
		showresturant = new ShowRestaurant(this, restaurant);
		setContentPane(showresturant);

		address = restaurant.getaddress();
		naverMap.actionPerformed(null);
		el_add();
		revalidate();
		repaint();
	}

	public void change() {
		heart.ShowHeartList();
		setContentPane(heart);
		el_add();
		revalidate();
		repaint();
	}
	public Heart getHeart() {
		return heart;
	}
}