package com.example.uchumi;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	Context mContext;
	ArrayList<Product> data;// modify here

	public CustomAdapter(Context context, ArrayList<Product> data) // modify
																	// here
	{
		this.mContext = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();// # of items in your arraylist
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);// get the actual movie
	}

	@Override
	public long getItemId(int id) {
		return id;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(R.layout.list_item_layout, parent,
					false);// modify here
			viewHolder = new ViewHolder();
			viewHolder.textViewProduct = (TextView) convertView
					.findViewById(R.id.textViewProduct);// modify here
			viewHolder.textViewQuantity = (TextView) convertView
					.findViewById(R.id.textViewQuantity);// modify here
			viewHolder.textViewPrice = (TextView) convertView
					.findViewById(R.id.textViewPrice);// modify here
			viewHolder.textViewId = (TextView) convertView
					.findViewById(R.id.textViewId);// modify here
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Product p = data.get(position);// modify here
		viewHolder.textViewProduct.setText("Product");// modify here
		viewHolder.textViewQuantity.setText("Price");// modify here
		viewHolder.textViewPrice.setText("Quantity");// modify here
		viewHolder.textViewId.setText("id");// modify here
		return convertView;
	}

	static class ViewHolder {
		TextView textViewProduct;// modify here
		TextView textViewQuantity;// modify here
		TextView textViewPrice;// modify here
		TextView textViewId;// modify here
	}

}