package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.PhieuMuonController;
import entity.PhieuMuon;

public class Panel_DSTraSach extends JPanel implements ActionListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTextField textField_Tim;
	private JTable table_TraSach;
	private JButton button;
	private JMenu mn_TrangChu;
	private JMenuItem mn_HT;
	private JMenuItem mn_DSDGia;
	private JButton btn_Qldg;
	private JButton btn_Qlpm;
	private JButton btn_Qls;
	private JButton btn_Qltk;
	private JMenuItem mn_DSTheHetHan;
	private JMenuItem mn_KhoSach;
	private JMenuItem mn_Muon;
	private JMenuItem mn_Tra;
	private JMenuItem mn_Dki;
	private JMenuItem mn_TKNam;
	private JButton btn_Thongtin;
	private JMenuItem mn_QLTK;
	private JButton btn_Thoat;
	private JMenuItem mn_TkHki;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane scroll;
	private JDateChooser txtNgayMuon;
	private JDateChooser txtNgayTra;
	private JTextField txtMaDauSach;
	private JTextField txtSL;

	
	private List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
	/**
	 * Create the panel.
	 */
	public Panel_DSTraSach() {
		setName("DANH SÁCH TRẢ SÁCH");
		setBounds(100, 100, 1295, 691);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.setBounds(0, 0, 1280, 33);
		add(menuBar);
		
		button = new JButton("Hệ thống");
		button.setMnemonic(KeyEvent.VK_G);
		button.setIcon(new ImageIcon("IMG/system-24.png"));
		button.addActionListener(this);
		button.setBackground(Color.WHITE);
		
		menuBar.add(button);
		
		JMenu mn_DG = new JMenu("Quản lí độc giả");
		mn_DG.setMnemonic(KeyEvent.VK_Q);
		mn_DG.setIcon(new ImageIcon("IMG/human.png"));
		menuBar.add(mn_DG);
		
		mn_DSDGia = new JMenuItem("Danh sách độc giả");
		mn_DSDGia.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mn_DSDGia.setIcon(new ImageIcon("IMG/list.png"));
		mn_DG.add(mn_DSDGia);
		mn_DSDGia.addActionListener(this);
		
		JMenuItem mn_Lthe = new JMenuItem("Lập thẻ độc giả");
		mn_Lthe.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		mn_Lthe.setIcon(new ImageIcon("IMG/card.png"));
		mn_Lthe.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new GUI.GUI_LapThe().setVisible(true);
			}
		});
		mn_DG.add(mn_Lthe);
		
