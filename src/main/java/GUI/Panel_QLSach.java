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
import java.util.Iterator;
import java.util.List;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import controller.LoaiSachController;
import controller.SachController;
import entity.LoaiSach;
import entity.Sach;

public class Panel_QLSach extends JPanel implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JMenu mn_thanhtoan;
	private JTextField textField_TiemKiem;
	private JTable table;
	private DefaultTableModel tablemodel;
	private JScrollPane scroll;
	private JButton button;
	private JMenuItem mn_DSDGia;
	private JMenuItem mn_DSTheHetHan;
	private JMenuItem mn_KhoSach;
	private JMenu mn_Muon;
	private JMenuItem mn_MuonSach;
	private JMenuItem mn_Tra;
	private JMenu mn_Dki;
	private JMenuItem mn_Dkisach;
	private JMenuItem mn_TKNam;
	private JButton btn_Thoat;
	private JMenuItem mn_TkHki;
	private JTextField txtTenSach;
	private JTextField txtTenTacGia;
	private JTextField txtNhaXB;
	private JDateChooser txtNgayXB;
	private JTextField txtSoLuong;
	private JButton btn_ChinhSua;
	private JButton btn_capnhat;
	private JTextField txtGiaTien;
	
	private List<Sach> listsach = new ArrayList<Sach>();
	private List<LoaiSach> listLoaiSach = new ArrayList<LoaiSach>();
	private JComboBox cbTheLoai;

	/**
	 * Create the panel.
	 */
	public Panel_QLSach() {
		setName("QUẢN LÝ SÁCH ");
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
		
		mn_MuonSach = new JMenuItem("Danh sách phiếu mượn");
		mn_MuonSach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.ALT_MASK));
		mn_MuonSach.setIcon(new ImageIcon("IMG/add-bookmark.png"));
		Mn_QLMTS.add(mn_MuonSach);
		mn_MuonSach.addActionListener(this);
		
		mn_Tra = new JMenuItem("Phiếu mượn đã trả");
		mn_Tra.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.ALT_MASK));
		mn_Tra.setIcon(new ImageIcon("IMG/bookmark-2.png"));
		Mn_QLMTS.add(mn_Tra);
		mn_Tra.addActionListener(this);
		
		mn_Dkisach = new JMenuItem("Phiếu mượn quá hạn");
		mn_Dkisach.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_8, ActionEvent.ALT_MASK));
		mn_Dkisach.setIcon(new ImageIcon("IMG/card-2.png"));
		Mn_QLMTS.add(mn_Dkisach);
		mn_Dkisach.addActionListener(this);
		
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
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(10, 22, 1261, 116); //10, 128, 1261, 116
		add(panel_1);
		panel_1.setLayout(null);
		
		btn_Thoat = new JButton("Thoát");
		btn_Thoat.addActionListener(this);
		btn_Thoat.setBackground(Color.WHITE);
		btn_Thoat.setBounds(1115, 40, 136, 65);
		btn_Thoat.setIcon(new ImageIcon("IMG\\cancel-30.png"));
		btn_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel_1.add(btn_Thoat);
		
		JButton btn_TimKiem = new JButton("");
		btn_TimKiem.setBackground(Color.WHITE);
		btn_TimKiem.setBounds(195, 40, 72, 65);
		btn_TimKiem.setIcon(new ImageIcon("IMG\\search-30.PNG"));
		panel_1.add(btn_TimKiem);
		
		JButton btn_TieuDe = new JButton("KHO SÁCH");
		btn_TieuDe.setBounds(10, 15, 175, 94);
		btn_TieuDe.setIcon(null);
		btn_TieuDe.setFont(new Font("Times New Roman", Font.BOLD, 26));
		btn_TieuDe.setForeground(Color.BLACK);
		btn_TieuDe.setBackground(new Color(144, 238, 144));
		panel_1.add(btn_TieuDe);
		
		btn_capnhat = new JButton("Cập nhật");
		btn_capnhat.setBackground(Color.WHITE);
		btn_capnhat.setBounds(968, 40, 136, 65);
		btn_capnhat.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_capnhat.setIcon(new ImageIcon("IMG\\update-30.png"));
		panel_1.add(btn_capnhat);
		btn_capnhat.addActionListener(this);
		
		btn_ChinhSua = new JButton("Chỉnh sửa");
		btn_ChinhSua.setBackground(Color.WHITE);
		btn_ChinhSua.setIcon(new ImageIcon("IMG\\edit-30.png"));
		btn_ChinhSua.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btn_ChinhSua.setBounds(822, 40, 136, 65);
		panel_1.add(btn_ChinhSua);
		btn_ChinhSua.addActionListener(this);
		
