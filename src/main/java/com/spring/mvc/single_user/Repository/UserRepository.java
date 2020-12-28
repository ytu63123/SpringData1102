package com.spring.mvc.single_user.Repository;

import com.spring.mvc.single_user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
只需定義 interface 的規格，實作內容是由 SpringDate實作
<User,Long> -->User 指的是Entity的類別名，Long指的是 @Id 的資料類別
*/
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
    
    
}
