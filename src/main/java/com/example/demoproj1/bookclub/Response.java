package com.example.demoproj1.bookclub;


import lombok.Data;

@Data
public class Response  {
    private String message;
    private Boolean status;


    public Response(String message, Boolean status){
        this.message = message;
        this.status = status;
    }


}
