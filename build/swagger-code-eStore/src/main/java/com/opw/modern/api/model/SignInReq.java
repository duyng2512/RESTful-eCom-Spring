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
 * Request body for Sign-in
 */
@ApiModel(description = "Request body for Sign-in")
@JacksonXmlRootElement(localName = "SignInReq")
@XmlRootElement(name = "SignInReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class SignInReq extends RepresentationModel<SignInReq>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("username")
  @JacksonXmlProperty(localName = "username")
  private String username;

  @JsonProperty("password")
  @JacksonXmlProperty(localName = "password")
  private String password;

  public SignInReq username(String username) {
    this.username = username;
    return this;
  }

  /**
   * username of the User
   * @return username
  */
  @ApiModelProperty(value = "username of the User")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public SignInReq password(String password) {
    this.password = password;
    return this;
  }

  /**
   * password of the User
   * @return password
  */
  @ApiModelProperty(value = "password of the User")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignInReq signInReq = (SignInReq) o;
    return Objects.equals(this.username, signInReq.username) &&
        Objects.equals(this.password, signInReq.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignInReq {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

