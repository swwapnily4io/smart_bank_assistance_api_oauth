
package com.example.OauthExample.controller;

public class ServiceRequest {

  private String description;
  private long requestId;
  private String createdOn;
  private String status;
  private String comments;

  public ServiceRequest(long requestId, String description, String createdOn, String status, String comments) {
    super();
    this.description = description;
    this.requestId = requestId;
    this.createdOn = createdOn;
    this.status = status;
    this.comments = comments;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public long getRequestId() {
    return requestId;
  }

  public void setRequestId(long requestId) {
    this.requestId = requestId;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

}
