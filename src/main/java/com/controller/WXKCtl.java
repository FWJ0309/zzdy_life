package com.controller;

import ch.qos.logback.core.util.FileUtil;
import com.Service.UserServiceImpl;
import com.Service.XuserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.*;
import com.util.Msg;
import org.apache.ibatis.ognl.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @Auther:位开心
 * @Date: 2019/12/16
 * @Description: com.controller
 * @version: 1.0
 */

@RestController
public class WXKCtl {

    @Autowired
    private XuserService userService;


    /**
     * @apiVersion 0.0.1
     * @api {get} /getUserByID
     * @apiName 根据用户id查询人员详情
     * @apiGroup 4.2 人员详情
     * @apiParam {int} id 用户ID
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *     "code": 100,
     *     "msg": "处理成功",
     *     "extend": {
     *         "list": {
     *             "id": 1,
     *             "username": "阿鑫",
     *             "password": "1234",
     *             "phone": "15617105157",
     *             "email": "784717017@qq",
     *             "nickname": "阿鑫",
     *             "sex": "1",
     *             "age": 18,
     *             "headImg": "1",
     *             "profession": "1",
     *             "realName":"",
     *             realEnterprise":"",
     *               "realElectro":"",
     *               "realOccupation":",
     *               "beginTime": "2019-12-14T00:43:17.000+0000",
     *             "updateTime": "2019-12-17T07:29:20.000+0000",
     *               "isNot":"",
     *                "standby1": null,
     *             "standby2": null,
     *             "standby3": null
     *               }
     *     }
     * }
     *
     *
     *
     *
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @GetMapping("/getUserByID")
    public Msg  getUserByID(int id){

        try {
            User user= userService.getUserByID(id);
            if(user.getUsername().length()>0){
                return  Msg.success().add("list",user);
            }else{
                return  Msg.fail();
            }
        }catch (Exception e){
            return  Msg.fail();
        }

    }


    /**
     * @apiVersion 0.0.1
     * @api {get} /getUserList
     * @apiName 分页查询人员
     * @apiGroup 4.1 人员列表
     * @apiParam {int} pageNo  起始页
     * @apiParam {int} pageSize  查询的条数
     *@apiSuccessExample Success-Response:
     *             HTTP/1.1 200 OK
     *             {
     *                  "code": 100,
     *                   "msg": "处理成功",
     *                      "extend": {
     *                   "list": {
     *                   "records": [
     *                           {
     *                              "id": 0,
     *                              "username": null,
     *                              "password": "123",
     *                              "phone": "18790103833",
     *                              "email": "545@qq.com",
     *                              "nickname": "阿想",
     *                              "sex":"
     *                              "age": 18,
     *                              "headImg": "1",
     *                              "profession": "1",
     *                              "realName":",
     *                              "realEnterprise":"",
     *                              "realElectro":"",
     *                              "realOccupation":"",
     *                              "beginTime": "2019-12-14T00:43:17.000+0000",
     *                              "updateTime": "2019-12-17T07:29:20.000+0000",
     *                              "isNot":"",
     *                              "standby1": null,
     *                              "standby2": null,
     *                              "standby3": null
     *                          },
     *                          {
     *                                     "id": 1,
     *                                     "username": "阿鑫",
     *                                     "password": "1234",
     *                                     "phone": "15617105157",
     *                                     "email": "784717017@qq",
     *                                     "nickname": "阿鑫",
     *                                     "sex": "1",
     *                                     "age": 18,
     *                                     "headImg": "1",
     *                                     "profession": "1",
     *                                    "realName":"",
     *                                    "realEnterprise":"",
     *                                    "realElectro":"",
     *                                    "realOccupation":"",
     *                                    "beginTime": "2019-12-14T00:43:17.000+0000",
     *                                    "updateTime": "2019-12-17T07:29:20.000+0000",
     *                                    "isNot":"",
     *                                    "standby1": null,
     *                                    "standby2": null,
     *                                    "standby3": null
     *                                }
     *                      ],
     *                         "total": 0,
     *                         "size": 10,
     *                         "current": 1,
     *                         "searchCount": true,
     *                         "pages": 0
     *                       }
     *            }
     *       }
     *
     *
     *        @apiErrorExample Error-Response:
     *            HTTP/1.1 404 Not Found
     *             {
     *                   "code": 200,
     *                   "msg": "处理失败",
     *                   "extend": {}
     *             }
     *
     *
     */
    @ResponseBody
    @RequestMapping("/getUserList")
    public Msg getUserList(int pageNo,int pageSize){
        try {
            IPage<User> list=userService.userService(pageNo,pageSize);
                return  Msg.success().add("list",list);
        }catch (Exception e){
            return  Msg.fail();
        }
    }



