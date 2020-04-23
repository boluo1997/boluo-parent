package cn.tedu.admin.mapper;

import com.jt.common.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    //admin login function
    Admin selectAdminByAdminNameAndPassword(Admin admin);


    Integer selectUserCount();


    List<User> selectUserByPage(@Param("start") Integer start,@Param("rows") Integer rows);


    void deleteUserByUserId(Integer userId);

    Integer selectTempCount();

    //
    List<User> selectTempByPage(@Param("start") Integer start,@Param("rows") Integer rows);


    void insertAdopt(Adopt adopt);


    void updateTemp(Integer userId);

    Integer selectVolunteerCount();


    List<Volunteer> selectVolunteerByPage(@Param("start") Integer start,@Param("rows") Integer rows);


    void updateVolunteer(Integer userId);


    Integer selectAlreadyVolunteerCount();


    List<Volunteer> selectAlreadyVolunteerByPage(@Param("start") Integer start,@Param("rows") Integer rows);


    //查看申请表数量
    Integer selectShenqingCount();

    //查看申请表
    List<Volunteer> selectShenqingByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //把当前申请表的对象获取
    Goods goods();

    //批准物资
    void pizhun(Integer userId);

    //添加文章
    void wenzhang(Wenzhang wenzhang);

    //删除文章
    void shanwen(Integer wenzhangId);

    //从申请表中把该条信息删除
    void shanshenqing(Integer userId);

    //删除评论
    void shanping(Integer messageId);

    //修改患者人数
    void xiugaihuanzhe(Huanzhe huanzhe);

    //查询物资总数量
    Integer selectGoodsCount();

    //查看物资剩余数量
    List<Goods> selectGoodsByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //修改口罩数量
    void kouzhao(Integer kouzhao);

    //修改消毒水数量
    void xiaodu(Integer xiaodu);

    //修改体温计数量
    void tiwen(Integer tiwen);

    int shenqingTy(Integer userId);

    //发放完物资之后把剩余物资数更新
    void fafang(Goods goods);

    //查看用户名是否存在
    int selectUserCountByUserName(String userName);

    //注册
    void insertFixer(Fixer fixer);

    //维修人员登录之前查看存在不存在该账号
    Fixer selectFixerByUserNameAndPassword(Fixer fixer);

    //查询Fix表中搜索出的数据量
    Integer selectFixCount();

    //分页查看Fix表中数据
    List<Fix> selectFixByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //维修人员接单,把数据存到handle表中
    void handle(Handle handle);

    //把用户的状态码改为3,代表维修人员已经接受
    void changeUserStatus(int userId);

    //查看handle表中的数量
    Integer selectHandleCount();

    //查看我的任务
    List<Fix> selectHandleByPage(@Param("start") Integer start,@Param("rows") Integer rows,@Param("fixId") Integer fixId);

    //维修人员完成订单
    void finishHandle(Integer handle);

    //把用户状态码改为4
    void changeUserStatus4(Integer userId);

    //维修人员查看自己已经完成的任务
    List<Fix> selectHandleByPage2(@Param("start") Integer start,@Param("rows") Integer rows,@Param("fixId") Integer fixId);
}
























