package com.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.*;

import java.util.List;

/**
 * @Auther:位开心
 * @Date: 2019/12/17
 * @Description: com.Service
 * @version: 1.0
 */
public interface XuserService {


    public User getUserByID(int id);

    IPage<User> userService(int pageNo, int pageSize);

    IPage<Mission> MyOrder(int state, String datatime, int userId,int pageNo, int pageSize);

    Mission getTaskOrderById(int id);

    boolean TaskEvaluation(int mission_id, int orderId, int grade,int appraiser_id, String evaluate);

    List<Sys_user_profession1> getProfrssionByUserID(int id);

    boolean AddProfrssion(int id, String username, String cid, String type, String introduce, String sevice_area);

    boolean updataProfrssion(int id, String username, String cid, String type, String introduce, String sevice_area);

    boolean addenterpriseCertification(int userid, String frimname, String frimNum, String frimimg, String address, String phone, String name, String cid, String cidimgZ, String cidimgF);

    List<Sys_user_firm> getEnterpriseCertificationByid(int id);

    boolean electricityCertification(int userid, String name, String cid, String phone, String num, String imgUrl);

    List<Sys_user_electric> getElectricityCertificationByid(int userid);
}
