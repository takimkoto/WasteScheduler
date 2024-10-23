package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Waste;

@Mapper
public interface WasteMapper {

	@Select("Select * From waste_types")
	List<Waste> findAll();
}
