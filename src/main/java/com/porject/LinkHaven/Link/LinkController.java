package com.porject.LinkHaven.Link;

import com.porject.LinkHaven.LinkTree.LinkTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
public class LinkController {

    @Autowired
    LinkRepository linkRepository;

    @GetMapping("/{link_tree_id}")
    public Link getLink(Long id){
        return linkRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @GetMapping("/{links}")
    public List<Link> getLinks(Long id){
        return linkRepository.findByLinkTreeId(id);
    }

    @PostMapping(value = "createLink", consumes = "application/json")
    public Link createLink(@RequestBody Link link){
        link.setLinkTree(link.getLinkTree());
        return linkRepository.save(link);
    }

    @PutMapping(value = "/updateLink", consumes = "application/json")
    public ResponseEntity<Link> updateLink(@RequestBody Link link) {
        // Lade das bestehende Link-Objekt aus der Datenbank
        Link currentLink = linkRepository.findById(link.getId())
                .orElseThrow(() -> new RuntimeException("Link not found with id: " + link.getId()));

        // Aktualisiere die Felder des bestehenden Links
        currentLink.setName(link.getName());
        currentLink.setUrl(link.getUrl());

        // Speichere die Änderungen
        Link updatedLink = linkRepository.save(currentLink);

        // Rückgabe mit ResponseEntity
        return ResponseEntity.ok(updatedLink);
    }

    @DeleteMapping("/deleteLink/{id}")
    public ResponseEntity deleteLink(@PathVariable Long id) {
        linkRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
