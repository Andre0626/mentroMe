package com.mentorme.mentor.entity;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_id")
    private Long evetId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
