package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controller.LoaiSachController;
import controller.SachController;
import dao.SachDao;
import entity.LoaiSach;
import entity.Sach;

public class GUI_ThemSach extends JFrame implements ActionListener{

	public static final String NGAY_REG = "^\\d{2}\\/\\d{2}\\/\\d{4}$";
	public static final String SL_REG = "^[0-9]{1,15}$";
	public static final String DOUBLE_REG = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$";
	private JPanel contentPane;
	private JTextField tf_tenSach;
	private JTextField tf_TenTg;
	private JTextField textField_SL;
	private JTextField tf_NhaSx;
	private JTextField textField_GiaTien;
	private JButton btn_huy;
	private JButton btn_xacnhan;
	private JDateChooser dateChooser;
	private String Ngay;
	private String SLa;
	private String double1;
	private JComboBox comboBox_TheLoai;
	private List<LoaiSach> listLoaiSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ThemSach frame = new GUI_ThemSach();
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
	public GUI_ThemSach() {
		setTitle("THÊM SÁCH");
		setIconImage(Toolkit.getDefaultToolkit().getImage("IMG/book-1000.png"));
		setBounds(100, 100, 605, 770);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
//		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(0, 0, 589, 731);
		contentPane.add(panel_1);
		
		JLabel lbl_TieuDe = new JLabel("THÊM SÁCH");
//		lbl_TieuDe.setIcon(new ImageIcon("IMG\\plu.PNG"));
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setForeground(Color.BLACK);
		lbl_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lbl_TieuDe.setBackground(SystemColor.activeCaption);
		lbl_TieuDe.setBounds(133, 11, 316, 53);
		panel_1.add(lbl_TieuDe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(0, 75, 589, 630);
		panel_1.add(panel_2);
		
		JLabel lbl_TenSach = new JLabel("Tên sách:");
		lbl_TenSach.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_TenSach.setBounds(21, 11, 166, 30);
		panel_2.add(lbl_TenSach);
		
		tf_tenSach = new JTextField();
		tf_tenSach.setForeground(Color.BLACK);
		tf_tenSach.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tf_tenSach.setColumns(10);
		tf_tenSach.setBackground(Color.WHITE);
		tf_tenSach.setBounds(169, 11, 336, 30);
		panel_2.add(tf_tenSach);
		
		JLabel lbl_TheLoai = new JLabel("Thể loại:");
		lbl_TheLoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_TheLoai.setBounds(21, 77, 166, 30);
		panel_2.add(lbl_TheLoai);
		
		JLabel lbl_ten = new JLabel("Tên tác giả:");
		lbl_ten.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_ten.setBounds(21, 152, 166, 30);
		panel_2.add(lbl_ten);
		
		JLabel lbl_NhaSx = new JLabel("Tên nhà xuất bản:");
		lbl_NhaSx.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_NhaSx.setBounds(21, 234, 166, 30);
		panel_2.add(lbl_NhaSx);
		
		JLabel lbl_ngay = new JLabel("Ngày xuất bản:");
		lbl_ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_ngay.setBounds(21, 307, 166, 30);
		panel_2.add(lbl_ngay);
		
		tf_TenTg = new JTextField();
		tf_TenTg.setForeground(Color.BLACK);
		tf_TenTg.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tf_TenTg.setColumns(10);
		tf_TenTg.setBackground(Color.WHITE);
		tf_TenTg.setBounds(169, 152, 336, 30);
		panel_2.add(tf_TenTg);
		
		btn_xacnhan = new JButton("Xác nhận");
		btn_xacnhan.setIcon(new ImageIcon("IMG\\check.png"));
		btn_xacnhan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_xacnhan.setBackground(Color.WHITE);
		btn_xacnhan.setBounds(210, 528, 155, 34);
		panel_2.add(btn_xacnhan);
		btn_xacnhan.addActionListener(this);
		
		btn_huy = new JButton("Hủy");
		btn_huy.addActionListener(this);
		btn_huy.setIcon(new ImageIcon("IMG\\cancel.png"));
		btn_huy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_huy.setBackground(Color.WHITE);
		btn_huy.setBounds(392, 528, 89, 34);
		panel_2.add(btn_huy);
		btn_huy.addActionListener(this);
		
		textField_SL = new JTextField();
		textField_SL.setForeground(Color.BLACK);
		textField_SL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SL.setColumns(10);
		textField_SL.setBackground(Color.WHITE);
		textField_SL.setBounds(169, 465, 336, 30);
		panel_2.add(textField_SL);
		
		JLabel lbl_GiaTien = new JLabel("Giá tiền:");
		lbl_GiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_GiaTien.setBounds(21, 385, 166, 30);
		panel_2.add(lbl_GiaTien);
		
		tf_NhaSx = new JTextField();
		tf_NhaSx.setForeground(Color.BLACK);
		tf_NhaSx.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tf_NhaSx.setColumns(10);
		tf_NhaSx.setBackground(Color.WHITE);
		tf_NhaSx.setBounds(171, 234, 334, 30);
		panel_2.add(tf_NhaSx);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(169, 307, 336, 30);
		panel_2.add(dateChooser);
		
		JLabel lbl_SL = new JLabel("Số lượng:");
		lbl_SL.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_SL.setBounds(21, 465, 81, 30);
		panel_2.add(lbl_SL);
		
		textField_GiaTien = new JTextField();
		textField_GiaTien.setBounds(169, 385, 336, 30);
		textField_GiaTien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		panel_2.add(textField_GiaTien);
		textField_GiaTien.setColumns(10);
		
		comboBox_TheLoai = new JComboBox();
		comboBox_TheLoai.setBounds(169, 75, 336, 30);
		comboBox_TheLoai.setBackground(Color.WHITE);
		panel_2.add(comboBox_TheLoai);
		loadData();
		
	}
	
	public void loadData() {
		LoaiSachController loaiSachController = new LoaiSachController();
		listLoaiSach = loaiSachController.getAllLoaiSach();
		LoaiSach loaiSach;
		for (int i = 0; i < listLoaiSach.size(); i++) {
			loaiSach = listLoaiSach.get(i);
			comboBox_TheLoai.addItem(loaiSach.getTenLoai());
		}
		comboBox_TheLoai.addItem("Chưa phân loại");
	}
	
	
	public void clearData() {
		Date date = Calendar.getInstance().getTime();
		dateChooser.setDate(date);
		textField_GiaTien.setText("");
		textField_SL.setText("");
		tf_NhaSx.setText("");
		tf_tenSach.setText("");
		tf_TenTg.setText("");
	}
	public boolean valid() {
		//kiểm tra tính hợp lệ dữ liệu
		if (tf_tenSach.getText().length() < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sách");
            return false;
        }
		if (tf_TenTg.getText().length() < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên tác giả");
            return false;
        }  
		if (tf_NhaSx.getText().length() < 1){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên nhà xuất bản");
            return false;
        }  
		Date date = Calendar.getInstance().getTime();
		if (dateChooser.getModel().getDate().after(date)){
            JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn ngày xuất bản cho chính xác");
            return false;
        }
		int giatien = Integer.parseInt(textField_GiaTien.getText());
		if (giatien < 0){
            JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập giá tiền cho chính xác (nhập 0 nếu là sách quyên tặng)");
            return false;
        }  
		int sl = Integer.parseInt(textField_SL.getText()) ;
		if (sl <= 1){
            JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập số lượng cho chính xác (lớn hơn 0)");
            return false;
        }  
		return true;
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		SLa = textField_SL.getText();
		double1 = textField_GiaTien.getText();
		
		
		if (o.equals(btn_huy)) {
			dispose();
		}
		if (o.equals(btn_xacnhan)) {
			if(valid()) {
				String tensach = tf_tenSach.getText();
				String tentg =tf_TenTg.getText();
				int sl = Integer.parseInt(textField_SL.getText()) ;
				String tennhasx =tf_NhaSx.getText();
				int giatien = Integer.parseInt(textField_GiaTien.getText());
				Date date = dateChooser.getModel().getDate();
				java.sql.Date ngayXB = new java.sql.Date(date.getTime());
				
				Sach sach = new Sach(tensach, tentg, ngayXB, tennhasx, giatien, sl);
				LoaiSachController loaiSachController = new LoaiSachController();
				
				if(!comboBox_TheLoai.getSelectedItem().toString().equalsIgnoreCase("Chưa phân loại")) {
					sach.setLoaiSach(listLoaiSach.get(comboBox_TheLoai.getSelectedIndex()));
				}else {
					sach.setLoaiSach(null);
				}
			
				SachController sachController = new SachController();
				
				//Thêm sách
				sachController.addSach(sach);
				JOptionPane.showMessageDialog(this, "Thêm sách thành công");
				clearData();
			}
			
		}
		
	}
}
