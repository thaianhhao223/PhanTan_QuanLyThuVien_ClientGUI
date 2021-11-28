package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.SachDao;
import entity.Sach;



public class SachController {
	SecurityManager securityManager = System.getSecurityManager();
	SachDao sachDao;
	public SachController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
			
		}
		try {
			sachDao = (SachDao) Naming.lookup("rmi://192.168.1.111:1099/sachDao");
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
	public boolean xoaSach(String id) {
		try {
			return sachDao.deleteSachById(id);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	public List<Sach> getAllSach(){
		List<Sach> listSach = new ArrayList<Sach>();
		try {
			listSach = sachDao.getAllSach();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return listSach;
	}
	
	public boolean addSach(Sach sach) {
		try {
			if(sachDao.addSach(sach))
				System.out.println("Thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public Sach getSachById(String id) {
		try {
			return sachDao.getSachById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
