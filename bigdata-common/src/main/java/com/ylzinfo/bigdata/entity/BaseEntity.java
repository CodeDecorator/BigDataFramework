/**   
* Copyright (c) 2012-2022 厦门市美亚柏科信息股份有限公司.
*/
package com.ylzinfo.bigdata.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{

    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
