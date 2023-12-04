package foodmap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;

public class Review extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Restaurant restaurant; // Restaurant 객체에 대한 참조 추가
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Double> starComboBox;
	private ShowRestaurant showRestaurantPanel;

	public Review(Restaurant restaurant, ShowRestaurant showRestaurantPanel) {
		this.restaurant = restaurant;
		this.showRestaurantPanel = showRestaurantPanel;
    	setForeground(new Color(255, 255, 255));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Review.class.getResource("/images/logo.png")));
        setBounds(100, 100, 450, 218);
        setTitle("리뷰 작성");
		setLocationRelativeTo(null); // 컴퓨터 정중앙
        getContentPane().setLayout(null);
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        //콤보박스
		Double[] starOptions = { 0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0 };
		starComboBox = new JComboBox<>(starOptions);
		starComboBox.setBounds(365, 36, 60, 22);
		getContentPane().add(starComboBox);
        
        JLabel lblNewLabel = new JLabel("별점");
        lblNewLabel.setBounds(303, 39, 50, 15);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("닉네임");
        lblNewLabel_1.setBounds(27, 39, 50, 15);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(77, 36, 96, 21);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("리뷰");
        lblNewLabel_2.setBounds(27, 84, 50, 15);
        getContentPane().add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(77, 81, 318, 53);
        getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("등록");
        btnNewButton.setBounds(110, 144, 91, 23);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("취소");
        btnNewButton_1.setBounds(242, 144, 91, 23);
        getContentPane().add(btnNewButton_1);

        // "등록" 버튼에 ActionListener 추가
        btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveReview(); // 리뷰 저장 메소드 호출
			}
		});

		// "취소" 버튼에 ActionListener 추가
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "취소" 버튼이 클릭되면 다이얼로그를 닫음
				dispose();
				repaint();
			}
		});
	}

	private void saveReview() {
		String username = textField.getText();
	    String reviewContent = textField_1.getText();
	    Double selectedStar = (Double) starComboBox.getSelectedItem();

	    // 사용자 이름, 리뷰 내용, 선택된 별점이 모두 유효한지 확인합니다.
	    if (!username.isEmpty() && !reviewContent.isEmpty() && selectedStar != null) {
	        // Restaurant 객체에 리뷰를 추가합니다.
	        restaurant.addReview(username, reviewContent, selectedStar);

            showRestaurantPanel.ReviewsDisplay();
	        // 다이얼로그 창을 닫습니다.
	        dispose();
	    }
	}
}

