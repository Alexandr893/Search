package org.example.report;

public class Report {
    private String guid;
    private String codeName;
    private String description;

    public Report(String guid,String codeName, String description) {
        this.guid = guid;
        this.codeName = codeName;
        this.description = description;

    }


    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }
    public String getCodeName() {
        return codeName;
    }
    public String getDescription() {
        return description;
    }

}
