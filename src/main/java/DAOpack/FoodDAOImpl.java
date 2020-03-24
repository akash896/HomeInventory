package DAOpack;

import model.Food;
import org.hibernate.Criteria;
import org.hibernate.Session;
import java.util.List;

public class FoodDAOImpl implements FoodDAO {
    public void create(Food item) {
        // code to save a book
        Session session = HibernateUtil.getSession();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    public Food readById(int id) {
        // code to get a book
        Session session = HibernateUtil.getSession();
        Food item =
                (Food)session.get(Food.class, id);
        /*System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());*/
        session.close();
        return item;
    }

    public List<Food> readAll() {
        Session session = HibernateUtil.getSession();
        Criteria crit = session.createCriteria(Food.class);//passing Class class argument
        List<Food> list = crit.list();
        return list;
    }

    public void update(Food item) {
// code to modify a book
        Session session = HibernateUtil.getSession();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteById(int id) {
// code to remove a book
        Session session = HibernateUtil.getSession();
        session.delete(id);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteAll() {
//  ---------------------------------------------------------
    }
}
