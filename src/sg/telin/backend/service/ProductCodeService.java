package sg.telin.backend.service;

import org.springframework.transaction.annotation.Transactional;

import sg.telin.backend.model.ProductCode;

@Transactional
public interface ProductCodeService extends BaseService<ProductCode, Integer> {

}
