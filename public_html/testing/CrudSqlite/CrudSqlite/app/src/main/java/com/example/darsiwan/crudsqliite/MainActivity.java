package com.example.darsiwan.crudsqliite;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btnHit;
    ProgressDialog pd;

    String datajson;

    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btn=(Button)findViewById(R.id.button2);
        btnHit = (Button) findViewById(R.id.buttonjson);

//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                Intent inte = new Intent(MainActivity.this, BuatBiodata.class);
//                startActivity(inte);
//            }
//        });

        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new JsonTask().execute("http://arghakarya.co.id/inv/");
                getJSON("http://arghakarya.co.id/invz/");
            }
        });





        Button btn3=(Button)findViewById(R.id.buttonjson2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });



        Button btnx=(Button)findViewById(R.id.button);

        btnx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//                //Intent inte = new Intent(MainActivity.this, BuatBiodata.class);
//                //startActivity(inte);
//                Toast.makeText(getApplicationContext(), "TOMBOLLLLLL", Toast.LENGTH_LONG).show();
//                SQLiteDatabase db = dbcenter.getWritableDatabase();
//                db.execSQL("insert into datainv(TAG_NUMBER, NIK, NAMA, ID_LOKASI, LOKASI) values('" +
//                        "1111" + "','" +
//                        "1221212" + "','" +
//                        "AAAAAAAA" + "','" +
//                        "5666666" + "','" +
//                        "656565656" + "')");
//                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
//                RefreshList();
//                //finish();
                Intent inte = new Intent(MainActivity.this, barcode.class);
                startActivity(inte);


            }
        });


        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }



    public void uploadData(){
        Toast.makeText(this, "Upload Daataaaaaa", Toast.LENGTH_LONG).show();
    }

    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private void loadIntoListView(String json) throws JSONException {
       // Toast.makeText(getApplicationContext(), json, Toast.LENGTH_LONG).show();
        JSONArray jsonArray = new JSONArray(json);
        String[] heroes = new String[jsonArray.length()];
        SQLiteDatabase db = dbcenter.getWritableDatabase();
        db.execSQL("delete from datainv ");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            heroes[i] = obj.getString("TAG_NUMBER");

           // SQLiteDatabase db = dbcenter.getWritableDatabase();
            db.execSQL("insert into datainv(SEQNO, TAG_NUMBER, NIK, NAMA, ID_LOKASI, LOKASI, ITEM_CODE, ID_SUBLOKASI, SUBLOKASI,P_PROCESSOR, P_MEMORY, P_HARDISK,P_OS, P_DISPLAY,P_DISPLAY_TIPE,P_KM,ID_POSISI,POSISI,P_DESC,P_IPADDR,P_WIFIADDR,P_GAD1ADDR,P_GAD2ADDR) values('" +
                    obj.getString("SEQNO") + "','" +
                    obj.getString("TAG_NUMBER") + "','" +
                    obj.getString("NIK") + "','" +
                    obj.getString("NAMA") + "','" +
                    obj.getString("ID_LOKASI") + "','" +
                    obj.getString("LOKASI") + "','" +
                    obj.getString("ITEM_CODE") + "','" +
                    obj.getString("ID_SUBLOKASI") + "','" +
                    obj.getString("SUBLOKASI") + "','" +
                    obj.getString("P_PROCESSOR") + "','" +
                    obj.getString("P_MEMORY") + "','" +
                    obj.getString("P_HARDISK") + "','" +
                    obj.getString("P_OS") + "','" +
                    obj.getString("P_DISPLAY") + "','" +
                    obj.getString("P_DISPLAY_TIPE") + "','" +
                    obj.getString("P_KM") + "','" +
                    obj.getString("ID_POSISI") + "','" +
                    obj.getString("POSISI") + "','" +
                    obj.getString("P_DESC") + "','" +
                    obj.getString("P_IPADDR") + "','" +
                    obj.getString("P_WIFIADDR") + "','" +
                    obj.getString("P_GAD1ADDR") + "','" +
                    obj.getString("P_GAD2ADDR") + "')");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            RefreshList();

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, heroes);
        Toast.makeText(getApplicationContext(), "Import Data Berhasil  ", Toast.LENGTH_LONG).show();
        //listView.setAdapter(arrayAdapter);
    }


