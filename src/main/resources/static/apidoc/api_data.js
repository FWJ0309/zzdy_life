define({ "api": [
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/login",
    "title": "",
    "name": "______",
    "group": "1.2登录界面",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n    \"code\": 100,\n    \"msg\": \"处理成功\",\n    \"extend\": {\n        \"user\": {\n            \"id\": 1,\n            \"username\": \"阿鑫\",\n            \"password\": \"1234\",     用户密码\n            \"phone\": \"15617105157\",  注册时手机号\n            \"email\": \"784717017@qq\",  邮箱\n            \"nickname\": \"阿鑫\",   用户名\n            \"sex\": \"1\",   性别\n            \"age\": 18,    年龄\n            \"headImg\": \"\",      头像图片路劲\n            \"profession\": \"电工\",   职业(多职业用逗号隔开)\n            \"realName\": \"0\",    是否实名  0未认证1已认证\n            \"realEnterprise\": \"0\",  是否企业认证\n            \"realElectro\": \"0\",   是否用电信息认证\n            \"realOccupation\": \"0\",   是否职业认证(职业)\n            \"beginTime\": \"2019-12-14T00:43:17.000+0000\",   字段创建时间\n            \"updateTime\": \"2019-12-17T07:29:20.000+0000\",    字段更改时间\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {\n\"msg\": \"密码错误\"  or \"该手机话未注册\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "1.2登录界面"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/updatePwd",
    "title": "",
    "name": "______",
    "group": "1.3忘记密码",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码，前端需要自己检测两个输入密码相同</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"修改成功\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {\n\"msg\": \"该手机话未注册\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "1.3忘记密码"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/onlyPhone",
    "title": "",
    "name": "_____________",
    "group": "1.41注册检测手机号是否唯一",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号，后端检测唯一</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n\"msg\": \"该手机号可以使用\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {\n\"msg\": \"该手机号已注册\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "1.41注册检测手机号是否唯一"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/adduser",
    "title": "",
    "name": "______",
    "group": "1.4注册",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号，后端检测唯一</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "password",
            "description": "<p>密码，前端需要自己检测两个输入密码相同</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "nickname",
            "description": "<p>昵称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "email",
            "description": "<p>邮箱  前端需要检查邮箱格式</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"该手机号已注册\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "1.4注册"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/addimg",
    "title": "",
    "name": "_______",
    "group": "10.0图片上传接口",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "MultipartFile[]",
            "optional": false,
            "field": "images",
            "description": "<p>名字</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n    \"src\": \"20191218/15766342784768906.jpg\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "10.0图片上传接口"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/getelectric",
    "title": "",
    "name": "______",
    "group": "2.1获取用户电量",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号，后端检测唯一</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n\"yesterday\": \"421\",\n\"surplus\": \"324\",\n\"name\": \"阿鑫\",\n\"lastMonth\": \"1625\"\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "2.1获取用户电量"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/getmissionbyid",
    "title": "",
    "name": "____________________",
    "group": "3.3服务详情",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>工单任务id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n\"list\": {\n\"id\": 2,\n\"userId\": 1,\n\"area\": null,\n\"address\": \"信阳市高新区XXXXX\",\n\"longitude\": null,\n\"latitude\": null,\n\"sort\": 0,\n\"title\": \"电灯坏了\",\n\"describel\": \"家里电网莫名坏了\",\n\"img\": null,\n\"contact\": null,\n\"orderId\": 0,\n\"evaluate\": null,\n\"state\": \"0\",\n\"beginTime\": \"2019-12-17T06:39:37.000+0000\",\n\"updateTime\": null,\n\"isNot\":\"\",\n\"standby1\": \"0\",\n\"standby2\": \"电力服务\",\n\"standby3\": \"2019-12-15\",\n\"cphone\": null\n}\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "3.3服务详情"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/getmission",
    "title": "",
    "name": "______",
    "group": "3服务列表",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageNo",
            "description": "<p>当前页</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageSize",
            "description": "<p>一页显示个数</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>0个人1企业</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "standby2",
            "description": "<p>为空字符串默认查所有；0电力服务1水力服务</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n\"list\": {\n\"records\": [\n{\n\"id\": 4,\n\"userId\": 1,\n\"area\": null,\n\"address\": \"信阳市高新区XXXXX\",\n\"longitude\": null,\n\"latitude\": null,\n\"sort\": 0,\n\"title\": \"水管破损\",\n\"describel\": \"家里水管爆了速来\",\n\"img\": null,\n\"contact\": null,\n\"orderId\": 0,\n\"evaluate\": null,\n\"state\": \"0\",\n\"beginTime\": \"2019-12-17T06:41:25.000+0000\",\n\"updateTime\": null,\n\"isNot\":\"\",\n\"standby1\": \"0\",\n\"standby2\": \"水力服务\",\n\"standby3\": \"2019-12-15\",\n\"cphone\": null\n}\n],\n\"total\": 0,\n\"size\": 5,\n\"current\": 1,\n\"searchCount\": true,\n\"pages\": 0\n}\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "3服务列表"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getUserList",
    "title": "",
    "name": "______",
    "group": "4.1_人员列表",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageNo",
            "description": "<p>起始页</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageSize",
            "description": "<p>查询的条数</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "      HTTP/1.1 200 OK\n      {\n           \"code\": 100,\n            \"msg\": \"处理成功\",\n               \"extend\": {\n            \"list\": {\n            \"records\": [\n                    {\n                       \"id\": 0,\n                       \"username\": null,\n                       \"password\": \"123\",\n                       \"phone\": \"18790103833\",\n                       \"email\": \"545@qq.com\",\n                       \"nickname\": \"阿想\",\n                       \"sex\":\"\n                       \"age\": 18,\n                       \"headImg\": \"1\",\n                       \"profession\": \"1\",\n                       \"realName\":\",\n                       \"realEnterprise\":\"\",\n                       \"realElectro\":\"\",\n                       \"realOccupation\":\"\",\n                       \"beginTime\": \"2019-12-14T00:43:17.000+0000\",\n                       \"updateTime\": \"2019-12-17T07:29:20.000+0000\",\n                       \"isNot\":\"\",\n                       \"standby1\": null,\n                       \"standby2\": null,\n                       \"standby3\": null\n                   },\n                   {\n                              \"id\": 1,\n                              \"username\": \"阿鑫\",\n                              \"password\": \"1234\",\n                              \"phone\": \"15617105157\",\n                              \"email\": \"784717017@qq\",\n                              \"nickname\": \"阿鑫\",\n                              \"sex\": \"1\",\n                              \"age\": 18,\n                              \"headImg\": \"1\",\n                              \"profession\": \"1\",\n                             \"realName\":\"\",\n                             \"realEnterprise\":\"\",\n                             \"realElectro\":\"\",\n                             \"realOccupation\":\"\",\n                             \"beginTime\": \"2019-12-14T00:43:17.000+0000\",\n                             \"updateTime\": \"2019-12-17T07:29:20.000+0000\",\n                             \"isNot\":\"\",\n                             \"standby1\": null,\n                             \"standby2\": null,\n                             \"standby3\": null\n                         }\n               ],\n                  \"total\": 0,\n                  \"size\": 10,\n                  \"current\": 1,\n                  \"searchCount\": true,\n                  \"pages\": 0\n                }\n     }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "4.1_人员列表"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getUserByID",
    "title": "",
    "name": "____id______",
    "group": "4.2_人员详情",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>用户ID</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "      HTTP/1.1 200 OK\n      {\n    \"code\": 100,\n    \"msg\": \"处理成功\",\n    \"extend\": {\n        \"list\": {\n            \"id\": 1,\n            \"username\": \"阿鑫\",\n            \"password\": \"1234\",\n            \"phone\": \"15617105157\",\n            \"email\": \"784717017@qq\",\n            \"nickname\": \"阿鑫\",\n            \"sex\": \"1\",\n            \"age\": 18,\n            \"headImg\": \"1\",\n            \"profession\": \"1\",\n            \"realName\":\"\",\n            realEnterprise\":\"\",\n              \"realElectro\":\"\",\n              \"realOccupation\":\",\n              \"beginTime\": \"2019-12-14T00:43:17.000+0000\",\n            \"updateTime\": \"2019-12-17T07:29:20.000+0000\",\n              \"isNot\":\"\",\n               \"standby1\": null,\n            \"standby2\": null,\n            \"standby3\": null\n              }\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "4.2_人员详情"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/MyOrder",
    "title": "",
    "name": "_____________id___________",
    "group": "5.16_我的接单和我的发布",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "state",
            "description": "<p>0发布 1接单 未完成 3待评价  4完成</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "datatime",
            "description": "<p>接单的日期</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userId",
            "description": "<p>接单人id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageNo",
            "description": "<p>起始位置</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "pageSize",
            "description": "<p>查询的条数</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "      HTTP/1.1 200 OK\n      {\n    \"code\": 100,\n    \"msg\": \"处理成功\",\n    \"extend\": {\n        \"list\": {\n            \"records\": [\n                {\n                    \"id\": 2,\n                    \"userId\": 1,\n                    \"area\": null,\n                    \"address\": \"信阳市高新区XXXXX\",\n                    \"longitude\": null,\n                    \"latitude\": null,\n                    \"sort\": 0,\n                    \"title\": \"电灯坏了\",\n                    \"describel\": \"家里电网莫名坏了\",\n                    \"img\": null,\n                    \"contact\": null,\n                    \"orderId\": 0,\n                    \"evaluate\": null,\n                    \"state\": \"0\",\n                    \"beginTime\": \"2019-12-17T06:39:37.000+0000\",\n                    \"updateTime\": null,\n                    \"isNot\":\"\n                    \"standby1\": \"0\",\n                    \"standby2\": \"电力服务\",\n                    \"standby3\": \"2019-12-15\",\n                    \"cphone\": null\n                },\n                {\n                    \"id\": 4,\n                    \"userId\": 1,\n                    \"area\": null,\n                    \"address\": \"信阳市高新区XXXXX\",\n                    \"longitude\": null,\n                    \"latitude\": null,\n                    \"sort\": 0,\n                    \"title\": \"水管破损\",\n                    \"describel\": \"家里水管爆了速来\",\n                    \"img\": null,\n                    \"contact\": null,\n                    \"orderId\": 0,\n                    \"evaluate\": null,\n                    \"state\": \"0\",\n                    \"beginTime\": \"2019-12-17T06:41:25.000+0000\",\n                    \"updateTime\": null,\n                    \"isNot\":\"\n                     \"standby1\": \"0\",\n                    \"standby2\": \"水力服务\",\n                    \"standby3\": \"2019-12-15\",\n                    \"cphone\": null\n                },\n                {\n                    \"id\": 6,\n                    \"userId\": 1,\n                    \"area\": null,\n                    \"address\": \"信阳市高新区XXXXX\",\n                    \"longitude\": null,\n                    \"latitude\": null,\n                    \"sort\": 0,\n                    \"title\": \"小区水利管道重置\",\n                    \"describel\": \"xx小区水利管道重置\",\n                    \"img\": null,\n                    \"contact\": null,\n                    \"orderId\": 0,\n                    \"evaluate\": null,\n                    \"state\": \"0\",\n                    \"beginTime\": \"2019-12-17T06:56:46.000+0000\",\n                    \"updateTime\": null,\n                    \"isNot\":\"\n                    \"standby1\": \"1\",\n                    \"standby2\": \"水力服务\",\n                    \"standby3\": \"约4个月\",\n                    \"cphone\": null\n                }\n            ],\n            \"total\": 0,\n            \"size\": 10,\n            \"current\": 1,\n            \"searchCount\": true,\n            \"pages\": 0\n        }\n    }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "5.16_我的接单和我的发布"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/getattestation",
    "title": "",
    "name": "______",
    "group": "5.21用户实名认证",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n\"list\": {\n\"id\": 0,\n\"userId\": 1,\n\"idNumber\": \"411522166666\",\n\"name\": \"程\",\n\"beginTime\": \"2019-12-17T06:51:35.000+0000\",\n\"updateTime\": null,\n\"isNot\":\"\",\n\"standby1\": null,\n\"standby2\": null,\n\"standby3\": null\n}\n}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "5.21用户实名认证"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/attestationId",
    "title": "",
    "name": "______",
    "group": "5.2用户实名认证",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>名字</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "num",
            "description": "<p>身份证号 安卓端验证格式</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "standby1",
            "description": "<p>图片路径 多图片用逗号隔开</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "5.2用户实名认证"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/addmission",
    "title": "",
    "name": "______",
    "group": "5.7个人任务发布",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>工作名称 前端限制字数</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>电力服务  水力服务</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "workTime",
            "description": "<p>工作时间</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>工作地址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describel",
            "description": "<p>工作内容</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "5.7个人任务发布"
  },
  {
    "version": "0.0.1",
    "type": "post",
    "url": "/addQYmission",
    "title": "",
    "name": "______",
    "group": "5.9企业任务发布",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "title",
            "description": "<p>项目名称 前端限制字数</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>项目类型</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "workTime",
            "description": "<p>项目周期</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>工作地址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "describel",
            "description": "<p>项目明细</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "phone",
            "description": "<p>注册时的手机号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n\"code\": 200,\n\"msg\": \"处理失败\",\n\"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/CxController.java",
    "groupTitle": "5.9企业任务发布"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/TaskEvaluation",
    "title": "",
    "name": "______",
    "group": "任务工单评价",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "mission_id",
            "description": "<p>任务id</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "orderId",
            "description": "<p>接单人编号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "appraiser_id",
            "description": "<p>评价人编号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "grade",
            "description": "<p>得分</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "evaluete",
            "description": "<p>评价详情</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "任务工单评价"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/enterpriseCertification",
    "title": "",
    "name": "______",
    "group": "提交企业认证",
    "description": "<p>根据用户编号提交自己的企业认证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userid",
            "description": "<p>用户编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "frimname",
            "description": "<p>企业名称</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "frimNum",
            "description": "<p>企业营业执照编号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "frimimg",
            "description": "<p>企业营业执照照片</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": "<p>企业地址</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "Phone",
            "description": "<p>联系电话</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>法人姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cid",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "CidimgZ",
            "description": "<p>身份证正面照</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "CidimgF",
            "description": "<p>身份证反面照</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "提交企业认证"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/electricityCertification",
    "title": "",
    "name": "____",
    "group": "提交用电认证信息",
    "description": "<p>根据用户编号提交自己的用电认证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userid",
            "description": "<p>用户编号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "name",
            "description": "<p>户主姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "cid",
            "description": "<p>户主身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "phone",
            "description": "<p>联系方式</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "num",
            "description": "<p>电表编号</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "imgUrl",
            "description": "<p>电表缴费单</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "提交用电认证信息"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getTaskOrderById",
    "title": "",
    "name": "____id____",
    "group": "根据接单id工单详情",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>接单id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n\"code\": 100,\n\"msg\": \"处理成功\",\n\"extend\": {\n    \"list\": {\n        \"id\": 2,\n        \"userId\": 1,\n        \"area\": null,\n        \"address\": \"信阳市高新区XXXXX\",\n        \"longitude\": null,\n        \"latitude\": null,\n        \"sort\": 0,\n        \"title\": \"电灯坏了\",\n        \"describel\": \"家里电网莫名坏了\",\n        \"img\": null,\n        \"contact\": null,\n        \"orderId\": 0,\n        \"evaluate\": null,\n        \"state\": \"0\",\n        \"beginTime\": \"2019-12-17T06:39:37.000+0000\",\n        \"updateTime\": null,\n        \"isNot\":\"\n       }\n     }\n }",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "根据接单id工单详情"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getProfrssionByUserID",
    "title": "",
    "name": "_______________________",
    "group": "职业认证",
    "description": "<p>根据用户编号查询自己职业认证状态和职业认证详情</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>用户id</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {\n      \"list\": []\n  }\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "职业认证"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/updataProfrssion",
    "title": "",
    "name": "_______",
    "group": "职业认证_修改",
    "description": "<p>根据id修改属于自己的职业认证信息</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>该条记录的id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>真实姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cid",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>职业类型</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "introduce",
            "description": "<p>自我介绍</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sevice_area",
            "description": "<p>服务范围</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "职业认证_修改"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/AddProfrssion",
    "title": "",
    "name": "______",
    "group": "职业认证_提交",
    "description": "<p>添加属于自己的职业认证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "username",
            "description": "<p>真实姓名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "cid",
            "description": "<p>身份证号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "type",
            "description": "<p>职业类型</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "introduce",
            "description": "<p>自我介绍</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sevice_area",
            "description": "<p>服务范围</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "职业认证_提交"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getEnterpriseCertificationByid",
    "title": "",
    "name": "______",
    "group": "获取企业认证信息",
    "description": "<p>根据用户编号获取自己的企业认证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userid",
            "description": "<p>用户编号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "获取企业认证信息"
  },
  {
    "version": "0.0.1",
    "type": "get",
    "url": "/getElectricityCertificationByid",
    "title": "",
    "name": "1",
    "group": "获取用电认证信息",
    "description": "<p>根据用户编号获取自己的用电认证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "userid",
            "description": "<p>用户编号</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "  HTTP/1.1 200 OK\n{\n  \"code\": 100,\n  \"msg\": \"处理成功\",\n  \"extend\": {}\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n {\n       \"code\": 200,\n       \"msg\": \"处理失败\",\n       \"extend\": {}\n }",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/com/controller/WXKCtl.java",
    "groupTitle": "获取用电认证信息"
  }
] });
