package single_user;

import com.spring.mvc.single_user.Repository.UserRepository;
import com.spring.mvc.single_user.entities.User;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    
    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository ur = ctx.getBean(UserRepository.class);
        //查詢多筆
        List<User> users = ur.findAll();
        System.out.println(users);
        //查詢單筆
        User user = ur.findOne(1L);
        System.out.println(user);
        //修改
//        user.setName("Antina");
//        ur.saveAndFlush(user);
//        user = ur.findOne(1L);
//        System.out.println(user);
        //刪除最後一筆(id=169)
      //  ur.delete(169L);
    }
}
