package org.example.cep_project.meuapp.service;

import com.google.gson.Gson;
import org.example.cep_project.meuapp.model.Endereco;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCepService {

    public Endereco buscarEnderecoPorCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

            try {
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Converter JSON para Endereco usando Gson
                    Gson gson = new Gson();
                    return gson.fromJson(response.toString(), Endereco.class);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    }
}
