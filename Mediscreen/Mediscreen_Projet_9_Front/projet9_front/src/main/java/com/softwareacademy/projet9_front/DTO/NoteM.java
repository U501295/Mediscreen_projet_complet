package com.softwareacademy.projet9_front.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NoteM {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @NotBlank
    private String content;

    public NoteM(String content){
        this.creationDate = java.time.LocalDate.now();
        this.content = content;
    }
}
