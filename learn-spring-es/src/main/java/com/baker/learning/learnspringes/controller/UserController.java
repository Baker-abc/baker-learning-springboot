package com.baker.learning.learnspringes.controller;

import com.baker.learning.learnspringes.model.UserDO;
import com.baker.learning.learnspringes.repository.UserRepository;
import com.baker.learning.learnspringes.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @date 2020/4/27 17:19
 */

@RestController
@Slf4j
@Api(value = "/design", description = "design")
@RequestMapping(path = "/design", produces = {"application/json"})
public class UserController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "查询", httpMethod = "GET", response = Object.class)
    public Object get(@RequestParam(name = "name", defaultValue = "") String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询", httpMethod = "GET", response = Object.class)
    public Object get(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/age/agg")
    @ApiOperation(value = "按照年龄分组查询，只查询名称包含的", httpMethod = "GET", response = Object.class)
    public Object getAgeAgg(@RequestParam(name = "name", defaultValue = "") String name) {
        return userService.group(name);
    }

    @PostMapping("/")
    @ApiOperation(value = "新增", httpMethod = "POST", response = Object.class)
    public Object save(@RequestBody UserDO userDO) {
        return userRepository.save(userDO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除", httpMethod = "DELETE", response = Object.class)
    public Object delete(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "ok";
    }

    @PutMapping("/")
    @ApiOperation(value = "更改", httpMethod = "PUT", response = Object.class)
    public Object update(@RequestBody UserDO userDO) {
        return userRepository.save(userDO);
    }

}
