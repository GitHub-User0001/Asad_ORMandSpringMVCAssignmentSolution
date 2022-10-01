package com.crm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listBooks(Model model) {
		System.out.println("request recieved");
		List<Customer> customers = customerService.findAllCustomer();
		model.addAttribute("Customers", customers);
		return "list-Customers";
	}
	
	
	
	@PostMapping("/save")
	public String saveOrUpdate(Customer customer) {
		System.out.println("inserting...");
		System.out.println(customer);
		Customer savedcustomer=null;
		System.out.println(customer);
		if(customer.getId()!=0) {
			savedcustomer=customerService.findCustomerById(customer.getId());	
			savedcustomer.setFirstName(customer.getFirstName());
			savedcustomer.setLastName(customer.getLastName());
			savedcustomer.setEmail(customer.getEmail());
		}
		else
			savedcustomer= customer;
			
		this.customerService.saveOrupdate(savedcustomer);
		return "redirect:/customer/list";
	}
    @GetMapping("/{id}")
    
    public String delete(@PathVariable int id) 
    {
	this.customerService.delete(id);
	return "redirect:/customer/list";
    }

    @GetMapping("/add")
    
    public String add(Model model) {
	model.addAttribute("customer", new Customer());
	return "customerform";
    }

    @GetMapping("/update/{id}")
    
    public String update(Model model,@PathVariable int id) {
	Customer customer= this.customerService.findCustomerById(id);
	model.addAttribute(customer);
	return "customerform";
	}
    
    
   
}



