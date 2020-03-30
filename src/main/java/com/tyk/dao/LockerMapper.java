package com.tyk.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: tyk
 * @Date: 2020/3/24 13:41
 * @Description:
 */
@Repository
public interface LockerMapper {
    void getLock(@Param("key") String key,@Param("timeout") long timeout);

    void releaseLock(String key);
}
