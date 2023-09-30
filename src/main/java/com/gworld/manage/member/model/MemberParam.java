package com.gworld.manage.member.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberParam {
    private String userId;
    private String name;
    private String profileImagePath;
    private boolean enabled;
    private LocalDateTime registerDate;
    private boolean isAdmin;
}
