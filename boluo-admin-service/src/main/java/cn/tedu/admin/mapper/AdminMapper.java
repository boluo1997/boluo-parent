package cn.tedu.admin.mapper;

import com.jt.common.pojo.Admin;
import com.jt.common.pojo.Adopt;
import com.jt.common.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    //admin login function
    Admin selectAdminByAdminNameAndPassword(Admin admin);

    Integer selectTempCount();

    //查看所有想领养动物的人员名单
    List<User> selectTempByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //批准领养      把伪领养表中的内容写到领养表中  并加入批准通过的表中
    void insertAdopt(Adopt adopt);

    Integer selectVolunteerCount();

    //查看想成为志愿者的人的名单     分页查询
    List<User> selectVolunteerByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    //批准成为志愿者
    void updateVolunteer(Integer userId);



}
























