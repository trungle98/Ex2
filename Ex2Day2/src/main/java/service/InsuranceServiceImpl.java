/**
 * @author trung
 * @date Nov 6, 2018
 */
package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.BaoHanh;
import utils.DBConnect;

/**
 * @author trung
 */
public class InsuranceServiceImpl implements InsuranceService {
	java.sql.Connection cnn = DBConnect.getConnecttion();
	List<BaoHanh> listBaoHanh=new ArrayList<BaoHanh>();
	/*
	 * <========================== GetAllInsurance ==========================>
	 * 
	 */
	
	/*
	 * @Get all and count Insurance in DB
	 * 
	 */
	public List<BaoHanh> GetAllInsurance() {
	try {
		String sql = "SELECT * FROM BAOHANH";
		PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maBH=rs.getString(1);
			String tenGoi=rs.getString(2);
			String loaiXe=rs.getString(3);
			listBaoHanh.add(new BaoHanh(maBH, tenGoi, loaiXe));
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return listBaoHanh;

	}
	/*
	 * <========================== CheckBuyInsurance ==========================>
	 * 
	 */

	/*
	 * Check Car have bought Insurance yet And Check valid CONSTRAIN Insurance vs
	 * NAMSANXUAT SQL Query MABH, NAMSANXUAT from table CAR where variable BKS from
	 * muabaohiem.jsp
	 */
	public boolean CheckBuyInsurance(String bks) {
		try {
			String sql = "SELECT Car.MABH, Car.NAMSANXUAT FROM Car WHERE Car.BKS =? ";
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ps.setString(1, bks);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// GET MABH AND NAMSANXUAT

				String Insurance = rs.getString(1);
				String namSanXuat = rs.getString(2);
				
				System.out.println(Insurance+"insurance and Years of manufacture"+namSanXuat);
				
				// IF INSURANCE==0 THAT MEAN THIS CAR HAVEN'T BOUGHT INSURANCE YET
				if (Insurance.equals("0")) {
					// IF NAMSANXUAT >= 2005 THIS CAR HAVE TO BUY PACKAGE A(PACKAGE A HAVE CODE
					// NUMBER IS 1
					if (Integer.parseInt(namSanXuat) >= 2005) {
						BuyInsurance(bks, 1);
						System.out.println("call A");

						return true;
					}
					// IF NAMSANXUAT FROM 1996 TO 2004 THIS CAR HAVE TO BUY PACKAGE B(PACKAGE B HAVE
					// CODE NUMBER IS 2
					if (Integer.parseInt(namSanXuat) >= 1996) {
						BuyInsurance(bks, 2);
						System.out.println("call B");
						return true;

					}
					// IF NAMSANXUAT <1996 THIS CAR HAVE TO BUY PACKAGE C(PACKAGE C HAVE CODE NUMBER
					// IS 3
					else {
						BuyInsurance(bks, 3);
						System.out.println("call C");

						return true;

					}

				} 
				//IF INSURANCE # 0, THAT MEAN THIS CAR HAVE BOUGHT INSURANCE, AND RETURN FALSE
				else {
					return false;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}

	/*
	 * <========================== BuyInsurance ==========================>
	 * 
	 */
	/*
	 * UPDATE INSURANCE FOR CAR HAVEN'T BOUGHT INSURANCE
	 */
	public boolean BuyInsurance(String bks, int maBH, int soLuongConLai) {
		System.out.println("FUNCTION BuyInsurance!");
		String sql = "UPDATE Car SET Car.MABH=? WHERE Car.BKS=?";
		try {
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ps.setInt(1, maBH);
			ps.setString(2, bks);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * <========================== CreateNewInsurance ==========================>
	 * 
	 */
	public void CreateNewInsurance() {
		// TODO Auto-generated method stub

	}


}
