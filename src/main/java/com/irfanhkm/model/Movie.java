package com.irfanhkm.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="movies")
@Where(clause = "deleted_at = null")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String title;

    @Column
    public String overview;

    @Column
    public String poster;

    @Column
    public Date play_until;

    @CreationTimestamp
    public Date created_at;

    @UpdateTimestamp
    public Date updated_at;

    @Column
    public Date deleted_at;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
