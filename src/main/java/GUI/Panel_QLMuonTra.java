package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controller.ChiTietPhieuMuonController;
import controller.PhieuMuonController;
import entity.ChiTietPhieuMuon;
import entity.PhieuMuon;

public class Panel_QLMuonTra extends JPanel implements ActionListener, MouseListener, ItemListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTextField textField;
	private JTable table_Sach;
	private JButton button;
	private JMenu mn_TrangChu;
	private JMenuItem mn_HT;
	private JMenuItem mn_DSDGia;
	private JButton btn_Qldg;
	private JButton btn_Qlpm;
	private JButton btn_Qls;
	private JButton btn_Qltk;
	private JButton btn_timSach;
	private JMenuItem mn_DSTheHetHan;
	private JMenuItem mn_KhoSach;
	private JMenuItem mn_Muon;
	private JMenuItem mn_Tra;
	private JMenuItem mn_Dki;
	private JMenuItem mn_TKNam;
	private JButton btn_Thongtin;
	private JMenuItem mn_QLTK;
	private JButton btn_DST;
	private JButton btn_DSDK;
	private JButton btn_DSS;
	private JButton btn_Thoat;
	private JButton btn_ChinhSua;
	private JButton btn_traPhieuMuon;
	private JButton btn_TimKiem;
	private JMenuItem mn_TkHki;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane scroll;
	private JDateChooser txtNgayMuon;
	private JDateChooser txtNgayTra;
	private JComboBox<String> txtMaDauSach;
	private JComboBox<String> txtSL;
	private JComboBox<String> cbxTrangThai;
	private JTextField txtSDT;

	
	private List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
	/**
	 * Create the panel.
	 */
	public Panel_QLMuonTra() {
		setName("QU???N L?? M?????N TR??? S??CH");
		setBounds(100, 100, 1295, 691);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
		menuBar.setBounds(0, 0, 1280, 33);
		add(menuBar);
		
		button = new JButton("H??? th???ng");
		button.setMnemonic(KeyEvent.VK_G);
		button.setIcon(new ImageIcon("IMG/system-24.png"));
		button.addActionListener(this);
		button.setBackground(Color.WHITE);
		
		menuBar.add(button);
		
		JMenu mn_DG = new JMenu("Qu???n l?? ?????c gi???");
		mn_DG.setMnemonic(KeyEvent.VK_Q);
		mn_DG.setIcon(new ImageIcon("IMG/human.png"));
		menuBar.add(mn_DG);
		
		mn_DSDGia = new JMenuItem("Danh s??ch ?????c gi???");
		mn_DSDGia.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		mn_DSDGia.setIcon(new ImageIcon("IMG/list.png"));
		mn_DG.add(mn_DSDGia);
		mn_DSDGia.addActionListener(this);
		
		JMenuItem mn_Lthe = new JMenuItem("L???p th??? ?????c gi???");
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
		
//		mn_DSTheHetHan = new JMenuItem("Danh s??ch th??? h???t h???n");
//		mn_DSTheHetHan.setAccelerator(
//				KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
//		mn_DSTheHetHan.setIcon(new ImageIcon("IMG/card-2.png"));
//		mn_DG.add(mn_DSTheHetHan);
//		mn_DSTheHetHan.addActionListener(this);
		
		JMenu mn_Sach = new JMenu("Qu???n l?? s??ch");
		mn_Sach.setMnemonic(KeyEvent.VK_L);
		mn_Sach.setIcon(new ImageIcon("IMG/quanly.png"));
		menuBar.add(mn_Sach);
		
		
		JMenuItem mn_BSSach = new JMenuItem("B??? sung s??ch");
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
		
		mn_KhoSach = new JMenuItem("Kho s??ch");
		mn_KhoSach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		mn_KhoSach.setIcon(new ImageIcon("IMG/books.png"));
		mn_Sach.add(mn_KhoSach);
		mn_KhoSach.addActionListener(this);
		
		JMenu Mn_QLMTS = new JMenu("Qu???n l?? m?????n - tr??? s??ch");
		Mn_QLMTS.setMnemonic(KeyEvent.VK_M);
		Mn_QLMTS.setIcon(new ImageIcon("IMG/bookmark.png"));
		menuBar.add(Mn_QLMTS);
		
		JMenuItem mn_PhieuMuon = new JMenuItem("T???o phi???u m?????n");
		mn_PhieuMuon.setIcon(new ImageIcon("IMG/add.png"));
		mn_PhieuMuon.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new GUI.GUI_PhieuMuon().setVisible(true);
			}
		});
		Mn_QLMTS.add(mn_PhieuMuon);
		
		mn_Muon = new JMenuItem("Danh s??ch phi???u m?????n");
		mn_Muon.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		mn_Muon.setIcon(new ImageIcon("IMG/add-bookmark.png"));
		Mn_QLMTS.add(mn_Muon);
		mn_Muon.addActionListener(this);
		
		mn_Tra = new JMenuItem("Phi???u m?????n ???? tr???");
		mn_Tra.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
		mn_Tra.setIcon(new ImageIcon("IMG/bookmark-2.png"));
		Mn_QLMTS.add(mn_Tra);
		mn_Tra.addActionListener(this);
		
		mn_Dki = new JMenuItem("Phi???u m?????n qu?? h???n");
		mn_Dki.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.ALT_MASK));
		mn_Dki.setIcon(new ImageIcon("IMG/card-2.png"));
		Mn_QLMTS.add(mn_Dki);
		mn_Dki.addActionListener(this);
		
		JMenu mn_QLTK = new JMenu("Qu???n l?? th???ng k??");
		mn_QLTK.setMnemonic(KeyEvent.VK_T);
		mn_QLTK.setIcon(new ImageIcon("IMG/statistics-24.png"));
		menuBar.add(mn_QLTK);
		
		mn_TKNam = new JMenuItem("Th???ng k?? theo n??m h???c");
		mn_TKNam.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_9, ActionEvent.ALT_MASK));
		mn_TKNam.setIcon(new ImageIcon("IMG/play-graph-report.png"));
		mn_QLTK.add(mn_TKNam);
		mn_TKNam.addActionListener(this);
		
		mn_TkHki = new JMenuItem("Th???ng k?? theo h???c k??");
		mn_TkHki.setMnemonic(KeyEvent.VK_O);
		mn_TkHki.setIcon(new ImageIcon("IMG/analytics-24.png"));
		mn_QLTK.add(mn_TkHki);
		mn_TkHki.addActionListener(this);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(10, 22, 1261, 116); // 10, 123, 1261, 121
		add(panel_1);
		panel_1.setLayout(null);
		
		btn_Thoat = new JButton("Tho??t");
		btn_Thoat.addActionListener(this);
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.setBounds(1115, 40, 136, 65);
		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(btn_Thoat);
		
		btn_TimKiem = new JButton("");
		btn_TimKiem.setBackground(Color.WHITE);
		btn_TimKiem.setBounds(221, 40, 72, 65);
		btn_TimKiem.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		panel_1.add(btn_TimKiem);
		
		JButton btn_Tieude = new JButton("PHI???U M?????N");
		btn_Tieude.setBounds(10, 20, 201, 94);
		btn_Tieude.setIcon(null);
		btn_Tieude.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_Tieude.setForeground(new Color(0, 0, 0));
		btn_Tieude.setBackground(new Color(152, 251, 152));
		panel_1.add(btn_Tieude);
		
		btn_traPhieuMuon = new JButton("C???p nh???t");
		btn_traPhieuMuon.setBackground(Color.WHITE);
		btn_traPhieuMuon.setBounds(968, 40, 136, 65);
		btn_traPhieuMuon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_traPhieuMuon.setIcon(new ImageIcon("IMG\\update-30.png"));
		panel_1.add(btn_traPhieuMuon);
		
		btn_ChinhSua = new JButton("Ch???nh s???a");
		btn_ChinhSua.setBackground(Color.WHITE);
		btn_ChinhSua.setIcon(new ImageIcon("IMG\\edit-30.png"));
		btn_ChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ChinhSua.setBounds(822, 40, 136, 65);
		panel_1.add(btn_ChinhSua);
		
		JButton btn_Xoa = new JButton("X??a");
		btn_Xoa.setBackground(Color.WHITE);
		btn_Xoa.setIcon(new ImageIcon("IMG\\delete-30.png"));
		btn_Xoa.setBounds(676, 40, 136, 66);
		panel_1.add(btn_Xoa);
		
		textField = new JTextField();
		textField.setBounds(303, 41, 293, 65);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		panel_1.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 255, 1261, 388);
		add(scrollPane_1);
		
		table = new JTable();
		String[] header = {"STT", "M?? phi???u m?????n", "Ng??y m?????n", 
				"Ng??y h???n tr???","T??nh tr???ng", "Ng?????i m?????n (?????c gi???)", "Th??? th??" };
		tablemodel = new DefaultTableModel(header, 0);
		scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tablemodel));
		table.setRowHeight(20);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane_1.setViewportView(scroll);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 140, 1261, 116);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNgayMuon = new JLabel("Ng??y M?????n:");
		lblNgayMuon.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayMuon.setBounds(20, 20, 175, 15);
		panel.add(lblNgayMuon);
		
		txtNgayMuon = new JDateChooser();
		txtNgayMuon.setBounds(120, 15, 175, 30);
		panel.add(txtNgayMuon);
		
		JLabel lblNgayTra = new JLabel("Ng??y Tr???:");
		lblNgayTra.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayTra.setBounds(20, 70, 175, 15);
		panel.add(lblNgayTra);
		
		txtNgayTra = new JDateChooser();
		txtNgayTra.setBounds(120, 65, 175, 30);
		panel.add(txtNgayTra);
		
		JLabel lblMaDauSach = new JLabel("M?? ?????u S??ch:");
		lblMaDauSach.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMaDauSach.setBounds(400, 20, 175, 15);
		panel.add(lblMaDauSach);
		
		txtMaDauSach = new JComboBox<String>();
		txtMaDauSach.setForeground(Color.BLACK);
		txtMaDauSach.setBackground(Color.WHITE);
		txtMaDauSach.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtMaDauSach.setBackground(Color.WHITE);
		txtMaDauSach.setBounds(550, 15, 175, 30);
		panel.add(txtMaDauSach);
		
		JLabel lblTrangThai = new JLabel("Tr???ng th??i:");
		lblTrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTrangThai.setBounds(770, 20, 175, 15);
		panel.add(lblTrangThai);
		
		cbxTrangThai = new JComboBox<String>();
		cbxTrangThai.setForeground(Color.BLACK);
		cbxTrangThai.setFont(new Font("Arial", Font.PLAIN, 18));
		
		cbxTrangThai.setBackground(Color.WHITE);
		cbxTrangThai.setBounds(850, 15, 175, 30);
		cbxTrangThai.setEditable(false);
		cbxTrangThai.addItem("Ch??a tr???");
		cbxTrangThai.addItem("???? tr???");
		panel.add(cbxTrangThai);
		
		JLabel lblSL = new JLabel("S??? L?????ng:");
		lblSL.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSL.setBounds(400, 70, 175, 15);
		panel.add(lblSL);
		
		txtSL = new JComboBox<String>();
		txtSL.setForeground(Color.BLACK);
		txtSL.setFont(new Font("Arial", Font.PLAIN, 18));
		
		txtSL.setBackground(Color.WHITE);
		txtSL.setBounds(550, 65, 175, 30);
		txtSL.setEditable(true);
		txtSL.setEditable(false);
		panel.add(txtSL);
		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
