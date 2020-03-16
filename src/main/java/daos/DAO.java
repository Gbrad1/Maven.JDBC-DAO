package daos;


import java.util.List;

public interface DAO<T> {
    T findBySSN(String ssn);
    List<T> findAll();
    Boolean update(CardDTO dto);
    Boolean create(CardDTO dto);
    Boolean delete(String ssn);
}
