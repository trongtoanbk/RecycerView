package com.example.recycerview;

public enum ServiceType {
    RESTAURANT("Nhà Hàng"),
    BIRDTH_DAY("Sinh Nhật"),
    FAMILY("Gia Đình"),
    GROUP("Hội Nhóm"),
    STORE("Cửa Hàng"),
    SHOP_ONLINE("Shop Online"),
    STREET_FOOD("Đồ Ăn Đường phố"),
    BUFFET("Buffer");

    private final String name;
    ServiceType(String s)
    {
        name =s;
    }
    public String toString(){
        return name;
    }


}
