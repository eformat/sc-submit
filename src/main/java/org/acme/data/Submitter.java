package org.acme.data;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity(name="submitter")
public class Submitter extends PanacheEntityBase {

   /*
mysql> describe submitter;
+--------------------+-------------+------+-----+-------------------+-----------------------------------------------+
| Field              | Type        | Null | Key | Default           | Extra                                         |
+--------------------+-------------+------+-----+-------------------+-----------------------------------------------+
| id                 | bigint      | NO   | PRI | NULL              | auto_increment                                |
| birth_year         | int         | YES  |     | NULL              |                                               |
| device_id          | varchar(20) | YES  |     | NULL              |                                               |
| gender             | varchar(1)  | YES  |     | NULL              |                                               |
| timestamp_created  | timestamp   | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
| timestamp_modified | timestamp   | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED on update CURRENT_TIMESTAMP |
+--------------------+-------------+------+-----+-------------------+-----------------------------------------------+
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

    @Column(length = 20)
    public String device_id;
    @Column(length = 6)
    public Integer birth_year;
    @Column(length = 1)
    public String gender;

}
