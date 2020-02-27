package com.maxim.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxim.spring.entity.Customer;
import com.maxim.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

//	// inject DAO
//	@Autowired
//	private CustomerDAO customerDAO;
	
	// inject customerSERVICE
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustumer(Model theModel) {
		
		// get the customers from DAO and add them to mvc model
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		theModel.addAttribute("customers",theCustomers);
		
		return "customers-list";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
