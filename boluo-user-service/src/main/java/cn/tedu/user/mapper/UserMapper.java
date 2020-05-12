package cn.tedu.user.mapper;

import com.jt.common.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Objects;

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

    //判断是否重复申请
    Temp selectStatusByUserIdAndAnimalId(@Param("userId") Integer userId,@Param("animalId") Integer animalId);

    //判断temp表中是否有animalId
    Temp selectStatusByAnimalId(Integer animalId);

    //判断temp表中是否有userId
    Temp selectStatusByUserId(Integer userId);

    //得到用户的申请领养状态码 判断用户是否已经领养过别的动物
    Integer getUserType(Integer userId);

    //改变用户的状态码为2--代表已经领养过动物，正在等待管理员审核
    void changeUserType2(Integer userId);

    //查看自己正在申请领养的动物
    Animal selectTemp(Integer userId);

    //查看自己被批准的可以领养的动物
    Animal selectAdoptByUserId(Integer userId);

    //申请成为志愿者
    void updateUserById(Integer userId);

    //往volunteer表中插入数据
    void insertVolunteer(Volunteer volunteer);

    //查看自己的志愿者状态
    Volunteer checkVolunteer(Integer userId);

    //领养处---模糊查询---查询出的动物总数量
    Integer selectAnimalCount();

    //领养处---模糊查询
    List<Animal> selectAnimalByPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("text")String text);

    //查看自己的领养状态码
    Integer checkType(Integer userId);

}
