package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Waste;
import com.example.demo.service.WasteService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class WasteController {

	@Autowired
	private WasteService wasteService;
	
	@GetMapping("/api/waste")
	public String getWastInfo() {
		return "ゴミ情報を取得しました";
	}
	
	@GetMapping("/api/waste-types")
	public List<Waste> getAllfind(){
		return wasteService.getAllfind();
	}
	
	
}
