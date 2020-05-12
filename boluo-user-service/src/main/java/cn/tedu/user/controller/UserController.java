package cn.tedu.user.controller;

import cn.tedu.user.service.UserService;
import com.jt.common.pojo.Animal;
import com.jt.common.pojo.User;
import com.jt.common.pojo.Volunteer;
import com.jt.common.utils.CookieUtils;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService us;

    //查看用户名是否存在
    @RequestMapping("checkUserName")        //localhost:10001/user/checkUserName?userName=aaa
    public SysResult checkUserName(String userName){
        if(us.userNameExists(userName)){
            //存在
            return SysResult.build(201,"用户名已存在",null);
        }else {
            return SysResult.ok();
        }
    }

    //注册表单提交
    @RequestMapping("save")
    public SysResult addUser(User user){

        //判断新增成功失败
        try{
            us.addUser(user);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"新增失败",null);

        }
    }

    //登录
    @RequestMapping("login")
    public SysResult doLogin(User user, HttpServletRequest req, HttpServletResponse res){

        String ticket = us.doLogin(user);
        String userId = us.doLogin2(user);

        if(StringUtils.isNotEmpty(ticket)){
            //登录成功,把ticket(userName)加入到cookie中返回给浏览器
            CookieUtils.setCookie(req,res,"USER_NAME",ticket);
            CookieUtils.setCookie(req,res,"USER_ID",userId);
            //System.out.println(CookieUtils.getCookieValue(req,"USER_NAME"));
            return SysResult.ok();
        }else {
            //登录失败
            return SysResult.build(201,"登录失败",null);
        }
    }


    //查看所有的用户信息(分页查询用户信息)       /user/pageManage?page=1&rows=5
    @RequestMapping("pageManage")
    public EasyUIResult queryPageUser(Integer page, Integer rows){
        return us.queryPageUser(page,rows);
    }


    //查询单个用户信息
    @RequestMapping("item/{userId}")     //路径传参     //localhost:10001/user/item/5
    public User queryOneUser(@PathVariable Integer userId){
        return us.queryOneUser(userId);
    }


    //删除用户
    @RequestMapping("delete/{userId}")
    public SysResult deleteUser(@PathVariable Integer userId){
        try{
            us.deleteUser(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除失败!",null);
        }
    }


    //申请领养动物        //往temp表中添加数据  userId和animalId
    @RequestMapping("adopt")
    public SysResult adoptAnimal(Integer userId,Integer animalId,String userName){

        if(us.existAnimalIdInTemp(animalId)!=null&&us.existUserIdInTemp(userId)==null){   //如果temp表中已经有该动物ID,说明该动物已经被人领养,别的用户不能再领养
            //System.out.println("203");
            return SysResult.build(203,"该动物已经被其他人领养",null);
        }else if(us.existUserIdInTemp(userId)!=null&&us.existAnimalIdInTemp(animalId)==null){     //如果temp表中已经有该用户ID,就不允许该用户再领养其他的动物
            //System.out.println("204");
            return SysResult.build(204,"每人只能领养一个动物",null);
        }else if(us.existUserId(userId,animalId)==null){  //temp表中不存在userId和animalId,说明该动物处于无人领养状态
            try{
                us.adoptAnimal(userId,animalId,userName);
                //System.out.println("200");
                return SysResult.ok();
            }catch (Exception e){
                e.printStackTrace();
                //System.out.println("201");
                return SysResult.build(201,"失败!",null);
            }
        }else {     //如果temp表中存在userId和animalId,就说明一个用户点了两次,显示不能重复申请
            //System.out.println("202");
            return SysResult.build(202,"不能重复申请",null);
        }
    }


    //申请领养动物        //往temp表中添加数据  userId和animalId
    @RequestMapping("tempAnimal")
    public SysResult tempAnimal(Integer userId,Integer animalId,String userName){

        if(us.getUserType(userId) != 1){        //如果用户申请领养状态码不为1，说明用户领养过别的动物
            return SysResult.build(201,"您已经领养过其他的动物！",null);
        }else if(us.existAnimalIdInTemp(animalId)!=null){      //如果动物ID存在在temp表中，就说明该动物已经被其他人领养
            return SysResult.build(202,"该动物已被其他人领养！",null);
        }else {
            us.adoptAnimal(userId,animalId,userName);
            return SysResult.ok();
        }
    }


    //查看自己正在申请领养的动物
    @RequestMapping("check/temp")
    public Animal querTemp(Integer userId){
        return us.queryTemp(userId);
    }

    //查看自己的领养状态码
    @RequestMapping("check/type")
    public Integer checkType(Integer userId){
        return us.checkType(userId);
    }

    //查看自己被批准的可以领养的动物
    @RequestMapping("check/adopt")
    public Animal queryAdopt(Integer userId){
        return us.queryAdopt(userId);
    }


    //申请成为志愿者       改变userType从1到2
    @RequestMapping("applyVolunteer")
    public SysResult applyVolunteer(Integer userId){
        try{
            us.applyVolunteer(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"申请失败!",null);
        }
    }

    //申请成为志愿者       往volunteer表中插入数据
    @RequestMapping("insertVolunteer")
    public SysResult insertVolunteer(Volunteer volunteer){
        try{
            us.insertVolunteer(volunteer);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"申请成为志愿者失败!",null);
        }
    }

    //查看自己的志愿者状态
    @RequestMapping("check/volunteer")
    public Volunteer checkVolunteer(Integer userId) {
        return us.checkVolunteer(userId);
    }

    //领养处---模糊查询
    @RequestMapping("search")
    public EasyUIResult queryAnimal(Integer page, Integer rows,String text){
        return us.queryAnimal(page,rows,text);
    }

    //修改个人信息
    @RequestMapping("xiugai")
    public SysResult xiugai(User user){
        try{
            us.xiugai(user);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败！",null);
        }
    }


}



















