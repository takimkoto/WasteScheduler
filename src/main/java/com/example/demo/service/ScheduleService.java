package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ScheduleMapper;
import com.example.demo.model.Schedule;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleMapper scheduleMapper;
	
	public List<Schedule> getSchedule(int month, int year){
		return scheduleMapper.getSchedule(month, year);
	}
}
