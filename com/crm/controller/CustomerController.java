package com.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entity.Customer;
import com.crm.service.CustomerService;
@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String findAllCustomer(Model theModel) {
		List<Customer> customers= customerService.findAllCustomer();
		theModel.addAttribute("customer", customers);
		return "customerlist";
	}
	
	@PostMapping("/save")//
	public String saveOrUpdate(@ModelAttribute("customer") Customer theCustomer) {
		System.out.println("inserting...");
		System.out.println(theCustomer);
		Customer savedcustomer=null;
		System.out.println(theCustomer);
		if(theCustomer.getId()!=0) {
			savedcustomer=customerService.findCustomerById(theCustomer.getId());	
			savedcustomer.setFirstName(theCustomer.getFirstName());
			savedcustomer.setLastName(theCustomer.getLastName());
			savedcustomer.setEmail(theCustomer.getEmail());
		}
		else
			savedcustomer= theCustomer;
			
		this.customerService.saveOrUpdate(savedcustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) 
	{
		this.customerService.delete(theId);
		return "redirect:/customer/list";
	}

	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new Customer());
		return "customerform";
	}
	
	@GetMapping("/update")
	public String update(Model model,@RequestParam("customerId") int theId) {
		Customer customer= this.customerService.findCustomerById(theId);
		model.addAttribute("customer",customer);
		return "customerform";
		
		
	}

}
