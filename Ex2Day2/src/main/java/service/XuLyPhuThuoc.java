/**
 * @author trung
 * @date Nov 5, 2018
 */
package service;

import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import utils.DBConnect;

/**
 * @author trung
 */
public class XuLyPhuThuoc {
	/*
	 * <========================== XuLyTinhNang ==========================>
	 * 
	 */
	/*
	 * Xu ly tinh nang luc them oto.
	 * return ve matinhnang trong bang tinhnang
	 */

	public int XuLyTinhNang(int Nam) {
		if (Nam >= 2005) {
			return 1;
		}
		if (Nam <= 2004 && Nam >= 1996) {
			return 2;
		}
		if (Nam < 1996) {
			return 3;
		}
		return 0;
	}
	/*
	 * <========================== XuLyTinhNamSuDung ==========================>
	 * 
	 */
	/*
	 * Tinh so nam da su dung cua nhung xe
	 * san xuat truoc nam 1996
	 */
	public String XuLyTinhNamSuDung(String tinhnang, int Nam) {
		int k=XuLyTinhNang(Nam);
		int soNamDaDi;
		if(k==1) {
			return "Have positioning device";
		}
		if(k==2) {
			return "Have power steering";
		}
		if(k==3) {
			soNamDaDi=2018-Nam;
			return soNamDaDi+" nam da su dung";
		}

		return null;
	}
	/*
	 * <========================== XuLyTen ==========================>
	 * 
	 */
	/*
	 * Tao ten xe
	 */
	public String XuLyTen() {
		String car = "car #";
		System.out.println(XuLyDemXe());
		return car;
	}
	/*
	 * <========================== XuLyBaoHanh ==========================>
	 * 
	 */
	public String XuLyBaoHanh(int bh) {
		if (bh == 0) {
			return "bought";
		}
		if (bh == 1) {
			return "haven't bought yet";
		}
		return null;
	}
	/*
	 * <========================== XuLyDemXe ==========================>
	 * 
	 */
	/*
	 * Dem tat ca cac xe co trong DB
	 * de tao ten xe
	 */
	public int XuLyDemXe() {
		String sql = "SELECT COUNT(BKS) FROM Car";
		int soLuongXe = 0;
		try {
			java.sql.Connection cnn = DBConnect.getConnecttion();
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				soLuongXe = rs.getInt(1);
				return soLuongXe;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
