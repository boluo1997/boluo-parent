package cn.tedu.givelose.service;

import cn.tedu.givelose.mapper.GiveloseMapper;
import com.jt.common.pojo.Give;
import com.jt.common.pojo.Lose;
import com.jt.common.vo.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiveloseService {

    @Autowired
    private GiveloseMapper gm;

    //分页查询送养信息
    public EasyUIResult queryPageGive(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = gm.selectGiveCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Give>
        Integer start = (page-1)*rows;
        List<Give> pList = gm.selectGiveByPage(start,rows);
        result.setRows(pList);
        return result;

    }

    //查询单个送养信息
    public Give queryOneGive(Integer giveId) {
        return gm.selectGiveById(giveId);
    }

    //添加送养信息
    public void addGive(Give give) {
        gm.insertGive(give);
    }



    //分页查询丢失动物信息
    public EasyUIResult queryPageLose(Integer page, Integer rows) {
        //准备一个返回对象
        EasyUIResult result = new EasyUIResult();
        //封装total
        Integer total = gm.selectLoseCount();
        result.setTotal(total);

        //封装返回分页数据rows List<Give>
        Integer start = (page-1)*rows;
        List<Give> pList = gm.selectLoseByPage(start,rows);
        result.setRows(pList);
        return result;

    }

    //单个丢失动物找寻信息
    public Lose queryOneLose(Integer loseId) {
        return gm.selectLoseById(loseId);
    }

    public void addLose(Lose lose) {
        gm.insertLose(lose);
    }
}
