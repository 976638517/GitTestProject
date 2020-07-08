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

//        @RequestMapping(value = "/useradd", method = RequestMethod.POST)
//        public boolean addUser( UserVo userVo) {
//            System.out.println("开始新增...");
//            return userService.addUser(userVo);
//        }
//
//        @RequestMapping(value = "/userupdate", method = RequestMethod.PUT)
//        public boolean updateUser( UserVo userVo) {
//            System.out.println("开始更新...");
//            return userService.updateUser(userVo);
//        }
//
//        @RequestMapping(value = "/userdelete", method = RequestMethod.POST)
//        public boolean delete(@RequestParam(value = "id", required = true) int id) {
//            System.out.println("开始删除...");
//            return userService.deleteUser(id);
//        }
//
//        @RequestMapping(value = "/userfindbyid", method = RequestMethod.GET)
//        public UserVo findByUserName(@RequestParam(value = "userName", required = true) String userName) {
//            System.out.println("开始查询...");
//            UserVo userVo = userService.findUserByName(userName);
//            return userVo;
//        }
//
//        @RequestMapping(value = "/userAll", method = RequestMethod.GET)
//        public List<UserVo> findByUserAge() {
//            System.out.println("开始查询所有数据...");
//            return userService.findAll();
//        }
//
//        @RequestMapping(value = "/test", method = RequestMethod.GET)
//        public void test() {
//            System.out.println("----------------test-------------------");
//        }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List findAll() {
        System.out.println("findAll");
        return userService.findAll();
    }

    @RequestMapping(value = "/findUserByAgeMaapper", method = RequestMethod.GET)
    public List findUserByAgeMaapper(int age) {
        System.out.println("findUserByAgeMaapper");
        return userService.findUserByAgeMaapper(age);
    }

    @RequestMapping(value = "/findUserByIdMaapper", method = RequestMethod.GET)
    public List findUserByIdMaapper(int id) {
        System.out.println("findUserByIdMaapper");
        return userService.findUserByIdMaapper(id);
    }
    @RequestMapping(value = "/findUserByNameMaapper", method = RequestMethod.GET)
    public List findUserByNameMaapper(String name){
        System.out.println("findUserByNameMaapper");
        return userService.findUserByNameMaapper(name);
    }

    @RequestMapping(value = "/addUserMapper", method = RequestMethod.GET)
    public Boolean addUserMapper(UserVo userVo){
        System.out.println("addUserMapper");
        return userService.addUserMapper(userVo);
    }
    @RequestMapping(value = "/deleteUserMapper", method = RequestMethod.GET)
    public Boolean deleteUserMapper(UserVo userVo){
        System.out.println("deleteUserMapper");
        return userService.deleteUserMapper(userVo);
    }
    @RequestMapping(value = "/updataUserMapper", method = RequestMethod.GET)
    public Boolean updataUserMapper(UserVo userVo){
        System.out.println("updataUserMapper");
        return userService.updataUserMapper(userVo);
    }


}
