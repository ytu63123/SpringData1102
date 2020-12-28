package single_user;

import com.spring.mvc.single_user.Repository.UserRepository;
import com.spring.mvc.single_user.entities.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

    @Test
    public void t1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springMVC-servlet.xml");
        UserRepository ur = ctx.getBean(UserRepository.class);

        User user = ur.getByName("Antina");
        System.out.println(user);

        List<User> users = ur.getByNameStartingWithAndIdLessThan("Sc", 100L);
        System.out.println(users);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            users = ur.getByIdInOrBirthLessThanEqual(Arrays.asList(2L, 4L, 8L, 16L), sdf.parse("2000-12-31"));
            System.out.println(users);
        } catch (ParseException ex) {
            System.out.println("Date Error !");
        }

        users = ur.getByAgeLessThan(20);
        System.out.println(users);

        Long totalCount=ur.getTotalCount();
        System.out.println(totalCount);
    }
}
