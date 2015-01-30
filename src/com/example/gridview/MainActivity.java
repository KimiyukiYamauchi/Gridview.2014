package com.example.gridview;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity 
	implements GridView.OnItemClickListener
{
	
	private ArrayList<Bitmap> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		list = new ArrayList<Bitmap>();
		Resources res = getResources();
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_add));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_delete));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_call));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_camera));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_day));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_directions));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_edit));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_help));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_info_details));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_preferences));
		list.add(BitmapFactory.decodeResource(res, android.R.drawable.ic_menu_search));
		
		// グリッドビューの生成
		GridView gv = new GridView(this);
		gv.setBackgroundColor(Color.WHITE);
		gv.setNumColumns(4);
		gv.setAdapter(new MyAdapter());
		gv.setOnItemClickListener(this);
		setContentView(gv);

//		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// MyAdapterクラスの定義
	private class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
                ImageView iv = new ImageView(MainActivity.this);
                iv.setLayoutParams(new GridView.LayoutParams(72,92));
                iv.setPadding(0, 0, 0, 20);
                iv.setImageBitmap(list.get(position));
                convertView = iv;
			}
			return convertView;
		}
		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		AlertDialog.Builder ad = new AlertDialog.Builder(this);
		ad.setMessage("id:" + id);
		ad.setPositiveButton("OK", null);
		ad.show();
		
	}
}
