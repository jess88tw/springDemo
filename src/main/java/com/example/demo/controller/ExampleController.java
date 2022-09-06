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

    @PostMapping("/result/search")
    public String resultSearch (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT SEARCH controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        String nameValue = (String) exampleService.searchStaffId(exampleEntity).get("name");
        this.message = "搜尋結果頁";
        this.msg = (idValue == "empty") ? "資料庫裡沒這個值" : "查詢結果";
        model.addAttribute("id", idValue);
        model.addAttribute("name", nameValue);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        return "result";
    }

    @PostMapping("/confirm/create")
    public String confirmCreate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM CREATE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        this.message = (idValue == "empty") ?  "新增確認頁" : "新增結果頁";
        this.msg = (idValue == "empty") ? "確定要新增" : "資料庫裡已有該 ID 值";
        this.path = "/result/create";
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return  (idValue == "empty") ? "confirm" : "result";
    }

    @PostMapping("/result/create")
    public String resultCreate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT CREATE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.addStaff(exampleEntity);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        String nameValue = (String) exampleService.searchStaffId(exampleEntity).get("name");
        this.message = "新增結果頁";
        this.msg = "已新增";
        model.addAttribute("id", idValue);
        model.addAttribute("name", nameValue);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        return "result";
    }


    @PostMapping("/confirm/update")
    public String confirmUpdate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM UPDATE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        String nameValue = (String) exampleService.searchStaffId(exampleEntity).get("name");
        this.message = (idValue == "empty") ?  "更新結果頁" : "確認更新頁";
        this.msg = (idValue == "empty") ? "資料庫裡沒這個值" : "確定要更新";
        this.path = "/result/update";
        model.addAttribute("id", idValue);
        model.addAttribute("name", nameValue);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return  (idValue == "empty") ? "result" : "confirm";
    }

    @PostMapping("/result/update")
    public String resultUpdate (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT UPDATE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.updateStaff(exampleEntity);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        String nameValue = (String) exampleService.searchStaffId(exampleEntity).get("name");
        this.message = "更新結果頁";
        this.msg = "已更新";
        model.addAttribute("id", idValue);
        model.addAttribute("name", nameValue);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        return "result";
    }

    @PostMapping("/confirm/delete")
    public String confirmDelete (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("CONFIRM DELETE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        String idValue = (String) exampleService.searchStaffId(exampleEntity).get("id");
        String nameValue = (String) exampleService.searchStaffId(exampleEntity).get("name");
        this.message = (idValue == "empty") ?  "刪除結果頁" : "確認刪除頁";
        this.msg = (idValue == "empty") ? "資料庫裡沒這個值" : "確定要刪除";
        this.path = "/result/delete";
        model.addAttribute("id", idValue);
        model.addAttribute("name", nameValue);
        model.addAttribute("message", message);
        model.addAttribute("msg", msg);
        model.addAttribute("path", path);
        return  (idValue == "empty") ? "result" : "confirm";
    }

    @PostMapping("/result/delete")
    public String resultDelete (@RequestParam String id, @RequestParam String name, Model model) {
        log.info("RESULT DELETE controller");
        exampleEntity = new ExampleEntity();
        exampleEntity.setId(id);
        exampleEntity.setName(name);
        exampleService.deleteStaff(exampleEntity);
        this.message = "刪除結果頁";
        this.msg = "已刪除";
        model.addAttribute("message", message);
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("msg", msg);
        return "result";
    }
}