//		mn_DSTheHetHan = new JMenuItem("Danh sách thẻ hết hạn");
//		mn_DSTheHetHan.setAccelerator(
//				KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
//		mn_DSTheHetHan.setIcon(new ImageIcon("IMG/card-2.png"));
//		mn_DG.add(mn_DSTheHetHan);
//		mn_DSTheHetHan.addActionListener(this);
		
		JMenu mn_Sach = new JMenu("Quản lí sách");
		mn_Sach.setMnemonic(KeyEvent.VK_L);
		mn_Sach.setIcon(new ImageIcon("IMG/quanly.png"));
		menuBar.add(mn_Sach);
		
		
		JMenuItem mn_BSSach = new JMenuItem("Bổ sung sách");
		mn_BSSach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		mn_BSSach.setIcon(new ImageIcon("IMG/add.png"));
		mn_BSSach.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new GUI.GUI_ThemSach().setVisible(true);
			}
		});
		mn_Sach.add(mn_BSSach);
		
		mn_KhoSach = new JMenuItem("Kho sách");
		mn_KhoSach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		mn_KhoSach.setIcon(new ImageIcon("IMG/books.png"));
		mn_Sach.add(mn_KhoSach);
		mn_KhoSach.addActionListener(this);
		
		JMenu Mn_QLMTS = new JMenu("Quản lí mượn - trả sách");
		Mn_QLMTS.setMnemonic(KeyEvent.VK_M);
		Mn_QLMTS.setIcon(new ImageIcon("IMG/bookmark.png"));
		menuBar.add(Mn_QLMTS);
		
		JMenuItem mn_PhieuMuon = new JMenuItem("Tạo phiếu mượn");
		mn_PhieuMuon.setIcon(new ImageIcon("IMG/add.png"));
		mn_PhieuMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new GUI.GUI_PhieuMuon().setVisible(true);
			}
		});
		Mn_QLMTS.add(mn_PhieuMuon);
		
		mn_Muon = new JMenuItem("Danh sách phiếu mượn");
		mn_Muon.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		mn_Muon.setIcon(new ImageIcon("IMG/add-bookmark.png"));
		Mn_QLMTS.add(mn_Muon);
		mn_Muon.addActionListener(this);
		
		mn_Tra = new JMenuItem("Phiếu mượn đã trả");
		mn_Tra.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
		mn_Tra.setIcon(new ImageIcon("IMG/bookmark-2.png"));
		Mn_QLMTS.add(mn_Tra);
		mn_Tra.addActionListener(this);
		
		mn_Dki = new JMenuItem("Phiếu mượn quá hạn");
		mn_Dki.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.ALT_MASK));
		mn_Dki.setIcon(new ImageIcon("IMG/card-2.png"));
		Mn_QLMTS.add(mn_Dki);
		mn_Dki.addActionListener(this);
		
		JMenu mn_QLTK = new JMenu("Quản lí thống kê");
		mn_QLTK.setMnemonic(KeyEvent.VK_T);
		mn_QLTK.setIcon(new ImageIcon("IMG/statistics-24.png"));
		menuBar.add(mn_QLTK);
		
		mn_TKNam = new JMenuItem("Thống kê theo năm học");
		mn_TKNam.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
		mn_TKNam.setIcon(new ImageIcon("IMG/play-graph-report.png"));
		mn_QLTK.add(mn_TKNam);
		mn_TKNam.addActionListener(this);
		
		mn_TkHki = new JMenuItem("Thống kê theo học kì");
		mn_TkHki.setMnemonic(KeyEvent.VK_O);
		mn_TkHki.setIcon(new ImageIcon("IMG/analytics-24.png"));
		mn_QLTK.add(mn_TkHki);
		mn_TkHki.addActionListener(this);
		
		
		
		
		
		JPanel panel_tks = new JPanel();
		panel_tks.setBackground(SystemColor.inactiveCaptionBorder);
		panel_tks.setBounds(10, 25, 1261, 95); // 10, 123, 1261, 121
		add(panel_tks);
		panel_tks.setLayout(null);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.addActionListener(this);
		btn_Thoat.setBounds(1115, 24, 136, 46);
		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_tks.add(btn_Thoat);
		
		JButton btn_TimKiem = new JButton("");
		btn_TimKiem.setBackground(Color.WHITE);
		btn_TimKiem.setBounds(10, 20, 72, 65);
		btn_TimKiem.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		panel_tks.add(btn_TimKiem);
		
		JButton btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.setBackground(Color.WHITE);
		btn_capnhat.setBounds(967, 24, 136, 46);
		btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capnhat.setIcon(new ImageIcon("IMG\\update-30.png"));
		panel_tks.add(btn_capnhat);
		
		JButton btn_ChinhSua = new JButton("Chỉnh sửa");
		btn_ChinhSua.setBackground(Color.WHITE);
		btn_ChinhSua.setIcon(new ImageIcon("IMG\\edit-30.png"));
		btn_ChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ChinhSua.setBounds(821, 24, 136, 46);
		panel_tks.add(btn_ChinhSua);
		
		JButton btn_Xoa = new JButton("Xóa");
		btn_Xoa.setBackground(Color.WHITE);
		btn_Xoa.setIcon(new ImageIcon("IMG\\delete-30.png"));
		btn_Xoa.setBounds(675, 25, 136, 46);
		panel_tks.add(btn_Xoa);
		
		textField_Tim = new JTextField();
		textField_Tim.setBounds(109, 20, 347, 65);
		panel_tks.add(textField_Tim);
		textField_Tim.setColumns(10);
		
		JScrollPane scroll;
		
		
		table = new JTable();
		
		String[] headers = "STT;ID;Ngày mượn;Ngày trả;Trạng thái;Người mượn (Đọc giả);Thủ thư".split(";");
		tablemodel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		scroll.setBounds(10, 250, 1261, 418);
		add(scroll);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 125, 1261, 116);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNgayMuon = new JLabel("Ngày Mượn:");
		lblNgayMuon.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayMuon.setBounds(20, 20, 175, 15);
		panel.add(lblNgayMuon);
		
		txtNgayMuon = new JDateChooser();
		txtNgayMuon.setBounds(120, 15, 175, 30);
		panel.add(txtNgayMuon);
		
		JLabel lblNgayTra = new JLabel("Ngày Trả:");
		lblNgayTra.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayTra.setBounds(20, 70, 175, 15);
		panel.add(lblNgayTra);
		txtNgayTra = new JDateChooser();
		txtNgayTra.setBounds(120, 65, 175, 30);
		panel.add(txtNgayTra);
		
		JLabel lblMaDauSach = new JLabel("Trạng Thái:");
		lblMaDauSach.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMaDauSach.setBounds(400, 20, 175, 15);
		panel.add(lblMaDauSach);
		
		txtMaDauSach = new JTextField();
		txtMaDauSach.setForeground(Color.BLACK);
		txtMaDauSach.setFont(new Font("Arial", Font.PLAIN, 18));
		txtMaDauSach.setColumns(10);
		txtMaDauSach.setBackground(Color.WHITE);
		txtMaDauSach.setBounds(550, 15, 175, 30);
		panel.add(txtMaDauSach);
		
		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(0, 0, 128));
