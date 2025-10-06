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

import com.ecommerce.wh.entity.ShipmentType;
import com.ecommerce.wh.service.IShipmentTypeService;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	
	@Autowired
	IShipmentTypeService shipmentTypeService;
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdate(@PathVariable Integer id, Model model){
		ShipmentType shipmentType=null;
		String viewName=null;
		
		if(shipmentTypeService.isShipmentTypeExist(id)) {
		 shipmentType=shipmentTypeService.getOneShipmentType(id);
		 viewName="updateShipmenttype";
		}else {
			viewName="redirect:../all";
		}
		model.addAttribute("shipmentType", shipmentType);
		return viewName;
	}

	@PostMapping(path="/save")
	public String saveRegistrationData(@ModelAttribute ShipmentType shipmentType, Model model) {
		int shipmentId=shipmentTypeService.saveShipmentType(shipmentType);
		String msg="Shipment Type Registration created with Shipment id "+shipmentId;
		model.addAttribute("shipmentMsg",msg);
		return "ShipmentTypeRegister";
	}
	
	@GetMapping(path="/all")
	public String showAllShipmentTypes(Model model) {
		List<ShipmentType> shipmentTypes=shipmentTypeService.findAllShipmentType();
		model.addAttribute("shipmentTypes",shipmentTypes);
		return "AllShipment";
	}
	
	@GetMapping("/delete/{id}")
	public String removeShipmentType(@PathVariable int  id,Model model) {
		String msg=null;
		if(shipmentTypeService.isShipmentTypeExist(id)) {
		shipmentTypeService.deleteShipmentType(id);
		 msg="Shipment type having shipment id : "+id+" has been deleted";
		}else {
			msg="Shipment type havind shipment id :"+id+" not Exist.";
		}
		model.addAttribute("msg", msg);
		
		List<ShipmentType> shipmentTypes=shipmentTypeService.findAllShipmentType();
		model.addAttribute("shipmentTypes",shipmentTypes);
		
		return "AllShipment";
		
	}
	
	@PostMapping("/update")
	public String modifyShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		
			shipmentTypeService.updateShipmentType(shipmentType);
			String msg="Shipment-Type id : "+shipmentType.getShipmentId()+" has been updated. ";
			model.addAttribute("msg", msg);
			
			List<ShipmentType> shipmentTypes=shipmentTypeService.findAllShipmentType();
			model.addAttribute("shipmentTypes",shipmentTypes);
			
			return "AllShipment";
		
	}
	
}
