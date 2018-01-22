package cn.easybuy.dao;

import java.util.List;


public interface IBaseDao<T> {
	public T findById(int id);
	public List<T> getAll();
	public boolean add(T t);
	public boolean delete(int id);
	public boolean update(T t);
}