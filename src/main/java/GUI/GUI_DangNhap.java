package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.hibernate.cfg.PropertyHolder;

import controller.ThuThuController;
import entity.ThuThu;

public class GUI_DangNhap extends JFrame implements ActionListener {

	public static final String PASSWORD_REG = "^\\w+@[a-z]+.[a-z]{2,4}+$";
	Container container = getContentPane();
	JLabel userLabel = new JLabel("Tài khoản:");
	JLabel passwordLabel = new JLabel("Mật khẩu:");
	JTextField userTextField = new JTextField("thaianhhao");
	JPasswordField passwordField = new JPasswordField("123456");
	JButton loginButton = new JButton("");
	JButton resetButton = new JButton("");
	JCheckBox showPassword = new JCheckBox("Hiển thị mật khẩu");
	JLabel lbl_hinh = new JLabel("New label");
	JLabel lbl_TieuDe = new JLabel("ĐĂNG NHẬP");
	JLabel lbl_hinh1 = new JLabel("New label");
	private String pwdText;

	GUI_DangNhap() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		setBackground(SystemColor.inactiveCaptionBorder);

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 320, 100, 40);
		resetButton.setBounds(200, 320, 100, 40);
		loginButton.setIcon(new ImageIcon("IMG\\\\exit-30.png"));
		loginButton.setMnemonic(KeyEvent.VK_ENTER);
		loginButton.setBackground(Color.WHITE);
		resetButton.setBackground(Color.WHITE);
		lbl_hinh.setBounds(350, 20, 409, 385);
		lbl_hinh.setIcon(new ImageIcon("IMG\\Book-100.PNG"));
		lbl_TieuDe.setForeground(Color.DARK_GRAY);
		lbl_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbl_TieuDe.setBounds(80, 20, 600, 78);
		lbl_hinh1.setIcon(new ImageIcon("IMG\\1.jpg"));
		lbl_hinh1.setBounds(10, 20, 330, 78);
		resetButton.setIcon(new ImageIcon("IMG\\\\reset-30.png"));

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
		container.add(lbl_hinh);
		container.add(lbl_TieuDe);
		container.add(lbl_hinh1);

	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			if(userTextField.getText().length() < 1 || passwordField.getPassword().length < 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên đăng nhập và mật khẩu");
			}else {
				String userText;
				pwdText = "";
				userText = userTextField.getText();
				char[] pass = passwordField.getPassword();
				for(int i = 0 ; i < pass.length; i++) {
					pwdText += pass[i];
				}
				
				ThuThuController thuThuController = new ThuThuController();
				ThuThu user = thuThuController.getThuThuByAccount(userText, pwdText);
				if (user != null && user.getId() != null) {
					System.out.println(user.toString());
					new GUI.GUI_INDEX().setVisible(true);
					Toolkit.getDefaultToolkit().beep();
					dispose();
				}else{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác!");
				}
			}

		}
		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}
		}
	}

	public static void main(String[] a) {
		GUI_DangNhap frame = new GUI_DangNhap();
		frame.setTitle("ĐĂNG NHẬP");
		frame.setVisible(true);
		frame.setBounds(10, 10, 790, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("IMG/exit-30.png"));

	}

}

//if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("Nhom10diem@")) {
//Pattern pattern = Pattern.compile(PASSWORD_REG);
//Matcher matcher = pattern.matcher(pwdText);
//if (!matcher.matches()) {
//	new GUI.GUI_INDEX().setVisible(true);
//	Toolkit.getDefaultToolkit().beep();
//
//	dispose();
//}
//}