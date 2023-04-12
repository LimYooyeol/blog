package com.lback.blog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {
    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    @Override
    public String toString(){
        return "\nid: " + id + "\n" +
                "name : " + name + "\n" +
                "members : \n" + members.toString() + "\n";
    }

    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    }
}
