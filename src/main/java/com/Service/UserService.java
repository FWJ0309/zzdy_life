package com.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.entity.Mission;
import com.entity.Sys_user_name;
import com.entity.User;

import java.util.List;

public interface UserService {

        public  List<User> selectUsers();

        public User getUserByPhone(String phone);

        public void updateUser(User user);

        public void add(User user);

        public IPage<Mission> getMissionList(int pageNo, int pageSize,String type,String standby2);

        public IPage<Mission> getMissionList2(int pageNo, int pageSize,String type);

        public Mission getMissionById(int id);

        public void addMission(Mission mission);

        public void addSys_user_name(Sys_user_name name);

        public Sys_user_name getUserName(int id);

}
