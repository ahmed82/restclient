package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private int total;
    private Employee[] results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Employee[] getResults() {
        return results;
    }

    public void setResults(Employee[] results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Data{" +
                "total=" + total +
                '}';
    }
    
}