package com.thoughtfocus.mvc.dao;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thoughtfocus.mvc.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveUser(UserDTO user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(user);

			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return true;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public UserDTO getByUserNameAndPaaword(String username, String password) {
		String hql = "SELECT user FROM UserDTO user WHERE username=:name AND password =:pwd";
		Session session = null;
		Transaction transaction = null;
		Query query;
		UserDTO dto = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			query = session.createQuery(hql);

			query.setParameter("name", username);
			query.setParameter("pwd", password);

			dto = (UserDTO) query.uniqueResult();

			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

		return dto;
	}

	@Override
	public boolean deleteUserByName(String username) {
		String hql = "DELETE FROM UserDTO user WHERE username=:name";
		Session session = null;
		Transaction transaction = null;
		Query query;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			query = session.createQuery(hql);

			query.setParameter("name", username);

			query.executeUpdate();

			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

		return true;
	}

	@Override
	public boolean updateUserByName(String username, long mobilenumber, double age) {
		String hql = "UPDATE UserDTO SET mobilenumber=:num,age=:age WHERE username=:name";
		Session session = null;
		Transaction transaction = null;
		Query query;
		int updateCount = 0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			query = session.createQuery(hql);

			query.setParameter("num", mobilenumber);
			query.setParameter("age", age);
			query.setParameter("name", username);

			updateCount = query.executeUpdate();

			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}
		if (updateCount != 0) {
			return true;
		}
		return false;
	}

}