    /**
     * @apiVersion 0.0.1
     * @api {get} /MyOrder
     * @apiName  根据接单状态和时间以及用户id查询属于自己的接单信息
     * @apiGroup 5.16 我的接单和我的发布
     * @apiParam {int} state  0发布 1接单 未完成 3待评价  4完成
     * @apiParam {String} datatime  接单的日期
     * @apiParam {int}  userId  接单人id
     * @apiParam {int} pageNo  起始位置
     * @apiParam {int} pageSize  查询的条数
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *       {
     *     "code": 100,
     *     "msg": "处理成功",
     *     "extend": {
     *         "list": {
     *             "records": [
     *                 {
     *                     "id": 2,
     *                     "userId": 1,
     *                     "area": null,
     *                     "address": "信阳市高新区XXXXX",
     *                     "longitude": null,
     *                     "latitude": null,
     *                     "sort": 0,
     *                     "title": "电灯坏了",
     *                     "describel": "家里电网莫名坏了",
     *                     "img": null,
     *                     "contact": null,
     *                     "orderId": 0,
     *                     "evaluate": null,
     *                     "state": "0",
     *                     "beginTime": "2019-12-17T06:39:37.000+0000",
     *                     "updateTime": null,
     *                     "isNot":"
     *                     "standby1": "0",
     *                     "standby2": "电力服务",
     *                     "standby3": "2019-12-15",
     *                     "cphone": null
     *                 },
     *                 {
     *                     "id": 4,
     *                     "userId": 1,
     *                     "area": null,
     *                     "address": "信阳市高新区XXXXX",
     *                     "longitude": null,
     *                     "latitude": null,
     *                     "sort": 0,
     *                     "title": "水管破损",
     *                     "describel": "家里水管爆了速来",
     *                     "img": null,
     *                     "contact": null,
     *                     "orderId": 0,
     *                     "evaluate": null,
     *                     "state": "0",
     *                     "beginTime": "2019-12-17T06:41:25.000+0000",
     *                     "updateTime": null,
     *                     "isNot":"
     *                      "standby1": "0",
     *                     "standby2": "水力服务",
     *                     "standby3": "2019-12-15",
     *                     "cphone": null
     *                 },
     *                 {
     *                     "id": 6,
     *                     "userId": 1,
     *                     "area": null,
     *                     "address": "信阳市高新区XXXXX",
     *                     "longitude": null,
     *                     "latitude": null,
     *                     "sort": 0,
     *                     "title": "小区水利管道重置",
     *                     "describel": "xx小区水利管道重置",
     *                     "img": null,
     *                     "contact": null,
     *                     "orderId": 0,
     *                     "evaluate": null,
     *                     "state": "0",
     *                     "beginTime": "2019-12-17T06:56:46.000+0000",
     *                     "updateTime": null,
     *                     "isNot":"
     *                     "standby1": "1",
     *                     "standby2": "水力服务",
     *                     "standby3": "约4个月",
     *                     "cphone": null
     *                 }
     *             ],
     *             "total": 0,
     *             "size": 10,
     *             "current": 1,
     *             "searchCount": true,
     *             "pages": 0
     *         }
     *     }
     * }
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     *
     */
        @ResponseBody
        @RequestMapping("/MyOrder")
        public Msg MyOrder(int state ,String datatime ,int userid,int pageNo, int pageSize){

            IPage<Mission> list=userService.MyOrder(state,datatime,userid,pageNo,pageSize);
            return  Msg.success().add("list",list);


    }
    /**
     * @apiVersion 0.0.1
     * @api {get} /getTaskOrderById
     * @apiName  根据接单id工单详情
     * @apiGroup 根据接单id工单详情
     * @apiParam {int} id  接单id
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *     "code": 100,
     *     "msg": "处理成功",
     *     "extend": {
     *         "list": {
     *             "id": 2,
     *             "userId": 1,
     *             "area": null,
     *             "address": "信阳市高新区XXXXX",
     *             "longitude": null,
     *             "latitude": null,
     *             "sort": 0,
     *             "title": "电灯坏了",
     *             "describel": "家里电网莫名坏了",
     *             "img": null,
     *             "contact": null,
     *             "orderId": 0,
     *             "evaluate": null,
     *             "state": "0",
     *             "beginTime": "2019-12-17T06:39:37.000+0000",
     *             "updateTime": null,
     *             "isNot":"
     *            }
     *          }
     *      }
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     *
     *
     */
        @ResponseBody
        @RequestMapping("/getTaskOrderById")
        public Msg  getTaskOrderById(int  id){
            try {
                Mission  list=userService.getTaskOrderById(id);
                System.out.println(list.toString());
                return  Msg.success().add("list",list);
            }catch (Exception e){
                return  Msg.fail();
            }
        }
    /**
     * @apiVersion 0.0.1
     * @api {get} /TaskEvaluation
     * @apiName  任务工单评价
     * @apiGroup 任务工单评价
     * @apiParam {int} mission_id  任务id
     * @apiParam {int} orderId  接单人编号
     * @apiParam {int} appraiser_id  评价人编号
     * @apiParam {int} grade  得分
     * @apiParam {int} evaluete  评价详情
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     *
     */
    @ResponseBody
    @RequestMapping("/TaskEvaluation")
        public  Msg TaskEvaluation(int mission_id,int orderId, int grade, int appraiser_id,String  evaluate){
                try {
                    boolean flag=userService.TaskEvaluation(mission_id,orderId,grade,appraiser_id,evaluate);
                    if(flag){
                        return  Msg.success();
                    }else{
                        return Msg.fail();
                    }
                }catch (Exception e){
                    return Msg.fail();
                }
        }


