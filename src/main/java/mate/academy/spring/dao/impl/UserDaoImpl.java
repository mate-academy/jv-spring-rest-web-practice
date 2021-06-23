package mate.academy.spring.dao.impl;

import java.util.Optional;
import mate.academy.spring.dao.AbstractDao;
import mate.academy.spring.dao.UserDao;
import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query = session.createQuery("FROM User u "
                    + "WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user by email: " + email, e);
        }
    }

    @Override
    public Optional<User> getById(Long userId) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> getUserQuery = session.createQuery(
                    "FROM User u WHERE u.id = :id", User.class);
            getUserQuery.setParameter("id", userId);
            return Optional.ofNullable(getUserQuery.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get user by id: " + userId, e);
        }
    }
}
