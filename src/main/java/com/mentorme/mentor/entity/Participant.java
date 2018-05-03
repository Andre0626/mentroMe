package com.mentorme.mentor.entity;

import javax.persistence.*;

@Table(name = "participants")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "event_id")
    private Long eventId;

}
