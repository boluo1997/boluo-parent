package cn.tedu.admin.service;

import cn.tedu.admin.mapper.AdminMapper;
import com.jt.common.pojo.*;
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


    //批准领养      把伪领养表中的内容写到领养表中  并把temp表中的状态码改为1(相当于把临时表中的数据删除)
    public void passAdopt(Adopt adopt) {
        //userId和animalId就是伪领养表中的内容
        adopt.setAdoptCreateTime(new Date());
        am.insertAdopt(adopt);
        Integer userId = adopt.getUserId();
        am.updateTemp(userId);
        am.changeUserType3(userId);

        //把该条动物信息从animal表中删除
        //Integer animalId = adopt.getAnimalId();
        //am.deleteAnimalByAnimalId(animalId);
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

    //拒绝成为志愿者，把volunteer状态码改为2
    public void refuseVolunteer(Integer userId) {
        am.refuseVolunteer(userId);
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

    //分页查看评论
    public EasyUIResult queryCheckComment(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectCommentCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Volunteer>
        Integer start = (page-1)*rows;
        List<Comment> pList = am.selectCommentByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //删除评论
    public void deleteComment(Integer leaveId) {
        am.deleteComment(leaveId);
    }

    //送养动物信息管理--删除
    public void deleteAnimal(Integer animalId) {
        am.deleteAnimalByAnimalId(animalId);
    }

    //丢失动物信息管理--删除
    public void deleteLose(Integer loseId) {
        am.deleteLose(loseId);
    }

    //查看领养名单
    public EasyUIResult queryAdoption(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectAdoptionCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Volunteer>
        Integer start = (page-1)*rows;
        List<Adoption> pList = am.selectAdoptionByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //拒绝领养  把temp表中数据删除(改状态码) 把用户type改为4 表示已经拒绝
    public void refuseAdopt(Adopt adopt) {
        Integer userId = adopt.getUserId();
        //am.updateTemp(userId);
        am.deleteTemp522(userId);
        am.changeUserType4(userId);
    }


}























