package ru.shamma.lesson4;

import ru.shamma.lesson4.annotations.DBColumn;
import ru.shamma.lesson4.annotations.DBId;
import ru.shamma.lesson4.annotations.DBtable;

@DBtable(name = "table")
public class Test {
    @DBId(id = 1)
    long id;
    @DBColumn()
    String a;

    public Test(long id, String a) {
        this.id = id;
        this.a = a;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
