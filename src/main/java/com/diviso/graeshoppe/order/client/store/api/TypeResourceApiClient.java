package com.diviso.graeshoppe.order.client.store.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.diviso.graeshoppe.order.client.store.StoreClientConfiguration;

@FeignClient(name="${store.name:store}", url="${store.url:dev.ci1.divisosofttech.com:8071/}", configuration = StoreClientConfiguration.class)
public interface TypeResourceApiClient extends TypeResourceApi {
}