package com.example.studentmarkingsystem.dto;

public class TeacherDTO {
    private Long id;
    private String teacherUsername;
    private String teacherPassword;
    private String teacherCourse;
    private Integer teacherCourseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(String teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    public Integer getTeacherCourseId() {
        return teacherCourseId;
    }

    public void setTeacherCourseId(Integer teacherCourseId) {
        this.teacherCourseId = teacherCourseId;
    }
}