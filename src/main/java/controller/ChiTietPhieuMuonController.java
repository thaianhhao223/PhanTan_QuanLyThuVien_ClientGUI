package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.ChiTietPhieuMuonDao;
import dao.LoaiSachDao;
import entity.ChiTietPhieuMuon;
import entity.LoaiSach;
import entity.Sach;

public class ChiTietPhieuMuonController {
	SecurityManager securityManager = System.getSecurityManager();
	ChiTietPhieuMuonDao chiTietPhieuMuonDao;
	public ChiTietPhieuMuonController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			chiTietPhieuMuonDao = (ChiTietPhieuMuonDao) Naming.lookup("rmi://192.168.1.111:1099/chiTietPhieuMuonDao");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<ChiTietPhieuMuon> getChiTietPhieuMuonByIdPhieuMuon(String phieuMuonId){
		List<ChiTietPhieuMuon> list = new ArrayList<ChiTietPhieuMuon>();
		try {
			list = chiTietPhieuMuonDao.getChiTietPhieuMuonByIdPhieuMuon(phieuMuonId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String addChiTietPhieuMuonById(ChiTietPhieuMuon chiTietPhieuMuon){
		try {
			return chiTietPhieuMuonDao.addChiTietPhieuMuonById(chiTietPhieuMuon.getPhieuMuon().getId(), 
					chiTietPhieuMuon.getSach().getId(), chiTietPhieuMuon.getSoLuong());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String addChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) {
		try {
			return chiTietPhieuMuonDao.addChiTietPhieuMuon(chiTietPhieuMuon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public boolean kiemTraSoLuongSach(Sach sach, int soLuong) {
		try {
			return chiTietPhieuMuonDao.isSachEnough(sach, soLuong);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteAllChiTietPhieuMuonByPhieuMuonId(String phieuMuonId) {
		try {
			return chiTietPhieuMuonDao.deleteChiTietPhieuMuonByPhieuMuonId(phieuMuonId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public String updateChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) {
		try {
			return chiTietPhieuMuonDao.updateChiTietPhieuMuon(chiTietPhieuMuon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteChiTietPhieuMuon(ChiTietPhieuMuon chiTietPhieuMuon) {
		try {
			chiTietPhieuMuonDao.deleteChiTietPhieuMuon(chiTietPhieuMuon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
