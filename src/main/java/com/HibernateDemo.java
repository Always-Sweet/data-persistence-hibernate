package com;

import com.modal.Dic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dic dic = new Dic();
        dic.setDicCode("D.001");
        dic.setDicName("是否");
        dic.setDescription("");

        session.save(dic);

        dic.setDescription("Description");

        session.update(dic);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
