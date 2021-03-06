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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Panel_ThongKe extends JPanel implements ActionListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
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

	/**
	 * Create the panel.
	 */
	public Panel_ThongKe() {
		setName("QUẢN LÝ THỐNG KÊ SÁCH ");
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
		panel_tks.setBounds(0, 24, 1281, 196);
		add(panel_tks);
		panel_tks.setLayout(null);
		
		JButton btn_Tknam = new JButton("Thống kê theo năm học");
		btn_Tknam.setBackground(Color.WHITE);
		btn_Tknam.setIcon(new ImageIcon("IMG\\chart-50.PNG"));
		btn_Tknam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btn_Tknam.setBounds(677, 20, 360, 65);
		panel_tks.add(btn_Tknam);
		
		JButton btn_tkhk = new JButton("Thống kê theo học kì");
		btn_tkhk.setBackground(Color.WHITE);
		btn_tkhk.setIcon(new ImageIcon("IMG\\icons8-chart-50.PNG"));
		btn_tkhk.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btn_tkhk.setBounds(677, 102, 360, 65);
		panel_tks.add(btn_tkhk);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(this);
		btn_Thoat.setBackground(Color.WHITE);

		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_Thoat.setBounds(1123, 116, 136, 50);
		panel_tks.add(btn_Thoat);
		
		JButton btn_TimKiem = new JButton("");
		btn_TimKiem.setBackground(Color.WHITE);
		btn_TimKiem.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		btn_TimKiem.setBounds(10, 117, 56, 50);
		panel_tks.add(btn_TimKiem);
		
		JButton btn_TieuDe = new JButton("THỐNG KÊ SÁCH ĐƯỢC YÊU THÍCH");
		btn_TieuDe.setIcon(new ImageIcon("IMG\\bar-chart-50.PNG"));
		btn_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_TieuDe.setForeground(Color.BLACK);
		btn_TieuDe.setBackground(new Color(230, 230, 250));
		btn_TieuDe.setBounds(10, 20, 516, 74);
		panel_tks.add(btn_TieuDe);
		
		JButton btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.setBackground(Color.WHITE);
		btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capnhat.setIcon(new ImageIcon("IMG\\update-30.png"));
		btn_capnhat.setBounds(1123, 26, 136, 50);
		panel_tks.add(btn_capnhat);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 116, 165, 51);
		panel_tks.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(361, 116, 165, 51);
		panel_tks.add(comboBox_1);
		
		JScrollPane scrollPane_Tk = new JScrollPane();
		scrollPane_Tk.setBounds(10, 231, 1261, 412);
		add(scrollPane_Tk);
		
		
		
		
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
		
	}

}
