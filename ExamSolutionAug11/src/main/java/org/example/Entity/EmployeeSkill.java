package org.example.Entity;

public class EmployeeSkill {
    public int employeeId;
    public int skillId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Override
    public String toString() {
        return "EmployeeSkill{" +
                "employeeId=" + employeeId +
                ", skillId=" + skillId +
                '}';
    }
}
