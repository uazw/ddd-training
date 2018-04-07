package io.github.uazw.dddtraining.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkGenerator linkGenerator;
    private LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkGenerator linkGenerator, LinkRepository linkRepository) {
        this.linkGenerator = linkGenerator;
        this.linkRepository = linkRepository;
    }

    public Link createLink(String email) {
        Link link = new Link(email, linkGenerator.generator());
        linkRepository.save(link);
        return link;

    }

    public Link byId(String linkIdentifer) {
        return linkRepository.byId(linkIdentifer);
    }
}
