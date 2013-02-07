package sg.telin.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.telin.backend.dao.ProductCodeDao;
import sg.telin.backend.model.ProductCode;
import sg.telin.backend.service.ProductCodeService;



@Service
public class ProductCodeImpl implements ProductCodeService  {

	@Autowired
	private ProductCodeDao productCodeDao;
	
	@Override
	public List<ProductCode> findAll() {
		
		return productCodeDao.findAll();
	}

	@Override
	public void delete(ProductCode o) {
		productCodeDao.delete(o);
	}

	@Override
	public int insert(ProductCode o) {
		 productCodeDao.save(o);
		return 0;
	}

	@Override
	public void update(ProductCode o) {
		productCodeDao.update(o);		
	}

	public ProductCodeDao getProductCodeDao() {
		return productCodeDao;
	}

	public void setProductCodeDao(ProductCodeDao productCodeDao) {
		this.productCodeDao = productCodeDao;
	}

}
