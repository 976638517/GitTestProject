package com.example.gittest.controller;

import com.example.gittest.bean.UserVo;
import com.example.gittest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {


        @Autowired
        private UserService userService;

        @RequestMapping(value = "/useradd", method = RequestMethod.POST)
        public boolean addUser( UserVo userVo) {
            System.out.println("开始新增...");
            return userService.addUser(userVo);
        }

        @RequestMapping(value = "/userupdate", method = RequestMethod.PUT)
        public boolean updateUser( UserVo userVo) {
            System.out.println("开始更新...");
            return userService.updateUser(userVo);
        }

        @RequestMapping(value = "/userdelete", method = RequestMethod.POST)
        public boolean delete(@RequestParam(value = "id", required = true) int id) {
            System.out.println("开始删除...");
            return userService.deleteUser(id);
        }

        @RequestMapping(value = "/userfindbyid", method = RequestMethod.GET)
        public UserVo findByUserName(@RequestParam(value = "userName", required = true) String userName) {
            System.out.println("开始查询...");
            return userService.findUserByName(userName);
        }

        @RequestMapping(value = "/userAll", method = RequestMethod.GET)
        public List<UserVo> findByUserAge() {
            System.out.println("开始查询所有数据...");
            return userService.findAll();
        }

        @RequestMapping(value = "/test", method = RequestMethod.GET)
        public void test() {
            System.out.println("----------------test-------------------");
        }

}
