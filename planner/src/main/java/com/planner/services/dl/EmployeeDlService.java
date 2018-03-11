package com.planner.services.dl;

import com.planner.entities.Employee;
import com.planner.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EmployeeDlService {

    public Employee findUserByName(String name) throws Exception {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee existingEmployee = null;
        try {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("name", name));
            existingEmployee = (Employee) criteria.uniqueResult();

        } catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("EXCEPTION_EMPLOYEE_FIND_DB");
        } finally {
            session.close();
        }
        return existingEmployee;
    }

}
