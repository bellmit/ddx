package com.upcera.ddx.service.base;

import java.io.Serializable;
import java.util.List;

/**
 * 抽象Service接口
 * @author 金德志
 * @param <T> 实体对象
 * @param <PK> 主键
 */
public interface IBaseService<T extends Serializable, PK extends Serializable>  {
	/**
	 * 保存实体
	 * @param entity
	 */
	public void add(T entity);
	/**
	 * 批量保存实体
	 * @param entity
	 */
	public void batchAdd(List<T> entity);
	/**
	 * 删除实体
	 * @param ids
	 */
	public void delete(PK... ids); 
	
	/**
	 * 更新实体
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 批量更新实体
	 * @param entity
	 */
	public void batchUpdate(List<T> entity);
	/**
	 * 添加或更新实体
	 * @param entity
	 */
	public void addOrUpdate(T entity);
	
	/**
	 * 查询实体, 使用load方式, 支持延迟加载
	 * @param id
	 * @return
	 */
	public T find(PK id);
	
	/**
	 * 查询实体, 使用get方式, 不支持延迟加载
	 * @param id
	 * @return
	 */
	public T get(PK id);
	
	/**
	 * 查询实体, 使用load方式, 支持延迟加载
	 * @param id
	 * @return
	 */
	public T load(PK id);
	
	/**
	 * 获取记录总数
	 * @return
	 */
	public Long getCount();
	
	/**
	 * 查询所有实体
	 * @return
	 */
	public List<T> listAll();
	/**
	 * 根据条件获取记录总数
	 * @return
	 */
	public Long getCountByLike(T entity) throws Exception;
	
	/**
	 * 根据条件查询所有实体
	 * @return
	 */
	public List<T> listAllByLike(T entity,int pageNo,int pageSize) throws Exception;
	/**
	 * 根据条件获取记录总数
	 * @return
	 */
	public Long getCountByEqual(T entity) throws Exception;
	
	/**
	 * 根据条件查询所有实体
	 * @return
	 */
	public List<T> listAllByEqual(T entity,int pageNo,int pageSize) throws Exception;
	
	/**
	 * 执行SQL 放入一级缓存
	 */
	public void flush();
	
	/**
	 * 从一级缓存中清楚某个对象
	 * @param entity
	 */
	public void evict(T entity);
	
	/**
	 * 清理一级缓存
	 */
	public void clear();
	
}
