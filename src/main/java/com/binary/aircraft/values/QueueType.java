package com.binary.aircraft.values;

import org.apache.commons.lang.StringUtils;

public enum QueueType {

    EMERGENCY("Emergency", "E", 0), VIP("VIP", "V",1),
    PASSENGER("Passenger", "P", 2), CARGO("Cargo", "C", 3);

    public static boolean contains(String s)
    {
        for(QueueType type:values())
            if (type.getAbbr().equals(s))
                return true;
        return false;
    }

    public static String getNameByAbbr(String abbr){
        if(StringUtils.isNotBlank(abbr)) {
            for (QueueType q : QueueType.values()) {
                if (abbr.equals(q.getAbbr())) return q.name();
            }
        }
        return null;
    }

    public static Integer getPriorityByName(String name){
        if(StringUtils.isNotBlank(name)) {
            for (QueueType q : QueueType.values()) {
                if (name.equals(q.getName().toUpperCase())) return q.getPriority();
            }
        }
        return null;
    }
    QueueType(String name, String abbr, Integer priority) {
        this.name = name;
        this.abbr = abbr;
        this.priority = priority;
    }

    private final String name;
    private final String abbr;
    private final Integer priority;

    public String getName() {
        return name;
    }

    public String getAbbr() {
        return abbr;
    }

    public Integer getPriority() {
        return priority;
    }
}
