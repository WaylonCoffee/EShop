package com.qingala.admin.product;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
@Builder
public class Photo {
    @Size(min=1, max = 150, message = "url长度在1-150")
    @Pattern(message = "URL格式不正常", regexp = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+(\\\\?{0,1}(([A-Za-z0-9-~]+\\\\={0,1})([A-Za-z0-9-~]*)\\\\&{0,1})*)$")
    private String url;

    public Photo(String url) {
        this.url = url;
    }
}