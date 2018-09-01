package com.util.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.util.dao.BaseDao;
import com.util.entity.Pagination;

public class BaseDaoImpl<K extends Serializable, T extends Serializable>
		implements BaseDao<K, T> {

	@SuppressWarnings("unused")
	private Class<K> modelIdClass; // 继承baseDaoImapl类的子类.Class
	private Class<T> modelClass;

	@SuppressWarnings("unchecked")
	protected BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		modelIdClass = (Class<K>) actualTypeArguments[0];
		modelClass = (Class<T>) actualTypeArguments[1];
		System.out.println("clazz ==>> " + modelClass);
		// System.out.println(modelClass.getSimpleName());
	}

	@Autowired
	private SessionFactory sessionFactory;

	// 获取得当前Session
	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(K id) {
		// TODO Auto-generated method stub
		return (T) this.getCurrentSession().load(modelClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(K id) {
		// TODO Auto-generated method stub
		return (T) this.getCurrentSession().get(modelClass, id);
	}

	@Override
	public void persist(T entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public K save(T entity) {
		// TODO Auto-generated method stub
		return (K) this.getCurrentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		this.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(K id) {
		// TODO Auto-generated method stub
		T entity = this.load(id);
		this.getCurrentSession().delete(entity);
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		this.getCurrentSession().flush();
	}

	// 获取某个对象集合List<T>
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return this.getCurrentSession().createQuery("from " + getEntityName())
				.setCacheable(true).list();
	}

	// 按HQL查询对象列表,数量可变的参数，按顺序绑定
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(final String hql, final Object... values) {
		// TODO Auto-generated method stub
		Query query = createQuery(hql, values);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> find(final String hql, Map<String, ?> values) {
		Query query = createQuery(hql, values);
		return query.list();
	}

	// 按Criteria查询对象列表，可变的criterion
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}
	
	// 按属性查找对象列表，默认匹配方式为like
	@Override
	public List<T> findByProperty(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.like(propertyName, (String) value,
				MatchMode.ANYWHERE);
		return find(criterion);
	}

	// 按属性查找唯一对象，默认匹配方式为like
	@SuppressWarnings("unchecked")
	@Override
	public T findUniqueByProperty(final String propertyName, final Object value) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criterion criterion = Restrictions.like(propertyName, (String) value,
				MatchMode.ANYWHERE);
		return (T) createCriteria(criterion).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<T> findPage(String whereSql, Pagination pagination,
			Object... args) {
		// TODO Auto-generated method stub
		if (pagination == null) {
			pagination = new Pagination();
		}
		int skip = (pagination.getCurrentPage() - 1) * pagination.getPageSize();
		StringBuilder sqlSb = new StringBuilder(whereSql);
		int count = count(sqlSb.toString(), args); // 得到要查询的总记录数
		pagination.setTotalCount(count);
		pagination.setTotalPage((int) Math.ceil((double) count/ pagination.getPageSize()));
		Query query = createQuery(whereSql, args);
		query.setMaxResults(pagination.getPageSize()); // 设置要查询的页面大小
		query.setFirstResult(skip); // 设置查询条件的起始位置
		List<T> list = query.list(); // 获取到一个页面的数据
		pagination.setData(list);
		return pagination;
	}

	// 按条件查询总记录数
	public int count(String whereSql, Object... values) {
		String countSql = "select count(*) from " + getEntityName()
				+ " where 1=1 " + whereSql;
		Query query = this.getCurrentSession().createQuery(countSql)
				.setCacheable(true);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		long count = (long) query.uniqueResult();
		return (int) count;
	}

	@SuppressWarnings("unchecked")
	public List<T> query(String whereSql, Object... values) {
		Query query = createQuery(whereSql, values);
		return query.list();
	}

	// 根据Criterion条件创建Criterion,与find函数可进行更加灵活的操作
	// 数量可变的Criterion
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = this.getCurrentSession().createCriteria(modelClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	// 根据查询HQL与参数列表创建Query对象，与find()函数可进行更加灵活的操作
	// 数量可变的参数，按顺序绑定
	public Query createQuery(final String whereSql, final Object... values) {
		//Assert.hasText(whereSql, "queryString不能为空");
		StringBuilder builder = new StringBuilder();
		builder.append("from " + getEntityName() + " ");
		builder.append("where 1=1 ");
		builder.append(whereSql);
		Query query = this.getCurrentSession().createQuery(builder.toString())
				.setCacheable(true);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	// 根据查询HQL与参数列表创建Query对象，与find()函数可进行更加灵活的操作
	// 命名参数，按名称绑定
	public Query creatQuery(final String whereSql, final Map<String, ?> values) {
		StringBuilder builder = new StringBuilder();
		builder.append("from " + getEntityName() + " ");
		builder.append("where 1=1 ");
		builder.append(whereSql);
		Query query = this.getCurrentSession().createQuery(builder.toString())
				.setCacheable(true);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	// 获取对象的主键名
	public String getIdName() {
		ClassMetadata meta = sessionFactory.getClassMetadata(modelClass);
		return meta.getIdentifierPropertyName();
	}

	// 获取对象名
	public String getEntityName() {
		// System.out.println(modelClass.getSimpleName());
		return modelClass.getSimpleName();
	}

	// 判断对象的属性值在数据库内是否唯一
	// 在修改对象的情景下，如果属性新修改的值(value)等于属性原来的值(orgValue)则不作比较
	public boolean isPropertyUnique(final String propertyName,
			final Object newValue, final Object oldValue) {
		if (newValue == null || newValue.equals(oldValue)) {
			return true;
		}
		Object object = findUniqueByProperty(propertyName, newValue);
		return (object == null);
	}
}
