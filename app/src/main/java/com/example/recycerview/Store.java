package com.example.recycerview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    private int image;
    private long openTime;
    private long closeTime;
    private String name;
    private String address;
    private List<ServiceType> listServiceType;
    private String saleOff;
    private float distance;

    public Store(int image, long openTime, long closeTime, String name, String address, List<ServiceType> listServiceType, String saleOff, float distance) {
        this.image = image;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.name = name;
        this.address = address;
        this.listServiceType = listServiceType;
        this.saleOff = saleOff;
        this.distance = distance;
    }

    public int getImage() {
        return image;
    }

    public long getOpenTime() {
        return openTime;
    }

    public long getCloseTime() {
        return closeTime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ServiceType> getListServiceType() {
        return listServiceType;
    }

    public String getSaleOff() {
        return saleOff;
    }

    public float getDistance() {
        return distance;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setOpenTime(long openTime) {
        this.openTime = openTime;
    }

    public void setCloseTime(long closeTime) {
        this.closeTime = closeTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setListServiceType(List<ServiceType> listServiceType) {
        this.listServiceType = listServiceType;
    }

    public void setSaleOff(String saleOff) {
        this.saleOff = saleOff;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "Store{" +
                "image=" + image +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", listServiceType=" + listServiceType +
                ", saleOff='" + saleOff + '\'' +
                ", distance=" + distance +
                '}';
    }
    public static List<Store> getMock()
    {
        return new ArrayList<>(Arrays.asList(
                new Store(R.drawable.bep_ba_muoi, 21600000, 65200000, "Bếp Bà Muối - Ăn Vặt Online", "606/52 Đường 3 Tháng 2, P. 14, Quận 10, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.SHOP_ONLINE, ServiceType.FAMILY)), "Cả ngày - Giảm 15%", 10),
                new Store(R.drawable.ta_la, 0, 86400000, "Tá Lả - Ăn Vặt, Mì Xào, Cơm Chiên & Sinh Tố - Phan Văn Trị", "667/1 Phan Văn Trị, P. 7, Gò Vấp, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.STREET_FOOD, ServiceType.RESTAURANT)), "Sáng - Giảm 10%", 12),
                new Store(R.drawable.royaltea, 29820000, 80520000, "Royaltea Vietnam By Hongkong - Sơn Kỳ", "35 Sơn Kỳ, P. Sơn Kỳ, Tân Phú, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.STREET_FOOD, ServiceType.RESTAURANT, ServiceType.BUFFET, ServiceType.GROUP)), "Tối - Giảm 5%", 20),
                new Store(R.drawable.anh_thu_banh_mi, 21600000, 79200000, "Anh Thư - Bánh Mì & Bún Thịt Nướng", "115B Tôn Đản, P. 14, Quận 4, TP. HCM", new ArrayList<>(), "Trưa - Giảm 10%", 5),
                new Store(R.drawable.banh_trang_ut_hanh, 43200000, 82800000, "Bánh Tráng Út Hạnh", "Kios 11 Đường số 32, P. 10, Quận 6, TP. HCM", new ArrayList<>(), "Sáng - Giảm 20%", 10),
                new Store(R.drawable.com_tam, 0, 86400000, "Cơm Tấm Huyền - Đinh Tiên Hoàng", "Hẻm 95 Đinh Tiên Hoàng, P. 3, Bình Thạnh, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.RESTAURANT, ServiceType.GROUP)), "Cả ngày - Giảm 15%", 9),
                new Store(R.drawable.vit_quay, 21600000, 79200000, "Vĩnh Phong - Cửa Hàng Vịt Quay", "523 - 525 - 527 Phan Văn Trị, P. 7, Quận 5, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.RESTAURANT, ServiceType.SHOP_ONLINE)), "Cả ngày - Giảm 15%", 8),
                new Store(R.drawable.bm_huynh_hoa, 29820000, 80520000, "RBánh Mì Huynh Hoa - Bánh Mì Pate", "26 Lê Thị Riêng, P. Bến Thành, Quận 1, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.STREET_FOOD, ServiceType.RESTAURANT)), "Cả ngày - Giảm 15%", 2),
                new Store(R.drawable.katinat, 21600000, 79200000, "Katinat - Cộng Hoà", "20 Cộng Hoà, P. 4, Tân Bình, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.BIRDTH_DAY, ServiceType.GROUP)), "Cả ngày - Giảm 15%", 1),
                new Store(R.drawable.banh_trang_cham, 21600000, 79200000, "Bánh Tráng Chấm Cô Gánh - Chung Cư A4 Phan Xích Long", "Lô D001 Chung Cư A4 Phan xích Long, P. 7, Phú Nhuận, TP. HCM", new ArrayList<>(Arrays.asList(ServiceType.SHOP_ONLINE)), "Cả ngày - Giảm 15%", 3)));

    }
}
