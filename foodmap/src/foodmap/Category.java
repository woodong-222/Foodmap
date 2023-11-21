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
	//이미지는 변경 해야함 
	private ImageIcon KfoodBasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Wangbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Jeulgyeobasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Hansotbasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Sseonybasicbutton = new ImageIcon(Main.class.getResource(""));
	private ImageIcon Chowonbasicbutton = new ImageIcon(Main.class.getResource(""));
	
	
	private JLabel Kfoodlabel = new JLabel(KfoodBasicbutton); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton(Wangbasicbutton); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton(Jeulgyeobasicbutton);
	private JButton Hansotbutton = new JButton(Hansotbasicbutton);
	private JButton Sseonybutton = new JButton(Sseonybasicbutton);
	private JButton Chowonbutton = new JButton(Chowonbasicbutton);
	
	
	void KfoodCategory() {
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
		
		Chowonbutton.setBounds(0, 500, 360, 100); // 버튼 위치 및 사이즈
		Chowonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});
	}
	
	}
	

}