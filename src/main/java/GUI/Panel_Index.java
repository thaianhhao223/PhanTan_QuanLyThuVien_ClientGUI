package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Panel_Index extends JPanel implements ActionListener{
	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTable table_pm;
	private JMenuItem mn_DG;
	private JPanel pnQGDocGia;
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
	private AbstractButton btn_DangXuat;
	private JMenuItem mn_TkHki;
	private JMenuItem mn_PhieuMuon;

	/**
	 * Create the panel.
	 */
	public Panel_Index() {
		setBounds(100, 100, 1295, 691);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1280, 33);
		menuBar.setBackground(SystemColor.inactiveCaptionBorder);
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
//		panel_1.setBackground(new Color(232, 226, 226));
		panel_1.setBounds(0, 26, 1280, 95);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl_TieuDe = new JLabel("HỆ THỐNG QUẢN LÝ THƯ VIỆN");
		lbl_TieuDe.setForeground(Color.WHITE);
		lbl_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lbl_TieuDe.setBounds(327, 11, 628, 78);
		panel_1.add(lbl_TieuDe);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(10, 128, 407, 516);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbl_hinh = new JLabel("New label");
		lbl_hinh.setIcon(new ImageIcon("IMG\\Book-100.PNG"));
		lbl_hinh.setBounds(0, 0, 409, 385);
		panel_2.add(lbl_hinh);
		
		btn_Thongtin = new JButton("Thông tin cá nhân");
		btn_Thongtin.setBackground(Color.WHITE);
		btn_Thongtin.setIcon(new ImageIcon("IMG\\person-30.png"));
		btn_Thongtin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_Thongtin.setBounds(81, 407, 231, 42);
		panel_2.add(btn_Thongtin);
		btn_Thongtin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GUI.GUI_ThongTinCaNhan().setVisible(true);
			}
		});
		
		btn_DangXuat = new JButton("Đăng xuất");
		btn_DangXuat.setBackground(Color.WHITE);
		btn_DangXuat.setIcon(new ImageIcon("IMG\\exit-30.PNG"));
		btn_DangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btn_DangXuat.setBounds(81, 460, 231, 42);
		panel_2.add(btn_DangXuat);
		btn_DangXuat.addActionListener(this);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		panel_3.setBounds(429, 128, 842, 516);
		add(panel_3);
		panel_3.setLayout(null);
		
		btn_Qldg = new JButton("ĐỘC GIẢ");

		
		btn_Qldg.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_Qldg.setBackground(Color.WHITE);
		btn_Qldg.setIcon(new ImageIcon("IMG\\life-cycle-100.PNG"));
		btn_Qldg.setBounds(68, 37, 324, 154);
		btn_Qldg.addActionListener(this);
		panel_3.add(btn_Qldg);
		
		btn_Qlpm = new JButton("MƯỢN - TRẢ");

		btn_Qlpm.setIcon(new ImageIcon("IMG\\add-book-100.PNG"));
		btn_Qlpm.setBackground(Color.WHITE);
		btn_Qlpm.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_Qlpm.setBounds(68, 296, 324, 154);
		btn_Qlpm.addActionListener(this);
		panel_3.add(btn_Qlpm);
		
		btn_Qls = new JButton("QUẢN LÝ SÁCH");

		btn_Qls.setIcon(new ImageIcon("IMG\\books-100.PNG"));
		btn_Qls.setBackground(Color.WHITE);
		btn_Qls.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_Qls.setBounds(462, 43, 324, 154);
		btn_Qls.addActionListener(this);
		panel_3.add(btn_Qls);
		
		btn_Qltk = new JButton("THỐNG KÊ");

		btn_Qltk.setBackground(Color.WHITE);
		btn_Qltk.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btn_Qltk.setIcon(new ImageIcon("IMG\\analytics-100.PNG"));
		btn_Qltk.setBounds(462, 296, 324, 154);
		btn_Qltk.addActionListener(this);
		panel_3.add(btn_Qltk);
		
		table_pm = new JTable();
		table_pm.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		//
		mn_DG.addActionListener(this);

	}

	private void setIconImage(Image image) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e){
		Object o = e.getSource();
		if (o.equals(button)) {
			super.removeAll();
			Panel_Index index = new Panel_Index();
			index.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(index);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_Qldg)) {
			super.removeAll();
			Panel_QLDocGia qlDG = new Panel_QLDocGia();
			qlDG.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlDG);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_Qlpm)) {
			super.removeAll();
			Panel_QLMuonTra qlPM = new Panel_QLMuonTra();
			qlPM.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlPM);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_Qls)) {
			super.removeAll();
			Panel_QLSach qlDGs = new Panel_QLSach();
			qlDGs.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlDGs);
			super.validate();
			super.repaint();
		} else if (o.equals(btn_Qltk)) {
			super.removeAll();
			Panel_ThongKe qlTK = new Panel_ThongKe();
			qlTK.setBounds(0, 0, super.getWidth(), super.getHeight());
			super.add(qlTK);
			super.validate();
			super.repaint();
		} else if (o.equals(mn_TKNam)) {
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
		}else if (o.equals(mn_DSDGia)) {
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
		} else if (o.equals(btn_DangXuat)) {
		    GUI_INDEX stop = (GUI_INDEX) SwingUtilities.getWindowAncestor(this);
		    GUI_DangNhap frame = new GUI_DangNhap();
		    frame.setVisible(true);
		    frame.setBounds(10, 10, 790, 465);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null);
	        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("IMG/book-1000.png"));
		    stop.dispose();
		}
	}

}
