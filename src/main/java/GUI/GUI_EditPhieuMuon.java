package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.ChiTietPhieuMuonController;
import controller.DocGiaController;
import controller.PhieuMuonController;
import controller.SachController;
import controller.ThuThuController;
import entity.ChiTietPhieuMuon;
import entity.DocGia;
import entity.PhieuMuon;
import entity.Sach;
import entity.ThuThu;

public class GUI_EditPhieuMuon extends JFrame implements ActionListener, MouseListener{

	public static final String NGAY_REG = "^\\d{2}\\/\\d{2}\\/\\d{4}$";
	public static final String SL_REG = "^[0-9]{1,15}$";
	private JPanel contentPane;
	private JTextField tf_tenSach;
	private JTextField txt_maDG;
	private JDateChooser textField_NgayTra;
	private JTextField txtSachId;
	private JComboBox<String> txtTrangThai;
	private JDateChooser txtField_Ngaymuon;
	private JButton btn_huy;
	private JButton btn_xacnhan;
	private JButton btn_timSach;
	private JButton btn_boChon;
	private JTextField txtMaThuThu;
	private String Ngaymuon;
	private String Ngaytra;
	private String SLa;
	private JTable table_PhieuMuon;
	private JTable table_pm;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane scroll;

	private PhieuMuon phieuMuon;
	private List<Sach> listSach = new ArrayList<Sach>();
	private List<Sach> listSachCTPM = new ArrayList<Sach>();
	private List<ChiTietPhieuMuon> listCTPM = new ArrayList<ChiTietPhieuMuon>();
	
	public PhieuMuon getPhieuMuon() {
		return phieuMuon;
	}

