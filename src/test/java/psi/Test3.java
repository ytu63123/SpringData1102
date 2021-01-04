package psi;

import com.spring.mvc.psi.entities.Inventory;
import com.spring.mvc.psi.entities.Inventory2;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.InventoryRepository2;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springdata-jpa-config.xml");
        InventoryRepository2 ir=ctx.getBean(InventoryRepository2.class);
      
         List<Inventory2> inventories = ir.findAll();
        System.out.println(inventories);
                
        
        ctx.close();
        
    }
}
