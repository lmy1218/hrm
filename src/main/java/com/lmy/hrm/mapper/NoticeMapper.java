package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.NoticeInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @date 2020/4/28 17:40
 */
@Mapper
public interface NoticeMapper {


    @Select({
            "<script>" ,
            "            select * from notice_inf" ,
            "            where 1 = 1" ,
            "            <if test=\"name != null\">" ,
            "                and name like concat('%','${name}','%')" ,
            "            </if>" ,
            "    </script>"
    })
    List<NoticeInf> getAllByPage(@Param("name") String name);
}
