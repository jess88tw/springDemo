# spring_demo
### 本專案任務
* 必須包含頁面 { 輸入、確認、結果 }
* DB沒有限制
* CRUD
* 提交 github 檢查

### 使用 Spring Initializr 建立 Maven Project
先到 https://start.spring.io/ 建立 Maven 專案

![image](https://github.com/jess88tw/spring_demo/blob/master/src/main/resources/static/picture/spring%20initiailiz.png)

* 本次會使用 JAVA 11.
* 使用 MySQL 作為 DB
* 為了日後其他功能, 使用 JSP

![image](https://github.com/jess88tw/spring_demo/blob/master/src/main/resources/static/picture/controller%20design.jpeg)
### 在 MySQL 建立 Database 與 Table
```
CREATE DATABASE spring_homework;

USE spring_homework;
CREATE TABLE `members`(
`id` VARCHAR(10),
`name` VARCHAR(10)
);
```

### 修改 pom.xml   
若要增加套件可以到 pom.xml 增加 dependencies, 可以參考本專案如
```
<!-- For DataBase connection -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- For DataBase connection -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```
增加 dependencies 後要記得更新專案, 會幫你重建需要的 plugins

### 修改 application.properties
可以在 application.properties 增加連線資料與其他屬性如
```
# For MySQL connection
spring.datasource.url=jdbc:mysql://localhost:3306/YOURDATABASE?serverTimezone=UTC&useSSL=false
spring.datasource.username=YOURNAME
spring.datasource.password=YOURPASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.servlet.encoding.force=true

spring.main.allow-bean-definition-overriding=true

#JSP
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

### 建立 Model(entity) package 並建立 .java
這邊設定你的 getter, setter
```
@Component
public class ExampleEntity {

    private String id;
    private String name;

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
```
這邊也可以使用 lombok 簡化, 但為了熟悉流程, 這邊暫時先不帶入

### 建立 Repository(dao) package 並建立 .java
Repository 負責與數據庫溝通，運用 SQL 語言來操作 CRUD
```
@Repository
public class ExampleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStaff (ExampleEntity exampleEntity) {
        String sql = "INSERT INTO members(id, name) VALUES (?,?);";
        jdbcTemplate.update(sql, exampleEntity.getId(), exampleEntity.getName());
    }
}
```
通常為了防止 SQL injection 我們會使用 PreparedStatement, 但這邊使用的 JdbcTemplate 有內建, 主要有四個類別
* execute
  * 操作資料表相關的 SQL (create, drop…)
* update/ batchUpdate
  * 資料的新增、修改、刪除
* query/ queryForXXX
  * 查詢資料
* call
  * Stored Procedure

### 建立 Service package 並建立 .java
Service 負責呼叫各種 CRUD 的指令
```
@Service
public class ExampleService {

    @Autowired
    ExampleDao exampleDao;

    public void addStaff(ExampleEntity exampleEntity){
        exampleDao.addStaff(exampleEntity);
    }
}
```

### 建立 Controller package 並建立 .java
Controller 負責 mapping, url 找到 mapping 就會執行
```
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
}
```
return "result" 會將頁面導向 result.jsp

### 修改 DemoApplication
把所有相關的 package 都加入
* @ComponentScan
* @EntityScan

目的是讓系統去檢查各個 package 的檔案
```
@SpringBootApplication
@ComponentScan({"com.example.demo","com.example.demo.controller","com.example.demo.dao","com.example.demo.entity","com.example.demo.service"})
@EntityScan({"com.example.demo","com.example.demo.controller","com.example.demo.dao","com.example.demo.entity","com.example.demo.service"})
public class DemoApplication extends SpringBootServletInitializer {    
    
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

### 執行 DemoApplication
最後執行 DemoApplication 就成功了!!!

![image](https://github.com/jess88tw/spring_demo/blob/master/src/main/resources/static/picture/view.png)



