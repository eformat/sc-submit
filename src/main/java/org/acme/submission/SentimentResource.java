package org.acme.submission;

import io.quarkus.panache.common.Sort;
import org.acme.data.Sentiment;
import org.acme.data.Submitter;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/sentiment")
public class SentimentResource {

    @GET
    public List<Sentiment> get() {
        return Sentiment.listAll(Sort.by("id"));
    }

}
