package com.example.demo.controller;

import com.example.demo.entity.ExampleEntity;
import com.example.demo.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/example")
@Slf4j
public class ExampleController {

    @Autowired
    ExampleEntity exampleEntity;

    @Autowired
    ExampleService exampleService;

    private String message = "current page";
    private String msg = "depiction";
    private String path = "to where";

    @GetMapping("/home")
    public String home (Model model) {
        log.info("HOME controller");
        this.message = "輸入頁";
        model.addAttribute("message", message);
        return "home";
    }

    @PostMapping("/confirm/create")
    public String confirmCreate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM CREATE controller");
        this.message = "新增確認頁";
        this.msg = "確定要新增";
        this.path = "/result/create";
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return "confirm";
    }

    @PostMapping("/result/create")
    public String resultCreate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT CREATE controller");
        this.message = "新增結果頁";
        this.msg = "已新增";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.addStaff(exampleEntity);
        model.addAttribute("message", message);
        model.addAttribute("id", exampleService.searchStaff(exampleEntity).get("id"));
        model.addAttribute("name", exampleService.searchStaff(exampleEntity).get("name"));
        model.addAttribute("msg", msg);
        return "result";
    }

    @PostMapping("/result/search")
    public String resultSearch (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT SEARCH controller");
        this.message = "搜尋結果頁";
        this.msg = "查詢結果";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        model.addAttribute("message", message);
        model.addAttribute("id", exampleService.searchStaff(exampleEntity).get("id"));
        model.addAttribute("name", exampleService.searchStaff(exampleEntity).get("name"));
        model.addAttribute("msg", msg);
        return "result";
    }

    @PostMapping("/confirm/update")
    public String confirmUpdate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM UPDATE controller");
        this.message = "確認更新頁";
        this.msg = "確定要更新";
        this.path = "/result/update";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        model.addAttribute("message", message);
        model.addAttribute("id", exampleService.searchStaff(exampleEntity).get("id"));
        model.addAttribute("name", exampleService.searchStaff(exampleEntity).get("name"));
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return "confirm";
    }

    @PostMapping("/result/update")
    public String resultUpdate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT UPDATE controller");
        this.message = "更新結果頁";
        this.msg = "已更新";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.updateStaff(exampleEntity);
        model.addAttribute("message", message);
        model.addAttribute("id", exampleService.searchStaff(exampleEntity).get("id"));
        model.addAttribute("name", exampleService.searchStaff(exampleEntity).get("name"));
        model.addAttribute("msg", msg);
        return "result";
    }

    @PostMapping("/confirm/delete")
    public String confirmDelete (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM DELETE controller");
        this.message = "確認刪除頁";
        this.msg = "確定要刪除";
        this.path = "/result/delete";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        model.addAttribute("message", message);
        model.addAttribute("id", exampleService.searchStaff(exampleEntity).get("id"));
        model.addAttribute("name", exampleService.searchStaff(exampleEntity).get("name"));
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return "confirm";
    }

    @PostMapping("/result/delete")
    public String resultDelete (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT DELETE controller");
        this.message = "刪除結果頁";
        this.msg = "已刪除";
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.deleteStaff(exampleEntity);
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("msg", msg);
        return "result";
    }
}