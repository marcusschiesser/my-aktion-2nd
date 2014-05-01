package de.dpunkt.myaktion.monitor.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class DisableHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String s, SSLSession sslSession) {
        return true;
    }
}
