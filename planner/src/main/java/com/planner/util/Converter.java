package com.planner.util;

import com.planner.entities.Agenda;
import com.planner.entities.Employee;
import com.planner.entities.MeetingRequests;
import com.planner.entities.Room;
import com.planner.rest.bo.AgendaBo;
import com.planner.rest.bo.EmployeeBo;
import com.planner.rest.bo.MeetingRequestsBo;
import com.planner.rest.bo.RoomBo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Converter {

    public EmployeeBo employeeEntityToEmployeeBo(Employee employeeEntity) {

        EmployeeBo employeeBo = new EmployeeBo();
        AgendaBo agendaBo = null;
        RoomBo roomBo = null;
        MeetingRequestsBo meetingRequestsBo = null;
        List<AgendaBo> agendaBoList = null;
        List<MeetingRequestsBo> meetingRequestsBoList = null;

        employeeBo.setId(employeeEntity.getId());
        employeeBo.setName(employeeEntity.getName());
        employeeBo.setEmail(employeeEntity.getEmail());

        if (employeeEntity.getAgendas() != null && employeeEntity.getAgendas().size() > 0) {
            agendaBoList = new ArrayList<>();
            for (Agenda agenda : employeeEntity.getAgendas()) {
                agendaBo = new AgendaBo();
                agendaBo.setId(agenda.getId());
                agendaBo.setDescription(agenda.getDescription());
                agendaBo.setStartDate(agenda.getStartDate());
                agendaBo.setStartTime(agenda.getStartTime());
                agendaBo.setEndDate(agenda.getEndDate());
                agendaBo.setEndTime(agenda.getEndTime());
                agendaBo.setDuration(agenda.getDuration());
                agendaBo.setPriority(agenda.getPriority());
                agendaBo.setIsConfidential(agenda.getIsConfidential());
                if (agenda.getRoom() != null && agenda.getRoom().getId() > 0) {
                    roomBo = RoomToRoomBo(agenda.getRoom());
                    agendaBo.setRoomBo(roomBo);
                }
                agendaBo.setIsRepetetive(agenda.getIsRepetetive());

                agendaBoList.add(agendaBo);
            }

        }
        employeeBo.setAgendaBoSet(new HashSet<>(agendaBoList));

        if (employeeEntity.getMeetingRequestses() != null && employeeEntity.getMeetingRequestses().size() > 0) {
            meetingRequestsBoList = new ArrayList<>();
            for (MeetingRequests meetingRequest : employeeEntity.getMeetingRequestses()) {
                meetingRequestsBo = new MeetingRequestsBo();
                meetingRequestsBo.setId(meetingRequest.getId());
                meetingRequestsBo.setDescription(meetingRequest.getDescription());
                meetingRequestsBo.setStartDate(meetingRequest.getStartDate());
                meetingRequestsBo.setStartTime(meetingRequest.getStartTime());
                meetingRequestsBo.setEndDate(meetingRequest.getEndDate());
                meetingRequestsBo.setEndTime(meetingRequest.getEndTime());
                meetingRequestsBo.setDuration(meetingRequest.getDuration());
                meetingRequestsBo.setPriority(meetingRequest.getPriority());
                meetingRequestsBo.setIsConfidential(meetingRequest.getIsConfidential());
                if (meetingRequest.getRoom() != null && meetingRequest.getRoom().getId() > 0) {
                    roomBo = RoomToRoomBo(meetingRequest.getRoom());
                    meetingRequestsBo.setRoomBo(roomBo);
                }
                meetingRequestsBo.setIsRepetative(meetingRequest.getIsRepetative());
                meetingRequestsBo.setStatus(meetingRequest.getStatus());
                meetingRequestsBoList.add(meetingRequestsBo);

            }

        }
        employeeBo.setMeetingRequestsBos(new HashSet<>(meetingRequestsBoList));

        return employeeBo;
    }

    private RoomBo RoomToRoomBo(Room room) {
        RoomBo roomBo = new RoomBo();
        roomBo.setId(room.getId());
        if (room.getName() != null) {
            roomBo.setName(room.getName());
        }
        if (room.getLocation() != null) {
            roomBo.setLocation(room.getLocation());
        }
        if (room.getCapacity() > 0) {
            roomBo.setCapacity(room.getCapacity());
        }
        return roomBo;
    }

}
