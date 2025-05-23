package org.example.result;

import java.util.List;

public class Result {
    private String search;
    private List<String> result;
    private long time;

    public Result(String search, List<String> result, long time) {
        this.search = search;
        this.result = result;
        this.time = time;
    }

    public String getSearch() {
        return search;
    }

    public List<String> getResult() {
        return result;
    }

    public long getTime() {
        return time;
    }
}