//    private class JsonTask extends AsyncTask<String, String, String> {
//
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            pd = new ProgressDialog(MainActivity.this);
//            pd.setMessage("Please wait");
//            pd.setCancelable(false);
//            pd.show();
//        }
//
//        protected String doInBackground(String... params) {
//
//
//            HttpURLConnection connection = null;
//            BufferedReader reader = null;
//
//            try {
//                URL url = new URL(params[0]);
//                connection = (HttpURLConnection) url.openConnection();
//                connection.connect();
//
//
//                InputStream stream = connection.getInputStream();
//
//                reader = new BufferedReader(new InputStreamReader(stream));
//
//                StringBuffer buffer = new StringBuffer();
//                String line = "";
//
//                while ((line = reader.readLine()) != null) {
//                    buffer.append(line + "\n");
//                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)
//
//                }
//
//                return buffer.toString();
//
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (connection != null) {
//                    connection.disconnect();
//                }
//                try {
//                    if (reader != null) {
//                        reader.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            if (pd.isShowing()){
//                pd.dismiss();
//            }
//
//            Toast.makeText(getApplicationContext(), "HASIL "+result, Toast.LENGTH_LONG).show();
//            try {
//
//                JSONObject jsonObj = new JSONObject(result);
//                JSONArray jArray1 = jsonObj.getJSONArray("premium");
//                String tagnmbr = jsonObj.getString("TAG_NUMBER");
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            //txtJson.setText(result);
//        }
//    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datainv",null);
        daftar = new String[cursor.getCount()];

        Toast.makeText(getApplicationContext(), "vlaue is "+cursor.getCount(), Toast.LENGTH_LONG).show();
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.listView1);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2]; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Lihat Data Inventori", "Update Data Inventori", "Hapus Data Inventori"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), LihatBiodata.class);
                                i.putExtra("tn", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), UpdateBiodata.class);
                                in.putExtra("tn", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("delete from datainv where TAG_NUMBER = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }



//    private String TAG = MainActivity.class.getSimpleName();
//
//    private ProgressDialog pDialog;
//    private ListView lv;
//
//    // URL to get contacts JSON
//    private static String url = "http://arghakarya.co.id/orc/";
//
//    ArrayList<HashMap<String, String>> contactList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        contactList = new ArrayList<>();
//
//        lv = (ListView) findViewById(R.id.list);
//
//        new GetContacts().execute();
//    }
//
//    /**
//     * Async task class to get json by making HTTP call
//     */
//    private class GetContacts extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Showing progress dialog
//            pDialog = new ProgressDialog(MainActivity.this);
//            pDialog.setMessage("Please wait...");
//            pDialog.setCancelable(false);
//            pDialog.show();
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... arg0) {
//            HttpHandler sh = new HttpHandler();
//
//            // Making a request to url and getting response
//            String jsonStr = sh.makeServiceCall(url);
//
//            Log.e(TAG, "Response from url: " + jsonStr);
//
//            if (jsonStr != null) {
//                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);
//
//                    // Getting JSON Array node
//                    JSONArray contacts = jsonObj.getJSONArray("IDUSR");
//
//                    // looping through All Contacts
//                    for (int i = 0; i < contacts.length(); i++) {
//                        JSONObject c = contacts.getJSONObject(i);
//
//                        String id = c.getString("IDUSR");
//                        String name = c.getString("USRNAME");
//                        String email = c.getString("USRNIK");
//                        String address = c.getString("GRADE");
//                        String gender = c.getString("USRPASS");
//
//                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("DEPT");
//                        String mobile = phone.getString("EMAIL");
//                        String home = phone.getString("EMAIL");
//                        String office = phone.getString("EMAIL");
//
//                        // tmp hash map for single contact
//                        HashMap<String, String> contact = new HashMap<>();
//
//                        // adding each child node to HashMap key => value
//                        contact.put("id", id);
//                        contact.put("name", name);
//                        contact.put("email", email);
//                        contact.put("mobile", mobile);
//
//                        // adding contact to contact list
//                        contactList.add(contact);
//                    }
//                } catch (final JSONException e) {
//                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getApplicationContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    });
//
//                }
//            } else {
//                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });
//
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            // Dismiss the progress dialog
//            if (pDialog.isShowing())
//                pDialog.dismiss();
//            /**
//             * Updating parsed JSON data into ListView
//             * */
//            ListAdapter adapter = new SimpleAdapter(
//                    MainActivity.this, contactList,
//                    R.layout.list_item, new String[]{"name", "email",
//                    "mobile"}, new int[]{R.id.name,
//                    R.id.email, R.id.mobile});
//
//            lv.setAdapter(adapter);
//        }
//
//    }

}