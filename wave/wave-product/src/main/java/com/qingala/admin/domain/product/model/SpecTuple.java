package com.qingala.admin.domain.product.model;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SpecTuple {

    @NotNull
    @Size(max = 3, message = "规格项最多3层")
    private List<Spec> specs = new ArrayList<>();
    public SpecTuple(List<Spec> specs) {
        this.specs = specs;
    }

}
