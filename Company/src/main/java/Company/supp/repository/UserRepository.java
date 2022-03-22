/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.supp.repository;

import Company.supp.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author odi
 */
@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
    
    //@Query("SELECT u FROM User u WHERE u.email = :email")
    public User findByEmail (String name);
    
}
