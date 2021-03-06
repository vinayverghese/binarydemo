package com.binary.aircraft.values;

import org.apache.commons.lang.StringUtils;

public enum QueueSize {

    LARGE("Large", "L", 0), SMALL("Small","S", 1);


    public static boolean contains(String s)
    {
    for(QueueSize size:values())
            if (size.getAbbr().equals(s))
                return true;
        return false;
    }

    public static String getNameByAbbr(String abbr){
        if(StringUtils.isNotBlank(abbr)) {
            for (QueueSize q : QueueSize.values()) {
                if (abbr.equals(q.getAbbr())) return q.name();
            }
        }
        return null;
    }

    public static Integer getPriorityByName(String name){
        if(StringUtils.isNotBlank(name)) {
            for (QueueSize q : QueueSize.values()) {
                if (name.equals(q.getName().toUpperCase())) return q.getPriority();
            }
        }
        return null;
    }

    QueueSize(String name, String abbr, Integer priority) {
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
