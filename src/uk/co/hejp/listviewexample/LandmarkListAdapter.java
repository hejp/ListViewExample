package uk.co.hejp.listviewexample;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LandmarkListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<Landmark> landmarks;

	public LandmarkListAdapter(Context context, ArrayList<Landmark> landmarks) {
		this.context = context;
		this.landmarks = landmarks;
	}

	@Override
	public int getCount() {
		/* the number of items in the list view i.e. the number of landmarks */
		return landmarks.size();
	}

	@Override
	public Landmark getItem(int position) {
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
			/* when the list view first starts up convertView is null so we must create the view */
			convertView = new TextView(context);
			((TextView) convertView).setTextSize(25);
			((TextView) convertView).setPadding(10, 25, 10, 25);
		}

		/* here we simply set the text view to display the name of the landmark e.g 'Titanic Museum' */
		((TextView) convertView).setText(landmarks.get(position).getName());

		return convertView;
	}

}
