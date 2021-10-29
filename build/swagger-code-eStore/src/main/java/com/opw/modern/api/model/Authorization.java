package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Authorization
 */
@JacksonXmlRootElement(localName = "Authorization")
@XmlRootElement(name = "Authorization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Authorization extends RepresentationModel<Authorization>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("orderId")
  @JacksonXmlProperty(localName = "orderId")
  private String orderId;

  @JsonProperty("time")
  @JacksonXmlProperty(localName = "time")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime time;

  @JsonProperty("authorized")
  @JacksonXmlProperty(localName = "authorized")
  private Boolean authorized;

  @JsonProperty("message")
  @JacksonXmlProperty(localName = "message")
  private String message;

  @JsonProperty("error")
  @JacksonXmlProperty(localName = "error")
  private String error;

  public Authorization orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Order Identification
   * @return orderId
  */
  @ApiModelProperty(value = "Order Identification")


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public Authorization time(OffsetDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Timestamp when this authorization was created
   * @return time
  */
  @ApiModelProperty(value = "Timestamp when this authorization was created")

  @Valid

  public OffsetDateTime getTime() {
    return time;
  }

  public void setTime(OffsetDateTime time) {
    this.time = time;
  }

  public Authorization authorized(Boolean authorized) {
    this.authorized = authorized;
    return this;
  }

  /**
   * Flat that specify whether the payment is authorized
   * @return authorized
  */
  @ApiModelProperty(value = "Flat that specify whether the payment is authorized")


  public Boolean getAuthorized() {
    return authorized;
  }

  public void setAuthorized(Boolean authorized) {
    this.authorized = authorized;
  }

  public Authorization message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Approavl or rejection message
   * @return message
  */
  @ApiModelProperty(value = "Approavl or rejection message")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Authorization error(String error) {
    this.error = error;
    return this;
  }

  /**
   * Processing error description, if any
   * @return error
  */
  @ApiModelProperty(value = "Processing error description, if any")


  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Authorization authorization = (Authorization) o;
    return Objects.equals(this.orderId, authorization.orderId) &&
        Objects.equals(this.time, authorization.time) &&
        Objects.equals(this.authorized, authorization.authorized) &&
        Objects.equals(this.message, authorization.message) &&
        Objects.equals(this.error, authorization.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, time, authorized, message, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Authorization {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

