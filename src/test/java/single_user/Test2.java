package single_user;

import com.github.javafaker.Faker;
import com.spring.mvc.single_user.Repository.UserRepository;
import com.spring.mvc.single_user.entities.User;
import java.util.Date;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository ur = ctx.getBean(UserRepository.class);
        Faker faker = new Faker();
        for (int i = 0; i < 168; i++) {
            User user = new User();
            user.setName(faker.name().lastName());
            user.setEmail(faker.internet().emailAddress());
            user.setBirth(faker.date().birthday());
            ur.save(user); //方法結束(Commit)後才存
        }
        //ur.saveAndFlush(user); 及時儲存
       

    }
}
