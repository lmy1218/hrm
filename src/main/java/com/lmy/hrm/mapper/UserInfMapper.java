package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.UserInf;

import com.lmy.hrm.vo.PageModel;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @author lmy
 * @date 2020/4/21 12:42
 * @version V1.0
 */
@Mapper
public interface UserInfMapper {

    @Select("select * from user_inf where loginname = #{loginname} and  password = #{password}")
    UserInf findBynameAndpassword(@Param("loginname") String loginname, @Param("password") String password);

    @Select("select * from user_inf")
    List<UserInf> getAll();

    @Delete("delete from user_inf where id = #{userId}")
    void deleteById(@Param("userId") Integer userId);

    @Insert("insert into user_inf (loginname, password, status, createdate, username) values (#{loginname}, #{password}, #{status}, #{createdate}, #{username})")
    void insert(UserInf user);

//    @Select("select * from user_inf where username = #{username}")


    @Select({
            "<script>" ,
                    "            select * from user_inf" ,
                    "            where 1 = 1" ,
                    "            <if test=\"loginname != null and loginname != '' \">" ,
                    "                and loginname = #{loginname}" ,
                    "            </if>" ,
                    "            <if test=\"username != null \">" ,
                    "                and username like concat('%','${username}','%') " ,
                    "            </if>",
                    "            <if test=\"status != 0 \" >" ,
                    "                and status = #{status}" ,
                    "            </if>" ,
                    "    </script>"
    })
    List<UserInf> getAllByExample(@Param("loginname") String loginname, @Param("username") String username, @Param("status") Integer status);
}
