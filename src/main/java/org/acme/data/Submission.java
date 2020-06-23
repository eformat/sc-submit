package org.acme.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity(name="submissions")
public class Submission extends PanacheEntityBase {

    /*
mysql> describe submissions;
+-----------------------------+-------------+------+-----+-------------------+-----------------------------------------------+
| Field                       | Type        | Null | Key | Default           | Extra                                         |
+-----------------------------+-------------+------+-----+-------------------+-----------------------------------------------+
| id                          | bigint      | NO   | PRI | NULL              | auto_increment                                |
| diagnosed_covid19           | varchar(1)  | YES  |     | NULL              |                                               |
| fever_status                | bit(1)      | YES  |     | NULL              |                                               |
| fever_temp                  | float       | YES  |     | NULL              |                                               |
| location_country_code       | varchar(2)  | YES  |     | NULL              |                                               |
| location_lat                | float       | YES  |     | NULL              |                                               |
| location_lng                | float       | YES  |     | NULL              |                                               |
| location_postal_code        | varchar(10) | YES  |     | NULL              |                                               |
| new_device_id               | int         | YES  |     | NULL              |                                               |
| symptom_cough               | varchar(1)  | YES  |     | NULL              |                                               |
| symptom_difficult_to_breath | varchar(1)  | YES  |     | NULL              |                                               |
| symptom_muscle_pain         | varchar(1)  | YES  |     | NULL              |                                               |
| symptom_sore_throat         | varchar(1)  | YES  |     | NULL              |                                               |
| timestamp_created           | timestamp   | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| timestamp_modified          | timestamp   | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| sentiment_id                | bigint      | YES  | MUL | NULL              |                                               |
| submitter_id                | bigint      | YES  | MUL | NULL              |                                               |
+-----------------------------+-------------+------+-----+-------------------+-----------------------------------------------+
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public Long id;

    @Generated(GenerationTime.INSERT)
    @Basic(optional = false)
    @Column(name = "timestamp_created", insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    public Date timestamp_created;// = new java.sql.Date(new java.util.Date().getTime());

    @Generated(GenerationTime.ALWAYS)
    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp_modified", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Date timestamp_modified;// = new java.sql.Date(new java.util.Date().getTime());

    // fevermap fields
    @Column(length = 1)
    public boolean fever_status;
    public Float fever_temp;
    @Column(length = 2)
    public String location_country_code;
    @Column(length = 10)
    public String location_postal_code;
    public Float location_lng;
    public Float location_lat;
    @Column(length = 1)
    public String symptom_difficult_to_breath;
    @Column(length = 1)
    public String symptom_cough;
    @Column(length = 1)
    public String symptom_sore_throat;
    @Column(length = 1)
    public String symptom_muscle_pain;
    @Column(length = 1)
    public String diagnosed_covid19;
//    @Column(length = 20)
//    public Integer new_device_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "submitter_id")
    public Submitter submitter;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sentiment_id")
    public Sentiment sentiment;

    public boolean isFever_status() {
        return fever_status;
    }

    public void setFever_status(boolean fever_status) {
        this.fever_status = fever_status;
    }

    public Float getFever_temp() {
        return fever_temp;
    }

    public void setFever_temp(Float fever_temp) {
        this.fever_temp = fever_temp;
    }

    public String getLocation_country_code() {
        return location_country_code;
    }

    public void setLocation_country_code(String location_country_code) {
        this.location_country_code = location_country_code;
    }

    public String getLocation_postal_code() {
        return location_postal_code;
    }

    public void setLocation_postal_code(String location_postal_code) {
        this.location_postal_code = location_postal_code;
    }

    public Float getLocation_lng() {
        return location_lng;
    }

    public void setLocation_lng(Float location_lng) {
        this.location_lng = location_lng;
    }

    public Float getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(Float location_lat) {
        this.location_lat = location_lat;
    }

    public String getSymptom_difficult_to_breath() {
        return symptom_difficult_to_breath;
    }

    public void setSymptom_difficult_to_breath(String symptom_difficult_to_breath) {
        this.symptom_difficult_to_breath = symptom_difficult_to_breath;
    }

    public String getSymptom_cough() {
        return symptom_cough;
    }

    public void setSymptom_cough(String symptom_cough) {
        this.symptom_cough = symptom_cough;
    }

    public String getSymptom_sore_throat() {
        return symptom_sore_throat;
    }

    public void setSymptom_sore_throat(String symptom_sore_throat) {
        this.symptom_sore_throat = symptom_sore_throat;
    }

    public String getSymptom_muscle_pain() {
        return symptom_muscle_pain;
    }

    public void setSymptom_muscle_pain(String symptom_muscle_pain) {
        this.symptom_muscle_pain = symptom_muscle_pain;
    }

    public String getDiagnosed_covid19() {
        return diagnosed_covid19;
    }

    public void setDiagnosed_covid19(String diagnosed_covid19) {
        this.diagnosed_covid19 = diagnosed_covid19;
    }

//    public Integer getNew_device_id() {
//        return new_device_id;
//    }
//
//    public void setNew_device_id(Integer new_device_id) {
//        this.new_device_id = new_device_id;
//    }

    public Submitter getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Submitter submitter) {
        this.submitter = submitter;
    }

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

}
