package com.example.backend.springbootbackend.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class ReferenceDTO {

    private long id;
    private String  nomAr;
    private String nomFr;
    private String nomAn;
    private String image;
    // private String contentType;
    // gfdgx

    private String  utilisateur;
    private String operation;
    private int isSelected;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private String createdBy;


    private LocalDateTime updatedDate;
    private String updatedBy;
}
