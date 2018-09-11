package com.java.demo;

/**
 * Created by cdc on 2018/4/3.
 */
public class GoodsCategory {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer sortIndex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public GoodsCategory(Integer id, Integer parentId, String name, Integer sortIndex){
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.sortIndex = sortIndex;
    }

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", sortIndex=" + sortIndex +
                '}';
    }
}
