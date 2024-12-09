package com.porject.LinkHaven.Link;

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
public class Link {
    @Id
    @GeneratedValue
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "link_tree_id", nullable = false)
    private LinkTree linkTree;

    public String name;

    public String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
