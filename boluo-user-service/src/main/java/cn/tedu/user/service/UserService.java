package cn.tedu.user.service;

import cn.tedu.user.mapper.UserMapper;
import com.jt.common.pojo.Animal;
import com.jt.common.pojo.Temp;
import com.jt.common.pojo.User;
import com.jt.common.pojo.Volunteer;
import com.jt.common.utils.MD5Util;
import com.jt.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserMapper um;

    //判注断用户名是否已经被册
    public boolean userNameExists(String userName) {
        System.out.println("Service userNameExists");
        int exist = um.selectUserCountByUserName(userName);
        System.out.println(exist);
        return exist == 1;
    }

    //注册
    public void addUser(User user) {

        //密码加密
        String md5Pass = MD5Util.md5(user.getUserPassword());
        user.setUserPassword(md5Pass);
        user.setUserType("1");
        um.insertUser(user);

    }

    //登录 获取用户名
    public String doLogin(User user) {
        try{
            user.setUserPassword(MD5Util.md5(user.getUserPassword()));
            User exist = um.selectUserByUserNameAndPassword(user);

            if(exist == null){
                //登录失败
                System.out.println("登录失败");
                return "";
            }else {
                //登录成功,存储user_name
                String ticket = user.getUserName();
                return ticket;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //登录 获取用户ID
    public String doLogin2(User user) {
        try{

            //user.setUserPassword(MD5Util.md5(user.getUserPassword()));
            User exist = um.selectUserByUserNameAndPassword(user);

            if(exist == null){
                //登录失败
                System.out.println("登录失败");
                return "-1";
            }else {

                //登录成功,存储user_name
                String ticket = String.valueOf(exist.getUserId());
                return ticket;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }


    //查询所有用户信息      分页查询
    public EasyUIResult queryPageUser(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = um.selectUserCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<User> pList = um.selectUserByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //查询单个用户信息
    public User queryOneUser(Integer userId) {
        return um.selectUserById(userId);
    }

    //删除用户信息        (管理员的功能)
    public void deleteUser(Integer userId) {
        um.deleteUserById(userId);
    }

    //申请领养动物
    public void adoptAnimal(Integer userId, Integer animalId,String userName) {
        //this.existUserId(userId,animalId);
        um.insertTemp(userId,animalId,userName);
        um.changeUserType2(userId);
    }

    //查看该动物有没有被其他人申请领养
    public Temp existAnimalIdInTemp(Integer animalId) {
        Temp exist = um.selectStatusByAnimalId(animalId);
        return exist;
    }

    //查看该用户有没有领养其他动物
    public Temp existUserIdInTemp(Integer userId) {
        Temp exist = um.selectStatusByUserId(userId);
        return exist;
    }

    //查看是否重复申请
    public Temp existUserId(Integer userId, Integer animalId){
        Temp exist = um.selectStatusByUserIdAndAnimalId(userId,animalId);
        return exist;
    }

    //得到用户的申请领养状态码 判断用户是否已经领养过别的动物
    public Integer getUserType(Integer userId) {
        return um.getUserType(userId);
    }

    //查看自己正在申请领养的动物
    public Animal queryTemp(Integer userId) {
        return um.selectTemp(userId);
    }

    //查看自己被批准可以领养的动物
    public Animal queryAdopt(Integer userId) {
        return um.selectAdoptByUserId(userId);
    }


    //申请成为志愿者
    public void applyVolunteer(Integer userId) {
        um.updateUserById(userId);
    }

    //申请成为志愿者       往volunteer表中插入数据
    public void insertVolunteer(Volunteer volunteer) {
        um.insertVolunteer(volunteer);
    }

    //查看自己的志愿者状态
    public Volunteer checkVolunteer(Integer userId) {
        return um.checkVolunteer(userId);
    }

    //领养处---模糊查询
    public EasyUIResult queryAnimal(Integer page, Integer rows,String text) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = um.selectAnimalCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<Animal> pList = um.selectAnimalByPage(start,rows,text);
        result.setRows(pList);
        return result;
    }


    //查看自己的领养状态码
    public Integer checkType(Integer userId) {
        return um.checkType(userId);
    }
}


















