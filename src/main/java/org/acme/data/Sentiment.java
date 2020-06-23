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

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public String getRoute_type() {
        return route_type;
    }

    public void setRoute_type(String route_type) {
        this.route_type = route_type;
    }

    public String getRoute_number() {
        return route_number;
    }

    public void setRoute_number(String route_number) {
        this.route_number = route_number;
    }

    public String getRoute_direction() {
        return route_direction;
    }

    public void setRoute_direction(String route_direction) {
        this.route_direction = route_direction;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }
}
