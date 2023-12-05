package foodmap;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Category extends JPanel {

	private ImageIcon Kfood = new ImageIcon(Main.class.getResource("../images/Kfood.png"));
	private ImageIcon Cfood = new ImageIcon(Main.class.getResource("../images/Cfood.png"));
	private ImageIcon Jfood = new ImageIcon(Main.class.getResource("../images/Jfood.png"));
	private ImageIcon Wfood = new ImageIcon(Main.class.getResource("../images/Wfood.png"));
	private ImageIcon Sfood = new ImageIcon(Main.class.getResource("../images/Sfood.png"));

	private JLabel Kfoodlabel = new JLabel(Kfood); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton("왕십리 야식"); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton("즐겨먹기");
	private JButton Hansotbutton = new JButton("한솥도시락");
	private JButton Sseonybutton = new JButton("써니숯불도시락");

	private JLabel Cfoodlabel = new JLabel(Cfood);// 중식 카테고리 라벨
	private JButton Chowonbutton = new JButton("초원"); // 중식 식당 버튼들
	private JButton Yongbutton = new JButton("용짬뽕");
	private JButton Soosinbutton = new JButton("수신반점");
	private JButton Bohwabutton = new JButton("보화 중화요리");

	private JLabel Jfoodlabel = new JLabel(Jfood); // 일식 카테고리 라벨
	private JButton Wellbutton = new JButton("웰돈카츠"); // 일식 식당 버튼들

	private JLabel Wfoodlabel = new JLabel(Wfood); // 일식 카테고리 라벨
	private JButton Yogitbutton = new JButton("요깃"); // 일식 식당 버튼들

	private JLabel Sfoodlabel = new JLabel(Sfood); // 중식 카테고리 라벨
	private JButton Sinjeonbutton = new JButton("신전떡볶이"); // 중식 식당 버튼
	
	
	public Category(Foodmap foodmap) 
	{
		Kfoodlabel.setBounds(0, 0, 360, 100);
		Kfoodlabel.setVisible(true);

		Wangbutton.setBackground(Color.WHITE);
		Wangbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Wangbutton.setBounds(0, 100, 360, 100);
		Wangbutton.setVisible(true);
		Wangbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				foodmap.changerest("왕십리 야식");

			}
		});

		Jeulgyeobutton.setBackground(Color.WHITE);
		Jeulgyeobutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Jeulgyeobutton.setBounds(0, 200, 360, 100);
		Jeulgyeobutton.setVisible(true);
		Jeulgyeobutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foodmap.changerest("즐겨먹기");
				// 즐겨먹기 버튼 눌렀을 때
			}
		});

		Hansotbutton.setBackground(Color.WHITE);
		Hansotbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Hansotbutton.setBounds(0, 300, 360, 100);
		Hansotbutton.setVisible(true);
		Hansotbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foodmap.changerest("한솥도시락");
				// 한솥 버튼 눌렀을 때
			}
		});

		Sseonybutton.setBackground(Color.WHITE);
		Sseonybutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Sseonybutton.setBounds(0, 400, 360, 100);
		Sseonybutton.setVisible(true);
		Sseonybutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				foodmap.changerest("써니숯불도시락");
				// 써니 버튼 눌렀을 때
			}
		});

		// 중식
		Cfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Chowonbutton.setBackground(Color.WHITE);
		Chowonbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Chowonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Chowonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("초원");
				// 초원 버튼 눌렀을 때
			}
		});
		
		Yongbutton.setBackground(Color.WHITE);
		Yongbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Yongbutton.setBounds(0, 200, 360, 100); // 버튼 위치 및 사이즈
		Yongbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("용짬뽕");
				// 용짬뽕 버튼 눌렀을 때
			}
		});

		Soosinbutton.setBackground(Color.WHITE);
		Soosinbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Soosinbutton.setBounds(0, 300, 360, 100); // 버튼 위치 및 사이즈
		Soosinbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("수신반점");
				// 수신 버튼 눌렀을 때
			}
		});

		Bohwabutton.setBackground(Color.WHITE);
		Bohwabutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Bohwabutton.setBounds(0, 400, 360, 100); // 버튼 위치 및 사이즈
		Bohwabutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("보화 중화요리");
				// 보화 버튼 눌렀을 때
			}
		});

		// 일식
		Jfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Wellbutton.setBackground(Color.WHITE);
		Wellbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Wellbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Wellbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("웰돈카츠");
				// 웰돈카츠 버튼 눌렀을 때
			}
		});

		// 양식
		Wfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Yogitbutton.setBackground(Color.WHITE);
		Yogitbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Yogitbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Yogitbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("요깃");
				// 요깃 버튼 눌렀을 때
			}
		});

		// 분식
		Sfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Sinjeonbutton.setBackground(Color.WHITE);
		Sinjeonbutton.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		Sinjeonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Sinjeonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				foodmap.changerest("신전떡볶이");
				// 신전 버튼 눌렀을 때
			}
		});
		
		//배치
		setLayout(null);
		setBounds(0, 0, 360, 500);
	}

	public void KfoodCategory() { // 카테고리 스크린
		add(Kfoodlabel);
		add(Wangbutton);
		add(Jeulgyeobutton);
		add(Hansotbutton);
		add(Sseonybutton);
	}
	
	public void CfoodCategory() {// 중식 카테고리 음식점 버튼
		add(Cfoodlabel);
		add(Chowonbutton);
		add(Yongbutton);
		add(Soosinbutton);
		add(Bohwabutton);
	}

	public void JfoodCategory() {// 일식 카테고리 음식점 버튼
		add(Jfoodlabel);
		add(Wellbutton);
	}

	public void WfoodCategory() {// 양식 카테고리 음식점 버튼
		add(Wfoodlabel);
		add(Yogitbutton);
		
	}

	public void SfoodCategory() {// 분식 카테고리 음식점 버튼
		add(Sfoodlabel);
		add(Sinjeonbutton);
	}
}
