package com.example.demo.entity;

import java.util.List;

import lombok.Data;

//泛型，T表示一个类型参数。在类中的方法中，可以使用这个类型参数来定义变量、参数、返回值的类型。在实例化这个类时，可以指定T的具体类型
@Data
public class Result<T> {
	private List<T> list;       // 查询结果列表
	private int count;       	// 查询结果列表明细条数
    private long total;         // 总记录数
    private int pageNum;        // 当前页码
    private int pageSize;       // 每页记录数
    private int pages;          // 总页数
}
