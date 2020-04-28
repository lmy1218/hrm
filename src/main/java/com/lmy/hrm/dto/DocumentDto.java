package com.lmy.hrm.dto;
/**
 * @Project hrm
 * @Package com.lmy.hrm.dto
 * @author lmy
 * @date 2020/4/28 16:12
 * @version V1.0
 */

import com.lmy.hrm.entity.DocumentInf;
import com.lmy.hrm.entity.UserInf;
import lombok.Data;

/**
 * @author lmy
 * @ClassName DocumentDto
 * @Description TODO
 * @date 2020/4/28 16:12
 **/

public class DocumentDto extends DocumentInf {

    private UserInf user;

    public UserInf getUser() {
        return user;
    }

    public void setUser(UserInf user) {
        this.user = user;
    }
}
