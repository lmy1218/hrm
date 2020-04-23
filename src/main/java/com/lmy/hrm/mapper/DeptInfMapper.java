package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.DeptInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @date 2020/4/23 11:21
 */
@Mapper
public interface DeptInfMapper {


    @Select({
            "<script>" ,
            "            select * from dept_inf" ,
            "            where 1 = 1" ,
            "            <if test=\"name != null\">" ,
            "                and name like concat('%','${name}','%')" ,
            "            </if>" ,
            "    </script>"
    })
    List<DeptInf> getAllByPage(@Param("name") String name);


    @Insert("insert into dept_inf (name, remark) values(#{name}, #{remark})")
    void insert(DeptInf deptInf);

    @Select("select * from dept_inf where id = #{id}")
    DeptInf getById(Integer id);

    @Update("update dept_inf set name = #{name}, remark = #{remark} where id = #{id}")
    void updateDept(DeptInf deptInf);

    @Delete("delete from dept_inf where id = #{deptId}")
    void delete(@Param("deptId") Integer deptId);
}
