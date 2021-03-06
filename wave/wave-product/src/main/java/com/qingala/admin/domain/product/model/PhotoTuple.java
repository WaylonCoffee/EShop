
package com.qingala.admin.domain.product.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhotoTuple  {

    @NotNull(message = "图片列表不能为空")
    @Size(max = 10, min = 1, message = "图片列表数量必须在1-10")
    private List<Photo> photos = new ArrayList<>();

    public PhotoTuple(List<Photo> photos) {
        this.photos = photos;
    }


    protected PhotoTuple() {
    }


    /**
     * 获取主图
     *
     * @return
     */
    private Photo getMainPhoto(){
        if(photos.isEmpty()){
            return null;
        }
        return photos.get(0);
    }

}