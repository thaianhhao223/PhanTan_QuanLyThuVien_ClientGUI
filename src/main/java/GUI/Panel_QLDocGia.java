package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

import controller.DocGiaController;
import controller.SachController;
import dao.DocGiaDao;
import entity.DocGia;
import entity.Sach;

public class Panel_QLDocGia extends JPanel implements ActionListener, MouseListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTextField textField_Tim;
	private JTable table_DGia;
	private JPanel pTotal;
	private JButton btn_Lthe;
	private JButton btn_DSHetHan;
	private JButton btn_Dg;
	private JButton button;
	private JMenuItem mn_DSDGia;
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
	private JButton btn_Xoa;
	private JButton btn_capnhat;
	private JTextField txtHoTen;
	private JTextField txtChucVu;
	private JTextField txtChuyenNganh;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JButton btn_ChinhSua;
	private JButton btn_TimKiem;
	private List<DocGia> listdocgia;
	/**
	 * Create the panel.
	 */
	public Panel_QLDocGia() {
		setName("QU???N L?? ?????C GI???");
		setSize(1295, 691);
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
			public void mousePressed(MouseEvent e) {
				new GUI.GUI_ThemSach().setVisible(true);
			}
		});
		mn_Sach.add(mn_BSSach);
		
		mn_KhoSach = new JMenuItem("Kho s??ch");
		mn_KhoSach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		mn_KhoSach.setIcon(new ImageIcon("IMG/books.png"));
		mn_KhoSach.addActionListener(this);
		mn_Sach.add(mn_KhoSach);
		
		JMenu Mn_QLMTS = new JMenu("Qu???n l?? m?????n - tr??? s??ch");
		Mn_QLMTS.setMnemonic(KeyEvent.VK_M);
		Mn_QLMTS.setIcon(new ImageIcon("IMG/bookmark.png"));
		menuBar.add(Mn_QLMTS);
		
		JMenuItem mn_PhieuMuon = new JMenuItem("T???o phi???u m?????n");
		mn_PhieuMuon.setIcon(new ImageIcon("IMG/add.png"));
		mn_PhieuMuon.addMouseListener(new MouseAdapter() {
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
		
		
		
		JPanel panel_tks = new JPanel();
		panel_tks.setBackground(SystemColor.inactiveCaptionBorder);
		panel_tks.setBounds(10, 22, 1261, 116);  //10, 128, 1261, 116
		add(panel_tks);
		panel_tks.setLayout(null);
		
		btn_Thoat = new JButton("Tho??t");
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.setBounds(1115, 40, 136, 65);
		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_Thoat.addActionListener(this);
		panel_tks.add(btn_Thoat);
		
		
		btn_TimKiem = new JButton("");
		btn_TimKiem.setBackground(Color.WHITE);
		btn_TimKiem.setBounds(195, 40, 72, 65);
		btn_TimKiem.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		panel_tks.add(btn_TimKiem);
		
		JButton btn_TieuDe = new JButton("?????C GI???");
		btn_TieuDe.setBounds(10, 15, 175, 94);
		btn_TieuDe.setIcon(null);
		btn_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_TieuDe.setForeground(Color.WHITE);
		btn_TieuDe.setBackground(new Color(0, 0, 128));
		panel_tks.add(btn_TieuDe);
		
		btn_capnhat = new JButton("C???p nh???t");
		btn_capnhat.setBackground(Color.WHITE);
		btn_capnhat.setBounds(968, 40, 136, 65);
		btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capnhat.setIcon(new ImageIcon("IMG\\update-30.png"));
		panel_tks.add(btn_capnhat);
		btn_capnhat.addActionListener(this);
		
		btn_ChinhSua = new JButton("Ch???nh s???a");
		btn_ChinhSua.setBackground(Color.WHITE);
		btn_ChinhSua.setIcon(new ImageIcon("IMG\\edit-30.png"));
		btn_ChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ChinhSua.setBounds(822, 40, 136, 65);
		panel_tks.add(btn_ChinhSua);
		btn_ChinhSua.addActionListener(this);
		
//		btn_Xoa = new JButton("X??a tr???ng");
//		btn_Xoa.setBackground(Color.WHITE);
//		btn_Xoa.setIcon(new ImageIcon("IMG\\delete-30.png"));
//		btn_Xoa.setBounds(676, 40, 136, 66);
//		panel_tks.add(btn_Xoa);
//		btn_Xoa.addActionListener(this);
		
		textField_Tim = new JTextField();
		textField_Tim.setFont(new Font("Times New Roman", Font.BOLD, 24));
		textField_Tim.setBounds(277, 41, 319, 65);
		panel_tks.add(textField_Tim);
		textField_Tim.setColumns(10);
		
		JScrollPane scroll;
		
		
		table = new JTable();
		
		String[] headers = "STT; H??? t??n; Ch???c v???; Chuy??n ng??nh; Email; S??? ??i???n tho???i".split(";");
		tablemodel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		scroll.setBounds(10, 255, 1261, 388);
		add(scroll);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 140, 1261, 116);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblHoten = new JLabel("H??? T??n:");
		lblHoten.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblHoten.setBounds(20, 20, 175, 15);
		panel.add(lblHoten);
		
		txtHoTen = new JTextField();
		txtHoTen.setForeground(Color.BLACK);
		txtHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtHoTen.setColumns(10);
		txtHoTen.setBackground(Color.WHITE);
		txtHoTen.setBounds(100, 15, 175, 30);
		panel.add(txtHoTen);
		
		JLabel lblChucVu = new JLabel("Ch???c V???:");
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChucVu.setBounds(20, 70, 175, 15);
		panel.add(lblChucVu);
		
		txtChucVu = new JTextField();
		txtChucVu.setForeground(Color.BLACK);
		txtChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChucVu.setColumns(10);
		txtChucVu.setBackground(Color.WHITE);
		txtChucVu.setBounds(100, 65, 175, 30);
		panel.add(txtChucVu);
		
		JLabel lblChuyenNganh = new JLabel("Chuy??n ng??nh:");
		lblChuyenNganh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblChuyenNganh.setBounds(400, 20, 175, 15);
		panel.add(lblChuyenNganh);
		
		txtChuyenNganh = new JTextField();
		txtChuyenNganh.setForeground(Color.BLACK);
		txtChuyenNganh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtChuyenNganh.setColumns(10);
		txtChuyenNganh.setBackground(Color.WHITE);
		txtChuyenNganh.setBounds(550, 15, 175, 30);
		panel.add(txtChuyenNganh);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblEmail.setBounds(400, 70, 175, 15);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(550, 65, 175, 30);
		panel.add(txtEmail);
		
		JLabel lblSDT = new JLabel("S??? ??i???n Tho???i:");
		lblSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSDT.setBounds(800, 20, 175, 15);
		panel.add(lblSDT);
		
		txtSDT = new JTextField();
		txtSDT.setForeground(Color.BLACK);
		txtSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBackground(Color.WHITE);
		txtSDT.setBounds(950, 15, 175, 30);
		panel.add(txtSDT);
		
	
		table.addMouseListener(this);
		btn_TimKiem.addActionListener(this);
		loadData();
		
		
	}
	
	public void loadData() {
		DocGiaController docgiaController = new DocGiaController();
		listdocgia = docgiaController.getAllDocGia();
		if(listdocgia!=null) {
			int i = 0;
			String stt;
			for(DocGia s: listdocgia) {
				i++;
				stt = String.valueOf(i);
				
				String [] rowData= {stt,
									s.getHoTen(), 
									s.getChucVu(), 
									s.getChuyenNganh(),
									s.getEmail(), 
									s.getSoDienThoai()};
				tablemodel.addRow(rowData);
				System.out.println(s.toString());
			}
			table.setModel(tablemodel);
		}
	}
	
	DocGiaController docgiaController = new DocGiaController();
	List<DocGia> docgia = docgiaController.getAllDocGia();

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btn_Dg)) {
			super.removeAll();
			GUI_LapThe lapthe = new GUI_LapThe();
		} else if (o.equals(btn_DSHetHan)) {
			super.removeAll();
			Panel_DSTheHetHan thehethan = new Panel_DSTheHetHan();
			thehethan.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(thehethan);
			super.validate();
			super.repaint();
			
		} else if (o.equals(button)) {
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
//		else if (o.equals(btn_Xoa)) {
//			txtHoTen.setText("");
//			txtChucVu.setText("");
//			txtChuyenNganh.setText("");
//			txtEmail.setText("");
//			txtSDT.setText("");
//			txtHoTen.requestFocus();
//		}
		else if (o.equals(btn_capnhat)) {
			tablemodel.setRowCount(0);
			try {
				loadData();
				JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if (o.equals(btn_ChinhSua)) {
			
			DocGia docGia = listdocgia.get(table.getSelectedRow());
			DocGiaController docGiaController = new DocGiaController();
			docGia.setHoTen(txtHoTen.getText());
			docGia.setChucVu(txtChucVu.getText());
			docGia.setChuyenNganh(txtChuyenNganh.getText());
			docGia.setEmail(txtEmail.getText());
			docGia.setSoDienThoai(txtSDT.getText());
			
			if(docGiaController.update(docGia)) {
				clearTextFill();
				removeRow();
				loadData();
				JOptionPane.showMessageDialog(this, "S???a th??nh c??ng");
			}

		}
		if(o.equals(btn_TimKiem)) {
			searchDocGia();
		}
	}
	public void searchDocGia() {
		int size = docgia.size();
		for(int i = 0; i < size; i++) {
			docgia.remove(0);
		}
		removeRow();
		DocGiaController docgiaController = new DocGiaController();
		listdocgia = docgiaController.searchDocGia(textField_Tim.getText());
		if(listdocgia!=null) {
			int i = 0;
			String stt;
			for(DocGia s: listdocgia) {
				i++;
				stt = String.valueOf(i);
				
				String [] rowData= {stt,
									s.getHoTen(), 
									s.getChucVu(), 
									s.getChuyenNganh(),
									s.getEmail(), 
									s.getSoDienThoai()};
				tablemodel.addRow(rowData);
				System.out.println(s.toString());
			}
			table.setModel(tablemodel);
		}
	}
	public void removeRow() {
		int size = table.getRowCount();
		for (int i = 0; i < size; i++) {
			tablemodel.removeRow(0);
		}
		table.setModel(tablemodel);
	}
	
	public void clearTextFill() {
		txtHoTen.setText("");
		txtChucVu.setText("");
		txtChuyenNganh.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txtHoTen.requestFocus();
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(table)) {
			int row = table.getSelectedRow();
			txtHoTen.setText(table.getValueAt(row, 1).toString());
			txtChucVu.setText(table.getValueAt(row, 2).toString());
			txtChuyenNganh.setText(table.getValueAt(row, 3).toString());
			txtEmail.setText(table.getValueAt(row, 4).toString());
			txtSDT.setText(table.getValueAt(row, 5).toString());
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

}
