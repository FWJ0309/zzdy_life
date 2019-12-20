package com.Service;

import com.alibaba.druid.sql.visitor.functions.Left;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.*;
import com.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.beans.Transient;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther:位开心
 * @Date: 2019/12/17
 * @Description: com.Service
 * @version: 1.0
 */
@Service
public class XuserServiceImpl implements  XuserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MissionMapper missionMapper;
    @Autowired
    private GradeMapper gradeMapper;
    @Autowired
    private Sys_user_profession1Mapper sys_user_profession1Mapper;
    @Autowired
    private Sys_user_firmMapper sys_user_firmMapper;
    @Autowired
    private  Sys_user_electricMapper sys_user_electricMapper;

    @Override
    public User getUserByID(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public  IPage<User> userService(int pageNo, int pageSize) {

        IPage<User> page = new Page<>(pageNo, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        return userMapper.selectPage(page,wrapper);
    }

    @Override
    public IPage<Mission> MyOrder(int state, String datatime, int userId,int pageNo, int pageSize) {
        QueryWrapper<Mission> queryWrapper = new QueryWrapper<>();
        //queryWrapper.lambda().eq(Mission::getState,state).eq(Mission::getUser_id,userId).like(Mission::getBegin_time,datatime+"%",SqlLike.DEFAULT);
    queryWrapper.exists("SELECT  * from mission  where  state="+state+" AND  user_id="+userId+" and begin_time  like  '"+datatime+"%'");
        System.out.println( queryWrapper.getSqlSelect());
        IPage<Mission> studentList = list(pageNo, pageSize,queryWrapper);
        return studentList;
    }

    @Override
    public Mission getTaskOrderById(int id) {
        return missionMapper.selectById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean TaskEvaluation(int mission_id, int orderId,int appraiser_id, int grade, String evaluate) {
        Boolean flag1=false;
        Boolean flag2=false;
        flag1 =updataMission(mission_id,evaluate);
        flag2= imtergrade(mission_id,orderId,appraiser_id,grade);

        if(flag1&&flag2){
            return  true;
        }else{
            return  false;
        }
    }

    @Override
    public List<Sys_user_profession1> getProfrssionByUserID(int id) {
        QueryWrapper<Sys_user_profession1> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Sys_user_profession1::getUserId,id);
        return  sys_user_profession1Mapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean AddProfrssion(int id, String username, String cid, String type, String introduce, String sevice_area) {
        Sys_user_profession1 sys_user_profession1=new Sys_user_profession1();
        sys_user_profession1.setUserId(id);
        sys_user_profession1.setUserName(username);
        sys_user_profession1.setUserCid(cid);
        sys_user_profession1.setType(type);
        sys_user_profession1.setIntroduce(introduce);
        sys_user_profession1.setServiceArea(sevice_area);
        sys_user_profession1.setState(0);
        int  i=  sys_user_profession1Mapper.insert(sys_user_profession1);

       System.out.println();
        if(i>0){
            return  true;
        }else{
            return  false;
        }
    }

    @Override
    @Transactional(readOnly = false)
    public boolean updataProfrssion(int id, String username, String cid, String type, String introduce, String sevice_area) {
        Sys_user_profession1 sys_user_profession1= sys_user_profession1Mapper.selectById(id);
        sys_user_profession1.setUserName(username);
        sys_user_profession1.setUserCid(cid);
        sys_user_profession1.setType(type);
        sys_user_profession1.setIntroduce(introduce);
        sys_user_profession1.setServiceArea(sevice_area);
        int i= sys_user_profession1Mapper.updateById(sys_user_profession1);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addenterpriseCertification(int userid, String frimname, String frimNum, String frimimg, String address, String phone, String name, String cid, String cidimgZ, String cidimgF) {

        Sys_user_firm sys_user_firm=new Sys_user_firm();
        sys_user_firm.setUserId(userid);
        sys_user_firm.setFrimName(frimname);
        sys_user_firm.setIntro(frimNum);
        sys_user_firm.setFrimImg(frimimg);
        sys_user_firm.setStandby1(address);
        sys_user_firm.setStandby2(phone);
        sys_user_firm.setStandby3(name);
        sys_user_firm.setStandby4(cid);
        sys_user_firm.setStandby5(cidimgZ);
        sys_user_firm.setStandby6(cidimgF);
        sys_user_firm.setBeginTime(new Date());
        int  i=  sys_user_firmMapper.insert(sys_user_firm);
        if(i>0){
            return  true;
        }else{
            return  false;
        }
    }

    @Override
    public List<Sys_user_firm> getEnterpriseCertificationByid(int id) {
        QueryWrapper<Sys_user_firm> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Sys_user_firm::getUserId,id);
         List<Sys_user_firm>  list=  sys_user_firmMapper.selectList(queryWrapper);

        return list;
    }

    @Override
    public boolean electricityCertification(int userid, String name, String cid, String phone, String num, String imgUrl) {

        Sys_user_electric sys_user_electric=new Sys_user_electric();
        sys_user_electric.setUserId(userid);
        sys_user_electric.setRegistrantName(name);
        sys_user_electric.setRegistrantId(cid);
        sys_user_electric.setRegistrantPhone(phone);
        sys_user_electric.setRegistrantPhotoUrl(imgUrl);
        sys_user_electric.setMasterId(num);
        sys_user_electric.setBeginTime(new Date());
        int  i=  sys_user_electricMapper.insert(sys_user_electric);
        if(i>0){
            return  true;
        }else{
            return  false;
        }
    }

    @Override
    public List<Sys_user_electric> getElectricityCertificationByid(int userid) {
        QueryWrapper<Sys_user_electric> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Sys_user_electric::getUserId,userid);
        List<Sys_user_electric>  list=  sys_user_electricMapper.selectList(queryWrapper);

        return list;
    }


    private Boolean imtergrade( int mission_id, int orderId, int appraiser_id ,int grade1) {

        Grade grade= new Grade();
        grade.setAppraiserId(appraiser_id);
        grade.setMissionId(mission_id);
        grade.setOrderId(orderId);
        grade.setGrade(grade1);
        grade.setBeginTime(new Date());

        int  i=  gradeMapper.insert(grade);
        if(i>0){
            return  true;
        }else{
            return  false;
        }
    }

    private Boolean updataMission(int mission_id, String evaluate) {
         Mission  mission= missionMapper.selectById(mission_id);
         mission.setEvaluate(evaluate);
         mission.setState("5");
         int i=  missionMapper.updateById(mission);

         if(i>0){
             return  true;
         }else{
             return  false;
         }
    }

    private IPage<Mission> list( int pageNo,int pageSzie, QueryWrapper<Mission> queryWrapper) {
        IPage<Mission> page = new Page<>(pageNo,pageSzie);
        return  missionMapper.selectPage(page,queryWrapper);
    }


    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
