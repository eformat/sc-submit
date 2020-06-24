package org.acme.test;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.data.Sentiment;
import org.acme.data.Submission;
import org.acme.data.Submitter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class SubmissionTests {

    @Test
    public void testPanacheMocking() {
        PanacheMock.mock(Submission.class);

        // Mocked classes always return a default value
        Assertions.assertEquals(0, Submission.count());

        Mockito.when(Submission.count()).thenReturn(23l);
        Assertions.assertEquals(23, Submission.count());

        Submission submission = new Submission();
        submission.location_lat = 144.00001f;
        submission.location_lat = -34.4554646f;

        Submitter submitter = new Submitter();
        submitter.device_id = "9987374734737743";

        Sentiment sentiment = new Sentiment();
        sentiment.capacity = 95;
        sentiment.route_direction = "City";
        sentiment.route_number = "111";
        sentiment.stop_name = "The Hill";
        sentiment.vibe = 40;

        submission.sentiment = sentiment;
        submission.submitter = submitter;

        List ls = new ArrayList();
        ls.add(submission);

        Mockito.when(Submission.listAll()).thenReturn(ls);
        Assertions.assertNotNull(Submission.listAll());

        //submission.persist();

    }
}
