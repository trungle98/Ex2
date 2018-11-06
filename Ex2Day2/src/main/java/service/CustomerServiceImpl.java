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
	List<Car> listCar = new ArrayList<Car>();
	/*
	 *<========================== getAllCar ==========================>
	 * 
	 */
	/*
	 * get information of all car in DB
	 * RETURN LIST CAR
	 *  
	 */
	public List<Car> getAllCar() {
		//Query infor of car from table: Car, HANGSANXUAT, BAOHANH, TINHNANG
		String sql = "SELECT Car.TenXe, Car.BKS,Car.NAMSANXUAT, HANGSANXUAT.TENHANGSANXUAT, BAOHANH.TENGOI, TINHANG.TENTINHNANG FROM Car LEFT JOIN HANGSANXUAT ON Car.HANGSANXUAT=HANGSANXUAT.HANGSANXUAT LEFT JOIN BAOHANH ON Car.MABH=BAOHANH.MABH LEFT JOIN TINHANG ON Car.MATINHNANG=TINHANG.MATINHNANG ORDER BY TenXe ";
		XuLyPhuThuoc xlpt = new XuLyPhuThuoc();

		try {

			java.sql.Connection cnn = DBConnect.getConnecttion();
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String tenXe = rs.getString(1);
				String bsk = rs.getString(2);
				String namSanXuat = rs.getString(3);
				String hangSanXuat = rs.getString(4);
				String tinhNang = rs.getString(5);
				String maBh = rs.getString(6);
				//ADD Car to ArrayList
				listCar.add(new Car(tenXe, Integer.parseInt(bsk), Integer.parseInt(namSanXuat), hangSanXuat,
						tinhNang, maBh));
			}
			System.out.println(listCar);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listCar;
	}
	/*
	 *<========================== autoImportCar ==========================>
	 * 
	 */
	/*
	 * Auto import random 10Car into DB
	 */
	public List<Car> autoImportCar() throws SQLException {
		String sql = "insert into Car values (?,?,?,?,?,?)";

		GregorianCalendar gc = new GregorianCalendar();
		XuLyPhuThuoc xlpt = new XuLyPhuThuoc();
		java.sql.Connection cnn = DBConnect.getConnecttion();
		PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
		int soXe=xlpt.XuLyDemXe();
		for (int i = 0; i < 10; i++) {
			int namSanXuat = randBetween(1980, 2012);
			int maHangSanXuat = randBetween(1, 3);
			int bsk = randBetween(10000, 99999);
			int maBh = randBetween(0, 3);
			int maTinhNang = xlpt.XuLyTinhNang(namSanXuat);
			String Ten = xlpt.XuLyTen().concat(Integer.toString(soXe+i));
			
			try {
				ps.setString(1, Ten);
				ps.setLong(2, bsk);
				ps.setLong(3, namSanXuat);
				ps.setLong(4, maHangSanXuat);
				ps.setLong(5, maTinhNang);
				ps.setLong(6, maBh);
				ps.executeUpdate();
				System.out.println(Ten); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/*
	 *<========================== randBetween ==========================>
	 * 
	 */
	/*
	 * RANDOM BETWEEN TWO NUMBER
	 * RETURN A NUMBER FROM start TO end
	 * TOBE USE TO RANDOM Number Plate, Year of manufacture, Brand, Have Insurance 
	 * 
	 */
	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
	/*
	 *<========================== SearchCar ==========================>
	 * 
	 */
	/*
	 * get information of car, which have a Number Plate
	 * RETURN CAR
	 *  THIS FUNCION WILL BE CALL IN muabaohiem.jsp
	 */
	public List<Car> SearchCar(String bks) {
		//Query infor of car from table: Car, HANGSANXUAT, BAOHANH, TINHNANG
		String sql = "SELECT Car.TenXe, Car.BKS,Car.NAMSANXUAT, HANGSANXUAT.TENHANGSANXUAT, BAOHANH.TENGOI, TINHANG.TENTINHNANG FROM Car LEFT JOIN HANGSANXUAT ON Car.HANGSANXUAT=HANGSANXUAT.HANGSANXUAT LEFT JOIN BAOHANH ON Car.MABH=BAOHANH.MABH LEFT JOIN TINHANG ON Car.MATINHNANG=TINHANG.MATINHNANG WHERE Car.BKS=? ";
		XuLyPhuThuoc xlpt = new XuLyPhuThuoc();

		try {

			java.sql.Connection cnn = DBConnect.getConnecttion();
			PreparedStatement ps = (PreparedStatement) cnn.prepareStatement(sql);
			ps.setString(1, bks);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String tenXe = rs.getString(1);
				String bsk = rs.getString(2);
				String namSanXuat = rs.getString(3);
				String hangSanXuat = rs.getString(4);
				String tinhNang = rs.getString(5);
				String maBh = rs.getString(6);
				//ADD Car to ArrayList
				listCar.add(new Car(tenXe, Integer.parseInt(bsk), Integer.parseInt(namSanXuat), hangSanXuat,
						tinhNang, maBh));
			}
			System.out.println(listCar);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listCar;
	}
}
