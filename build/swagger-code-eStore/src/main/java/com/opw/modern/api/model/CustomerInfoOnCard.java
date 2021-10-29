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
 * Customer information required for payment processing
 */
@ApiModel(description = "Customer information required for payment processing")
@JacksonXmlRootElement(localName = "CustomerInfoOnCard")
@XmlRootElement(name = "CustomerInfoOnCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerInfoOnCard extends RepresentationModel<CustomerInfoOnCard>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("firstName")
  @JacksonXmlProperty(localName = "firstName")
  private String firstName;

  @JsonProperty("lastName")
  @JacksonXmlProperty(localName = "lastName")
  private String lastName;

  public CustomerInfoOnCard firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Customer first name
   * @return firstName
  */
  @ApiModelProperty(value = "Customer first name")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CustomerInfoOnCard lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Customer last name
   * @return lastName
  */
  @ApiModelProperty(value = "Customer last name")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerInfoOnCard customerInfoOnCard = (CustomerInfoOnCard) o;
    return Objects.equals(this.firstName, customerInfoOnCard.firstName) &&
        Objects.equals(this.lastName, customerInfoOnCard.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerInfoOnCard {\n");
    
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

