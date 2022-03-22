/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.supp.repository;

import Company.supp.entity.Supplier;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author odi
 */
@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Integer>{
    public List<Supplier> findByCompanyName(String companyName);
     
}