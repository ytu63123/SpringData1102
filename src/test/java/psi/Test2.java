package psi;

import com.spring.mvc.psi.entities.Inventory;
import com.spring.mvc.psi.repository.InventoryRepository;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-jpa-config.xml");
        InventoryRepository ir=ctx.getBean(InventoryRepository.class);
      
         List<Inventory> inventories = ir.findAll();
        System.out.println(inventories);
                
        
        ctx.close();
        
    }
}
