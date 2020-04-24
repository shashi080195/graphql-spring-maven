package com.example.demo.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class RestResponse {

  private Boolean status;

  public RestResponse(Boolean status) {
    this.status = status;
  }
}
