package RESTpack;

import DAOpack.FoodDAO;
import model.Food;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTMapper {

    ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    // getting a FoodDAOImpl bean and then typecasting it to FoodDAO.class and assigning it to foodDAO
    FoodDAO foodDAO = context.getBean("FoodDAOImpl", FoodDAO.class);

    @RequestMapping("/Inventory")
    public String welcome(){
        return "Welcome to your Inventory ";
    }

    @PostMapping(path = "/Inventory/Food/addItem", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addItem(@RequestBody Food food){
        System.out.println(food.toString());
        foodDAO.create(food);
        return "Food item added successfully ";
    }

    @GetMapping(path = "Inventory/Food/getItem/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Food> getItem(@PathVariable int id){
        Food f = foodDAO.readById(id);
        return ResponseEntity.ok(f);
    }

    @GetMapping(path = "Inventory/Food/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Food>> getItem(){
        List<Food> f = foodDAO.readAll();
        return ResponseEntity.ok(f);
    }

    @PutMapping(path = "/Inventory/Food/Update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateItem(@RequestBody Food food) {
        foodDAO.update(food);
        return "Item updated ";
    }

    @DeleteMapping(path = "/Inventory/Food/Delete/{id}")
    public String deleteItem(@PathVariable int id) {
        foodDAO.deleteById(id);
        return "Item deleted ";
    }

    @DeleteMapping(path = "/Inventory/Food/DeleteAll")
    public String deleteAllItem() {
        foodDAO.deleteAll();
        return "All Items deleted ";
    }

}
