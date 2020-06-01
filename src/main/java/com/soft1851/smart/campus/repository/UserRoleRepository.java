package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserRoleRepository
 * @Description TODO
 * @date 2020-06-01 14:08
 **/
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    
}
