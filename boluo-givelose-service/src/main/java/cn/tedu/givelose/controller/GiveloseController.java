package cn.tedu.givelose.controller;

import cn.tedu.givelose.service.GiveloseService;
import com.jt.common.pojo.Give;
import com.jt.common.pojo.Lose;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GiveloseController {

    @Autowired
    private GiveloseService gs;

    //送养信息分页查看
    @RequestMapping("give/pageManage")
    public EasyUIResult queryPageGive(Integer page, Integer rows){
        return gs.queryPageGive(page,rows);
    }

    //单个送养信息查询
    @RequestMapping("give/item/{giveId}")     //路径传参
    public Give queryOneGive(@PathVariable Integer giveId){
        return gs.queryOneGive(giveId);
    }

    //添加送养信息
    @RequestMapping("give/save")
    public SysResult addGive(Give give){
        //判断新增成功失败
        try{
            gs.addGive(give);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"添加送养信息失败!",null);
        }
    }


    //丢失动物信息分页查看
    @RequestMapping("lose/pageManage")
    public EasyUIResult queryPageLose(Integer page, Integer rows){
        return gs.queryPageLose(page,rows);
    }

    //丢失动物信息单个查看
    @RequestMapping("lose/item/{loseId}")     //路径传参
    public Lose queryOneLose(@PathVariable Integer loseId){
        return gs.queryOneLose(loseId);
    }

    //丢失动物信息添加
    @RequestMapping("lose/save")
    public SysResult addLose(Lose lose){
        //判断新增成功失败
        try{
            gs.addLose(lose);
            System.out.println(lose);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"添加丢失动物找寻信息失败!",null);
        }
    }


}