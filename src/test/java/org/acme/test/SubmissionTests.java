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
        submission.diagnosed_covid19 = "0";
        submission.fever_status = false;
        submission.fever_temp = 0f;
        submission.location_country_code = "NZ";
        submission.location_lat = 144.00001f;
        submission.location_lat = -34.4554646f;
        submission.location_postal_code = "40987";
        submission.symptom_cough = "0";
        submission.symptom_difficult_to_breath = "0";
        submission.symptom_muscle_pain = "0";
        submission.symptom_sore_throat = "0";

        Submitter submitter = new Submitter();
        submitter.birth_year = 1990;
        submitter.device_id = "9987374734737743";
        submitter.gender = "F";

        Sentiment sentiment = new Sentiment();
        sentiment.capacity = 95;
        sentiment.route_direction = "City";
        sentiment.route_number = "111";
        sentiment.stop_name = "The Hill";
        sentiment.vibe = "angry";

        submission.sentiment = sentiment;
        submission.submitter = submitter;

        List ls = new ArrayList();
        ls.add(submission);

        Mockito.when(Submission.listAll()).thenReturn(ls);
        Assertions.assertNotNull(Submission.listAll());

        //submission.persist();

    }
}
