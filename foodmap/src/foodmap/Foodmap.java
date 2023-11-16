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

	private JButton homebutton = new JButton(homeBasicbutton);
	private JButton likedbutton = new JButton(likedBasicbutton);
	private JButton Kfoodbutton = new JButton("한식");
	private JButton Cfoodbutton = new JButton("중식");
	private JButton Jfoodbutton = new JButton("일식");
	private JButton Wfoodbutton = new JButton("양식");
	private JButton Sfoodbutton = new JButton("분식");

	private boolean isScreen1 = false;

	private int mouseX, mouseY;

	public Foodmap() {
		setUndecorated(true); // 메뉴바 같은거 안보이게인데 이거 보이게 하고 싶어
		setTitle("Food Map"); // 타이틀
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 사이즈 설정
		setResizable(false); // 사이즈 변경 불가능
		setLocationRelativeTo(null); // 컴퓨터 정중앙
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 종료시 프로그램 종료
		setVisible(true); // 화면 보임

		setBackground(new Color(0, 0, 0, 0));
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
		homebutton.setBounds(1075, 50, 65, 65);
		homebutton.setBorderPainted(false);
		homebutton.setContentAreaFilled(false);
		homebutton.setFocusPainted(false);
		homebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				homebutton.setIcon(homeEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				homebutton.setIcon(homeBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 홈 버튼 눌렀을 때
			}
		});

		// 찜 버튼
		likedbutton.setBounds(1150, 50, 65, 65);
		likedbutton.setBorderPainted(false);
		likedbutton.setContentAreaFilled(false);
		likedbutton.setFocusPainted(false);
		likedbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				likedbutton.setIcon(likedEnteredbutton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				likedbutton.setIcon(likedBasicbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 찜 버튼 눌렀을 때
			}
		});

		// 한식 버튼
		Font ButtonFont = new Font("", Font.BOLD, 40); // 원하는 폰트로 수정
		Kfoodbutton.setFont(ButtonFont);
		Cfoodbutton.setFont(ButtonFont);
		Jfoodbutton.setFont(ButtonFont);
		Wfoodbutton.setFont(ButtonFont);
		Sfoodbutton.setFont(ButtonFont);

		Kfoodbutton.setBounds(0, 0, 360, 144);
		// Kfoodbutton.setBorderPainted(false);
		// Kfoodbutton.setContentAreaFilled(false);
		// Kfoodbutton.setFocusPainted(false);
		/*
		 * Kfoodbutton.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseEntered(MouseEvent e) {
		 * likedbutton.setIcon(likedEnteredbutton); }
		 * 
		 * @Override public void mouseExited(MouseEvent e) {
		 * likedbutton.setIcon(likedBasicbutton); }
		 * 
		 * @Override public void mousePressed(MouseEvent e) { //한식 버튼 눌렀을 때 } });
		 */

		Cfoodbutton.setBounds(0, 144, 360, 144);
		Jfoodbutton.setBounds(0, 288, 360, 144);
		Wfoodbutton.setBounds(0, 432, 360, 144);
		Sfoodbutton.setBounds(0, 576, 360, 144);

		timer.setRepeats(false); // 한 번만 실행
		timer.start();
	}

	public void setScreen1() {
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

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null);
		if (isScreen1) {
			g.drawImage(Map, 360, 0, 920, 720, null);
		}
		paintComponents(g);
		this.repaint();
	}
}
