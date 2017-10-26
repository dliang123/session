package com.yuntu.infrastructure.session.core.dao;



import com.yuntu.infrastructure.session.core.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "select * from user where username =?1 order by userid desc /* #pageable# */ ",countQuery = "select count(*) from user where username =?1",nativeQuery = true)
    Page<UserEntity>  findByUsername(String username, Pageable pageable);
}
