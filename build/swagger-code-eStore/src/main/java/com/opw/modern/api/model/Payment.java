package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Payment
 */
@JacksonXmlRootElement(localName = "Payment")
@XmlRootElement(name = "Payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment extends RepresentationModel<Payment>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @JacksonXmlProperty(localName = "id")
  private String id;

  @JsonProperty("authorized")
  @JacksonXmlProperty(localName = "authorized")
  private Boolean authorized;

  @JsonProperty("message")
  @JacksonXmlProperty(localName = "message")
  private String message;

  public Payment id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Order identifier
   * @return id
  */
  @ApiModelProperty(value = "Order identifier")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Payment authorized(Boolean authorized) {
    this.authorized = authorized;
    return this;
  }

  /**
   * Flag that specified whether payment is authorized or not
   * @return authorized
  */
  @ApiModelProperty(value = "Flag that specified whether payment is authorized or not")


  public Boolean getAuthorized() {
    return authorized;
  }

  public void setAuthorized(Boolean authorized) {
    this.authorized = authorized;
  }

  public Payment message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Approval or rejection message
   * @return message
  */
  @ApiModelProperty(value = "Approval or rejection message")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Payment payment = (Payment) o;
    return Objects.equals(this.id, payment.id) &&
        Objects.equals(this.authorized, payment.authorized) &&
        Objects.equals(this.message, payment.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, authorized, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    authorized: ").append(toIndentedString(authorized)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

