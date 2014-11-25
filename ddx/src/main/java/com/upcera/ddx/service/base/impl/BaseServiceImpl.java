package com.upcera.ddx.service.base.impl;

import java.io.Serializable;
import java.util.List;

import com.upcera.ddx.dao.base.IBaseDao;
import com.upcera.ddx.service.base.IBaseService;

/**
 * 抽象service
 * @author 金德志
 *
 */
public abstract class BaseServiceImpl<T extends Serializable, PK extends Serializable> implements IBaseService<T, PK> {


	
	@Override
	public Long getCountByLike(T entity) throws Exception {
		// TODO Auto-generated method stub
		return getDao().getCountByLike(entity);
	}

	@Override
	public List<T> listAllByLike(T entity, int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return getDao().listAllByLike(entity, pageNo, pageSize);
	}
	
	@Override
	public Long getCountByEqual(T entity) throws Exception{
		return getDao().getCountByEqual(entity);
	}
	
	@Override
	public List<T> listAllByEqual(T entity,int pageNo,int pageSize) throws Exception{
		return getDao().listAllByEqual(entity, pageNo, pageSize);
	}
	
	public abstract IBaseDao<T, PK> getDao();
	
	public void add(T entity) { 
		getDao().add(entity);
	}
	public void batchAdd(List<T> entity){
		getDao().batchAdd(entity);
	}
	public void delete(PK... ids) {
		getDao().delete(ids);
	} 
	
	public void addOrUpdate(T entity) {
		getDao().addOrUpdate(entity);
	}

	
	public T find(PK id) {
		return getDao().find(id);
	}
	
	
	public T get(PK id) {
		return getDao().get(id);
	}
	
	
	public T load(PK id) {
		return getDao().load(id);
	}

	
	public Long getCount() {
		return getDao().getCount();
	}

	
	public List<T> listAll() {
		return getDao().listAll();
	}

	
	public void update(T entity) {
		getDao().update(entity);
	}
	public void batchUpdate(List<T> entity) {
		// TODO Auto-generated method stub
		getDao().batchUpdate(entity);
	}
	
	public void clear() {
		getDao().clear();
	}

	
	public void evict(T entity) {
		getDao().evict(entity);
	}

	
	public void flush() {
		getDao().flush();
	}
	
}
