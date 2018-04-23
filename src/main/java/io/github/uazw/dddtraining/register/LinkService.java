package io.github.uazw.dddtraining.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkGenerator linkGenerator;
    private LinkDao linkDao;

    @Autowired
    public LinkService(LinkGenerator linkGenerator, LinkDao linkDao) {
        this.linkGenerator = linkGenerator;
        this.linkDao = linkDao;
    }

    public Link createLink(String email) {
        Link link = new Link(email, linkGenerator.generator());
        linkDao.save(link);
        return link;

    }

    public Link byId(String linkIdentifier) {
        return linkDao.byId(linkIdentifier);
    }
}
