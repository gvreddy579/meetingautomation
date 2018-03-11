package com.planner.rest.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class AgendaBo {

    private int id;
    private RoomBo roomBo;
    private String description;
    private Date startDate;
    private Date endDate;
    private Date startTime;
    private Date endTime;
    private int duration;
    private Integer priority;
    private Character isConfidential;
    private Character isRepetetive;
    private Set<EmployeeBo> employeeBoSet = new HashSet<EmployeeBo>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomBo getRoomBo() {
        return roomBo;
    }

    public void setRoomBo(RoomBo roomBo) {
        this.roomBo = roomBo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Character getIsConfidential() {
        return isConfidential;
    }

    public void setIsConfidential(Character isConfidential) {
        this.isConfidential = isConfidential;
    }

    public Character getIsRepetetive() {
        return isRepetetive;
    }

    public void setIsRepetetive(Character isRepetetive) {
        this.isRepetetive = isRepetetive;
    }

    public Set<EmployeeBo> getEmployeeBoSet() {
        return employeeBoSet;
    }

    public void setEmployeeBoSet(Set<EmployeeBo> employeeBoSet) {
        this.employeeBoSet = employeeBoSet;
    }
}
