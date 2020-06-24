package org.acme.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name="submissions")
public class Submission extends PanacheEntityBase {

    /*
mysql> describe submissions;
+--------------------+-----------+------+-----+-------------------+-----------------------------------------------+
| Field              | Type      | Null | Key | Default           | Extra                                         |
+--------------------+-----------+------+-----+-------------------+-----------------------------------------------+
| id                 | bigint    | NO   | PRI | NULL              | auto_increment                                |
| location_lat       | float     | YES  |     | NULL              |                                               |
| location_lng       | float     | YES  |     | NULL              |                                               |
| timestamp_created  | timestamp | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| timestamp_modified | timestamp | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| sentiment_id       | bigint    | YES  | MUL | NULL              |                                               |
| submitter_id       | bigint    | YES  | MUL | NULL              |                                               |
+--------------------+-----------+------+-----+-------------------+-----------------------------------------------+
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

    public Float location_lng;
    public Float location_lat;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "submitter_id")
    public Submitter submitter;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "sentiment_id")
    public Sentiment sentiment;

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
