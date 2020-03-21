package com.ruoyi.common.dto;

/**
 * @description: 下拉框实体类
 * @author: chaijin
 * @create: 2020-03-21 22:27:05
 * @version: 1.0.0
 */
public class DropdownDTO {
    private String value;

    private String name;

    public DropdownDTO(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DropdownDTO{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