//		panel_2.setBounds(10, 22, 1261, 95);
//		add(panel_2);
//		panel_2.setLayout(null);
		
//		btn_DSS = new JButton("Danh s??ch m?????n s??ch");
//		btn_DSS.setBackground(Color.WHITE);
//		btn_DSS.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		btn_DSS.setIcon(new ImageIcon("IMG\\add-list-50.PNG"));
//		btn_DSS.setBounds(10, 20, 280, 73);
//		panel_2.add(btn_DSS);
//		
//		btn_DSS.addActionListener(this);
//		
//		btn_DST = new JButton("Danh s??ch tr??? s??ch");
//		btn_DST.addActionListener(this);
//		btn_DST.setBackground(Color.WHITE);
//		btn_DST.setIcon(new ImageIcon("IMG\\check-list-50.PNG"));
//		btn_DST.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		btn_DST.setBounds(300, 20, 280, 73);
//		panel_2.add(btn_DST);
//		
//		btn_DSDK = new JButton("Danh s??ch ????ng k?? m?????n s??ch");
//		btn_DSDK.addActionListener(this);
//		btn_DSDK.setBackground(Color.WHITE);
//		btn_DSDK.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//		btn_DSDK.setIcon(new ImageIcon("IMG\\to-do-list-49.png"));
//		btn_DSDK.setBounds(590, 20, 340, 73);
//		panel_2.add(btn_DSDK);	
		
		table.addMouseListener(this);
		txtSL.addItemListener(this);
		txtMaDauSach.addItemListener(this);
		
		txtMaDauSach.addActionListener(this);
		txtSL.addActionListener(this);
		
		btn_ChinhSua.addActionListener(this);
		btn_TimKiem.addActionListener(this);
		btn_traPhieuMuon.addActionListener(this);
		
		loadData();
		
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
		if(e.getSource().equals(txtMaDauSach)) {
			if(txtMaDauSach.getSelectedIndex() != -1 && txtSL.getItemCount() ==  txtMaDauSach.getItemCount())
				txtSL.setSelectedIndex(txtMaDauSach.getSelectedIndex());
		}
		if(e.getSource().equals(txtSL)) {
			if(txtMaDauSach.getSelectedIndex() != -1 && txtSL.getItemCount() ==  txtMaDauSach.getItemCount())
				txtMaDauSach.setSelectedIndex(txtSL.getSelectedIndex());
		}
		if(o.equals(btn_ChinhSua)) {
			if(table.getSelectedRow() != -1) {
				GUI_EditPhieuMuon gui_EditPhieuMuon = new GUI_EditPhieuMuon(listPhieuMuon.get(table.getSelectedRow()));
				gui_EditPhieuMuon.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n 1 phi???u m?????n ????? ch???nh s???a");
			}
		}
		if(o.equals(btn_TimKiem)) {
			searchPhieuMuon();
		}
		if(o.equals(btn_traPhieuMuon)) {
			loadData();
		}
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
			Panel_PhieuMuonQuaHan dkMuonSach = new Panel_PhieuMuonQuaHan();
			dkMuonSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(dkMuonSach);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_DST)) {
			super.removeAll();
			Panel_DSTraSach trasach = new Panel_DSTraSach();
			trasach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(trasach);
			super.validate();
			super.repaint(); 
		} else if (o.equals(btn_DSDK)) {
			super.removeAll();
			Panel_PhieuMuonQuaHan dkmuonsach = new Panel_PhieuMuonQuaHan();
			dkmuonsach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(dkmuonsach);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_DSS)) {
			super.removeAll();
			Panel_QLMuonTra dsmuon = new Panel_QLMuonTra();
			dsmuon.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(dsmuon);
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
	private void searchPhieuMuon() {
		// TODO Auto-generated method stub
		int n = tablemodel.getRowCount();
		for (int i = 0; i < n; i++) {
			tablemodel.removeRow(0);
		}
		int size = listPhieuMuon.size();
		for (int i = 0; i < size; i++) {
			listPhieuMuon.remove(0);
		}
		PhieuMuonController phieuMuonController = new PhieuMuonController();
		listPhieuMuon = phieuMuonController.searchPhieuMuon(textField.getText());
		if(listPhieuMuon!=null) {
			int i = 0;
			String stt;
			for(PhieuMuon s: listPhieuMuon) {
				i++;
				stt = String.valueOf(i);
				String ngayMuon = s.getNgayMuon().toString();
				String ngayTra = s.getNgayTra().toString();
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
		textField.setText("");
	}

	public void loadData() {
		int n = tablemodel.getRowCount();
		for (int i = 0; i < n; i++) {
			tablemodel.removeRow(0);
		}
		PhieuMuonController phieuMuonController = new PhieuMuonController();
		listPhieuMuon = phieuMuonController.getPhieuMuon();
		if(listPhieuMuon!=null) {
			int i = 0;
			String stt;
			for(PhieuMuon s: listPhieuMuon) {
				i++;
				stt = String.valueOf(i);
				String ngayMuon = s.getNgayMuon().toString();
				String ngayTra = s.getNgayTra().toString();
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
	public void clearData() {
		Date date = Calendar.getInstance().getTime();
		txtNgayMuon.setDate(date);
		txtNgayTra.setDate(date);
		txtMaDauSach.removeAllItems();
		txtSL.removeAllItems();
	}
	public boolean valid() {
		Date date = Calendar.getInstance().getTime();
		if(txtNgayMuon.getDate().after(date))
		{
			JOptionPane.showMessageDialog(this, "Ng??y m?????n ??t nh???t ph???i l?? ng??y hi???n t???i");
			return false;
		}
		if(txtNgayTra.getDate().before(txtNgayMuon.getDate()))
		{
			JOptionPane.showMessageDialog(this, "Ng??y tr??? ph???i sau ng??y m?????n");
			return false;
		}
		return true;
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(table)) {
			clearData();
			PhieuMuon phieuMuon = listPhieuMuon.get(table.getSelectedRow());
			txtNgayMuon.setDate(phieuMuon.getNgayMuon());
			txtNgayTra.setDate(phieuMuon.getNgayTra());
			ChiTietPhieuMuonController chiTietPhieuMuonController = new ChiTietPhieuMuonController();
			List<ChiTietPhieuMuon> listChiTietPhieuMuon = chiTietPhieuMuonController.getChiTietPhieuMuonByIdPhieuMuon(phieuMuon.getId());
			ChiTietPhieuMuon chiTietPhieuMuon = new ChiTietPhieuMuon();
			for(int i = 0; i < listChiTietPhieuMuon.size();i++) {
				chiTietPhieuMuon = listChiTietPhieuMuon.get(i);
				txtMaDauSach.addItem(chiTietPhieuMuon.getSach().getTenSach());
				txtSL.addItem(String.valueOf(chiTietPhieuMuon.getSoLuong()));
			}
			if(!cbxTrangThai.getItemAt(0).toString().equalsIgnoreCase(phieuMuon.getTrangThai()) && cbxTrangThai.getSelectedIndex() == 0) {
				cbxTrangThai.setSelectedIndex(1);
			}else {
				cbxTrangThai.setSelectedIndex(0);
			}
		}
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
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}
