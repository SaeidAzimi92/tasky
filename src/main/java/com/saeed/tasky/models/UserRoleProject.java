package com.saeed.tasky.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleProject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Project project;
    @OneToOne
    private User user;
    @OneToOne
    private Role role;

    public UserRoleProject(Project project, User user, Role role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }
}