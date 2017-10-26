package com.yuntu.infrastructure.session.core.dao;



import com.yuntu.infrastructure.session.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * Created by jackdeng on 17/8/4.
 */
@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {


    /**
     * user login check
     * @param username
     * @param password
     * @return
     */
    Integer countByUserNameAndPassword(String username,String password);
    UserEntity findByUserNameAndPassword(String username,String password);
}
