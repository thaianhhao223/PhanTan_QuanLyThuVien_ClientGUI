package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.LoaiSachDao;
import dao.SachDao;
import entity.LoaiSach;
import entity.Sach;

public class LoaiSachController {
	SecurityManager securityManager = System.getSecurityManager();
	LoaiSachDao loaiSachDao;
	public LoaiSachController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			loaiSachDao = (LoaiSachDao) Naming.lookup("rmi://192.168.1.111:1099/loaiSachDao");
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
	public List<LoaiSach> getAllLoaiSach(){
		List<LoaiSach> list = new ArrayList<LoaiSach>();
		try {
			list = loaiSachDao.getAllLoaiSach();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
