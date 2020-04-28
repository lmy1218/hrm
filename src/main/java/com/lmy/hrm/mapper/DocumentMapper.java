package com.lmy.hrm.mapper;

import com.lmy.hrm.entity.DocumentInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lmy
 * @version V1.0
 * @Project hrm
 * @Package com.lmy.hrm.mapper
 * @date 2020/4/28 13:54
 */
@Mapper
public interface DocumentMapper {

    @Select({
            "<script>" ,
            "            select * from document_inf" ,
            "            where 1 = 1" ,
            "            <if test=\"title != null\">" ,
            "                and title like concat('%','${title}','%')" ,
            "            </if>" ,
            "    </script>"
    })
    List<DocumentInf> getPage(@Param("title") String title);

    @Insert("insert into document_inf (title,filename, filetype, filebytes, remark, create_date, user_id) values(#{title}, #{filename}, #{filetype}, #{filebytes}, #{remark}, #{createDate}, #{userId})")
    void insert(DocumentInf documentInf);


    @Select("select * from document_inf where id =#{id}")
    DocumentInf getById(@Param("id") Integer id);
}
