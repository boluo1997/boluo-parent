package cn.tedu.user.mapper;

import com.jt.common.pojo.Adopt;
import com.jt.common.pojo.Temp;
import com.jt.common.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int selectUserCountByUserName(String userName);

    void insertUser(User user);

    User selectUserByUserNameAndPassword(User user);

    User selectUserByUserNameAndPassword2(@Param("userName") String name, @Param("userPassword") String password);

    Integer selectUserCount();

    //分页查询用户
    List<User> selectUserByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //单个查询用户
    User selectUserById(Integer userId);

    //删除单个用户
    void deleteUserById(Integer userId);

    //把领养信息暂时存入领养表中
    void insertTemp(@Param("userId") Integer userId,@Param("animalId") Integer animalId,@Param("userName")String userName);

    //判断temp表中是否有animalId
    Temp selectStatusByAnimalId(Integer animalId);

    //判断temp表中是否有userId
    Temp selectStatusByUserId(Integer userId);

    Integer selectAdoptCount();

    //查看自己被批准的可以领养的动物
    List<User> selectAdoptByPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("userId") Integer userId);

    //申请成为志愿者
    void updateUserById(Integer userId);

    //判断是否重复申请
    Temp selectStatusByUserIdAndAnimalId(@Param("userId") Integer userId,@Param("animalId") Integer animalId);


}
