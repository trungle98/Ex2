/**
 * @author trung
 * @date Nov 3, 2018
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.Car;
import utils.DBConnect;

/**
 * @author trung
 */
public class CustomerServiceImpl implements CustomerService {

	Car car;
	List<Car> listCustomer = new ArrayList<Car>();
	public List<Car> getAllCar() {

		String sql = "SELECT Car.TenXe, Car.BKS,Car.NAMSANXUAT, HANGSANXUAT.TENHANGSANXUAT, BAOHANH.TENGOI, TINHANG.TENTINHNANG FROM Car LEFT JOIN HANGSANXUAT ON Car.HANGSANXUAT=HANGSANXUAT.HANGSANXUAT LEFT JOIN BAOHANH ON Car.MABH=BAOHANH.MABH LEFT JOIN TINHANG ON Car.MATINHNANG=TINHANG.MATINHNANG ORDER BY TenXe ";
		XuLyPhuThuoc xlpt = new XuLyPhuThuoc();

		try {

			java.sql.Connection cnn = DBConnect.getConnecttion();
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String TenXe = rs.getString(1);
				String bsk = rs.getString(2);
				String NAMSANXUAT = rs.getString(3);
				String HANGSANXUAT = rs.getString(4);
				String TINHNANG = rs.getString(5);
				String MABH = rs.getString(6);
			
				listCustomer.add(new Car(TenXe, Integer.parseInt(bsk), Integer.parseInt(NAMSANXUAT), HANGSANXUAT,
						TINHNANG, MABH));
			}
			System.out.println(listCustomer);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listCustomer;
	}

	public List<Car> autoImportCar() throws SQLException {
		String sql = "insert into Car values (?,?,?,?,?,?)";

		GregorianCalendar gc = new GregorianCalendar();
		XuLyPhuThuoc xlpt = new XuLyPhuThuoc();
		java.sql.Connection cnn = DBConnect.getConnecttion();
		PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
		int soxe=xlpt.XuLyDemXe();
		for (int i = 0; i < 10; i++) {
			int NamSanXuat = randBetween(1980, 2012);
			int MaHangSanXuat = randBetween(1, 3);
			int Bsk = randBetween(10000, 99999);
			int MaBh = randBetween(0, 1);
			int MaTinhNang = xlpt.XuLyTinhNang(NamSanXuat);
			String Ten = xlpt.XuLyTen().concat(Integer.toString(soxe+i));
			
			try {
				ps.setString(1, Ten);
				ps.setLong(2, Bsk);
				ps.setLong(3, NamSanXuat);
				ps.setLong(4, MaHangSanXuat);
				ps.setLong(5, MaTinhNang);
				ps.setLong(6, MaBh);
				ps.executeUpdate();
				System.out.println(Ten); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

}
