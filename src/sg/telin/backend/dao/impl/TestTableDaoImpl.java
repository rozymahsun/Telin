package sg.telin.backend.dao.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.springframework.stereotype.Repository;

import sg.telin.backend.dao.TestTableDao;
import sg.telin.backend.model.TestTable;
 
 
/**
 * DAO for table: TestTable.
 * @author autogenerated
 */
@Repository
public class TestTableDaoImpl extends GenericHibernateDaoImpl<TestTable, String> implements TestTableDao {
	
	/** Constructor method. */
		public TestTableDaoImpl() {
			super(TestTable.class);
		}
	}

