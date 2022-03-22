/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.supp.repository;

import Company.supp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author odi
 */
@Repository
public interface RoleRepository extends JpaRepository <Role, Integer>{
    //public Role getRoleByRoleName (String name);
    
}
