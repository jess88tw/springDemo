package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExampleEntity;

@Repository
public class ExampleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStaff (ExampleEntity exampleEntity) {
        String sql = "INSERT INTO members(id, name) VALUES (?,?);";
        jdbcTemplate.update(sql, exampleEntity.getId(), exampleEntity.getName());
    }

    public List<Map<String, Object>> searchStaff (ExampleEntity exampleEntity) {
        String sql = "SELECT id, name FROM members WHERE id = (?);";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, exampleEntity.getId());
        if (rows.isEmpty()) {
            Map<String, Object> emptyMap = new HashMap<>();
            emptyMap.put("id", "empty");
            emptyMap.put("name", "empty");
            rows.add(emptyMap);
        }
        return rows;
    }

    public void updateStaff (ExampleEntity exampleEntity) {
        String sql = "UPDATE members SET name = (?) WHERE id = (?);";
        jdbcTemplate.update(sql, exampleEntity.getName(), exampleEntity.getId());
    }

    public void deleteStaff (ExampleEntity exampleEntity) {
        String sql = "DELETE FROM members WHERE id = (?);";
        jdbcTemplate.update(sql, exampleEntity.getId());
    }
}
