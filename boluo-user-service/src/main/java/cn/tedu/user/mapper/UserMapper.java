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

    //申请防疫物资
    void shenqing(Shenqing shenqing);

    //修改个人信息
    void xiugai(User user);

    //查看文章数量
    Integer selectWenzhangCount();

    //分页查看文章
    List<Wenzhang> selectWenzhangByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //查看单个文章
    Wenzhang selectWenzhangById(Integer wenzhangId);

    //查看自己物资申请的状态
    String chashenqing(Integer userId);

    //留言
    void liuyan(Message message);

    //查询评论数
    Integer selectmessageCount();

    //批量查看评论
    List<Message> selectMessageByPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("wenzhangId") Integer wenzhangId);

    //查询所有评论数
    Integer selectallmessage();

    //查看所有评论
    List<Message> selectallMessage(@Param("start") Integer start,@Param("rows") Integer rows);

    //查询所有患者数量
    Integer selectAllHuanzhe();

    //查看所有患者数据
    List<Huanzhe> selectHuanzheByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //全文检索
    List<Wenzhang> jiansuo(@Param("start") Integer start, @Param("rows") Integer rows,@Param("text") String text);

    //全文检索出的数量
    Integer jiansuoCount();
}
