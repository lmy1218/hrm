package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.DeptInf;
import com.lmy.hrm.entity.JobInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @date 2020/4/24 11:04
 */
@Mapper
public interface JobInfMapper {

    @Select({
            "<script>" ,
            "            select * from job_inf" ,
            "            where 1 = 1" ,
            "            <if test=\"name != null\">" ,
            "                and name like concat('%','${name}','%')" ,
            "            </if>" ,
            "    </script>"
    })
    List<JobInf> getAllByPage(@Param("name") String name);

    @Insert("insert into job_inf (name, remark) values(#{name}, #{remark})")
    void insert(JobInf jobInf);

    @Select("select * from job_inf where id = #{id}")
    JobInf getById(Integer id);

    @Update("update job_inf set name = #{name}, remark = #{remark} where id = #{id}")
    void updateJob(JobInf jobInf);

    @Delete("delete from job_inf where id = #{jobId}")
    void delete(@Param("jobId") Integer jobId);

    @Select("select * from job_inf")
    List<JobInf> getAll();
}
