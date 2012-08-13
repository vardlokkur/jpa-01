package com.blogspot.vardlokkur.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Column(name = "DATE_OF_BIRTH")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dateOfBirth;

    @Column(name = "EMPLOYEE_ID")
    @Id
    private Long employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    /**
     * Constructs new instance.
     */
    Employee() {
        super();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("employeeId", employeeId).append("name", name)
            .append("dateOfBirth", dateOfBirth).build();
    }

}
