package com.binary.aircraft.values;

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
        for(QueueSize q : QueueSize.values()){
            System.out.println("abbr: " +abbr + " q: "+q + " getAbbr : " +q.getAbbr());
            if(abbr.equals(q.getAbbr())) return q.name();
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
