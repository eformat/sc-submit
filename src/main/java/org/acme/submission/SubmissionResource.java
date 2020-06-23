package org.acme.submission;

import io.quarkus.panache.common.Sort;
import org.acme.data.Sentiment;
import org.acme.data.Submission;
import org.acme.data.Submitter;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/submission")
public class SubmissionResource {

    @GET
    public List<Submission> get() {
        return Submission.listAll(Sort.by("id"));
    }

    @GET
    @Path("{id}")
    public Submission getSingle(@PathParam Long id) {
        Submission entity = Submission.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Form with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(Submission submission) {
        if (submission.id != null) {
            throw new WebApplicationException("ID was invalidly set on request.", 422);
        }
        Submitter submitter = submission.getSubmitter();
        Submitter exists = Submitter.findByDeviceId(submitter.device_id);
        if (null != exists) {
            submission.submitter = exists;
        }
        submission.persist();
        return Response.ok(submission).status(201).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam Long id) {
        Submission entity = Submission.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Form with id of " + id + " does not exist.", 404);
        }
        entity.delete();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/killer")
    @Transactional
    @Operation(operationId = "killer",
            summary = "⚡ remove all data ⚡",
            description = "This operation deletes all data from the database",
            deprecated = false,
            hidden = false)
    public void submissionsKiller() {
        Submission.deleteAll();
        Submitter.deleteAll();
        Sentiment.deleteAll();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {
        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                    .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
                    .build();
        }
    }

}
