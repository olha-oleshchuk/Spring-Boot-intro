package mate.academy.repository.impl;

import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import mate.academy.repository.AbstractDao;
import org.hibernate.Transaction;

public class BookRepositoryImpl extends mate.academy.hibernate.relations.dao.impl.AbstractDao implements BookRepository {
    public BookRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    Book save(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(actor);
            transaction.commit();
            return actor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert actor: " + actor, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    List findAll() {

    }
}
