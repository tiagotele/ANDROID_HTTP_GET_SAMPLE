package enjoy.tiago.com.http_client_sample;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;


/**
 * Created by tiago_000 on 05/07/2015.
 */
public class OnButtonClickHttpGetAssyncTask extends AsyncTask<String, Void, Void> {

    private static final String TAG = "MainActivity";
    private static final String URL = "http://192.168.25.101:8080/contatos/contatos/adiciona?contato.nome=tiago&contato.email=tiago%40gmail.com&contato.telefone=333333";

    @Override
    protected Void doInBackground(String... params) {

        try {
            BufferedReader in = null;
            String data = null;
            DefaultHttpClient httpclient = new DefaultHttpClient();

            HttpGet request = new HttpGet();
            URI website = new URI(URL);
            request.setURI(website);
            HttpResponse response = httpclient.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            Log.e("log_tag", "DADOS ADICIONDOS!");
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }

        return null;
    }
}
