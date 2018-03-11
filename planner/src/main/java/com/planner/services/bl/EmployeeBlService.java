package com.planner.services.bl;

import com.planner.entities.Agenda;
import com.planner.entities.Employee;
import com.planner.entities.MeetingRequests;
import com.planner.rest.bo.ServiceStatus;
import com.planner.services.dl.AgendaDlService;
import com.planner.services.dl.EmployeeDlService;
import com.planner.services.dl.MeetingRequestsDlService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class EmployeeBlService {


    public void test(){
        System.out.println("Hello....");
    }

    public ServiceStatus findEmployee(String name) throws Exception {

        ServiceStatus statusMessage = new ServiceStatus();
        EmployeeDlService employeeDlService = null;
        try {

            if (name != null) {
                employeeDlService = new EmployeeDlService();
                Employee existingEmployee = employeeDlService.findUserByName(name);
                if (existingEmployee == null) {
                    statusMessage.setStatusCode(1);
                    statusMessage.setStatusMessage("EMPLOYEE_NOT_FOUND");
                    statusMessage.setData(null);
                } else {

                    AgendaDlService agendaDlService = new AgendaDlService();
                    MeetingRequestsDlService meetingRequestsDlService = new MeetingRequestsDlService();

                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    String date = simpleDateFormat.format(new Date());

                    List<Agenda> agendaList = agendaDlService.findAgendaItemsByDates(existingEmployee.getId(), date, date);
                    for (Agenda id : agendaList) {
                        System.out.println("Agenda ID: " + id.getId());
                    }

                    existingEmployee.setAgendas(new HashSet<>(agendaList));

                    List<MeetingRequests> meetingRequestsList = meetingRequestsDlService.findMeetingRequestsItemsByDates(existingEmployee.getId());
                    for (MeetingRequests id : meetingRequestsList) {
                        System.out.println("Meeting Req ID: " + id.getId());
                    }

                    existingEmployee.setMeetingRequestses(new HashSet<>(meetingRequestsList));

                    statusMessage.setStatusCode(0);
                    statusMessage.setStatusMessage("EMPLOYEE_LOGIN_SUCCESS");
                    statusMessage.setData(existingEmployee);
                }

            } else {
                statusMessage.setStatusCode(1);
                statusMessage.setStatusMessage("EMPLOYEE_NAME_ISEMPTY");
                statusMessage.setData(null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            statusMessage.setStatusCode(1);
            statusMessage.setStatusMessage("EXCEPTION_EMPLOYEE_LOGIN_PROBLEM");
            statusMessage.setData(null);
        }

        return statusMessage;

    }

}
