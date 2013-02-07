package sg.telin.backend.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.telin.backend.dao.ProductMapDao;
import sg.telin.backend.model.ProductMap;
import sg.telin.backend.service.ProductMapService;


@Service
public class ProductMapImpl implements ProductMapService {

	@Autowired
	private ProductMapDao productMapDao;
	
	public List<ProductMap> findByObject(ProductMap o) {
		return productMapDao.findByObject(o);
        
		
	}
	@Override
	public List<ProductMap> findAll() {
		return productMapDao.findAll();
	}

	@Override
	public void delete(ProductMap o) {
		productMapDao.delete(o);
		
	}

	@Override
	public int insert(ProductMap o) {
		
		return productMapDao.save(o);
	}

	@Override
	public void update(ProductMap o) {
		productMapDao.update(o);
		
	}

	public ProductMapDao getProductMapDao() {
		return productMapDao;
	}

	public void setProductMapDao(ProductMapDao productMapDao) {
		this.productMapDao = productMapDao;
	}

}
