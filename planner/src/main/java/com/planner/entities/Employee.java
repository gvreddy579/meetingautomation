package com.planner.entities;

// default package
// Generated Mar 10, 2018 12:35:08 AM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "planner", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Employee implements java.io.Serializable {

    private int id;
    private String name;
    private String email;
    private Set<Agenda> agendas = new HashSet<Agenda>(0);
    private Set<MeetingRequests> meetingRequestses = new HashSet<MeetingRequests>(0);

    public Employee() {
    }

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Employee(int id, String name, String email, Set<Agenda> agendas, Set<MeetingRequests> meetingRequestses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.agendas = agendas;
        this.meetingRequestses = meetingRequestses;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", unique = true, nullable = false, length = 145)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "agenda_mem", catalog = "planner", uniqueConstraints = {
            @UniqueConstraint(columnNames = "employeeId"),
            @UniqueConstraint(columnNames = "agendaId")}, joinColumns = {
            @JoinColumn(name = "employeeId", unique = true, nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "agendaId", unique = true, nullable = false, updatable = false)})
    public Set<Agenda> getAgendas() {
        return this.agendas;
    }

    public void setAgendas(Set<Agenda> agendas) {
        this.agendas = agendas;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "meeting_req_mem", catalog = "planner", uniqueConstraints = {
            @UniqueConstraint(columnNames = "employeeId"),
            @UniqueConstraint(columnNames = "meetingReqId")}, joinColumns = {
            @JoinColumn(name = "employeeId", unique = true, nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "meetingReqId", unique = true, nullable = false, updatable = false)})
    public Set<MeetingRequests> getMeetingRequestses() {
        return this.meetingRequestses;
    }

    public void setMeetingRequestses(Set<MeetingRequests> meetingRequestses) {
        this.meetingRequestses = meetingRequestses;
    }

}
