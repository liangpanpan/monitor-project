package com.qs.monitor.entity;

import java.io.Serializable;

public class Emp implements Serializable {
    private Integer id;

    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table emp
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.id
     *
     * @return the value of emp.id
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.id
     *
     * @param id the value for emp.id
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column emp.username
     *
     * @return the value of emp.username
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column emp.username
     *
     * @param username the value for emp.username
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table emp
     *
     * @mbg.generated Sat Jan 23 12:21:56 CST 2021
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}