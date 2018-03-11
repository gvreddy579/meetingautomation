package com.planner.rest.bo;

import java.util.HashSet;
import java.util.Set;

public class EmployeeBo {

    private int id;
    private String name;
    private String email;
    private Set<AgendaBo> agendaBoSet = new HashSet<AgendaBo>(0);
    private Set<MeetingRequestsBo> meetingRequestsBos = new HashSet<MeetingRequestsBo>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<AgendaBo> getAgendaBoSet() {
        return agendaBoSet;
    }

    public void setAgendaBoSet(Set<AgendaBo> agendaBoSet) {
        this.agendaBoSet = agendaBoSet;
    }

    public Set<MeetingRequestsBo> getMeetingRequestsBos() {
        return meetingRequestsBos;
    }

    public void setMeetingRequestsBos(Set<MeetingRequestsBo> meetingRequestsBos) {
        this.meetingRequestsBos = meetingRequestsBos;
    }
}
