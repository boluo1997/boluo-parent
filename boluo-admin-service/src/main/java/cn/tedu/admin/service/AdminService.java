package cn.tedu.admin.service;

import cn.tedu.admin.mapper.AdminMapper;
import com.jt.common.pojo.Admin;
import com.jt.common.pojo.Adopt;
import com.jt.common.pojo.User;
import com.jt.common.pojo.Volunteer;
import com.jt.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper am;

    //admin login
    public String doLogin(Admin admin) {
        try{

            Admin exist = am.selectAdminByAdminNameAndPassword(admin);

            if(exist == null){
                //登录失败
                return "";
            }else {
                //登录成功
                return "success";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //查看用户信息
    public EasyUIResult queryPageUser(Integer page, Integer rows) {
        EasyUIResult result = new EasyUIResult();

        Integer total = am.selectUserCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<User> pList = am.selectUserByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //删除用户
    public void deleteUser(Integer userId) {
        am.deleteUserByUserId(userId);
    }

    //查看想领养动物用户的名单
    public EasyUIResult queryPageTemp(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectTempCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<User> pList = am.selectTempByPage(start,rows);
        result.setRows(pList);
        return result;
    }


    //批准领养      把伪领养表中的内容写到领养表中  并把temp表中的状态码改为1
    public void passAdopt(Adopt adopt) {
        //userId和animalId就是伪领养表中的内容
        adopt.setAdoptCreateTime(new Date());
        am.insertAdopt(adopt);
        Integer userId = adopt.getUserId();
        am.updateTemp(userId);
    }


    //查看申请成为志愿者的人的名单        分页查询
    public EasyUIResult queryPageVolunteer(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectVolunteerCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<Volunteer> pList = am.selectVolunteerByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //批准成为志愿者
    public void passVolunteer(Integer userId) {
        am.updateVolunteer(userId);
    }

    //查看志愿者名单
    public EasyUIResult queryPageAlreadyVolunteer(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectAlreadyVolunteerCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Volunteer>
        Integer start = (page-1)*rows;
        List<Volunteer> pList = am.selectAlreadyVolunteerByPage(start,rows);
        result.setRows(pList);
        return result;
    }

}























