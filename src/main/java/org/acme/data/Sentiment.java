package org.acme.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity(name="sentiment")
public class Sentiment extends PanacheEntityBase {

    /*
mysql> describe sentiment;
+--------------------+--------------+------+-----+-------------------+-----------------------------------------------+
| Field              | Type         | Null | Key | Default           | Extra                                         |
+--------------------+--------------+------+-----+-------------------+-----------------------------------------------+
| id                 | bigint       | NO   | PRI | NULL              | auto_increment                                |
| capacity           | int          | YES  |     | NULL              |                                               |
| route_direction    | varchar(255) | YES  |     | NULL              |                                               |
| route_number       | varchar(255) | YES  |     | NULL              |                                               |
| route_type         | varchar(255) | YES  |     | NULL              |                                               |
| stop_name          | varchar(255) | YES  |     | NULL              |                                               |
| timestamp_created  | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| timestamp_modified | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| vibe               | varchar(255) | YES  |     | NULL              |                                               |
+--------------------+--------------+------+-----+-------------------+-----------------------------------------------+
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

    // route service fields
    public String stop_name;
    public String route_type;
    public String route_number;
    public String route_direction;

    // sentiment
    public Integer capacity;
    public String vibe;

}
