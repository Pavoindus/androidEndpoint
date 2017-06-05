package com.example.i323802.gcpendpointtest.dummy;

import com.example.i323802.gcpendpointtest.model.Employee;
import com.example.i323802.gcpendpointtest.model.EmployeeList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URL;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        ArrayList<EmployeeList> empList = getArrayListFromURL("https://endpoints-169618.appspot.com/gcp/employees");
        for(EmployeeList el : empList) {
            addItem(new DummyItem(el));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Employee: \n");
        builder.append(getEmployeeInfoFromURL("https://endpoints-169618.appspot.com/gcp/employee/" + position));
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        public DummyItem(EmployeeList el) {
            this.id = el.getId().toString();
            this.content = el.getName();
            this.details = makeDetails(el.getId().intValue());
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static ArrayList<EmployeeList> getArrayListFromURL(String urlString) {

        ArrayList<EmployeeList> arrayList = new ArrayList<>();
        try {
            HttpURLConnection urlConnection = null;

            URL url = new URL(urlString);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);

            urlConnection.setDoOutput(true);

            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            char[] buffer = new char[1024];

            String jsonString = new String();

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            jsonString = sb.toString();

            System.out.println("JSON: " + jsonString);

            JSONArray array = new JSONArray(jsonString);
            for (int i = 0; i < array.length(); i++) {
                JSONObject elem = (JSONObject) array.get(i);
                EmployeeList el = new EmployeeList();
                el.setId(elem.getLong("empId"));
                el.setName(elem.getString("name"));
                arrayList.add(el);
                System.out.println(el);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static Employee getEmployeeInfoFromURL(String urlString) {

        ArrayList<EmployeeList> arrayList = new ArrayList<>();
        Employee employee = null;
        try {
            HttpURLConnection urlConnection = null;

            URL url = new URL(urlString);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);

            urlConnection.setDoOutput(true);

            urlConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            char[] buffer = new char[1024];

            String jsonString = new String();

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();

            jsonString = sb.toString();

            System.out.println("JSON: " + jsonString);

            JSONObject elem = new JSONObject(jsonString);
            employee = new Employee(elem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
}
