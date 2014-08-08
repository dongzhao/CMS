package com.dzhao.simplecms.core.enums;

public enum ObjectType {

    CMS_FILE("cms:file"),
    CMS_FOLDER("cms:folder") ;

    private final String value;

    ObjectType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ObjectType fromValue(String v) {
        for (ObjectType c : ObjectType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
