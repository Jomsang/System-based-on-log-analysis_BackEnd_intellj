package com.example.demo.mapper;

import com.example.demo.model.UserMb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserMb> findAll();
}
