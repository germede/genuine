package org.fluentness.networking;

import com.sun.net.httpserver.HttpsParameters;
import org.fluentness.common.Configuration;
import org.fluentness.logging.Logger;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

public class HttpSecure extends com.sun.net.httpserver.HttpsConfigurator {

    HttpSecure() {
        super(getSslContext(Configuration.getString(Configuration.APP_KEYSTORE)));
    }

    @Override
    public void configure(HttpsParameters params) {
        try {
            // initialise the SSL context
            SSLContext c = SSLContext.getDefault();
            SSLEngine engine = c.createSSLEngine();
            params.setNeedClientAuth(false);
            params.setCipherSuites(engine.getEnabledCipherSuites());
            params.setProtocols(engine.getEnabledProtocols());

            // get the default parameters
            SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
            params.setSSLParameters(defaultSSLParameters);
        } catch (Exception e) {
            Logger.severe(HttpServer.class, e);
        }
    }

    private static SSLContext getSslContext(String keystore) {
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");

            // initialise the keystore
            char[] password = "simulator".toCharArray();
            KeyStore ks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream(keystore), password);

            // setup the key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, password);

            // setup the trust manager factory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks);

            // setup the HTTPS context and parameters
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        } catch (KeyStoreException |
                CertificateException |
                UnrecoverableKeyException |
                IOException |
                NoSuchAlgorithmException |
                KeyManagementException e) {
            Logger.severe(HttpServer.class, e);
        }
        assert sslContext != null;
        return sslContext;
    }
}
