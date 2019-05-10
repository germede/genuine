package org.fluentness.networking;

import com.sun.net.httpserver.HttpsParameters;
import org.fluentness.Fluentness;
import org.fluentness.logging.Logger;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

final class HttpSecure extends com.sun.net.httpserver.HttpsConfigurator {

    HttpSecure() {
        super(getSslContext(Fluentness.Configuration.getString(Fluentness.Configuration.APP_KEYSTORE)));
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
            Logger.error(HttpServer.class, e);
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

            return sslContext;
        } catch (KeyStoreException |
                CertificateException |
                UnrecoverableKeyException |
                IOException |
                NoSuchAlgorithmException |
                KeyManagementException e) {
            Logger.error(HttpServer.class, e);
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            Logger.error(HttpServer.class, e);
        }
        return null;
    }
}