	public void setPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_EditPhieuMuon frame = new GUI_EditPhieuMuon(null);
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
	public GUI_EditPhieuMuon(PhieuMuon phieuMuon) {
		this.phieuMuon = phieuMuon;
		setTitle("Chỉnh sửa phiếu mượn");
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

		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(0, 0, 589, 731);
		contentPane.add(panel_1);
		
		JLabel lbl_TieuDe = new JLabel("CHỈNH SỬA PHIẾU MƯỢN");
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setForeground(Color.BLACK);
		lbl_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lbl_TieuDe.setBackground(SystemColor.activeCaption);
		lbl_TieuDe.setBounds(120, 11, 350, 53);
		panel_1.add(lbl_TieuDe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_2.setBounds(0, 75, 589, 630);
		panel_1.add(panel_2);
		
		JLabel lbl_TheLoai = new JLabel("Thủ thư:");
		lbl_TheLoai.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_TheLoai.setBounds(20, 20, 166, 30);
		panel_2.add(lbl_TheLoai);
		
		JLabel lbl_ten = new JLabel("Đọc giả:");
		lbl_ten.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_ten.setBounds(20, 80, 166, 30);
		panel_2.add(lbl_ten);
		
//		JLabel lbl_NhaSx = new JLabel("Trạng thái:");
//		lbl_NhaSx.setFont(new Font("Arial", Font.PLAIN, 16));
//		lbl_NhaSx.setBounds(21, 330, 166, 30);
//		panel_2.add(lbl_NhaSx);
		
//		JLabel lbl_ngay = new JLabel("Số lượng:");
//		lbl_ngay.setFont(new Font("Arial", Font.PLAIN, 16));
//		lbl_ngay.setBounds(21, 234, 166, 30); //21, 307, 166, 30
//		panel_2.add(lbl_ngay);
		
		txt_maDG = new JTextField();
		txt_maDG.setForeground(Color.BLACK);
		txt_maDG.setFont(new Font("Arial", Font.PLAIN, 16));
		txt_maDG.setColumns(10);
		txt_maDG.setBounds(170, 80, 336, 30);
		txt_maDG.setEditable(false);
		panel_2.add(txt_maDG);
		
		btn_xacnhan = new JButton("Sửa");
		btn_xacnhan.setIcon(new ImageIcon("IMG\\check.png"));
		btn_xacnhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_xacnhan.setBounds(170, 580, 120, 34);
		panel_2.add(btn_xacnhan);
		btn_xacnhan.addActionListener(this);
		
		btn_huy = new JButton("Hủy");
		btn_huy.setIcon(new ImageIcon("IMG\\cancel.png"));
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_huy.setBackground(Color.WHITE);
		btn_huy.setBounds(300, 580, 120, 34);
		panel_2.add(btn_huy);
		btn_huy.addActionListener(this);
		
		textField_NgayTra = new JDateChooser();
		textField_NgayTra.setBounds(170, 200, 334, 30); //169, 465, 336, 30
		panel_2.add(textField_NgayTra);
		
		JLabel lbl_GiaTien = new JLabel("Ngày mượn:");
		lbl_GiaTien.setFont(new Font("Arial", Font.PLAIN, 16));
		lbl_GiaTien.setBounds(20, 140, 166, 30); //21, 385, 166, 30
		panel_2.add(lbl_GiaTien);
		
//		txtTrangThai = new JTextField();
//		txtTrangThai.setForeground(Color.BLACK);
//		txtTrangThai.setFont(new Font("Arial", Font.PLAIN, 18));
//		txtTrangThai.setColumns(10);
//		txtTrangThai.setBackground(Color.WHITE);
//		txtTrangThai.setBounds(171, 330, 334, 30);
//		panel_2.add(txtTrangThai);
		
//		txtField_SoLuong = new JTextField();
//		txtField_SoLuong.setBounds(171, 234, 334, 30);
//		panel_2.add(txtField_SoLuong);
		
		JLabel lbl_SL = new JLabel("Ngày trả:");
		lbl_SL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SL.setBounds(20, 200, 166, 30); //21, 465, 81, 30
		panel_2.add(lbl_SL);
		
		//ngày mượn
		txtField_Ngaymuon = new JDateChooser();
		txtField_Ngaymuon.setBounds(170, 140, 334, 30); //169, 385, 336, 30
		panel_2.add(txtField_Ngaymuon);
		
		txtMaThuThu = new JTextField();
		txtMaThuThu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMaThuThu.setBounds(170, 20, 336, 30);
		txtMaThuThu.setEditable(false);
		panel_2.add(txtMaThuThu);
		
		JLabel lbl_TrangThai = new JLabel("Trạng thái:");
		lbl_TrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_TrangThai.setBounds(20, 260, 166, 30); //21, 465, 81, 30
		panel_2.add(lbl_TrangThai);
		
		txtTrangThai = new JComboBox<String>();
		txtTrangThai.setForeground(Color.BLACK);
		txtTrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTrangThai.setBackground(Color.WHITE);
		txtTrangThai.setBounds(170, 260, 336, 30);
		txtTrangThai.setEditable(false);
		txtTrangThai.addItem("Chưa trả");
		txtTrangThai.addItem("Đã trả");
		panel_2.add(txtTrangThai);
		
		JLabel lbl_LuuY = new JLabel("(*) Điền lần lượt từng mã sách");
		lbl_LuuY.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_LuuY.setForeground(Color.RED);
		lbl_LuuY.setBounds(170, 300, 166, 15); //21, 465, 81, 30
		panel_2.add(lbl_LuuY);
		
		JLabel lbl_SachId = new JLabel("Mã sách:");
		lbl_SachId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_SachId.setBounds(20, 320, 166, 30); //21, 465, 81, 30
		panel_2.add(lbl_SachId);
		
		txtSachId = new JTextField();
		txtSachId.setForeground(Color.BLACK);
		txtSachId.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSachId.setColumns(10);
		txtSachId.setBackground(Color.WHITE);
		txtSachId.setBounds(170, 320, 336, 30);
		panel_2.add(txtSachId);
		
		btn_timSach = new JButton("Tìm sách");
		btn_timSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_timSach.setBackground(Color.WHITE);
		btn_timSach.setBounds(170, 380, 120, 34);
		panel_2.add(btn_timSach);
		
		
		btn_boChon = new JButton("Bỏ chọn");
		btn_boChon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn_boChon.setBackground(Color.WHITE);
		btn_boChon.setBounds(300, 380, 120, 34);
		panel_2.add(btn_boChon);
		
		JScrollPane scroll;
		
		table = new JTable();
		String[] headers = "STT; Mã sách; Tên sách; Số lượng".split(";");
		tablemodel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);	
		scroll.setBounds(20, 440, 550, 130);
		panel_2.add(scroll);
		
		btn_boChon.addActionListener(this);
		btn_timSach.addActionListener(this);
		table.addMouseListener(this);
		
		
		
		getChiTietPhieuMuon();
	}
	