    /**
     * @apiVersion 0.0.1
     * @api {get} /getProfrssionByUserID
     * @apiName  根据用户编号查询自己职业认证状态和职业认证详情
     * @apiGroup 职业认证
     * @apiDescription 根据用户编号查询自己职业认证状态和职业认证详情
     * @apiParam {int} id  用户id
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {
     *           "list": []
     *       }
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     *
     */
    @ResponseBody
    @RequestMapping("/getProfrssionByUserID")
        public  Msg  getProfrssionByUserID(int id){
            try{
                List<Sys_user_profession1> list= userService.getProfrssionByUserID(id);
               return Msg.success().add("list", list);
            }catch (Exception  e){
                return  Msg.fail();
            }
        }
    /**
     * @apiVersion 0.0.1
     * @api {get} /AddProfrssion
     * @apiName  提交职业认证
     * @apiGroup 职业认证  提交
     * @apiDescription 添加属于自己的职业认证
     * @apiParam {int} id  用户id
     * @apiParam {String} username 真实姓名
     * @apiParam {String} cid  身份证号
     * @apiParam {String} type  职业类型
     * @apiParam {String} introduce  自我介绍
     * @apiParam {String} sevice_area  服务范围
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @RequestMapping("/AddProfrssion")
       public  Msg  AddProfrssion( int  id,String username,String cid ,String type,String introduce,String  sevice_area){
            try {
               boolean  flag =  userService.AddProfrssion(id,username,cid,type,introduce,sevice_area);
               if(flag){
                   return  Msg.success();
               }else{
                   return  Msg.fail();
               }
            }catch (Exception e){
                return  Msg.fail();
            }
       }


    /**
     * @apiVersion 0.0.1
     * @api {get} /updataProfrssion
     * @apiName  职业认证  修改
     * @apiGroup 职业认证  修改
     * @apiDescription 根据id修改属于自己的职业认证信息
     * @apiParam {int} id 该条记录的id
     * @apiParam {String} username 真实姓名
     * @apiParam {String} cid  身份证号
     * @apiParam {String} type  职业类型
     * @apiParam {String} introduce  自我介绍
     * @apiParam {String} sevice_area  服务范围
     *

     *
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @RequestMapping("/updataProfrssion")
    public  Msg  updataProfrssion( int  id,String username,String cid ,String type,String introduce,String  sevice_area){
         try{
            boolean  flag =  userService.updataProfrssion(id,username,cid,type,introduce,sevice_area);
            if(flag){
                return  Msg.success();
            }else{
                return  Msg.fail();
            }
         }catch (Exception e){
            return  Msg.fail();
        }
    }

/**
 * @apiVersion 0.0.1
 * @api {get} /enterpriseCertification
 * @apiName  提交企业认证
 * @apiGroup 提交企业认证
 * @apiDescription 根据用户编号提交自己的企业认证
 * @apiParam {int} userid  用户编号
 * @apiParam {String} frimname 企业名称
 * @apiParam {String} frimNum  企业营业执照编号
 * @apiParam {String} frimimg  企业营业执照照片
 * @apiParam {String} address  企业地址
 * @apiParam {String} Phone  联系电话
 * @apiParam {String} name  法人姓名
 * @apiParam {String} cid  身份证号
 * @apiParam {String} CidimgZ  身份证正面照
 * @apiParam {String} CidimgF  身份证反面照
 * @apiSuccessExample Success-Response:
  *       HTTP/1.1 200 OK
  *     {
  *       "code": 100,
  *       "msg": "处理成功",
  *       "extend": {}
  *     }
  *
  *
  *  @apiErrorExample Error-Response:
 *      HTTP/1.1 404 Not Found
 *       {
 *             "code": 200,
 *             "msg": "处理失败",
 *             "extend": {}
 *       }
 */
    @ResponseBody
    @RequestMapping("/enterpriseCertification")
    public  Msg   enterpriseCertification(int userid,String frimname ,String frimNum, String  frimimg,String address,String phone ,String name ,String  cid ,String  cidimgZ,String cidimgF){
        try {
            boolean flag=userService.addenterpriseCertification(userid,frimname,frimNum,frimimg,address,phone,name,cid,cidimgZ,cidimgF);
            if(flag){
                return  Msg.success();
            }else{
                return  Msg.fail();
            }
        }catch (Exception e){
            return  Msg.fail();
        }

    }
    /**
     * @apiVersion 0.0.1
     * @api {get} /getEnterpriseCertificationByid
     * @apiName  提交企业认证
     * @apiGroup 获取企业认证信息
     * @apiDescription 根据用户编号获取自己的企业认证
     * @apiParam {int} userid  用户编号
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @RequestMapping("/getEnterpriseCertificationByid")
    public Msg getEnterpriseCertificationByid(int id){
        try {
            List<Sys_user_firm> list = userService.getEnterpriseCertificationByid(id);
            return  Msg.success().add("list",list);
        }catch (Exception e){
            return  Msg.fail();
        }
    }
    /**
     * @apiVersion 0.0.1
     * @api {get} /electricityCertification
     * @apiName  用电认证
     * @apiGroup 提交用电认证信息
     * @apiDescription 根据用户编号提交自己的用电认证
     * @apiParam {int} userid  用户编号
     * @apiParam {int} name  户主姓名
     * @apiParam {int} cid  户主身份证号
     * @apiParam {int} phone  联系方式
     * @apiParam {int} num  电表编号
     * @apiParam {int} imgUrl  电表缴费单
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @RequestMapping("/electricityCertification")
    public Msg electricityCertification(int userid ,String name ,String  cid ,String  phone,String num ,String  imgUrl ){
        try {
            boolean flag = userService.electricityCertification(userid,name,cid,phone,num,imgUrl);
            if(flag){
                return  Msg.success();
            }else{
                return  Msg.fail();
            }
        }catch (Exception e){
            return  Msg.fail();
        }
    }

    /**
     * @apiVersion 0.0.1
     * @api {get} /getElectricityCertificationByid
     * @apiName 1
     * @apiGroup 获取用电认证信息
     * @apiDescription 根据用户编号获取自己的用电认证
     * @apiParam {int} userid  用户编号
     * @apiSuccessExample Success-Response:
     *       HTTP/1.1 200 OK
     *     {
     *       "code": 100,
     *       "msg": "处理成功",
     *       "extend": {}
     *     }
     *
     *
     *  @apiErrorExample Error-Response:
     *      HTTP/1.1 404 Not Found
     *       {
     *             "code": 200,
     *             "msg": "处理失败",
     *             "extend": {}
     *       }
     */
    @ResponseBody
    @RequestMapping("/getElectricityCertificationByid")
    public  Msg getElectricityCertificationByid(int userid){
        try {
            List<Sys_user_electric> list = userService.getElectricityCertificationByid(userid);
            return  Msg.success().add("list",list);
        }catch (Exception e){
            return  Msg.fail();
        }
    }


}
