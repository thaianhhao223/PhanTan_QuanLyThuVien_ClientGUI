package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dao.DocGiaDao;
import dao.ThuThuDao;
import entity.ThuThu;

public class ThuThuController {
	SecurityManager securityManager = System.getSecurityManager();
	ThuThuDao thuThuDao;
	private static ThuThu instance;
	public static ThuThu getInstance() {
		return instance;
	}
	public static void setInstance(ThuThu instance) {
		ThuThuController.instance = instance;
	}
	public ThuThuController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		try {
			thuThuDao = (ThuThuDao) Naming.lookup("rmi://localhost:1099/thuThuDao");
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
	public ThuThu getThuThuById(String id) {
		try {
			return thuThuDao.getThuThuById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ThuThu getThuThuByAccount(String account, String password) {
		try {
			instance = thuThuDao.getThuThuByAccount(account, password);
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateThuThu(ThuThu thuThu) {
		try {
			return thuThuDao.updateThuThu(thuThu);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
