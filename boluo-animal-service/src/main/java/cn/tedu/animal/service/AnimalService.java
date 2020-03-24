package cn.tedu.animal.service;

import cn.tedu.animal.mapper.AnimalMapper;
import com.jt.common.pojo.Animal;
import com.jt.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    private AnimalMapper am;

    //分页查询动物
    public EasyUIResult queryPageAnimal(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = am.selectAnimalCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Animal>
        Integer start = (page-1)*rows;
        List<Animal> pList = am.selectAnimalByPage(start,rows);
        result.setRows(pList);
        return result;

    }

    //查看单个动物
    public Animal queryOneAnimal(Integer animalId) {
        return am.selectAnimalById(animalId);
    }


    //管理员添加动物信息
    public void addAnimal(Animal animal) {
        am.insertAnimal(animal);

    }


    public List<String> test() {
        List<String> list = am.test();
        return list;
    }
}























