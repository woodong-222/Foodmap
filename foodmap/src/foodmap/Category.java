package foodmap;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Category extends JPanel{
	//이미지는 추가 해야함 
	private ImageIcon KfoodBasiclabel = new ImageIcon(Main.class.getResource(""));
	private ImageIcon CfoodBasiclabel = new ImageIcon(Main.class.getResource(""));
	private ImageIcon JfoodBasiclabel = new ImageIcon(Main.class.getResource(""));
	private ImageIcon WfoodBasiclabel = new ImageIcon(Main.class.getResource(""));
	private ImageIcon SfoodBasiclabel = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Wangbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Jeulgyeobasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Hansotbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Sseonybasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Chowonbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Yongbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Soosinbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Bohwabasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Wellbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Yogitbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Sinjeonbasicbutton = new ImageIcon(Main.class.getResource(""));
	
	
	private JLabel Kfoodlabel = new JLabel(KfoodBasiclabel); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton(Wangbasicbutton); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton(Jeulgyeobasicbutton);
	private JButton Hansotbutton = new JButton(Hansotbasicbutton);
	private JButton Sseonybutton = new JButton(Sseonybasicbutton);
	
	private JLabel Cfoodlabel = new JLabel(CfoodBasiclabel); // 중식 카테고리 라벨
	private JButton Chowonbutton = new JButton(Chowonbasicbutton); // 중식 식당 버튼들
	private JButton Yongbutton = new JButton(Yongbasicbutton);
	private JButton Soosinbutton = new JButton(Soosinbasicbutton);
	private JButton Bohwabutton = new JButton(Bohwabasicbutton);
	
	private JLabel Jfoodlabel = new JLabel(JfoodBasiclabel); // 중식 카테고리 라벨
	private JButton Wellbutton = new JButton(Wellbasicbutton); // 중식 식당 버튼들
	
	private JLabel Wfoodlabel = new JLabel(WfoodBasiclabel); // 중식 카테고리 라벨
	private JButton Yogitbutton = new JButton(Yogitbasicbutton); // 중식 식당 버튼들
	
	private JLabel Sfoodlabel = new JLabel(SfoodBasiclabel); // 중식 카테고리 라벨
	private JButton Sinjeonbutton = new JButton(Sinjeonbasicbutton); // 중식 식당 버튼들
	
	
	
	void KfoodCategory() {//한식 카테고리 음식점 버튼
		Kfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Wangbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Wangbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 왕십리 야식 버튼 눌렀을 때
			}
		});

		Jeulgyeobutton.setBounds(0, 200, 360, 100); // 버튼 위치 및 사이즈
		Jeulgyeobutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 즐겨먹기 버튼 눌렀을 때
			}
		});		
		
		Hansotbutton.setBounds(0, 300, 360, 100); // 버튼 위치 및 사이즈
		Hansotbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 한솥 버튼 눌렀을 때
			}
		});
		
		Sseonybutton.setBounds(0, 400, 360, 100); // 버튼 위치 및 사이즈
		Sseonybutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 써니 버튼 눌렀을 때
			}
		});
		
		}
	
	void CfoodCategory() {// 중식 카테고리 음식점 버튼
		Cfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Chowonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Chowonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		Yongbutton.setBounds(0, 200, 360, 100); // 버튼 위치 및 사이즈
		Yongbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 용짬뽕 버튼 눌렀을 때
			}
		});		
		
		Soosinbutton.setBounds(0, 300, 360, 100); // 버튼 위치 및 사이즈
		Soosinbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 수신 버튼 눌렀을 때
			}
		});
		
		Bohwabutton.setBounds(0, 400, 360, 100); // 버튼 위치 및 사이즈
		Bohwabutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 보화 버튼 눌렀을 때
			}
		});
		
		}
	
	void JfoodCategory() {//일식 카테고리 음식점 버튼
		Jfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Wellbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Wellbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		
		}
	
	void WfoodCategory() {//양식 카테고리 음식점 버튼
		Wfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Yogitbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Yogitbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		
		}
		
	void SfoodCategory() {//분식 카테고리 음식점 버튼 
		Sfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Sinjeonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Sinjeonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		
		}

}
	
