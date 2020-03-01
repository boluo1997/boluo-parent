package cn.tedu.givelose.mapper;

import com.jt.common.pojo.Give;
import com.jt.common.pojo.Lose;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiveloseMapper {

    Integer selectGiveCount();

    //分页查看送养信息
    List<Give> selectGiveByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //送养信息单个查看
    Give selectGiveById(Integer giveId);

    //添加送养信息
    void insertGive(Give give);



    Integer selectLoseCount();

    //分页查询丢失动物找寻信息
    List<Give> selectLoseByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //单个丢失动物找寻信息
    Lose selectLoseById(Integer loseId);

    //添加丢失动物找寻信息
    void insertLose(Lose lose);
}
