/**
 * @author trung
 * @date Nov 5, 2018
 */
package model;

/**
 * @author trung
 */
public class HangSanXuat {
	private int HangSanXuat;
	private String TenHangSanXuat;
	/**
	 * @return the hangSanXuat
	 */
	public int getHangSanXuat() {
		return HangSanXuat;
	}
	/**
	 * @param hangSanXuat the hangSanXuat to set
	 */
	public void setHangSanXuat(int hangSanXuat) {
		HangSanXuat = hangSanXuat;
	}
	/**
	 * @return the tenHangSanXuat
	 */
	public String getTenHangSanXuat() {
		return TenHangSanXuat;
	}
	/**
	 * @param tenHangSanXuat the tenHangSanXuat to set
	 */
	public void setTenHangSanXuat(String tenHangSanXuat) {
		TenHangSanXuat = tenHangSanXuat;
	}
	/**
	 * @param hangSanXuat
	 * @param tenHangSanXuat
	 */
	public HangSanXuat(int hangSanXuat, String tenHangSanXuat) {
		super();
		HangSanXuat = hangSanXuat;
		TenHangSanXuat = tenHangSanXuat;
	}
	/**
	 * 
	 */
	public HangSanXuat() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HangSanXuat [HangSanXuat=" + HangSanXuat + ", TenHangSanXuat=" + TenHangSanXuat + "]";
	}
	
}
