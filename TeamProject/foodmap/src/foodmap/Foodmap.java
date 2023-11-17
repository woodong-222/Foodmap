package foodmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Foodmap extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image Background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private Image Map = new ImageIcon(Main.class.getResource("../images/Map1.jpg")).getImage(); // 제대로된 지도 이미지 교체 필요

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

	private JButton homebutton = new JButton(homeBasicbutton); // 홈버튼 생성
	private JButton likedbutton = new JButton(likedBasicbutton); // 찜버튼 생성
	private JButton Kfoodbutton = new JButton(KfoodBasicbutton); // 카테고리 버튼
	private JButton Cfoodbutton = new JButton(CfoodBasicbutton);
	private JButton Jfoodbutton = new JButton(JfoodBasicbutton);
	private JButton Wfoodbutton = new JButton(WfoodBasicbutton);
	private JButton Sfoodbutton = new JButton(SfoodBasicbutton);

	private boolean isScreen1 = false; // 메인화면이면 true

	private int mouseX, mouseY; // 마우스 위치

	public Foodmap() {
		setUndecorated(true); // 메뉴바 같은거 안보이게인데 이거 보이게 하고 싶어
		setTitle("Food Map"); // 타이틀
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 사이즈 설정
		setResizable(false); // 사이즈 변경 불가능
		setLocationRelativeTo(null); // 컴퓨터 정중앙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로그램 종료
		setVisible(true); // 화면 보임

		setBackground(new Color(0, 0, 0, 0)); // 배경 투명색
		setLayout(null);

		Timer timer = new Timer(3000, new ActionListener() { // 3초뒤에 로딩화면 숨김
			@Override
			public void actionPerformed(ActionEvent e) {
				Background = null; // 배경 숨기기
				repaint(); // 변경된 상태를 다시 그리기
				setScreen1(); // 버튼 등을 추가하는 메소드 호출
			}
		});

		// 홈 버튼
		homebutton.setBounds(1075, 50, 65, 65); // 버튼 위치 및 사이즈
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
		likedbutton.setBounds(1150, 50, 65, 65); // 버튼 위치 및 사이즈
		likedbutton.setBorderPainted(false);
		likedbutton.setContentAreaFilled(false);
		likedbutton.setFocusPainted(false);
		likedbutton.addMouseListener(new MouseAdapter() {// 재정의
			@Override
			public void mouseEntered(MouseEvent e) {// 마우스 가까이 가면
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

		// 한식 버튼

		Kfoodbutton.setBounds(0, 0, 360, 144); // 버튼 위치 및 사이즈
		Kfoodbutton.setBorderPainted(false);
		Kfoodbutton.setContentAreaFilled(false);
		Kfoodbutton.setFocusPainted(false);
		Kfoodbutton.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				Kfoodbutton.setIcon(KfoodEnteredbutton); 
			}
		 
			@Override 
			public void mouseExited(MouseEvent e) {
				Kfoodbutton.setIcon(KfoodBasicbutton); 
			}
		 
		 @Override public void mousePressed(MouseEvent e) { 
			 //한식 버튼 눌렀을 때 
		 	} 
		});
		
		// 중식 버튼
		Cfoodbutton.setBounds(0, 144, 360, 144);
		Cfoodbutton.setBorderPainted(false);
		Cfoodbutton.setContentAreaFilled(false);
		Cfoodbutton.setFocusPainted(false);
		Cfoodbutton.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				Cfoodbutton.setIcon(CfoodEnteredbutton); 
			}
		 
			@Override 
			public void mouseExited(MouseEvent e) {
				Cfoodbutton.setIcon(CfoodBasicbutton); 
			}
		 
		 @Override public void mousePressed(MouseEvent e) { 
			 //중식 버튼 눌렀을 때 
		 	} 
		});
		
		// 일식 버튼
		Jfoodbutton.setBounds(0, 288, 360, 144);
		Jfoodbutton.setBorderPainted(false);
		Jfoodbutton.setContentAreaFilled(false);
		Jfoodbutton.setFocusPainted(false);
		Jfoodbutton.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				Jfoodbutton.setIcon(JfoodEnteredbutton); 
			}
		 
			@Override 
			public void mouseExited(MouseEvent e) {
				Jfoodbutton.setIcon(JfoodBasicbutton); 
			}
		 
		 @Override public void mousePressed(MouseEvent e) { 
			 //일식 버튼 눌렀을 때 
		 	} 
		});
		
		//양식
		Wfoodbutton.setBounds(0, 432, 360, 144);
		Wfoodbutton.setBorderPainted(false);
		Wfoodbutton.setContentAreaFilled(false);
		Wfoodbutton.setFocusPainted(false);
		Wfoodbutton.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				Wfoodbutton.setIcon(WfoodEnteredbutton); 
			}
		 
			@Override 
			public void mouseExited(MouseEvent e) {
				Wfoodbutton.setIcon(WfoodBasicbutton); 
			}
		 
		 @Override public void mousePressed(MouseEvent e) { 
			 //양식 버튼 눌렀을 때 
		 	} 
		});
		
		//분식
		Sfoodbutton.setBounds(0, 576, 360, 144);
		Sfoodbutton.setBorderPainted(false);
		Sfoodbutton.setContentAreaFilled(false);
		Sfoodbutton.setFocusPainted(false);
		Sfoodbutton.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseEntered(MouseEvent e) {
				Sfoodbutton.setIcon(SfoodEnteredbutton); 
			}
		 
			@Override 
			public void mouseExited(MouseEvent e) {
				Sfoodbutton.setIcon(SfoodBasicbutton); 
			}
		 
		 @Override public void mousePressed(MouseEvent e) { 
			 //분식 버튼 눌렀을 때 
		 	} 
		});

		timer.setRepeats(false); // 한 번만 실행
		timer.start();
	}

	public void setScreen1() { // 스크린 1
		isScreen1 = true;
		add(homebutton);
		add(likedbutton);
		add(Kfoodbutton);
		add(Cfoodbutton);
		add(Jfoodbutton);
		add(Wfoodbutton);
		add(Sfoodbutton);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) { // 화면 그리기
		g.drawImage(Background, 0, 0, null);
		if (isScreen1) {
			g.drawImage(Map, 360, 0, 920, 720, null);
		}
		paintComponents(g);
		this.repaint();
	}
}