package com.ninise.computoolsglobaltest.mvp.model.network;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import rx.Observable;

public class GetResponse {

    public static Observable<String> createResponse(String link) {
        return Observable.create(subscriber -> {
            URL url;
            HttpURLConnection urlConnection = null;
            StringBuilder builder = new StringBuilder();

            try {
                url = new URL(link);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream in = urlConnection.getInputStream();

                InputStreamReader isw = new InputStreamReader(in);

                int data = isw.read();

                while (data != -1) {
                    char current = (char) data;
                    builder.append(current);
                    data = isw.read();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                subscriber.onNext(builder.toString());
                subscriber.onCompleted();
            }
        });
    }
}
