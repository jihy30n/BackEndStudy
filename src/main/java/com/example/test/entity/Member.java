package com.example.test.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", unique = true, nullable = false)
    private Long id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String contact;

    @OneToMany(mappedBy = "member", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Board> board = new ArrayList<>();

    @Builder
    public Member(String name, String password, String email, String contact) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
    }

}
