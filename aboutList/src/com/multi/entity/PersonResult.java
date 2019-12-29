package com.multi.entity;

import java.util.List;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/11/10 9:45
 * @description:
 */
public class PersonResult {

    private int count;
    private List result;

    public PersonResult(int count, List result) {
        super();
        this.count = count;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
