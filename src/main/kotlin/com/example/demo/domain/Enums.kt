package com.example.demo.domain

enum class Grade(val grade: String) {
    JT("junior technician"),
    T("technician"),
    ST("senior technician"),
    EN("engineer"),
    SE("senior engineer"),
    CL("consultant"),
    SC("senior consultant")
}

enum class Discipline(val discipline: String) {
    TEST("testing"),
    DEV("development"),
    SM("scrum master"),
    OPS("devops")
}