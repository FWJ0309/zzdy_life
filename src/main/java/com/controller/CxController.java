package com.controller;

import com.Service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Mission;
import com.entity.Sys_user_name;
import com.entity.User;
//import com.util.FileUtil;
import com.util.FileUtil;
import com.util.Msg;
//import com.util.PropUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class CxController {


    @Autowired
    private UserService userService;

    /**
     * @apiVersion 0.0.1
     * @api {post} /login
     * @apiName 登录方法接口
     * @apiGroup 1.2登录界面
     * @apiParam {String} phone 注册时的手机号
     * @apiParam {String} password 密码
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     *     "code": 100,
     *     "msg": "处理成功",
     *     "extend": {
     *         "user": {
     *             "id": 1,
     *             "username": "阿鑫",
     *             "password": "1234",     用户密码
     *             "phone": "15617105157",  注册时手机号
     *             "email": "784717017@qq",  邮箱
     *             "nickname": "阿鑫",   用户名
     *             "sex": "1",   性别
     *             "age": 18,    年龄
     *             "headImg": "",      头像图片路劲
     *             "profession": "电工",   职业(多职业用逗号隔开)
     *             "realName": "0",    是否实名  0未认证1已认证
     *             "realEnterprise": "0",  是否企业认证
     *             "realElectro": "0",   是否用电信息认证
     *             "realOccupation": "0",   是否职业认证(职业)
     *             "beginTime": "2019-12-14T00:43:17.000+0000",   字段创建时间
     *             "updateTime": "2019-12-17T07:29:20.000+0000",    字段更改时间
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {
     * "msg": "密码错误"  or "该手机话未注册"
     * }
     * }
     */
    @PostMapping("/login")
    public Msg login(String phone, String password) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return Msg.success().add("user",user);
            } else {
                return Msg.fail().add("msg", "密码错误");
            }
        } else {
            return Msg.fail().add("msg", "该手机话未注册");
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /updatePwd
     * @apiName 修改密码接口
     * @apiGroup 1.3忘记密码
     * @apiParam {String} phone 注册时的手机号
     * @apiParam {String} password  密码，前端需要自己检测两个输入密码相同
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "修改成功",
     * "extend": {}
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {
     * "msg": "该手机话未注册"
     * }
     * }
     */
    @PostMapping("/updatePwd")
    public Msg updatePassword(String phone, String password) {
        User user = userService.getUserByPhone(phone);
        user.setPassword(password);
        user.setUpdateTime(new Date());
        if (user != null) {
            userService.updateUser(user);
            return Msg.success().add("msg", "修改成功");
        } else {
            return Msg.fail().add("msg", "该手机号未注册");
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /adduser
     * @apiName 新增用户接口
     * @apiGroup 1.4注册
     * @apiParam {String} phone 注册时的手机号，后端检测唯一
     * @apiParam {String} password  密码，前端需要自己检测两个输入密码相同
     * @apiParam {String} nickname 昵称
     * @apiParam {String} email 邮箱  前端需要检查邮箱格式
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {}
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "该手机号已注册",
     * "extend": {}
     * }
     */
    @PostMapping("/adduser")
    public Msg addUser(String phone, String password, String nickname, String email) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            return Msg.fail().add("msg", "该手机号已注册");
        } else {
            User user1 = new User();
            user1.setPassword(password);
            user1.setEmail(email);
            user1.setPhone(phone);
            user1.setNickname(nickname);
            user1.setBeginTime(getDate());
            userService.add(user1);
            return Msg.success().add("msg", "注册成功");
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /onlyPhone
     * @apiName 注册页面检测手机号是否唯一
     * @apiGroup 1.41注册检测手机号是否唯一
     * @apiParam {String} phone 注册时的手机号，后端检测唯一
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     * "msg": "该手机号可以使用"
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {
     * "msg": "该手机号已注册"
     * }
     * }
     */
    @PostMapping("/onlyPhone")
    public Msg onlyPhone(String phone) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            return Msg.fail().add("msg", "该手机号已注册");
        } else {
            return Msg.success().add("msg", "该手机号可以使用");
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /getmission
     * @apiName 获取服务接口
     * @apiGroup 3服务列表
     * @apiParam {int} pageNo 当前页
     * @apiParam {int} pageSize 一页显示个数
     * @apiParam {String} type  0个人1企业
     * @apiParam {String} standby2 为空字符串默认查所有；0电力服务1水力服务
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     * "list": {
     * "records": [
     * {
     * "id": 4,
     * "userId": 1,
     * "area": null,
     * "address": "信阳市高新区XXXXX",
     * "longitude": null,
     * "latitude": null,
     * "sort": 0,
     * "title": "水管破损",
     * "describel": "家里水管爆了速来",
     * "img": null,
     * "contact": null,
     * "orderId": 0,
     * "evaluate": null,
     * "state": "0",
     * "beginTime": "2019-12-17T06:41:25.000+0000",
     * "updateTime": null,
     * "isNot":"",
     * "standby1": "0",
     * "standby2": "水力服务",
     * "standby3": "2019-12-15",
     * "cphone": null
     * }
     * ],
     * "total": 0,
     * "size": 5,
     * "current": 1,
     * "searchCount": true,
     * "pages": 0
     * }
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/getmission")
    public Msg getMission(int pageNo, int pageSize, String type, String standby2) {
        try {
            if (!standby2.isEmpty()) {
                IPage<Mission> list = userService.getMissionList(pageNo, pageSize, type, standby2);
                return Msg.success().add("list", list);
            } else {
                IPage<Mission> list = userService.getMissionList2(pageNo, pageSize, type);
                return Msg.success().add("list", list);
            }
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /getmissionbyid
     * @apiName 查看工作详情 个人和企业详情为同一个接口
     * @apiGroup 3.3服务详情
     * @apiParam {int} id 工单任务id
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     * "list": {
     * "id": 2,
     * "userId": 1,
     * "area": null,
     * "address": "信阳市高新区XXXXX",
     * "longitude": null,
     * "latitude": null,
     * "sort": 0,
     * "title": "电灯坏了",
     * "describel": "家里电网莫名坏了",
     * "img": null,
     * "contact": null,
     * "orderId": 0,
     * "evaluate": null,
     * "state": "0",
     * "beginTime": "2019-12-17T06:39:37.000+0000",
     * "updateTime": null,
     * "isNot":"",
     * "standby1": "0",
     * "standby2": "电力服务",
     * "standby3": "2019-12-15",
     * "cphone": null
     * }
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/getmissionbyid")
    public Msg getMissionById(int id) {
        try {
            Mission mission = userService.getMissionById(id);
            return Msg.success().add("list", mission);
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /addmission
     * @apiName 个人任务发布
     * @apiGroup 5.7个人任务发布
     * @apiParam {String} title 工作名称 前端限制字数
     * @apiParam {String} type 电力服务  水力服务
     * @apiParam {String} workTime 工作时间
     * @apiParam {String} address 工作地址
     * @apiParam {String} describel 工作内容
     * @apiParam {String} phone 注册时的手机号
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {}
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/addmission")
    public Msg addMission(String title, String type, String workTime, String address, String describel, String phone) {
        User userByPhone = userService.getUserByPhone(phone);
        Mission mission = new Mission();
        mission.setUserId(userByPhone.getId());
        mission.setAddress(address);
        mission.setTitle(title);
        mission.setDescribel(describel);
        mission.setStandby3(workTime);
        mission.setStandby1("0");
        mission.setStandby2(type);
        mission.setBeginTime(new Date());
        mission.setState("0");
        try {
            userService.addMission(mission);
            return Msg.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /addQYmission
     * @apiName 企业任务发布
     * @apiGroup 5.9企业任务发布
     * @apiParam {String} title 项目名称 前端限制字数
     * @apiParam {String} type 项目类型
     * @apiParam {String} workTime 项目周期
     * @apiParam {String} address 工作地址
     * @apiParam {String} describel 项目明细
     * @apiParam {String} phone 注册时的手机号
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {}
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/addQYmission")
    public Msg addMissionQY(String title, String type, String workTime, String address, String describel, String phone) {
        User userByPhone = userService.getUserByPhone(phone);
        Mission mission = new Mission();
        mission.setUserId(userByPhone.getId());
        mission.setAddress(address);
        mission.setTitle(title);
        mission.setDescribel(describel);
        mission.setStandby3(workTime);
        mission.setStandby1("1");
        mission.setStandby2(type);
        mission.setBeginTime(new Date());
        try {
            userService.addMission(mission);
            return Msg.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }


    /**
     * @apiVersion 0.0.1
     * @api {post} /getelectric
     * @apiName 获取用户电量
     * @apiGroup 2.1获取用户电量
     * @apiParam {String} phone 注册时的手机号，后端检测唯一
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     * "yesterday": "421",
     * "surplus": "324",
     * "name": "阿鑫",
     * "lastMonth": "1625"
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/getelectric")
    public Msg getElectric(String phone) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            return Msg.success().add("name", user.getNickname()).add("lastMonth", "1625").add("surplus", "324").add("yesterday", "421");
        } else {
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /attestationId
     * @apiName 用户实名认证
     * @apiGroup 5.2用户实名认证
     * @apiParam {String} name 名字
     * @apiParam {String} num 身份证号 安卓端验证格式
     * @apiParam {String} phone 注册时的手机号
     * @apiParam {String} standby1 图片路径 多图片用逗号隔开
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {}
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/attestationId")
    public Msg addSys_user_name(String name, String num, String phone,String standby1) {
        User user = userService.getUserByPhone(phone);
        if (user != null) {
            user.setUpdateTime(new Date());
            char i = 1;
            user.setRealName(i);
            Sys_user_name attestation = new Sys_user_name();
            attestation.setBeginTime(new Date());
            attestation.setName(name);
            attestation.setIdNumber(num);
            attestation.setUserId(user.getId());
            attestation.setStandby1(standby1);
            userService.addSys_user_name(attestation);
            userService.updateUser(user);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /getattestation
     * @apiName 查看实名认证
     * @apiGroup 5.21用户实名认证
     * @apiParam {String} phone 注册时的手机号
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     * "list": {
     * "id": 0,
     * "userId": 1,
     * "idNumber": "411522166666",
     * "name": "程",
     * "beginTime": "2019-12-17T06:51:35.000+0000",
     * "updateTime": null,
     * "isNot":"",
     * "standby1": null,
     * "standby2": null,
     * "standby3": null
     * }
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @PostMapping("/getattestation")
    public Msg getattestation(String phone) {
        try {
            User user = userService.getUserByPhone(phone);
            Sys_user_name userName = userService.getUserName(user.getId());
            return Msg.success().add("list", userName);
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {post} /addimg
     * @apiName 多图片上传接口
     * @apiGroup 10.0图片上传接口
     * @apiParam {MultipartFile[]} images 名字
     * @apiSuccessExample Success-Response:
     * HTTP/1.1 200 OK
     * {
     * "code": 100,
     * "msg": "处理成功",
     * "extend": {
     *     "src": "20191218/15766342784768906.jpg"
     * }
     * }
     * @apiErrorExample Error-Response:
     * HTTP/1.1 404 Not Found
     * {
     * "code": 200,
     * "msg": "处理失败",
     * "extend": {}
     * }
     */
    @RequestMapping(value = "/addimg", method = RequestMethod.POST)
    @ResponseBody
    public Msg addimg(@RequestParam(required = false) MultipartFile[] images) {
        String imageStr = "";
        try {
            if (images != null && images.length > 0) {
                for (MultipartFile file : images) {
                    try {
                        String fileName = FileUtil.uploadFile("", file);
                        imageStr += fileName;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return Msg.success().add("msg", "成功").add("src", imageStr);
        } catch (Exception e) {
            e.printStackTrace();
            return Msg.fail();
        }
    }







    public Date getDate(){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String createdate = sdf.format(date);
        try {
            return sdf.parse(createdate);
        } catch (ParseException e) {
           return  null;
        }
    }




















    }









