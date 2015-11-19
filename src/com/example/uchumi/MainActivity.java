package com.example.uchumi;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MainActivity extends Activity {

ListView list;
CustomAdapter adapter;
ArrayList<Product>dataArray;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list =(ListView)findViewById(R.id.listView1);
	dataArray= new ArrayList<Product>();
		adapter = new CustomAdapter(this, dataArray);
		list.setAdapter(adapter);
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
public void buy (View v) {
	String url="http://10.0.2.2/2npull/fetch.php";
	AsyncHttpClient client = new AsyncHttpClient();
	client.get(url, new AsyncHttpResponseHandler() {
		
		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] response) {
			String data = new String(response);
			Log.d("DATA",data);
			try {
				JSONArray array = new JSONArray(data);
				for(int y = 0 ; y<array.length();y++)
				{
					JSONObject  obj= array.getJSONObject(y);
					String id =obj.getString("id");
					String name =obj.getString("name");
					String price =obj.getString("price");
					String quantity = obj.getString("quantity");
					Product pro=new Product(id, name, quantity, price);
					dataArray.add(pro);
					
					Log.d("DATA", id + ":" + name+ ":" + price+ ":"
							+ quantity);
				}
				adapter.notifyDataSetChanged();
				
			} catch (JSONException e) {
			Log.e("DATA","Error with JSON");
			e.printStackTrace();
			
			}
			
		}
		
		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			Log.e("DATA","Failed to fetch");
		}
	});
	
}

}
