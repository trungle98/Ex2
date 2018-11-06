/**
 * @author trung
 * @date Nov 6, 2018
 */
package service;

import java.util.List;

import model.BaoHanh;

/**
 * @author trung
 * Buy, Create, getAll Insurance
 */
public interface InsuranceService {
	List<BaoHanh> GetAllInsurance();
	
	void CreateNewInsurance();
}
