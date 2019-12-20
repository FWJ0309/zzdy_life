package com.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Mission;
import com.entity.Sys_user_name;
import com.entity.User;
import com.mapper.MissionMapper;
import com.mapper.Sys_user_nameMapper;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private MissionMapper missionMapper;
    @Autowired
    private Sys_user_nameMapper nameMapper;

    @Override
    public List<User> selectUsers() {

        return userMapper.selectList(null);
    }

    @Override
    public User getUserByPhone(String phone) {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getPhone,phone);
        List<User>  userlist = list(queryWrapper);
        try {
            User user = userlist.get(0);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    private List<User> list(QueryWrapper<User> queryWrapper) {
       return userMapper.selectList(queryWrapper);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public IPage<Mission> getMissionList(int pageNo, int pageSize,String type,String standby2) {
        Page<Mission> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Mission> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Mission::getStandby1,type).eq(Mission::getStandby2,standby2).orderByDesc(Mission::getBeginTime);
        return  missionMapper.selectPage(page,wrapper);
    }

    @Override
    public IPage<Mission> getMissionList2(int pageNo, int pageSize, String type) {
        Page<Mission> page = new Page<>(pageNo, pageSize);
        QueryWrapper<Mission> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Mission::getStandby1,type).orderByDesc(Mission::getBeginTime);
        return  missionMapper.selectPage(page,wrapper);
    }

    @Override
    public Sys_user_name getUserName(int id) {
        QueryWrapper<Sys_user_name> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Sys_user_name::getUserId,id);
        return nameMapper.selectOne(wrapper);
    }

    @Override
    public Mission getMissionById(int id) {
        return missionMapper.selectById(id);
    }

    @Override
    public void addMission(Mission mission) {
        missionMapper.insert(mission);
    }

    @Override
    public void addSys_user_name(Sys_user_name name) {
        nameMapper.insert(name);
    }
}