//		JButton btn_Xoa = new JButton("Xóa");
//		btn_Xoa.setBackground(Color.WHITE);
//		btn_Xoa.setIcon(new ImageIcon("IMG\\delete-30.png"));
//		btn_Xoa.setBounds(676, 40, 136, 66);
//		panel_1.add(btn_Xoa);
		
		textField_TiemKiem = new JTextField();
		textField_TiemKiem.setBounds(277, 41, 319, 65);
		panel_1.add(textField_TiemKiem);
		textField_TiemKiem.setColumns(10);
		
		JScrollPane scroll;
		
		
		table = new JTable();		
		String[] headers = "STT; Tên sách; Mã sách; Loại sách; Nhà xuất bản; Tên tác giả; Ngày xuất bản; Giá tiền; Số lượng".split(";");
		tablemodel  = new DefaultTableModel(headers,0);
		scroll = new JScrollPane(table = new JTable(tablemodel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(20);
		
		scroll.setBounds(10, 300, 1261, 388);
		add(scroll);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 140, 1261, 160);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTenSach = new JLabel("Tên Sách:");
		lblTenSach.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenSach.setBounds(20, 20, 175, 15);
		panel.add(lblTenSach);
		
		txtTenSach = new JTextField();
		txtTenSach.setForeground(Color.BLACK);
		txtTenSach.setFont(new Font("Arial", Font.PLAIN, 18));
		txtTenSach.setColumns(10);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(100, 15, 175, 30);
		panel.add(txtTenSach);
		
		JLabel lblTenTacGia = new JLabel("Tên TG:");
		lblTenTacGia.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenTacGia.setBounds(20, 70, 175, 15);
		panel.add(lblTenTacGia);
		
		txtTenTacGia = new JTextField();
		txtTenTacGia.setForeground(Color.BLACK);
		txtTenTacGia.setFont(new Font("Arial", Font.PLAIN, 18));
		txtTenTacGia.setColumns(10);
		txtTenTacGia.setBackground(Color.WHITE);
		txtTenTacGia.setBounds(100, 65, 175, 30);
		panel.add(txtTenTacGia);
		
		JLabel lblNhaXB = new JLabel("Nhà Xuất Bản:");
		lblNhaXB.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNhaXB.setBounds(400, 20, 175, 15);
		panel.add(lblNhaXB);
		
		txtNhaXB = new JTextField();
		txtNhaXB.setForeground(Color.BLACK);
		txtNhaXB.setFont(new Font("Arial", Font.PLAIN, 18));
		txtNhaXB.setColumns(10);
		txtNhaXB.setBackground(Color.WHITE);
		txtNhaXB.setBounds(550, 15, 175, 30);
		panel.add(txtNhaXB);
		
		JLabel lblNgayXB = new JLabel("Ngày Xuất Bản:");
		lblNgayXB.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayXB.setBounds(400, 70, 175, 15);
		panel.add(lblNgayXB);
		
		txtNgayXB = new JDateChooser();
		txtNgayXB.setBackground(Color.WHITE);
		txtNgayXB.setBounds(550, 65, 175, 30);
		panel.add(txtNgayXB);
		
		JLabel lblGiaTien = new JLabel("Giá Tiền:");
		lblGiaTien.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGiaTien.setBounds(800, 20, 175, 15);
		panel.add(lblGiaTien);
		
		txtGiaTien = new JTextField();
		txtGiaTien.setForeground(Color.BLACK);
		txtGiaTien.setFont(new Font("Arial", Font.PLAIN, 18));
		txtGiaTien.setColumns(10);
		txtGiaTien.setBackground(Color.WHITE);
		txtGiaTien.setBounds(950, 15, 175, 30);
		panel.add(txtGiaTien);
		
		JLabel lblSoLuong = new JLabel("Số Lượng:");
		lblSoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSoLuong.setBounds(800, 70, 175, 15);
		panel.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setForeground(Color.BLACK);
		txtSoLuong.setFont(new Font("Arial", Font.PLAIN, 18));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setBounds(950, 65, 175, 30);
		panel.add(txtSoLuong);
		
		JLabel lblTheLoai = new JLabel("Thể Loại:");
		lblTheLoai.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTheLoai.setBounds(10, 120, 175, 15);
		panel.add(lblTheLoai);
		
		cbTheLoai = new JComboBox();
		cbTheLoai.setBounds(100, 115, 175, 30);
		panel.add(cbTheLoai);
		
		txtTenSach = new JTextField();
		txtTenSach.setForeground(Color.BLACK);
		txtTenSach.setFont(new Font("Arial", Font.PLAIN, 18));
		txtTenSach.setColumns(10);
		txtTenSach.setBackground(Color.WHITE);
		txtTenSach.setBounds(100, 15, 175, 30);
		panel.add(txtTenSach);
		
		table.addMouseListener(this);
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
	public void loadData() {
		SachController sachController = new SachController();
		listsach = sachController.getAllSach();
		if(listsach!=null) {
			int i = 0;
			String stt;
			for(Sach s: listsach) {
				i++;
				stt = String.valueOf(i);
				String loai;
				if(s.getLoaiSach() != null) {
					loai = s.getLoaiSach().getTenLoai();
				}else {
					loai = "Chưa phân loại";
				}
				String namxuatban = s.getNamXuatBan().toString();
				String dongia = String.valueOf(s.getDonGia());
				String soluong = String.valueOf(s.getSoLuongBanIn());
				String [] rowData= {stt,
						s.getTenSach(),
						s.getId(),
						loai, 
						s.getNhaXuatBan(), 
						s.getTacGia(),
						namxuatban,
						dongia,
						soluong};
				tablemodel.addRow(rowData);
				System.out.println(s.toString());
			}
			table.setModel(tablemodel);
			LoaiSachController loaiSachController = new LoaiSachController();
			listLoaiSach = loaiSachController.getAllLoaiSach();
			LoaiSach loaiSach;
			for(int j = 0; j < listLoaiSach.size(); j++) {
				loaiSach = listLoaiSach.get(j);
				cbTheLoai.addItem(loaiSach.getTenLoai());
			}
			cbTheLoai.addItem("Chưa phân loại");
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
		} else if (o.equals(mn_MuonSach)) {
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
		else if (o.equals(btn_capnhat)) {
			tablemodel.setRowCount(0);
			try {
				loadData();
				JOptionPane.showMessageDialog(this, "Cập nhật thành công");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if (o.equals(btn_ChinhSua)) {
			if(table.getSelectedRow() != -1) {
				Sach sach = listsach.get(table.getSelectedRow());
				SachController sachController = new SachController();
				sach.setTenSach(txtTenSach.getText());
				sach.setNhaXuatBan(txtNhaXB.getText());
				sach.setTacGia(txtTenTacGia.getText());
				sach.setTenSach(txtTenSach.getText());
				int sl = Integer.parseInt(txtSoLuong.getText());
				int gt = Integer.parseInt(txtGiaTien.getText());
				sach.setSoLuongBanIn(sl);
				sach.setDonGia(gt);
				if(!cbTheLoai.getSelectedItem().toString().equalsIgnoreCase("Chưa phân loại")) {
					sach.setLoaiSach(listLoaiSach.get(cbTheLoai.getSelectedIndex()));
				}else {
					sach.setLoaiSach(null);
				}
				if(sachController.update(sach)) {
					clearTextFill();
					removeRow();
					loadData();
					JOptionPane.showMessageDialog(this, "Chỉnh sửa sách thành công");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 sách cần chỉnh sửa");
			}
			
			
			
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
		txtTenSach.setText("");
		txtTenTacGia.setText("");
		txtSoLuong.setText("");
		txtNhaXB.setText("");
		txtGiaTien.setText("");
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(table)) {
			int row = table.getSelectedRow();
			txtTenSach.setText(table.getValueAt(row, 1).toString());
//			cbTheLoai.setSelectedIndex(table.getValueAt(row, 3).toString());
			txtNhaXB.setText(table.getValueAt(row, 4).toString());
			txtTenTacGia.setText(table.getValueAt(row, 5).toString());
			txtGiaTien.setText(table.getValueAt(row, 7).toString());
			txtSoLuong.setText(table.getValueAt(row, 8).toString());
			txtNgayXB.setDate(listsach.get(row).getNamXuatBan());
			for (int i = 0; i < cbTheLoai.getItemCount(); i++) {
				if(listsach.get(row).getLoaiSach() == null) {
					cbTheLoai.setSelectedIndex(cbTheLoai.getItemCount()-1);
					break;
				}
				if(listsach.get(row).getLoaiSach().getTenLoai()
						.equalsIgnoreCase(cbTheLoai.getItemAt(i).toString()))
				{
					cbTheLoai.setSelectedIndex(i);
					break;
				}
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

}
