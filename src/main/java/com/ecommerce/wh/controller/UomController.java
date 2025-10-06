package com.ecommerce.wh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.wh.entity.Uom;
import com.ecommerce.wh.service.IuomService;

@Controller
@RequestMapping(path = "/uom")
public class UomController {
	
	@Autowired
	IuomService service;
	
	@GetMapping(path = "/register")
	public String showUom() {
		return "UomRegistration";
	}
	
	
	@PostMapping(path="/uom-save")
	public String uomSave(@ModelAttribute Uom uom, Model model) {
		int id=service.saveUom(uom);
		String msg="UOM Registration completed with UOM-ID : "+id;
		model.addAttribute("uomMsg", msg);
		return "UomRegistration";
	}
	
	@GetMapping("/all")
	public String showAllUom(Model model) {
		List<Uom> Uoms=service.findAllUom();
		model.addAttribute("UomData", Uoms);
		return "AllUomData";
	}
	
	@GetMapping("/delete/{id}")
	public String removeUom(@PathVariable int id, Model model) {
		String pageMessage="";
		if(service.isUomExist(id)) {
			service.deleteUom(id);
			pageMessage="Uom id : "+id+" has been Deleted.";
			
		}else {
			pageMessage="Uom id : "+id+" doesn't Exist.";
		}
		
		model.addAttribute("msg",pageMessage);
		
		return "AllUomData";
	}

}
