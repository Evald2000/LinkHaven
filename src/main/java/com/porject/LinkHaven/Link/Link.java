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

}
