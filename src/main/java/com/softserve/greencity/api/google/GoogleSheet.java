package com.softserve.greencity.api.google;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class GoogleSheet {
    private static Sheets sheetsService;
    private static final String APPLICATION_NAME = "OAuth client";
    private static final String SPREADSHEET_ID = "19U5Ocxx0P5I8opWEWJ6WNqlZMrHFpSbTxyFHSkfzYgU";
    private static List<List<Object>> values;

    private static Credential authorize() throws IOException, GeneralSecurityException {
        java.util.logging.Logger
                .getLogger("com.google.api.**")
                .setLevel(Level.OFF);
        java.util.logging.Logger
                .getLogger("com.google.api.client.util.store.FileDataStoreFactory")
                .setLevel(Level.OFF);
        java.util.logging.Logger.
                getLogger("com.google.api.client.util.store.FileDataStoreFactory setPermissionsToOwnerOnly")
                .setLevel(Level.OFF);

        InputStream in = GoogleSheet.class.getResourceAsStream("/sheetsApi.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");
        return credential;
    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        if (sheetsService == null) {
            System.out.println("new SheetsService");
            Credential credential = authorize();
            sheetsService = new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                    JacksonFactory.getDefaultInstance(), credential)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        }
        return sheetsService;

    }

    public static List<Object> getRow(int row) throws IOException, GeneralSecurityException {
        if (values == null) {
            sheetsService = getSheetsService();
            String range = "A1:B33";
            ValueRange response = sheetsService.spreadsheets().values()
                    .get(SPREADSHEET_ID, range)
                    .execute();
            values = response.getValues();
        }

        if (values == null || values.isEmpty()) {

            System.out.println("empty value");
        } else {
            return values.get(row);
        }
        return null;
    }
}
