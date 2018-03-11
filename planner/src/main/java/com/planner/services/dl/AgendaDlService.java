package com.planner.services.dl;

import com.planner.entities.Agenda;
import com.planner.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AgendaDlService {

    public List<Agenda> findAgendaItemsByDates(int empId, String startDate, String endDate) {

        Session session = null;
        List<Agenda> agendaList = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createSQLQuery("SELECT distinct `agenda`.`id`,`agenda`.`description`,`agenda`.`startDate`,`agenda`.`endDate`,`agenda`.`startTime`,`agenda`.`endTime`,`agenda`.`duration`,`agenda`.`priority`,`agenda`.`roomId`,`agenda`.`isConfidential`,`agenda`.`isRepetetive` FROM `planner`.`agenda`, planner.agenda_mem WHERE agenda.id = agenda_mem.agendaId AND agenda_mem.employeeId = :employeeId AND agenda.startDate = :startDate AND agenda.endDate = :endDate")
                    .addEntity("agenda", Agenda.class)
                    .setParameter("employeeId", empId)
                    .setParameter("startDate", startDate)
                    .setParameter("endDate", endDate);

            agendaList = (List<Agenda>) query.list();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
        }

        return agendaList;
    }
}
