package com.opw.modern.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.opw.modern.api.model.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import org.springframework.hateoas.RepresentationModel;

/**
 * Shopping Cart of the user
 */
@ApiModel(description = "Shopping Cart of the user")
@JacksonXmlRootElement(localName = "Cart")
@XmlRootElement(name = "Cart")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cart extends RepresentationModel<Cart>  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @JacksonXmlProperty(localName = "id")
  private String id;

  @JsonProperty("customerId")
  @JacksonXmlProperty(localName = "customerId")
  private String customerId;

  @JsonProperty("items")
  @JacksonXmlProperty(localName = "items")
  @Valid
  private List<Item> items = null;

  public Cart id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Cart Identifier
   * @return id
  */
  @ApiModelProperty(value = "Cart Identifier")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cart customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Id of the customer who possesses the cart
   * @return customerId
  */
  @ApiModelProperty(value = "Id of the customer who possesses the cart")


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public Cart items(List<Item> items) {
    this.items = items;
    return this;
  }

  public Cart addItemsItem(Item itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Collection of items in cart.
   * @return items
  */
  @ApiModelProperty(value = "Collection of items in cart.")

  @Valid

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cart cart = (Cart) o;
    return Objects.equals(this.id, cart.id) &&
        Objects.equals(this.customerId, cart.customerId) &&
        Objects.equals(this.items, cart.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customerId, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cart {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

