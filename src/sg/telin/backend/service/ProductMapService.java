package sg.telin.backend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sg.telin.backend.model.ProductMap;

@Transactional
public interface ProductMapService  extends BaseService<ProductMap, Integer> {

	public List<ProductMap> findByObject(ProductMap o);
}
