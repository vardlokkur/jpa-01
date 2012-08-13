package com.blogspot.vardlokkur;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.blogspot.vardlokkur.domain.Employee;

@ContextConfiguration(locations = {"classpath:com/blogspot/vardlokkur/database-oracle.xml",
    "classpath:com/blogspot/vardlokkur/infrastructure.xml"})
@TestExecutionListeners(listeners = TransactionalTestExecutionListener.class)
public class Test01 extends AbstractJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional(readOnly = true)
    public void test01() {
        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e order by e.name", Employee.class);
        for (int i = 0 ; i < 40 ; i = i + 5) {
            StringBuilder builder = new StringBuilder();
            for (Employee employee : query.setFirstResult(i).setMaxResults(5).getResultList()) {
                if (builder.length() > 0) {
                    builder.append(", ");
                }
                builder.append(employee.getEmployeeId());
            }
            System.out.println("" + i + " - " + builder.toString());
        }
    }
}
