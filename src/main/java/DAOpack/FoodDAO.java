package DAOpack;

import model.Food;
import java.util.List;

public interface FoodDAO {

    public void create(Food item);
    public Food readById(int id);
    public List<Food> readAll();
    public void update(Food item);
    public void deleteById(int id);
    public void deleteAll();
}
