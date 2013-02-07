package sg.telin.backend.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BaseService<Object, Integer>  {

	public abstract List<Object> findAll();
	public abstract void delete(Object o);
	public abstract int insert(Object o);
	public abstract void update(Object o);
}
