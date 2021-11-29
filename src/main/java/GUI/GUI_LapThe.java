package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DocGiaController;
import entity.DocGia;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUI_LapThe extends JFrame implements ActionListener{

	public static final String EMAIL_REG = "^\\w+@[a-z]+.[a-z]{2,4}+$";
	public static final String SDT_REG = "\\d{3}\\d{2}\\d{5}";
	private JPanel contentPane;
	private JTextField tf_ten;
	private JTextField textField_chucvu;
	private JTextField textField_Sdt;
	private JButton btn_xacnhan;
	private JButton btn_huy;
	private String patternDate;
	private String Field_Sdt;
	private JTextField textField_Email;
	private String Field_email;
	private JTextField txtChuyenNganh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_LapThe frame = new GUI_LapThe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_LapThe() {
		setTitle("LẬP THẺ ĐỘC GIẢ\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("IMG/book-1000.png"));
		setBounds(100, 100, 570, 710);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
//		panel.setBackground(Color.DARK_GRAY);
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(2, 2, 715, 722);
		contentPane.add(panel);
		
		JLabel lblTitle = new JLabel("LẬP THẺ ĐỘC GIẢ\r\n");
		lblTitle.setIcon(null);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblTitle.setBackground(SystemColor.activeCaption);
		lblTitle.setBounds(146, 11, 290, 53);
		panel.add(lblTitle);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(1, 70, 570, 570);
		panel.add(contentPane_1);
		
		
		JLabel lblTen = new JLabel("Họ và tên:");
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTen.setBounds(40, 78, 126, 30);
		contentPane_1.add(lblTen);
		
		tf_ten = new JTextField();
		tf_ten.setForeground(Color.BLACK);
		tf_ten.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tf_ten.setColumns(10);
		tf_ten.setBackground(Color.WHITE);
		tf_ten.setBounds(197, 78, 304, 30);
		contentPane_1.add(tf_ten);
		
		JLabel lblMa = new JLabel("Chức vụ:");
		lblMa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMa.setBounds(40, 142, 126, 30);
		contentPane_1.add(lblMa);
		
		JLabel lbl_Email = new JLabel("Email:");
		lbl_Email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_Email.setBounds(40, 266, 166, 30); //40, 397, 126, 30
		contentPane_1.add(lbl_Email);
		
//		JLabel lblKhoa = new JLabel("Chuyên ngành:");
//		lblKhoa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblKhoa.setBounds(40, 203, 166, 30);
//		contentPane_1.add(lblKhoa);
		
//		JLabel lblLop = new JLabel("Lớp:");
//		lblLop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		lblLop.setBounds(40, 334, 166, 30);
//		contentPane_1.add(lblLop);
		
		btn_xacnhan = new JButton("Xác nhận");
		btn_xacnhan.addActionListener(this);
		btn_xacnhan.setIcon(new ImageIcon("IMG\\check.png"));
		btn_xacnhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_xacnhan.setBackground(Color.WHITE);
		btn_xacnhan.setBounds(210, 450, 126, 34);
		contentPane_1.add(btn_xacnhan);
		
		
		btn_huy = new JButton("Hủy");
		btn_huy.addActionListener(this);
		btn_huy.setBackground(Color.WHITE);
		btn_huy.setIcon(new ImageIcon("IMG\\cancel.png"));
		btn_huy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_huy.setBounds(360, 450, 119, 34);
		contentPane_1.add(btn_huy);
		
		textField_chucvu = new JTextField();
		textField_chucvu.setForeground(Color.BLACK);
		textField_chucvu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_chucvu.setColumns(10);
		textField_chucvu.setBackground(Color.WHITE);
		textField_chucvu.setBounds(197, 142, 304, 30);
		contentPane_1.add(textField_chucvu);
		
//		JComboBox comboBox_Khoa = new JComboBox();
//		comboBox_Khoa.setBounds(197, 203, 304, 30);
//		contentPane_1.add(comboBox_Khoa);
//		
//		JComboBox comboBox_Lop = new JComboBox();
//		comboBox_Lop.setBounds(197, 334, 304, 34);
//		contentPane_1.add(comboBox_Lop);
		
		textField_Email = new JTextField();
		textField_Email.setForeground(Color.BLACK);
		textField_Email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Email.setBounds(197, 267, 304, 32); //197, 402, 304, 34
		contentPane_1.add(textField_Email);
		
		JLabel lbl_CVu = new JLabel("Chuyên ngành:");
		lbl_CVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_CVu.setBounds(40, 203, 166, 30); //
		contentPane_1.add(lbl_CVu);
		
		textField_Sdt = new JTextField();
		textField_Sdt.setForeground(Color.BLACK);
		textField_Sdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_Sdt.setBounds(197, 340, 304, 36);
		contentPane_1.add(textField_Sdt);
		textField_Sdt.setColumns(10);

		
		JLabel lblNewLabel_Sdt = new JLabel("Số điện thoại:");
		lblNewLabel_Sdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_Sdt.setBounds(40, 340, 133, 38);
		contentPane_1.add(lblNewLabel_Sdt);
		
		txtChuyenNganh = new JTextField();
		txtChuyenNganh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChuyenNganh.setBounds(197, 203, 304, 30); //197, 267, 304, 32
		contentPane_1.add(txtChuyenNganh);
		
	}
	public boolean valid() {
		if(tf_ten.getText().length() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập tên");
			return false;
		}
		if(textField_chucvu.getText().length() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chức vụ");
			return false;
		}
		if(txtChuyenNganh.getText().length() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chuyên ngành");
			return false;
		}
		if(textField_Email.getText().length() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập email");
			return false;
		}
		//String regex = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
		String regex = "^\\w+@[a-z]+.[a-z]{2,4}+$";
		if(textField_Email.getText().length() < 1) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập email");
			return false;
		}
		if(!textField_Email.getText().matches(regex)) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập chính xác email");
			return false;
		}
		regex = "\\d{10}";
		if(! textField_Sdt.getText().matches(regex)) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số điện thoại (10 số)");
			return false;
		}
		return true;
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		Field_email = textField_Email.getText();
		Field_Sdt = textField_Sdt.getText();
		
		if (o.equals(btn_huy)) {
			dispose();
		}
		if (o.equals(btn_xacnhan)) {
			if(valid()) {
				String email = textField_Email.getText();
				String ten =tf_ten.getText();
				String chucvu =textField_chucvu.getText();
				String sdt =textField_Sdt.getText();
				String chuyennganh =txtChuyenNganh.getText();
				
				DocGia docgia = new DocGia(ten, sdt, email, chucvu, chuyennganh);
				DocGiaController docGiaController = new DocGiaController();
				docGiaController.addDocGia(docgia);
				JOptionPane.showMessageDialog(this, "Lập thẻ độc giả thành công");
			}
		}
	}
}
