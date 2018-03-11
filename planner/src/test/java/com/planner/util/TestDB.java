package com.planner.util;

import com.planner.entities.Agenda;
import com.planner.entities.Employee;
import com.planner.entities.MeetingRequests;
import com.planner.services.dl.AgendaDlService;
import com.planner.services.dl.MeetingRequestsDlService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestDB {

    public static void main(String[] args) {
        System.out.println("Welcome...");

        try {
            AgendaDlService agendaDlService = new AgendaDlService();
            MeetingRequestsDlService meetingRequestsDlService = new MeetingRequestsDlService();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            System.out.println(date);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date orderDate = dateFormat.parse(date);

            System.out.println(orderDate);

            List<Agenda> meetingIDs = agendaDlService.findAgendaItemsByDates(3, date, date);
            for (Agenda id : meetingIDs) {
                System.out.println("Agenda ID: " + id.getId());
            }

            List<MeetingRequests> meetingReqIds = meetingRequestsDlService.findMeetingRequestsItemsByDates(5);
            for (MeetingRequests id : meetingReqIds) {
                System.out.println("Meeting Req ID: " + id.getId());
            }

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
