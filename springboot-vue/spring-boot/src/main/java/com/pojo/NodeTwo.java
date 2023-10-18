package com.pojo;

public class NodeTwo {
    private Long id;
    private String name;
    private Boolean authenticated_flag;
    private int count;
    private String contents;

    public NodeTwo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAuthenticated_flag() {
        return authenticated_flag;
    }

    public void setAuthenticated_flag(Boolean authenticated_flag) {
        this.authenticated_flag = authenticated_flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "NodeTwo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authenticated_flag=" + authenticated_flag +
                ", count=" + count +
                ", contents='" + contents + '\'' +
                '}';
    }
}
