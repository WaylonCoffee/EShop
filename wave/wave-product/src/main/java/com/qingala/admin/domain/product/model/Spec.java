package com.qingala.admin.domain.product.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "order")
public class Spec implements Serializable{
    
    @Size(max=10, min=1, message = "规格项字符数必须在1-10")
    private String key;
    
    @Size(max=10, min=1, message = "规格项字符数必须在1-10")
    private String value;
    
    private String order;

    protected Spec(){}
  
    public Spec(String key, String value) {
        this.key = key;
        this.value = value;
    }
  
    public Spec setOrder(String order){
        this.order = order;
        return this;
    }

}
