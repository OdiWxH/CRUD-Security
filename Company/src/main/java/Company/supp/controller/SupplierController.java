/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.supp.controller;

import Company.supp.entity.Supplier;
import Company.supp.repository.SupplierRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author odi
 */
@Controller
@RequestMapping("/suppliers/")
@ComponentScan(basePackages = "Company.supp.repository")
public class SupplierController {
    
       
    private SupplierRepository supplierRepository;
    
    @Autowired 
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    
     //show supplier form
    @GetMapping("signup")
    public String showSignUpForm(Supplier supplier){
         return  "add-supplier";   
    }
    
    //ALL Suppliers
    @GetMapping("list")
    public String showUpdateForm(Model model){
        model.addAttribute("suppliers", this.supplierRepository.findAll());
        return "index";
    }
    
    //ADD
    @PostMapping("add")
    public String addSupplier (@Valid Supplier supplier, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-supplier";
        } 
        this.supplierRepository.save(supplier);
        return "redirect:list";
    }
    
    //EDIT UPDATE
    @GetMapping("edit/{id}")
    public String showupdateForm(@PathVariable("id") int id, Model model){
        Supplier supplier = this.supplierRepository.findById(id)
                          .orElseThrow(() -> new IllegalArgumentException("Wrong Supplier ID: - " + id));
        
        model.addAttribute("supplier", supplier);
        return "update-supplier";
    
    }
    
    //UPDATE
    @GetMapping("update/{id}")
    public String updateSupplier (@PathVariable("id") int id,@Valid Supplier supplier, BindingResult result, Model model){
        if(result.hasErrors()){
           supplier.setId(id);
           return "update-supplier";
        }
        supplierRepository.save(supplier);
        model.addAttribute("suppliers", this.supplierRepository.findAll());
        return "index";
    }
    
     @GetMapping("delete/{id}")
    public String deleteSupplier(@PathVariable("id") int id, Model model){
        Supplier supplier = this.supplierRepository.findById(id)
                          .orElseThrow(() -> new IllegalArgumentException("Wrong Supplier ID: - " + id));

        this.supplierRepository.delete(supplier);
        model.addAttribute("suppliers", this.supplierRepository.findAll());
        return "index";
    }
}
