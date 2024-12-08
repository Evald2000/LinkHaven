package com.porject.LinkHaven.User;

import com.porject.LinkHaven.LinkTree.LinkTree;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Component
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @OneToOne(mappedBy = "customer", fetch = FetchType.LAZY)
    private LinkTree linkTree;

    public String username;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LinkTree getLinkTree() {
        return linkTree;
    }

    public void setLinkTree(LinkTree linkTree) {
        this.linkTree = linkTree;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
