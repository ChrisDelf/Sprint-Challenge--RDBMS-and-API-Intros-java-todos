package com.lambdaschool.javatodos.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="todos")

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

//    @Column(nullable = false)
    private String todos;

    private Date datestarted;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties({"todo", "hibernateLazyInitializer"})
    private User user;

    public Todo() {
    }

    public Todo(String todos, Date datestarted,  User user) {
        this.todos = todos;
        this.datestarted = datestarted;
        this.completed = false;
        this.user = user;
    }

    public Date getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(Date datestarted) {
        this.datestarted = datestarted;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
