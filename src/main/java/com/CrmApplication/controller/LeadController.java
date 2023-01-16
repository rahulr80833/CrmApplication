package com.CrmApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CrmApplication.entities.Contact;
import com.CrmApplication.entities.Lead;
import com.CrmApplication.service.ContactService;
import com.CrmApplication.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/")
	public String ViewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		
		contactService.saveContact(contact);
		
		leadService.deleteOneLeadById(id);
		List<Contact> contacts = contactService.listContacts();
		model.addAttribute("contacts", contacts);
		return "search_contact_result";
	}
	
	@RequestMapping("/listall")
	public String listAlleads(ModelMap model ) {
		List <Lead> leads = leadService.listLeads();
		model.addAttribute("leads", leads);
		return "search_lead_result";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id, ModelMap model) {
		Lead lead = leadService.getOneLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}

}
