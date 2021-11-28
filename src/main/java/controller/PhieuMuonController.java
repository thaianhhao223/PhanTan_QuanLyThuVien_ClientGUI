package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.PhieuMuonDao;
import entity.PhieuMuon;

public class PhieuMuonController {
	SecurityManager securityManager = System.getSecurityManager();
	PhieuMuonDao phieuMuonDao;
	public PhieuMuonController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
			
		}
		try {
			phieuMuonDao = (PhieuMuonDao) Naming.lookup("rmi://localhost:1099/phieuMuonDao");
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
	public String addPhieuMuon(PhieuMuon phieuMuon) {
		try {
			return phieuMuonDao.createPhieuMuon(phieuMuon);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
		
	}
	public List<PhieuMuon> getPhieuMuon(){
		List<PhieuMuon> listPhieuMuon = new ArrayList<PhieuMuon>();
		try {
			listPhieuMuon = phieuMuonDao.getAllPhieuMuon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhieuMuon;
		
	}
	
	public List<PhieuMuon> getPhieuMuonQuaHan(){
		List<PhieuMuon> listPhieuMuonQuaHan = new ArrayList<PhieuMuon>();
		try {
			listPhieuMuonQuaHan = phieuMuonDao.getPhieuMuonQuaHan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhieuMuonQuaHan;
	}
	
	public List<PhieuMuon> getPhieuMuonDaTra(){
		List<PhieuMuon> listPhieuMuonDaTra = new ArrayList<PhieuMuon>();
		try {
			listPhieuMuonDaTra = phieuMuonDao.getPhieuMuonDaTra();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPhieuMuonDaTra;
	}
	public PhieuMuon getPhieuMuonById(String id) {
		try {
			return phieuMuonDao.getPhieuMuonById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean updatePhieuMuon(PhieuMuon phieuMuon) {
		try {
			return phieuMuonDao.updatePhieuMuon(phieuMuon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
