/**
 * @author trung
 * @date Nov 5, 2018
 */
package model;

/**
 * @author trung
 */
public class TinhNang {
	private int maTinhNang;
	private String tenTinhNang;
	/**
	 * @return the maTinhNang
	 */
	public int getMaTinhNang() {
		return maTinhNang;
	}
	/**
	 * @param maTinhNang the maTinhNang to set
	 */
	public void setMaTinhNang(int maTinhNang) {
		this.maTinhNang = maTinhNang;
	}
	/**
	 * @return the tenTinhNang
	 */
	public String getTenTinhNang() {
		return tenTinhNang;
	}
	/**
	 * @param tenTinhNang the tenTinhNang to set
	 */
	public void setTenTinhNang(String tenTinhNang) {
		this.tenTinhNang = tenTinhNang;
	}
	/**
	 * @param maTinhNang
	 * @param tenTinhNang
	 */
	public TinhNang(int maTinhNang, String tenTinhNang) {
		super();
		this.maTinhNang = maTinhNang;
		this.tenTinhNang = tenTinhNang;
	}
	/**
	 * 
	 */
	public TinhNang() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TinhNang [maTinhNang=" + maTinhNang + ", tenTinhNang=" + tenTinhNang + "]";
	}
	
}
