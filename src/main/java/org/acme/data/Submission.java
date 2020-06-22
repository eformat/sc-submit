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
    @Column(length = 20)
    public Integer new_device_id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "submitter_id")
    Submitter submitter;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "sentiment_id")
    Sentiment sentiment;
}
