package de.etc.lambda;

import java.math.BigDecimal;
import java.util.List;

public class Developer {
    private String name;
    private BigDecimal gehalt;
    private int alter;
    private List<String> projects;

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", gehalt=" + gehalt +
                ", alter=" + alter +
                '}';
    }

    public Developer(String name, BigDecimal gehalt, int alter) {
        this.name = name;
        this.gehalt = gehalt;
        this.alter = alter;

    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public BigDecimal getGehalt() {
        return gehalt;
    }

    public void setGehalt(BigDecimal gehalt) {
        this.gehalt = gehalt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
