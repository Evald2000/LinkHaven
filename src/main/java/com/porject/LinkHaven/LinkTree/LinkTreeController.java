package com.porject.LinkHaven.LinkTree;

import com.porject.LinkHaven.User.Customer;
import com.porject.LinkHaven.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class LinkTreeController {

    @Autowired
    LinkTreeRepository linkTreeRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/createLinktree", consumes = "application/json")
    public LinkTree createLinkTree(@RequestBody LinkTree linkTree) {
        linkTree.setCustomer(userRepository.findById(linkTree.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer not found with id: " + linkTree.getId())));
        return linkTreeRepository.save(linkTree);
    }

    @PutMapping(value = "/updateLinktree", consumes = "application/json")
    public LinkTree updateLinktree(@RequestBody LinkTree linktree){
        LinkTree currentLinktree = linkTreeRepository.findById(linktree.getId()).orElseThrow(() -> new RuntimeException("Linktree not found with id: " + linktree.getId()));
        currentLinktree.setLinks(linktree.getLinks());
        currentLinktree.setName(linktree.getName());
        currentLinktree = linkTreeRepository.save(linktree);
        return ResponseEntity.ok(currentLinktree).getBody();
    }

    @GetMapping("/{id}")
    public LinkTree getLinktree(@PathVariable Long id) {
        return linkTreeRepository.findById(id).orElseThrow(RuntimeException::new);
    }







}
