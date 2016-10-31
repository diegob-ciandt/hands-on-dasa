package br.com.treinamento.dojo.service;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Date;

/**
 * Created by diegob on 27/10/2016.
 */
@Service
public class MarvelRequestSender {

    private static final String publicKey = "04fb7243e813d1eda5d61acbe3433389";
    private static final String privateKey = "5d6c87a9d46eaee43bccec38268dd2bea402164c";

    public String sendRequest(String url) {
        try {
            long ts = new Date().getTime();
            String hash = ts + privateKey + publicKey;
            String md5Hash = DigestUtils.md5DigestAsHex(hash.getBytes()).toString();

            ClientConfig config = new ClientConfig();
            Client client = ClientBuilder.newClient(config);

            String response = client.target(url).queryParam("ts", ts)
                    .queryParam("apikey", publicKey).queryParam("hash", md5Hash)
                    .request("application/json").get(String.class);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
