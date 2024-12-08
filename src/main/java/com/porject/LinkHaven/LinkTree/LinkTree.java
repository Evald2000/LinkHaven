package com.porject.LinkHaven.LinkTree;

import com.porject.LinkHaven.Link.Link;
import com.porject.LinkHaven.User.Customer;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Component
@Entity
public class LinkTree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @OneToMany(mappedBy = "linkTree", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Link> links;

    public String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public Date created;
}
