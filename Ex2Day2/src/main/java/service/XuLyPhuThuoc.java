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
public String XuLyHSX(int HSX) {
	if(HSX==1) {
		return "TOYOTA";
	}
	if(HSX==2) {
		return "BMW";
	}
	if(HSX==3) {
		return "HUYNDAI";
	}
	return null;
}
public String XuLyNam(int Nam) {
	if(Nam>=2005) {
		return "Have positioning device";
	}
	if(Nam<=2004&&Nam>=1996) {
		return "Have power steering";
	}
	if(Nam<1996) {
		return "Old Car";
	}
	return null;
}
public int XuLyTinhNang(int Nam) {
	if(Nam>=2005) {
		return 1;
	}
	if(Nam<=2004&&Nam>=1996) {
		return 2;
	}
	if(Nam<1996) {
		return 2018-Nam;
	}
	return 0;
}
public String XuLyTen() {
	String car="car #";
//	String SoXe=Integer.toString(XuLyDemXe());
	//car=car.concat(SoXe);
	System.out.println(XuLyDemXe());
	return car;
}
public String XuLyBaoHiem(int bh) {
	if(bh==0) {
		return "bought";
	}
	if(bh==1) {
		return "haven't bought yet";
	}
	return null;
}
public int XuLyDemXe() {
	String sql="SELECT COUNT(BKS) FROM Car";
	int SoLuongXe=0;
	try {
		java.sql.Connection cnn = DBConnect.getConnecttion();
		PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			SoLuongXe=rs.getInt(1);
			return SoLuongXe;
		}
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 0;
}
}
