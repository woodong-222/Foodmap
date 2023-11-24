package foodmap;

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
	private JLabel Kfoodlabel = new JLabel(Kfood); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton("A"); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton("B");
	private JButton Hansotbutton = new JButton("C");
	private JButton Sseonybutton = new JButton("D");

	JLabel map; // 지도 사진 (여기에서 지도 출력)

	private Image screenImage;
	private Graphics screenGraphic;

	private Foodmap parent;
	private NaverMap naverMap;
	
	public Kcategory(Foodmap parent){
		this.parent = parent; // 부모 객체 참조 설정

        setUndecorated(true);
        setTitle("Food Map");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        Kfoodlabel.setBounds(0, 0, 360, 100);
        Kfoodlabel.setVisible(true);

        Wangbutton.setBounds(0, 100, 360, 100);
        Wangbutton.setVisible(true);
		Wangbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 왕십리 야식 버튼 눌렀을 때
			}
		});

		Jeulgyeobutton.setBounds(0, 200, 360, 100);
		Jeulgyeobutton.setVisible(true);
		Jeulgyeobutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 즐겨먹기 버튼 눌렀을 때
			}
		});

		Hansotbutton.setBounds(0, 300, 360, 100);
		Hansotbutton.setVisible(true);
		Hansotbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 한솥 버튼 눌렀을 때
			}
		});

		Sseonybutton.setBounds(0, 400, 360, 100);
		Sseonybutton.setVisible(true);
		Sseonybutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 써니 버튼 눌렀을 때
			}
		});

		// NaverMap 객체 생성 및 초기화
	    System.out.println("뭐야 여기야?");
	    this.naverMap = new NaverMap(parent);
		//KfoodCategory();
		map = new JLabel();
		map.setBounds(360, -111, 877, 720);

		// 지도 새로고침
		naverMap.actionPerformed(null); 
		add(map);
	}

	public void KfoodCategory() { // 카테고리 스크린
		add(Kfoodlabel);
		add(Wangbutton);
		add(Jeulgyeobutton);
		add(Hansotbutton);
		add(Sseonybutton);
	}

	void CfoodCategory() {// 중식 카테고리 음식점 버튼

	}

	void JfoodCategory() {// 일식 카테고리 음식점 버튼

	}

	void WfoodCategory() {// 양식 카테고리 음식점 버튼

	}

	void SfoodCategory() {// 분식 카테고리 음식점 버튼

	}

	public void removeKfoodCategory() {
		// 버튼들 제거
		remove(Wangbutton);
		remove(Jeulgyeobutton);
		remove(Hansotbutton);
		remove(Sseonybutton);
		repaint();
	}
/*
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) { // 화면 그리기
		// g.drawImage(null, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
*/
}
