package com.planner.services.dl;

import com.planner.entities.Employee;
import com.planner.entities.MeetingRequests;
import com.planner.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class MeetingRequestsDlService {

    public List<MeetingRequests> findMeetingRequestsItemsByDates(int empId) {

        Session session = null;
        List<MeetingRequests> meetingRequestsList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createSQLQuery("SELECT DISTINCT `meeting_requests`.`id`,`meeting_requests`.`description`,`meeting_requests`.`startDate`,`meeting_requests`.`endDate`,`meeting_requests`.`startTime`,`meeting_requests`.`endTime`,`meeting_requests`.`duration`,`meeting_requests`.`priority`,`meeting_requests`.`status`,\n" +
                    "    `meeting_requests`.`isFlexible`,`meeting_requests`.`canOverride`,`meeting_requests`.`roomId`,`meeting_requests`.`isConfidential`,`meeting_requests`.`isRepetative` FROM `planner`.`meeting_requests`, planner.meeting_req_mem WHERE meeting_requests.id = meeting_req_mem.meetingReqId AND meeting_req_mem.employeeId = :employeeId")
                    .addEntity("agenda", MeetingRequests.class)
                    .setParameter("employeeId", empId);

            meetingRequestsList = (List<MeetingRequests>) query.list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return meetingRequestsList;
    }

    public void createMeetingRequests(List<MeetingRequests> meetingRequestsList) throws Exception{

        Session session = null;
        MeetingRequests meetingRequests = null;
        Set<Employee> employeeList = null;
        long meetingRequestId = 0;
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            for(MeetingRequests meetingRequest: meetingRequestsList ){
                session.save(meetingRequest);
                meetingRequestId = meetingRequest.getId();
                employeeList = meetingRequest.getEmployees();
                if (employeeList != null & employeeList.size() > 0) {
                    for (Employee employee : employeeList){

                        session.save(meetingRequest);

                    }
                } else {
                    throw new Exception("ATLEAST_ONE_PERSON_SHOULD_BE_AS_MEETING_PARTICIPANT");
                }

            }

            session.getTransaction().commit();

        } catch (ConstraintViolationException cve) {
            session.getTransaction().rollback();
            throw cve;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }
}