//		panel.setBounds(10, 22, 1261, 95);
//		add(panel);
//		panel.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("DANH SÁCH TRẢ SÁCH");
//		lblNewLabel.setIcon(null);
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
//		lblNewLabel.setForeground(Color.WHITE);
//		lblNewLabel.setBackground(new Color(0, 0, 128));
//		lblNewLabel.setBounds(413, 11, 484, 73);
//		panel.add(lblNewLabel);
		
		
		loadData();
	}
	
	public void loadData() {
		PhieuMuonController phieuMuonController = new PhieuMuonController();
		List<PhieuMuon> phieuMuon = phieuMuonController.getPhieuMuonDaTra();
		if(phieuMuon!=null) {
			int i = 0;
			String stt;
			for(PhieuMuon s: phieuMuon) {
				i++;
				stt = String.valueOf(i);
				String ngayMuon = s.getNgayMuon().toString();
				String ngayTra = s.getNgayMuon().toString();
				String docgia = String.valueOf(s.getDocGia().getHoTen());
				String thuthu = String.valueOf(s.getThuThu().getHoTen());
				String [] rowData= {stt,
									s.getId(), 
									ngayMuon, 
									ngayTra,
									s.getTrangThai(), 
									docgia,
									thuthu};
				tablemodel.addRow(rowData);
				System.out.println(s.toString());
			}
			table.setModel(tablemodel);
		}
	}

	private void setLayout(float centerAlignment) {
		// TODO Auto-generated method stub
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(button)) {
			super.removeAll();
			Panel_Index index = new Panel_Index();
			index.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(index);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_DSDGia)) {
			super.removeAll();
			Panel_QLDocGia DSDGia = new Panel_QLDocGia();
			DSDGia.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(DSDGia);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_DSTheHetHan)) {
			super.removeAll();
			Panel_DSTheHetHan DSTheHH = new Panel_DSTheHetHan();
			DSTheHH.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(DSTheHH);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_KhoSach)) {
			super.removeAll();
			Panel_QLSach khoSach = new Panel_QLSach();
			khoSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(khoSach);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_Muon)) {
			super.removeAll();
			Panel_QLMuonTra muonSach = new Panel_QLMuonTra();
			muonSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(muonSach);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_Tra)) {
			super.removeAll();
			Panel_DSTraSach traSach = new Panel_DSTraSach();
			traSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(traSach);
			super.validate();
			super.repaint(); 
		} else if (o.equals(mn_Dki)) {
			super.removeAll();
			Panel_DSDKMuonSach dkMuonSach = new Panel_DSDKMuonSach();
			dkMuonSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(dkMuonSach);
			super.validate();
			super.repaint();  
		} else if (o.equals(btn_Thoat)) {
			super.removeAll();
			Panel_Index index = new Panel_Index();
			index.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(index);
			super.validate();
			super.repaint();
		}else if (o.equals(mn_TKNam)) {
			super.removeAll();
			Panel_ThongKe qlTK = new Panel_ThongKe();
			qlTK.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlTK);
			super.validate();
			super.repaint();
		}else if (o.equals(mn_TkHki)) {
			super.removeAll();
			Panel_ThongKe qlTK = new Panel_ThongKe();
			qlTK.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlTK);
			super.validate();
			super.repaint();
		}
		
	}
}
