package com.planner.rest.bo;

public class RoomBo {

    private int id;
    private String name;
    private String location;
    private int capacity;
    private MeetingRequestsBo meetingRequestsBo;
    private AgendaBo agendaBo;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public MeetingRequestsBo getMeetingRequestsBo() {
        return meetingRequestsBo;
    }

    public void setMeetingRequestsBo(MeetingRequestsBo meetingRequestsBo) {
        this.meetingRequestsBo = meetingRequestsBo;
    }

    public AgendaBo getAgendaBo() {
        return agendaBo;
    }

    public void setAgendaBo(AgendaBo agendaBo) {
        this.agendaBo = agendaBo;
    }
}
