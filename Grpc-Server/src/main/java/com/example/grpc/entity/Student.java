package com.example.grpc.entity;

public class Student {
    String id;
    String name;
    String major;
    String[] takeCoures;

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    private void setMajor(String major) {
        this.major = major;
    }

    public String[] getTakeCoures() {
        return takeCoures;
    }

    private void setTakeCoures(String[] takeCoures) {
        this.takeCoures = takeCoures;
    }
}
