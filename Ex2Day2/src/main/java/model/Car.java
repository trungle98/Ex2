/**
 * @author trung
 * @date Nov 3, 2018
 */
package model;

import java.util.Date;

/**
 * @author trung
 */
public class Car {
	String TenXe;
	private int bsk;
	private int NAMSANXUAT;
	private String HANGSANXUAT;
	private String MATINHNANG;
	private String MABH;
	
	
	
	/**
	 * @return the tenXe
	 */
	public String getTenXe() {
		return TenXe;
	}
	/**
	 * @param tenXe the tenXe to set
	 */
	public void setTenXe(String tenXe) {
		TenXe = tenXe;
	}
	/**
	 * @return the id
	 */
	/**
	 * @return the bsk
	 */
	public int getBsk() {
		return bsk;
	}
	/**
	 * @param bsk the bsk to set
	 */
	public void setBsk(int bsk) {
		this.bsk = bsk;
	}
	/**
	 * @return the nAMSANXUAT
	 */
	public int getNAMSANXUAT() {
		return NAMSANXUAT;
	}
	/**
	 * @param nAMSANXUAT the nAMSANXUAT to set
	 */
	public void setNAMSANXUAT(int nAMSANXUAT) {
		NAMSANXUAT = nAMSANXUAT;
	}
	/**
	 * @return the hANGSANXUAT
	 */
	public String getHANGSANXUAT() {
		return HANGSANXUAT;
	}
	/**
	 * @param hANGSANXUAT the hANGSANXUAT to set
	 */
	public void setHANGSANXUAT(String hANGSANXUAT) {
		HANGSANXUAT = hANGSANXUAT;
	}
	/**
	 * @return the mATINHNANG
	 */
	public String getMATINHNANG() {
		return MATINHNANG;
	}
	/**
	 * @param mATINHNANG the mATINHNANG to set
	 */
	public void setMATINHNANG(String mATINHNANG) {
		MATINHNANG = mATINHNANG;
	}
	/**
	 * @return the mABH
	 */
	public String getMABH() {
		return MABH;
	}
	/**
	 * @param mABH the mABH to set
	 */
	public void setMABH(String mABH) {
		MABH = mABH;
	}
	/**
	 * @param bsk
	 * @param nAMSANXUAT
	 * @param hANGSANXUAT
	 * @param mATINHNANG
	 * @param mABH
	 */
	
	/**
	 * 
	 */
	public Car() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [TenXe=" + TenXe + ", bsk=" + bsk + ", NAMSANXUAT=" + NAMSANXUAT + ", HANGSANXUAT=" + HANGSANXUAT
				+ ", MATINHNANG=" + MATINHNANG + ", MABH=" + MABH + "]";
	}
	/**
	 * @param tenXe
	 * @param bsk
	 * @param nAMSANXUAT
	 * @param hANGSANXUAT
	 * @param mATINHNANG
	 * @param mABH
	 */
	public Car(String tenXe, int bsk, int nAMSANXUAT, String hANGSANXUAT, String mATINHNANG, String mABH) {
		super();
		TenXe = tenXe;
		this.bsk = bsk;
		NAMSANXUAT = nAMSANXUAT;
		HANGSANXUAT = hANGSANXUAT;
		MATINHNANG = mATINHNANG;
		MABH = mABH;
	}

	
}
