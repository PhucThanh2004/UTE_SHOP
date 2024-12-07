package vn.iotstar.service;

import vn.iotstar.models.ShopModel;

public interface IShopService {
    void registerShop(ShopModel shop) throws Exception;

    ShopModel findByAccountId(int accountId) throws Exception;
}
