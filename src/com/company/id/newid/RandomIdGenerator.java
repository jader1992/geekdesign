package com.company.id.newid;

import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.IllegalArgumentException;

public class RandomIdGenerator implements LogTraceIdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String genetate() throws IdGenerationFailureException{
        String substrOfHostName = null;
        try{
            substrOfHostName = getLastfieldOfHostName();
        } catch (UnknownHostException e) {
            throw new IdGenerationFailureException("host name is empty");
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomString = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", substrOfHostName, currentTimeMillis, randomString);
        return id;
    }

    private String getLastfieldOfHostName() throws UnknownHostException{
        String substrOfHostName = null;
        String hostname = InetAddress.getLocalHost().getHostName();
        if (hostname == null || hostname.isEmpty()) {
            throw new UnknownHostException("...");
        }
        substrOfHostName = getLastSubstrSplittedByDot(hostname);
        return substrOfHostName;
    }

    @VisibleForTesting
    public String getLastSubstrSplittedByDot(String hostname) {
        if (hostname == null || hostname.isEmpty()) {
            throw IllegalArgumentException("the param is null");
        }
        String[] tokens = hostname.split("\\.");
        String substrOfHostName = tokens[tokens.length -1];
        return substrOfHostName;
    }

    @VisibleForTesting
    public String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalAccessException("...");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit= randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase= randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase= randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit|| isUppercase || isLowercase) {
                randomChars[count] = (char) (randomAscii);
                ++count;
            }
        }
        return new String(randomChars);
    }

}

