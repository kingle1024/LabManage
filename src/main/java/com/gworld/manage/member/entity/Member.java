package com.gworld.manage.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Member {
    @Id
    private String userId;
    private String name;
    private String password;
    private String profileImagePath;
    private boolean enabled;
    private LocalDateTime register_date;
    private boolean adminYn;
}
