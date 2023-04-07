package com.example.loading.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String contents;

    private Long view;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer")
    private Member writer;

    public Board(){}

    public Board(String title, String contents, long view, Member writer) {
        this.title = title;
        this.contents = contents;
        this.view = view;
        this.writer = writer;
    }
}
