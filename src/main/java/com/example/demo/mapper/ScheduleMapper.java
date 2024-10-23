package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Schedule;

@Mapper
public interface ScheduleMapper {

	List<Schedule> getSchedule(int month, int year);
}
