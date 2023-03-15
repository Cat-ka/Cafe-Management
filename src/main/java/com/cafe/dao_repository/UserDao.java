package com.cafe.dao_repository;

import com.cafe.POJO.User;
import com.cafe.wrapper.UserWrapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    //atribúty sú trieda s ktorou pracujeme a primary key, preto User a Integer

    //pre všetky tieto metódy som vytvárala v triede User @NamedQuery

    User findByEmailId(@Param("email") String email);

    List<UserWrapper> getAllUser();

    List<String> getAllAdmin();

    @Transactional
    @Modifying
    Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
    //bez týchto dvoch anotácii túto metódu nemôžem použiť a spadlo by mi to do výnimky

    User findByEmail(String email);
    //malo by to byť implementované, takže to nemusíme implementovať

}
