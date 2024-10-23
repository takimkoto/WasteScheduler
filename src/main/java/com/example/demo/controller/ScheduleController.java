package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/api/schedule")
	public List<Schedule> getSchedule(@RequestParam(required=false) Integer month, Integer year){
		return scheduleService.getSchedule(month, year);
	}
}
