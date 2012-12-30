package uk.co.hejp.listviewexample;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/* Create the array list of landmarks to pass to the adapter */

		TypedArray landmarkNames = this.getResources().obtainTypedArray(R.array.landmark_names);
		TypedArray landmarkDrawableIds = this.getResources().obtainTypedArray(R.array.landmark_drawables);
		TypedArray landmarkLocations = this.getResources().obtainTypedArray(R.array.landmark_locations);

		ArrayList<Landmark> landmarks = new ArrayList<Landmark>();

		for (int i = 0; i < landmarkNames.length(); i++) {
			landmarks.add(new Landmark(landmarkNames.getString(i), landmarkDrawableIds.getResourceId(i, 0), landmarkLocations.getString(i)));
		}

		/* find the list view */
		ListView landmarkListView = (ListView) this.findViewById(R.id.landmarkListView);

		/* display a Toast containing the info of the landmark that was clicked */
		landmarkListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				/* get the relevant landmark from the adapter */
				Landmark landmark = (Landmark) parent.getAdapter().getItem(position);

				String toastText;

				/* I'm a little OCD */
				if (landmark.getDrawableId() == R.drawable.buckingham_palace) {
					toastText = landmark.getName() + " is in " + landmark.getLocation();
				} else {
					toastText = "The " + landmark.getName() + " is in " + landmark.getLocation();
				}

				/* create and show the toast */
				Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_SHORT).show();
			}
		});

		/* set the adapter of the list view. Choose either: */

		/* the simple */
		// landmarkListView.setAdapter(new LandmarkListAdapter(this, landmarks));

		/* or the exciting */
		landmarkListView.setAdapter(new ExcitingLandmarkListAdapter(this, landmarks));

	}
}
