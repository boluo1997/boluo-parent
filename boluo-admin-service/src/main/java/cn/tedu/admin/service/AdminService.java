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

    //维修人员登录 获取用户名
    public String doLogin1(Fixer fixer) {
        try{
            //user.setUserPassword(MD5Util.md5(user.getUserPassword()));
            Fixer exist = am.selectFixerByUserNameAndPassword(fixer);

            if(exist == null){
                //登录失败
                System.out.println("登录失败");
                return "";
            }else {
                //登录成功,存储user_name
                String ticket = fixer.getUserName();
                return ticket;
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    //获取用户ID
    public String doLogin2(Fixer fixer) {
        try{

            //user.setUserPassword(MD5Util.md5(user.getUserPassword()));
            Fixer exist = am.selectFixerByUserNameAndPassword(fixer);

            if(exist == null){
                //登录失败
                System.out.println("登录失败");
                return "-1";
            }else {

                //登录成功,存储user_name
                String ticket = String.valueOf(exist.getFixerId());
                return ticket;
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

    //查看申请物资状态
    public EasyUIResult chakanshenqing(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectShenqingCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Volunteer>
        Integer start = (page-1)*rows;
        List<Volunteer> pList = am.selectShenqingByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //根据用户ID把申请的物资类型找出来
    public int shenqingTy(Integer userId) {
        return am.shenqingTy(userId);
    }

    //把当前申请表的对象获取到
    public Goods goods() {
        return am.goods();
    }

    //批准物资
    public void pizhun(Integer userId) {
        am.pizhun(userId);
    }

    //添加文章
    public void wenzhang(Wenzhang wenzhang) {
        am.wenzhang(wenzhang);
    }

    //删除文章
    public void shanwen(Integer wenzhangId) {
        am.shanwen(wenzhangId);
    }


    //从申请表中把该条信息删除
    public void shanshenqing(Integer userId) {
        am.shanshenqing(userId);
    }

    //删除评论
    public void shanping(Integer messageId) {
        am.shanping(messageId);
    }

    //修改患者人数
    public void xiugaihuanzhe(Huanzhe huanzhe) {
        am.xiugaihuanzhe(huanzhe);
    }

    //查看物资剩余数量
    public EasyUIResult goods(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectGoodsCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Volunteer>
        Integer start = (page-1)*rows;
        List<Goods> pList = am.selectGoodsByPage(start,rows);
        result.setRows(pList);
        return result;
    }

    //修改口罩数量
    public void kouzhao(Integer kouzhao) {
        am.kouzhao(kouzhao);
    }


    //修改消毒水数量
    public void xiaodu(Integer xiaodu) {
        am.xiaodu(xiaodu);
    }

    //修改体温计数量
    public void tiwen(Integer tiwen) {
        am.tiwen(tiwen);
    }

    //发放完物资之后把剩余物资数更新
    public void fafang(Goods goods) {
        am.fafang(goods);
    }


    //维修人员注册---查看用户名是否存在
    public boolean userNameExists(String userName) {
        System.out.println("Service userNameExists");
        int exist = am.selectUserCountByUserName(userName);
        System.out.println(exist);
        return exist == 1;
    }


    public void addFixer(Fixer fixer) {

        //密码加密
        //String md5Pass = MD5Util.md5(user.getUserPassword());
        //user.setUserPassword(md5Pass);
        //  user.setUserStatus("1");
        am.insertFixer(fixer);

    }
}