	public void getSach(String id) {
		SachController sachController = new SachController();
		Sach sach = new Sach();
		boolean checkexist = true;
		if(txtSachId.getText() == "" || txtSachId.getText().length() < 1)
		{
			JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sách");
			checkexist = false;
		}
		for(int i = 0; i < listSach.size(); i++) {
			if(listSach.get(i).getId().equalsIgnoreCase(txtSachId.getText())) {
				JOptionPane.showMessageDialog(this, "Sách này đã được thêm");
				txtSachId.setText("");
				checkexist = false;
			}
		}
		if(id != null && id.length() > 0 && checkexist == true) {
			sach = sachController.getSachById(id);
			if(sach != null) {
				listSach.add(sach);
			}else {
				sach = new Sach();
				sach.setId(id);
				sach.setTenSach("Không xác định");
				listSach.add(sach);
			}
			txtSachId.setText("");
		}
	}
	public void getChiTietPhieuMuon() {
		ChiTietPhieuMuonController chiTietPhieuMuonController = new ChiTietPhieuMuonController();
		listCTPM = chiTietPhieuMuonController.getChiTietPhieuMuonByIdPhieuMuon(phieuMuon.getId());
		for (int i = 0; i < listCTPM.size(); i++) {
			listSach.add(listCTPM.get(i).getSach());
			listSachCTPM.add(listCTPM.get(i).getSach());
		}
		loadData();
	}
	public void loadData() {
		txtMaThuThu.setText(phieuMuon.getThuThu().getHoTen());
		txt_maDG.setText(phieuMuon.getDocGia().getHoTen());
		txtField_Ngaymuon.setDate(phieuMuon.getNgayMuon());
		textField_NgayTra.setDate(phieuMuon.getNgayTra());
		int n = tablemodel.getRowCount();
		for (int i = 0; i < n; i++) {
			tablemodel.removeRow(0);
		}
		if(listSach!=null) {
			int i = 0;
			String stt;
			for(Sach s: listSach) {
				i++;
				stt = String.valueOf(i);
				if(s != null) {
					String sl = String.valueOf(1);
					String [] rowData= {stt,
										s.getId(), 
										s.getTenSach(), 
										sl};
					tablemodel.addRow(rowData);
					System.out.println(stt);
				}else {
					String [] rowData= {stt,
							s.getId(),
							"Không xác định"};
					tablemodel.addRow(rowData);
				}
			}
		}
		table.setModel(tablemodel);
		
		if(!txtTrangThai.getItemAt(0).toString().equalsIgnoreCase(phieuMuon.getTrangThai()) && txtTrangThai.getSelectedIndex() == 0) {
			txtTrangThai.setSelectedIndex(1);
		}else {
			txtTrangThai.setSelectedIndex(0);
		}
	}
	public boolean valid() {
		Date date = Calendar.getInstance().getTime();
		if(txtField_Ngaymuon.getDate().after(date))
		{
			JOptionPane.showMessageDialog(this, "Ngày mượn ít nhất phải là ngày hiện tại");
			return false;
		}
		if(textField_NgayTra.getDate().before(txtField_Ngaymuon.getDate()))
		{
			JOptionPane.showMessageDialog(this, "Ngày trả phải sau ngày mượn");
			return false;
		}
		if(listSach.size() < 1) {
			JOptionPane.showMessageDialog(this, "Phải mượn ít nhất 1 sách");
			return false;
		}
		for(int i = 0; i < listSach.size(); i++) {
			if(listSach.get(i).getTenSach() ==  "Không xác định") {
				JOptionPane.showMessageDialog(this, "Sách mượn không hợp lệ");
				return false;
			}
		}
		ChiTietPhieuMuonController chiTietPhieuMuonController = new ChiTietPhieuMuonController();
		for(int i = 0; i < table.getRowCount(); i++) {
			int soLuong = Integer.parseInt(tablemodel.getValueAt(i, 3).toString());
			if(soLuong < 1) {
				JOptionPane.showMessageDialog(this, "Số lượng sách "+listSach.get(i).getTenSach()+" không hợp lệ (ít nhất 1)");
				return false;
			}
			if(chiTietPhieuMuonController.kiemTraSoLuongSach(listSach.get(i), soLuong) == false)
			{
				JOptionPane.showMessageDialog(this, "Sách "+listSach.get(i).getTenSach()+" không đủ số lượng");
				return false;
			}
		}
		return true;
	}
	public void clearData() {
		txt_maDG.setText("");
		Date date  = Calendar.getInstance().getTime();
		txtField_Ngaymuon.setDate(date);
		textField_NgayTra.setDate(date);
		txtSachId.setText("");
		int n = tablemodel.getRowCount();
		for (int i = 0; i < n; i++) {
			tablemodel.removeRow(0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
//		SLa = txtField_SoLuong.getText();
		
		if (o.equals(btn_huy)) {
			dispose();
		}
		if (o.equals(btn_xacnhan)) {
			if(valid()) {
				String trangThai = "Chưa trả";
				Date date = txtField_Ngaymuon.getModel().getDate();
				java.sql.Date ngayMuon = new java.sql.Date(date.getTime());
				
				Date date1 = textField_NgayTra.getModel().getDate();
				java.sql.Date ngayTra = new java.sql.Date(date1.getTime());
				
				phieuMuon.setNgayMuon(ngayMuon);
				phieuMuon.setNgayTra(ngayTra);
				phieuMuon.setTrangThai(txtTrangThai.getSelectedItem().toString());
				
				PhieuMuonController muonController = new PhieuMuonController();
				ChiTietPhieuMuonController chiTietPhieuMuonController = new ChiTietPhieuMuonController();
				//chiTietPhieuMuonController.deleteAllChiTietPhieuMuonByPhieuMuonId(phieuMuon.getId());
				String phieuMuonId = phieuMuon.getId();
				if(phieuMuonId != null && phieuMuon != null) {
					ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon();
					chiTietPhieuMuon.setPhieuMuon(phieuMuon);
					int soLuong;
					for(int i = 0; i < listSach.size(); i++) {
						soLuong = Integer.parseInt(tablemodel.getValueAt(i, 3).toString());
						chiTietPhieuMuon.setSach(listSach.get(i));
						chiTietPhieuMuon.setSoLuong(soLuong);
						xuLyCTPM(chiTietPhieuMuon);
					}
					if(listSachCTPM != null && listSachCTPM.size() > 0){
						 for(int i = 0; i < listSachCTPM.size(); i++){
							if(!listSach.contains(listSachCTPM.get(i))) {
								chiTietPhieuMuon.setSach(listSachCTPM.get(i));
								boolean ktr = chiTietPhieuMuonController.deleteChiTietPhieuMuon(chiTietPhieuMuon);
								System.out.println("xóa sách thành công - "+chiTietPhieuMuon.getSach().toString());
							}
						}
					}
					JOptionPane.showMessageDialog(this, "Chỉnh sửa phiếu mượn thành công!");
					clearData();
				}else {
					JOptionPane.showMessageDialog(this, "Chỉnh sửa phiếu mượn thất bại! Vui lòng thử lại");
				}
			}
			
		}	
		if(o.equals(btn_timSach)) {
			getSach(txtSachId.getText());
			loadData();
		}
		if(o.equals(btn_boChon)) {
			if(table.getSelectedRow() != -1) {
				listSach.remove(table.getSelectedRow());
				tablemodel.removeRow(table.getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một sách cần hủy chọn");
			}
		}
//	            if (SLa.equals("")){
//            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");
//            return;
//        }else{
//            Pattern pattern = Pattern.compile(SL_REG);
//            Matcher matcher = pattern.matcher(SLa);
//            if(! matcher.matches()){
//                JOptionPane.showMessageDialog(this, "Số lượng là số nguyên dương, từ 0 đến 9");
//                return;
//            }
//        }
		
	}

	private void xuLyCTPM(ChiTietPhieuMuon chiTietPhieuMuon) {
		// TODO Auto-generated method stub
		ChiTietPhieuMuonController chiTietPhieuMuonController = new ChiTietPhieuMuonController();
		if(listSachCTPM != null) {
			if(listSachCTPM.size() > 0 && listSachCTPM.contains(chiTietPhieuMuon.getSach())) {
				chiTietPhieuMuonController.updateChiTietPhieuMuon(chiTietPhieuMuon);
				System.out.println("Cập nhật CTPM thành công - "+chiTietPhieuMuon.getSach().toString());
			}
			if(listSachCTPM.size() == 0 || !listSachCTPM.contains(chiTietPhieuMuon.getSach())) {
				String ktr = chiTietPhieuMuonController.addChiTietPhieuMuon(chiTietPhieuMuon);
				System.out.println(ktr +" - "+chiTietPhieuMuon.getSach().toString());
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource().equals(table)) {
//			loadData();
//		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
