package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.DocGiaDao;
import entity.DocGia;
import entity.Sach;

public class DocGiaController {
	
	SecurityManager securityManager = System.getSecurityManager();
	DocGiaDao docGiaDao;
	public DocGiaController() {
		if(securityManager == null) {
			System.setProperty("java.security.policy", "policy/policy.policy");
			System.setSecurityManager(new SecurityManager());
			
		}
		
		try {
			docGiaDao = (DocGiaDao) Naming.lookup("rmi://localhost:1099/docGiaDao");
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
	
	public boolean addDocGia(DocGia docGia) {
		try {
			
			if(docGiaDao.addDocGia(docGia))
				System.out.println("Thành công");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
		
	}
	
	public boolean xoaDGByID(String id) {
		try {
			if(docGiaDao.deleteDocGiaById(id))
				System.out.println("Thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<DocGia> getAllDocGia(){
		List<DocGia> listDocGia = new ArrayList<DocGia>();
		try {
			listDocGia = docGiaDao.getAllDocGia();
			System.out.println(listDocGia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDocGia;
	}
	
	public boolean update(DocGia docgia) {
		try {
			return docGiaDao.updateDocGia(docgia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public DocGia getDocGiaById(String id) {
		try {
			return docGiaDao.getDocGiaById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<DocGia> searchDocGia(String keyword){
		List<DocGia> listDocGia = new ArrayList<DocGia>();
		try {
			listDocGia = docGiaDao.findDocGiaByKeyWord(keyword);
			System.out.println(listDocGia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDocGia;
	}
}
