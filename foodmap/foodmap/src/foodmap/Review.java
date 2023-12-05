package foodmap;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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
    public JLabel contentLabel; // 여기에 contentLabel 선언

    public Review() {
    	
    	contentLabel = new JLabel(); // contentLabel 초기화
        contentLabel.setBounds(0, 222, 360, 420); // 적절한 크기 및 위치 설정
        getContentPane().add(contentLabel);
        
        setBounds(100, 100, 450, 218);
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
                displayFileContent();
                dispose();
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
    	String filePath = "C:/Users/juhoj/Desktop/허명철 시발련/Foodmap/foodmap/src/reviews/review.txt";
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
    
    public void displayFileContent() {
        // 파일 경로 및 파일명 설정 (본인의 프로젝트에 맞게 수정)
        String filePath = "C:/Users/juhoj/Desktop/허명철 시발련/Foodmap/foodmap/src/reviews/review.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            
            // 파일에서 각 줄을 읽어와 StringBuilder에 추가
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // StringBuilder에 저장된 내용을 JLabel에 표시
            // 여기서는 contentLabel이라는 JLabel을 가정합니다.
            contentLabel.setText("<html>" + content.toString() + "</html>");

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("파일 읽기 중 오류 발생");
        }
    }
    
    public JLabel getContentLabel() {
        return contentLabel;
    }
    
}
