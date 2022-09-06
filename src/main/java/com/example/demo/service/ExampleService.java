package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ExampleDao;
import com.example.demo.entity.ExampleEntity;

@Service
public class ExampleService {

    @Autowired
    ExampleDao exampleDao;

    public void addStaff(ExampleEntity exampleEntity){
        exampleDao.addStaff(exampleEntity);
    }

    public Map<?,?> searchStaffId(ExampleEntity exampleEntity){
        Map<?,?> userMap = (Map<?,?>) exampleDao.searchStaffId(exampleEntity).get(0);
        return userMap;
    }

    public void updateStaff(ExampleEntity exampleEntity){
        exampleDao.updateStaff(exampleEntity);
    }

    public void deleteStaff(ExampleEntity exampleEntity){
        exampleDao.deleteStaff(exampleEntity);
    }

//    public Map<?,?> searchStaffNames(ExampleEntity exampleEntity){
//        Map<?,?> userMap = (Map<?,?>) exampleDao.searchStaffNames(exampleEntity);
//        System.out.println(userMap);
//        return userMap;
//    }
}
