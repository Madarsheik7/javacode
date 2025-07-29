package com.tpms.global.utility;

import java.util.UUID;

public class CorrelationIdUtil {
    private static final ThreadLocal<String> correlationId = new ThreadLocal<>();

    public static String generateCorrelationId(String existingCorrelationId, String laneTxId) {
        final String DEFAULT_LANE_TX_ID = "0000000";

        if (existingCorrelationId != null && existingCorrelationId.matches("(?i)[0-9]+-([a-f0-9]{32})")) {
            return existingCorrelationId;
        } else {
            String uuidPart = UUID.randomUUID().toString().replace("-", "");
            laneTxId = laneTxId != null && !laneTxId.isEmpty() ? laneTxId : DEFAULT_LANE_TX_ID;
            return (laneTxId + "-" + uuidPart).toUpperCase();
        }

    }



    public static void setCorrelationId(String id) {
        correlationId.set(id);
    }

    public static String getCorrelationId() {
        return correlationId.get();
    }

    public static void clear() {
        correlationId.remove();
    }
}