package cn.tedu.animal.mapper;

import com.jt.common.pojo.Animal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnimalMapper {

    Integer selectAnimalCount();

    List<Animal> selectAnimalByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查看单个动物
    Animal selectAnimalById(Integer animalId);

    //管理员添加动物
    void insertAnimal(Animal animal);

}
