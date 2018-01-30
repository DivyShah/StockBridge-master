package com.example.abc.stockbridge;

import java.io.Serializable;

/**
 * Created by abc on 9/2/2017.
 */

public class CommoditiesDetail  implements Serializable
{
    private String source_code;
    private String source_name;

    public String getSource_code() {
        return source_code;
    }

    public void setSource_code(String source_code) {
        this.source_code = source_code;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }
}
