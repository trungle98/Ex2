/**
 * @author trung
 * @date Nov 5, 2018
 */
package model;

/**
 * @author trung
 */
public class BaoHanh {
	private String maBh;
	private String tenGoi;
	private String loaiXe;
	/**
	 * @return the maBh
	 */
	public String getMaBh() {
		return maBh;
	}
	/**
	 * @param maBh the maBh to set
	 */
	public void setMaBh(String maBh) {
		this.maBh = maBh;
	}
	/**
	 * @return the tenGoi
	 */
	public String getTenGoi() {
		return tenGoi;
	}
	/**
	 * @param tenGoi the tenGoi to set
	 */
	public void setTenGoi(String tenGoi) {
		this.tenGoi = tenGoi;
	}
	/**
	 * @return the loaiXe
	 */
	public String getLoaiXe() {
		return loaiXe;
	}
	/**
	 * @param loaiXe the loaiXe to set
	 */
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	/**
	 * @param maBh
	 * @param tenGoi
	 * @param loaiXe
	 */
	public BaoHanh(String maBh, String tenGoi, String loaiXe) {
		super();
		this.maBh = maBh;
		this.tenGoi = tenGoi;
		this.loaiXe = loaiXe;
	}
	/**
	 * 
	 */
	public BaoHanh() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaoHanh [maBh=" + maBh + ", tenGoi=" + tenGoi + ", loaiXe=" + loaiXe + "]";
	}
	
}
