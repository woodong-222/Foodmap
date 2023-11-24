package foodmap;

import foodmap.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Category extends JPanel {
	// 이미지는 추가 해야함

	private JLabel Kfoodlabel = new JLabel("한식"); // 한식 카테고리 라벨
	private JButton Wangbutton = new JButton("A"); // 한식 식당 버튼들
	private JButton Jeulgyeobutton = new JButton("B");
	private JButton Hansotbutton = new JButton("C");
	private JButton Sseonybutton = new JButton("D");

	private JLabel Cfoodlabel = new JLabel("중식");// 중식 카테고리 라벨
	private JButton Chowonbutton = new JButton("A"); // 중식 식당 버튼들
	private JButton Yongbutton = new JButton("B");
	private JButton Soosinbutton = new JButton("C");
	private JButton Bohwabutton = new JButton("D");

	private JLabel Jfoodlabel = new JLabel("일식"); // 일식 카테고리 라벨
	private JButton Wellbutton = new JButton("A"); // 일식 식당 버튼들

	private JLabel Wfoodlabel = new JLabel("양식"); // 일식 카테고리 라벨
	private JButton Yogitbutton = new JButton("A"); // 일식 식당 버튼들

	private JLabel Sfoodlabel = new JLabel("중식"); // 중식 카테고리 라벨
	private JButton Sinjeonbutton = new JButton("A"); // 중식 식당 버튼들

	
	public Category() 
	{
		// 한식
		Kfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈
	    Kfoodlabel.setVisible(true);
	    
		Wangbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
	    Wangbutton.setVisible(true);
		Wangbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 왕십리 야식 버튼 눌렀을 때
			}
		});
		Jeulgyeobutton.setBounds(0, 200, 360, 100); // 버튼 위치 및 사이즈
	    Jeulgyeobutton.setVisible(true);
		Jeulgyeobutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 즐겨먹기 버튼 눌렀을 때
			}
		});

		Hansotbutton.setBounds(0, 300, 360, 100); // 버튼 위치 및 사이즈
	    Hansotbutton.setVisible(true);
		Hansotbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 한솥 버튼 눌렀을 때
			}
		});

		Sseonybutton.setBounds(0, 400, 360, 100); // 버튼 위치 및 사이즈
	    Sseonybutton.setVisible(true);
		Sseonybutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 써니 버튼 눌렀을 때
			}
		});
		
		// 중식
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
		
		// 일식
		Jfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Wellbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Wellbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});
		
		// 양식
		Wfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Yogitbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Yogitbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});
		
		//분식
		Sfoodlabel.setBounds(0, 0, 360, 100); // 버튼 위치 및 사이즈

		Sinjeonbutton.setBounds(0, 100, 360, 100); // 버튼 위치 및 사이즈
		Sinjeonbutton.addMouseListener(new MouseAdapter() { // 재정의
			@Override
			public void mousePressed(MouseEvent e) { // 마우스 눌렀을 때
				// 초원 버튼 눌렀을 때
			}
		});

		add(Kfoodlabel);
		add(Wangbutton);
		add(Jeulgyeobutton);
		add(Hansotbutton);
		add(Sseonybutton);
	}

	public void KfoodCategory() { // 카테고리 스크린
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
}
