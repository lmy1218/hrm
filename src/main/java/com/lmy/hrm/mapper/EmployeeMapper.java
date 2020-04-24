package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.EmployeeInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @date 2020/4/24 12:29
 */
@Mapper
public interface EmployeeMapper {


    @Select({
            "<script>" ,
            "            select * from employee_inf" ,
            "            where 1 = 1" ,
            "            <if test=\"name != null\">" ,
            "                and name like concat('%','${name}','%') " ,
            "            </if>" ,
            "            <if test=\"jobId != 0 and jobId != null \" >" ,
            "                and job_id = #{jobId}" ,
            "            </if>" ,
            "            <if test=\"deptId != 0  and deptId != null\" >" ,
            "                and dept_id = #{deptId}" ,
            "            </if>" ,
            "            <if test=\"cardId != null\" >" ,
            "                and card_id = #{cardId}" ,
            "            </if>" ,
            "            <if test=\"sex != 0 and sex != null\" >" ,
            "                and sex = #{sex}" ,
            "            </if>" ,
            "            <if test=\"phone != null\" >" ,
            "                and phone = #{phone}" ,
            "            </if>" ,
            "    </script>"
    })
    List<EmployeeInf> getAllByPage(EmployeeInf employeeInf);

    @Select("select * from employee_inf where card_id = #{cardId}")
    EmployeeInf getByCardId(@Param("cardId") String cardId);


    @Insert("insert into employee_inf (name, card_id, sex, job_id, education, email, phone, tel, party,qq_num, address, post_code, birthday,  race, speciality, hobby, remark, dept_id) values (#{name}, #{cardId}, #{sex}, #{jobId}, #{education}, #{email}, #{phone}, #{tel}, #{party}, #{qqNum}, #{address}, #{postCode}, #{birthday}, #{race}, #{speciality}, #{hobby}, #{remark}, #{deptId})")
    void insert(EmployeeInf employeeInf);

    @Select("select * from employee_inf where id = #{id}")
    EmployeeInf getById(@Param("id") Integer id);

    @Update("update employee_inf set name = #{name}, card_id = #{cardId}, sex = #{sex}, job_id = #{jobId}, education = #{education}, email = #{email}, phone = #{phone}, tel = #{tel}, party = #{party}, qq_num = #{qqNum}, address = #{address}, post_code = #{postCode}, birthday = #{birthday}, race = #{race}, speciality = #{speciality}, hobby = #{hobby}, remark = #{remark}, dept_id = #{deptId} where id = #{id}")
    void updateEm(EmployeeInf employeeInf);

    @Delete("delete from employee_inf where id = #{employeeId}")
    void delete(Integer employeeId);
}
