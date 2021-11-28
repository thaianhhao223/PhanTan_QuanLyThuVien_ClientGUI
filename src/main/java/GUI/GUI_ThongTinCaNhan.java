package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GUI_ThongTinCaNhan extends JFrame implements ActionListener{

	public static final String EMAIL_REG = "^\\w+@[a-z]+.[a-z]{2,4}+$";
	public static final String SDT_REG = "\\d{3}\\d{2}\\d{5}";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JButton btn_Thoat;
	private String Field_email;
	private String Field_Sdt;
	private JButton btn_ChinhSua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThongTinCaNhan frame = new GUI_ThongTinCaNhan();
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
	public GUI_ThongTinCaNhan() {
		setTitle("THÔNG TIN CÁ NHÂN");
		setIconImage(Toolkit.getDefaultToolkit().getImage("IMG/book-1000.png"));
		setBounds(100, 100, 605, 740);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
//		contentPane.setBackground(Color.WHITE);
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 571, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_HinhThuThu = new JLabel("");
		lbl_HinhThuThu.setIcon(new ImageIcon("IMG\\U.PNG"));
		lbl_HinhThuThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_HinhThuThu.setBounds(3, 5, 150, 125);
		panel_1.add(lbl_HinhThuThu);
		
		JLabel lbl_TenThuThu = new JLabel("THÔNG TIN CÁ NHÂN THỦ THƯ");
		lbl_TenThuThu.setBounds(170, 11, 600, 113);
		lbl_TenThuThu.setForeground(Color.DARK_GRAY);
		lbl_TenThuThu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		panel_1.add(lbl_TenThuThu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 157, 571, 454);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_ma = new JLabel("Mã thủ thư:");
		lbl_ma.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_ma.setBounds(23, 10, 129, 37);
		panel_2.add(lbl_ma);
		
		JLabel lbl_Dchi = new JLabel("Địa chỉ:");
		lbl_Dchi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_Dchi.setBounds(23, 134, 129, 37);
		panel_2.add(lbl_Dchi);
		
		JLabel lbl_Sdt = new JLabel("Số điện thoại:");
		lbl_Sdt.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_Sdt.setBounds(23, 250, 129, 37);
		panel_2.add(lbl_Sdt);
		
		JLabel lbl_email = new JLabel("Email:");
		lbl_email.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_email.setBounds(23, 371, 129, 37);
		panel_2.add(lbl_email);
		
		textField = new JTextField();
		textField.setBounds(203, 11, 286, 37);
		panel_2.add(textField);
		textField.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(203, 134, 286, 37);
		panel_2.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(203, 250, 286, 37);
		panel_2.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(203, 371, 286, 37);
		panel_2.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 622, 571, 67);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.addActionListener(this);
		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_Thoat.setBounds(312, 18, 133, 38);
		panel_3.add(btn_Thoat);
		
		btn_ChinhSua = new JButton("Chỉnh sửa");
		btn_ChinhSua.setBackground(Color.WHITE);
		btn_ChinhSua.setIcon(new ImageIcon("IMG\\edit_1.png"));
		btn_ChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_ChinhSua.setBounds(122, 18, 133, 38);
		panel_3.add(btn_ChinhSua);
		btn_ChinhSua.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		Field_email = txtEmail.getText();
		Field_Sdt = txtSDT.getText();
		
		
		if (o.equals(btn_Thoat)) {
			dispose();
		}
		if(Field_email.equals("")){
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập email");
            return;
        } else {
        Pattern pattern = Pattern.compile(EMAIL_REG);
        Matcher matcher = pattern.matcher(Field_email);
        if(! matcher.matches()){
        	JOptionPane.showMessageDialog(this, "Email chưa đúng định dạng");
            return;
        	}
        }
		if(Field_Sdt.equals("")){
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập số điện thoại");
            return;
        } else {
        Pattern pattern = Pattern.compile(SDT_REG);
        Matcher matcher = pattern.matcher(Field_Sdt);
        if(! matcher.matches()){
        	JOptionPane.showMessageDialog(this, "Số điện thoại chưa đúng định dạng");
            return;
        	}
		
        }
		
	}
}
