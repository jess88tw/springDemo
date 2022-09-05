package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ExampleEntity;

@Repository
public class ExampleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStaff (ExampleEntity exampleEntity) {
        jdbcTemplate.update("INSERT INTO members(id, name) "
                + "VALUES (?,?);", exampleEntity.getId(), exampleEntity.getName());
    }

    public List<?> searchStaff (ExampleEntity exampleEntity) {
        List<?> rows = jdbcTemplate.queryForList("SELECT id, name FROM members "
                + "WHERE id = (?);", exampleEntity.getId());
        return rows;
    }

    public void updateStaff (ExampleEntity exampleEntity) {
        jdbcTemplate.update("UPDATE `members` SET `name` = (?) "
                + "WHERE `id` = (?);", exampleEntity.getName(), exampleEntity.getId());
    }

    public void deleteStaff (ExampleEntity exampleEntity) {
        jdbcTemplate.update("DELETE FROM members "
                + "WHERE id = (?);", exampleEntity.getId());
    }
}
