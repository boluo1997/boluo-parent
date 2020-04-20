package cn.tedu.admin.controller;

import cn.tedu.admin.service.AdminService;
import com.jt.common.pojo.*;
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


    //查看申请物资状况
    @RequestMapping("chakanshenqing")
    public EasyUIResult chakanshenqing(Integer page, Integer rows){
        return as.chakanshenqing(page,rows);
    }

    //批准物资给用户
    @RequestMapping("pizhun")
    public SysResult pizhun(Integer userId){
        try{

            //先根据用户ID把需求的物资找出来
            int shenqingTy = as.shenqingTy(userId);
            System.out.println(shenqingTy);

            //然后先获取当前Shenqing表对象,根据用户需求的物资把物资数量-1
            //再根据这个改过的对象中的值,修改物资表中的数据

            Goods goods = as.goods();      //获取到了唯一的一个goods_id为1的申请表对象
            if(shenqingTy == 1){        //口罩
                goods.setGoodsKouzhao(goods.getGoodsKouzhao()-10);  //发放10个口罩
                as.fafang(goods);
            }else if(shenqingTy == 2){  //消毒水
                goods.setGoodsXiaodu(goods.getGoodsXiaodu()-1);
                as.fafang(goods);
            }else if(shenqingTy == 3){  //体温计
                goods.setGoodsTiwen(goods.getGoodsTiwen()-1);
                as.fafang(goods);
            }else if(shenqingTy == 4){  //口罩+消毒水
                goods.setGoodsKouzhao(goods.getGoodsKouzhao()-10);
                goods.setGoodsXiaodu(goods.getGoodsXiaodu()-1);
                as.fafang(goods);
            }else if(shenqingTy == 5){  //口罩+体温计
                goods.setGoodsKouzhao(goods.getGoodsKouzhao()-10);
                goods.setGoodsTiwen(goods.getGoodsTiwen()-1);
                as.fafang(goods);
            }else if(shenqingTy == 6){  //消毒水+体温计
                goods.setGoodsXiaodu(goods.getGoodsXiaodu()-1);
                goods.setGoodsTiwen(goods.getGoodsTiwen()-1);
                as.fafang(goods);
            }else if(shenqingTy == 7){  //口罩+消毒水+体温计
                goods.setGoodsKouzhao(goods.getGoodsKouzhao()-10);
                goods.setGoodsXiaodu(goods.getGoodsXiaodu()-1);
                goods.setGoodsTiwen(goods.getGoodsTiwen()-1);
                as.fafang(goods);
            }


            //把用户的申请状态码改变
            as.pizhun(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"批准失败!",null);
        }
    }

    //从申请表中把该条信息删除
    @RequestMapping("shanshenqing")
    public SysResult shanshenqing(Integer userId){
        try{
            as.shanshenqing(userId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除失败!",null);
        }
    }

    //添加文章
    @RequestMapping("wenzhang")
    public SysResult wenzhang(Wenzhang wenzhang){
        try{
            as.wenzhang(wenzhang);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"添加失败!",null);
        }
    }

    //删除文章
    @RequestMapping("shanwen/{wenzhangId}")
    public SysResult shanwen(@PathVariable Integer wenzhangId){
        try{
            as.shanwen(wenzhangId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除失败!",null);
        }
    }

    //删除评论
    @RequestMapping("shanping/{messageId}")
    public SysResult shanping(@PathVariable Integer messageId){
        try{
            as.shanping(messageId);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"删除失败!",null);
        }
    }

    //修改患者人数
    @RequestMapping("xiugaihuanzhe")
    public SysResult xiugaihuanzhe(Huanzhe huanzhe){
        try{
            as.xiugaihuanzhe(huanzhe);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败!",null);
        }
    }

    //查看物资数量
    @RequestMapping("goods")
    public EasyUIResult goods(Integer page, Integer rows){
        return as.goods(page,rows);
    }

    //修改口罩数量
    @RequestMapping("kouzhao")
    public SysResult kouzhao(Integer kouzhao){
        try{
            as.kouzhao(kouzhao);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败!",null);
        }
    }

    //修改消毒水数量
    @RequestMapping("xiaodu")
    public SysResult xiaodu(Integer xiaodu){
        try{
            as.xiaodu(xiaodu);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败!",null);
        }
    }

    //修改体温计数量
    @RequestMapping("tiwen")
    public SysResult tiwen(Integer tiwen){
        try{
            as.tiwen(tiwen);
            return SysResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return SysResult.build(201,"修改失败!",null);
        }
    }

}
