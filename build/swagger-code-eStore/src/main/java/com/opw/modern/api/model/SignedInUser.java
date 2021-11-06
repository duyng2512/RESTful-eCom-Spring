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
 * Signed-in user information
 */
@ApiModel(description = "Signed-in user information")
@JacksonXmlRootElement(localName = "SignedInUser")
@XmlRootElement(name = "SignedInUser")
@XmlAccessorType(XmlAccessType.FIELD)
public class SignedInUser extends RepresentationModel<SignedInUser>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("refreshToken")
  @JacksonXmlProperty(localName = "refreshToken")
  private String refreshToken;

  @JsonProperty("accessToken")
  @JacksonXmlProperty(localName = "accessToken")
  private String accessToken;

  @JsonProperty("username")
  @JacksonXmlProperty(localName = "username")
  private String username;

  @JsonProperty("userId")
  @JacksonXmlProperty(localName = "userId")
  private String userId;

  public SignedInUser refreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Refresh Token
   * @return refreshToken
  */
  @ApiModelProperty(value = "Refresh Token")


  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public SignedInUser accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * JWT Token aka access token
   * @return accessToken
  */
  @ApiModelProperty(value = "JWT Token aka access token")


  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public SignedInUser username(String username) {
    this.username = username;
    return this;
  }

  /**
   * User Name
   * @return username
  */
  @ApiModelProperty(value = "User Name")


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public SignedInUser userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * User Identifier
   * @return userId
  */
  @ApiModelProperty(value = "User Identifier")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SignedInUser signedInUser = (SignedInUser) o;
    return Objects.equals(this.refreshToken, signedInUser.refreshToken) &&
        Objects.equals(this.accessToken, signedInUser.accessToken) &&
        Objects.equals(this.username, signedInUser.username) &&
        Objects.equals(this.userId, signedInUser.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(refreshToken, accessToken, username, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignedInUser {\n");
    
    sb.append("    refreshToken: ").append(toIndentedString(refreshToken)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

