package sg.telin.backend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import sg.telin.backend.model.TestTable;



@Transactional
public interface TestTableService  extends BaseService<TestTable, Integer> {

	public List<TestTable> findByObject(TestTable o);
}
