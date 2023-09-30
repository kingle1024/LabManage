package com.gworld.manage.member.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
public class MemberInput {
    @Email(message = "아이디는 이메일 형식으로 사용 가능합니다.")
    @Size(max = 30, message = "아이디는 30자 이하로 사용 가능합니다.")
    private String userId;
    @Size(max = 10, message= "이름은 10자 이하까지 사용 가능합니다.")
    private String name;
    @Size(max = 50, message = "패스워드는 50자 이하까지 사용 가능합니다.")
    private String password;
    @Size(max = 50, message = "패스워드는 50자 이하까지 사용 가능합니다.")
    private String rePassword;
    private String profileImagePath;
    private boolean enabled;
    private LocalDateTime registerDate;
    private boolean isAdmin;
}
