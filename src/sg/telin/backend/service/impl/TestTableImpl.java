package sg.telin.backend.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.telin.backend.dao.TestTableDao;
import sg.telin.backend.model.TestTable;
import sg.telin.backend.service.TestTableService;



@Service
public class TestTableImpl implements TestTableService {

	@Autowired
	private TestTableDao testTableDao;
	
	public List<TestTable> findByObject(TestTable o) {
//		return testTableDao.findByObject(o);  //create this on DAO Implementation
		return testTableDao.findAll();
        
		
	}
	@Override
	public List<TestTable> findAll() {
		return testTableDao.findAll();
	}

	@Override
	public void delete(TestTable o) {
		testTableDao.delete(o);
		
	}

	@Override
	public int insert(TestTable o) {
		testTableDao.save(o);
		return 0;
	}

	@Override
	public void update(TestTable o) {
		testTableDao.update(o);
		
	}
	public TestTableDao getTestTableDao() {
		return testTableDao;
	}
	public void setTestTableDao(TestTableDao testTableDao) {
		this.testTableDao = testTableDao;
	}



}
