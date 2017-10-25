package com.yuntu.infrastructure.session.core.dao;



import com.yuntu.infrastructure.session.core.entity.MarketingActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 营销活动定义
 * Created by jackdeng on 17/8/4.
 */
@Repository
public interface MarketingActivityDao extends JpaRepository<MarketingActivityEntity, Long> {


}
