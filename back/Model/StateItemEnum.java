package com.example.practicaBBX2.Model;

public enum StateItemEnum {
    ACTIVE(1, "Active"),
    DISCONTINUED(2, "Discontinued");

    Integer val;
    String valStr;

    StateItemEnum(Integer iVal, String valStr) {
        val = iVal;
        this.valStr = valStr;
    }

    public String getStringRep() {
        return valStr;
    }

    public Integer asInteger() {
        return val;
    }

    public static StateItemEnum get(Integer id) {
        for(StateItemEnum s : values()) {
            if(s.val.equals(id))
                return s;
        }
        return DISCONTINUED;
    }

}
