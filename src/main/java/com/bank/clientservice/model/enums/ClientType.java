package com.bank.clientservice.model.enums;

import com.bank.clientservice.exception.BadRequestException;

import java.util.Map;

public enum ClientType {
    PERSONAL,
    BUSINESS,
    PERSONAL_VIP,
    BUSINESS_PYME;

    public static ClientType fromId(int id) {
        if (id < 1 || id > ClientType.values().length) {
            throw new IllegalArgumentException("ID fuera de rango: " + id);
        }
        return ClientType.values()[id - 1];
    }

    public static ClientType fromName(String name) {
        try {
            Map<String, ClientType> map = Map.of(
                    "personal", PERSONAL,
                    "business", BUSINESS,
                    "personal-vip", PERSONAL_VIP,
                    "business-pyme", BUSINESS_PYME
            );
            return map.get(name);
        } catch (Exception e) {
            throw new BadRequestException("Nombre de tipo de cliente no reconocido: " + name);
        }
    }
}
