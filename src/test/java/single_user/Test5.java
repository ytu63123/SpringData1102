package single_user;

import com.spring.mvc.single_user.Repository.UserRepository;
import com.spring.mvc.single_user.Repository.UserViewRepository;
import com.spring.mvc.single_user.entities.User;
import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
   
    @Test
    public void t1(){
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserViewRepository uvr=ctx.getBean(UserViewRepository.class);
        System.out.println(uvr.findAll());
        
    }
}
