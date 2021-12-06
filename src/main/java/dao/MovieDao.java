package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDao.class);

    @Inject
    EntityManager entityManager;

    public Person find(Integer id) {

        final EntityManager em = entityManager;
        try {
            return em.find(Person.class, id);
        } catch (RuntimeException e) {
            LOGGER.error("failed to find person id {} :{}",id, e.getMessage());
            return null;
        }
    }
}
