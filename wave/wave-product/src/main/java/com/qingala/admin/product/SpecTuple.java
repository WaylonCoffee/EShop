package com.qingala.admin.product;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SpecTuple {

    @NotNull
    @Size(max = 3, message = "规格项最多3层")
    private List<Spec> specs = new ArrayList<>();
    public SpecTuple(List<Spec> specs) {
        this.specs = specs;
    }

}
