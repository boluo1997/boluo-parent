package cn.tedu.user.controller;

import cn.tedu.user.service.UserService;
import com.jt.common.pojo.User;
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
    @RequestMapping("login")        //
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

        if(us.existUserId(userId,animalId)==null){
            try{
                us.adoptAnimal(userId,animalId,userName);
                return SysResult.ok();
            }catch (Exception e){
                e.printStackTrace();
                return SysResult.build(201,"失败!",null);
            }
        }else {     //返回的有数据
            return SysResult.build(202,"不能重复申请",null);
        }


    }


    //查看自己被批准的可以领养的动物
    @RequestMapping("check/adopt")
    public EasyUIResult queryPageAdopt(Integer page, Integer rows, Integer userId){
        return us.queryPageAdopt(page,rows,userId);
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

}



















