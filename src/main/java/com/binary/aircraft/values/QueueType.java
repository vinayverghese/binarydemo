package com.binary.aircraft.values;

public enum QueueType {

    EMERGENCY("Emergency", "E", 0), VIP("VIP", "V",1),
    PASSENGER("Passenger", "P", 2), C("Cargo", "C", 3);

    public static boolean contains(String s)
    {
        for(QueueType type:values())
            if (type.getAbbr().equals(s))
                return true;
        return false;
    }

    public static String getNameByAbbr(String abbr){
        for(QueueType q : QueueType.values()){
            if(abbr.equals(q.getAbbr())) return q.name();
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
