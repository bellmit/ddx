package com.upcera.ddx.dao.base.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.upcera.ddx.common.util.ToolsKit;
import com.upcera.ddx.dao.base.IBaseDao;
/**
 * 抽象dao
 * @author 金德志
 *
 */
public abstract class BaseHibernateDao<T extends Serializable, PK extends Serializable>
		implements IBaseDao<T, PK> {

	
	private Class<T> entityClass;

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public BaseHibernateDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void add(T entity) {
		getSession().save(entity);
	}
	@Override
	public void batchAdd(List<T> entity){
		if(null!=entity){
			for (int i = 0; i < entity.size(); i++) {
				this.add(entity.get(i));
			}
		}
	}
	public void delete(PK... ids) {
		if (null != ids) {
			for (Serializable id : ids) {
				getSession().delete(getSession().load(entityClass, id));
			}
		}
	}

	public void addOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public T find(PK id) {
		return (T) getSession().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T get(PK id) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public T load(PK id) {
		return (T) getSession().load(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		return getSession().createQuery("from " + getEntityName(entityClass)).list();
	}

	public void update(T entity) {
		getSession().update(entity);
	}
	@Override
	public void batchUpdate(List<T> entity) {
		// TODO Auto-generated method stub
		if(null!=entity){
			for (int i = 0; i < entity.size(); i++) {
				this.update(entity.get(i));
			}
		}
	}
	public Long getCount() {
		return (Long) getSession().createQuery(
				"select count(" + getCountField(entityClass) + ") from "
						+ getEntityName(entityClass) + " as o").uniqueResult();
	}
	@Override
	public Long getCountByLike(T entity) throws Exception {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(addCondition(entity, "select count(*) from "+getEntityName(entityClass)+" where 1=1 ",true).toString());
		return (Long) query.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAllByLike(T entity,int pageNo,int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(addCondition(entity, "from "+getEntityName(entityClass)+" where 1=1 ",true).append(" order by id desc").toString());
		if(pageSize>0){
			query.setFirstResult(pageNo * pageSize - pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	@Override
	public Long getCountByEqual(T entity) throws Exception {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(addCondition(entity, "select count(*) from "+getEntityName(entityClass)+" where 1=1 ",false).toString());
		return (Long) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAllByEqual(T entity, int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(addCondition(entity, "from "+getEntityName(entityClass)+" where 1=1 ",false).append(" order by id desc").toString());
		if(pageSize>0){
			query.setFirstResult(pageNo * pageSize - pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	public void clear() {
		getSession().clear();
	}

	public void evict(T entity) {
		getSession().evict(entity);
	}

	public void flush() {
		getSession().flush();
	}
	private static <E> String getEntityName(Class<E> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (null != entity.name() && !"".equals(entity.name())) {
			entityName = entity.name();
		}
		return entityName;
	}

	private static <E> String getCountField(Class<E> clazz) {
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(clazz).getPropertyDescriptors();
			for (PropertyDescriptor propertydesc : propertyDescriptors) {
				Method method = propertydesc.getReadMethod();
				if (method != null
						&& method.isAnnotationPresent(EmbeddedId.class)) {
					PropertyDescriptor[] ps = Introspector.getBeanInfo(
							propertydesc.getPropertyType())
							.getPropertyDescriptors();
					out = "o."
							+ propertydesc.getName()
							+ "."
							+ (!ps[1].getName().equals("class") ? ps[1]
									.getName() : ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return out;
	}
	
	private static List<Method> getmethodList(String flag, Method[] method) {
		List<Method> methodList = new ArrayList<Method>();
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().indexOf(flag) != -1) {
				methodList.add(method[i]);
			}
		}
		return methodList;
	}
	
	@SuppressWarnings("unchecked")
	public StringBuffer addCondition(T condition, String hql, boolean isLike) throws Exception {
		StringBuffer hqlString = new StringBuffer();
		hqlString.append(hql);
		if (ToolsKit.EmptyCheckUtil.isNotEmpty(condition)) {
			hqlString.append("and (");
			Map condition2Map = ToolsKit.jsonUitl.toBean(Map.class, ToolsKit.jsonUitl.toJson(condition));
			Iterator it = condition2Map.entrySet().iterator();
			boolean conditionsBlank = true;
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				if (ToolsKit.EmptyCheckUtil.isNotEmpty(entry.getValue())) {
					String key = ToolsKit.TypeConversionUtil.asString((entry.getKey()));
					String value = ToolsKit.TypeConversionUtil.asString(entry.getValue());
					
					String methodName = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
					Method method = condition.getClass().getMethod("get" + methodName);
					if(!method.isAnnotationPresent(Transient.class)) {
						if (!isLike) {
							conditionsBlank = false;
							hqlString.append(" ").append(key);
							hqlString.append(" = '").append(value).append("' and");
						} else {
							if (!method.isAnnotationPresent(Id.class)) {
								if(!method.getReturnType().getName().equals("java.lang.Integer") && !method.getReturnType().getName().equals("int")){
									conditionsBlank = false;
									hqlString.append(" ").append(key);
									hqlString.append(" like '").append("%" + value + "%' ").append(" or");
								
								}
							}
						}
					}
				}
			}
			if (conditionsBlank) {
				hqlString.append(" 1=1 ");
			} else {
				int digital = 2;
				if (!isLike) {
					digital = 3;
				}
				String hqlstr = hqlString.toString();
				hqlString = new StringBuffer(hqlstr.substring(0, hqlstr.length() - digital));
			}
			hqlString.append(")");
			if (isLike) {
				List<Method> method = getmethodList("get", condition.getClass().getMethods());
				for (int i = 0; i < method.size(); i++) {
					if(!method.get(i).isAnnotationPresent(Transient.class)) {
						if (method.get(i).isAnnotationPresent(Id.class) || method.get(i).getReturnType().getName().equals("java.lang.Integer") || method.get(i).getReturnType().getName().equals("int")) {
							Integer id = ToolsKit.TypeConversionUtil.asInteger(method.get(i).invoke(condition));
							if (ToolsKit.EmptyCheckUtil.isNotEmpty(id)) {
								String methodName = method.get(i).getName().split("get")[1];
								String name = methodName.substring(0, 1).toLowerCase() + methodName.substring(1, methodName.length());
								hqlString.append(" and " + name + " = " + id);
							}
						}
					}
				}
			}
		}
		return hqlString;
	}

	@Override
	public List<T> queryListByCriteria(String hqlString, Map<String,Object> params , Integer pageNo, Integer pageSize) {
		Query query = getSession().createQuery(hqlString);
		query.setProperties(params);
		if(pageSize>0){
			query.setFirstResult(pageNo * pageSize - pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}

	@Override
	public Long queryCountByCriteria(String hqlString, Map<String,Object> params) {
		Query query = getSession().createQuery(hqlString);
		query.setProperties(params);
		return (Long) query.uniqueResult();
	}
	
	@Override
	public List<T> queryListByCriteria(String hqlString,Map<String,Object> params){
		Query query = getSession().createQuery(hqlString);
		query.setProperties(params);
		return query.list();
	}
	
}
