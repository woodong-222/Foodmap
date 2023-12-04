package foodmap;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Sharefinsh extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public Sharefinsh() {
        setBounds(100, 100, 291, 132);
        setTitle("공유");
		setLocationRelativeTo(null); // 컴퓨터 정중앙
        getContentPane().setLayout(null);
        contentPanel.setLayout(null);
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblNewLabel = new JLabel("공유되었습니다.");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
        lblNewLabel.setVerticalAlignment(JLabel.CENTER);
		lblNewLabel.setBounds(12, 27, 253, 15);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(90, 62, 91, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}
}
