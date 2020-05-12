package cn.tedu.admin.controller;

import cn.tedu.admin.service.AdminService;
import com.jt.common.pojo.Admin;
import com.jt.common.pojo.Adopt;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService as;

    //管理员登录
    @RequestMapping("login")
    public SysResult doLogin(Admin admin){

        String ticket = as.doLogin(admin);

        if(StringUtils.isNotEmpty(ticket)){
            //登录成功
            return SysResult.ok();
        }else {
            //登录失败
            return SysResult.build(201,"登录失败",null);
        }
    }

    //查看用户信息--分页查询
    @RequestMapping("check")
    public EasyUIResult checkUser(Integer page,Integer rows){
        return as.queryPageUser(page,rows);
    }

    //删除用户
    @RequestMapping("delete/{userId}")
    public SysResult deleteUser(@PathVariable Integer userId){
        try{
            System.out.println("userId"+userId);
            as.deleteUser(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除用户失败!",null);
        }
    }

    //查看想领养动物人员的名单--分页      查看伪领养表中的内容
    @RequestMapping("pageManager")
    public EasyUIResult queryPageTemp(Integer page, Integer rows){
        return as.queryPageTemp(page,rows);
    }

    //批准领养              把伪领养表中的内容写到领养表中  并加入批准通过的表中
    @RequestMapping("pass/adopt")
    public SysResult passAdopt(Adopt adopt){
        //接收的是页面中显示的userId和animalId     可以在此处加一个后端校验(service)
        try{
            as.passAdopt(adopt);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"批准失败!",null);
        }
    }


    //拒绝领养                     把伪领养表中的内容删除 把用户领养状态码改为4
    @RequestMapping("refuse/adopt")
    public SysResult refuseAdopt(Adopt adopt){
        //接收的是页面中显示的userId和animalId
        try{
            as.refuseAdopt(adopt);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"批准失败!",null);
        }
    }


    //查看申请成为志愿者人员名单     分页查看
    @RequestMapping("queryVolunteer")
    public EasyUIResult queryPageVolunteer(Integer page, Integer rows){
        return as.queryPageVolunteer(page,rows);
    }


    //批准成为志愿者
    @RequestMapping("pass/volunteer")
    public SysResult passVolunteer(Integer userId){
        try{
            as.passVolunteer(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"批准失败!",null);
        }
    }

    //拒绝成为志愿者
    @RequestMapping("refuse/volunteer")
    public SysResult refuseVolunteer(Integer userId){
        try{
            as.refuseVolunteer(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"批准失败!",null);
        }
    }

    
    //查看志愿者名单
    @RequestMapping("queryAlreadyVolunteer")
    public EasyUIResult queryPageAlreadyVolunteer(Integer page, Integer rows){
        return as.queryPageAlreadyVolunteer(page,rows);
    }

    //分页查看评论
    @RequestMapping("queryCheckComment")
    public EasyUIResult queryCheckComment(Integer page, Integer rows){
        return as.queryCheckComment(page,rows);
    }

    //删除评论
    @RequestMapping("deleteComment")
    public SysResult deleteComment(Integer leaveId){
        try{
            as.deleteComment(leaveId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除用户失败!",null);
        }
    }


    //送养动物信息管理--删除
    @RequestMapping("deleteAnimal/{animalId}")
    public SysResult deleteAnimal(@PathVariable Integer animalId){
        try{
            as.deleteAnimal(animalId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除用户失败!",null);
        }
    }

    //丢失动物信息管理--删除
    @RequestMapping("deleteLose/{loseId}")
    public SysResult deleteLose(@PathVariable Integer loseId){
        try{
            as.deleteLose(loseId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除用户失败!",null);
        }
    }

    //查看领养名单
    @RequestMapping("queryAdoption")
    public EasyUIResult queryAdoption(Integer page, Integer rows){
        return as.queryAdoption(page,rows);
    }


}
