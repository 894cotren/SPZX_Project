package com.awc20.spzx.model.vo.common;

public class Test01 {
    public static void main(String[] args) {
        Result<String> result = Result.ok("哈哈哈哈哈");
        System.out.println(result);

        Result<Object> fail = Result.fail("测试-失败了");
        System.out.println(fail);
    }
}
