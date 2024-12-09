package com.porject.LinkHaven.Link;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByLinkTreeId(Long linktreeId);
}
