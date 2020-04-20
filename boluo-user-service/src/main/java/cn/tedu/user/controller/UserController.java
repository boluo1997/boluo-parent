package cn.tedu.user.controller;

import cn.tedu.user.service.UserService;
import com.jt.common.pojo.*;
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

        System.out.println("进来了!");
        System.out.println(user);

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


    //申请防疫物资,申请成功之后把userStatus状态从1改为2,代表已经申请
    @RequestMapping("shenqing")
    public SysResult shenqing(Shenqing shenqing){
        try{
            us.shenqing(shenqing);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"申请失败!",null);
        }
    }


    //查看自己物资申请状态        1代表还没批准    2代表已经批准
    @RequestMapping("chashenqing")
    public String chashenqing(Integer userId){
        return us.chashenqing(userId);
    }

    //修改个人信息
    @RequestMapping("xiugai")
    public SysResult xiugai(User user){
        try{
            System.out.println("修改进来了!");
            System.out.println(user);
            us.xiugai(user);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败!",null);
        }
    }

    //查看文章---分页
    @RequestMapping("wenzhang")
    public EasyUIResult wenzhang(Integer page, Integer rows){
        System.out.println("进来了!");
        return us.wenzhang(page,rows);
    }

    //查看单个文章
    @RequestMapping("wenzhang1/{wenzhangId}")     //路径传参     //localhost:10001/user/item/5
    public Wenzhang queryOneWenzhang(@PathVariable Integer wenzhangId){
        return us.queryOneWenzhang(wenzhangId);
    }

    //留言
    @RequestMapping("liuyan")
    public SysResult liuyan(Message message){
        try{
            us.liuyan(message);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"留言失败!",null);
        }

    }

    //查看留言(根据文章)(用户)
    @RequestMapping("chakanliuyan")
    public EasyUIResult chakanliuyan(Integer page, Integer rows,Integer wenzhangId){
        System.out.println("进来了!");
        return us.chakanliuyan(page,rows,wenzhangId);
    }

    //查看所有评论(管理员)
    @RequestMapping("allpinglun")
    public EasyUIResult allpinglun(Integer page, Integer rows){
        System.out.println("进来了!");
        return us.allpinglun(page,rows);
    }

    //查看患者人数
    @RequestMapping("huanzhe")
    public EasyUIResult huanzhe(Integer page, Integer rows){
        return us.huanzhe(page,rows);
    }

    //全文检索
    @RequestMapping("jiansuo")
    public EasyUIResult jiansuo(Integer page, Integer rows,String text){
        System.out.println("进来了!");
        return us.jiansuo(page,rows,text);
    }


    //宿舍报修申请表
    @RequestMapping("")
    public SysResult shenqingFix(Fix fix){
        try{
            us.shenqingFix(fix);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"申请失败!",null);
        }
    }


}



















