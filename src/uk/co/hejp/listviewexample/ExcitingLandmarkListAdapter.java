package uk.co.hejp.listviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExcitingLandmarkListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Landmark> landmarks;

	public ExcitingLandmarkListAdapter(Context context, ArrayList<Landmark> landmarks) {
		this.context = context;
		this.landmarks = landmarks;
	}

	@Override
	public int getCount() {
		return landmarks.size();
	}

	@Override
	public Object getItem(int position) {
		return landmarks.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		/**
		 * position - refers to the position in the list view.
		 * 
		 * convertView - is a view that has been scrolled past and is now being recycled as the bottom (or top if
		 * scrolling up) item. Although you can simply create a new view each time it is much more efficient to recycle
		 * this view, by for example calling setText(...) if the view is a TextView.
		 * 
		 * parent - refers to the list view in which this view will be placed.
		 */

		if (convertView == null) {

			/*
			 * rather than just using a text view we will inflate the layout specified in
			 * res/layout/list_item_landmark.xml and use that
			 */

			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

			convertView = inflater.inflate(R.layout.list_item_landmark, null);

		}

		/* get the views and set them to display the correct data */

		((TextView) convertView.findViewById(R.id.listItemName)).setText(landmarks.get(position).getName());
		((ImageView) convertView.findViewById(R.id.listItemImage)).setImageResource(landmarks.get(position).getDrawableId());
		((TextView) convertView.findViewById(R.id.listItemLocation)).setText(landmarks.get(position).getLocation());

		return convertView;
	}

}
