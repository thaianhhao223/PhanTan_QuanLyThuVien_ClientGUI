package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.PhieuMuonController;
import entity.PhieuMuon;

public class Panel_DSTheHetHan extends JPanel implements ActionListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTextField textField;
	private JTable table_pm;
	private JTable table_HetHan;
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
	private JButton btnThoat;
	private JTextField btn_r;
	private JLabel lblNewLabel;
	private JMenuItem mn_TkHki;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane scroll;

	/**
	 * Create the panel.
	 */
	public Panel_DSTheHetHan() {
		setName("DANH SÁCH THẺ HẾT HẠN");
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 128));
		panel_1.setBounds(0, 22, 1281, 100);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel paneldg2 = new JPanel();
		paneldg2.setBackground(Color.WHITE);
		paneldg2.setBounds(0, 22, 1281, 198);
		add(paneldg2);
		paneldg2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(76, 121, 318, 50);
		paneldg2.add(textField);
		textField.setColumns(10);
		
		JButton btnCapnhat = new JButton("Cập nhật");
		btnCapnhat.setBackground(Color.WHITE);
		btnCapnhat.setIcon(new ImageIcon("IMG\\update-30.png"));
		btnCapnhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCapnhat.setBounds(900, 121, 136, 50);
		paneldg2.add(btnCapnhat);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(Color.WHITE);
		btnThoat.addActionListener(this);
		btnThoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThoat.setBounds(1058, 121, 136, 50);
		paneldg2.add(btnThoat);
		
		JButton btnTim = new JButton("");
		btnTim.setBackground(Color.WHITE);
		btnTim.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		btnTim.setBounds(10, 122, 56, 50);
		paneldg2.add(btnTim);
		
		
		btn_r = new JTextField("DANH SÁCH THẺ HẾT HẠN");
		btn_r.setHorizontalAlignment(SwingConstants.CENTER);
		btn_r.setFont(new Font("Times New Roman", Font.BOLD, 40));
		btn_r.setForeground(Color.WHITE);
		btn_r.setBackground(new Color(0, 0, 128));
		btn_r.setBounds(0, 5, 1300, 100);
		paneldg2.add(btn_r);
		
		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("IMG\\delete-30.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(740, 121, 136, 50);
		paneldg2.add(btnNewButton);
		
		JScrollPane scroll;
		
		
		table = new JTable();
		
		String[] headers = "STT; ID; Ngày mượn; Ngày trả; Trạng thái; ID đọc giả; ID thủ thư".split(";");
		tablemodel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		scroll.setBounds(10, 238, 1261, 405);
		add(scroll);
		loadData();
		
	}
	
	public void loadData() {
		PhieuMuonController phieuMuonController = new PhieuMuonController();
		List<PhieuMuon> phieuMuon = phieuMuonController.getPhieuMuonQuaHan();
		if(phieuMuon!=null) {
			int i = 0;
			String stt;
			for(PhieuMuon s: phieuMuon) {
				i++;
				stt = String.valueOf(i);
				String ngayMuon = s.getNgayMuon().toString();
				String ngayTra = s.getNgayMuon().toString();
				String docgia = String.valueOf(s.getDocGia());
				String thuthu = String.valueOf(s.getThuThu());
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
			Panel_PhieuMuonQuaHan dkMuonSach = new Panel_PhieuMuonQuaHan();
			dkMuonSach.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(dkMuonSach);
			super.validate();
			super.repaint();   
		} else if (o.equals(btnThoat)) {
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
