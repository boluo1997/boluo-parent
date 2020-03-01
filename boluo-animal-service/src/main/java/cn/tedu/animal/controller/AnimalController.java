package cn.tedu.animal.controller;

import cn.tedu.animal.service.AnimalService;
import com.jt.common.pojo.Animal;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalService as;

    //动物查询分页    /animal/pageManage?page=1&rows=5
    @RequestMapping("pageManage")
    public EasyUIResult queryPageAnimal(Integer page, Integer rows){
        return as.queryPageAnimal(page,rows);
    }

    //单个动物查询
    @RequestMapping("item/{animalId}")     //路径传参
    public Animal queryOneAnimal(@PathVariable Integer animalId){
        return as.queryOneAnimal(animalId);
    }

    //管理员添加动物信息     //localhost:10002/animal/save?animalName=斌哥&animalImage=f.jpg&animalType=狗&animalInfo=一只哈士奇
    @RequestMapping("save")
    public SysResult addAnimal(Animal animal){
        System.out.println("进来了");
        //判断新增成功失败
        try{
            as.addAnimal(animal);
            return SysResult.ok();
        }catch(Exception e){
            e.printStackTrace();
            return SysResult.build(201,"新增失败",null);

        }
    }


}
