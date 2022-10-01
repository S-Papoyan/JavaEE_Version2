package com.digi.repository.jpaRepository;

import com.digi.model.User;
import com.digi.util.HibernateUtil;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import java.util.List;

@Data
public class UserJPARepository {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        NativeQuery<User> nativeQuery = session.createNativeQuery("select * from users", User.class);
        List<User> resultList = nativeQuery.getResultList();
        return resultList;
    }
}