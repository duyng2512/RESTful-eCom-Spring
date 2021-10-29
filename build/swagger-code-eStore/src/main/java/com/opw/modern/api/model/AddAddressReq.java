package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.opw.modern.api.model.AddAddressReqAllOf;
import com.opw.modern.api.model.Address;
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
 * AddAddressReq
 */
@JacksonXmlRootElement(localName = "AddAddressReq")
@XmlRootElement(name = "AddAddressReq")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddAddressReq extends RepresentationModel<AddAddressReq>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @JacksonXmlProperty(localName = "id")
  private String id;

  @JsonProperty("number")
  @JacksonXmlProperty(localName = "number")
  private String number;

  @JsonProperty("residency")
  @JacksonXmlProperty(localName = "residency")
  private String residency;

  @JsonProperty("street")
  @JacksonXmlProperty(localName = "street")
  private String street;

  @JsonProperty("city")
  @JacksonXmlProperty(localName = "city")
  private String city;

  @JsonProperty("state")
  @JacksonXmlProperty(localName = "state")
  private String state;

  @JsonProperty("country")
  @JacksonXmlProperty(localName = "country")
  private String country;

  @JsonProperty("pincode")
  @JacksonXmlProperty(localName = "pincode")
  private String pincode;

  @JsonProperty("userId")
  @JacksonXmlProperty(localName = "userId")
  private String userId;

  public AddAddressReq id(String id) {
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

  public AddAddressReq number(String number) {
    this.number = number;
    return this;
  }

  /**
   * house of flat number
   * @return number
  */
  @ApiModelProperty(value = "house of flat number")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public AddAddressReq residency(String residency) {
    this.residency = residency;
    return this;
  }

  /**
   * Socieity or building name
   * @return residency
  */
  @ApiModelProperty(value = "Socieity or building name")


  public String getResidency() {
    return residency;
  }

  public void setResidency(String residency) {
    this.residency = residency;
  }

  public AddAddressReq street(String street) {
    this.street = street;
    return this;
  }

  /**
   * street name
   * @return street
  */
  @ApiModelProperty(value = "street name")


  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public AddAddressReq city(String city) {
    this.city = city;
    return this;
  }

  /**
   * city name
   * @return city
  */
  @ApiModelProperty(value = "city name")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddAddressReq state(String state) {
    this.state = state;
    return this;
  }

  /**
   * state name
   * @return state
  */
  @ApiModelProperty(value = "state name")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public AddAddressReq country(String country) {
    this.country = country;
    return this;
  }

  /**
   * country name
   * @return country
  */
  @ApiModelProperty(value = "country name")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AddAddressReq pincode(String pincode) {
    this.pincode = pincode;
    return this;
  }

  /**
   * postal code
   * @return pincode
  */
  @ApiModelProperty(value = "postal code")


  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public AddAddressReq userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @ApiModelProperty(value = "")


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
    AddAddressReq addAddressReq = (AddAddressReq) o;
    return Objects.equals(this.id, addAddressReq.id) &&
        Objects.equals(this.number, addAddressReq.number) &&
        Objects.equals(this.residency, addAddressReq.residency) &&
        Objects.equals(this.street, addAddressReq.street) &&
        Objects.equals(this.city, addAddressReq.city) &&
        Objects.equals(this.state, addAddressReq.state) &&
        Objects.equals(this.country, addAddressReq.country) &&
        Objects.equals(this.pincode, addAddressReq.pincode) &&
        Objects.equals(this.userId, addAddressReq.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, residency, street, city, state, country, pincode, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddAddressReq {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    residency: ").append(toIndentedString(residency)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    pincode: ").append(toIndentedString(pincode)).append("\n");
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

