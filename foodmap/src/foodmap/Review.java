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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class Review extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;

    public Review() {
        setBounds(100, 100, 450, 218);
		setLocationRelativeTo(null); // 컴퓨터 정중앙
        getContentPane().setLayout(null);
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // 스피너 설정 부분
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0.0, 0.0, 5.0, 0.1);
        JSpinner spinner = new JSpinner(spinnerModel);
        spinner.setBounds(365, 36, 60, 22);
        getContentPane().add(spinner);
        
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
            public void actionPerformed(ActionEvent e) {
                // "등록" 버튼이 클릭되면 파일에 내용 저장
                saveToFile();
            }
        });

        // "취소" 버튼에 ActionListener 추가
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // "취소" 버튼이 클릭되면 다이얼로그를 닫음
                dispose();
            }
        });
    }

    // 파일에 내용 저장하는 메서드
    private void saveToFile() {
        // 파일 경로 및 파일명 설정 (본인의 프로젝트에 맞게 수정)
        String filePath = "..\reviews\review.txt";
        // 텍스트 필드의 내용 가져오기
        String text1 = textField.getText();
        String text2 = textField_1.getText();

        // 파일 쓰기 작업
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(text1 + " : " + text2);
            writer.newLine(); // 개행 문자 추가
            System.out.println("파일에 내용 저장 완료!");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("파일 저장 중 오류 발생");
        }
    }
}
